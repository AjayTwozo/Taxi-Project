package com.sanmedia.twozo.transaction.model;

import com.sanmedia.twozo.booking.model.Booking;

/**
 * Transaction pattern
 * Contains id, com.TaxiProject.transaction ID, payment acknowledgement, com.TaxiProject.booking, payment option
 *
 * @author Ajay
 * @version 1.0
 */
public class Transaction {

    private Long id;
    private Long transactionId;
    private boolean paymentAcknowledgement;
    private Booking booking;
    private PaymentOption paymentOption;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(final PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public boolean isPaymentAcknowledgement() {
        return paymentAcknowledgement;
    }

    public void setPaymentAcknowledgement(final boolean paymentAcknowledgement) {
        this.paymentAcknowledgement = paymentAcknowledgement;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final Long transactionId) {
        this.transactionId = transactionId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(final Booking booking) {
        this.booking = booking;
    }
}
