package com.sanmedia.twozo.booking.service;

import com.sanmedia.twozo.booking.model.Booking;

import java.util.List;

/**
 * Exhibits the Booking history services that are available to Customers and Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public interface BookingHistoryService {

    List<Booking> getCustomerHistory(final Long customerId);

    List<Booking> getDriverHistory(final Long driverId);
}
