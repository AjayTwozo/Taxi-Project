package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.CustomerDAO;
import com.TaxiProject.service.CustomerService;
import com.TaxiProject.model.Customer;

import java.util.Collection;

/**
 * Enforces the CustomerService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomerServiceImpl implements CustomerService {

    private static final CustomerDAO CUSTOMER_DAO = new CustomerDAO();

    /**
     * Effectuates insert functionality from CustomerController Class being passed to CustomerDAO Class
     *
     * @param userId userId, being wrapped
     * @return being passed to DAO
     */
    public long insert(final Long userId) {
        return CUSTOMER_DAO.insert(userId);
    }

    /**
     * Effectuates getAll functionality from CustomerController Class being passed to CustomerDAO Class
     *
     * @return being passed to DAO
     */
    public Collection<Customer> getAll() {
        return CUSTOMER_DAO.getAll();
    }

    /**
     * Effectuates get functionality from CustomerController Class being passed to CustomerDAO Class
     *
     * @param idNumber idNumber, being wrapped
     * @return being passed to DAO
     */
    public Customer get(final Long idNumber) {
        return CUSTOMER_DAO.get(idNumber);
    }

    /**
     * Effectuates remove functionality from CustomerController Class being passed to CustomerDAO Class
     *
     * @param idNumber idNumber, being wrapped
     * @return being passed to DAO
     */
    public boolean remove(final Long idNumber) {
        return CUSTOMER_DAO.remove(idNumber);
    }

    /**
     * Effectuates update functionality from CustomerController Class being passed to CustomerDAO Class
     * If null, acquires existing value from Get functionality
     *
     * @param customer Customer, object being wrapped
     * @return being passed to DAO
     */
    public boolean update(final Customer customer) {
        final Customer serviceImplCustomer = get(customer.getId());
        final String name = customer.getName() == null ? serviceImplCustomer.getName() : customer.getName();
        final String mobileNumber = customer.getMobileNumber() == null ?
                serviceImplCustomer.getMobileNumber() : customer.getMobileNumber();
        final String password = customer.getPassword() == null ?
                serviceImplCustomer.getPassword() : customer.getPassword();
        final String emailId = customer.getEmailId() == null ? serviceImplCustomer.getEmailId() : customer.getEmailId();

        return CUSTOMER_DAO.update(customer);
    }
}
