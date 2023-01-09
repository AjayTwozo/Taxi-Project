package com.TaxiProject.service;

import com.TaxiProject.model.Booking;
import com.TaxiProject.model.Driver;
import com.TaxiProject.model.ServiceFare;

import java.util.List;

/**
 * Exhibits the Booking services that are available to Customers and Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public interface BookingService {

    List<ServiceFare> calculateFares(final Double distance);

    long assignDriver(final Driver driver);

    long insertBooking(final Booking booking);
    long updateDriverId(final Long locationId);
}
