package com.TaxiProject.view;

import com.TaxiProject.controller.TransactionController;
import com.TaxiProject.model.Booking;
import com.TaxiProject.model.PaymentOption;
import com.TaxiProject.model.Transaction;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Displays all pertaining things to the Transaction Service for Customer & Driver
 *
 * @author Ajay
 * @version 1.0
 */
public class TransactionPage {

    private static final Scanner INPUT = new Scanner(System.in);
    private static final TransactionController TRANSACTION_CONTROLLER = new TransactionController();

    /**
     * Generates random code and acts as a supplement for Transaction ID.
     *
     * @return a Generated code
     * @see Random
     */
    private long generateCode() {
        final Random random = new Random();

        return random.nextInt(100001, 999999);
    }

    /**
     * Acquires available payment options from the database.
     *
     * @return a {@link List}, containing {@link PaymentOption}.
     * @see Collection
     */
    private List<PaymentOption> getOptions() {
        return TRANSACTION_CONTROLLER.getOptions();
    }

    /**
     * Displays all available payment options to the Customers.
     */
    private void showPaymentOptions() {
        final List<PaymentOption> paymentOptionList = getOptions();

        for (PaymentOption paymentOption : paymentOptionList) {
            System.out.println(new StringBuilder().append(paymentOption.getId()).append(".").append(" ").
                    append(paymentOption.getMode()));
        }
    }

    /**
     * Displays and acquires Customer's choice of {@link PaymentOption}.
     *
     * @return the choice of the Customer.
     */
    private long getCustomerChoice() {
        showPaymentOptions();
        System.out.println(new StringBuilder("Please choose a payment option from above!").append('\n').
                append("Enter your choice : "));
        final long choice = INPUT.nextLong();

        if (choice == 1) {
            System.out.println("----------------------------------------------");
            System.out.println("You have chosen Cash Payment!");
        } else if (choice == 2) {
            System.out.println("----------------------------------------------");
            System.out.println("You have chosen UPI Payment!");
        } else if (choice == 3) {
            System.out.println("----------------------------------------------");
            System.out.println("You have chosen In-App Payment!");
        } else {
            System.out.println("Please enter above mentioned choices only!");
        }
        return choice;
    }

    /**
     * <p>
     *     Inserts {@link Transaction} both successful and failed ones.
     * </p>
     *
     * @param bookingId {@link Long}, determines for which {@link Booking} transaction's being recorded.
     * @param choice {@link Long}, determines whether a booking's successful.
     */
    long insertTransaction(final long bookingId, final Long choice) {
        final Transaction transaction = new Transaction();
        final Booking booking = new Booking();
        final PaymentOption paymentOption = new PaymentOption();

        if (choice == 1) {
            booking.setId(bookingId);
            paymentOption.setId(getCustomerChoice());
            transaction.setPaymentOption(paymentOption);
            transaction.setBooking(booking);
            transaction.setPaymentAcknowledgement(true);
            transaction.setTransactionId(generateCode());
        } else if (choice == 2) {
            booking.setId(bookingId);
            paymentOption.setId(null);
            transaction.setPaymentOption(null);
            transaction.setBooking(booking);
            transaction.setPaymentAcknowledgement(false);
            transaction.setTransactionId(generateCode());
        }
        return TRANSACTION_CONTROLLER.insertTransaction(transaction);
    }

    /**
     * Acquires Customer's transaction history from database based on their ID.
     *
     * @return a {@link List}, containing Customer's transaction history.
     * @see Collection
     */
    List<Transaction> getCustomerHistory() {
        System.out.println("Please enter Customer ID : ");
        final long customerId = INPUT.nextLong();

        return TRANSACTION_CONTROLLER.getCustomerHistory(customerId);
    }

    /**
     * Acquires Driver's transaction history from database based on their ID.
     *
     * @return a a {@link List}, containing Driver's transaction history.
     * @see Collection
     */
    List<Transaction> getDriverHistory() {
        System.out.println("Please enter Customer ID : ");
        final long driverId = INPUT.nextLong();

        return TRANSACTION_CONTROLLER.getCustomerHistory(driverId);
    }
}