/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4infob1jdbc;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import workshodb.entities.Personne;
import workshopdb.services.PersonneService;

/**
 * FXML Controller class
 *
 * @author Wadii Chamakhi
 */
public class FXMLafficheController implements Initializable {

    @FXML
    private TableColumn<Personne, Integer> id;
    @FXML
    private TableColumn<Personne, String> nom;
    @FXML
    private TableColumn<Personne, String> prenom;
    @FXML
    private TableView<Personne> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        PersonneService ps= new PersonneService();
        ArrayList<Personne> personnes = new ArrayList<>();
        try {
            personnes=(ArrayList<Personne>) ps.getAllPersonnes();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLafficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Personne> obsl = FXCollections.observableArrayList(personnes);
        table.setItems(obsl);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        
    }    
    
}
