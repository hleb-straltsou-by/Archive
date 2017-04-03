package com.gv.archive.communication.interfaces;

public interface Request {

    String getRequestType();

    String getRequestBody();

    void setRequestType(String requestType);

    void setRequestBody(String body);
}
