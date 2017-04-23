package com.gv.archive.xml.parsers.implementations;

import com.gv.archive.xml.parsers.interfaces.XMLUserParser;
import org.junit.Assert;
import org.junit.Test;

public class DomXMLUserParserTest {

    private XMLUserParser parser = new DomXMLUserParser();

    private String userXml = "<user>\n" +
            "        <login>gleb4477</login>\n" +
            "        <name>Gleb Streltsov</name>\n" +
            "        <role>ADMIN</role>\n" +
            "        <password>5588</password>\n" +
            "    </user>";


    @Test
    public void getExistedUserTest() throws Exception {
        String login = "gleb4477";
        String password = "5588";
        Assert.assertEquals(parser.getUser(login, password), userXml);
    }

    @Test
    public void getNotExistedUserTest() throws Exception {
        String login = "gleb44";
        String password = "5588";
        Assert.assertNull(parser.getUser(login, password));
    }
}