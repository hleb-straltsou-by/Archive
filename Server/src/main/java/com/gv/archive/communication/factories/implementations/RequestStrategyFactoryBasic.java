package com.gv.archive.communication.factories.implementations;

import com.gv.archive.communication.factories.enums.RequestStrategyEnum;
import com.gv.archive.communication.factories.interfaces.RequestStrategyFactory;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.logging.AppLogger;

public class RequestStrategyFactoryBasic implements RequestStrategyFactory {

    private RequestStrategyEnum strategyEnum;

    RequestStrategyFactoryBasic(){}

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
