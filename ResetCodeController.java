/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.challange.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ResetCodeController implements Initializable {

    @FXML
    private Button btnreset;
    @FXML
    private TextField txtResetPass;
    @FXML
    private TextField txtVerResetPass;
    public String user;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private Button btnreset1;

    public void setUser(String user) {
        this.user = user;
    }

    //initComponents();
//
//    }
    @FXML
    public void Resetb(ActionEvent event) {
        if (txtResetPass.getText().equals(txtVerResetPass.getText())) {
            try {
                System.out.println(user);
                String updateQuery = "UPDATE `user` SET `password`=? WHERE email like ? ";
                con = DriverManager.getConnection("jdbc:mysql://localhost/ahmeddb", "root", "");
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, txtVerResetPass.getText());
                pst.setString(2, user);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reset Successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "password do not match");
        }

    }

    @FXML
    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("frontoffice.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
