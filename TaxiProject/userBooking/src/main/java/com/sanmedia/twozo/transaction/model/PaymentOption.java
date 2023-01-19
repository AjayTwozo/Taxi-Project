package com.sanmedia.twozo.transaction.model;

/**
 * Payment Option pattern
 * Contains id, mode
 *
 * @author Ajay
 * @version 1.0
 */
public class PaymentOption {

    private Long id;
    private String mode;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(final String mode) {
        this.mode = mode;
    }
}
