package com.TaxiProject.service.Impl;

import com.TaxiProject.DAO.UserDAO;
import com.TaxiProject.service.UserService;
import com.TaxiProject.model.User;

/**
 * Enforces the UserService Interface class and the functionalities inside
 *
 * @author Ajay
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private static final UserDAO USER_DAO = new UserDAO();

    /**
     * Effectuates signUp functionality from UserController Class being passed to UserDAO Class
     *
     * @param user User, object being wrapped
     * @return being passed to DAO
     */
    public boolean signUp(final User user) {
        return USER_DAO.signUp(user);
    }

    /**
     * Effectuates login functionality from UserController Class being passed to UserDAO Class
     *
     * @param user User, object being wrapped
     * @return being passed to DAO
     */
    public boolean login(final User user) {
        return USER_DAO.login(user);
    }
}
