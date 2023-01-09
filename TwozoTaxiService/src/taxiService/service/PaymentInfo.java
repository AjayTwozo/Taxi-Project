package taxiService.service;

/**
 * Displays users fare price, payment options etc.
 *
 * @author Ajay
 * @version 1.0
 */
public class PaymentInfo {
    /**
     * Calculates the total fare of the ride
     *
     * @param distance distance of the ride
     * @param pricePerKM for the ride
     * @return total fare of the ride
     */
    public double displayPrice(final double distance, final int pricePerKM) {
        return distance * pricePerKM;
    }

    /**
     * Showing the driver reference number for payment being done
     *
     * @param upiReferenceID UPI reference ID of the payment made
     * @return UPI reference number
     */
    public int showRefNo(final int upiReferenceID) {
        return upiReferenceID;
    }

    /**
     * Processes information based on the ride
     */
    public void printPaymentInfo() {
        final StringBuffer stringFare = new StringBuffer("Total fare :");

        stringFare.append(displayPrice(20.5, 15));
        stringFare.append(" Rs.");
        System.out.println(stringFare);
        final StringBuffer stringUPIRefID = new StringBuffer("UPI Payment Reference Num :");

        stringUPIRefID.append(showRefNo(87286));
        System.out.println(stringUPIRefID);
    }
}