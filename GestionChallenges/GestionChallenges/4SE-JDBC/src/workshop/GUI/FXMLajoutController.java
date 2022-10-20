/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import workshodb.entities.Personne;
import workshopdb.services.PersonneService;

/**
 * FXML Controller class
 *
 * @author Wadii Chamakhi
 */
public class FXMLajoutController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               PersonneService ps = new PersonneService();
               Personne personne = new Personne(nom.getText(), prenom.getText());
               try {
                   ps.ajouterPersonne(personne);
                   Parent root= FXMLLoader.load(getClass().getResource("FXMLaffiche.fxml"));
                   nom.getScene().setRoot(root);
                   
               } catch (SQLException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(FXMLajoutController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
    }    


    
}
