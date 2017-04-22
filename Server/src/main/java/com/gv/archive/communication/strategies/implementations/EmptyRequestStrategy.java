package com.gv.archive.communication.strategies.implementations;

import com.gv.archive.communication.implementations.BasicResponse;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;

public class EmptyRequestStrategy implements RequestStrategy{

    public EmptyRequestStrategy(){}

    @Override
    public Response executeRequest(Request request) {
        return new BasicResponse("failed");
    }
}
