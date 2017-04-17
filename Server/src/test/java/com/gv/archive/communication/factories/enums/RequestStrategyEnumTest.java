package com.gv.archive.communication.factories.enums;

import com.gv.archive.communication.strategies.implementations.DeleteRequestStrategy;
import com.gv.archive.communication.strategies.implementations.GetRequestStrategy;
import com.gv.archive.communication.strategies.implementations.PostRequestStrategy;
import com.gv.archive.communication.strategies.implementations.PutRequestStrategy;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RequestStrategyEnumTest {

    private RequestStrategyEnum strategyEnum = null;

    private final String getRequest = "GET";
    private final String putRequest = "PUT";
    private final String postRequest = "POST";
    private final String deleteRequest = "DELETE";

    @Test
    public void getEnumsTest() throws Exception {
        strategyEnum = RequestStrategyEnum.valueOf(getRequest);
        Assert.assertEquals(strategyEnum, RequestStrategyEnum.GET);

        strategyEnum = RequestStrategyEnum.valueOf(putRequest);
        Assert.assertEquals(strategyEnum, RequestStrategyEnum.PUT);

        strategyEnum = RequestStrategyEnum.valueOf(postRequest);
        Assert.assertEquals(strategyEnum, RequestStrategyEnum.POST);

        strategyEnum = RequestStrategyEnum.valueOf(deleteRequest);
        Assert.assertEquals(strategyEnum, RequestStrategyEnum.DELETE);
    }

    private static final Object[] getIllegalRequest(){
        return new String[][]{{""}, {"SOMETHING"}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getIllegalRequest")
    public void getEnumsWithIllegalArgumentsTest(String illegalRequest){
        strategyEnum = RequestStrategyEnum.valueOf(illegalRequest);
    }

    @Test
    public void getRequestStrategiesTest(){
        strategyEnum = RequestStrategyEnum.valueOf(getRequest);
        RequestStrategy strategy = strategyEnum.getCurrentRequestStrategy();
        Assert.assertTrue(strategy instanceof GetRequestStrategy);

        strategyEnum = RequestStrategyEnum.valueOf(putRequest);
        strategy = strategyEnum.getCurrentRequestStrategy();
        Assert.assertTrue(strategy instanceof PutRequestStrategy);

        strategyEnum = RequestStrategyEnum.valueOf(postRequest);
        strategy = strategyEnum.getCurrentRequestStrategy();
        Assert.assertTrue(strategy instanceof PostRequestStrategy);

        strategyEnum = RequestStrategyEnum.valueOf(deleteRequest);
        strategy = strategyEnum.getCurrentRequestStrategy();
        Assert.assertTrue(strategy instanceof DeleteRequestStrategy);
    }

}