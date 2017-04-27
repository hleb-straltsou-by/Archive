package com.gv.archive.models;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * represents address model
 */
public class DossierList implements Serializable {

    /** list of dossier objects */
    private List<Dossier> list;

    /**
     * initializes list of dossier objects
     */
    public DossierList(){
        list = new ArrayList<>();
    }

    /**
     * returns dossier object according specified index
     * @param index - position of dossier object in list
     * @return dossier object
     */
    public Dossier get(int index) throws RemoteException{
        if(index < 0 || list.size() <= index){
            return null;
        }
        return list.get(index);
    }

    /**
     * adds new dossier to the list
     * @param dossier - new dossier object
     */
    public void add(Dossier dossier) throws RemoteException {
        list.add(dossier);
    }

    /**
     * @return dossier list
     */
    public List<Dossier> getList() throws RemoteException {
        return list;
    }
}
