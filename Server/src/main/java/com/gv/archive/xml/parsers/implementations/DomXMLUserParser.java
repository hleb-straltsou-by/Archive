package com.gv.archive.xml.parsers.implementations;

import com.gv.archive.logging.AppLogger;
import com.gv.archive.xml.parsers.interfaces.XMLUserParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class DomXMLUserParser implements XMLUserParser{

    private final static String XML_USERS_PATH = "data" + File.separator + "xml" + File.separator + "users.xml";

    private DocumentBuilder builder;

    public DomXMLUserParser(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            builder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e){
            AppLogger.getLogger().error(e);
        }
    }

    @Override
    public String getUser(String login, String password) {
        String userStr = null;
        Document document = getDocument(XML_USERS_PATH);
        NodeList list = document.getElementsByTagName("user");
        for(int i = 0; i < list.getLength(); i++){
            Element user = (Element)list.item(i);
            if(user.getElementsByTagName("login").item(0).getTextContent().equals(login) &&
                    user.getElementsByTagName("password").item(0).getTextContent().equals(password)){
               userStr = innerXml(user);
            }
        }
        return userStr;
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

    private String innerXml(Node node) {
        DOMImplementationLS lsImpl = (DOMImplementationLS)node.getOwnerDocument().
                getImplementation().getFeature("LS", "3.0");
        LSSerializer lsSerializer = lsImpl.createLSSerializer();
        lsSerializer.getDomConfig().setParameter("xml-declaration", false);
        return lsSerializer.writeToString(node);
    }
}
