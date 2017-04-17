package com.gv.archive.parsers.factories.implementations;

import com.gv.archive.logging.AppLogger;
import com.gv.archive.parsers.factories.enums.XMLDossierParserEnum;
import com.gv.archive.parsers.factories.interfaces.XMLDossierParserFactory;
import com.gv.archive.parsers.interfaces.XMLDossierParser;

public class XMLDossierParserFactoryImpl implements XMLDossierParserFactory {

    private XMLDossierParserEnum parserEnum;

    public XMLDossierParserFactoryImpl(){}

    @Override
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
