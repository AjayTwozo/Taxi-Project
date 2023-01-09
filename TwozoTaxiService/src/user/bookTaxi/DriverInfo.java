package user.bookTaxi;

/**
 * Shares user driver information once booking process is done
 * Driver's name, contact number
 *
 * @author Ajay
 * @version 1.0
 */
public class DriverInfo {
    private String name;
    private String mobileNumber;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNumber;
    }

    public void setMobileNo(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Processes users information about the driver
     */
    public void printDriverInfo() {
        setMobileNo("900000000");
        setName("Mr. Ram");
        final StringBuilder stringMobileNumber = new StringBuilder("Driver Number :");

        stringMobileNumber.append(getMobileNo());
        System.out.println(stringMobileNumber);
        final StringBuilder stringName = new StringBuilder("Driver Name :");

        stringName.append(getName());
        System.out.println(stringName);
    }
}