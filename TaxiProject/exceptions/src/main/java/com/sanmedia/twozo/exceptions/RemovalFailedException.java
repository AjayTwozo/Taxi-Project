package com.sanmedia.twozo.exceptions;

public class RemovalFailedException extends CustomException {

    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public RemovalFailedException(final String customMessage) {
        super(customMessage);
    }
}
