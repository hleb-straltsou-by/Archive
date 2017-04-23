package com.gv.archive.xml.converters.implementations;

import com.gv.archive.xml.converters.interfaces.XMLUserConverter;
import com.gv.archive.xml.models.Role;
import com.gv.archive.xml.models.User;
import org.junit.Assert;
import org.junit.Test;

public class XStreamXMLUserConverterTest {

    private XMLUserConverter converter = new XStreamXMLUserConverter();

    private String xmlUser1 = "<user>\n" +
            "  <login>gleb4477</login>\n" +
            "  <name>Gleb Streltsov</name>\n" +
            "  <role>ADMIN</role>\n" +
            "  <password>5588</password>\n" +
            "</user>";

    private String xmlUser2 = "    <user>\n" +
            "        <login>vi4477</login>\n" +
            "        <name>Veronika Sanko</name>\n" +
            "        <role>GUEST</role>\n" +
            "        <password>5588</password>\n" +
            "    </user>";

    private User userObject = new User("gleb4477", "Gleb Streltsov", Role.ADMIN ,"5588");

    @Test
    public void convertXMLStringToUserObject() throws Exception {
        User user = converter.convertXMLStringToUserObject(xmlUser1);
        Assert.assertEquals(user.getLogin(), "gleb4477");
        Assert.assertEquals(user.getName(), "Gleb Streltsov");
        Assert.assertEquals(user.getRole().toString(), "ADMIN");
        Assert.assertEquals(user.getPassword(), "5588");

        user = converter.convertXMLStringToUserObject(xmlUser2);
        Assert.assertEquals(user.getLogin(), "vi4477");
        Assert.assertEquals(user.getName(), "Veronika Sanko");
        Assert.assertEquals(user.getRole().toString(), "GUEST");
        Assert.assertEquals(user.getPassword(), "5588");
    }

    @Test
    public void convertUserToXMLString() throws Exception {
        Assert.assertEquals(converter.convertUserToXMLString(userObject), xmlUser1);
    }
}