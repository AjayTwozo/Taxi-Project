package com.TaxiProject.DAO;

import com.TaxiProject.exception.InsertionFailedException;
import com.TaxiProject.exception.RemovalFailedException;
import com.TaxiProject.exception.SelectionFailedException;
import com.TaxiProject.exception.UpdateFailedException;
import com.TaxiProject.exception.CustomException;
import com.TaxiProject.model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Prompts the Driver services related queries and might project Exceptions to administer unexpected errors
 *
 * @author Ajay
 * @version 1.0
 */
public class DriverDAO {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * Inserts Driver details in the respective table of our Database
     *
     * @param driver Driver, object being unwrapped
     * @return driver's ID being returned
     */
    public long insert(final Driver driver) {
        final String driverInsertQuery =
                "INSERT into driver(user_id, service_id, registration_number, location_id, availability) " +
                        "values(?, ?, ?, ?, ?)";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(driverInsertQuery)) {
            preparedStatement.setLong(1, driver.getId());
            preparedStatement.setLong(2, driver.getService().getId());
            preparedStatement.setString(3, driver.getRegistrationNumber());
            preparedStatement.setLong(4, driver.getLocation().getId());
            preparedStatement.setBoolean(5, driver.getAvailability());

            if (preparedStatement.executeUpdate() > 0) {
                final String driverIdQuery = "SELECT id FROM driver ORDER BY id DESC LIMIT 1";

                try (Statement statement = connection.createStatement()) {
                    final ResultSet resultSet = statement.executeQuery(driverIdQuery);

                    if (resultSet.next()) {
                        return resultSet.getLong(1);
                    }
                }
            }
            return 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new InsertionFailedException("Insertion failed!");
        }
    }

    /**
     * Retrieves a Driver's details from the Driver table based on the ID provided in the Database
     *
     * @return Driver details
     */
    public Driver get(final Long id) {
        final String driverSelectQuery = "SELECT name, mobile_number, email, registration_id, service_id from " +
                "service_user LEFT JOIN driver ON service_user.id = user_id WHERE driver.id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(driverSelectQuery)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            final ResultSet resultSet = preparedStatement.executeQuery();
            final Driver driver = new Driver();

            while (resultSet.next()) {
                driver.setName(resultSet.getString("name"));
                driver.setMobileNumber(resultSet.getString("mobile_number"));
                driver.setEmailId(resultSet.getString("emailId"));
                driver.setRegistrationNumber(resultSet.getString("registration_number"));
            }
            return driver;
        } catch (Exception exception) {
            throw new SelectionFailedException("Failed to retrieve driver's info!");
        }
    }

    /**
     * Removes a Driver 's details from the Driver table based on the ID provided in the Database
     *
     * @return whether removed or not
     */
    public boolean remove(final Long id) {
        final String driverRemoveQuery = "DELETE from driver where ID = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(driverRemoveQuery)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (Exception exception) {
            throw new RemovalFailedException("Failed to remove driver's info!");
        }
    }

    /**
     * Updates a Driver's details from the Driver table based on the ID provided in the Database
     *
     * @param driver Driver, object being unwrapped
     * @return whether updated or not
     */
    public boolean update(final Driver driver) {
        final String driverUpdateQuery =
                "UPDATE driver set name = ?, set password = ?, mobile_number = ?, emailId = ?, " +
                        "registration_number = ? where ID = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(driverUpdateQuery)) {
            preparedStatement.setLong(6, driver.getId());

            if (preparedStatement.executeUpdate() > 0) {
                preparedStatement.setString(1, driver.getName());
                preparedStatement.setString(2, driver.getPassword());
                preparedStatement.setString(3, driver.getMobileNumber());
                preparedStatement.setString(4, driver.getEmailId());
                preparedStatement.setString(5, driver.getRegistrationNumber());

                return preparedStatement.execute();
            } else {
                throw new UpdateFailedException("Failed to update driver's info!");
            }
        } catch (Exception exception) {
            throw new UpdateFailedException("Failed to update driver's info!");
        }
    }

    /**
     * Retrieves all Driver details from the Driver table in the Database
     *
     * @return List containing Driver details
     */
    public Collection<Driver> getAll() {
        final String driverSelectAllQuery = "SELECT driver.id, name, mobile_number, email, registration_id, service_id from " +
                "service_user LEFT JOIN driver ON service_user.id = user_id";
        final Collection<Driver> driversList = new ArrayList<>();

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(driverSelectAllQuery)) {
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Driver driver = new Driver();

                driver.setId(resultSet.getLong(1));
                driver.setName(resultSet.getString("name"));
                driver.setMobileNumber(resultSet.getString("mobile_number"));
                driver.setEmailId(resultSet.getString("emailId"));
                driver.setRegistrationNumber(resultSet.getString("registration_number"));
                driversList.add(driver);
            }
            return driversList;
        } catch (Exception exception) {
            throw new CustomException("Unable to retrieve info!");
        }
    }
}