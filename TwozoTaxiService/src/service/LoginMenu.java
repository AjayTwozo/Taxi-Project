package service;

/**
 * Displays users the LoginMenu to put in their credentials
 *
 * @author @Ajay
 * @version 1.0
 */
public interface LoginMenu {
    String typeMobileNo(final String mobileNumber);

    String typePassword(final String password);

    String typeRegistrationNumber(final String registrationNumber);
}