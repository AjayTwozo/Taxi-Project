package com.sanmedia.twozo.booking.service;

import com.sanmedia.twozo.booking.model.Booking;
import com.sanmedia.twozo.booking.model.ServiceFare;
import com.sanmedia.twozo.user.model.Driver;

import java.util.List;

/**
 * Exhibits the Booking services that are available to Customers and Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public interface BookingService {

    List<ServiceFare> calculateFares(final Double distance);

    Driver getDriverAvailability(final Long serviceId, final Long locationId);

    long insertBooking(final Booking booking);
    long updateDriverId(final Long locationId);
}
