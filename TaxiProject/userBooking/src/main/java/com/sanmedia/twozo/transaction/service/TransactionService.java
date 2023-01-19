package com.sanmedia.twozo.transaction.service;

import com.sanmedia.twozo.transaction.model.Transaction;

import java.util.List;

/**
 * Exhibits the Transaction services that are offered to Customers and Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public interface TransactionService {

    long insertTransaction(final long bookingId, final Transaction transaction);

    List<Transaction> getCustomerHistory(final Long customerId);

    List<Transaction> getDriverHistory(final Long driverId);
}