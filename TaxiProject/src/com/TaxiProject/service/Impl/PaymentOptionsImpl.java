package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.TransactionDAO;
import com.TaxiProject.model.PaymentOption;
import com.TaxiProject.service.PaymentOptionsService;

import java.util.List;

/**
 * Enforces the PaymentOptionsService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class PaymentOptionsImpl implements PaymentOptionsService {

    private static final TransactionDAO PAYMENT_DAO = new TransactionDAO();

    /**
     * Effectuates getOptions functionality from BookingController Class being passed to BookingDAO Class
     *
     * @return being passed to DAO
     */
    public List<PaymentOption> getOptions() {
        return PAYMENT_DAO.getOptions();
    }
}
