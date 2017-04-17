package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DeleteRequestStrategyTest extends Mockito{

    private RequestStrategy deleteStrategy = new DeleteRequestStrategy();

    private RequestStrategy postStrategy = new PostRequestStrategy();

    @Test
    public void executeRequestWithDomParser() throws Exception {
        // added test data
        Request request = mock(Request.class);

        when(request.getRequestBody()).thenReturn("<dossier login=\"test44\" role=\"GUEST\">\n" +
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

        Response response = postStrategy.executeRequest(request);
        verify(request).getRequestBody();
        verify(request).getXMLParser();

        Assert.assertEquals(response.getResponseBody(), "succeed");

        // delete test data
        request = mock(Request.class);

        when(request.getRequestBody()).thenReturn("test44");
        when(request.getXMLParser()).thenReturn("DOM");

        response = deleteStrategy.executeRequest(request);
        verify(request).getRequestBody();
        verify(request).getXMLParser();

        Assert.assertEquals(response.getResponseBody(), "succeed");
    }
}