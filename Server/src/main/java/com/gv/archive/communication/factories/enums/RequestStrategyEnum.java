package com.gv.archive.communication.factories.enums;

import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public enum RequestStrategyEnum {

    GET{
        {
            strategy = (RequestStrategy)context.getBean(GET_REQUEST_STRATEGY_BEAN);
        }
    },
    PUT{
        {
            strategy = (RequestStrategy)context.getBean(PUT_REQUEST_STRATEGY_BEAN);
        }
    },
    POST{
        {
            strategy = (RequestStrategy)context.getBean(POST_REQUEST_STRATEGY_BEAN);
        }
    },
    DELETE{
        {
            strategy = (RequestStrategy)context.getBean(DELETE_REQUEST_STRATEGY_BEAN);
        }
    },
    LOGIN{
        {
            strategy = (RequestStrategy)context.getBean(LOGIN_REQUEST_STRATEGY_BEAN);
        }
    },
    EMPTY{
        {
            strategy = (RequestStrategy)context.getBean(EMPTY_REQUEST_STRATEGY_BEAN);
        }
    };

    RequestStrategy strategy;

    ApplicationContext context = new ClassPathXmlApplicationContext("IoC/request-context.xml");

    private final static String DELETE_REQUEST_STRATEGY_BEAN = "deleteRequestStrategy";

    private final static String EMPTY_REQUEST_STRATEGY_BEAN = "emptyRequestStrategy";

    private final static String GET_REQUEST_STRATEGY_BEAN = "getRequestStrategy";

    private final static String LOGIN_REQUEST_STRATEGY_BEAN = "loginRequestStrategy";

    private final static String POST_REQUEST_STRATEGY_BEAN = "postRequestStrategy";

    private final static String PUT_REQUEST_STRATEGY_BEAN = "putRequestStrategy";

    public RequestStrategy getCurrentRequestStrategy(){
        return strategy;
    }
}
