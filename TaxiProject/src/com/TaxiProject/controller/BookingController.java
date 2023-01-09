package com.TaxiProject.controller;

import com.TaxiProject.model.Booking;
import com.TaxiProject.model.Fare;
import com.TaxiProject.model.Service;
import com.TaxiProject.model.Location;
import com.TaxiProject.model.Driver;
import com.TaxiProject.model.ServiceFare;
import com.TaxiProject.service.Impl.AvailableServicesImpl;
import com.TaxiProject.service.Impl.BookingServiceImpl;
import com.TaxiProject.service.Impl.FareServiceImpl;
import com.TaxiProject.service.Impl.BookingHistoryServiceImpl;
import com.TaxiProject.service.Impl.LocationServiceImpl;

import java.util.List;

/**
 * Acquired functions from BookingPage and BookingHistory Class being passed to respective Services
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingController {
    private static final FareServiceImpl FARE_SERVICE_IMPL = new FareServiceImpl();
    private static final AvailableServicesImpl AVAILABLE_SERVICES_IMPL = new AvailableServicesImpl();
    private static final LocationServiceImpl LOCATION_SERVICE_IMPL = new LocationServiceImpl();
    private static final BookingServiceImpl BOOKING_SERVICE_IMPL = new BookingServiceImpl();
    private static final BookingHistoryServiceImpl BOOKING_HISTORY_SERVICE_IMPL = new BookingHistoryServiceImpl();

    /**
     * Effectuates insert functionality from BookingPage Class being passed to FareService
     *
     * @param fare Fare, object being wrapped
     * @return being passed to Service
     */
    public long insertFareDetails(final Fare fare) {
        return FARE_SERVICE_IMPL.insertFareDetails(fare);
    }

    /**
     * Effectuates getAll functionality from BookingPage Class being passed to AvailableServicesService
     *
     * @return being passed to Service
     */
    public List<Service> getServiceInfo() {
        return AVAILABLE_SERVICES_IMPL.getServiceInfo();
    }

    /**
     * Effectuates calculateFares functionality from BookingPage Class being passed to BookingService
     *
     * @param distance Distance, being wrapped
     * @return being passed to Service
     */
    public List<ServiceFare> calculateFares(final Double distance) {
        return BOOKING_SERVICE_IMPL.calculateFares(distance);
    }

    /**
     * Effectuates getLocationInfo functionality from BookingPage Class being passed to LocationService
     *
     * @return being passed to Service
     */
    public List<Location> getLocationInfo() {
        return LOCATION_SERVICE_IMPL.getLocationInfo();
    }

    /**
     * Effectuates assignDriver functionality from BookingPage Class being passed to BookingService
     *
     * @param driver Driver, object being wrapped
     * @return being passed to Service
     */
    public long assignDriver(final Driver driver) {
        return  BOOKING_SERVICE_IMPL.assignDriver(driver);
    }

    /**
     * Effectuates insertBooking functionality from BookingPage Class being passed to BookingService
     *
     * @param booking Booking, object being wrapped
     * @return being passed to Service
     */
    public long insertBooking(final Booking booking) {
        return BOOKING_SERVICE_IMPL.insertBooking(booking);
    }

    /**
     * Effectuates getCustomerHistory functionality from BookingHistoryPage Class being passed to BookingHistoryService
     *
     * @param customerId customerId, being wrapped
     * @return being passed to Service
     */
    public List<Booking> getCustomerHistory(final Long customerId) {
        return BOOKING_HISTORY_SERVICE_IMPL.getCustomerHistory(customerId);
    }

    /**
     * Effectuates getDriverHistory functionality from BookingHistoryPage Class being passed to BookingHistoryService
     *
     * @param driverId driverId, being wrapped
     * @return being passed to Service
     */
    public List<Booking> getDriverHistory(final Long driverId) {
        return BOOKING_HISTORY_SERVICE_IMPL.getDriverHistory(driverId);
    }

    /**
     * Effectuates updateDriverId functionality from BookingHistoryPage Class being passed to BookingService
     *
     * @param locationId location ID, being wrapped
     * @return being passed to Controller
     */
    public long updateDriverId(final Long locationId) {
        return BOOKING_SERVICE_IMPL.updateDriverId(locationId);
    }
}