package com.gv.archive.communication.concurrency;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RMIServerTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("IoC/rmi-context.xml");

    private final static String RMI_SERVER_BEAN = "rmiServer";

    @Test
    public void runTest() throws Exception {
        RMIServer server = (RMIServer) context.getBean(RMI_SERVER_BEAN);

        Thread thread = new Thread(server);
        thread.start();
        Thread.sleep(5000);
    }

}