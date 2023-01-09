package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingDAO;
import com.TaxiProject.controller.BookingController;
import com.TaxiProject.model.*;
import com.TaxiProject.service.BookingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Enforces the {@link BookingService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingServiceImpl implements BookingService {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * <p>
     *     Effectuates {@link ServiceFare} calculation functionality, then, calculates Fares using Distance and
     *     Price per KM of different Services.
     * </p>
     *
     * @param distance {@link  Long}, Journey's distance being wrapped.
     * @return a {@link List}, containing {@link ServiceFare} details.
     */
    public List<ServiceFare> calculateFares(final Double distance) {
        final List<Service> serviceContainer = BOOKING_DAO.getServiceInfo();
        final List<ServiceFare> fareList = new ArrayList<>();

        for (final Service service : serviceContainer) {
            final Booking booking = new Booking();
            final ServiceFare serviceFare = new ServiceFare();

            booking.setTotalFare(service.getPricePerKM() * distance);
            serviceFare.setService(service);
            serviceFare.setBooking(booking);
            fareList.add(serviceFare);
        }
        return fareList;
    }

    /**
     * <p>
     *     Effectuates Driver's availability functionality to the Database.
     * </p>
     *
     * @param serviceId {@link Long}, determines Customer's choice of Service.
     * @param locationId {@link Long}, determines Customer's choice of Location.
     * @return being passed to the Database.
     */
    public Driver getDriverAvailability(final Long serviceId, final Long locationId) {
        return BOOKING_DAO.getDriverAvailability(serviceId, locationId);
    }

    /**
     * Effectuates insert {@link Booking} functionality to the Database.
     *
     * @param booking {@link Booking}, contains all related details regarding a Booking.
     * @return being passed to the Database.
     */
    public long insertBooking(final Booking booking) {
        return BOOKING_DAO.insertBooking(booking);
    }

    /**
     * <p>
     *     Effectuates driver update functionality to the Database.
     * </p>
     *
     * @param locationId {@link Long}, critical in updating that ID's data.
     * @return being passed to the Database.
     */
    public long updateDriverId(final Long locationId) {
        return BOOKING_DAO.updateDriverId(locationId);
    }
}
