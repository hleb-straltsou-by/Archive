package com.gv.archive.authenthication.validators.interfaces;

import com.gv.archive.models.User;

/**
 * authenticate user using login and encrypt password
 */
public interface UserValidator {

    /**
     * checks is password and login correspond to some of users registered on the server
     * @param login - login property of user
     * @param password - encrypt password property of user
     * @return corresponding User object, if not then returns @null
     */
    User checkUser(String login, String password);
}
