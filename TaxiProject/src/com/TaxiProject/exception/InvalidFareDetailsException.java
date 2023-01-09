package com.TaxiProject.exception;

public class InvalidFareDetailsException extends CustomException {

    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public InvalidFareDetailsException(final String customMessage) {
        super(customMessage);
    }
}
