package user.bookTaxi;

/**
 * Displays users the booking screen
 * Enters location for the ride
 * Driver's information are shared
 *
 * @author Ajay
 * @version 1.0
 */
public interface BookingScreen {
    boolean getAvailability();

    String getLocation();

    double getDistance();

    /**
     * Calculates the fare for the ride
     *
     * @param distance distance of the ride
     * @param pricePerKM price per KM for total distance
     * @return fare for the ride
     */
    double displayPrice(final double distance, final int pricePerKM);
}