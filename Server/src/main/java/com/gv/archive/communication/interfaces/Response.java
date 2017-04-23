package com.gv.archive.communication.interfaces;

/**
 * Defines response contract for communicating between client and server
 */
public interface Response {

    /**
     * @return body of server response
     */
    String getResponseBody();

    /**
     * sets response body
     * @param body - body of server response
     */
    void setResponseBody(String body);
}
