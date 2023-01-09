package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingDAO;
import com.TaxiProject.model.Service;
import com.TaxiProject.service.AvailableServicesService;

import java.util.List;

/**
 * Enforces the AvailableServices Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class AvailableServicesImpl implements AvailableServicesService  {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * Effectuates getServiceInfo functionality from BookingController Class being passed to BookingDAO Class
     *
     * @return being passed to DAO
     */
    public List<Service> getServiceInfo() {
        return BOOKING_DAO.getServiceInfo();
    }
}
