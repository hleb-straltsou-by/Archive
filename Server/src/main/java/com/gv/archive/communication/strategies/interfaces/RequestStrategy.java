package com.gv.archive.communication.strategies.interfaces;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;

/**
 * Specifies contract for handling client requests
 */
public interface RequestStrategy {

    /**
     * handles client request and defines response for client
     * @param request - object that contain all necessary request information
     * @return response object for client
     */
    Response executeRequest(Request request);
}
