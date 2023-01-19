package com.sanmedia.twozo.booking.model;

/**
 * Location pattern
 * Contains id, zone
 *
 * @author Ajay
 * @version 1.0
 */
public class Location {

    private Long id;
    private String zone;

    public long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(final String zone) {
        this.zone = zone;
    }
}