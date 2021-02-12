package ui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Browser;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class ClassroomGUI {

    @FXML
    private Pane mainPane;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private RadioButton tbMale;
    @FXML
    private ToggleGroup tgGender;
    @FXML
    private RadioButton tbFemale;
    @FXML
    private RadioButton tbOther;
    @FXML
    private TextField pictureURL;
    @FXML
    private Circle pictureHolder;
    @FXML
    private ChoiceBox<Browser> cbBrowser;

    // LOGIN SCREEN ----------------------------------------------------------------------------------------------------

    @FXML
    void login(ActionEvent event) {
        System.out.println("");
    }

    // REGISTER SCREEN -------------------------------------------------------------------------------------------------

    @FXML
    void choosePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images","*.jpg","*.png","*.jpeg"));
        fileChooser.setTitle("Select profile image");
        Stage stage = (Stage) mainPane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        Image image = null;
        if(selectedFile != null) {
            pictureURL.setText(selectedFile.getPath());
            image = new Image(selectedFile.toURI().toString());
            pictureHolder.setFill(new ImagePattern(image));
        } else {
            pictureURL.setText("No picture selected");
        }
    }

    @FXML
    void createUser(ActionEvent event) {

    }

    // SHOW SCENES -----------------------------------------------------------------------------------------------------

    @FXML
    void showAccountList(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setWidth(616);
        stage.setHeight(439);
        Parent accountList = FXMLLoader.load(getClass().getResource("account-list.fxml"));
        mainPane.getChildren().setAll(accountList);
    }

    @FXML
    void showLogIn(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setWidth(616);
        stage.setHeight(439);
        Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
        mainPane.getChildren().setAll(login);
    }

    @FXML
    void showSignUp(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setWidth(650);
        stage.setHeight(895);
        Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
        mainPane.getChildren().setAll(register);
    }

}
