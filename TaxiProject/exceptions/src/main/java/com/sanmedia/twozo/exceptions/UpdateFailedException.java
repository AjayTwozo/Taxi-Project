package com.sanmedia.twozo.exceptions;

public class UpdateFailedException extends CustomException {

    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public UpdateFailedException(final String customMessage) {
        super(customMessage);
    }
}
