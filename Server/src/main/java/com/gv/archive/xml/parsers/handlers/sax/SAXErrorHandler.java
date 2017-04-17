package com.gv.archive.xml.parsers.handlers.sax;

import com.gv.archive.logging.AppLogger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SAXErrorHandler implements ErrorHandler {

        public void warning(SAXParseException e) throws SAXException {
            System.err.println(e.getMessage());
            AppLogger.getLogger().error(e);
        }

    public void error(SAXParseException e) throws SAXException {
        System.err.println(e.getMessage());
        AppLogger.getLogger().error(e);
        throw new SAXException();
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println(e.getMessage());
        AppLogger.getLogger().error(e);
        throw new SAXException();
    }
}
