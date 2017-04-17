package com.gv.archive.parsers.implementations;

import com.gv.archive.models.Dossier;
import com.gv.archive.parsers.interfaces.XMLDossierParser;

public class EmptyXMLDossierParser implements XMLDossierParser {

    public EmptyXMLDossierParser(){}

    @Override
    public boolean isValid(String xml) {
        return false;
    }

    @Override
    public String getDossier(String login) {
        return null;
    }

    @Override
    public String getDossiers() {
        return null;
    }

    @Override
    public boolean putDossier(String login, Dossier updatingDossier) {
        return false;
    }

    @Override
    public boolean postDossier(Dossier dossier) {
        return false;
    }

    @Override
    public boolean deleteDossier(String login) {
        return false;
    }
}
