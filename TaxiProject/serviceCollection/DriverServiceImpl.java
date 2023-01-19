package com.TaxiProject.serviceCollection;

import com.TaxiProject.driver.model.Driver;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementation class of Driver Service Interface
 */
public class DriverServiceImpl implements DriverService {

    private static final Map<String, String> SIGNUP_MAP = new HashMap<>();
    private static final Map<Long, Driver> DRIVER_MAP = new HashMap<>();
    private static final AtomicInteger ID_NUMBER = new AtomicInteger(0);

    /**
     * Enables potential drivers to sign up
     *
     * @param driver com.TaxiProject.driver details being passed from the controller
     * @return whether the com.TaxiProject.driver registered successfully
     */
    public boolean signUp(final Driver driver) {
        SIGNUP_MAP.put(driver.getMobileNumber(), driver.getPassword());

        return true;
    }

    /**
     * Enables existing drivers to login
     *
     * @param driver com.TaxiProject.driver details being passed from the controller
     * @return whether the com.TaxiProject.driver logged in successfully
     */
    public boolean login(final Driver driver) {

        if (SIGNUP_MAP.containsKey(driver.getMobileNumber())) {
            return SIGNUP_MAP.containsValue(driver.getPassword());
        }
        return false;
    }

    /**
     * Inserts com.TaxiProject.driver
     *
     * @param driver com.TaxiProject.driver details being passed from the controller
     * @return id number of the com.TaxiProject.driver
     */
    public long insert(final Driver driver) {
        DRIVER_MAP.put((long) ID_NUMBER.incrementAndGet(), driver);
        driver.setId((long) ID_NUMBER.intValue());

        return ID_NUMBER.intValue();
    }

    /**
     * Lists all the drivers
     *
     * @return com.TaxiProject.driver's list
     */
    public Collection<Driver> getAll() {
        return new ArrayList<>(DRIVER_MAP.values());
    }

    /**
     * Acquires the specified com.TaxiProject.driver's information based on id number
     *
     * @param idNumber id number of the com.TaxiProject.driver being passed
     * @return com.TaxiProject.driver's info
     */
    public Driver get(final long idNumber) {
        return DRIVER_MAP.get(idNumber);
    }



    /**
     * Removes the specified com.TaxiProject.driver based on id number
     *
     * @param idNumber id number of the com.TaxiProject.driver being passed
     * @return whether com.TaxiProject.driver has been successfully removed
     */
    public boolean remove(final long idNumber) {
        return DRIVER_MAP.remove(idNumber, get(idNumber));
    }

    /**
     * Enables the com.TaxiProject.driver to update their information
     *
     * @param driver com.TaxiProject.driver details being passed from the controller
     * @return whether com.TaxiProject.driver's information has successfully updated
     */
    public boolean update(final Driver driver) {
        final Driver get = get(driver.getId());

        if (driver.getName() == null) {
            driver.setName(get.getName());
        }

        if (driver.getMobileNumber() == null) {
            driver.setMobileNumber(get.getMobileNumber());
        }

        if (driver.getRegistrationNumber() == null) {
            driver.setRegistrationNumber(get.getRegistrationNumber());
        }

        return DRIVER_MAP.replace(driver.getId(), get, driver);
    }
}