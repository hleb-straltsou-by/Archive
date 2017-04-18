package com.gv.archive.gui.controllers;

import com.gv.archive.models.Dossier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private static final Dossier EMPTY_DOSSIER = null;

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
       MainController.setDossierCash(dossier);

       Node source = (Node)actionEvent.getSource();
       Stage stage = (Stage)source.getScene().getWindow();
       stage.close();
    }

    public void cancelClicked(ActionEvent actionEvent){
        MainController.setDossierCash(EMPTY_DOSSIER);
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
}
