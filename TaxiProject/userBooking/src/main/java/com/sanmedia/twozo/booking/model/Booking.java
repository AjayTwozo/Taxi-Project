package com.sanmedia.twozo.booking.model;

import com.sanmedia.twozo.user.model.Driver;

/**
 * Booking pattern
 * Contains id, total fare, fare & com.TaxiProject.driver
 *
 * @author Ajay
 * @version 1.0
 */
public class Booking {

    private Long id;
    private Double totalFare;
    private Fare fare;
    private Driver driver;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(final Double totalFare) {
        this.totalFare = totalFare;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(final Driver driver) {
        this.driver = driver;
    }
}