package com.TaxiProject.serviceCollection;

import com.TaxiProject.customer.model.Customer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementation class of the Customer Service Interface
 */
public class CustomerServiceImpl implements CustomerService {

    private static final Map<String, String> SIGNUP_MAP = new HashMap<>();
    private static final Map<Integer, Customer> CUSTOMER_MAP = new HashMap<>();
    private static final AtomicInteger ID_NUMBER = new AtomicInteger(0);

    /**
     * Enables potential customers to sign up
     *
     * @param customer com.TaxiProject.customer details being passed from the controller
     * @return whether the com.TaxiProject.customer registered successfully
     */
    public boolean signUp(final Customer customer) {
        //SIGNUP_MAP.put(com.TaxiProject.customer.getMobileNo(), com.TaxiProject.customer.getPassword());

        return true;
    }

    /**
     * Enables existing customers to login
     *
     * @param customer com.TaxiProject.customer details being passed from the controller
     * @return whether the com.TaxiProject.customer logged in successfully
     */
    public boolean login(final Customer customer) {

        /*if (SIGNUP_MAP.containsKey(com.TaxiProject.customer.getMobileNo())) {
            return SIGNUP_MAP.containsValue(com.TaxiProject.customer.getPassword());
        }*/
        return false;
    }

    /**
     * Inserts com.TaxiProject.customer
     *
     * @param customer com.TaxiProject.customer details being passed from the controller
     * @return id number of the com.TaxiProject.customer
     */
    public int insert(final Customer customer) {
        /*CUSTOMER_MAP.put(ID_NUMBER.incrementAndGet(), com.TaxiProject.customer);
        com.TaxiProject.customer.setId(ID_NUMBER.intValue());*/

        return ID_NUMBER.intValue();
    }

    /**
     * Lists all the customers
     *
     * @return com.TaxiProject.customer's list
     */
    public Collection<Customer> getAll() {
        return new ArrayList<>(CUSTOMER_MAP.values());
    }

    /**
     * Acquires the specified com.TaxiProject.customer's information based on id number
     *
     * @param idNumber id number of the com.TaxiProject.customer being passed
     * @return com.TaxiProject.customer's info
     */
    public Customer get(final int idNumber) {
        return CUSTOMER_MAP.get(idNumber);
    }

    /**
     * Removes the specified com.TaxiProject.customer based on id number
     *
     * @param idNumber id number of the com.TaxiProject.customer being passed
     * @return whether com.TaxiProject.customer has been successfully removed
     */
    public boolean remove(final int idNumber) {
        return CUSTOMER_MAP.remove(idNumber, get(idNumber));
    }

    /**
     * Enables the com.TaxiProject.customer to update their information
     *
     * @param customer com.TaxiProject.customer details being passed from the controller
     * @return whether com.TaxiProject.customer's information has successfully updated
     */
    public boolean update(final Customer customer) {
        /*final Customer get = get(com.TaxiProject.customer.getId());

        if (com.TaxiProject.customer.getName() == null) {
            com.TaxiProject.customer.setName(get.getName());
        }

        if (com.TaxiProject.customer.getMobileNo() == null) {
            com.TaxiProject.customer.setMobileNo(get.getMobileNo());
        }

        if (com.TaxiProject.customer.getPinCode() == 0) {
            com.TaxiProject.customer.setPinCode(get.getPinCode());
        }

        return CUSTOMER_MAP.replace(com.TaxiProject.customer.getId(), get(com.TaxiProject.customer.getId()), com.TaxiProject.customer);
    }*/
        return true;
    }
}