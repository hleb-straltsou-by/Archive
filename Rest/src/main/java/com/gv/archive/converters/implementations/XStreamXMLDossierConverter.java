package com.gv.archive.converters.implementations;

import com.gv.archive.converters.interfaces.XMLDossierConverter;
import com.gv.archive.models.Dossier;
import com.gv.archive.models.DossierList;
import com.gv.archive.models.Role;
import com.thoughtworks.xstream.XStream;

/**
 * Implements XMLDossierConverter interface using XStream xml converter
 */
public class XStreamXMLDossierConverter implements XMLDossierConverter {

    /** object for converting */
    private XStream xStream;

    /**
     * initializes xStream object and processes annotations in models classes
     */
    public XStreamXMLDossierConverter(){
        xStream = new XStream();
        xStream.processAnnotations(Dossier.class);
        xStream.processAnnotations(Role.class);
        xStream.alias("dossiers", DossierList.class);
        xStream.addImplicitCollection(DossierList.class, "list");
    }

    @Override
    public Dossier convertXMLStringToDossierObject(String xmlDossier) {
        return (Dossier)xStream.fromXML(xmlDossier);
    }

    @Override
    public String convertDossierToXMLString(Dossier dossier) {
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
