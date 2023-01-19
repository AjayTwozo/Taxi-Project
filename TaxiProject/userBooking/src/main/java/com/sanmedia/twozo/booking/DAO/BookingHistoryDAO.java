package com.sanmedia.twozo.booking.DAO;

import com.sanmedia.twozo.booking.model.Booking;
import com.sanmedia.twozo.booking.model.Fare;
import com.sanmedia.twozo.booking.model.Location;
import com.sanmedia.twozo.dbConnection.DBConnection;
import com.sanmedia.twozo.user.model.Customer;
import com.sanmedia.twozo.user.model.Driver;
import com.sanmedia.twozo.exceptions.CustomException;

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
     * <p>
     *     Retrieves Customer's com.TaxiProject.booking history from the respective table of our Database.
     * </p>
     *
     * @return a {@link List}, containing Customer's com.TaxiProject.booking history details.
     */
    public List<Booking> getCustomerHistory(final Long customerId) {
        final String selectBookingQuery = "SELECT com.TaxiProject.booking.id, driver_id, pickup_location_id, drop_location_id, " +
                "distance, total_fare FROM com.TaxiProject.booking LEFT JOIN fare ON fare_id = fare.id LEFT JOIN location ON " +
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
     * <p>
     *     Retrieves Driver's com.TaxiProject.booking history from the respective table of our Database.
     * </p>
     *
     * @return a {@link List} containing Customer's com.TaxiProject.booking history details.
     */
    public List<Booking> getDriverHistory(final Long driverId) {
        final String selectBookingQuery = "SELECT com.TaxiProject.booking.id, customer_id, pickup_location_id, drop_location_id, " +
                "distance, total_fare FROM com.TaxiProject.booking LEFT JOIN fare ON fare_id = fare.id LEFT JOIN location ON " +
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