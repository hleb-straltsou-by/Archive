package com.gv.archive.gui.controllers;

import com.gv.archive.models.Dossier;
import com.gv.archive.models.Role;
import com.gv.archive.services.implementations.BasicDossierService;
import com.gv.archive.services.interfaces.DossierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    @FXML
    private ChoiceBox roleBox;

    @FXML
    private TextField nameForm;

    @FXML
    private TextField loginForm;

    @FXML
    private TextField countryForm;

    @FXML
    private TextField cityForm;

    @FXML
    private TextField addressForm;

    @FXML
    private TextField mobileForm;

    @FXML
    private TextField skypeForm;

    @FXML
    private TextArea experienceForm;

    private DossierService service = new BasicDossierService();

    private static final Dossier EMPTY_DOSSIER = null;

    private final static String DOM_PARSER = "DOM";

    @FXML
    private void initialize(){
        // initializing data of existed dossier for updating if need;
        Dossier dossier = MainController.getDossierCash();
        if(dossier != null){
            roleBox.getSelectionModel().select(dossier.getRole().toString());
            loginForm.setText(dossier.getLogin());
            nameForm.setText(dossier.getName());
            countryForm.setText(dossier.getAddress().getCountry());
            cityForm.setText(dossier.getAddress().getCity());
            addressForm.setText(dossier.getAddress().getStreet());
            mobileForm.setText(dossier.getMobile());
            skypeForm.setText(dossier.getSkype());
            experienceForm.setText(dossier.getExperience());
        }
    }

    public void okClicked(ActionEvent actionEvent){
       Dossier dossier = new Dossier();
       dossier.setLogin(loginForm.getText());
       dossier.setName(nameForm.getText());
       dossier.getAddress().setCountry(countryForm.getText());
       dossier.getAddress().setCity(cityForm.getText());
       dossier.getAddress().setStreet(addressForm.getText());
       dossier.setMobile(mobileForm.getText());
       dossier.setSkype(skypeForm.getText());
       dossier.setExperience(experienceForm.getText());
       dossier.setRole(Role.valueOf(roleBox.getSelectionModel().getSelectedItem().toString()));

       if(MainController.getDossierCash() == null){
           service.addDossier(dossier, DOM_PARSER);
       } else {
           service.updateDossier(MainController.getDossierCash().getLogin(), dossier, DOM_PARSER);
       }

       Node source = (Node)actionEvent.getSource();
       Stage stage = (Stage)source.getScene().getWindow();
       stage.close();
    }

    public void cancelClicked(ActionEvent actionEvent){
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
}
