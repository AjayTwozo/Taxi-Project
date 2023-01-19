package com.sanmedia.twozo.user.controller;

import com.sanmedia.twozo.user.model.Customer;
import com.sanmedia.twozo.user.service.implementation.CustomerServiceImpl;

import java.util.Collection;

/**
 * Acts as a Controller, manages the data's flow from View to respective Services.
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomerController {

    private static final CustomerServiceImpl CUSTOMER_SERVICE_IMPL = new CustomerServiceImpl();

    /**
     * <p>
     *     Effectuates {@link Customer} insert functionality from view to Service.
     * </p>
     *
     * @param userId {@link  Long}, critical in deciding which Customer's registering.
     * @return being passed to Service.
     */
    public long insert(final Long userId) {
        return CUSTOMER_SERVICE_IMPL.insert(userId);
    }

    /**
     * <p>
     *     Effectuates acquire every {@link Customer} details functionality from view to Service.
     * </p>
     *
     * @return being passed to service.
     */
    public Collection<Customer> getAll() {
        return CUSTOMER_SERVICE_IMPL.getAll();
    }

    /**
     * <p>
     *     Effectuates acquire {@link Customer} details functionality from view to Service through their ID.
     * </p>
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to Service.
     */
    public Customer get(final Long id) {
        return CUSTOMER_SERVICE_IMPL.get(id);
    }

    /**
     * <p>
     *     Effectuates remove {@link Customer} functionality from view to Service through their ID.
     * </p>
     *
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to the Service
     */
    public boolean remove(final Long id) {
        return CUSTOMER_SERVICE_IMPL.remove(id);
    }

    /**
     * <p>
     *     Effectuates update {@link Customer} functionality from view to Service through their ID.
     * </p>
     *
     * @param customer {@link Customer}, holds updated information from Customer.
     * @return being passed to the Service
     */
    public boolean update(final Customer customer) {
        return CUSTOMER_SERVICE_IMPL.update(customer);
    }
}