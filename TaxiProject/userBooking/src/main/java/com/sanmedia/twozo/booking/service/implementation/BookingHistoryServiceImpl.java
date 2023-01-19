package com.sanmedia.twozo.booking.service.implementation;

import com.sanmedia.twozo.booking.DAO.BookingHistoryDAO;
import com.sanmedia.twozo.booking.model.Booking;
import com.sanmedia.twozo.booking.service.BookingHistoryService;

import java.util.List;

/**
 * Enforces the {@link BookingHistoryService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingHistoryServiceImpl implements BookingHistoryService {

    private static final BookingHistoryDAO BOOKING_HISTORY_DAO = new BookingHistoryDAO();

    /**
     * <p>
     *     Effectuates acquire Customer's History functionality to the Database.
     * </p>
     *
     * @param customerId {@link Long}, critical in retrieving that ID's data.
     * @return being passed to the Database.
     */
    public List<Booking> getCustomerHistory(final Long customerId) {
        return BOOKING_HISTORY_DAO.getCustomerHistory(customerId);
    }

    /**
     * <p>
     *     Effectuates acquire Driver's History functionality to the Data base.
     * </p>
     *
     * @param driverId {@link Long}, critical in retrieving that ID's data.
     * @return being passed to the Database.
     */
    public List<Booking> getDriverHistory(final Long driverId) {
        return BOOKING_HISTORY_DAO.getDriverHistory(driverId);
    }
}
