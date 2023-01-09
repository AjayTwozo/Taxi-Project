package com.TaxiProject.view;

import com.TaxiProject.controller.BookingController;
import com.TaxiProject.model.Customer;
import com.TaxiProject.model.Fare;
import com.TaxiProject.model.Location;
import com.TaxiProject.model.ServiceFare;
import com.TaxiProject.model.Service;
import com.TaxiProject.model.Driver;
import com.TaxiProject.model.Booking;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
/**
 * Displays all pertaining things to the Booking service for Customers and Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public class BookingPage {

    private static final Scanner INPUT = new Scanner(System.in);
    private static final BookingController BOOKING_CONTROLLER = new BookingController();
    private static final TransactionPage TRANSACTION_PAGE = new TransactionPage();

    /**
     * Acquires Location details from the database
     *
     * @return List containing Location details
     */
    List<Location> getLocationInfo() {
        return BOOKING_CONTROLLER.getLocationInfo();
    }

    /**
     * Acts as a hub and passes necessary values to the related functions
     */
    void bookingHub() {
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
        final List<ServiceFare> serviceFareList = calculateFares(distance);
        final long serviceId = acquireService(serviceFareList);
        final double totalFare = getTotalFare(serviceFareList, serviceId);
        final long driverId = assignDriver(serviceId, pickPointId);

        closeBooking(driverId, fare, totalFare);
    }

    /**
     * Acquires Service details from the database
     *
     * @return List containing Service details
     */
    List<Service> getAllServiceInfo() {
        return BOOKING_CONTROLLER.getServiceInfo();
    }

    /**
     * Calculates the Fare using Distance and Price per KM which is acquired from Data base
     *
     * @param distance distance, passed from Hub which was previously entered by Customer through Scanner
     * @return List containing Fares of different Services
     */
    private List<ServiceFare> calculateFares(final Double distance) {
        return BOOKING_CONTROLLER.calculateFares(distance);
    }

    /**
     * Iterates Service's fares and enables Customers to choose the service of their choice
     *
     * @param serviceFareList serviceFareList, passed from Hub
     * @return Service choice of the Customer
     */
    private long acquireService(final List<ServiceFare> serviceFareList) {

        for (final ServiceFare serviceFare : serviceFareList) {
            System.out.println(new StringBuilder().append(serviceFare.getService().getId()).append(".").
                    append(" ").append(serviceFare.getService().getName()).append(" ").
                    append(serviceFare.getBooking().getTotalFare()));
        }
        System.out.println(new StringBuilder("Please choose a service from above!").append('\n').
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
     * Selects Total Fare based on the Service chosen by the Customer
     *
     * @param serviceFareList serviceFareList, passed from Hub
     * @param serviceId serviceId, passed from Hub
     * @return Total Fare for the Journey
     */
    private double getTotalFare(final List<ServiceFare> serviceFareList, final Long serviceId) {
        final ListIterator<ServiceFare> fareIterator = serviceFareList.listIterator();
        final double miniFare = fareIterator.next().getBooking().getTotalFare();
        final double sedanFare = fareIterator.next().getBooking().getTotalFare();
        final double primeFare = fareIterator.next().getBooking().getTotalFare();

        if (serviceId == 1) {
            System.out.println("Your Fare : " + miniFare);

            return miniFare;
        } else if (serviceId == 2) {
            System.out.println("Your Fare : " + sedanFare);

            return sedanFare;
        } else if (serviceId == 3) {
            System.out.println("Your Fare : " + primeFare);

            return primeFare;
        }
        return 0;
    }

    /**
     * Assigns a Driver based on Customer's choice of Location & Service chosen by them
     * If driver's unavailable, reverts to booking hub
     *
     * @param serviceId serviceId, passed from the Hub
     * @param locationId locationId, passed from the Hub
     * @return Driver's id
     */
    private long assignDriver(final Long serviceId, final Long locationId) {
        final Driver driver = new Driver();
        final Service service = new Service();
        final Location location = new Location();

        service.setId(serviceId);
        location.setId(locationId);
        driver.setService(service);
        driver.setLocation(location);
        final long driverId = BOOKING_CONTROLLER.assignDriver(driver);

        if (driverId == 0) {
            System.out.println("Driver's Currently unavailable at the requested location. Please try again! ");
            bookingHub();
        } else {
            displayDriverInfo(driver);
        }
        return driverId;
    }

    /**
     * Displays driver's info to Customers
     *
     * @param driver Driver, passed from assignDriver function
     */
    private void displayDriverInfo(final Driver driver) {
        System.out.println("----------------------------------------------");
        System.out.println(new StringBuilder("Driver's Contact Information : ").append('\n').append("Name : ").
                append(driver.getName()).append('\n').append("Mobile Number : ").append(driver.getMobileNumber()).
                append('\n').append("Email ID : ").append(driver.getEmailId()).append('\n').
                append("Registration Number : ").append(driver.getRegistrationNumber()));
    }

    /**
     * Inserts booking then immediately proceeds to transaction Page
     *
     * @param driverId driverId, passed from Hub
     * @param fare Fare, passed from Hub
     * @param totalFare totalFare, passed from Hub
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
        System.out.println(new StringBuilder("Booking Confirmed!").append('\n').append("Your Booking ID is No. ").
                append(bookingId));
        System.out.println("----------------------------------------------");
        System.out.println("Your journey is completed. Please Confirm 1. Yes 2. No");
        updateDriverId(fare.getDropPoint().getId());
        TRANSACTION_PAGE.insertTransaction(bookingId);
    }

    /**
     * Updates driver's location once the Journey ends
     *
     * @param locationId location ID, being wrapped
     * @return being passed to Controller
     */
    long updateDriverId(final Long locationId) {
        return BOOKING_CONTROLLER.updateDriverId(locationId);
    }
}