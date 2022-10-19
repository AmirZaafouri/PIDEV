/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.challange.gui;

import edu.worshop.entites.Challenges;
import edu.worshop.services.ChallengeCrud;
import edu.worshop.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AffChallengesController implements Initializable {
    int myIndex;
    int txtidStudio;
    int txtidChallenge;
     @FXML
    private TextField TXTdure;
    @FXML
    private TextField TXTdescrip;
    @FXML
    private TextField TXTrecmpense;
    @FXML
    private TableView<Challenges> TableChallenges;
    @FXML
    private TableColumn<Challenges, String> Columnduree;
    @FXML
    private TableColumn<Challenges, String> Columnrecompense;
    @FXML
    private TableColumn<Challenges, String> Columndescription;
    @FXML
    private TableColumn<Challenges, Integer> ColumnIdChallenge;
    @FXML
    private TableColumn<Challenges, Integer> ColumnIdStudio;
    @FXML
    private Button Ajouterchallenge;
    @FXML
    private Button delletedchallenge;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

  table();
    
    
    
    }    
  
    @FXML
    private void updateChallenge(ActionEvent event) throws SQLException{
        ChallengeCrud Cc= new ChallengeCrud();
        String descrption,duree,recomponce;
        myIndex = TableChallenges.getSelectionModel().getSelectedIndex();
        txtidChallenge = Integer.parseInt(String.valueOf(TableChallenges.getItems().get(myIndex).getIdchallange()));
        txtidStudio=Integer.parseInt(String.valueOf(TableChallenges.getItems().get(myIndex).getStudio_id()));   
            recomponce = TXTrecmpense.getText();
            duree = TXTdure.getText();
            descrption = TXTdescrip.getText();
            System.out.println("txtidChallenge : "+txtidChallenge+"\n");
       
                Challenges g=new Challenges( txtidChallenge,duree, recomponce, descrption,txtidChallenge);
                Cc.modifierChallenges(g);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Challenge Registationn");
 
alert.setHeaderText("U Want the change ");
alert.setContentText("Updateddd!");
 
alert.showAndWait();
                table();
        
       
        
    }
    public void table(){
      ChallengeCrud Cc= new ChallengeCrud();
     ArrayList<Challenges> challengess = new ArrayList<>();
              
                     challengess= (ArrayList<Challenges>) Cc.afficheMonChallanges(1);
              
  
    ObservableList<Challenges> obsl = FXCollections.observableArrayList(challengess); 
  
    TableChallenges.setItems(obsl);
    
    ColumnIdChallenge.setCellValueFactory(new  PropertyValueFactory<>("idchallange"));    
      Columnduree.setCellValueFactory(new  PropertyValueFactory<>("duree"));
    Columnrecompense.setCellValueFactory(new  PropertyValueFactory<>("recompense"));
   Columndescription.setCellValueFactory(new  PropertyValueFactory<>("description"));
   ColumnIdStudio.setCellValueFactory(new  PropertyValueFactory<>("studio_id"));
 TableChallenges.setRowFactory( tv -> {
     TableRow<Challenges> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
            myIndex =  TableChallenges.getSelectionModel().getSelectedIndex();
        
             txtidChallenge=Integer.parseInt(String.valueOf(TableChallenges.getItems().get(myIndex).getIdchallange()));               
             txtidStudio=Integer.parseInt(String.valueOf(TableChallenges.getItems().get(myIndex).getStudio_id()));               
             TXTdure.setText(TableChallenges.getItems().get(myIndex).getDuree());            
             TXTdescrip.setText(TableChallenges.getItems().get(myIndex).getDescription()); 
             TXTrecmpense.setText(TableChallenges.getItems().get(myIndex).getRecompense());
                   
          
        }
     });
        return myRow;
                   });
    
    }

    @FXML
    private void supprimerChallenge(ActionEvent event) {
                ChallengeCrud Cc= new ChallengeCrud();
       
        myIndex = TableChallenges.getSelectionModel().getSelectedIndex();
        txtidChallenge = Integer.parseInt(String.valueOf(TableChallenges.getItems().get(myIndex).getIdchallange()));
      
        
       
          
                Cc.suprimerChallenges(txtidChallenge);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Challenge Registationn");
 
alert.setHeaderText("U Want Deleted Challenge ");
alert.setContentText("SUPPRIMER!");
 
alert.showAndWait();
                table();
        
    }

    @FXML
    private void addChallenge(ActionEvent event) {
                ChallengeCrud Cc= new ChallengeCrud();
        String descrption,duree,recomponce;
        txtidStudio =1;
            recomponce = TXTrecmpense.getText();
            duree = TXTdure.getText();
            descrption = TXTdescrip.getText();
       
       
                Challenges g=new Challenges( duree, recomponce, descrption);
                     System.out.println("txtidChallenge : "+g+"\n");
                Cc.ajouterChallenges(g, txtidStudio);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Challenge Registationn");
 
alert.setHeaderText("U Want to ADD New CHALLENGE ");
alert.setContentText("ADD!");
 
alert.showAndWait();
                table();
        
        
                
                
            
        
    }
    
}
