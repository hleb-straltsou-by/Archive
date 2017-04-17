package com.gv.archive.xml.parsers.factories.interfaces;

import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;

public interface XMLDossierParserFactory {

    XMLDossierParser defineParserType(String type);
}
