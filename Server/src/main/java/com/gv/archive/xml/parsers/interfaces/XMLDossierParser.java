package com.gv.archive.xml.parsers.interfaces;

import com.gv.archive.xml.models.Dossier;

public interface XMLDossierParser {

    boolean isValid(String xml);

    String getDossier(String login);

    String getDossiers();

    boolean putDossier(String login, Dossier updatingDossier);

    boolean postDossier(Dossier dossier);

    boolean deleteDossier(String login);
}
