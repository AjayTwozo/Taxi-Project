package taxiService.service;

import user.view.LoginAuthentication;
import user.view.SignUpAuthentication;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Enables users to perform their preferred option
 * Login, Signup
 *
 * @author Ajay
 * @version 1.0
 */
public class UserOptions {
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static final LoginAuthentication LOGIN_AUTHENTICATION = new LoginAuthentication();
    private static final SignUpAuthentication SIGN_UP_AUTHENTICATION = new SignUpAuthentication();

    /**
     * Shows users their options
     */
    public static void userOptions() {
        System.out.println("Enter your choice :" + '\n' + "1.Login 2.Signup");
        final int userOption = USER_INPUT.nextInt();

        final int option = userOption;

        switch (option) {
        case 1 -> LOGIN_AUTHENTICATION.printLoginInfo();
        case 2 -> SIGN_UP_AUTHENTICATION.printSignUpInfo();
        }

        try {

            if (userOption > 2) {
                throw new NumberFormatException();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Enter above mentioned options please");
            userOptions();
        }
    }
}