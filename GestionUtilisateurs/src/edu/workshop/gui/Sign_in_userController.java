/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.workshop.gui;

import edu.worshop.entites.User;
import edu.worshop.services.UserCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Sign_in_userController implements Initializable {

    @FXML
    private TextField TXTmail;
    @FXML
    private PasswordField TXTpass;
    @FXML
    private Button btnlogin;
    @FXML
    private Hyperlink create_acc;
    @FXML
    private Label start;
    @FXML
    private Label C9;
    @FXML
    private AnchorPane loginform;
    @FXML
    private AnchorPane signupform;
    @FXML
    private Button btnsignup;
    @FXML
    private Hyperlink create_acc1;
    @FXML
    private TextField TXTmail1;
    @FXML
    private PasswordField TXTpass1;
    @FXML
    private TextField TXTusername1;
    @FXML
    private TextField TXTsoftware1;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private Label start1;
    @FXML
    private Label C91;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;

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

        // -------------------------------------------------------------------------------------------------------------------------------------
        C91.setEffect(original);
        C91.setOnMouseEntered((MouseEvent event)
                -> {
            DropShadow shadow = new DropShadow(50, Color.valueOf("#6a9ae7"));

            C91.setStyle("-fx-text-fill:#fff");
            C91.setEffect(shadow);
            start1.setEffect(shadow);
        });

        C91.setOnMouseExited((MouseEvent event) -> {
            DropShadow shadow = new DropShadow(20, Color.valueOf("#6a9ae7"));
            C91.setStyle("-fx-text-fill:#6a9ae7");
            C91.setEffect(shadow);
            start1.setEffect(shadow);

        });
        start1.setOnMouseEntered((MouseEvent event)
                -> {
            DropShadow shadow = new DropShadow(50, Color.valueOf("#6a9ae7"));

            C91.setStyle("-fx-text-fill:#fff");
            C91.setEffect(shadow);
            start1.setEffect(shadow);
        });

        start1.setOnMouseExited((MouseEvent event) -> {
            DropShadow shadow = new DropShadow(20, Color.valueOf("#6a9ae7"));
            C91.setStyle("-fx-text-fill:#6a9ae7");
            C91.setEffect(shadow);
            start1.setEffect(shadow);

        });

        ObservableList<String> list = FXCollections.observableArrayList("ARTIST", "MANAGER");
        combobox.setItems(list);

    }

    @FXML
    public void login(ActionEvent event) throws Exception {
        Connection cnx = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String password = TXTpass.getText();
        String adminpass = "admin";
        String adminmail = "admin@esprit.tn";

        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");

            preparedStatement = cnx.prepareStatement("SELECT password FROM user WHERE adresse_email = ?");
            preparedStatement.setString(1, TXTmail.getText());
            resultSet = preparedStatement.executeQuery();
            if (adminmail.equals(TXTmail.getText()) && adminpass.equals(password)) {
                Parent root = FXMLLoader.load(getClass().getResource("AdminRegister.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found!!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided Credentials are incorrect!!");
                alert.show();

            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
//                        btnlogin.getScene().getWindow().hide();
//                        Parent root = FXMLLoader.load(getClass().getResource("AdminRegister.FXML"));
//                        Scene scene = new Scene(root);
//                        Stage stage = new Stage();
//                        stage.setScene(scene);
//                        stage.show();
                        /*      FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminRegister.fxml"));
                        Parent root = loader.load();
                        AdminRegisterController ac = loader.getController();
                        btnlogin.getScene().setRoot(root);*/
                        Parent root = FXMLLoader.load(getClass().getResource("labo.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        System.out.println("Password did not match!!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The Provided Credentials are incorrect!!!!");
                        alert.show();

                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void signup(ActionEvent event) {
        String s = combobox.getSelectionModel().getSelectedItem().toString();
        boolean isPasswordEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTpass1, l2, "*");
        boolean isEmailEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTmail1, l1, "*");
        //boolean isRoleEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(s, error_role, "*");
        boolean isNameEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTusername1, l3, "*");
        boolean isMainSoftwareEmpty = Validation.TextFieldValidations.isTextFieldNoEmpty(TXTsoftware1, l4, "*");
        boolean isEmailValid;
        isEmailValid = Validation.TextFieldValidations.isValidEmailAddress(TXTmail1.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        UserCRUD Cc = new UserCRUD();
        String email, role, name, mainsoftware, password;
        if (!(isEmailEmpty && isNameEmpty && isMainSoftwareEmpty && isEmailValid && isPasswordEmpty)) {
            alert.setTitle("WARNING !!");
            alert.setHeaderText("Cannot Add User because some inputs are missing!! ");
            alert.setContentText("invalid field ");
            alert.showAndWait();
        } else {

            email = TXTmail1.getText();
            role = s;
            name = TXTusername1.getText();
            mainsoftware = TXTsoftware1.getText();
            password = TXTpass1.getText();

            User g = new User(password, email, role, name, mainsoftware);
            System.out.println("TXTUserID : " + g + "\n");
            Cc.createUser(g);

            alert.setTitle("User Registation");

            alert.setHeaderText("Successfully created account! ");
            alert.setContentText("Checking for existing users.. please wait!!");
            alert.showAndWait();

        }

    }

    public void changeForm(ActionEvent event) {
        if (event.getSource() == create_acc1) {
            signupform.setVisible(false);
            loginform.setVisible(true);
        } else if (event.getSource() == create_acc) {
            signupform.setVisible(true);
            loginform.setVisible(false);
        }
    }
}
