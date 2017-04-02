package com.gv.archive.communication.interfaces;

public interface Request {

    String getRequestType();

    String getRequestBody();

    void setRequestType(String type);

    void setRequestBody(String body);
}
