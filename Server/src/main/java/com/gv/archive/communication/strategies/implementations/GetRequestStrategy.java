package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.implementations.BasicResponse;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.xml.parsers.factories.implementations.XMLDossierParserFactoryImpl;
import com.gv.archive.xml.parsers.factories.interfaces.XMLDossierParserFactory;
import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;

public class GetRequestStrategy implements RequestStrategy{

    private final static String ALL_DOSSIERS_REQUEST_BODY = "dossiers";

    @Override
    public Response executeRequest(Request request) {
        XMLDossierParserFactory factory = new XMLDossierParserFactoryImpl();
        XMLDossierParser parser = factory.defineParserType(request.getXMLParser());

        String login = request.getRequestBody();
        Response response;
        if(login.equals(ALL_DOSSIERS_REQUEST_BODY)){
            response = new BasicResponse(parser.getDossiers());
        } else {
            response = new BasicResponse(parser.getDossier(login));
        }
        return response;
    }
}
