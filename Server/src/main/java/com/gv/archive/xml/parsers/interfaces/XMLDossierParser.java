package com.gv.archive.xml.parsers.interfaces;

import com.gv.archive.xml.models.Dossier;

/**
 * defines contract for parsing xml files containing dossier objects and dossier list object
 * @see com.gv.archive.xml.models.Dossier
 * @see com.gv.archive.xml.models.DossierList
 */
public interface XMLDossierParser {

    /**
     * checks if input xml string is valid according xsd schema
     * @param xml - input xml info
     * @return true - input xml is valid
     *         false - input xml is invalid
     */
    boolean isValid(String xml);

    /**
     * returns dossier according login
     * @param login - login attribute of dossier
     * @return xml representation of dossier
     */
    String getDossier(String login);

    /**
     * returns dossier list
     * @return xml representation of dossier list
     */
    String getDossiers();

    /**
     * updates dossier according @param login uses updating dossier object
     * @param login - login attribute of dossier
     * @param updatingDossier - updating dossier object
     * @return true - updating was successful
     *         false - updating was unsuccessful
     */
    boolean putDossier(String login, Dossier updatingDossier);

    /**
     * adds new dossier
     * @param dossier - new dossier object
     * @return true - adding was successful
     *         false - adding was unsuccessful
     */
    boolean postDossier(Dossier dossier);

    /**
     * deletes dossier by @param login
     * @param login - login attribute of dossier
     * @return true - deleting was successful
     *         false - deleting was unsuccessful
     */
    boolean deleteDossier(String login);
}
