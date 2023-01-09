package driver.login;

import validation.ValidateInputs;

import java.util.Scanner;

/**
 * Acquires required credentials from Driver
 *
 * @author Ajay
 * @version 1.0
 */
public class LoginMenuImpl implements LoginMenu {
    private static final Scanner LOGIN_INPUT = new Scanner(System.in);
    private static final ValidateInputs VALIDATE_INPUTS = new ValidateInputs();

    /**
     * Types their vehicle's registration number
     *
     * @return vehicle's registration
     */
    public String typeRegistration() {
        System.out.println("Enter Registration Number :");
        final String registration = LOGIN_INPUT.next().trim();

        if (!VALIDATE_INPUTS.validateRegistration(registration)) {
            System.out.println("Registration Number is not valid");
            return typeRegistration();
        } else {
            return registration;
        }
    }

    /**
     * Types their registered mobile number
     *
     * @return registered mobile number
     */
    public String typeMobileNumber() {
        System.out.println("Enter Mobile Number :");
        final String mobileNumber = LOGIN_INPUT.next().trim();

        if (!VALIDATE_INPUTS.validateMobileNo(mobileNumber)) {
            System.out.println("Mobile number is not valid");
            return typeMobileNumber();
        } else {
            return mobileNumber;
        }
    }

    /**
     * Types their password
     *
     * @return password
     */
    public String typePassword() {
        System.out.println("Enter Password :");
        final String password = LOGIN_INPUT.next();

        if (!VALIDATE_INPUTS.validatePassword(password)) {
            System.out.println("Password is incorrect");
            return typePassword();
        } else {
            return password;
        }
    }
}