package com.gv.archive.communication.interfaces;

public interface CommunicationService {

    void init();

    Response doGet(Request request);

    Response doPut(Request request);

    Response doPost(Request request);

    Response doDelete(Request request);
}
