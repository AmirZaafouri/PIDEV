/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.workshop.gui;

import edu.worshop.services.SignIN;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HomeUsersController implements Initializable {

    @FXML
    private TextField TXTmail;
    @FXML
    private TextField TXTpass;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnResetPassword;
    @FXML
    private Label error_combination;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        btnLogin.setOnAction(new EventHandler<ActionEvent>{
//        @Override
//        public void handle(ActionEvent event){
//            SignIN.loginUser(event,TXTmail.getText(),TXTpass.getText());
//        }
//    }
        // TODO
    }

    @FXML
    private void handle(ActionEvent event) {
        SignIN.loginUser(event, TXTmail.getText(), TXTpass.getText());
    }

}
