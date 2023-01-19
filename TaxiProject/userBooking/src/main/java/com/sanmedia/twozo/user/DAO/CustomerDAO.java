package com.sanmedia.twozo.user.DAO;

import com.sanmedia.twozo.dbConnection.DBConnection;
import com.sanmedia.twozo.exceptions.InsertionFailedException;
import com.sanmedia.twozo.exceptions.RemovalFailedException;
import com.sanmedia.twozo.exceptions.SelectionFailedException;
import com.sanmedia.twozo.exceptions.UpdateFailedException;
import com.sanmedia.twozo.exceptions.CustomException;
import com.sanmedia.twozo.user.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Prompts the Customer services related queries and might project Exceptions to administer unexpected errors
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomerDAO {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * <p>
     *     Inserts {@link Customer} details in the respective table of our Database.
     * </p>
     *
     * @param userId {@link  Long}, critical in deciding which Customer's registering.
     * @return that com.TaxiProject.customer's ID is being returned.
     */
    public long insert(final Long userId) {
        final String customerInsertQuery = "INSERT into com.TaxiProject.customer(user_id) values(?)";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerInsertQuery)) {
            preparedStatement.setLong(1, userId);

            if (preparedStatement.executeUpdate() > 0) {
                final String customerIdQuery = "SELECT id FROM com.TaxiProject.customer ORDER BY id DESC LIMIT 1";

                try (Statement statement = connection.createStatement()) {
                    final ResultSet resultSet = statement.executeQuery(customerIdQuery);

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
     * <p>
     *     Retrieves a Customer's details from the {@link Customer} table based on the ID provided in the Database.
     * </p>
     *
     * @return that Customer's details.
     */
    public Customer get(final Long id) {
        final String customerSelectQuery = "SELECT name, mobile_number, email from service_user LEFT JOIN com.TaxiProject.customer " +
                "ON service_user.id = user_id WHERE com.TaxiProject.customer.id = ?";
        final Customer customer = new Customer();
        customer.setId(id);

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerSelectQuery)) {
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    customer.setMobileNumber(resultSet.getString("mobile_number"));
                    customer.setName(resultSet.getString("name"));
                    customer.setEmailId(resultSet.getString("email"));
                }
            return customer;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new SelectionFailedException("Failed to retrieve com.TaxiProject.customer's info!");
        }
    }

    /**
     * <p>
     *     Removes a Customer's details from the Customer table based on the ID provided in the Database.
     * </p>
     *
     * @return whether that {@link Customer} has been removed.
     */
    public boolean remove(final Long id) {
        final String customerRemoveQuery = "DELETE from com.TaxiProject.customer where ID = ? ";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerRemoveQuery)) {
            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (Exception exception) {
            throw new RemovalFailedException("Failed to remove com.TaxiProject.customer's info!");
        }
    }

    /**
     * <p>
     *     Updates a Customer's details from the Customer table based on the ID provided in the Database.
     * </p>
     *
     * @param customer {@link Customer}, holds updated information from Customer.
     * @return whether that {@link Customer} has been updated.
     */
    public boolean update(final Customer customer) {
        final String customerUpdateQuery =
                "UPDATE com.TaxiProject.customer set name = ?, set password = ?, mobile_number = ?, emailId = ? where ID ="
                        + customer.getId();

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerUpdateQuery)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getMobileNumber());
            preparedStatement.setString(4, customer.getEmailId());

            return preparedStatement.execute();
        } catch (Exception exception) {
            throw new UpdateFailedException("Failed to update com.TaxiProject.customer's info!");
        }
    }

    /**
     * <p>
     *     Retrieves all Customer details from the Customer table in the Database.
     * </p>
     *
     * @return a {@link List} containing Customer details
     */
    public Collection<Customer> getAll() {
        final String customerSelectQuery = "SELECT com.TaxiProject.customer.id, name, mobile_number, email from service_user LEFT JOIN com.TaxiProject.customer " +
                "ON service_user.id = user_id";
        final Collection<Customer> customersList = new ArrayList<>();

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerSelectQuery)) {
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Customer customer = new Customer();

                customer.setId(resultSet.getLong(1));
                customer.setName(resultSet.getString("name"));
                customer.setMobileNumber(resultSet.getString("mobile_number"));
                customer.setEmailId(resultSet.getString("email"));
                customersList.add(customer);
            }
            return customersList;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Unable to retrieve info!");
        }
    }
}