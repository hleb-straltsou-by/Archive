package com.gv.archive.parsers.factories.enums;

import com.gv.archive.parsers.implementations.*;
import com.gv.archive.parsers.interfaces.XMLDossierParser;

/**
 * defines available parser types for handling data on the server in xml format
 */
public enum XMLDossierParserEnum {

    DOM{
        {
            parser = new DomXMLDossierParser();
        }
    },
    SAX{
        {
            parser = new SaxXMLDossierParser();
        }
    },
    STAX{
        {
            parser = new StaxXMLDossierParser();
        }
    },
    JDOM{
        {
            parser = new JDomXMLDossierParser();
        }
    },
    EMPTY{
        {
            parser = new EmptyXMLDossierParser();
        }
    };

    /** object for defining type of parser */
    XMLDossierParser parser;

    /**
     * @return parser object according parser type
     */
    public XMLDossierParser getCurrentParserType(){
        return parser;
    }
}
