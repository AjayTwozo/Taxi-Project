package com.sanmedia.twozo.transaction.service;

import com.sanmedia.twozo.transaction.model.PaymentOption;
import com.sanmedia.twozo.transaction.DAO.TransactionDAO;

import java.util.List;

/**
 * Enforces the {@link PaymentOptionsService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class PaymentOptionsImpl implements PaymentOptionsService {

    private static final TransactionDAO TRANSACTION_DAO = new TransactionDAO();

    /**
     * <p>
     *     Effectuates acquire available payment options functionality to the Database.
     * </p>
     *
     * @return being passed to the Database.
     */
    public List<PaymentOption> getOptions() {
        return TRANSACTION_DAO.getOptions();
    }
}
