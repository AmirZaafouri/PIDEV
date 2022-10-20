/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.workshop.gui;

import edu.worshop.entites.User;
import edu.worshop.services.UserCRUD;
import Validation.TextFieldValidations;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class CRUDINTERFACEController implements Initializable {

    int myIndex;
    int txtiduser;

    @FXML
    private TextField TXTemail;
    @FXML
    private TextField TXTPassword;
    @FXML
    private TextField TXTName;
    @FXML
    private TextField TXTMainSoftware;
    @FXML
    private Button buttonAddUser;
    @FXML
    private TextField TXTDescription;
    @FXML
    private TextField TXTUserID;
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
    private Label error_email;
    @FXML
    private Label error_mainsoftware;
    @FXML
    private Label error_name;
    @FXML
    private Label error_role;
    @FXML
    private Label error_description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table();
    }

    @FXML
    private void addU(ActionEvent event) {

        boolean isDescriptionEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTDescription, error_description, "Description est vide");
        boolean isEmailEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTemail, error_email, "email est vide");
        boolean isRoleEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTRole, error_role, "role est vide");
        boolean isNameEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTName, error_name, "name est vide");
        boolean isMainSoftwareEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTMainSoftware, error_mainsoftware, "mainsoftware est vide");
        boolean isEmailValid;
        isEmailValid = Validation.TextFieldValidations.isValidEmailAddress(TXTemail.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        UserCRUD Cc = new UserCRUD();
        String description, email, role, name, mainsoftware;
        if (!(isDescriptionEmpty && isEmailEmpty && isRoleEmpty && isNameEmpty && isMainSoftwareEmpty && isEmailValid)) {
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

            User g = new User(email, role, name, mainsoftware, description);
            System.out.println("TXTUserID : " + g + "\n");
            Cc.createUser(g);

            alert.setTitle("User Registation");

            alert.setHeaderText("Confirm adding User ");
            alert.setContentText("User ADDED!!");
            alert.showAndWait();
            table();

        }
    }

    @FXML
    private void updateU(ActionEvent event) {
        boolean isDescriptionEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTDescription, error_description, "Description est vide");
        boolean isEmailEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTemail, error_email, "email est vide");
        boolean isRoleEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTRole, error_role, "role est vide");
        boolean isNameEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTName, error_name, "name est vide");
        boolean isMainSoftwareEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTMainSoftware, error_mainsoftware, "mainsoftware est vide");
        boolean isEmailValid;
        isEmailValid = Validation.TextFieldValidations.isValidEmailAddress(TXTemail.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        UserCRUD Cc = new UserCRUD();
        String description, email, role, name, mainsoftware;
        myIndex = tableUser.getSelectionModel().getSelectedIndex();
        txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId_user()));
        if (!(isDescriptionEmpty && isEmailEmpty && isRoleEmpty && isNameEmpty && isMainSoftwareEmpty && isEmailValid)) {
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

            System.out.println("TXTUserID : " + TXTUserID + "\n");

            User g = new User(txtiduser, email, role, name, mainsoftware, description);
            Cc.updateUser(g);
            alert.setTitle("User Update");

            alert.setHeaderText("Confirm the changes? ");
            alert.setContentText("Updated!!");

            alert.showAndWait();
            table();
        }
    }

    public void table() {
        UserCRUD Cc = new UserCRUD();
        ArrayList<User> users = new ArrayList<>();

        users = (ArrayList<User>) Cc.readUser();

        ObservableList<User> obsl = FXCollections.observableArrayList(users);

        tableUser.setItems(obsl);

        columnIduser.setCellValueFactory(new PropertyValueFactory<User, Integer>("id_user"));
        columnName.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<User, String>("adresse_email"));
        columnRole.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
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

                    txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId_user()));
                    TXTemail.setText(tableUser.getItems().get(myIndex).getAdresse_email());
                    TXTDescription.setText(tableUser.getItems().get(myIndex).getDescription());
                    TXTName.setText(tableUser.getItems().get(myIndex).getLogin());
                    TXTMainSoftware.setText(tableUser.getItems().get(myIndex).getMain_software());
                    TXTRole.setText(tableUser.getItems().get(myIndex).getRole());

                }
            });
            return myRow;
        });

    }

    @FXML
    private void deleteU(ActionEvent event) {
        UserCRUD Cc = new UserCRUD();

        myIndex = tableUser.getSelectionModel().getSelectedIndex();
        txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId_user()));

        Cc.deleteUser(txtiduser);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Delete");

        alert.setHeaderText("Confirm deleting the user? ");
        alert.setContentText("User deleted!!!");

        alert.showAndWait();
        table();
    }

}
