package com.sanmedia.twozo.booking.service.implementation;

import com.sanmedia.twozo.booking.DAO.BookingDAO;
import com.sanmedia.twozo.booking.model.Location;
import com.sanmedia.twozo.booking.service.LocationService;

import java.util.List;

/**
 * Enforces the {@link LocationService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class LocationServiceImpl implements LocationService {

    private static final BookingDAO BOOKING_DAO = new BookingDAO();

    /**
     * <p>
     *     Effectuates acquire {@link Location} functionality to the Database.
     * </p>
     *
     * @return being passed to the Database.
     */
    public List<Location> getLocationInfo() {
        return BOOKING_DAO.getZoneInfo();
    }
}
