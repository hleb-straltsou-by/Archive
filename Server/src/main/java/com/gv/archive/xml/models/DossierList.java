package com.gv.archive.xml.models;

import java.util.ArrayList;
import java.util.List;

public class DossierList {

    private List<Dossier> list;

    public DossierList(){
        list = new ArrayList<Dossier>();
    }

    public Dossier get(int index){
        if(index < 0 || list.size() <= index){
            return null;
        }
        return list.get(index);
    }

    public void add(Dossier dossier){
        list.add(dossier);
    }

    public List<Dossier> getList() {
        return list;
    }
}
