package com.TaxiProject.controller;

import com.TaxiProject.service.Impl.UserServiceImpl;
import com.TaxiProject.model.User;

/**
 * Acts as a Controller, manages the data's flow from View to respective Services.
 *
 * @author Ajay
 * @version 1.0
 */
public class UserController {

    private static final UserServiceImpl USER_SERVICE_IMPL = new UserServiceImpl();

    /**
     * <p>
     *     Effectuates Sign Up functionality from View to Service.
     * </p>
     *
     * @param user {@link User} holds all relevant personal details.
     * @return being passed to Service
     */
    public boolean signUp(final User user) {
        return USER_SERVICE_IMPL.signUp(user);
    }

    /**
     * <p>
     *     Effectuates Login functionality from View to Service.
     * </p>
     *
     * @param user {@link User} holds all relevant personal details.
     * @return being passed to Service
     */
    public boolean login(final User user) {
        return USER_SERVICE_IMPL.login(user);
    }
}