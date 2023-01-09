package user.bookTaxi;

import java.util.Scanner;

/**
 * Enables users to enter location and check availability for the ride
 * Shows ride's distance & fare
 *
 * @author Ajay
 * @version 1.0
 */
public class BookRide implements BookingScreen {
    private boolean checkAvailability;
    private String location;
    private double distance;
    private final int pricePerKM = 15;

    private static final Scanner USER_INPUT = new Scanner(System.in);

    public boolean getAvailability() {
        return checkAvailability;
    }

    public void setAvailability(final boolean checkAvailability) {
        this.checkAvailability = checkAvailability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(final double distance) {
        this.distance = distance;
    }

    /**
     * Calculates fare for the ride
     *
     * @param distance   distance  of the journey
     * @param pricePerKM price per KM for the journey
     * @return fare for the ride
     */
    public double displayPrice(final double distance, final int pricePerKM) {
        return distance * pricePerKM;
    }

    /**
     * Processes whatever inputs that are passed by the users
     */
    public void printBookingInfo() {
        System.out.println("Enter your location :");
        final String location = USER_INPUT.next();

        setLocation(location);
        final StringBuilder locationBuilder = new StringBuilder("Location is");

        locationBuilder.append(getLocation());
        setAvailability(true);
        setDistance(10.5);
        final StringBuilder checkAvailabilityBuilder = new StringBuilder("BookingDetails Confirmed : ");

        checkAvailabilityBuilder.append(getAvailability());
        System.out.println(checkAvailabilityBuilder);
        final StringBuilder distanceBuilder = new StringBuilder("Location Distance : ");

        distanceBuilder.append(getDistance());
        System.out.println(distanceBuilder);
        final StringBuilder fareBuilder = new StringBuilder("Total Fare :");

        fareBuilder.append(displayPrice(20.5, pricePerKM));
        fareBuilder.append(" Rs.");
        System.out.println(fareBuilder);
    }
}