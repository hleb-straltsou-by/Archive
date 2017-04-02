package com.gv.archive.communication.strategies.interfaces;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;

public interface RequestStrategy {

    Response executeRequest(Request request);
}
