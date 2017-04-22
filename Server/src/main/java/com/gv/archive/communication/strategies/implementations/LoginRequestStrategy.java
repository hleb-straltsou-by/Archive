package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.implementations.BasicResponse;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.xml.parsers.interfaces.XMLUserParser;

public class LoginRequestStrategy implements RequestStrategy {

    private XMLUserParser parser;

    public LoginRequestStrategy(XMLUserParser parser){
        this.parser = parser;
    }

    @Override
    public Response executeRequest(Request request) {
        String params[] = request.getRequestBody().split(" ");
        String login = params[0];
        String password = params[1];

        String xmlUser = parser.getUser(login, password);
        Response response = new BasicResponse();
        if(xmlUser == null){
            response.setResponseBody("failed");
        } else {
            response.setResponseBody(xmlUser);
        }
        return response;
    }
}
