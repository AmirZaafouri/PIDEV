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
import static java.sql.JDBCType.NULL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Dali
 */
public class AjouterFormationController implements Initializable {

    @FXML
    private TextField fnom;
    @FXML
    private TextField fduree;
    @FXML
    private TextField fdisc;
    @FXML
    public  Spinner<Integer> fprix;
    @FXML
    private Button AjouterF;
    @FXML
    private Label msg;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
	

    }
public void validation()throws Exception{                

    if(fnom.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setTitle("Information Dialog");
        fail.setHeaderText("Erreur");
        fail.setContentText("Vous devez ajouter un nom!");
        fail.showAndWait();
        throw new Exception("Exception message");
  
     
    }
    if(fduree.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setTitle("Information Dialog");
        fail.setHeaderText("Erreur");
        fail.setContentText("Vous devez ajouter une durée!");
        fail.showAndWait();
           throw new Exception("Exception message");
  
     
    }
    if(fdisc.getText().trim().isEmpty()){
        Alert fail= new Alert(AlertType.INFORMATION);
        fail.setTitle("Information Dialog");
        fail.setHeaderText("Erreur");
        fail.setContentText("Vous devez ajouter une description!");
        fail.showAndWait();
           throw new Exception("Exception message");
  
     
    }
}
    @FXML
    private void AjouterF(ActionEvent event) throws Exception{
    
         String nom,description,duree;
         final int prix;
        nom=fnom.getText();
        description=fdisc.getText();
        duree=fduree.getText();
  
    
       //SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(100,1000 ,100, 5);
              //fprix.setValueFactory(valueFactory);
        fprix.setEditable(true);
        prix=fprix.getValue();
      
      
     //String s=String.valueOf(prix);
        Formation e= new Formation(nom,duree,description,prix);
        FormationCrud Cc= new FormationCrud();
        Studio S=new Studio(1, "UBISOFT manager", "joseph kerssbi", "joseph123@gmail.com", "55619255", "Studio Manager");
    
        try {
            validation();
                         Cc.ajouterFormation(e, S);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

             

    
        
                             //msg.setVisible(true);
                              Alert alert = new Alert(AlertType.INFORMATION);

alert.setTitle("Information Dialog");

alert.setHeaderText(null);

alert.setContentText("Formation ajoutée avec succés!");
  alert.showAndWait();



  //FXMLLoader loader= new FXMLLoader(getClass().getResource("AfficherFormation.fxml"));     
    
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AfficherFormation.fxml"));
            Parent root= loader.load();
            AfficherFormationController ac = loader.getController();
           
            //ac.setMnom(nom);
            //ac.setMduree(duree);
            //ac.setMdisc(description);
            //ac.setList(Cc.afficherpersonne().toString());
            fnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void display (ActionEvent event) throws Exception{
    
    Parent root = FXMLLoader.load(getClass().getResource("AfficherFormation.fxml"));
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
}
    


