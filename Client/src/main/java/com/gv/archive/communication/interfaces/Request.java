package com.gv.archive.communication.interfaces;

public interface Request {

    String getRequestType();

    String getRequestBody();

    String getXMLParser();

    void setRequestType(String requestType);

    void setRequestBody(String body);

    void setXMLParser(String xmlParser);
}
