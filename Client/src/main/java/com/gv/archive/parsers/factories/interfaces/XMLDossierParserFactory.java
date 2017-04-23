package com.gv.archive.parsers.factories.interfaces;

import com.gv.archive.parsers.interfaces.XMLDossierParser;

/**
 * specifies contract for factorizing XMLDossierParser implementations
 */
public interface XMLDossierParserFactory {

    /**
     * returns defined type of parser
     * @param type - name of parser type
     * @return XMLDossierParser object
     */
    XMLDossierParser defineParserType(String type);
}
