package com.sanmedia.twozo.exceptions;

public class InsertionFailedException extends CustomException {

    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public InsertionFailedException(final String customMessage) {
        super(customMessage);
    }
}
