package com.gv.archive.communication.interfaces;
/**
 * communicates with server sending requests and getting responses
 */
public interface CommunicationService {

    /**
     * executes get request (getting dossier object)
     * @param request - contains all information for request
     * @return response object
     */
    Response doGet(Request request);

    /**
     * executes put request (updates dossier object)
     * @param request - contains all information for request
     * @return response object
     */
    Response doPut(Request request);

    /**
     * executes post request (adds new dossier object)
     * @param request - contains all information for request
     * @return response object
     */
    Response doPost(Request request);

    /**
     * executes delete request (deletes dossier object)
     * @param request - contains all information for request
     * @return response object
     */
    Response doDelete(Request request);

    /**
     * executes login request (checks and returns user object)
     * @param request - contains all information for request
     * @return response object
     */
    Response doLogin(Request request);
}
