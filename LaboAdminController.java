/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.challange.gui;

import edu.worshop.entites.User;
import edu.worshop.services.UserCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class LaboAdminController implements Initializable {

    int myIndex;
    int txtiduser;

    @FXML
    private Label MenuClose;
    private Button btBackup;
    private Button btchallenge;
    @FXML
    private Button btAllChallenge;
    private GridPane PnBackup;
    private GridPane PnChallenge;
    @FXML
    private Button VisitChallenges;
    @FXML
    private Button ArtWork;
    @FXML
    private Button VisitFormation;
    private Stage stage;
    private Stage scene;
    private Stage root;
    @FXML
    private Button btngestuser;
    @FXML
    private Button btngestdemandes;
    @FXML
    private GridPane pngestuser;
    @FXML
    private GridPane pngestdemandes;
    @FXML
    private Button buttonAddUser;
    @FXML
    private TextField TXTDescription;
    @FXML
    private Label error_email;
    @FXML
    private Label error_mainsoftware;
    @FXML
    private Label error_name;
    @FXML
    private Label error_role;
    @FXML
    private Label error_description;
    @FXML
    private Label error_password;
    @FXML
    private TextField TXTemail;
    @FXML
    private TextField TXTPassword;
    @FXML
    private TextField TXTName;
    @FXML
    private TextField TXTMainSoftware;
    @FXML
    private Label C9;
    @FXML
    private Label start;
    @FXML
    private TextField TXTRole;
    @FXML
    private TableView<User> tableUser;
    @FXML
    private TableColumn<User, Integer> columnIduser;
    @FXML
    private TableColumn<User, String> columnEmail;
    @FXML
    private TableColumn<User, String> columnName;
    @FXML
    private TableColumn<User, String> columnMainSoftware;
    @FXML
    private TableColumn<User, String> columnRole;
    @FXML
    private TableColumn<User, String> columnDescription;
    @FXML
    private Button buttonUpdateUser;
    @FXML
    private Button buttonDeleteUser;
    @FXML
    private Label emailsign;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DropShadow original = new DropShadow(20, Color.valueOf("#6a9ae7"));
        C9.setEffect(original);
        C9.setOnMouseEntered((MouseEvent event)
                -> {
            DropShadow shadow = new DropShadow(50, Color.valueOf("#6a9ae7"));

            C9.setStyle("-fx-text-fill:#fff");
            C9.setEffect(shadow);
            start.setEffect(shadow);
        });

        C9.setOnMouseExited((MouseEvent event) -> {
            DropShadow shadow = new DropShadow(20, Color.valueOf("#6a9ae7"));
            C9.setStyle("-fx-text-fill:#6a9ae7");
            C9.setEffect(shadow);
            start.setEffect(shadow);

        });
        start.setOnMouseEntered((MouseEvent event)
                -> {
            DropShadow shadow = new DropShadow(50, Color.valueOf("#6a9ae7"));

            C9.setStyle("-fx-text-fill:#fff");
            C9.setEffect(shadow);
            start.setEffect(shadow);
        });

        start.setOnMouseExited((MouseEvent event) -> {
            DropShadow shadow = new DropShadow(20, Color.valueOf("#6a9ae7"));
            C9.setStyle("-fx-text-fill:#6a9ae7");
            C9.setEffect(shadow);
            start.setEffect(shadow);

        });
        // TODO
        tablegestuser();
        // TODO
    }

    @FXML
    private void handleClick(ActionEvent event) {
        if (event.getSource() == btngestuser) {

            pngestuser.toFront();

        }

        if (event.getSource() == btngestdemandes) {

            pngestdemandes.toFront();

        }
    }

    @FXML
    private void ButtonVisitChallenges(ActionEvent event) {

        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("AffChallenges.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ButtonArtWork(ActionEvent event) {

        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("ArtWork.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ButtonVisitFormation(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("ForMation.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void addU(ActionEvent event) {
        boolean isPasswordEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTPassword, error_password, "Password est vide");
        boolean isDescriptionEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTDescription, error_description, "Description est vide");
        boolean isEmailEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTemail, error_email, "email est vide");
        boolean isRoleEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTRole, error_role, "role est vide");
        boolean isNameEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTName, error_name, "name est vide");
        boolean isMainSoftwareEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTMainSoftware, error_mainsoftware, "mainsoftware est vide");
        boolean isEmailValid;
        isEmailValid = Validation.TextFieldValidations.isValidEmailAddress(TXTemail.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        UserCRUD Cc = new UserCRUD();
        String description, email, role, name, mainsoftware, password;
        if (!(isDescriptionEmpty && isEmailEmpty && isRoleEmpty && isNameEmpty && isMainSoftwareEmpty && isEmailValid && isPasswordEmpty)) {
            alert.setTitle("WARNING !!");
            alert.setHeaderText("Cannot Add User because some inputs are missing!! ");
            alert.setContentText("invalid field ");
            alert.showAndWait();
        } else {

            description = TXTDescription.getText();
            email = TXTemail.getText();
            role = TXTRole.getText();
            name = TXTName.getText();
            mainsoftware = TXTMainSoftware.getText();
            password = TXTPassword.getText();

            User g = new User(password, email, role, name, mainsoftware, description);
            System.out.println("TXTUserID : " + g + "\n");
            Cc.createUser(g);

            alert.setTitle("User Registation");

            alert.setHeaderText("Confirm adding User ");
            alert.setContentText("Checking for existing users.. please wait!!");
            alert.showAndWait();
            tablegestuser();

        }
    }

    @FXML
    private void updateU(ActionEvent event) {
        boolean isPasswordEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTPassword, error_password, "Password est vide");
        boolean isDescriptionEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTDescription, error_description, "Description est vide");
        boolean isEmailEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTemail, error_email, "email est vide");
        boolean isRoleEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTRole, error_role, "role est vide");
        boolean isNameEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTName, error_name, "name est vide");
        boolean isMainSoftwareEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTMainSoftware, error_mainsoftware, "mainsoftware est vide");
        boolean isEmailValid;
        isEmailValid = Validation.TextFieldValidations.isValidEmailAddress(TXTemail.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        UserCRUD Cc = new UserCRUD();
        String description, email, role, name, mainsoftware, password;
        myIndex = tableUser.getSelectionModel().getSelectedIndex();
        txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId()));
        if (!(isDescriptionEmpty && isEmailEmpty && isRoleEmpty && isNameEmpty && isMainSoftwareEmpty && isEmailValid && isPasswordEmpty)) {
            alert.setTitle("WARNING !!");
            alert.setHeaderText("Cannot Update User because some inputs Wrong!! ");
            alert.setContentText("invalid field ");
            alert.showAndWait();
        } else {
            description = TXTDescription.getText();
            email = TXTemail.getText();
            role = TXTRole.getText();
            name = TXTName.getText();
            mainsoftware = TXTMainSoftware.getText();
            password = TXTPassword.getText();

            //System.out.println("TXTUserID : " + TXTUserID + "\n");
            User g = new User(txtiduser, password, email, role, name, mainsoftware, description);
            Cc.updateUser(g);
            alert.setTitle("User Update");

            alert.setHeaderText("Confirm the changes? ");
            alert.setContentText("Updated!!");

            alert.showAndWait();
            tablegestuser();
        }
    }

    public void tablegestuser() {
        UserCRUD Cc = new UserCRUD();
        ArrayList<User> users = new ArrayList<>();

        users = (ArrayList<User>) Cc.readUser();

        ObservableList<User> obsl = FXCollections.observableArrayList(users);

        tableUser.setItems(obsl);

        columnIduser.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        columnRole.setCellValueFactory(new PropertyValueFactory<User, String>("roles"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<User, String>("description"));
        columnMainSoftware.setCellValueFactory(new PropertyValueFactory<User, String>("main_software"));

//    columnIduser.setCellValueFactory(f -> f.getValue().id_userProperty());
//    columnName.setCellValueFactory(f -> f.getValue().loginProperty());
//    columnEmail.setCellValueFactory(f -> f.getValue().adresse_emailProperty());
//    columnRole.setCellValueFactory(f -> f.getValue().roleProperty());
//    columnDescription.setCellValueFactory(f -> f.getValue().descriptionProperty());
//    columnMainSoftware.setCellValueFactory(f -> f.getValue().main_softwareProperty());
        tableUser.setRowFactory(tv -> {
            TableRow<User> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = tableUser.getSelectionModel().getSelectedIndex();

                    txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId()));
                    TXTemail.setText(tableUser.getItems().get(myIndex).getEmail());
                    TXTDescription.setText(tableUser.getItems().get(myIndex).getDescription());
                    TXTName.setText(tableUser.getItems().get(myIndex).getLogin());
                    TXTMainSoftware.setText(tableUser.getItems().get(myIndex).getMain_software());
                    TXTRole.setText(tableUser.getItems().get(myIndex).getRoles());

                }
            });
            return myRow;
        });

    }

    @FXML
    private void deleteU(ActionEvent event) {
        UserCRUD Cc = new UserCRUD();

        myIndex = tableUser.getSelectionModel().getSelectedIndex();
        txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId()));

        Cc.deleteUser(txtiduser);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Delete");

        alert.setHeaderText("Confirm deleting the user? ");
        alert.setContentText("User deleted!!!");

        alert.showAndWait();
        tablegestuser();
    }

//    public Label getEmailsign() {
//        return emailsign;
//    }
//
//    public void setEmailsign(String emailsign) {
//        this.emailsign = emailsign;
//    }
}
