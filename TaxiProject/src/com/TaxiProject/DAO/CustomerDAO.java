package com.TaxiProject.DAO;

import com.TaxiProject.exception.CustomException;
import com.TaxiProject.exception.RemovalFailedException;
import com.TaxiProject.exception.SelectionFailedException;
import com.TaxiProject.exception.UpdateFailedException;
import com.TaxiProject.exception.InsertionFailedException;
import com.TaxiProject.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Prompts the Customer services related queries and might project Exceptions to administer unexpected errors
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomerDAO {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * Inserts Customer details in the respective table of our Database
     *
     * @param userId userId, being wrapped
     * @return customer's ID being returned
     */
    public long insert(final Long userId) {
        final String customerInsertQuery = "INSERT into customer(user_id) values(?)";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerInsertQuery)) {
            preparedStatement.setLong(1, userId);

            if (preparedStatement.executeUpdate() > 0) {
                final String customerIdQuery = "SELECT id FROM customer ORDER BY id DESC LIMIT 1";

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
     * Retrieves a Customer's details from the Customer table based on the ID provided in the Database
     *
     * @return Customer details
     */
    public Customer get(final Long id) {
        final String customerSelectQuery = "SELECT name, mobile_number, email from service_user LEFT JOIN customer " +
                "ON service_user.id = user_id WHERE customer.id = ?";
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
            throw new SelectionFailedException("Failed to retrieve customer's info!");
        }
    }

    /**
     * Removes a Customer's details from the Customer table based on the ID provided in the Database
     *
     * @return whether removed or not
     */
    public boolean remove(final Long id) {
        final String customerRemoveQuery = "DELETE from customer where ID = ? ";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerRemoveQuery)) {
            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (Exception exception) {
            throw new RemovalFailedException("Failed to remove customer's info!");
        }
    }

    /**
     * Updates a Customer's details from the Customer table based on the ID provided in the Database
     *
     * @param customer Customer, object being unwrapped
     * @return whether updated or not
     */
    public boolean update(final Customer customer) {
        final String customerUpdateQuery =
                "UPDATE customer set name = ?, set password = ?, mobile_number = ?, emailId = ? where ID ="
                        + customer.getId();

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(customerUpdateQuery)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getMobileNumber());
            preparedStatement.setString(4, customer.getEmailId());

            return preparedStatement.execute();
        } catch (Exception exception) {
            throw new UpdateFailedException("Failed to update customer's info!");
        }
    }

    /**
     * Retrieves all Customer details from the Customer table in the Database
     *
     * @return List containing Customer details
     */
    public Collection<Customer> getAll() {
        final String customerSelectQuery = "SELECT customer.id, name, mobile_number, email from service_user LEFT JOIN customer " +
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