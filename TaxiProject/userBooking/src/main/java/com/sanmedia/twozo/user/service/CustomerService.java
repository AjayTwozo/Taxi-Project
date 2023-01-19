package com.sanmedia.twozo.user.service;

import com.sanmedia.twozo.user.model.Customer;

import java.util.Collection;

/**
 * Exhibits the services that are offered to Customers
 *
 * @author Ajay
 * @version 1.0
 */
public interface CustomerService {

    long insert(final Long userId);

    Collection<Customer> getAll();

    Customer get(final Long idNumber);

    boolean remove(final Long idNumber);

    boolean update(final Customer customer);
}
