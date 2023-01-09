package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.DriverDAO;
import com.TaxiProject.service.DriverService;
import com.TaxiProject.model.Driver;

import java.util.Collection;

/**
 * Enforces the DriverService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class DriverServiceImpl implements DriverService {

    private static final DriverDAO DRIVER_DAO = new DriverDAO();

    /**
     * Effectuates insert functionality from DriverController Class being passed to DriverDAO Class
     *
     * @param driver, Driver being wrapped
     * @return being passed to DAO
     */
    public long insert(final Driver driver) {
        return DRIVER_DAO.insert(driver);
    }

    /**
     * Effectuates getAll functionality from DriverController Class being passed to DriverDAO Class
     *
     * @return being passed to DAO
     */
    public Collection<Driver> getAll() {
        return DRIVER_DAO.getAll();
    }

    /**
     * Effectuates get functionality from DriverController Class being passed to DriverDAO Class
     *
     * @param idNumber idNumber, being wrapped
     * @return being passed to DAO
     */
    public Driver get(final Long idNumber) {
        return DRIVER_DAO.get(idNumber);
    }

    /**
     * Effectuates remove functionality from DriverController Class being passed to DriverDAO Class
     *
     * @param idNumber idNumber, being wrapped
     * @return being passed to DAO
     */
    public boolean remove(final Long idNumber) {
        return DRIVER_DAO.remove(idNumber);
    }

    /**
     * Effectuates remove functionality from DriverController Class being passed to DriverDAO Class
     * If null, acquires existing value from Get functionality
     *
     * @param driver, Driver being wrapped
     * @return being passed to DAO
     */
    public boolean update(final Driver driver) {
        final Driver serviceImplDriver = get(driver.getId());
        final String name = driver.getName() == null ? serviceImplDriver.getName() : driver.getName();
        final String mobileNumber = driver.getMobileNumber() == null ?
                serviceImplDriver.getMobileNumber() : driver.getMobileNumber();
        final String password = driver.getPassword() == null ? serviceImplDriver.getPassword() : driver.getPassword();
        final String emailId = driver.getEmailId() == null ? serviceImplDriver.getEmailId() : driver.getEmailId();
        final String registrationNumber = driver.getRegistrationNumber() == null ?
                serviceImplDriver.getRegistrationNumber() : driver.getRegistrationNumber();

        return DRIVER_DAO.update(driver);
    }
}
