package com.TaxiProject.exception;

public class SignUpFailedException extends CustomException {

    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public SignUpFailedException(final String customMessage) {
        super(customMessage);
    }
}
