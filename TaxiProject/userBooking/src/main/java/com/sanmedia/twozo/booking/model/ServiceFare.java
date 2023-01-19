package com.sanmedia.twozo.booking.model;

/**
 * ServiceFare pattern
 * Contains service, com.TaxiProject.booking
 *
 * @author Ajay
 * @version 1.0
 */
public class ServiceFare {

    private Service service;
    private Booking booking;

    public Service getService() {
        return service;
    }

    public void setService(final Service service) {
        this.service = service;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(final Booking booking) {
        this.booking = booking;
    }
}
