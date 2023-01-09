package validation;

/**
 * Validation of mobile number, name, password
 *
 * @author Ajay
 * @version 1.0
 */
public class ValidateInputs {
    /**
     * Inputs required to validate a mobile number
     *
     * @param mobileNumber of the user
     * @return mobile number of the user
     */
    public boolean validateMobileNo(final String mobileNumber) {
        return mobileNumber.matches("(0/91)?[6-9][0-9]{9}");
    }

    /**
     * Inputs required to validate a name
     *
     * @param name of the user
     * @return name of the user
     */
    public boolean validateName(final String name) {
        return name.matches("[a-zA-z]{4,15}");
    }

    /**
     * Inputs required to validate a password
     *
     * @param password of the user
     * @return password of the user
     */
    public boolean validatePassword(final String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%^&-+=()])(?=\\S+$).{8,20}");
    }

    public boolean validateRegistration(final String registration) {
        return registration.matches("^[A-Z]{2}[0-9]{2}[A-HJ-NP-Z]{1,2}[0-9]{4}$$");
    }
}