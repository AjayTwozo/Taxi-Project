package com.TaxiProject.serviceCollection;

import com.TaxiProject.model.Driver;

import java.util.Collection;

/**
 * Displays the services offered to drivers
 */
public interface DriverService {

    boolean signUp(final Driver driver);

    boolean login(final Driver driver);

    long insert(final Driver driver);

    Collection<Driver> getAll();

    Driver get(final long idNumber);

    boolean remove(final long idNumber);

    boolean update(final Driver driver);
}