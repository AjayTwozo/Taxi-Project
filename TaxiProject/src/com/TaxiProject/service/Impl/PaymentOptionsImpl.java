package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.TransactionDAO;
import com.TaxiProject.model.PaymentOption;
import com.TaxiProject.service.PaymentOptionsService;

import java.util.List;

/**
 * Enforces the {@link PaymentOptionsService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class PaymentOptionsImpl implements PaymentOptionsService {

    private static final TransactionDAO PAYMENT_DAO = new TransactionDAO();

    /**
     * <p>
     *     Effectuates acquire available payment options functionality to the Database.
     * </p>
     *
     * @return being passed to the Database.
     */
    public List<PaymentOption> getOptions() {
        return PAYMENT_DAO.getOptions();
    }
}
