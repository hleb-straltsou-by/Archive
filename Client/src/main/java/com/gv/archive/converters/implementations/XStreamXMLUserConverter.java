package com.gv.archive.converters.implementations;

import com.gv.archive.converters.interfaces.XMLUserConverter;
import com.gv.archive.models.Role;
import com.gv.archive.models.User;
import com.thoughtworks.xstream.XStream;

public class XStreamXMLUserConverter implements XMLUserConverter {

    private XStream xStream;

    public XStreamXMLUserConverter(){
        xStream = new XStream();
        xStream.processAnnotations(User.class);
        xStream.processAnnotations(Role.class);
    }

    @Override
    public User convertXMLStringToUserObject(String xmlUser) {
        return (User)xStream.fromXML(xmlUser);
    }

    @Override
    public String convertUserToXMLString(User user) {
        return xStream.toXML(user);
    }
}
