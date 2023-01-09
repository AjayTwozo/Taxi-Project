package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.CustomerDAO;
import com.TaxiProject.service.CustomerService;
import com.TaxiProject.model.Customer;

import java.util.Collection;

/**
 * Enforces the {@link CustomerService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomerServiceImpl implements CustomerService {

    private static final CustomerDAO CUSTOMER_DAO = new CustomerDAO();

    /**
     * <p>
     *     Effectuates {@link Customer} insert functionality to the Database.
     * </p>
     *
     * @param userId {@link  Long}, critical in deciding which Customer's registering.
     * @return being to the Database.
     */
    public long insert(final Long userId) {
        return CUSTOMER_DAO.insert(userId);
    }

    /**
     * <p>
     *     Effectuates acquire every {@link Customer} details functionality to the Database.
     * </p>
     *
     * @return being passed to the Database.
     */
    public Collection<Customer> getAll() {
        return CUSTOMER_DAO.getAll();
    }

    /**
     * <p>
     *     Effectuates acquire {@link Customer} details functionality to the Database.
     * </p>
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to the Database.
     */
    public Customer get(final Long id) {
        return CUSTOMER_DAO.get(id);
    }

    /**
     * <p>
     *     Effectuates remove {@link Customer} functionality to the Database.
     * </p>
     *
     * @param id {@link  Long}, critical on whose details being retrieved.
     * @return being passed to the Database.
     */
    public boolean remove(final Long id) {
        return CUSTOMER_DAO.remove(id);
    }

    /**
     * <p>
     *     Effectuates update {@link Customer} functionality to the Database.
     *     If null, acquires existing value from Get functionality.
     * </p>
     *
     * @param customer {@link Customer}, holds updated information from Customer.
     * @return being passed to the Database.
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
