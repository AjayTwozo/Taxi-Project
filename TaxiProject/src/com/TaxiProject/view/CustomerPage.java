package com.TaxiProject.view;

import com.TaxiProject.controller.CustomerController;
import com.TaxiProject.model.Customer;
import com.TaxiProject.model.User;

import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Displays all pertaining things to the {@link Customer's} functionalities to the {@link Customer}
 *
 * @author Ajay
 * @version 1.0
 */
public class CustomerPage {

    private static final UserInputs USER_INPUTS = new UserInputs();
    private static final CustomerController CUSTOMER_CONTROLLER = new CustomerController();
    private static final Scanner INPUT = new Scanner(System.in);

    /**
     * <p>
     *     Registers a {@link Customer} based on their User ID.
     * </p>
     *
     * @return that Customer's id, being displayed upon successful insertion.
     * @see User
     */
    long registerCustomer() {
        System.out.print("Please enter User ID : ");
        final long userId = INPUT.nextLong();
        final long id = CUSTOMER_CONTROLLER.insert(userId);

        System.out.println("Registration Successful! Welcome!!" + '\n' + "Generated ID : " + id);

        return id;
    }

    /**
     * <p>
     *     Acquires and displays {@link Customer}'s info from database based on their ID.
     * </p>
     *
     * @return a {@link Customer}, containing all the details.
     */
    Customer getCustomer() {
        System.out.println("Enter ID Number : ");
        final long idNumber = INPUT.nextInt();
        final Customer customerControllerGet = CUSTOMER_CONTROLLER.get(idNumber);

        if (customerControllerGet.getName() != null) {
            System.out.println(new StringBuilder("Name : ").append(customerControllerGet.getName()).append("\n").
                    append("Mobile Number : ").append(customerControllerGet.getMobileNumber()).append("\n").
                    append("Email ID : ").append(customerControllerGet.getEmailId()));
            System.out.println("Record Retrieved Successfully!");
        } else {
            System.out.println("Entered key has no record!");
        }
        return customerControllerGet;
    }

    /**
     * <p>
     *     Acquires every Customer's info from database and displays the details.
     * </p>
     *
     * @return a {@link List} containing Customers info.
     * @see Collection
     */
    Collection<Customer> getAllCustomer() {
        final Collection<Customer> customerControllerGet = CUSTOMER_CONTROLLER.getAll();

        for (final Customer customer : customerControllerGet) {
            System.out.println(new StringBuilder("ID Number : ").append(customer.getId()).append("\n").
                    append("Name : ").append(customer.getName()).append("\n").
                    append("Mobile Number : ").append(customer.getMobileNumber()).append("\n").
                    append("Email ID : ").append(customer.getEmailId()));
        }
        return customerControllerGet;
    }

    /**
     * <p>
     * Removes Customer's info from the database based on their ID.
     * </p>
     * @return whether removed successfully, based on the results prints a message.
     */
    boolean removeCustomer() {
        System.out.println("Enter ID Number : ");
        final long id = INPUT.nextInt();
        final boolean removeResult = CUSTOMER_CONTROLLER.remove(id);
        final String message = removeResult ? "Record has been removed successfully!" :
                "Entered key has no record! Enter a valid ID!";

        System.out.println(message);

        return removeResult;
    }

    /**
     * <p>
     *     Updates Customer's info based on their ID.
     * </p>
     *
     * @return whether updated successfully, based on the results prints a message.
     */
    boolean updateCustomer() {
        System.out.println("Enter ID Number : ");
        final long idNumber = INPUT.nextInt();
        final Customer customerControllerGet = CUSTOMER_CONTROLLER.get(idNumber);

        if (idNumber == customerControllerGet.getId()) {
            final Customer customer = new Customer();

            customer.setId(idNumber);
            System.out.println("Do you want to update your name? 1. YES 2. NO");
            final int nameChoice = INPUT.nextInt();

            switch (nameChoice) {
                case 1 -> customer.setName(USER_INPUTS.getName());
                case 2 -> customer.setName(null);
                default -> {
                    System.out.println("Yes or No choices only!");
                    updateCustomer();
                }
            }
            System.out.println("Do you want to update your Mobile Number? 1. YES 2. NO");
            final int mobileNumberChoice = INPUT.nextInt();

            switch (mobileNumberChoice) {
                case 1 -> customer.setMobileNumber(USER_INPUTS.getMobileNumber());
                case 2 -> customer.setMobileNumber(null);
                default -> {
                    System.out.println("Yes or No choices only!");
                    updateCustomer();
                }
            }
            System.out.println("Do you want to update your Email Id? 1. YES 2. NO");
            final int pinCodeChoice = INPUT.nextInt();

            switch (pinCodeChoice) {
                case 1 -> customer.setEmailId(USER_INPUTS.getEmailId());
                case 2 -> customer.setEmailId(null);
                default -> {
                    System.out.println("Yes or No choices only!");
                    updateCustomer();
                }
            }
            final boolean updateResult = CUSTOMER_CONTROLLER.update(customer);
            System.out.println("Updated Successfully!");

            return updateResult;
        } else {
            System.out.println("Entered key not found!");
        }
        return false;
    }
}