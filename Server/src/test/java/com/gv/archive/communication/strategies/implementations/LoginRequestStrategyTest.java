package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.xml.converters.implementations.XStreamXMLUserConverter;
import com.gv.archive.xml.converters.interfaces.XMLUserConverter;
import com.gv.archive.xml.models.Role;
import com.gv.archive.xml.models.User;
import com.gv.archive.xml.parsers.implementations.DomXMLUserParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class LoginRequestStrategyTest extends Mockito{

    private RequestStrategy strategy = new LoginRequestStrategy(new DomXMLUserParser());

    private User existedUser = new User("vi4477", "Veronika Sanko", Role.GUEST, "5588");

    XMLUserConverter converter = new XStreamXMLUserConverter();

    @Test
    public void executeRequest() throws Exception {
        Request request = mock(Request.class);

        String requestBodyStr = "vi4477 5588";
        when(request.getRequestBody()).thenReturn(requestBodyStr);

        Response response = strategy.executeRequest(request);
        verify(request).getRequestBody();

        User result = converter.convertXMLStringToUserObject(response.getResponseBody());
        String errorMessage = "Result and existed user objects are different";
        Assert.assertEquals(errorMessage, result, existedUser);
    }
}