package com.sanmedia.twozo.booking.service.implementation;

import com.sanmedia.twozo.booking.DAO.BookingDAO;
import com.sanmedia.twozo.booking.model.Service;
import com.sanmedia.twozo.booking.service.AvailableServicesService;

import java.util.List;

/**
 * Enforces the {@link AvailableServicesService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class AvailableServicesImpl implements AvailableServicesService  {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * <p>
     *     Effectuates {@link Service} acquiring functionality to Data base.
     * </p>
     *
     * @return being passed to the Database.
     */
    public List<Service> getServiceInfo() {
        return BOOKING_DAO.getServiceInfo();
    }
}
