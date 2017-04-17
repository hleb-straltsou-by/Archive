package com.gv.archive.xml.parsers.implementations;

import com.gv.archive.logging.AppLogger;
import com.gv.archive.xml.models.Dossier;
import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;
import com.gv.archive.xml.parsers.handlers.sax.SAXErrorHandler;
import org.xml.sax.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ResourceBundle;

public class SaxXMLDossierParser implements XMLDossierParser {

    private final static String XSD_SCHEMA_PATH = "data" + File.separator + "schemas" + File.separator + "dossiers.xsd";

    /** object for extracting properties from resource bundle xmlDossiers.properties */
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("xmlDossiers");

    private final static String DOSSIERS_HEADER_PROPERTY = "xml.dossiers.header";

    private final static String DOSSIERS_END_PROPERTY = "xml.dossiers.end";

    private SAXParser parser;

    private XMLReader xmlReader;

    public SaxXMLDossierParser() {
        try {
            File xsd = new File(XSD_SCHEMA_PATH);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsd);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setValidating(false);
            saxParserFactory.setNamespaceAware(true);
            saxParserFactory.setSchema(schema);

            parser = saxParserFactory.newSAXParser();
            xmlReader = parser.getXMLReader();
            xmlReader.setErrorHandler(new SAXErrorHandler());
        } catch (SAXException | ParserConfigurationException e){
            AppLogger.getLogger().error(e);
        }
    }

    @Override
    public boolean isValid(String xml) {
        boolean isXmlValid = false;
        try {
            String resultXml = RESOURCE_BUNDLE.getString(DOSSIERS_HEADER_PROPERTY) + xml
                    + RESOURCE_BUNDLE.getString(DOSSIERS_END_PROPERTY);
            xmlReader.parse(new InputSource(new StringReader(resultXml)));
            isXmlValid = true;
        } catch (IOException | SAXException e){
            AppLogger.getLogger().error(e);
        } finally {
            return isXmlValid;
        }
    }

    @Override
    public String getDossier(String login) {
        return null;
    }

    @Override
    public String getDossiers() {
        return null;
    }

    @Override
    public boolean putDossier(String login, Dossier updatingDossier) {
        return false;
    }

    @Override
    public boolean postDossier(Dossier dossier) {
        return false;
    }

    @Override
    public boolean deleteDossier(String login) {
        return false;
    }
}
