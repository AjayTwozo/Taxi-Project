package com.TaxiProject.DAO;

import com.TaxiProject.exception.CustomException;
import com.TaxiProject.exception.InsertionFailedException;
import com.TaxiProject.model.Booking;
import com.TaxiProject.model.Driver;
import com.TaxiProject.model.PaymentOption;
import com.TaxiProject.model.Transaction;
import com.TaxiProject.model.Customer;
import com.TaxiProject.model.Fare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Prompts the Transaction services related queries and might project Exceptions to administer unexpected errors
 *
 * @author Ajay
 * @version 1.0
 */
public class TransactionDAO {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * Inserts Transaction details in the respective table of our Database
     *
     * @param transaction Transaction, object being unwrapped
     * @return driver's ID being returned
     */
    public long insertTransaction(final Transaction transaction) {
        final String insertQuery = "INSERT INTO transaction(booking_id, payment_options_id, payment_acknowledgement, " +
                "transaction_id) values(?, ?, ?, ?)";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setLong(1, transaction.getBooking().getId());
            preparedStatement.setLong(2, transaction.getPaymentOption().getId());
            preparedStatement.setBoolean(3, transaction.isPaymentAcknowledgement());
            preparedStatement.setLong(4, transaction.getTransactionId());

            if (preparedStatement.executeUpdate() > 0) {
                final String selectIdQuery = "SELECT id FROM driver ORDER BY id DESC LIMIT 1";

                try (Statement statement = connection.createStatement()) {
                    final ResultSet resultSet = statement.executeQuery(selectIdQuery);

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
     * Retrieves available Payment options from the respective table of our Database
     *
     * @return List containing available Payment options
     */
    public List<PaymentOption> getOptions() {
        final List<PaymentOption> paymentOptionList = new ArrayList<>();
        final String selectServiceQuery = "SELECT * from payment_option";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectServiceQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final PaymentOption paymentOption = new PaymentOption();

                paymentOption.setId(resultSet.getLong(1));
                paymentOption.setMode(resultSet.getString(2));
                paymentOptionList.add(paymentOption);
            }
            return paymentOptionList;
        } catch (Exception exception) {
            throw new CustomException("Failed to retrieve info");
        }
    }

    /**
     * Retrieves Customer's transaction history from the respective table of our Database
     *
     * @param customerId customerId, being unwrapped
     * @return List containing Customer's transaction history details
     */
    public List<Transaction> getCustomerHistory(final Long customerId) {
        final String selectTransactionQuery = "SELECT transactions_record.id, booking_id, driver_id, total_fare, " +
                "payment_option_id, transaction_id FROM transactions_record LEFT JOIN booking ON booking_id = " +
                "booking.id LEFT JOIN payment_option ON payment_option_id = payment_option.id LEFT JOIN fare ON " +
                "fare.id = fare_id WHERE customer_id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectTransactionQuery)) {
            preparedStatement.setLong(1, customerId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            final List<Transaction> transactionList = new ArrayList<>();

            while (resultSet.next()) {
                final Transaction transaction = new Transaction();
                final Booking booking = new Booking();
                final PaymentOption paymentOption = new PaymentOption();
                final Driver driver = new Driver();

                transaction.setTransactionId(resultSet.getLong(1));
                booking.setId(resultSet.getLong(2));
                driver.setId(resultSet.getLong(3));
                booking.setTotalFare(resultSet.getDouble(4));
                paymentOption.setId(resultSet.getLong(5));
                transaction.setTransactionId(resultSet.getLong(6));
                booking.setDriver(driver);
                transaction.setBooking(booking);
                transaction.setPaymentOption(paymentOption);
                transactionList.add(transaction);
            }
            return transactionList;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Failed to retrieve details!");
        }
    }

    /**
     * Retrieves Driver's transaction history from the respective table of our Database
     *
     * @param driverId driverId, being unwrapped
     * @return List containing Driver's transaction history details
     */
    public List<Transaction> getDriverHistory(final Long driverId) {
        final String selectTransactionQuery = "SELECT transactions_record.id, booking_id, customer_id, total_fare, " +
                "payment_option_id, transaction_id FROM transactions_record LEFT JOIN booking ON booking_id = " +
                "booking.id LEFT JOIN payment_option ON payment_option_id = payment_option.id LEFT JOIN fare ON " +
                "fare.id = fare_id WHERE driver_id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectTransactionQuery)) {
            preparedStatement.setLong(1, driverId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            final List<Transaction> transactionList = new ArrayList<>();

            while (resultSet.next()) {
                final Transaction transaction = new Transaction();
                final Booking booking = new Booking();
                final PaymentOption paymentOption = new PaymentOption();
                final Fare fare = new Fare();
                final Customer customer = new Customer();

                transaction.setTransactionId(resultSet.getLong(1));
                booking.setId(resultSet.getLong(2));
                customer.setId(resultSet.getLong(3));
                booking.setTotalFare(resultSet.getDouble(4));
                paymentOption.setId(resultSet.getLong(5));
                transaction.setTransactionId(resultSet.getLong(6));
                fare.setCustomer(customer);
                booking.setFare(fare);
                transaction.setBooking(booking);
                transaction.setPaymentOption(paymentOption);
                transactionList.add(transaction);
            }
            return transactionList;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Failed to retrieve details!");
        }
    }
}