package com.gv.archive.communication.factories.interfaces;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;

public interface RequestStrategyFactory {

    RequestStrategy defineRequestStrategy(Request request);
}
