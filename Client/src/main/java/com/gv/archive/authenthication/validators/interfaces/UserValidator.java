package com.gv.archive.authenthication.validators.interfaces;

import com.gv.archive.models.User;

public interface UserValidator {

    User checkUser(String login, String password);
}
