package com.gv.archive.communication.rmi.implementations;

import com.gv.archive.communication.rmi.interfaces.RemoteDossierService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RemoteDossierServiceImplTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("IoC/rmi-context.xml");

    private final static String REMOTE_DOSSIER_SERVICE_NAME = "remoteDossierService";

    @Test
    public void getDossier() throws Exception {
        RemoteDossierService service = (RemoteDossierService)context.getBean(REMOTE_DOSSIER_SERVICE_NAME);
        Assert.assertTrue(service instanceof RemoteDossierServiceImpl);
        Assert.assertNotEquals(service.getDossier("vi4477"), "");
    }
}