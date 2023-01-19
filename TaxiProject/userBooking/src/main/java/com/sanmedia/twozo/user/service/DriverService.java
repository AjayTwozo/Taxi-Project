package com.sanmedia.twozo.user.service;


import com.sanmedia.twozo.user.model.Driver;

import java.util.Collection;

/**
 * Exhibits the services that are offered to Drivers
 *
 * @author Ajay
 * @version 1.0
 */
public interface DriverService {

    long insert(final Driver driver);

    Collection<Driver> getAll();

    Driver get(final Long idNumber);

    boolean remove(final Long idNumber);

    boolean update(final Driver driver);
}
