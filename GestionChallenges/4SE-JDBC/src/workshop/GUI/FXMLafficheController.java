/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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
    private TableView<Personne> table;
    @FXML
    private TableColumn<Personne,Integer> idColumn;
    @FXML
    private TableColumn<Personne, String> nomColumn;
    @FXML
    private TableColumn<Personne, String> prenomColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PersonneService ps = new PersonneService();
        ArrayList<Personne> personnes;
        try {
            personnes = (ArrayList<Personne>) ps.getAllPersonnes();
            ObservableList obs = FXCollections.observableArrayList(personnes);
            table.setItems(obs);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLafficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    
    
}
