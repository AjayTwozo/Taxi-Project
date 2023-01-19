package com.sanmedia.twozo.booking.model;

import com.sanmedia.twozo.user.model.Customer;

/**
 * Fare pattern
 * Contains id, distance, pickup point, drop point, com.TaxiProject.customer, location
 *
 * @author Ajay
 * @version 1.0
 */
public class Fare {

    private Long id;
    private Double distance;
    private Location pickupPoint;
    private Location dropPoint;
    private Customer customer;
    private Location location;

    public Location getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(final Location pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public Location getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(final Location dropPoint) {
        this.dropPoint = dropPoint;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(final Double distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}