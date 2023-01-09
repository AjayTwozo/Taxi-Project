import driver.carRegistration.RegistrationHub;
import taxiService.service.PaymentInfo;
import user.bookTaxi.BookRide;
import user.bookTaxi.DriverInfo;

/**
 * Main class of the package
 * Various methods are called
 *
 * @author Ajay
 * @version 1.0
 */
public class TaxiService {

    /**
     * Main method
     *
     *  @param args of main method
     */
    public static void main(String[] args) {
        final WelcomePage options = new WelcomePage();
        final BookRide booking = new BookRide();
        final DriverInfo driver = new DriverInfo();
        final PaymentInfo payment = new PaymentInfo();
        final RegistrationHub registration = new RegistrationHub();

        WelcomePage.welcomePage();
        booking.printBookingInfo();
        driver.printDriverInfo();
        payment.printPaymentInfo();
    }
}