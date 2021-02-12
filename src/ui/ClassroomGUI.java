package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

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

    // LOGIN SCREEN ----------------------------------------------------------------------------------------------------

    @FXML
    void login(ActionEvent event) {
        System.out.println("");
    }

    // REGISTER SCREEN -------------------------------------------------------------------------------------------------

    @FXML
    void choosePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Image");
        Stage stage = (Stage) mainPane.getScene().getWindow();
        fileChooser.showOpenDialog(stage);
    }

    @FXML
    void createUser(ActionEvent event) {
        System.out.println("");
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
        stage.setHeight(775);
        Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
        mainPane.getChildren().setAll(register);
    }

}
