package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.TransactionDAO;
import com.TaxiProject.model.Transaction;
import com.TaxiProject.service.TransactionService;

import java.util.List;

/**
 * Enforces the {@link TransactionService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class TransactionServiceImpl implements TransactionService {

    private static final TransactionDAO TRANSACTION_DAO = new TransactionDAO();

    /**
     * <p>
     *     Effectuates insert {@link Transaction} functionality to the Database.
     * </p>
     *
     * @param transaction Transaction holds booking ID, total fare and payment mode details.
     * @return being passed to the Database.
     */
    public long insertTransaction(final Transaction transaction) {
        return TRANSACTION_DAO.insertTransaction(transaction);
    }

    /**
     * <p>
     *     Effectuates acquire Customer's History functionality to the Database.
     * </p>
     *
     * @param customerId {@link Long}, critical on whose details being retrieved.
     * @return being passed to the Database.
     */
    public List<Transaction> getCustomerHistory(final Long customerId) {
        return TRANSACTION_DAO.getCustomerHistory(customerId);
    }

    /**
     * <p>
     *     Effectuates acquire Driver's History functionality to the Database.
     * </p>
     *
     * @param driverId {@link Long}, critical on whose details being retrieved.
     * @return being passed to the Database.
     */
    public List<Transaction> getDriverHistory(final Long driverId) {
        return TRANSACTION_DAO.getDriverHistory(driverId);
    }
}
