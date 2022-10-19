/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.UI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author wiemhjiri
 */
public class AffichageController implements Initializable {

    @FXML
    private TableColumn<Personne, Integer> id;
    @FXML
    private TableColumn<Personne, String> lib;
    @FXML
    private TableColumn<Personne, String> desc;
    @FXML
    private TableView<Personne> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PersonneService ps = new PersonneService();
        try {
            ArrayList<Personne> arrayList = (ArrayList<Personne>) ps.getAllPersonnes();
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            table.setItems(obs);

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            lib.setCellValueFactory(new PropertyValueFactory<>("nom"));
            desc.setCellValueFactory(new PropertyValueFactory<>("pre"));
        } catch (SQLException ex) {
            Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
