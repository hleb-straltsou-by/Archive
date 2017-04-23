package com.gv.archive.authenthication.validators.implementations;

import com.gv.archive.authenthication.validators.interfaces.UserValidator;
import com.gv.archive.models.User;
import org.junit.Assert;
import org.junit.Test;

public class UserValidatorImplTest {

    UserValidator validator = new UserValidatorImpl();

    @Test
    public void checkValidUserTest() throws Exception {
        String login = "vi4477";
        String password = "4477";
        User user = validator.checkUser(login, password);
        Assert.assertEquals(user.getLogin(), "vi4477");
        Assert.assertEquals(user.getRole().toString(), "GUEST");
        Assert.assertEquals(user.getName(), "Veronika Sanko");
    }

    @Test
    public void checkInvalidUserTest() throws Exception {
        String login = "vi4477";
        String password = "44799";
        User user = validator.checkUser(login, password);
        Assert.assertNull(user);
    }
}