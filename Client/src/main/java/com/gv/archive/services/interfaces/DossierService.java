package com.gv.archive.services.interfaces;

import com.gv.archive.models.Dossier;
import javafx.collections.ObservableMap;

/**
 * provides CRUD operations with dossiers
 */
public interface DossierService {

    /**
     * returns Dossier object according @param login using @param parser on the server
     * @param login - login attribute of dossier
     * @param parser - used xml parser on the server
     * @return Dossier object
     */
    Dossier getDossier(String login, String parser);

    /**
     * returns list of all dossiers stored on the server
     * @param parser used xml parser on the server
     * @return DossierList object
     */
    ObservableMap<String, Dossier> getAllDossiers(String parser);

    /**
     * updates dossier with @param login using @param dossier on the server
     * @param login - login attribute of dossier
     * @param parser - used xml parser on the server
     * @param dossier - updating dossier object
     * @return true - updating was successful
     *         false - - updating was unsuccessful
     */
    boolean updateDossier(String login, Dossier dossier, String parser);

    /**
     * adds new dossier object on the server
     * @param dossier - new dossier object
     * @param parser - used xml parser on the server
     * @return true - adding was successful
     *         false - adding was unsuccessful
     */
    boolean addDossier(Dossier dossier, String parser);

    /**
     * deletes dossier according @param login on the server
     * @param login - dossier attribute
     * @param parser - used xml parser on the server
     * @return true - deleting was successful
     *         false - deleting was unsuccessful
     */
    boolean deleteDossier(String login, String parser);
}
