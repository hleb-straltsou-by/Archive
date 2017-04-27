package com.gv.archive.communication.concurrency;

import com.gv.archive.communication.rmi.interfaces.RemoteDossierService;
import com.gv.archive.logging.AppLogger;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * specifies thread that shares remote dossier service using RMI, objects of this class are
 * configured by Spring IoC container
 */
public class RMIServer implements Runnable{

    /** object for sharing */
    private final RemoteDossierService service;

    /** port value on local host */
    private final static int PORT_VALUE = 3000;

    /** binding name property */
    private final static String BINDING_NAME = "DOSSIER_SHARING";

    /** basic constructor */
    public RMIServer(RemoteDossierService service){
        this.service = service;
    }

    @Override
    /**
     * start up in loop sharing of RemoteDossierService object
     */
    public void run(){
        try {
            AppLogger.getLogger().info("Starting registry...");
            final Registry registry = LocateRegistry.createRegistry(PORT_VALUE);
            AppLogger.getLogger().info("OK");

            Remote stub = UnicastRemoteObject.exportObject(service, 0);

            AppLogger.getLogger().info("Binding service...");
            registry.bind(BINDING_NAME, stub);
            AppLogger.getLogger().info("OK");

            while (true) {
                Thread.sleep(Integer.MAX_VALUE);
            }
        } catch (Exception e){
            AppLogger.getLogger().error(e);
        }
    }
}
