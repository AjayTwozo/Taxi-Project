package com.sanmedia.twozo.booking.service;

import com.sanmedia.twozo.booking.model.Service;

import java.util.List;

/**
 * Exhibits the Service options that are available to Customers and Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public interface AvailableServicesService {

    List<Service> getServiceInfo();
}
