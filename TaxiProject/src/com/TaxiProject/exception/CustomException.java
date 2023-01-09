package com.TaxiProject.exception;

/**
 * User defined exception's parent class
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomException extends RuntimeException {

    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public CustomException(final String customMessage) {
        super(customMessage);
    }
}