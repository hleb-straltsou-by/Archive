package com.gv.archive.xml.converters.implementations;

import com.gv.archive.xml.converters.interfaces.XMLDossierConverter;
import com.gv.archive.xml.models.Dossier;
import com.gv.archive.xml.models.DossierList;
import com.gv.archive.xml.models.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XStreamXMLDossierConverterTest {

    private XMLDossierConverter converter = new XStreamXMLDossierConverter();

    private String xmlDossier = "<dossier login=\"vi4477\" role=\"GUEST\"><name>Veronika Sanko</name><address><country>Belarus</country><city>Minsk</city><street>Gerasimenko 7</street></address><mobile>+375291239671</mobile><skype>vi_sanko</skype><experience>none</experience></dossier>";

    private String xmlDossierRaw = "<dossier login=\"vi4477\" role=\"GUEST\">\n" +
            "  <name>Veronika Sanko</name>\n" +
            "  <address>\n" +
            "    <country>Belarus</country>\n" +
            "    <city>Minsk</city>\n" +
            "    <street>Gerasimenko 7</street>\n" +
            "  </address>\n" +
            "  <mobile>+375291239671</mobile>\n" +
            "  <skype>vi_sanko</skype>\n" +
            "  <experience>none</experience>\n" +
            "</dossier>";

    private String xmlDossierList = "<dossiers xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"/data/schemas/dossiers.xsd\">\n" +
            "        <dossier login=\"vi4477\" role=\"GUEST\">\n" +
            "            <name>Veronika Sanko</name>\n" +
            "            <address>\n" +
            "                <country>Belarus</country>\n" +
            "                <city>Minsk</city>\n" +
            "                <street>Gerasimenko 7</street>\n" +
            "            </address>\n" +
            "            <mobile>+375291239671</mobile>\n" +
            "            <skype>vi_sanko</skype>\n" +
            "            <experience>none</experience>\n" +
            "        </dossier>\n" +
            "        <dossier login=\"gleb4477\" role=\"ADMIN\">\n" +
            "            <name>Gleb Streltsov</name>\n" +
            "            <address>\n" +
            "                <country>Belarus</country>\n" +
            "                <city>Minsk</city>\n" +
            "                <street>Prushinskih 47</street>\n" +
            "            </address>\n" +
            "            <mobile>+375296949195</mobile>\n" +
            "            <skype>ka1oken_4by</skype>\n" +
            "            <experience>none</experience>\n" +
            "        </dossier>\n" +
            "        <dossier login=\"test47\" role=\"ADMIN\">\n" +
            "            <name>Gleb Streltsov</name>\n" +
            "            <address>\n" +
            "                <country>Belarus</country>\n" +
            "                <city>Minsk</city>\n" +
            "                <street>Prushinskih 47</street>\n" +
            "            </address>\n" +
            "            <mobile>+375296949195</mobile>\n" +
            "            <skype>ka1oken_4by</skype>\n" +
            "            <experience>none</experience>\n" +
            "        </dossier>\n" +
            "</dossiers>";

    private Dossier dossier = new Dossier();

    @Before
    public void initDossierObject() throws Exception {
        dossier.setLogin("vi4477");
        dossier.setRole(Role.GUEST);
        dossier.setName("Veronika Sanko");

        dossier.getAddress().setCountry("Belarus");
        dossier.getAddress().setCity("Minsk");
        dossier.getAddress().setStreet("Gerasimenko 7");

        dossier.setMobile("+375291239671");
        dossier.setSkype("vi_sanko");
        dossier.setExperience("none");
    }

    @Test
    public void convertToDossierObjectWithGoodXMLStrTest() throws Exception {
        Dossier result = converter.convertXMLStringToDossierObject(xmlDossier);
        Assert.assertEquals(dossier.getLogin(), result.getLogin());
        Assert.assertEquals(dossier.getRole(), result.getRole());
        Assert.assertEquals(dossier.getExperience(), result.getExperience());
        Assert.assertEquals(dossier.getSkype(), result.getSkype());
        Assert.assertEquals(dossier.getName(), result.getName());
    }

    @Test
    public void convertToDossierObjectWithRawXMLStrTest() throws Exception {
        Dossier result = converter.convertXMLStringToDossierObject(xmlDossierRaw);
        Assert.assertEquals(dossier.getLogin(), result.getLogin());
        Assert.assertEquals(dossier.getExperience(), result.getExperience());
        Assert.assertEquals(dossier.getName(), result.getName());
        Assert.assertEquals(dossier.getSkype(), result.getSkype());
        Assert.assertEquals(dossier.getRole(), result.getRole());
    }

    @Test
    public void convertToXMLStringTest() throws Exception {
        Assert.assertEquals(xmlDossierRaw, converter.convertDossierToXMLString(dossier));
    }

    @Test
    public void convertToDossierListTest() throws Exception{
        DossierList list = converter.convertXMLStringToDossierList(xmlDossierList);
        Assert.assertEquals(list.get(0).getLogin(), "vi4477");
        Assert.assertEquals(list.get(1).getLogin(), "gleb4477");
        Assert.assertEquals(list.get(2).getLogin(), "test47");
    }

    @Test
    public void convertDossierListToXMLStringSymmetricTest() throws Exception{
        DossierList list = converter.convertXMLStringToDossierList(xmlDossierList);
        String resultXMLStr = converter.convertDossierListToXMLString(list);
        DossierList resultList = converter.convertXMLStringToDossierList(resultXMLStr);
        Assert.assertEquals(list.get(0).getLogin(), resultList.get(0).getLogin());
        Assert.assertEquals(list.get(1).getLogin(), resultList.get(1).getLogin());
        Assert.assertEquals(list.get(2).getLogin(), resultList.get(2).getLogin());
    }
}