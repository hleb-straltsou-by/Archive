package com.gv.archive.communication.factories.implementations;

import com.gv.archive.communication.factories.interfaces.RequestStrategyFactory;
import com.gv.archive.communication.implementations.BasicRequest;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.strategies.implementations.*;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import org.junit.Assert;
import org.junit.Test;

public class RequestStrategyFactoryImplTest {

    private RequestStrategyFactory factory = new RequestStrategyFactoryImpl();

    private String getRequestType = "GET";
    private String putRequestType = "PUT";
    private String postRequestType = "POST";
    private String deleteRequestType = "DELETE";
    private String illegalRequestType = "ILLEGAL";

    private String requestBody = "Request body from client";
    private String requestParser = "DOM";
    private Request request = new BasicRequest(requestBody, requestParser);

    @Test
    public void defineRequestStrategyTest() throws Exception {
        request.setRequestType(getRequestType);
        RequestStrategy strategy = factory.defineRequestStrategy(request);
        Assert.assertTrue(strategy instanceof GetRequestStrategy);

        request.setRequestType(putRequestType);
        strategy = factory.defineRequestStrategy(request);
        Assert.assertTrue(strategy instanceof PutRequestStrategy);

        request.setRequestType(postRequestType);
        strategy = factory.defineRequestStrategy(request);
        Assert.assertTrue(strategy instanceof PostRequestStrategy);

        request.setRequestType(deleteRequestType);
        strategy = factory.defineRequestStrategy(request);
        Assert.assertTrue(strategy instanceof DeleteRequestStrategy);
    }

    @Test
    public void defineIllegalRequestStrategyTest() throws Exception {
        request.setRequestType(illegalRequestType);
        RequestStrategy strategy = factory.defineRequestStrategy(request);
        Assert.assertTrue(strategy instanceof EmptyRequestStrategy);
    }

}