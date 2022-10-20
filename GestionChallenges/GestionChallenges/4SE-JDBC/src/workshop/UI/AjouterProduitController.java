/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.UI;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import workshodb.entities.Personne;
import workshopdb.services.PersonneService;


public class AjouterProduitController implements Initializable {

    @FXML
    private Button btn_ajout;
    @FXML
    private TextField txtlib;
    @FXML
    private TextField txtDesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        PersonneService ps = new PersonneService();
//        btn_ajout.setOnAction(e->{
//            try {
//                ps.ajouterPersonne(new Personne(txtlib.getText(), txtDesc.getText()));
//            } catch (SQLException ex) {
//                Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });



        btn_ajout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    ps.ajouterPersonne(new Personne(txtlib.getText(), txtDesc.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
                }
                FXMLLoader loader =new FXMLLoader(getClass().getResource("./Affichage.fxml"));
        Parent root;
                try {
                    root=loader.load();
                    btn_ajout.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
                }
        

            }
        });
    }

}
