package com.sanmedia.twozo.exceptions;

public class SelectionFailedException extends CustomException {
    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public SelectionFailedException(final String customMessage) {
        super(customMessage);
    }
}
