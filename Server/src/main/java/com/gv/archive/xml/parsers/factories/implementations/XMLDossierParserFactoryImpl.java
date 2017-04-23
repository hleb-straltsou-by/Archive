package com.gv.archive.xml.parsers.factories.implementations;

import com.gv.archive.logging.AppLogger;
import com.gv.archive.xml.parsers.factories.enums.XMLDossierParserEnum;
import com.gv.archive.xml.parsers.factories.interfaces.XMLDossierParserFactory;
import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;

/**
 * Defines factory for XMLDossierParser
 * @see com.gv.archive.communication.strategies.interfaces.RequestStrategy
 */
public class XMLDossierParserFactoryImpl implements XMLDossierParserFactory{

    /** specified available parser types */
    private XMLDossierParserEnum parserEnum;

    public XMLDossierParserFactoryImpl(){}

    @Override
    /**
     * returns defined type of parser
     * @param type - name of parser type
     * @return XMLDossierParser object
     */
    public XMLDossierParser defineParserType(String type) {
        XMLDossierParser parser;
        try{
            parserEnum = XMLDossierParserEnum.valueOf(type);
        } catch (IllegalArgumentException e){
            AppLogger.getLogger().error(e);
            parserEnum = XMLDossierParserEnum.EMPTY;
        } finally {
            return parserEnum.getCurrentParserType();
        }
    }
}
