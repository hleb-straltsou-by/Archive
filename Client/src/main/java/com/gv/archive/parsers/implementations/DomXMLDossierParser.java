package com.gv.archive.parsers.implementations;

import com.gv.archive.logging.AppLogger;
import com.gv.archive.models.Dossier;
import com.gv.archive.parsers.interfaces.XMLDossierParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ResourceBundle;

public class DomXMLDossierParser implements XMLDossierParser {

    /** path to xsd schema*/
    private final static String XSD_SCHEMA_PATH = "data" + File.separator + "schemas" + File.separator + "dossiers.xsd";

    /** path to xml file with dossiers */
    private final static String XML_DOSSIERS_PATH = "data" + File.separator + "xml" + File.separator + "dossiers.xml";

    /** object for extracting properties from resource bundle xmlDossiers.properties */
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("xmlDossiers");

    /** name of property in resource bundle */
    private final static String DOSSIERS_HEADER_PROPERTY = "xml.dossiers.header";

    /** name of property in resource bundle */
    private final static String DOSSIERS_END_PROPERTY = "xml.dossiers.end";

    /** for validating xml strings */
    private Validator validator;

    /** for building dom models */
    private DocumentBuilder builder;

    /** for transforming xml file */
    private Transformer transformer;

    /** index of node */
    private final int COUNTRY_NODE_INDEX = 1;

    /** index of node */
    private final int CITY_NODE_INDEX = 3;

    /** index of node */
    private final int STREET_NODE_INDEX = 5;

    /**
     * initializes components of object
     */
    public DomXMLDossierParser(){
        try {
            // create a SchemaFactory capable of understanding WXS schemas
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsdFile = new File(XSD_SCHEMA_PATH);
            Schema schema = schemaFactory.newSchema(xsdFile);

            // create a Validator instance, which can be used to validate an instance document
            validator = schema.newValidator();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            builder = docFactory.newDocumentBuilder();

            // create transformer
            TransformerFactory tff = TransformerFactory.newInstance();
            transformer = tff.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        } catch (Exception e){
            AppLogger.getLogger().error(e);
        }
    }

    @Override
    public boolean isValid(String xml) {
        boolean isValid = false;
        try {
            String resultXml = RESOURCE_BUNDLE.getString(DOSSIERS_HEADER_PROPERTY) + xml
                    + RESOURCE_BUNDLE.getString(DOSSIERS_END_PROPERTY);
            validator.validate(new StreamSource(new StringReader(resultXml)));
            isValid = true;
        } catch (Exception e){
            AppLogger.getLogger().error(e);
        } finally {
            return isValid;
        }
    }

    @Override
    public String getDossier(String login) {
        String dossierStr = null;
        Document document = getDocument(XML_DOSSIERS_PATH);
        NodeList list = document.getElementsByTagName("dossier");
        for(int i = 0; i < list.getLength(); i++){
            Element dossier = (Element)list.item(i);
            if(dossier.getAttribute("login").equals(login)){
                dossierStr = innerXml(dossier);
                break;
            }
        }
        return dossierStr;

    }

    @Override
    public String getDossiers() {
        Document document = getDocument(XML_DOSSIERS_PATH);
        NodeList list = document.getElementsByTagName("dossiers");
        return innerXml(list.item(0));
    }

    @Override
    public boolean putDossier(String login, Dossier updatingDossier) {
        Document document;
        boolean isPut = true;
        try{
            document = getDocument(XML_DOSSIERS_PATH);
            NodeList list = document.getElementsByTagName("dossier");
            for(int i = 0; i < list.getLength(); i++){
                Element dossier = (Element)list.item(i);
                if(dossier.getAttribute("login").equals(login)){
                    dossier.setAttribute("login", updatingDossier.getLogin());
                    dossier.setAttribute("role", updatingDossier.getRole().toString());
                    dossier.getElementsByTagName("name").item(0).setTextContent(updatingDossier.getName());
                    // update address part
                    Node address = dossier.getElementsByTagName("address").item(0);
                    address.getChildNodes().item(COUNTRY_NODE_INDEX).setTextContent(updatingDossier.getAddress().getCountry());
                    address.getChildNodes().item(CITY_NODE_INDEX).setTextContent(updatingDossier.getAddress().getCity());
                    address.getChildNodes().item(STREET_NODE_INDEX).setTextContent(updatingDossier.getAddress().getStreet());
                    // update mobile, skype, experience
                    dossier.getElementsByTagName("mobile").item(0).setTextContent(updatingDossier.getMobile());
                    dossier.getElementsByTagName("skype").item(0).setTextContent(updatingDossier.getSkype());
                    dossier.getElementsByTagName("experience").item(0).setTextContent(updatingDossier.getExperience());
                }
            }
            // save changes to xml file
            saveXMLContent(document, XML_DOSSIERS_PATH);
        } catch (TransformerException e){
            AppLogger.getLogger().error(e);
            isPut = false;
        } finally {
            return isPut;
        }
    }

    @Override
    public boolean postDossier(Dossier dossier) {
        boolean isPosted = true;
        Document document;

        document = getDocument(XML_DOSSIERS_PATH);
        Element dossiers = document.getDocumentElement();
        Element dossierElem = document.createElement("dossier");
        dossierElem.setAttribute("login", dossier.getLogin());
        dossierElem.setAttribute("role", dossier.getRole().toString());

        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(dossier.getName()));
        dossierElem.appendChild(name);

        // adding address
        Element address = document.createElement("address");
        Element country = document.createElement("country");
        country.appendChild(document.createTextNode(dossier.getAddress().getCountry()));
        address.appendChild(country);
        Element city = document.createElement("city");
        city.appendChild(document.createTextNode(dossier.getAddress().getCity()));
        address.appendChild(city);
        Element street = document.createElement("street");
        street.appendChild(document.createTextNode(dossier.getAddress().getStreet()));
        address.appendChild(street);

        dossierElem.appendChild(address);

        Element mobile = document.createElement("mobile");
        mobile.appendChild(document.createTextNode(dossier.getMobile()));
        dossierElem.appendChild(mobile);

        Element skype = document.createElement("skype");
        skype.appendChild(document.createTextNode(dossier.getSkype()));
        dossierElem.appendChild(skype);

        Element experience = document.createElement("experience");
        experience.appendChild(document.createTextNode(dossier.getExperience()));
        dossierElem.appendChild(experience);

        dossiers.appendChild(dossierElem);
        try {
            saveXMLContent(document, XML_DOSSIERS_PATH);
        } catch (TransformerException e){
            AppLogger.getLogger().error(e);
            isPosted = false;
        }
        return isPosted;
    }

    @Override
    public boolean deleteDossier(String login) {
        Document document;
        boolean isDeleted = false;
        try{
            document = getDocument(XML_DOSSIERS_PATH);
            NodeList list = document.getElementsByTagName("dossier");
            for(int i = 0; i < list.getLength(); i++){
                Element dossier = (Element)list.item(i);
                if(dossier.getAttribute("login").equals(login)){
                    dossier.getParentNode().removeChild(dossier);
                    i--;        // for deleting all dossiers with such
                    isDeleted = true;
                }
            }
            // write changes to xml file
            saveXMLContent(document, XML_DOSSIERS_PATH);
        } catch (TransformerException e){
            AppLogger.getLogger().error(e);
            isDeleted = false;
        } finally {
            return isDeleted;
        }
    }

    private Document getDocument(String filePath){
        Document document = null;
        try {
            document = builder.parse(filePath);
        } catch (Exception e) {
            AppLogger.getLogger().error(e);
        } finally {
            return document;
        }
    }

    private String getXMLContent(Document document){
        String result = null;
        StringWriter sW = new StringWriter();
        StreamResult streamResult = new StreamResult(sW);
        DOMSource source = new DOMSource();
        try {
            transformer.transform(source, streamResult);
            result = sW.toString();
        } catch (Exception e) {
            AppLogger.getLogger().error(e);
        } finally {
            return result;
        }
    }

    private void saveXMLContent(Document document, String filePath) throws TransformerException {
        try {
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(filePath);
            transformer.transform(source, streamResult);
        } catch (TransformerConfigurationException e) {
            AppLogger.getLogger().error(e);
        }
    }

    public String innerXml(Node node) {
        DOMImplementationLS lsImpl = (DOMImplementationLS)node.getOwnerDocument().
                getImplementation().getFeature("LS", "3.0");
        LSSerializer lsSerializer = lsImpl.createLSSerializer();
        lsSerializer.getDomConfig().setParameter("xml-declaration", false);
        NodeList childNodes = node.getChildNodes();
        return lsSerializer.writeToString(node);
    }
}
