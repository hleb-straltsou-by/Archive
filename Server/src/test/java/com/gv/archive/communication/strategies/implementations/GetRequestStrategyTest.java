package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.xml.converters.implementations.XStreamXMLDossierConverter;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetRequestStrategyTest extends Mockito{

    private RequestStrategy strategy = new GetRequestStrategy(new XStreamXMLDossierConverter());

    private String testXmlStringWithOneDossier ="<dossier login=\"vi4477\" role=\"ADMIN\">\n" +
            "        <name>Veronika Sanko</name>\n" +
            "        <address>\n" +
            "            <country>Belarus</country>\n" +
            "            <city>Minsk</city>\n" +
            "            <street>Gerasimenko 7</street>\n" +
            "        </address>\n" +
            "        <mobile>+375291239671</mobile>\n" +
            "        <skype>vivi_sanko</skype>\n" +
            "        <experience>none</experience>\n" +
            "    </dossier>";
    @Test
    public void executeRequestWithDomParser() throws Exception {
        Request request = mock(Request.class);

        when(request.getRequestBody()).thenReturn("vi4477");
        when(request.getXMLParser()).thenReturn("DOM");

        Response response = strategy.executeRequest(request);
        verify(request).getRequestBody();
        verify(request).getXMLParser();

        Assert.assertEquals(response.getResponseBody(), testXmlStringWithOneDossier);
    }

    @Test
    public void executeRequestWithAllDossiersAndDomParser() throws Exception {
        Request request = mock(Request.class);
        when(request.getRequestBody()).thenReturn("dossiers");
        when(request.getXMLParser()).thenReturn("DOM");

        strategy.executeRequest(request);
        verify(request).getRequestBody();
        verify(request).getXMLParser();
    }

}