package ui;

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
import model.Classroom;
import model.Genre;
import model.UserAccount;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private CheckBox cbSoftware;
    @FXML
    private CheckBox cbTelematic;
    @FXML
    private CheckBox cbIndustrial;
    @FXML
    private DatePicker dpBirthday;
    @FXML
    private TextField txtBrowser;
    @FXML
    private TableView<UserAccount> tvAccount;
    @FXML
    private TableColumn<UserAccount, String> tcUser;
    @FXML
    private TableColumn<UserAccount, String> tcGender;
    @FXML
    private TableColumn<UserAccount, String> tcCareer;
    @FXML
    private TableColumn<UserAccount, String> tcBirthday;
    @FXML
    private TableColumn<UserAccount, String> tcBrowser;

    Alert errorAlert = new Alert(Alert.AlertType.WARNING);
    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);

    Classroom classroom = new Classroom();

    // LOGIN SCREEN ----------------------------------------------------------------------------------------------------

    @FXML
    void login(ActionEvent event) throws IOException {

        System.out.println(classroom.getUserAccounts().size());

        String user = txtUser.getText();
        String password = txtPass.getText();

        if(classroom.getUserAccounts().isEmpty()) {
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("No Users Found");
            errorAlert.setContentText("There are no existing users.");
            errorAlert.showAndWait();
        } else {
            if(user.isEmpty() || password.isEmpty()) {
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Blank spaces detected");
                errorAlert.setContentText("Please enter all the information.");
                errorAlert.showAndWait();
            }
            for(UserAccount userAccount : classroom.getUserAccounts()) {
                if(userAccount.getUsername().equals(user)) {
                    if(userAccount.getPassword().equals(password)) {
                        showAccountList(null);
                    }
                } else {
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText("User doesn't exist");
                    errorAlert.setContentText("This user doesn't exist in the contact list.");
                    errorAlert.showAndWait();
                }

            }
        }
    }

    // REGISTER SCREEN -------------------------------------------------------------------------------------------------

    Image image = null;

    @FXML
    void choosePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images","*.jpg","*.png","*.jpeg"));
        fileChooser.setTitle("Select profile image");
        Stage stage = (Stage) mainPane.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if(selectedFile != null) {
            pictureURL.setText(selectedFile.getPath());
            image = new Image(selectedFile.toURI().toString());
            pictureHolder.setFill(new ImagePattern(image));
        } else {
            pictureURL.setText("No picture selected");
        }
    }

    @FXML
    void createUser(ActionEvent event) throws IOException {
        Boolean careerSelected = true;
        if(!cbSoftware.isSelected() && !cbTelematic.isSelected() && !cbIndustrial.isSelected()) {
            careerSelected = false;
        }
        if(!txtUser.getText().equals("") && !txtPass.getText().equals("") && tgGender.getSelectedToggle()!=null && careerSelected && dpBirthday.getValue()!=null && !txtBrowser.getText().equals("")) {
            ArrayList<String> careers = new ArrayList<String>();
            String user = txtUser.getText();
            String password = txtPass.getText();
            Image profilePic = image;
            // GET GENDER
            RadioButton selectedRadioButton = (RadioButton) tgGender.getSelectedToggle();
            String toggleGroupValue = selectedRadioButton.getText();
            Genre genre = Genre.valueOf(toggleGroupValue);
            // GET CAREERS
            if(cbSoftware.isSelected()) careers.add(cbSoftware.getText());
            if(cbTelematic.isSelected()) careers.add(cbTelematic.getText());
            if(cbIndustrial.isSelected()) careers.add(cbIndustrial.getText());
            // GET DATE
            String date = dpBirthday.getValue().toString();
            String favBrowser = txtBrowser.getText();
            UserAccount newUser = new UserAccount(user, password, profilePic, genre, careers, date, favBrowser);
            classroom.getUserAccounts().add(newUser);
            infoAlert.setTitle("Information");
            infoAlert.setHeaderText("Contact added");
            infoAlert.setContentText(user + " was successfully added to the contact list.");
            infoAlert.showAndWait();
            System.out.println(classroom.getUserAccounts().size());
            showLogIn(null);
        } else {
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Blank spaces detected");
            errorAlert.setContentText("Please enter all the information.");
            errorAlert.showAndWait();
        }
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
