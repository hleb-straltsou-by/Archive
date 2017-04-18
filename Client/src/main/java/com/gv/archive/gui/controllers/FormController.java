package com.gv.archive.gui.controllers;

import com.gv.archive.authenthication.validators.implementations.UserValidatorImpl;
import com.gv.archive.authenthication.validators.interfaces.UserValidator;
import com.gv.archive.gui.start.Main;
import com.gv.archive.logging.AppLogger;
import com.gv.archive.models.Role;
import com.gv.archive.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This is a controller class, which is used to bind gui and business logic
 * according MVC pattern. Controller for the view represented in main.fxml file
 */
public class FormController {

    @FXML
    /** object for representing errors */
    private Label errorLabel;

    @FXML
    /** object used for input login of user */
    private TextField loginField;

    @FXML
    /** object used for input password of user */
    private PasswordField passwordField;

    private UserValidator validator = new UserValidatorImpl();

    /**  object used to enter into main page as guest */
    private static final User USER_GUEST = new User("guest", "guest", Role.GUEST, "guest");

    /**  object for storing entered user */
    public static User currentUser;

    /**
     * checks if input password and login are valid, if it is,
     * then method forward user to the main page
     * @param actionEvent - JafaFx event for binding view and controller
     */
    public void logIn(ActionEvent actionEvent) {
        User user = validator.checkUser(loginField.getText(), passwordField.getText());
        if(user == null){
            setAuthenticationError();
            return;
        }
        forwardToMainPage(user);
    }

    /**
     * loads register form for the new user for input initial register data.
     * @param actionEvent - JafaFx event for binding view and controller
     */
    public void signUp(ActionEvent actionEvent) {
        // TODO: upload register form
    }

    /**
     * forward unregistered user to the main page as guest.
     * @param actionEvent - JafaFx event for binding view and controller
     */
    public void logInAsGuest(ActionEvent actionEvent) {
        forwardToMainPage(USER_GUEST);
    }

    /**
     * sets authentication error message to the errorLabel
     */
    private void setAuthenticationError(){
        errorLabel.setText("Error! Please, check input email address or password...");
    }

    /**
     * sets up main page and registered entered user in currentUser static variable
     * @param user - object of entered user.
     */
    private void forwardToMainPage(User user){
        try {
            currentUser = user;
            Main.getMainStage().close();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
            Scene scene = new Scene(root);
            stage.setResizable(true);
            stage.getIcons().add(new Image(getClass().getClassLoader()
                    .getResource("pictures/icons/favicon.jpg").toExternalForm()));
            stage.setMinHeight(Main.MIN_HEIGHT_OF_MAIN_WINDOW);
            stage.setMinWidth(Main.MIN_WIDTH_OF_MAIN_WINDOW);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            AppLogger.getLogger().error(e.getMessage());
        }
    }
}