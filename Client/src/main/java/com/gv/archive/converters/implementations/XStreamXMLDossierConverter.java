package com.gv.archive.converters.implementations;

import com.gv.archive.converters.interfaces.XMLDossierConverter;
import com.gv.archive.models.Dossier;
import com.gv.archive.models.DossierList;
import com.gv.archive.models.Role;
import com.thoughtworks.xstream.XStream;

public class XStreamXMLDossierConverter implements XMLDossierConverter {

    private XStream xStream;

    public XStreamXMLDossierConverter(){
        xStream = new XStream();
        xStream.processAnnotations(Dossier.class);
        xStream.processAnnotations(Role.class);
        xStream.alias("dossiers", DossierList.class);
        xStream.addImplicitCollection(DossierList.class, "list");
    }

    @Override
    public Dossier convertToDossierObject(String xmlDossier) {
        return (Dossier)xStream.fromXML(xmlDossier);
    }

    @Override
    public String convertToXMLString(Dossier dossier) {
        return xStream.toXML(dossier);
    }

    @Override
    public DossierList convertToDossierList(String xmlDossiers) {
        return (DossierList)xStream.fromXML(xmlDossiers);
    }

    @Override
    public String convertDossierListToXMLString(DossierList list) {
        return xStream.toXML(list);
    }
}
