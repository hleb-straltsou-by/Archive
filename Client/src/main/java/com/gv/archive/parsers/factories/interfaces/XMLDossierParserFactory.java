package com.gv.archive.parsers.factories.interfaces;

import com.gv.archive.parsers.interfaces.XMLDossierParser;

public interface XMLDossierParserFactory {

    XMLDossierParser defineParserType(String type);
}
