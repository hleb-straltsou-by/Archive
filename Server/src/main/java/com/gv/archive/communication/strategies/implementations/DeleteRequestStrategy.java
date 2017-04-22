package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.implementations.BasicResponse;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.xml.converters.interfaces.XMLDossierConverter;
import com.gv.archive.xml.parsers.factories.implementations.XMLDossierParserFactoryImpl;
import com.gv.archive.xml.parsers.factories.interfaces.XMLDossierParserFactory;
import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;

public class DeleteRequestStrategy implements RequestStrategy{

    private XMLDossierConverter converter;

    public DeleteRequestStrategy(XMLDossierConverter converter){
        this.converter = converter;
    }

    @Override
    public Response executeRequest(Request request) {
        XMLDossierParserFactory factory = new XMLDossierParserFactoryImpl();
        XMLDossierParser parser = factory.defineParserType(request.getXMLParser());

        String login = request.getRequestBody();
        Response response = new BasicResponse();

        if(parser.deleteDossier(login)){
            response.setResponseBody("succeed");
        } else {
            response.setResponseBody("failed");
        }
        return response;
    }
}
