package com.TaxiProject.controller;

import com.TaxiProject.service.Impl.DriverServiceImpl;
import com.TaxiProject.model.Driver;

import java.util.Collection;

/**
 * Acquired functions from DriverPage Class being passed to DriverService
 *
 * @author Ajay
 * @version 1.0
 */
public class DriverController {

    private static final DriverServiceImpl DRIVER_SERVICE_IMPL = new DriverServiceImpl();

    /**
     * Effectuates insert functionality from DriverPage Class being passed to DriverService
     *
     * @param driver Driver's info being wrapped
     * @return being passed to Service
     */
    public long insert(final Driver driver) {
        return DRIVER_SERVICE_IMPL.insert(driver);
    }

    /**
     * Effectuates getAll functionality from DriverPage Class being passed to DriverService
     *
     * @return being passed to service
     */
    public Collection<Driver> getAll() {
        return DRIVER_SERVICE_IMPL.getAll();
    }

    /**
     * Effectuates get functionality from DriverPage Class being passed to DriverService
     *
     * @param id ID Number
     * @return being passed to Service
     */
    public Driver get(final Long id) {
        return DRIVER_SERVICE_IMPL.get(id);
    }

    /**
     * Effectuates remove functionality from DriverPage Class being passed to DriverService
     *
     * @param idNumber ID number
     * @return being passed to the Service
     */
    public boolean remove(final Long idNumber) {
        return DRIVER_SERVICE_IMPL.remove(idNumber);
    }

    /**
     * Effectuates update functionality from DriverPage Class being passed to DriverService
     *
     * @param driver Driver's info being wrapped
     * @return being passed to the Service
     */
    public boolean update(final Driver driver) {
        return DRIVER_SERVICE_IMPL.update(driver);
    }
}
