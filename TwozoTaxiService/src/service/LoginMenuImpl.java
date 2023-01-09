package service;

/**
 * Acquires credentials from the users
 *
 * @author Ajay
 * @version 1.0
 */
public class LoginMenuImpl implements LoginMenu {
    /**
     * Enables the users to type their mobile number
     *
     * @param mobileNumber of the user
     * @return mobile number of the user
     */
    public String typeMobileNo(final String mobileNumber) {
        return mobileNumber;
    }

    /**
     * Enables the users to type their password
     *
     * @param password of the user
     * @return password of the user
     */
    public String typePassword(final String password) {
        return password;
    }

    public String typeRegistrationNumber(final String registrationNumber) {
        return registrationNumber;
    }
}