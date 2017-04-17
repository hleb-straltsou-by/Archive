package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.implementations.BasicResponse;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.xml.converters.implementations.XStreamXMLDossierConverter;
import com.gv.archive.xml.converters.interfaces.XMLDossierConverter;
import com.gv.archive.xml.models.Dossier;
import com.gv.archive.xml.parsers.factories.implementations.XMLDossierParserFactoryImpl;
import com.gv.archive.xml.parsers.factories.interfaces.XMLDossierParserFactory;
import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;

public class PostRequestStrategy implements RequestStrategy{

    private XMLDossierConverter converter = new XStreamXMLDossierConverter();

    @Override
    public Response executeRequest(Request request) {
        XMLDossierParserFactory factory = new XMLDossierParserFactoryImpl();
        XMLDossierParser parser = factory.defineParserType(request.getXMLParser());

        String xmlDossier = request.getRequestBody();
        Dossier dossier = converter.convertXMLStringToDossierObject(xmlDossier);

        Response response = new BasicResponse();
        if(parser.postDossier(dossier)){
            response.setResponseBody("succeed");
        } else {
            response.setResponseBody("failed");
        }
        return response;
    }
}
