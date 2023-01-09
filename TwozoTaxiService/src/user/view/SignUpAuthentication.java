package user.view;

import user.exceptions.NameNotComplying;
import user.exceptions.PasswordNotMatchingException;
import service.SignUpMenuImpl;
import validation.ValidateInputs;

import java.util.Scanner;

/**
 * Authentication of SignUp Process
 * Users mobile number, name, password are processed
 *
 * @author Ajay
 * @version 1.0
 */
public class SignUpAuthentication {
    private static final Scanner SIGNUP_INPUT = new Scanner(System.in);
    private static final SignUpMenuImpl SIGNUP_MENU = new SignUpMenuImpl();
    private static final ValidateInputs VALIDATE_INPUTS = new ValidateInputs();

    /**
     * Processes the inputs that are entered by the users
     * Exceptions occurs when users inputs are invalid
     */
    public static void printSignUpInfo() {
        System.out.println("Type your Name :");
        final String name = SIGNUP_INPUT.next();

        SIGNUP_MENU.setName(name);
        final StringBuilder stringBuilderName = new StringBuilder("Name : ");

        stringBuilderName.append(SIGNUP_MENU.getName());
        System.out.println(stringBuilderName);

        try {

            if (!VALIDATE_INPUTS.validateName(name)) {
                throw new NameNotComplying("Name is either too short or large");
            }
        } catch (NameNotComplying e) {
            System.out.println("Name is either too short or large");
            printSignUpInfo();
        }
        System.out.println("Type your MobileNo :");
        final String mobileNumber = SIGNUP_INPUT.next();

        if (VALIDATE_INPUTS.validateMobileNo(mobileNumber)) {
            SIGNUP_MENU.setMobileNo(mobileNumber);
            final StringBuilder stringBuilderMobileNo = new StringBuilder("Mobile No :");

            stringBuilderMobileNo.append(SIGNUP_MENU.getMobileNo());
            System.out.println(stringBuilderMobileNo);
        } else {
            System.out.println("Type numbers only");
            printSignUpInfo();
        }
        System.out.println("Type your Password :");
        final String password = SIGNUP_INPUT.next();

        if (VALIDATE_INPUTS.validatePassword(password)) {
            SIGNUP_MENU.setPassword(password);
            final StringBuilder stringBuilderPassword = new StringBuilder("Password is :");

            stringBuilderPassword.append(SIGNUP_MENU.getPassword());
            System.out.println(stringBuilderPassword);
        } else {
            System.out.println("Invalid password");
            printSignUpInfo();
        }
        System.out.println("Re-type your Password :");
        final String retypePassword = SIGNUP_INPUT.next();

        SIGNUP_MENU.setConfirmPassword(retypePassword);
        final StringBuilder stringBuilderRetypePassword = new StringBuilder();

        stringBuilderRetypePassword.append("Confirm Password :");
        stringBuilderRetypePassword.append(SIGNUP_MENU.getConfirmPassword());
        System.out.println(stringBuilderRetypePassword);

        try {

            if (!SIGNUP_MENU.getPassword().equals(SIGNUP_MENU.getConfirmPassword())) {
                throw new PasswordNotMatchingException("Password not matching");
            }
        } catch (PasswordNotMatchingException e) {
            System.out.println("Password not matching");
            printSignUpInfo();
        }
    }
}