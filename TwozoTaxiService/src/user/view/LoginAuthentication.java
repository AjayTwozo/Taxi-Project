package user.view;

import service.LoginMenuImpl;
import validation.ValidateInputs;

import java.util.Scanner;

/**
 * Authentication of user's login process
 *
 * @author @Ajay
 * version @1.0
 */
public class LoginAuthentication {
    private static final Scanner LOGIN_INPUT = new Scanner(System.in);
    private static final LoginMenuImpl LOGIN_MENU = new LoginMenuImpl();
    private static final ValidateInputs VALIDATE_INPUTS = new ValidateInputs();

    /**
     * Processes whatever inputs that are passed by the users
     * Exceptions occurs when users inputs are invalid
     */
    public static void printLoginInfo() {
        System.out.println("Type your MobileNo :");
        final String mobileNumber = LOGIN_INPUT.next();

        if (VALIDATE_INPUTS.validateMobileNo(mobileNumber)) {
            final StringBuilder stringBuilder = new StringBuilder("Mobile No :");

            stringBuilder.append(LOGIN_MENU.typeMobileNo(mobileNumber));
            System.out.println(stringBuilder);
        } else {
            System.out.println("Please type numbers only");
            printLoginInfo();
        }
        System.out.println("Type your Password :");
        final String password = LOGIN_INPUT.next();

        if (VALIDATE_INPUTS.validatePassword(password)) {
            final StringBuilder stringBuilder = new StringBuilder("Password :");

            stringBuilder.append(LOGIN_MENU.typePassword(password));
            System.out.println(stringBuilder);
        } else {
            System.out.println("Please use CAPS, digits & special characters once at least");
            printLoginInfo();
        }
    }
}