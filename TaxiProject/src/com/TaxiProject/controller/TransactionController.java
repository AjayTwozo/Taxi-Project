package com.TaxiProject.controller;

import com.TaxiProject.model.PaymentOption;
import com.TaxiProject.model.Transaction;
import com.TaxiProject.service.Impl.PaymentOptionsImpl;
import com.TaxiProject.service.Impl.TransactionServiceImpl;

import java.util.List;

/**
 * Acquired functions from TransactionPage Class being passed to respective Services
 *
 * @author Ajay
 * @version 1.0
 */
public class TransactionController {

    private static final PaymentOptionsImpl PAYMENT_OPTIONS_IMPL = new PaymentOptionsImpl();
    private static final TransactionServiceImpl TRANSACTION_SERVICE_IMPL = new TransactionServiceImpl();

    /**
     * Effectuates getOption functionality from TransactionPage Class being passed to PaymentOptionsService
     *
     * @return being passed to Service
     */
    public List<PaymentOption> getOptions() {
        return PAYMENT_OPTIONS_IMPL.getOptions();
    }

    /**
     * Effectuates insert functionality from TransactionPage Class being passed to TransactionService
     *
     * @param transaction Transaction object being wrapped
     * @return being passed to Service
     */
    public long insertTransaction(final Transaction transaction) {
        return TRANSACTION_SERVICE_IMPL.insertTransaction(transaction);
    }

    /**
     * Effectuates getCustomerHistory functionality from TransactionPage Class being passed to TransactionService
     *
     * @param customerId customerId object being wrapped
     * @return being passed to Service
     */
    public List<Transaction> getCustomerHistory(final Long customerId) {
        return TRANSACTION_SERVICE_IMPL.getCustomerHistory(customerId);
    }

    /**
     * Effectuates getDriverHistory functionality from TransactionPage Class being passed to TransactionService
     *
     * @param driverId driverId object being wrapped
     * @return being passed to Service
     */
    public List<Transaction> getDriverHistory(final Long driverId) {
        return TRANSACTION_SERVICE_IMPL.getDriverHistory(driverId);
    }
}
