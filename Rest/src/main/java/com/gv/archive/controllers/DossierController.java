package com.gv.archive.controllers;

import com.gv.archive.communication.rmi.interfaces.RemoteDossierService;
import com.gv.archive.converters.implementations.XStreamXMLDossierConverter;
import com.gv.archive.converters.interfaces.XMLDossierConverter;
import com.gv.archive.logging.AppLogger;
import com.gv.archive.models.Dossier;
import com.gv.archive.models.DossierList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@RestController
/** specifies rest controller for sharing dossier objects in JSON format */
public class DossierController {

    /** type of parser for request */
    private final static int RMI_SERVER_PORT = 3000;

    /** property name for binding through rmi */
    private final static String BINDING_NAME = "DOSSIER_SHARING";

    @RequestMapping("/dossier/{login}")
    public Dossier getDossier(@RequestParam(value="login", defaultValue="vi4477") String login) {
        XMLDossierConverter converter = new XStreamXMLDossierConverter();
        Dossier dossier = null;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", RMI_SERVER_PORT);
            RemoteDossierService service = (RemoteDossierService) registry.lookup(BINDING_NAME);

            String xmlDossier = service.getDossier(login);
            if (!xmlDossier.equals("")) {
                dossier = converter.convertXMLStringToDossierObject(xmlDossier);
            }
        } catch (Exception e){
            AppLogger.getLogger().error(e);
        } finally {
            return dossier;
        }
    }

    @RequestMapping("/dossiers")
    public DossierList getDossierList() {
        XMLDossierConverter converter = new XStreamXMLDossierConverter();
        DossierList dossierList = null;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", RMI_SERVER_PORT);
            RemoteDossierService service = (RemoteDossierService) registry.lookup(BINDING_NAME);

            String xmlDossiers = service.getAllDossiers();
            if (!xmlDossiers.equals("")) {
                dossierList = converter.convertToDossierList(xmlDossiers);
            }
        } catch (Exception e){
            AppLogger.getLogger().error(e);
        } finally {
            return dossierList;
        }
    }
}
