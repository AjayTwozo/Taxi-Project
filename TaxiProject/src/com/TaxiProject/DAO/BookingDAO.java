package com.TaxiProject.DAO;

import com.TaxiProject.exception.CustomException;
import com.TaxiProject.exception.InvalidFareDetailsException;
import com.TaxiProject.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Prompts the Booking related queries and might project Exceptions to administer unexpected errors
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingDAO {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * Inserts Fare details in the respective table of our Database
     *
     * @param fare Fare, object being wrapped
     * @return fare Id being returned
     */
    public long insertFareDetails(final Fare fare) {
        final String fareInsertionQuery =
                "INSERT INTO fare (customer_id, pickup_location_id, drop_location_id, distance) VALUES(?, ?, ?, ?)";
        final String fareIdSelectionQuery = "SELECT id FROM fare ORDER BY id DESC LIMIT 1";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(fareInsertionQuery)) {
            preparedStatement.setLong(1, fare.getCustomer().getId());
            preparedStatement.setLong(2, fare.getPickupPoint().getId());
            preparedStatement.setLong(3, fare.getDropPoint().getId());
            preparedStatement.setDouble(4, fare.getDistance());
            preparedStatement.execute();

            try (Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(fareIdSelectionQuery);

                if (resultSet.next()) {
                    final long id = resultSet.getLong(1);

                    fare.setId(id);

                    return id;
                }
            }
            return 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new InvalidFareDetailsException("Failed to insert details!");
        }
    }

    /**
     * Retrieves Service details from the respective table of our Database
     *
     * @return List containing Service details
     */
    public List<Service> getServiceInfo() {
        final List<Service> serviceList = new ArrayList<>();
        final String selectServiceQuery = "SELECT * from service";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectServiceQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Service service = new Service();

                service.setId(resultSet.getLong(1));
                service.setName(resultSet.getString(2));
                service.setPricePerKM(resultSet.getDouble(3));
                serviceList.add(service);
            }
        } catch (Exception exception) {
            System.out.println("Unable to retrieve information!");
        }
        return serviceList;
    }

    /**
     * Assigns a driver from the respective table of our Database
     *
     * @param driver Driver, object being wrapped
     * @return fare Id being returned
     */
    public long assignDriver(final Driver driver) {
        final String selectDriverQuery = "SELECT driver.id, name, mobile_number, email, registration_number FROM driver " +
                "FULL JOIN service_user ON driver.id != service_user.id WHERE location_id = ? and service_id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectDriverQuery)) {
            preparedStatement.setLong(1, driver.getLocation().getId());
            preparedStatement.setLong(2, driver.getService().getId());
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final long id = resultSet.getLong(1);

                driver.setName(resultSet.getString("name"));
                driver.setMobileNumber(resultSet.getString("mobile_number"));
                driver.setEmailId(resultSet.getString("email"));
                driver.setRegistrationNumber(resultSet.getString("registration_number"));
                driver.setId(id);

                return id;
            }
            return 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Failed to register info!");
        }
    }

    /**
     * Retrieves Location details from the respective table of our Database
     *
     * @return List containing Location details
     */
    public List<Location> getZoneInfo() {
        final String selectLocationQuery = "Select * from Location";
        final List<Location> locationList = new ArrayList<>();

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectLocationQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Location location = new Location();

                location.setId(resultSet.getLong(1));
                location.setZone(resultSet.getString(2));
                locationList.add(location);
            }
            return locationList;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Inserts Booking details in the respective table of our Database
     *
     * @param booking Booking, object being wrapped
     * @return fare Id being returned
     */
    public long insertBooking(final Booking booking) {
        final String insertQuery = "INSERT into booking (fare_id, driver_id, total_fare) VALUES (?, ?, ?)";
        final String bookingIdSelectionQuery = "SELECT id FROM booking ORDER BY id DESC LIMIT 1";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setLong(1, booking.getFare().getId());
            preparedStatement.setLong(2, booking.getDriver().getId());
            preparedStatement.setDouble(3, booking.getTotalFare());

            if (preparedStatement.executeUpdate() > 0) {

                try (Statement statement = connection.createStatement()) {
                    final ResultSet resultSet = statement.executeQuery(bookingIdSelectionQuery);

                    if (resultSet.next()) {
                        return resultSet.getLong(1);
                    }
                }
            }
            return 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Failed to register info!");
        }
    }

    /**
     * Updates driver's location in the Driver table once the Journey ends
     *
     * @param locationId location ID, being unwrapped
     * @return driver's updated location ID
     */
    public long updateDriverId(final Long locationId) {
        final String updateLocationQuery = "update driver set location_id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateLocationQuery)) {
            preparedStatement.setLong(1, locationId);

            if (preparedStatement.executeUpdate() > 0) {
                return locationId;
            }
            return 0;
        } catch (Exception exception) {
            throw new CustomException("Failed to update Driver's ID");
        }
    }
}