package com.gv.archive.services.implementations;

import com.gv.archive.communication.implementations.BasicRequest;
import com.gv.archive.communication.implementations.SocketCommunicationService;
import com.gv.archive.communication.interfaces.CommunicationService;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.converters.implementations.XStreamXMLDossierConverter;
import com.gv.archive.converters.interfaces.XMLDossierConverter;
import com.gv.archive.models.Dossier;
import com.gv.archive.models.DossierList;
import com.gv.archive.services.interfaces.DossierService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class BasicDossierService implements DossierService {

    /** used for sending request to the server */
    private CommunicationService service = new SocketCommunicationService();

    /** used for converting xml strings into java objects */
    private XMLDossierConverter converter = new XStreamXMLDossierConverter();

    /** map of dossiers and its headers (used in gui) */
    private ObservableMap<String, Dossier> dossierMap = FXCollections.observableHashMap();

    /** request body */
    private final static String ALL_DOSSIERS_REQUEST_BODY = "dossiers";

    @Override
    public Dossier getDossier(String login, String parser) {
        Request request = new BasicRequest(login, parser);
        Response response = service.doGet(request);
        Dossier dossier = null;
        if(!response.getResponseBody().equals("")){
            dossier = converter.convertToDossierObject(response.getResponseBody());
        }
        return dossier;
    }

    @Override
    public ObservableMap<String, Dossier> getAllDossiers(String parser) {
        Request request = new BasicRequest(ALL_DOSSIERS_REQUEST_BODY, parser);
        Response response = service.doGet(request);
        if(!response.getResponseBody().equals("")){
            DossierList dossierList = converter.convertToDossierList(response.getResponseBody());
            dossierMap.clear();
            for(Dossier dos : dossierList.getList()){
                dossierMap.put(dos.getName() + "\n" + dos.getAddress().getCountry() +
                        ", " + dos.getAddress().getCity(), dos);
            }
            return dossierMap;
        }
        return null;
    }

    @Override
    public boolean updateDossier(String login, Dossier dossier, String parser) {
        boolean isUpdate = false;
        Request request = new BasicRequest(login + " " + converter.convertToXMLString(dossier), parser);
        Response response = service.doPut(request);
        if(!response.getResponseBody().equals("failed")){
            isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean addDossier(Dossier dossier, String parser) {
        boolean isAdded = false;
        Request request = new BasicRequest(converter.convertToXMLString(dossier), parser);
        Response response = service.doPost(request);
        if(!response.getResponseBody().equals("failed")){
            isAdded = true;
        }
        return isAdded;
    }

    @Override
    public boolean deleteDossier(String login, String parser) {
        boolean isDeleted = false;
        Request request = new BasicRequest(login, parser);
        Response response = service.doDelete(request);
        if(!response.getResponseBody().equals("failed")){
            isDeleted = true;
        }
        return isDeleted;
    }
}
