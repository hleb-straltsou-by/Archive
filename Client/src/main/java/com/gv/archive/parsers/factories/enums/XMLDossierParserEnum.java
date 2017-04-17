package com.gv.archive.parsers.factories.enums;

import com.gv.archive.parsers.implementations.*;
import com.gv.archive.parsers.interfaces.XMLDossierParser;

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

    XMLDossierParser parser;

    public XMLDossierParser getCurrentParserType(){
        return parser;
    }
}
