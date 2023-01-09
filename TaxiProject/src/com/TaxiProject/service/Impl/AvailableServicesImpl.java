package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingDAO;
import com.TaxiProject.model.Service;
import com.TaxiProject.service.AvailableServicesService;

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
