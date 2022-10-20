/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.challange.gui;

import edu.worshop.entites.Challenges;
import edu.worshop.services.ChallengeCrud;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class AffChallengesController implements Initializable {
    int myIndex;
    int txtidStudio;
    int txtidChallenge;
     private Stage stage;
    private Stage scene;
    private Stage root;
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
    private Button Ajouterchallenge;
    @FXML
    private Button delletedchallenge;
    @FXML
    private Button BackHome;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

  table();
    
    
    
    }    
  
    public void table(){
      ChallengeCrud Cc= new ChallengeCrud();
     ArrayList<Challenges> challengess = new ArrayList<>();
              
                     challengess= (ArrayList<Challenges>) Cc.afficheMonChallanges(1);
              
  
    ObservableList<Challenges> obsl = FXCollections.observableArrayList(challengess); 
  
    TableChallenges.setItems(obsl);
    
      
      Columnduree.setCellValueFactory(new  PropertyValueFactory<>("duree"));
    Columnrecompense.setCellValueFactory(new  PropertyValueFactory<>("recompense"));
   Columndescription.setCellValueFactory(new  PropertyValueFactory<>("description"));
  
 TableChallenges.setRowFactory( tv -> {
     TableRow<Challenges> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
            myIndex =  TableChallenges.getSelectionModel().getSelectedIndex();
        
             txtidChallenge=Integer.parseInt(String.valueOf(TableChallenges.getItems().get(myIndex).getIdchallange()));               
         //    txtidStudio=Integer.parseInt(String.valueOf(TableChallenges.getItems().get(myIndex).getStudio_id()));               
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
 
alert.setHeaderText("Delete Challenge? ");
alert.setContentText("Done!");
 
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
                Cc.ajouterChallenges(g);
                Cc.suprimerChallenges(txtidChallenge);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Challenge Registation");
 
alert.setHeaderText("ADD New CHALLENGE? ");
alert.setContentText("Done!");
 
alert.showAndWait();
                table();
        
        
                
                
            
        
    }

    @FXML
    private void BackHomeButton(ActionEvent event) {
        
               try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        
    }
    
}
