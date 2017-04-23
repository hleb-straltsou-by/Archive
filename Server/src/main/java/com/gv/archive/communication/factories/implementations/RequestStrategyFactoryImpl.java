package com.gv.archive.communication.factories.implementations;

import com.gv.archive.communication.factories.enums.RequestStrategyEnum;
import com.gv.archive.communication.factories.interfaces.RequestStrategyFactory;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.logging.AppLogger;

/**
 * Defines factory for RequestStrategy
 * @see com.gv.archive.communication.strategies.interfaces.RequestStrategy
 */
public class RequestStrategyFactoryImpl implements RequestStrategyFactory {

    /** contains all available types of client requests */
    private RequestStrategyEnum strategyEnum;

    public RequestStrategyFactoryImpl(){}

    /**
     * according client request type defines specific strategy for handling
     * @param request - object that contain all necessary request information
     * @return specific strategy
     */
    @Override
    public RequestStrategy defineRequestStrategy(Request request) {
        try{
            strategyEnum = RequestStrategyEnum.valueOf(request.getRequestType());
        } catch (IllegalArgumentException e){
            strategyEnum = RequestStrategyEnum.EMPTY;
            AppLogger.getLogger().error(e);
        } finally {
            return strategyEnum.getCurrentRequestStrategy();
        }
    }
}
