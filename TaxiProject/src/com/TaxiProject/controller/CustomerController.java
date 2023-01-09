package com.TaxiProject.controller;

import com.TaxiProject.service.Impl.CustomerServiceImpl;
import com.TaxiProject.model.Customer;

import java.util.Collection;

/**
 * Acquired functions from CustomerPage Class being passed to CustomerService
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomerController {

    private static final CustomerServiceImpl CUSTOMER_SERVICE_IMPL = new CustomerServiceImpl();

    /**
     * Effectuates insert functionality from CustomerPage Class being passed to CustomerService
     *
     * @param userId userId being wrapped
     * @return being passed to Service
     */
    public long insert(final Long userId) {
        return CUSTOMER_SERVICE_IMPL.insert(userId);
    }

    /**
     * Effectuates getAll functionality from CustomerPage Class being passed to CustomerService
     *
     * @return being passed to service
     */
    public Collection<Customer> getAll() {
        return CUSTOMER_SERVICE_IMPL.getAll();
    }

    /**
     * Effectuates get functionality from CustomerPage Class being passed to CustomerService
     *
     * @param id ID Number
     * @return being passed to Service
     */
    public Customer get(final Long id) {
        return CUSTOMER_SERVICE_IMPL.get(id);
    }

    /**
     * Effectuates remove functionality from CustomerPage Class being passed to CustomerService
     *
     * @param id ID number
     * @return being passed to the Service
     */
    public boolean remove(final Long id) {
        return CUSTOMER_SERVICE_IMPL.remove(id);
    }

    /**
     * Effectuates update functionality from CustomerPage Class being passed to CustomerService
     *
     * @param customer customer's info being wrapped
     * @return being passed to the Service
     */
    public boolean update(final Customer customer) {
        return CUSTOMER_SERVICE_IMPL.update(customer);
    }
}