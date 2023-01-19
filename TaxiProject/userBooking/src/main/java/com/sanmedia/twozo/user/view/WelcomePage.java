package com.sanmedia.twozo.user.view;

import com.sanmedia.twozo.booking.view.BookingHistoryPage;
import com.sanmedia.twozo.booking.view.BookingPage;
import com.sanmedia.twozo.exceptions.CustomException;
import com.sanmedia.twozo.transaction.view.TransactionPage;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Welcome page of the application being displayed and acts as a Hub for View
 *
 * @author Ajay
 * @version 1.0
 */
public class WelcomePage {

    private static final WelcomePage WELCOME_PAGE = new WelcomePage();
    private static final Scanner INPUT = new Scanner(System.in);
    private static final CustomerPage CUSTOMER_PAGE = new CustomerPage();
    private static final UserPage USER_PAGE = new UserPage();
    private static final DriverPage DRIVER_PAGE = new DriverPage();
    private static final BookingPage BOOKING_PAGE = new BookingPage();
    private static final BookingHistoryPage BOOKING_HISTORY_PAGE = new BookingHistoryPage();
    private static final TransactionPage TRANSACTION_PAGE = new TransactionPage();

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        BOOKING_PAGE.openBookingHub();
        WELCOME_PAGE.welcome();
    }

    /**
     * Enables Users to choose their affiliation to the Platform i.e. Customer or com.TaxiProject.driver
     */
    private void welcome() {

        try {

            System.out.println("Welcome to Taxi Service!");
            System.out.println("Enter your choice :" + '\n' + "1.User 2.Driver");
            final int option = INPUT.nextInt();

            switch (option) {
                case 1 -> customerOptions();
                case 2 -> displayDriverOptions();
                default -> {
                    System.out.println("Please enter above mentioned choices only!");
                    welcome();
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Please enter above mentioned choices only!");
            welcome();
        }
    }

    /**
     * Enables Customers to perform their choice of action i.e. login or sign up
     */
    private void customerOptions() {

        try {
            System.out.println("Enter your choice :" + '\n' + "1.Login 2.Signup");
            final int option = INPUT.nextInt();

            switch (option) {
                case 1 -> USER_PAGE.userLogin();
                case 2 -> USER_PAGE.userSignUp();
                default -> {
                    System.out.println("Please enter above mentioned choices only!");
                    customerOptions();
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Please enter above mentioned choices only");
            customerOptions();
        }
        displayCustomerOptions();
    }

    /**
     * Displays Customer's profile choices and enables them to perform action of their choice
     */
    private void setCustomerProfileOptions() {
        int choice;

        try {

            do {
                System.out.println("----------------------------------------------");
                System.out.println("Enter your choice :" + '\n' + "1.Register 2.Update 3.Display 4.DisplayAll 5.Remove");
                choice = INPUT.nextInt();
                System.out.println("----------------------------------------------");

                switch (choice) {
                    case 1 -> CUSTOMER_PAGE.registerCustomer();
                    case 2 -> CUSTOMER_PAGE.updateCustomer();
                    case 3 -> CUSTOMER_PAGE.getCustomer();
                    case 4 -> CUSTOMER_PAGE.getAllCustomer();
                    case 5 -> CUSTOMER_PAGE.removeCustomer();
                    default -> {
                        System.out.println("Please enter above mentioned choices only!");
                        setCustomerProfileOptions();
                    }
                }
            } while (choice != 0);
        } catch (InputMismatchException exception) {
            System.out.println("Enter above mentioned choices only");
            setCustomerProfileOptions();
        }
    }

    /**
     * Forwards to Customer's com.TaxiProject.booking page
     */
    private void setBookingPage() {
        BOOKING_PAGE.openBookingHub();
    }

    /**
     * Forwards to Customer's com.TaxiProject.booking history page
     */
    private void setCustomerBookingHistoryPage() {
        BOOKING_HISTORY_PAGE.displayCustomerHistory();
    }

    /**
     * Forwards to Customer's com.TaxiProject.transaction history page
     */
    private void setCustomerTransactionPage() {
        TRANSACTION_PAGE.getCustomerHistory();
    }

    /**
     * Display's Customer's their Menu and enables them to perform action of their choice
     */
    private void displayCustomerOptions() {
        int choice;

        try {

            do {
                System.out.println("----------------------------------------------");
                System.out.println("Welcome to our Taxi Service Page!" + '\n' + "Customer Menu : " + '\n' +
                        "1.Book-a-Ride 2.Profile 3.Booking History 4.Transactions");
                System.out.print("Enter your choice : ");
                choice = INPUT.nextInt();
                System.out.println("----------------------------------------------");

                switch (choice) {
                    case 1 -> setBookingPage();
                    case 2 -> setCustomerProfileOptions();
                    case 3 -> setCustomerBookingHistoryPage();
                    case 4 -> setCustomerTransactionPage();
                    default -> {
                        System.out.println("Please enter above mentioned choices only!");
                        setCustomerProfileOptions();
                    }
                }
            } while (choice != 0);
        } catch (Exception exception) {
            throw new CustomException("Enter above mentioned choices only");
        }
    }

    /**
     * Enables Driver to perform their choice of action i.e. login or sign up
     */
    void displayDriverOptions() {

        try {
            System.out.println("Enter your choice :" + '\n' + "1.Login 2.Signup");
            final int option = INPUT.nextInt();

            switch (option) {
                case 1 -> USER_PAGE.userLogin();
                case 2 -> USER_PAGE.userSignUp();
                default -> {
                    System.out.println("Please enter above mentioned choices only!");
                    displayDriverOptions();
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println("Please enter above mentioned choices only!");
            displayDriverOptions();
        }
        displayDriverMenuOptions();
    }

    /**
     * Forwards to Driver's com.TaxiProject.booking history page
     */
    private void setDriverBookingHistory() {
        BOOKING_HISTORY_PAGE.displayDriverHistory();
    }

    /**
     * Forwards to Driver's com.TaxiProject.transaction history page
     */
    private void setDriverTransactionPage() {
        TRANSACTION_PAGE.getDriverHistory();
    }

    /**
     * Displays Driver's their Menu and enables them to perform action of their choice
     */
    private void displayDriverMenuOptions() {
        int choice;

        try {

            do {
                System.out.println("----------------------------------------------");
                System.out.println("Welcome to our Taxi Service Page!" + '\n' + "Driver Menu : " + '\n' +
                        "1.Profile 2.Booking History 3.Transactions");
                System.out.print("Enter your choice : ");
                choice = INPUT.nextInt();
                System.out.println("----------------------------------------------");

                switch (choice) {
                    case 1 -> setDriverProfileOptions();
                    case 2 -> setDriverBookingHistory();
                    case 3 -> setDriverTransactionPage();
                    default -> {
                        System.out.println("Please enter above mentioned choices only!");
                        displayDriverMenuOptions();
                    }
                }
            } while (choice != 0);
        } catch (Exception exception) {
            throw new CustomException("Enter above mentioned choices only");
        }
    }

    /**
     * Displays Customer's profile choices and enables them to perform action of their choice
     */
    private void setDriverProfileOptions() {
        int choice;

        try {

            do {
                System.out.println("----------------------------------------------");
                System.out.println("Enter your choice :" + '\n' + "1.Register 2.Update 3.Display 4.DisplayAll 5.Remove");
                choice = INPUT.nextInt();
                System.out.println("----------------------------------------------");

                switch (choice) {
                    case 1 -> DRIVER_PAGE.registerDriver();
                    case 2 -> DRIVER_PAGE.updateDriver();
                    case 3 -> DRIVER_PAGE.getDriver();
                    case 4 -> DRIVER_PAGE.getAllDriver();
                    case 5 -> DRIVER_PAGE.removeDriver();
                    default -> {
                        System.out.println("Please enter above mentioned choices only!");
                        setDriverProfileOptions();
                    }
                }
            } while (choice != 0);
        } catch (Exception exception) {
            throw new CustomException("Enter above mentioned choices only");
        }
    }
}