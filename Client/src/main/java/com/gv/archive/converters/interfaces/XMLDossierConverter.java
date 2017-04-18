package com.gv.archive.converters.interfaces;

import com.gv.archive.models.Dossier;
import com.gv.archive.models.DossierList;

public interface XMLDossierConverter {

    Dossier convertToDossierObject(String xmlDossier);

    String convertToXMLString(Dossier dossier);

    DossierList convertToDossierList(String xmlDossiers);

    String convertDossierListToXMLString(DossierList list);

}
