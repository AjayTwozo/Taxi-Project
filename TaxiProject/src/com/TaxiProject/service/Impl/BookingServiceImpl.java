package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingDAO;
import com.TaxiProject.model.*;
import com.TaxiProject.service.BookingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Enforces the BookingService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingServiceImpl implements BookingService {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * Effectuates getCustomerHistory functionality from BookingController Class
     * then, calculates Fares using Distance and Price per KM of different Services
     * and storing it in List
     * Finally, being passed to BookingDAO Class
     *
     * @param distance distance, being wrapped
     * @return being passed to DAO
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
     * Effectuates assignDriver functionality from BookingController Class being passed to BookingDAO Class
     *
     * @param driver Driver, object being wrapped
     * @return being passed to DAO
     */
    public long assignDriver(final Driver driver) {
        return BOOKING_DAO.assignDriver(driver);
    }

    /**
     * Effectuates insertBooking functionality from BookingController Class being passed to BookingDAO Class
     *
     * @param booking Booking, object being wrapped
     * @return being passed to DAO
     */
    public long insertBooking(final Booking booking) {
        return BOOKING_DAO.insertBooking(booking);
    }

    /**
     * Effectuates updateDriverId functionality from BookingController Class being passed to BookingDAO Class
     *
     * @param locationId location ID, being wrapped
     * @return being passed to Controller
     */
    public long updateDriverId(final Long locationId) {
        return BOOKING_DAO.updateDriverId(locationId);
    }
}
