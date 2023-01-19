package com.sanmedia.twozo.transaction.controller;

import com.sanmedia.twozo.transaction.model.PaymentOption;
import com.sanmedia.twozo.transaction.service.PaymentOptionsImpl;
import com.sanmedia.twozo.transaction.model.Transaction;
import com.sanmedia.twozo.transaction.service.TransactionServiceImpl;

import java.util.List;

/**
 * Acts as a Controller, manages the data's flow from View to respective Services.
 *
 * @author Ajay
 * @version 1.0
 */
public class TransactionController {

    private static final PaymentOptionsImpl PAYMENT_OPTIONS_IMPL = new PaymentOptionsImpl();
    private static final TransactionServiceImpl TRANSACTION_SERVICE_IMPL = new TransactionServiceImpl();

    /**
     * <p>
     *     Effectuates acquire available payment options functionality from View to Service.
     * </p>
     *
     * @return being passed to Service
     */
    public List<PaymentOption> getOptions() {
        return PAYMENT_OPTIONS_IMPL.getOptions();
    }

    /**
     * <p>
     *     Effectuates insert {@link Transaction} functionality from View to Service.
     * </p>
     *
     * @param transaction Transaction holds com.TaxiProject.booking ID, total fare and payment mode details.
     * @return being passed to Service.
     */
    public long insertTransaction(final long bookingId, final Transaction transaction) {
        return TRANSACTION_SERVICE_IMPL.insertTransaction(bookingId, transaction);
    }

    /**
     * <p>
     *     Effectuates acquire Customer's History functionality from View to Service.
     * </p>
     *
     * @param customerId {@link Long}, critical on whose details being retrieved.
     * @return being passed to Service.
     */
    public List<Transaction> getCustomerHistory(final Long customerId) {
        return TRANSACTION_SERVICE_IMPL.getCustomerHistory(customerId);
    }

    /**
     * <p>
     *     Effectuates acquire Driver's History functionality from View to Service.
     * </p>
     *
     * @param driverId {@link Long}, critical on whose details being retrieved.
     * @return being passed to Service.
     */
    public List<Transaction> getDriverHistory(final Long driverId) {
        return TRANSACTION_SERVICE_IMPL.getDriverHistory(driverId);
    }
}
