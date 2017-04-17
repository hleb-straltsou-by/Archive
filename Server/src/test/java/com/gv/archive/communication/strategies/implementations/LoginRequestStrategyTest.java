package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import org.junit.Test;
import org.mockito.Mockito;

public class LoginRequestStrategyTest extends Mockito{

    private RequestStrategy strategy = new LoginRequestStrategy();

    @Test
    public void executeRequest() throws Exception {
        Request request = mock(Request.class);

        when(request.getRequestBody()).thenReturn("vi4477 5588");

        Response response = strategy.executeRequest(request);
        verify(request).getRequestBody();

        System.out.println(response.getResponseBody());
    }

}