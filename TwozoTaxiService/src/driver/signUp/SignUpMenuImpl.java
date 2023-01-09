package driver.signUp;

import user.exceptions.PasswordNotMatchingException;
import validation.ValidateInputs;

import java.util.Scanner;

public class SignUpMenuImpl implements SignUpMenu {

    private static final Scanner SIGNUP_INPUT = new Scanner(System.in);
    private static final ValidateInputs VALIDATE_INPUTS = new ValidateInputs();

    public String getRegistration() {
        final String registration = SIGNUP_INPUT.next();

        if (!VALIDATE_INPUTS.validateRegistration(registration)) {
            System.out.println("Registration number you entered is not valid!");
            return getRegistration();
        } else {
            return registration;
        }
    }

    public String getName() {
        final String name = SIGNUP_INPUT.next();

        if (!VALIDATE_INPUTS.validateName(name)) {
            System.out.println("Name you entered is not valid!");
            return getName();
        } else {
            return name;
        }
    }

    public String getMobileNumber() {
        final String mobileNumber = SIGNUP_INPUT.next();

        if (!VALIDATE_INPUTS.validateMobileNo(mobileNumber)) {
            System.out.println("Mobile number you entered is not valid!");
            return getMobileNumber();
        } else {
            return mobileNumber;
        }
    }

    public String getPassword() {
        final String password = SIGNUP_INPUT.next();

        if (!VALIDATE_INPUTS.validatePassword(password)) {
            System.out.println("Password you entered is not valid!");
            return getPassword();
        } else {
            return password;
        }
    }

    public String getConfirmPassword() {
        final String confirmPassword = SIGNUP_INPUT.next();

        try {

            if (!getPassword().equals(getConfirmPassword())) {
                throw new PasswordNotMatchingException("Password is not matching!");
            }
        } catch (PasswordNotMatchingException e) {
            System.out.println("Password is not matching!");
            return getConfirmPassword();
        }
        return confirmPassword;
    }

    /*public void getType() {
        enum Type {DELUXE_MINI, DELUXE_SEDAN, DELUXE_PRIME}

        final int typeOptions = SIGNUP_INPUT.nextInt();

        final int options = typeOptions;

            switch (options) {
            case 1 -> Type.valueOf("DELUXE_MINI");
            case 2 -> Type.valueOf("DELUXE_SEDAN");
            case 3 -> Type.valueOf("DELUXE_PRIME");
        }
    }*/
}