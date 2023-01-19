package com.sanmedia.twozo.booking.service;

import com.sanmedia.twozo.booking.model.Fare;

/**
 * Exhibits the Fare services that are offered to Customers
 *
 * @author Ajay
 * @version 1.0
 */
public interface FareService {

    long insertFareDetails(final Fare fare);
}