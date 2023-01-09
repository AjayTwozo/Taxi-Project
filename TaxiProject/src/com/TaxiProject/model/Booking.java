package com.TaxiProject.model;

/**
 * Booking pattern
 * Contains id, total fare, fare & driver
 *
 * @author Ajay
 * @version 1.0
 */
public class Booking {

    private Long id;
    private Double totalFare;
    private Fare fare;
    private Driver driver;

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Double totalFare) {
        this.totalFare = totalFare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
