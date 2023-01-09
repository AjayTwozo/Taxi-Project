package com.TaxiProject.exception;

public class LoginFailedException extends CustomException {

    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public LoginFailedException(final String customMessage) {
        super(customMessage);
    }
}
