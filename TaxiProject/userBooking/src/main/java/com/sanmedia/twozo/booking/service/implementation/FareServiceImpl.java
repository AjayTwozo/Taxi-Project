package com.sanmedia.twozo.booking.service.implementation;

import com.sanmedia.twozo.booking.DAO.BookingDAO;
import com.sanmedia.twozo.booking.model.Fare;
import com.sanmedia.twozo.booking.service.FareService;

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