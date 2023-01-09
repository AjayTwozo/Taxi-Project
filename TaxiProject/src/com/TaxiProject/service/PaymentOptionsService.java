package com.TaxiProject.service;

import com.TaxiProject.model.PaymentOption;

import java.util.List;

/**
 * Exhibits the payment options that are available to Customers
 *
 * @author Ajay
 * @version 1.0
 */
public interface PaymentOptionsService {

    List<PaymentOption> getOptions();
}
