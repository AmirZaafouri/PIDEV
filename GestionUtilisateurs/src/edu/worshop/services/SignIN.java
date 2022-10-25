/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.worshop.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class SignIN {

    public static void changescene(ActionEvent event, String fxmlFile, String username) {
        Parent root = null;
        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(SignIN.class.getResource(fxmlFile));
                root = loader.load();
                //PlaceholderController placeholderController = loader.getController();
                // placeholderController.setUserInformation(username);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(SignIN.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(username);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    public static void loginUser(ActionEvent event, String email, String password) {
        Connection cnx = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");

            preparedStatement = cnx.prepareStatement("SELECT password FROM user WHERE adresse_email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found!!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided Credentials are incorrect!!");
                alert.show();

            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        changescene(event, "labo.fxml", "Logged In!!");
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

}
