/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4infob1jdbc;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
       
        Parent root=FXMLLoader.load(getClass().getResource("../workshop/UI/AjouterProduit.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
