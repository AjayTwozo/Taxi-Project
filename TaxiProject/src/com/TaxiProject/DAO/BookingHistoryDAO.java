package com.TaxiProject.DAO;

import com.TaxiProject.exception.CustomException;
import com.TaxiProject.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Prompts the Booking history related queries and might project Exceptions to administer unexpected errors
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingHistoryDAO {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * Retrieves Customer's booking history from the respective table of our Database
     *
     * @return List containing Customer's booking history details
     */
    public List<Booking> getCustomerHistory(final Long customerId) {
        final String selectBookingQuery = "SELECT booking.id, driver_id, pickup_location_id, drop_location_id, " +
                "distance, total_fare FROM booking LEFT JOIN fare ON fare_id = fare.id LEFT JOIN location ON " +
                "location.id = pickup_location_id AND location.id = drop_location_id  WHERE customer_id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectBookingQuery)) {
            preparedStatement.setLong(1, customerId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            final List<Booking> bookingList = new ArrayList<>();

            while (resultSet.next()) {
                final Booking booking = new Booking();
                final Driver driver = new Driver();
                final Location pickUpLocation = new Location();
                final Location dropLocation = new Location();
                final Fare fare = new Fare();

                booking.setId(resultSet.getLong(1));
                driver.setId(resultSet.getLong("driver_id"));
                pickUpLocation.setId(resultSet.getLong("pickup_location_id"));
                dropLocation.setId(resultSet.getLong("drop_location_id"));
                fare.setDistance(resultSet.getDouble("distance"));
                booking.setTotalFare(resultSet.getDouble("total_fare"));
                fare.setPickupPoint(pickUpLocation);
                fare.setDropPoint(dropLocation);
                booking.setFare(fare);
                booking.setDriver(driver);
                bookingList.add(booking);
            }
            return bookingList;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Failed to retrieve details!");
        }
    }

    /**
     * Retrieves Driver's booking history from the respective table of our Database
     *
     * @return List containing Customer's booking history details
     */
    public List<Booking> getDriverHistory(final Long driverId) {
        final String selectBookingQuery = "SELECT booking.id, customer_id, pickup_location_id, drop_location_id, " +
                "distance, total_fare FROM booking LEFT JOIN fare ON fare_id = fare.id LEFT JOIN location ON " +
                "location.id = pickup_location_id AND location.id = drop_location_id  WHERE customer_id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectBookingQuery)) {
            preparedStatement.setLong(1, driverId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            final List<Booking> bookingList = new ArrayList<>();

            while (resultSet.next()) {
                final Booking booking = new Booking();
                final Customer customer = new Customer();
                final Location pickUpLocation = new Location();
                final Location dropLocation = new Location();
                final Fare fare = new Fare();

                booking.setId(resultSet.getLong(1));
                customer.setId(resultSet.getLong("customer_id"));
                pickUpLocation.setId(resultSet.getLong("pickup_location_id"));
                dropLocation.setId(resultSet.getLong("drop_location_id"));
                fare.setDistance(resultSet.getDouble("distance"));
                booking.setTotalFare(resultSet.getDouble("total_fare"));
                fare.setPickupPoint(pickUpLocation);
                fare.setDropPoint(dropLocation);
                fare.setCustomer(customer);
                booking.setFare(fare);
                bookingList.add(booking);
            }
            return bookingList;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Failed to retrieve details!");
        }
    }
}