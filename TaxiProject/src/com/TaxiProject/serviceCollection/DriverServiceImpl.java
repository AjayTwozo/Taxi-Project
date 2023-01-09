package com.TaxiProject.serviceCollection;

import com.TaxiProject.model.Driver;

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
     * @param driver driver details being passed from the controller
     * @return whether the driver registered successfully
     */
    public boolean signUp(final Driver driver) {
        SIGNUP_MAP.put(driver.getMobileNumber(), driver.getPassword());

        return true;
    }

    /**
     * Enables existing drivers to login
     *
     * @param driver driver details being passed from the controller
     * @return whether the driver logged in successfully
     */
    public boolean login(final Driver driver) {

        if (SIGNUP_MAP.containsKey(driver.getMobileNumber())) {
            return SIGNUP_MAP.containsValue(driver.getPassword());
        }
        return false;
    }

    /**
     * Inserts driver
     *
     * @param driver driver details being passed from the controller
     * @return id number of the driver
     */
    public long insert(final Driver driver) {
        DRIVER_MAP.put((long) ID_NUMBER.incrementAndGet(), driver);
        driver.setId((long) ID_NUMBER.intValue());

        return ID_NUMBER.intValue();
    }

    /**
     * Lists all the drivers
     *
     * @return driver's list
     */
    public Collection<Driver> getAll() {
        return new ArrayList<>(DRIVER_MAP.values());
    }

    /**
     * Acquires the specified driver's information based on id number
     *
     * @param idNumber id number of the driver being passed
     * @return driver's info
     */
    public Driver get(final long idNumber) {
        return DRIVER_MAP.get(idNumber);
    }



    /**
     * Removes the specified driver based on id number
     *
     * @param idNumber id number of the driver being passed
     * @return whether driver has been successfully removed
     */
    public boolean remove(final long idNumber) {
        return DRIVER_MAP.remove(idNumber, get(idNumber));
    }

    /**
     * Enables the driver to update their information
     *
     * @param driver driver details being passed from the controller
     * @return whether driver's information has successfully updated
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