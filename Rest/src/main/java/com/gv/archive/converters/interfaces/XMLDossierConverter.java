package com.gv.archive.converters.interfaces;

import com.gv.archive.models.Dossier;
import com.gv.archive.models.DossierList;

/**
 * defines contract for converting models Dossier and DossierList to xml string and vice versa
 * @see Dossier
 * @see DossierList
 */
public interface XMLDossierConverter {

    /**
     * converts xml string to Dossier object
     * @param xmlDossier - string contains xml information about dossier
     * @return Dossier object
     */
    Dossier convertXMLStringToDossierObject(String xmlDossier);

    /**
     * converts Dossier model to xml string
     * @param dossier - Dossier object
     * @return xml string
     */
    String convertDossierToXMLString(Dossier dossier);

    /**
     * converts xml string to DossierList object
     * @param xmlDossiers - string contains xml information about dossier list
     * @return DossierList object
     */
    DossierList convertToDossierList(String xmlDossiers);

    /**
     * converts DossierList model to xml string
     * @param list - DossierList object
     * @return xml string
     */
    String convertDossierListToXMLString(DossierList list);
}
