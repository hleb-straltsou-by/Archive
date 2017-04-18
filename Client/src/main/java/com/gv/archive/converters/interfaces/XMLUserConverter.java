package com.gv.archive.converters.interfaces;

import com.gv.archive.models.User;

public interface XMLUserConverter {

    User convertXMLStringToUserObject(String xmlUser);

    String convertUserToXMLString(User user);
}
