package com.gv.archive.communication.implementations;

import com.gv.archive.communication.interfaces.Response;
import java.io.Serializable;

public class BasicResponse implements Response, Serializable{

    private String body;

    public BasicResponse(String body){
        this.body = body;
    }

    @Override
    public String getResponseBody() {
        return body;
    }

    @Override
    public void setResponseBody(String body) {
        this.body = body;
    }
}
