package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.DriverDAO;
import com.TaxiProject.model.Customer;
import com.TaxiProject.service.DriverService;
import com.TaxiProject.model.Driver;

import java.util.Collection;

/**
 * Enforces the {@link DriverService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class DriverServiceImpl implements DriverService {

    private static final DriverDAO DRIVER_DAO = new DriverDAO();

    /**
     * <p>
     *     Effectuates {@link Driver} insert functionality to the Database.
     * </p>
     *
     * @param driver {@link Driver} holds registration number, choice of Service critical in Driver's registration.
     * @return being to the Database.
     */
    public long insert(final Driver driver) {
        return DRIVER_DAO.insert(driver);
    }

    /**
     * <p>
     *     Effectuates acquire every {@link Driver} details functionality to the Database.
     * </p>
     *
     * @return being passed to the Database.
     */
    public Collection<Driver> getAll() {
        return DRIVER_DAO.getAll();
    }

    /**
     * <p>
     *     Effectuates acquire {@link Driver} details functionality to the Database.
     * </p>
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to the Database.
     */
    public Driver get(final Long id) {
        return DRIVER_DAO.get(id);
    }

    /**
     * <p>
     *     Effectuates remove {@link Driver} functionality to the Database.
     * </p>
     *
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to the Service
     */
    public boolean remove(final Long id) {
        return DRIVER_DAO.remove(id);
    }

    /**
     * <p>
     *     Effectuates update {@link Driver} functionality to the Database.
     *     If null, acquires existing value from Get functionality.
     * </p>
     *
     * @param driver {@link Driver}, holds updated information from Customer.
     * @return being passed to the Database.
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
