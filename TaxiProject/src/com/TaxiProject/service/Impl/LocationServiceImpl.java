package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.BookingDAO;
import com.TaxiProject.model.Location;
import com.TaxiProject.service.LocationService;

import java.util.List;

/**
 * Enforces the LocationService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class LocationServiceImpl implements LocationService {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * Effectuates getLocationInfo functionality from BookingController Class being passed to BookingDAO Class
     *
     * @return being passed to DAO
     */
    public List<Location> getLocationInfo() {
        return BOOKING_DAO.getZoneInfo();
    }
}
