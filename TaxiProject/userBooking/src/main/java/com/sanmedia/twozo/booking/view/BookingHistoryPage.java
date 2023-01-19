package com.sanmedia.twozo.booking.view;

import com.sanmedia.twozo.booking.controller.BookingController;
import com.sanmedia.twozo.booking.model.Booking;
import com.sanmedia.twozo.user.model.Customer;
import com.sanmedia.twozo.user.model.Driver;

import java.util.Scanner;

/**
 * Displays customers and drivers their com.TaxiProject.booking history of the Platform
 *
 * @author Ajay
 * @version 1.0
 * @see Booking
 * @see Customer
 * @see Driver
 */
public class BookingHistoryPage {

    private static final Scanner INPUT = new Scanner(System.in);
    private static final BookingController BOOKING_CONTROLLER = new BookingController();

    /**
     * <p>
     *     Retrieves & displays Customer's com.TaxiProject.booking history based on their ID
     * </p>
     */
    public void displayCustomerHistory() {
        System.out.print("Please enter Customer ID : ");
        final long customerId = INPUT.nextLong();

        for (Booking booking :  BOOKING_CONTROLLER.getCustomerHistory(customerId)) {
            System.out.println(new StringBuffer("Booking ID : ").append(booking.getId()).append(",").append(" ").
                    append("Driver ID : ").append(booking.getDriver().getId()).append(",").append(" ").
                    append("Pickup Location ID : ").append(booking.getFare().getPickupPoint().getId()).append(",").append(" ").
                    append("Drop Location ID : ").append(booking.getFare().getDropPoint().getId()).append(",").append(" ").
                    append("Distance : ").append(booking.getFare().getDistance()).append(" KM,").append(" ").
                    append("Total Fare : ").append(booking.getTotalFare()).append(" Rs."));
        }
    }

    /**
     * <p>
     *     Retrieves and displays Driver's com.TaxiProject.booking history based on their ID provided through Scanner
     * </p>
     */
    public void displayDriverHistory() {
        System.out.print("Please enter Driver ID : ");
        final long driverId = INPUT.nextLong();

        for (Booking booking : BOOKING_CONTROLLER.getDriverHistory(driverId)) {
            System.out.println(new StringBuffer("Booking ID : ").append(booking.getId()).append(",").append(" ").
                    append("Driver ID : ").append(booking.getDriver().getId()).append(",").append(" ").
                    append("Pickup Location ID : ").append(booking.getFare().getPickupPoint().getId()).append(",").append(" ").
                    append("Drop Location ID : ").append(booking.getFare().getDropPoint().getId()).append(",").append(" ").
                    append("Distance : ").append(booking.getFare().getDistance()).append(" KM,").append(" ").
                    append("Total Fare : ").append(booking.getTotalFare()).append(" Rs."));
        }
    }
}