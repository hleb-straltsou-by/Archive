package com.gv.archive.communication.implementations;

import com.gv.archive.communication.interfaces.Request;
import java.io.Serializable;

public class BasicRequest implements Request, Serializable{

    private String type;

    private String body;

    public BasicRequest(String body) {
        this.body = body;
    }

    public BasicRequest(String type, String body) {
        this.type = type;
        this.body = body;
    }

    @Override
    public String getRequestType() {
        return type;
    }

    @Override
    public String getRequestBody() {
        return body;
    }

    @Override
    public void setRequestType(String type) {
        this.type = type;
    }

    @Override
    public void setRequestBody(String body) {
        this.body = body;
    }
}
