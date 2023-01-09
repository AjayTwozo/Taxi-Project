import taxiService.service.DriverOptions;
import taxiService.service.UserOptions;

import java.util.Scanner;

public class WelcomePage {
    private static final UserOptions USER_OPTIONS = new UserOptions();
    private static final DriverOptions DRIVER_OPTIONS = new DriverOptions();
    private static final Scanner WELCOME_INPUT = new Scanner(System.in);

    public static void welcomePage() {
        System.out.println("Welcome to Twozo Taxi Service!");
        System.out.println("Enter your choice :" + '\n' + "1.User 2.Driver");
        final int welcomeOption = WELCOME_INPUT.nextInt();

        final int option = welcomeOption ;

        switch (option) {
            case 1 -> USER_OPTIONS.userOptions();
            case 2 -> DRIVER_OPTIONS.driverOptions();
        }
    }
}