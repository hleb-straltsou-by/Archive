package com.gv.archive.communication.implementations;

import com.gv.archive.communication.interfaces.Request;
import java.io.Serializable;

public class BasicRequest implements Request, Serializable {

    private String type;

    private String body;

    private String xmlParser;

    public BasicRequest(String body, String xmlParser) {
        this.type = type;
        this.body = body;
        this.xmlParser = xmlParser;
    }

    @Override
    public String getRequestType() {
        return type;
    }

    @Override
    public String getRequestBody() {
        return body;
    }

    @Override
    public String getXMLParser() {
        return xmlParser;
    }

    @Override
    public void setRequestType(String type) {
        this.type = type;
    }

    @Override
    public void setRequestBody(String body) {
        this.body = body;
    }

    @Override
    public void setXMLParser(String xmlParser) {
        this.xmlParser = xmlParser;
    }
}