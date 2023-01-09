package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingDAO;
import com.TaxiProject.model.Fare;
import com.TaxiProject.service.FareService;

/**
 * Enforces the FareService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class FareServiceImpl implements FareService {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * Effectuates insert functionality from BookingController Class being passed to BookingDAO Class
     *
     * @param fare Fare, object being wrapped
     * @return being passed to DAO
     */
    public long insertFareDetails(final Fare fare) {
        return BOOKING_DAO.insertFareDetails(fare);
    }
}