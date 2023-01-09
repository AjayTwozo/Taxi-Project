package com.TaxiProject.controller;

import com.TaxiProject.service.Impl.UserServiceImpl;
import com.TaxiProject.model.User;

/**
 * Acquired functions from UserPage Class being passed to UserService
 *
 * @author Ajay
 * @version 1.0
 */
public class UserController {

    private static final UserServiceImpl USER_SERVICE_IMPL = new UserServiceImpl();

    /**
     * Effectuates signUp functionality from UserPage Class being passed to UserService
     *
     * @param user User object being wrapped
     * @return being passed to Service
     */
    public boolean signUp(final User user) {
        return USER_SERVICE_IMPL.signUp(user);
    }

    /**
     * Effectuates login functionality from UserPage Class being passed to UserService
     *
     * @param user User object being wrapped
     * @return being passed to Service
     */
    public boolean login(final User user) {
        return USER_SERVICE_IMPL.login(user);
    }
}