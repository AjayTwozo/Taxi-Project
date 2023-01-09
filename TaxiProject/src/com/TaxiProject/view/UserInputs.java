package com.TaxiProject.view;

import com.TaxiProject.validation.Validator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Acquires inputs from platform users undergoes the process of validation.
 *
 * @author Ajay
 * @version 1.0
 * @see UserInputs
 */
public class UserInputs {

    private static final Scanner INPUT = new Scanner(System.in);
    private static final Validator VALIDATOR = new Validator();
    private String password;

    /**
     * Enables users to enter their name.
     *
     * @return a name of the user.
     */
    String getName() {
        System.out.print("Type your Name : ");
        final String name = INPUT.next();

        if (!VALIDATOR.validateName(name)) {
            System.out.println("Enter a valid name!");

            return getName();
        }
        return name;
    }

    /**
     * Enables users to enter their mobile number.
     *
     * @return a mobile number of the user.
     */
    String getMobileNumber() {
        System.out.print("Type your MobileNo : ");
        final String mobileNumber = INPUT.next();

        if (!VALIDATOR.validateMobileNumber(mobileNumber)) {
            System.out.println("Number you entered is invalid!");

            return getMobileNumber();
        }
        return mobileNumber;
    }

    /**
     * Enables users to enter their email.
     *
     * @return an email of the user.
     */
    String getEmailId() {
        System.out.print("Type your Email ID : ");
        final String emailId = INPUT.next();

        return emailId;
    }

    /**
     * Enables users to enter their password and which is then stored in a decrypted format.
     *
     * @return a password of the user in decrypted format.
     */
    String getPassword() {
        System.out.print("Type your password : ");
        password = INPUT.next();
        String encryptedPassword = null;

        if (!VALIDATOR.validatePassword(password)) {
            System.out.println("Invalid password!");

            return getPassword();
        }
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();
            final StringBuilder stringBuilder = new StringBuilder();

            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = stringBuilder.toString();
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return encryptedPassword;
    }

    /**
     * Enables users to enter their input. Only if, matches with password entered input's validated
     *
     * @return a confirmed password of the user
     */
    String getConfirmPassword() {
        System.out.print("Confirm Password : ");
        final String confirmPassword = INPUT.next();

        if (!password.equals(confirmPassword)) {
            System.out.println("Password not matching!");

            return getConfirmPassword();
        }
        return confirmPassword;
    }
}