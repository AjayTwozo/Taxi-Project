package com.sanmedia.twozo.user.service.implementation;

import com.sanmedia.twozo.user.DAO.UserDAO;
import com.sanmedia.twozo.user.model.User;
import com.sanmedia.twozo.user.service.UserService;

/**
 * Enforces the {@link UserService} functionalities.
 *
 * @author Ajay
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private static final UserDAO USER_DAO = new UserDAO();

    /**
     * <p>
     *     Effectuates Sign Up functionality to the Database.
     * </p>
     *
     * @param user {@link User} holds all relevant personal details.
     * @return being passed to the Database.
     */
    public boolean signUp(final User user) {
        return USER_DAO.signUp(user);
    }

    /**
     * <p>
     *     Effectuates Login functionality to the Database.
     * </p>
     *
     * @param user {@link User} holds all relevant personal details.
     * @return being passed to the Database.
     */
    public boolean login(final User user) {
        return USER_DAO.login(user);
    }
}
