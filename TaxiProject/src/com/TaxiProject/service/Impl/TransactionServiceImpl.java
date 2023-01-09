package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.TransactionDAO;
import com.TaxiProject.model.Transaction;
import com.TaxiProject.service.TransactionService;

import java.util.List;

/**
 * Enforces the TransactionService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class TransactionServiceImpl implements TransactionService {

    private static final TransactionDAO TRANSACTION_DAO = new TransactionDAO();

    /**
     * Effectuates insert functionality from TransactionController Class being passed to TransactionDAO Class
     *
     * @param transaction Transaction, object being wrapped
     * @return being passed to DAO
     */
    public long insertTransaction(final Transaction transaction) {
        return TRANSACTION_DAO.insertTransaction(transaction);
    }

    /**
     * Effectuates getCustomerHistory functionality from TransactionController Class being passed to TransactionDAO Class
     *
     * @return being passed to DAO
     */
    public List<Transaction> getCustomerHistory(final Long customerId) {
        return TRANSACTION_DAO.getCustomerHistory(customerId);
    }

    /**
     * Effectuates getDriverHistory functionality from TransactionController Class being passed to TransactionDAO Class
     *
     * @return being passed to DAO
     */
    public List<Transaction> getDriverHistory(final Long driverId) {
        return TRANSACTION_DAO.getDriverHistory(driverId);
    }
}
