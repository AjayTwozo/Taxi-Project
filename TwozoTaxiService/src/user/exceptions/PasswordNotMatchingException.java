package user.exceptions;

/**
 * Exception happens when password doesn't match
 *
 * @author Ajay
 * @version 1.0
 */
public class PasswordNotMatchingException extends RuntimeException {
    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public PasswordNotMatchingException(String customMessage) {
        super(customMessage);
    }
}