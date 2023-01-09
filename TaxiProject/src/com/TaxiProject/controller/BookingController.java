package com.TaxiProject.controller;

import com.TaxiProject.model.*;
import com.TaxiProject.service.Impl.AvailableServicesImpl;
import com.TaxiProject.service.Impl.BookingServiceImpl;
import com.TaxiProject.service.Impl.FareServiceImpl;
import com.TaxiProject.service.Impl.BookingHistoryServiceImpl;
import com.TaxiProject.service.Impl.LocationServiceImpl;

import java.util.List;

/**
 * Acts as a Controller, manages the data's flow from View to respective Services.
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
     * <p>
     *     Effectuates {@link Fare} inserts functionality from View to Service.
     * </p>
     *
     * @param fare {@link Fare} contains pick up, drop and location details that were wrapped.
     * @return being passed to Service.
     */
    public long insertFareDetails(final Fare fare) {
        return FARE_SERVICE_IMPL.insertFareDetails(fare);
    }

    /**
     * <p>
     *     Effectuates {@link Service} acquiring functionality from View to Service.
     * </p>
     *
     * @return being passed to Service.
     */
    public List<Service> getServiceInfo() {
        return AVAILABLE_SERVICES_IMPL.getServiceInfo();
    }

    /**
     * Effectuates {@link ServiceFare} calculation functionality from View to Service.
     *
     * @param distance {@link  Long}, Journey's distance being wrapped.
     * @return being passed to Service.
     */
    public List<ServiceFare> calculateFares(final Double distance) {
        return BOOKING_SERVICE_IMPL.calculateFares(distance);
    }

    /**
     * <p>
     *     Effectuates acquire {@link Location} functionality from View to Service.
     * </p>
     *
     * @return being passed to Service.
     */
    public List<Location> getLocationInfo() {
        return LOCATION_SERVICE_IMPL.getLocationInfo();
    }

    /**
     * <p>
     *     Effectuates Driver's availability functionality from View to Service.
     * </p>
     *
     * @param serviceId {@link Long}, determines Customer's choice of Service.
     * @param locationId {@link Long}, determines Customer's choice of Location.
     * @return being passed to Service
     */
    public Driver getDriverAvailability(final Long serviceId, final Long locationId) {
        return  BOOKING_SERVICE_IMPL.getDriverAvailability(serviceId, locationId);
    }

    /**
     * Effectuates insert {@link Booking} functionality from View to Service.
     *
     * @param booking {@link Booking}, contains all related details regarding a Booking.
     * @return being passed to Service.
     */
    public long insertBooking(final Booking booking) {
        return BOOKING_SERVICE_IMPL.insertBooking(booking);
    }

    /**
     * <p>
     *     Effectuates acquire Customer's History functionality from View to Service.
     * </p>
     *
     * @param customerId {@link Long}, critical in retrieving that ID's data.
     * @return being passed to Service
     */
    public List<Booking> getCustomerHistory(final Long customerId) {
        return BOOKING_HISTORY_SERVICE_IMPL.getCustomerHistory(customerId);
    }

    /**
     * <p>
     *     Effectuates acquire Driver's History functionality from View to Service.
     * </p>
     *
     * @param driverId {@link Long}, critical in retrieving that ID's data.
     * @return being passed to Service.
     */
    public List<Booking> getDriverHistory(final Long driverId) {
        return BOOKING_HISTORY_SERVICE_IMPL.getDriverHistory(driverId);
    }

    /**
     * <p>
     *     Effectuates driver update functionality from View to Service.
     * </p>
     *
     * @param locationId {@link Long}, critical in updating that ID's data.
     * @return being passed to Service.
     */
    public long updateDriverId(final Long locationId) {
        return BOOKING_SERVICE_IMPL.updateDriverId(locationId);
    }
}