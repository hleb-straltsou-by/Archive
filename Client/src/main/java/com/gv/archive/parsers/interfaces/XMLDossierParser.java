package com.gv.archive.parsers.interfaces;

import com.gv.archive.models.Dossier;

public interface XMLDossierParser {

    boolean isValid(String xml);

    String getDossier(String login);

    String getDossiers();

    boolean putDossier(String login, Dossier updatingDossier);

    boolean postDossier(Dossier dossier);

    boolean deleteDossier(String login);
}
