package com.sanmedia.twozo.user.service;

import com.sanmedia.twozo.user.model.User;

/**
 * Exhibits the Users the options whence they access the platform
 *
 * @author Ajay
 * @version 1.0
 */
public interface UserService {

    boolean signUp(final User user);

    boolean login(final User user);
}