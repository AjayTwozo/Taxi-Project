package com.TaxiProject.serviceCollection;

import com.TaxiProject.customer.model.Customer;

import java.util.Collection;

/**
 * Displays the services offered to Customers
 */
public interface CustomerService {

    boolean signUp(final Customer customer);

    boolean login(final Customer customer);

    int insert(final Customer customer);

    Collection<Customer> getAll();

    Customer get(final int idNumber);

    boolean remove(final int idNumber);

    boolean update(final Customer customer);
}