package com.TaxiProject.serviceCollection;

import com.TaxiProject.model.Customer;

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
     * @param customer customer details being passed from the controller
     * @return whether the customer registered successfully
     */
    public boolean signUp(final Customer customer) {
        //SIGNUP_MAP.put(customer.getMobileNo(), customer.getPassword());

        return true;
    }

    /**
     * Enables existing customers to login
     *
     * @param customer customer details being passed from the controller
     * @return whether the customer logged in successfully
     */
    public boolean login(final Customer customer) {

        /*if (SIGNUP_MAP.containsKey(customer.getMobileNo())) {
            return SIGNUP_MAP.containsValue(customer.getPassword());
        }*/
        return false;
    }

    /**
     * Inserts customer
     *
     * @param customer customer details being passed from the controller
     * @return id number of the customer
     */
    public int insert(final Customer customer) {
        /*CUSTOMER_MAP.put(ID_NUMBER.incrementAndGet(), customer);
        customer.setId(ID_NUMBER.intValue());*/

        return ID_NUMBER.intValue();
    }

    /**
     * Lists all the customers
     *
     * @return customer's list
     */
    public Collection<Customer> getAll() {
        return new ArrayList<>(CUSTOMER_MAP.values());
    }

    /**
     * Acquires the specified customer's information based on id number
     *
     * @param idNumber id number of the customer being passed
     * @return customer's info
     */
    public Customer get(final int idNumber) {
        return CUSTOMER_MAP.get(idNumber);
    }

    /**
     * Removes the specified customer based on id number
     *
     * @param idNumber id number of the customer being passed
     * @return whether customer has been successfully removed
     */
    public boolean remove(final int idNumber) {
        return CUSTOMER_MAP.remove(idNumber, get(idNumber));
    }

    /**
     * Enables the customer to update their information
     *
     * @param customer customer details being passed from the controller
     * @return whether customer's information has successfully updated
     */
    public boolean update(final Customer customer) {
        /*final Customer get = get(customer.getId());

        if (customer.getName() == null) {
            customer.setName(get.getName());
        }

        if (customer.getMobileNo() == null) {
            customer.setMobileNo(get.getMobileNo());
        }

        if (customer.getPinCode() == 0) {
            customer.setPinCode(get.getPinCode());
        }

        return CUSTOMER_MAP.replace(customer.getId(), get(customer.getId()), customer);
    }*/
        return true;
    }
}