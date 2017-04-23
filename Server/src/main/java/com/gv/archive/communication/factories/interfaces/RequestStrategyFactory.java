package com.gv.archive.communication.factories.interfaces;

import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;

/**
 * Defines signature of factory for RequestStrategy
 * @see com.gv.archive.communication.strategies.interfaces.RequestStrategy
 */
public interface RequestStrategyFactory {

    /**
     * according client request type defines specific strategy for handling
     * @param request - object that contain all necessary request information
     * @return specific strategy
     */
    RequestStrategy defineRequestStrategy(Request request);
}
