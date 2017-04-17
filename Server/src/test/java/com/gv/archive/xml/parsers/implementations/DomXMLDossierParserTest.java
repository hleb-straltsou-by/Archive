package com.gv.archive.xml.parsers.implementations;

import com.gv.archive.xml.models.Dossier;
import com.gv.archive.xml.models.Role;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class DomXMLDossierParserTest {

    private DomXMLDossierParser parser = new DomXMLDossierParser();

    private final String testDossier = "<dossier login=\"test\" role=\"ADMIN\">\n" +
            "            <name>Gleb Streltsov</name>\n" +
            "            <address>\n" +
            "                <country>Belarus</country>\n" +
            "                <city>Minsk</city>\n" +
            "                <street>Prushinskih 47</street>\n" +
            "            </address>\n" +
            "            <mobile>+375296949195</mobile>\n" +
            "            <skype>ka1oken_4by</skype>\n" +
            "            <experience>none</experience>\n" +
            "        </dossier>";

    private String testXmlStringWithOneDossier ="<dossier login=\"vi4477\" role=\"GUEST\">\n" +
            "            <name>Veronika Sanko</name>\n" +
            "            <address>\n" +
            "                <country>Belarus</country>\n" +
            "                <city>Minsk</city>\n" +
            "                <street>Gerasimenko 7</street>\n" +
            "            </address>\n" +
            "            <mobile>+375291239671</mobile>\n" +
            "            <skype>vi_sanko</skype>\n" +
            "            <experience>none</experience>\n" +
            "        </dossier>";

    private String testInvalidXmlStringWithOneDossier =
            "<dossier login=\"vi4477\" role=\"GUEST\">\n" +
                    "            <name>Veronika Sanko</name>\n" +
                    "            <add ress>\n" +
                    "                <country>Belarus</country>\n" +
                    "                <city>Minsk</city>\n" +
                    "                <street>Gerasimenko 7</street>\n" +
                    "            </address>\n" +
                    "            <mobile>+375291239671</mobile>\n" +
                    "            <skype>vi_sanko</skype>\n" +
                    "            <experience>none</experience>\n" +
                    "        </dossier>";

    private String testXmlStringWithTwoDossiers =
            "<dossier login=\"vi4477\" role=\"GUEST\">\n" +
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
                    "            <skype >ka1oken_4by</skype>\n" +
                    "            <experience>none</experience>\n" +
                    "        </dossier>";

    private String testInvalidXmlStringWithTwoDossiers =
            "<dossier login=\"vi4477\" role=\"gust\">\n" +
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
                    "        </dossier>";

    @Test
    public void isXmlStringValidWithOneElementTest() throws Exception {
        Assert.assertTrue(parser.isValid(testXmlStringWithOneDossier));
    }

    @Test
    public void isXmlStringValidWithSeveralElementsTest() throws Exception {
        Assert.assertTrue(parser.isValid(testXmlStringWithTwoDossiers));
    }

    @Test
    public void isXmlStringValidWithInvalidXmlTest() throws Exception {
        Assert.assertFalse(parser.isValid(testInvalidXmlStringWithOneDossier));
        Assert.assertFalse(parser.isValid(testInvalidXmlStringWithTwoDossiers));
    }

    @Test
    public void getExistedDossierTest() throws Exception {
        String find = parser.getDossier("vi4477");
        Assert.assertEquals(find, testXmlStringWithOneDossier);
    }

    @Test
    public void getAllExistedDossiersNotNullTest() throws Exception{
        Assert.assertNotNull(parser.getDossiers());
    }

    @Test
    public void postDossierTest() throws Exception {
        Dossier dossier = new Dossier();
        dossier.setLogin("testLogin");
        dossier.setRole(Role.USER);
        dossier.setName("testName");

        dossier.getAddress().setCountry("testCountry");
        dossier.getAddress().setCity("testCity");
        dossier.getAddress().setStreet("testStreet");

        dossier.setMobile("testMobile");
        dossier.setSkype("testSkype");
        dossier.setExperience("testExperience");

        Assert.assertTrue(parser.postDossier(dossier));
    }

    @Test
    public void deleteDossierTest() throws Exception {
        String loginForDeletingDossier = "testLogin";
        Assert.assertTrue(parser.deleteDossier(loginForDeletingDossier));
        loginForDeletingDossier = "updateLogin";
        Assert.assertTrue(parser.deleteDossier(loginForDeletingDossier));
    }

    @Test
    public void putDossierTest() throws Exception {
        Dossier dossier = new Dossier();

        dossier.setLogin("testLogin");
        dossier.setRole(Role.USER);
        dossier.setName("testName");

        dossier.getAddress().setCountry("testCountry");
        dossier.getAddress().setCity("testCity");
        dossier.getAddress().setStreet("testStreet");

        dossier.setMobile("testMobile");
        dossier.setSkype("testSkype");
        dossier.setExperience("testExperience");

        Assert.assertTrue(parser.postDossier(dossier));

        dossier.setLogin("updateLogin");
        dossier.setRole(Role.USER);
        dossier.setName("updateName");

        dossier.getAddress().setCountry("updateCountry");
        dossier.getAddress().setCity("updateCity");
        dossier.getAddress().setStreet("updateStreet");

        dossier.setMobile("updateMobile");
        dossier.setSkype("testSkype");
        dossier.setExperience("testExperience");

        Assert.assertTrue(parser.putDossier("testLogin", dossier));
    }

    @After
    public void deleteAllTestData(){
        String loginForDeletingDossier = "updateLogin";
        Assert.assertTrue(parser.deleteDossier(loginForDeletingDossier));
    }
}