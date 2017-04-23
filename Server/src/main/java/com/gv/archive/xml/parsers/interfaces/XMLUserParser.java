package com.gv.archive.xml.parsers.interfaces;

/**
 * defines contract for parsing xml files containing dossier objects and dossier list object
 */
public interface XMLUserParser {

    /**
     * returns xml string represents user object
     * @param login - login property of user
     * @param password - encrypt password property of user
     * @return User object
     */
    String getUser(String login, String password);
}
