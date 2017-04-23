package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.xml.converters.implementations.XStreamXMLDossierConverter;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class PutRequestStrategyTest extends Mockito{

    private RequestStrategy strategy = new PutRequestStrategy(new XStreamXMLDossierConverter());

    @Test
    public void executeRequestWithDomParser() throws Exception {
        Request request = mock(Request.class);

        when(request.getRequestBody()).thenReturn("test <dossier login=\"test47\" role=\"ADMIN\">\n" +
                "            <name>Gleb Streltsov</name>\n" +
                "            <address>\n" +
                "                <country>Belarus</country>\n" +
                "                <city>Minsk</city>\n" +
                "                <street>Prushinskih 47</street>\n" +
                "            </address>\n" +
                "            <mobile>+375296949195</mobile>\n" +
                "            <skype>ka1oken_4by</skype>\n" +
                "            <experience>none</experience>\n" +
                "        </dossier>");
        when(request.getXMLParser()).thenReturn("DOM");

        Response response = strategy.executeRequest(request);
        verify(request).getRequestBody();
        verify(request).getXMLParser();

        Assert.assertEquals(response.getResponseBody(), "succeed");
    }
}