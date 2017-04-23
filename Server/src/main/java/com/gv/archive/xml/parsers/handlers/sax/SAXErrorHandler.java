package com.gv.archive.xml.parsers.handlers.sax;

import com.gv.archive.logging.AppLogger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * handles errors of parsing xml, used by SAX parsers
 */
public class SAXErrorHandler implements ErrorHandler {

    /** defines handling for warnings */
    public void warning(SAXParseException e) throws SAXException {
        System.err.println(e.getMessage());
        AppLogger.getLogger().error(e);
    }

    /** defines handling for errors */
    public void error(SAXParseException e) throws SAXException {
        System.err.println(e.getMessage());
        AppLogger.getLogger().error(e);
        throw new SAXException();
    }

    /** defines handling for fatal errors */
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println(e.getMessage());
        AppLogger.getLogger().error(e);
        throw new SAXException();
    }
}
