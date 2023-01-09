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
     * <p>
     *     Inserts {@link Fare} in the respective table of our Database.
     * </p>
     *
     * @param fare {@link Fare} contains pick up, drop and location details that are unwrapped here.
     * @return that Fare's ID is being returned.
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
                    return resultSet.getLong(1);
                }
            }
            return 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new InvalidFareDetailsException("Failed to insert details!");
        }
    }

    /**
     * <p>
     *     Retrieves {@link Service} details from the respective table in our Database.
     * </p>
     *
     * @return a {@link List}, containing {@link Service} details.
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
     * Assigns a {@link Driver} from the respective table of our Database.
     *
     * @param serviceId {@link Long}, determines Customer's choice of Service.
     * @param locationId {@link Long}, determines Customer's choice of Location.
     * @return a Driver's ID being returned
     */
    public Driver getDriverAvailability(final Long serviceId, final Long locationId) {
        final String selectDriverQuery = "SELECT driver.id, name, mobile_number, email, registration_number FROM driver " +
                "FULL JOIN service_user ON driver.id != service_user.id WHERE location_id = ? and service_id = ?";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectDriverQuery)) {
            preparedStatement.setLong(1, locationId);
            preparedStatement.setLong(2, serviceId);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final long id = resultSet.getLong(1);
                final Driver driver = new Driver();

                driver.setName(resultSet.getString("name"));
                driver.setMobileNumber(resultSet.getString("mobile_number"));
                driver.setEmailId(resultSet.getString("email"));
                driver.setRegistrationNumber(resultSet.getString("registration_number"));
                driver.setId(id);

                return driver;
            }
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new CustomException("Failed to register info!");
        }
    }

    /**
     * <p>
     *     Retrieves {@link Location} details from the respective table of our Database
     * </p>
     *
     * @return a {@link List} containing {@link Location} details
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
     * <p>
     *     Inserts {@link Booking} details in the respective table of our Database.
     * </p>
     *
     * @param booking Booking, object being wrapped
     * @return that Booking's ID is being returned.
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
     * <p>
     *     Updates driver's location in the respective table once the Journey ends.
     * </p>
     *
     * @param locationId {@link Long}, drop Location being updated as Driver's current Location.
     * @return that driver's updated location ID.
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