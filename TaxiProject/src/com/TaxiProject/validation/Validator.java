package com.TaxiProject.validation;

/**
 * Validator of mobile number, name, password
 *
 * @author Ajay
 * @version 1.0
 */
public class Validator {

    /**
     * Inputs required to validate a mobile number
     *
     * @param mobileNumber mobile number of the user
     * @return mobile number of the user
     */
    public boolean validateMobileNumber(final String mobileNumber) {
        return mobileNumber.matches("(0/91)?[6-9][0-9]{9}");
    }

    /**
     * Inputs required to validate a name
     *
     * @param name name of the user
     * @return name of the user
     */
    public boolean validateName(final String name) {
        return name.matches("[a-zA-z]{2,16}");
    }

    /**
     * Inputs required to validate a password
     *
     * @param password password of the user
     * @return password of the user
     */
    public boolean validatePassword(final String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%^&-+=()])(?=\\S+$).{8,20}");
    }

    /**
     * Inputs required to validate registration number
     *
     * @param registration registration of the driver
     * @return registration of the driver
     */
    public boolean validateRegistration(final String registration) {
        return registration.matches("^[a-zA-z]{2}[0-9]{2}[a-zA-z]{1,2}[0-9]{4}$$");
    }

    /**
     * Inputs required to validate pin code
     *
     * @param pinCode pin code of the user/driver
     * @return registration of the user/driver
     */
    public boolean validatePinCode(final int pinCode) {
        return pinCode > 99999 & pinCode < 1000000;
    }
}