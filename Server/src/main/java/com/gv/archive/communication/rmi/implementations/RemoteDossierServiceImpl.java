package com.gv.archive.communication.rmi.implementations;

import com.gv.archive.communication.rmi.interfaces.RemoteDossierService;
import com.gv.archive.xml.converters.interfaces.XMLDossierConverter;
import com.gv.archive.xml.parsers.interfaces.XMLDossierParser;
import java.rmi.RemoteException;

/**
 * basic implementation of RemoteDossierService, object of this class is configured by
 * Spring IoC container
 */
public class RemoteDossierServiceImpl implements RemoteDossierService{

    /** for parsing dossier objects from local xml storage */
    private XMLDossierParser parser;

    /** for converting dossier objects in xml format */
    private XMLDossierConverter converter;

    /** basic constructor */
    public RemoteDossierServiceImpl(XMLDossierParser parser, XMLDossierConverter converter){
        this.parser = parser;
        this.converter = converter;
    }

    @Override
    public String getDossier(String login) throws RemoteException {
        return parser.getDossier(login);
    }

    @Override
    public String getAllDossiers() throws RemoteException{
        return parser.getDossiers();
    }
}
