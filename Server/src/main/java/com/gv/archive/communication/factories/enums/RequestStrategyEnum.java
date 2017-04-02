package com.gv.archive.communication.factories.enums;

import com.gv.archive.communication.strategies.implementations.*;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;

public enum RequestStrategyEnum {

    GET{
        {
            strategy = new GetRequestStrategy();
        }
    },
    PUT{
        {
            strategy = new PutRequestStrategy();
        }
    },
    POST{
        {
            strategy = new PostRequestStrategy();
        }
    },
    DELETE{
        {
            strategy = new DeleteRequestStrategy();
        }
    },
    EMPTY{
        {
            strategy = new EmptyRequestStrategy();
        }
    },;

    RequestStrategy strategy;

    public RequestStrategy getCurrentRequestStrategy(){
        return strategy;
    }
}
