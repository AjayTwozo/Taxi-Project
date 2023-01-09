package com.TaxiProject.view;

import com.TaxiProject.controller.BookingController;
import com.TaxiProject.model.Booking;

import java.util.Scanner;

/**
 * Displays customers and drivers their booking history
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingHistoryPage {

    private static final Scanner INPUT = new Scanner(System.in);
    private static final BookingController BOOKING_CONTROLLER = new BookingController();

    /**
     * Iterates and displays Customer's bookings based on their ID provided through Scanner
     *
     */
    void iterateCustomerHistory() {
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
     * Iterates and displays Driver's bookings based on their ID provided through Scanner
     */
    void iterateDriverHistory() {
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