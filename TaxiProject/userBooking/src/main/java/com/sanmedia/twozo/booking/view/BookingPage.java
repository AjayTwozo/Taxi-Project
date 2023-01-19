package com.sanmedia.twozo.booking.view;

import com.sanmedia.twozo.booking.controller.BookingController;
import com.sanmedia.twozo.booking.model.*;
import com.sanmedia.twozo.transaction.view.TransactionPage;
import com.sanmedia.twozo.user.model.Customer;
import com.sanmedia.twozo.user.model.Driver;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
/**
 * Displays all pertaining things to the Booking functionalities for Customers and Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingPage {

    private static final Scanner INPUT = new Scanner(System.in);
    private static final BookingController BOOKING_CONTROLLER = new BookingController();
    private static final TransactionPage TRANSACTION_PAGE = new TransactionPage();

    /**
     * <p>
     *     Acquires {@link Location} details from the database.
     * </p>
     *
     * @return a {@link List} containing all of {@link Location} details.
     * @see Collection
     */
    public List<Location> getLocationInfo() {
        return BOOKING_CONTROLLER.getLocationInfo();
    }

    /**
     * <p>
     *     Inserts {@link Fare} by acquiring Customer's ID.
     *     Also, acts as a hub and passes necessary values to the related functions.
     * </p>
    */
    public void openBookingHub() {
        final Customer customer = new Customer();
        final Fare fare = new Fare();

        System.out.print("Please enter Customer ID : ");
        final long customerId = INPUT.nextLong();

        System.out.println("Available Zones : ");

        for (final Location locationObject : getLocationInfo()) {
            System.out.println(locationObject.getId() + "." + " " + locationObject.getZone());
        }

        System.out.print("Please enter your Pickup Point ID : ");
        final long pickPointId = INPUT.nextLong();

        System.out.print("Please enter your Drop Point ID : ");
        final long dropPointId = INPUT.nextLong();

        System.out.print("Please enter the Distance : ");
        final double distance = INPUT.nextDouble();
        final Location pickupLocation = new Location();
        final Location dropLocation = new Location();

        customer.setId(customerId);
        pickupLocation.setId(pickPointId);
        dropLocation.setId(dropPointId);
        fare.setCustomer(customer);
        fare.setPickupPoint(pickupLocation);
        fare.setDropPoint(dropLocation);
        fare.setDistance(distance);
        final long fareId = BOOKING_CONTROLLER.insertFareDetails(fare);

        fare.setId(fareId);
        final List<ServiceFare> serviceFareList =  BOOKING_CONTROLLER.calculateFares(distance);
        final long serviceId = acquireService(serviceFareList);
        final double totalFare = getTotalFare(serviceFareList, serviceId);
        final Driver driver = getDriverAvailability(serviceId, pickPointId);

        displayDriverInfo(driver);
        closeBooking(driver.getId(), fare, totalFare);
    }

    /**
     * <p>
     *     Acquires {@link Service} details from the database.
     * </p>
     *
     * @return a {@link List} containing all of {@link Service} details.
     * @see Collection
     */
    public List<Service> getServiceInfo() {
        return BOOKING_CONTROLLER.getServiceInfo();
    }

    /**
     * <p>
     *     Displays {@link ServiceFare}'s details. Enables, Customers to choose their choice of Service.
     * </p>
     *
     * @param serviceFareList {@link List}, containing {@link ServiceFare} which holds each Service's fare.
     * @return the {@link Customer}'s choice of Service, which is mandatory in assigning {@link Driver}.
     */
    private long acquireService(final List<ServiceFare> serviceFareList) {

        for (final ServiceFare serviceFare : serviceFareList) {
            System.out.println(new StringBuffer().append(serviceFare.getService().getId()).append(".").
                    append(" ").append(serviceFare.getService().getName()).append(" ").
                    append(serviceFare.getBooking().getTotalFare()));
        }
        System.out.println(new StringBuffer("Please choose a service from above!").append('\n').
                append("Enter your choice : "));
        final long choice = INPUT.nextLong();

        if (choice == 1) {
            System.out.println("----------------------------------------------");
            System.out.println("You have chosen Mini Service!");
        } else if (choice == 2) {
            System.out.println("----------------------------------------------");
            System.out.println("You have chosen Sedan Service!");
        } else if (choice == 3) {
            System.out.println("----------------------------------------------");
            System.out.println("You have chosen Prime Service!");
        } else {
            System.out.println("Please enter above mentioned choices only!");
        }
        return choice;
    }

    /**
     * <p>
     *     Determines Journey's fare based on the {@link Service} chosen by the {@link Customer}.
     * </p>
     *
     * @param serviceFareList {@link List}, containing {@link ServiceFare} which holds each {@link Service}'s fare.
     * @param serviceId {@link Long}, indicates Customer's choice of {@link Service}.
     * @return total fare for the Journey, being used to display to {@link Customer}.
     */
    private double getTotalFare(final List<ServiceFare> serviceFareList, final Long serviceId) {

        for (ServiceFare serviceFare : serviceFareList) {

            if (serviceId.equals(serviceFare.getService().getId())) {
                final double totalFare = serviceFare.getBooking().getTotalFare();

                System.out.println("Your Fare : " + totalFare);
            }
        }
        return 0;
    }

    /**
     * <p>
     *     Assigns a {@link Driver} based on Customer's Pick-up Location and choice of Service.
     * </p>
     *
     * @param serviceId {@link Long}, determines Customer's choice of Service.
     * @param locationId {@link Long}, determines Customer's choice of Location.
     * @return a {@link Driver}, whose current predicaments are matching with Customer's predicaments.
     */
    private Driver getDriverAvailability(final Long serviceId, final Long locationId) {
        final Driver driver = BOOKING_CONTROLLER.getDriverAvailability(serviceId, locationId);

        if (driver == null) {
            System.out.println("Driver's Currently unavailable at the requested location. Please try again! ");
            openBookingHub();
        }
        return driver;
    }

    /**
     * <p>
     *     Displays {@link Driver} details to the Customer.
     * </p>
     *
     * @param driver {@link Driver}, holds details mandatory for Communication.
     */
    private void displayDriverInfo(final Driver driver) {
        System.out.println("----------------------------------------------");
        System.out.println(new StringBuffer("Driver's Contact Information : ").append('\n').append("Name : ").
                append(driver.getName()).append('\n').append("Mobile Number : ").append(driver.getMobileNumber()).
                append('\n').append("Email ID : ").append(driver.getEmailId()).append('\n').
                append("Registration Number : ").append(driver.getRegistrationNumber()));
    }

    /**
     * <p>
     *     Inserts {@link Booking}, and prints ID once successful.
     *     Based on Customer's confirmation, updates Driver's location, then, proceeds to {@link TransactionPage}.
     * </p>
     *
     * @param driverId {@link Long}, whose com.TaxiProject.driver to {@link Customer}.
     * @param fare {@link Fare}, holds generated ID, drop {@link Location} ID.
     * @param totalFare {@link Double}, Journey's total fare being used in Insertion.
     */
    private void closeBooking(final Long driverId, final Fare fare, final Double totalFare) {
        final Booking booking = new Booking();
        final Driver driver = new Driver();

        driver.setId(driverId);
        fare.setId(fare.getId());
        booking.setDriver(driver);
        booking.setFare(fare);
        booking.setTotalFare(totalFare);
        final long bookingId = BOOKING_CONTROLLER.insertBooking(booking);

        System.out.println("----------------------------------------------");
        System.out.println(new StringBuffer ("Booking Confirmed!").append('\n').append("Your Booking ID is No. ").
                append(bookingId));
        System.out.println("----------------------------------------------");
        System.out.println("Your journey is completed. Please Confirm 1. Yes 2. No");
        final long choice = INPUT.nextLong();

        if (choice == 1) {
            BOOKING_CONTROLLER.updateDriverId(fare.getDropPoint().getId());
            TRANSACTION_PAGE.insertTransaction(bookingId, choice);
        } else if (choice == 2) {
            TRANSACTION_PAGE.insertTransaction(bookingId, choice);
        } else {
            System.out.println("Please enter above mentioned choices only!");
        }
    }
}