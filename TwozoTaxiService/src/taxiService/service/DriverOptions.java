package taxiService.service;

import driver.login.LoginAuthentication;
import driver.signUp.SignUpAuthentication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverOptions {
    private static final Scanner DRIVER_INPUT = new Scanner(System.in);
    private static final LoginAuthentication LOGIN_MENU = new LoginAuthentication();
    private static final SignUpAuthentication SIGNUP_MENU = new SignUpAuthentication();

    /**
     * Shows users their options
     */
    public void driverOptions() {
        System.out.println("Enter your choice :" + '\n' + "1.Login 2.Signup");
        final int driverOption = DRIVER_INPUT.nextInt();
        final int option = driverOption;

        switch (option) {
        case 1 -> LOGIN_MENU.printLoginInfo();
        case 2 -> SIGNUP_MENU.printSignUpInfo();
        }

        try {

            if (driverOption > 2) {
                throw new NumberFormatException();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Enter above mentioned options please");
            driverOptions();
        }
    }
}
