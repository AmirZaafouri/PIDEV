/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.workshop.gui;

import edu.worshop.entites.Formation;
import edu.worshop.entites.Studio;
import edu.worshop.services.FormationCrud;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Observable;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.event.ListDataEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Dali
 */
public class AfficherFormationController implements Initializable {
    int txtidForamtion;
    int myIndex;
    @FXML
    private TableColumn<Formation, Integer> tid;
    @FXML
    private TableColumn<Formation, String> tnom;
    @FXML
    private TableColumn<Formation, String> tduree;
    @FXML
    private TableColumn<Formation, Integer> tprix;
    @FXML
    private TextField mnom;
    @FXML
    private TextField mduree;
    @FXML
    private TextField mdisc;
    @FXML
    private Spinner<Integer> mprix;
    @FXML
    private Button ModifierF;
    @FXML
    private Button SupprimerF;
    @FXML
    private TableView<Formation> tableF;
    @FXML
    private TableColumn<Formation, Integer> tIdstudio;
    @FXML
     private TableColumn<Formation, String>tdiscp;
    @FXML
    private AnchorPane sceneAffichage;
    @FXML
    private Button back;
    public void setTableF(TableView<Formation> tableF) {
        this.tableF = tableF;
    }

    public TableView<Formation> getTableF() {
        return tableF;
    }
   
    
    public TextField getMnom() {
        return mnom;
    }

    public TextField getMduree() {
        return mduree;
    }

    public TextField getMdisc() {
        return mdisc;
    }

    public Spinner<Integer> getMprix() {
        return (Spinner<Integer>) mprix;
    }

    public void setMnom(String mnom) {
        this.mnom.setText(mnom);
    }

    public void setMduree(String mduree) {
        this.mduree.setText(mduree);
    }

    public void setMdisc(String mdisc) {
        this.mdisc.setText(mdisc);
    }

    public void setMprix(Spinner<Integer> mprix) {
        this.mprix = (Spinner<Integer>) mprix;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  FormationCrud Cc= new FormationCrud();
  ArrayList<Formation> list = new ArrayList<>();
              
                     list= (ArrayList<Formation>) Cc.afficheFormation();
              
  
    ObservableList<Formation> obsl = FXCollections.observableArrayList(list); 
  
    tableF.setItems(obsl);
    
    tid.setCellValueFactory(new  PropertyValueFactory<>("idformation"));    
      tduree.setCellValueFactory(new  PropertyValueFactory<>("duree"));
    tnom.setCellValueFactory(new  PropertyValueFactory<>("nom"));
   tprix.setCellValueFactory(new  PropertyValueFactory<>("studio_id"));
   tIdstudio.setCellValueFactory(new  PropertyValueFactory<>("prix"));
   tdiscp.setCellValueFactory(new  PropertyValueFactory<>("description"));
  
    
  }

    @FXML
    private void ModifierF(ActionEvent event) {
    FormationCrud Cc= new FormationCrud();
        String descrption,duree,nom;
         int prix=100;
            myIndex = tableF.getSelectionModel().getSelectedIndex();
            txtidForamtion = Integer.parseInt(String.valueOf(tableF.getItems().get(myIndex).getIdformation()));
            nom = mnom.getText();
            duree = mduree.getText();
            descrption = mdisc.getText();
             //mprix.setEditable(true);
            //prix=mprix.getValue();
            
               try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AfficherFormation.fxml"));
            Parent root= loader.load();
            AfficherFormationController ac = loader.getController();
            ac.setMdisc(descrption);
            ac.setMnom(nom);
            ac.setMduree(duree);
            mnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
           
               //Studio S=new Studio(1, "UBISOFT manager", "joseph kerssbi", "joseph123@gmail.com", "55619255", "Studio Manager");
                

               // Formation g=new Formation( txtidForamtion,nom, duree, descrption,prix,txtidForamtion);
               // Cc.modifierFormation(g,S);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Challenge Registationn");
 
alert.setHeaderText("U Want the change ");
alert.setContentText("Updateddd!");
 
alert.showAndWait();
                
    }
    @FXML
    private void SupprimerF(ActionEvent event) {
              FormationCrud Cc= new FormationCrud();
                      //Studio S=new Studio(1, "UBISOFT manager", "joseph kerssbi", "joseph123@gmail.com", "55619255", "Studio Manager");

        myIndex = tableF.getSelectionModel().getSelectedIndex();
        txtidForamtion = Integer.parseInt(String.valueOf(tableF.getItems().get(myIndex).getIdformation()));
      
        
       
          
                Cc.suprimerFormation(txtidForamtion);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle(" Suppression");
 
alert.setHeaderText("Vous voulez supprimer cette formation? ");

 
alert.showAndWait();
               try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AfficherFormation.fxml"));
            Parent root= loader.load();
            AfficherFormationController ac = loader.getController();
            mnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
    
  Parent root = FXMLLoader.load(getClass().getResource("AjouterFormation.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }

}
