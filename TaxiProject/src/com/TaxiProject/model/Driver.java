package com.TaxiProject.model;

/**
 * Driver's pattern elaborating User's pattern
 * Contains Driver's availability, registrationNumber, service & location
 *
 * @author Ajay
 * @version 1.0
 */
public class Driver extends User {

    private boolean availability;
    private String registrationNumber;
    private Service service;
    private Location location;

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(final boolean availability) {
        this.availability = availability;
    }

    public Service getService() {
        return service;
    }

    public void setService(final Service service) {
        this.service = service;
    }

    public void setRegistrationNumber(final String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }
}