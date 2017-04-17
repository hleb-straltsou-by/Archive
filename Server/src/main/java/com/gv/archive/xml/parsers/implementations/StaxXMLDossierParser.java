package com.gv.archive.xml.parsers.implementations;

import com.gv.archive.xml.models.Dossier;
import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;

public class StaxXMLDossierParser implements XMLDossierParser {

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
