package com.gv.archive.communication.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *  sets contract to get dossier objects using RMI
 */
public interface RemoteDossierService extends Remote {

    /**
     * gets Dossier object according login attribute and return it in xml format
     * @param login - dossier attribute
     * @return dossier object corresponding to login in xml format
     * @throws RemoteException - if there is error using RMI
     */
    String getDossier(String login) throws RemoteException;

    /**
     * gets all Dossier objects and returns it in xml format
     * @return list of dossiers in xml format
     * @throws RemoteException - if there is error using RMI
     */
    String getAllDossiers() throws RemoteException;
}
