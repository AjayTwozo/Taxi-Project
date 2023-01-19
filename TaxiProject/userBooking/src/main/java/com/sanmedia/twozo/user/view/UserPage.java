package com.sanmedia.twozo.user.view;

import com.sanmedia.twozo.user.controller.UserController;
import com.sanmedia.twozo.user.model.User;

/**
 * Enables Users to Signup and Login into the Platform
 *
 * @author Ajay
 * @version 1.0
 */
public class UserPage {

    private static final UserInputs USER_INPUTS = new UserInputs();
    private static final UserController USER_CONTROLLER = new UserController();

    /**
     * Acquires required details and does Sign Up process
     */
    void userSignUp() {
        final User user = new User();

        user.setMobileNumber(USER_INPUTS.getMobileNumber());
        user.setPassword(USER_INPUTS.getPassword());
        USER_INPUTS.getConfirmPassword();
        user.setName(USER_INPUTS.getName());
        user.setEmailId(USER_INPUTS.getEmailId());
        USER_CONTROLLER.signUp(user);
        System.out.println("Registration Successful!");
    }

    /**
     * Acquires details and verifies whether they exist
     */
    void userLogin() {
        final String mobileNumber = USER_INPUTS.getMobileNumber();
        final String password = USER_INPUTS.getPassword();
        final User user = new User();

        user.setMobileNumber(mobileNumber);
        user.setPassword(password);

        if (USER_CONTROLLER.login(user)) {
            System.out.println("Login Successful! Welcome, " + user.getName());
        } else {
            System.out.println("Incorrect info!");
            userLogin();
        }
    }
}