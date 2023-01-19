package com.sanmedia.twozo.booking.model;

/**
 * Service pattern
 * Contains id, price per km & name
 *
 * @author Ajay
 * @version 1.0
 */
public class Service {

    private Long id;
    private Double pricePerKM;
    private String name;

    public Double getPricePerKM() {
        return pricePerKM;
    }

    public void setPricePerKM(final Double pricePerKM) {
        this.pricePerKM = pricePerKM;
    }

    public String getName() {
        return name;
    }

    public void setName(final String service) {
        this.name = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}