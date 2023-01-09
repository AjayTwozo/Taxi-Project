package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingHistoryDAO;
import com.TaxiProject.model.Booking;
import com.TaxiProject.service.BookingHistoryService;

import java.util.List;

/**
 * Enforces the BookingHistoryService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingHistoryServiceImpl implements BookingHistoryService {

    private static final BookingHistoryDAO BOOKING_HISTORY_DAO = new BookingHistoryDAO();

    /**
     * Effectuates getCustomerHistory functionality from BookingController Class being passed to BookingHistoryDAO Class
     *
     * @param customerId customerId, being wrapped
     * @return being passed to DAO
     */
    public List<Booking> getCustomerHistory(final Long customerId) {
        return BOOKING_HISTORY_DAO.getCustomerHistory(customerId);
    }

    /**
     * Effectuates getDriverHistory functionality from BookingController Class being passed to BookingHistoryDAO Class
     *
     * @param driverId driverId, being wrapped
     * @return being passed to DAO
     */
    public List<Booking> getDriverHistory(final Long driverId) {
        return BOOKING_HISTORY_DAO.getDriverHistory(driverId);
    }
}
