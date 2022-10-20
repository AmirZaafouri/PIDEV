/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.challange.gui;

import edu.worshop.entites.ArtWork;
import edu.worshop.services.ArtWorkCRUD;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import edu.worshop.entites.Studio;

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class ArtWorkController implements Initializable {

    private Stage stage;
    private Stage scene;
    private Stage root;
    int myIndex;
    int txtidStudio;
    int txtidArtWork;
    
    @FXML
    private TextField TXTdescrip;
    @FXML
    private TableColumn<ArtWork, String> Columntag;
    @FXML
    private TableColumn<ArtWork, String> Columntitre;
    @FXML
    private TableColumn<ArtWork, String> Columndescription;
    @FXML
    private Button BackHome;
    @FXML
    private TableView<ArtWork> TableArt;
    @FXML
    private TextField TXTtags;
    @FXML
    private TextField TXTtitre;
    @FXML
    private Button delletedArt;
    @FXML
    private Button AjouterArt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void TableArt(){
        txtidStudio =1;
     ArtWorkCRUD Cc= new ArtWorkCRUD();
     ArrayList<ArtWork> ArtWorkk = new ArrayList<>();
              
                     ArtWorkk= (ArrayList<ArtWork>) Cc.afficheArtWork(1);
              
  
    ObservableList<ArtWork> obsl = FXCollections.observableArrayList(ArtWorkk); 
  
    TableArt.setItems(obsl);
    
      
      Columntag.setCellValueFactory(new  PropertyValueFactory<>("Tags"));
    Columntitre.setCellValueFactory(new  PropertyValueFactory<>("Titre"));
   Columndescription.setCellValueFactory(new  PropertyValueFactory<>("description"));
  
 TableArt.setRowFactory( tv -> {
     TableRow<ArtWork> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
            myIndex =  TableArt.getSelectionModel().getSelectedIndex();
        
             txtidArtWork=Integer.parseInt(String.valueOf(TableArt.getItems().get(myIndex).getIdArtWork()));               
            // txtidStudio=Integer.parseInt(String.valueOf(TableArt.getItems().get(myIndex).getIdArtWork()));
             TXTtags.setText(TableArt.getItems().get(myIndex).getTagsArt());            
             TXTdescrip.setText(TableArt.getItems().get(myIndex).getDescriptionArt()); 
             TXTtitre.setText(TableArt.getItems().get(myIndex).getTitreArt());
                   
          
        }
     });
        return myRow;
                   });
    
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

    @FXML
    private void supprimerArt(ActionEvent event) {
    }

    @FXML
    private void addArt(ActionEvent event) {
    }




    
}
