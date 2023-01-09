package com.TaxiProject.view;

import com.TaxiProject.controller.DriverController;
import com.TaxiProject.model.Driver;
import com.TaxiProject.model.Location;
import com.TaxiProject.model.Service;
import com.TaxiProject.model.User;
import com.TaxiProject.validation.Validator;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Displays all pertaining things to the Driver service for Driver
 *
 * @author Ajay
 * @version 1.0
 */
public class DriverPage {

    private static final Validator VALIDATOR = new Validator();
    private static final UserInputs USER_INPUTS = new UserInputs();
    private static final DriverController DRIVER_CONTROLLER = new DriverController();
    private static final Scanner INPUT = new Scanner(System.in);
    private static final BookingPage BOOKING_PAGE = new BookingPage();

    /**
     * Enables Drivers to enter their Registration Number.
     *
     * @return a registration number of the {@link Driver}.
     */
    private String getRegistrationNumber() {
        System.out.print("Registration Number : ");
        final String registrationNumber = INPUT.next();

        if (!VALIDATOR.validateRegistration(registrationNumber)) {
            System.out.println("Registration number you entered is invalid");

            return getRegistrationNumber();
        }
        return registrationNumber;
    }

    /**
     * Enables driver to choose their choice of {@link Service} being retrieved from the database.
     * 
     * @return a Driver's choice of Service
     */
    private long getDriverServiceId() {
        final List<Service> serviceList = BOOKING_PAGE.getServiceInfo();
        System.out.println("Services : ");

        for (final Service service : serviceList) {
            System.out.println(new StringBuilder().append(service.getId()).append(".").
                    append(" ").append(service.getName()).append(service.getPricePerKM()));
        }
        System.out.println(new StringBuilder("Please choose a service from above!").append('\n').
                append("Enter your choice : "));
        final long choice = INPUT.nextLong();

        if (choice == 1) {
            System.out.println("You have chosen Mini Service!");
        } else if (choice == 2) {
            System.out.println("You have chosen Sedan Service!");
        } else if (choice == 3) {
            System.out.println("You have chosen Prime Service!");
        } else {
            System.out.println("Please enter above mentioned choices only!");
            getDriverServiceId();
        }
        return choice;
    }

    /**
     * Registers {@link Driver} by acquiring all necessary details.
     *
     * @return that Driver's id
     */
    long registerDriver() {
        System.out.print("Please enter User ID : ");
        final long userId = INPUT.nextLong();
        final Driver driver = new Driver();
        final User user = new User();
        final Service service = new Service();
        final Location location = new Location();

        user.setId(userId);
        service.setId(getDriverServiceId());
        driver.setId(user.getId());
        driver.setService(service);
        driver.setRegistrationNumber(getRegistrationNumber());
        System.out.println("Available Zones : ");

        for (final Location locationObject : BOOKING_PAGE.getLocationInfo()) {
            System.out.println(locationObject.getId() + "." + " " + locationObject.getZone());
        }
        System.out.print("Please enter your Location Zone : ");
        final long locationId = INPUT.nextLong();

        location.setId(locationId);
        driver.setLocation(location);
        driver.setAvailability(true);
        final long id = DRIVER_CONTROLLER.insert(driver);

        System.out.println("Registration Successful! Welcome!!" + '\n' + "Generated ID : " + id);

        return id;
    }

    /**
     * Acquires Driver's info from database based on their ID
     *
     * @return that {@link Driver} details.
     */
    Driver getDriver() {
        System.out.println("Enter ID Number : ");
        final long id = INPUT.nextLong();
        final Driver driverControllerGet = DRIVER_CONTROLLER.get(id);

        if (driverControllerGet.getName() != null) {
            System.out.println(new StringBuilder("Name : ").append(driverControllerGet.getName()).append("\n").
                    append("Mobile Number :").append(driverControllerGet.getMobileNumber()).append("\n").
                    append("Registration Number : ").append(driverControllerGet.getRegistrationNumber()).
                    append("\n").append("Service : ").append(driverControllerGet.getService().getName()));
            System.out.println("Record Retrieved Successfully!");
        } else {
            System.out.println("Entered key has no record!");
        }
        return driverControllerGet;
    }

    /**
     * Acquires and displays every Driver's details from the database
     *
     * @return List containing Driver's info
     */
    Collection<Driver> getAllDriver() {
        final Collection<Driver> driversList = DRIVER_CONTROLLER.getAll();

        for (final Driver driver : driversList) {
            System.out.println(new StringBuilder("ID Number : ").append(driver.getId()).append("\n").
                    append("Name : ").append(driver.getName()).append("\n").
                    append("Mobile Number :").append(driver.getMobileNumber()).append("\n").
                    append("Registration Number : ").append(driver.getRegistrationNumber()).append("\n").
                    append("Service Type : "));
        }
        return driversList;
    }

    /**
     * Removes a {@link Driver} from database based on their ID.
     *
     * @return whether removed successfully.
     */
    boolean removeDriver() {
        System.out.print("Enter ID Number : ");
        final long id = INPUT.nextLong();
        final boolean removeResult = DRIVER_CONTROLLER.remove(id);
        final String message = removeResult ? "Record has been removed successfully!" :
                "Entered key has no record! Enter a valid ID!";

        System.out.println(message);

        return removeResult;
    }

    /**
     * Updates driver's info based on ID number passed
     *
     * @return whether removed successfully
     */
    boolean updateDriver() {
        System.out.println("Enter ID Number : ");
        final long id = INPUT.nextLong();
        final Driver controllerGet = DRIVER_CONTROLLER.get(id);

        if (id == controllerGet.getId()) {
            final Driver driver = new Driver();

            driver.setId(id);
            System.out.println("Do you want to update your name? 1. YES 2. NO");
            final int nameChoice = INPUT.nextInt();

            switch (nameChoice) {
                case 1 -> driver.setName(USER_INPUTS.getName());
                case 2 -> driver.setName(null);
                default -> {
                    System.out.println("Yes or No choices only!");
                    updateDriver();
                }
            }
            System.out.println("Do you want to update your Mobile Number? 1. YES 2. NO");
            final int mobileNumberChoice = INPUT.nextInt();

            switch (mobileNumberChoice) {
                case 1 -> driver.setMobileNumber(USER_INPUTS.getMobileNumber());
                case 2 -> driver.setMobileNumber(null);
                default -> {
                    System.out.println("Yes or No choices only!");
                    updateDriver();
                }
            }
            System.out.println("Do you want to update your Registration Number? 1. YES 2. NO");
            final int registrationChoice = INPUT.nextInt();

            switch (registrationChoice) {
                case 1 -> driver.setRegistrationNumber(getRegistrationNumber());
                case 2 -> driver.setRegistrationNumber(null);
                default -> {
                    System.out.println("Yes or No choices only!");
                    updateDriver();
                }
            }
            System.out.println("Do you want to update your Service Type? 1. YES 2. NO");
            final int serviceTypeChoice = INPUT.nextInt();
            final Service service = new Service();

            switch (serviceTypeChoice) {
                case 1 -> {
                    service.setId(getDriverServiceId());
                    driver.setService(service);
                }
                case 2 -> driver.setService(null);
                default -> {
                    System.out.println("Yes or No choices only!");
                    updateDriver();
                }
            }
            final boolean updateResult = DRIVER_CONTROLLER.update(driver);
            System.out.println("Updated Successfully!");

            return updateResult;
        } else {
            System.out.println("Entered key has no record! Enter a valid ID!");
        }
        return false;
    }
}