package com.TaxiProject.controller;

import com.TaxiProject.service.Impl.DriverServiceImpl;
import com.TaxiProject.model.Driver;

import java.util.Collection;

/**
 * Acts as a Controller, manages the data's flow from View to respective Services.
 *
 * @author Ajay
 * @version 1.0
 */
public class DriverController {

    private static final DriverServiceImpl DRIVER_SERVICE_IMPL = new DriverServiceImpl();

    /**
     * <p>
     *     Effectuates {@link Driver} insert functionality from view to Service.
     * </p>
     *
     * @param driver {@link Driver} holds registration number, choice of Service critical in Driver's registration.
     * @return being passed to Service.
     */
    public long insert(final Driver driver) {
        return DRIVER_SERVICE_IMPL.insert(driver);
    }

    /**
     * <p>
     *     Effectuates acquire every {@link Driver} details functionality from view to Service.
     * </p>
     *
     * @return being passed to service.
     */
    public Collection<Driver> getAll() {
        return DRIVER_SERVICE_IMPL.getAll();
    }

    /**
     * <p>
     *     Effectuates acquire {@link Driver} details functionality from view to Service through their ID.
     * </p>
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to Service.
     */
    public Driver get(final Long id) {
        return DRIVER_SERVICE_IMPL.get(id);
    }

    /**
     * <p>
     *     Effectuates remove {@link Driver} functionality from view to Service through their ID.
     * </p>
     *
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to the Service
     */
    public boolean remove(final Long id) {
        return DRIVER_SERVICE_IMPL.remove(id);
    }

    /**
     * <p>
     *     Effectuates update {@link Driver} functionality from view to Service through their ID.
     * </p>
     *
     * @param driver {@link Driver}, holds updated information from Customer.
     * @return being passed to the Service.
     */
    public boolean update(final Driver driver) {
        return DRIVER_SERVICE_IMPL.update(driver);
    }
}
