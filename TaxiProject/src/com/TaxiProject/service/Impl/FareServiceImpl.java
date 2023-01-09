package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingDAO;
import com.TaxiProject.model.Fare;
import com.TaxiProject.service.FareService;

/**
 * Enforces the {@link FareService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class FareServiceImpl implements FareService {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * <p>
     *     Effectuates {@link Fare} inserts functionality to the Database.
     * </p>
     *
     * @param fare {@link Fare} contains pick up, drop and location details that were wrapped.
     * @return being passed to the Database.
     */
    public long insertFareDetails(final Fare fare) {
        return BOOKING_DAO.insertFareDetails(fare);
    }
}