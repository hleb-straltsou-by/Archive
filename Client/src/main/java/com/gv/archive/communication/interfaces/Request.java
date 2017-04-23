package com.gv.archive.communication.interfaces;

/**
 * Defines request contract for communicating between client and server
 */
public interface Request {

    /**
     * @return type of client request
     */
    String getRequestType();

    /**
     * @return body of client request
     */
    String getRequestBody();

    /**
     * @return xml parser for handling data on the server
     */
    String getXMLParser();

    /**
     * sets request type
     * @param requestType - type of client request
     */
    void setRequestType(String requestType);

    /**
     * sets request body
     * @param body - body of client request
     */
    void setRequestBody(String body);

    /**
     * sets request xml parser
     * @param xmlParser - xml parser for handling data on the server
     */
    void setXMLParser(String xmlParser);
}