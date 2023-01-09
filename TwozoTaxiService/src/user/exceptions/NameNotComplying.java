package user.exceptions;

/**
 * Exception happens when name terms are not complied
 *
 * @author Ajay
 * @version 1.0
 */
public class NameNotComplying extends RuntimeException  {
    /**
     * Constructor being used to print custom message
     *
     * @param customMessage of the exception
     */
    public NameNotComplying(String customMessage) {
        super(customMessage);
    }
}
