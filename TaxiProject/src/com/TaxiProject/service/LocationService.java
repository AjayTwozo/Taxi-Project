package com.TaxiProject.service;

import com.TaxiProject.model.Location;

import java.util.List;

/**
 * Exhibits the Locations wherein the Services are being available and operated
 *
 * @author Ajay
 * @version 1.0
 */
public interface LocationService {

    List<Location> getLocationInfo();
}