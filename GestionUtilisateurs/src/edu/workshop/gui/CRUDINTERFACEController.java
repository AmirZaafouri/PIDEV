/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.workshop.gui;

import edu.worshop.entites.User;
import edu.worshop.services.UserCRUD;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class CRUDINTERFACEController implements Initializable {
    int myIndex;
    int txtiduser;

  
    @FXML
    private TextField TXTemail;
    @FXML
    private TextField TXTPassword;
    @FXML
    private TextField TXTName;
    @FXML
    private TextField TXTMainSoftware;
    @FXML
    private Button buttonAddUser;
    @FXML
    private TextField TXTDescription;
    @FXML
    private TextField TXTUserID;
    @FXML
    private TextField TXTRole;
    @FXML
    private TableView<User> tableUser;
    @FXML
    private TableColumn<User, Integer> columnIduser;
    @FXML
    private TableColumn<User, String> columnEmail;
    @FXML
    private TableColumn<User, String> columnName;
    @FXML
    private TableColumn<User, String> columnMainSoftware;
    @FXML
    private TableColumn<User, String> columnRole;
    @FXML
    private TableColumn<User, String> columnDescription;
    @FXML
    private Button buttonUpdateUser;
    @FXML
    private Button buttonDeleteUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table();
//         UserCRUD Cc= new UserCRUD();
//  ArrayList<User> users = new ArrayList<>();
//              
//                     users= (ArrayList<User>) Cc.readUser();
//              
//  
//    ObservableList<User> obsl = FXCollections.observableArrayList(users); 
//  
//    tableUser.setItems(obsl);
//    
//    columnIduser.setCellValueFactory(new  PropertyValueFactory<>("id_user"));    
//      columnEmail.setCellValueFactory(new  PropertyValueFactory<>("adresse_email"));
//    columnRole.setCellValueFactory(new  PropertyValueFactory<>("role"));
//   columnDescription.setCellValueFactory(new  PropertyValueFactory<>("description"));
//   columnMainSoftware.setCellValueFactory(new  PropertyValueFactory<>("main_software"));
//   columnName.setCellValueFactory(new  PropertyValueFactory<>("login"));
//   
    
    }    

//    private void ajouterP(ActionEvent event) {
//        String nom,prenom;
//        nom=NomTXT.getText();   
//        prenom=PrenomTXT.getText();
//      User e=new User(nom, prenom) ;
//      UserCRUD Cc = new UserCRUD();
//      Cc.ajouterpersonne(e);
//
//    }

    @FXML
    private void addU(ActionEvent event) {
        UserCRUD Cc= new UserCRUD();
        String description,email,role,name,mainsoftware;
        //txtidStudio =1;
            description = TXTDescription.getText();
            email = TXTemail.getText();
            role = TXTRole.getText();
            name = TXTName.getText();
            mainsoftware = TXTMainSoftware.getText();
       
       
                User g=new User(email, role, name,mainsoftware, description);
            System.out.println("TXTUserID : "+g+"\n");
                Cc.createUser(g);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("User Registation");
 
alert.setHeaderText("Confirm adding User ");
alert.setContentText("User ADDED!!");
 
alert.showAndWait();
                table();
        
    }

    @FXML
    private void updateU(ActionEvent event) {
        UserCRUD Cc= new UserCRUD();
        String description,email,role,name,mainsoftware;
        myIndex = tableUser.getSelectionModel().getSelectedIndex();
        txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId_user()));
        //txtidStudio=Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getStudio_id()));   
            description = TXTDescription.getText();
            email = TXTemail.getText();
            role = TXTRole.getText();
            name = TXTName.getText();
            mainsoftware = TXTMainSoftware.getText();
            
            System.out.println("TXTUserID : "+TXTUserID+"\n");
       
                User g=new User( txtiduser,email, role, name,mainsoftware, description);
                Cc.updateUser(g);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("User Registation");
 
alert.setHeaderText("Confirm the changes? ");
alert.setContentText("Updated!!");
 
alert.showAndWait();
                table();
    }
    public void table(){
         UserCRUD Cc= new UserCRUD();
  ArrayList<User> users = new ArrayList<>();
              
                     users= (ArrayList<User>) Cc.readUser();
              
  
    ObservableList<User> obsl = FXCollections.observableArrayList(); 
  
    tableUser.setItems(obsl);
    
    columnIduser.setCellValueFactory(new  PropertyValueFactory<>("id_user"));  
    columnName.setCellValueFactory(new  PropertyValueFactory<>("login"));
    columnEmail.setCellValueFactory(new  PropertyValueFactory<>("adresse_email"));
    columnRole.setCellValueFactory(new  PropertyValueFactory<>("role"));
    columnDescription.setCellValueFactory(new  PropertyValueFactory<>("description"));
    columnMainSoftware.setCellValueFactory(new  PropertyValueFactory<>("main_software"));
    
//    columnIduser.setCellValueFactory(f -> f.getValue().id_userProperty());  
//    columnName.setCellValueFactory(f -> f.getValue().loginProperty());
//    columnEmail.setCellValueFactory(f -> f.getValue().adresse_emailProperty());
//    columnRole.setCellValueFactory(f -> f.getValue().roleProperty());
//    columnDescription.setCellValueFactory(f -> f.getValue().descriptionProperty());
//    columnMainSoftware.setCellValueFactory(f -> f.getValue().main_softwareProperty());
    tableUser.setRowFactory( tv -> {
     TableRow<User> myRow = new TableRow<>();
     myRow.setOnMouseClicked (event ->
     {
        if (event.getClickCount() == 1 && (!myRow.isEmpty()))
        {
            myIndex =  tableUser.getSelectionModel().getSelectedIndex();
        
             txtiduser=Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId_user()));               
             //txtidStudio=Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getStudio_id()));               
             TXTemail.setText(tableUser.getItems().get(myIndex).getAdresse_email());            
             TXTDescription.setText(tableUser.getItems().get(myIndex).getDescription()); 
             TXTName.setText(tableUser.getItems().get(myIndex).getLogin());
             TXTMainSoftware.setText(tableUser.getItems().get(myIndex).getMain_software());
             
                   
          
        }
     });
        return myRow;
                   });
    
    }

    @FXML
    private void deleteU(ActionEvent event) {
        UserCRUD Cc= new UserCRUD();
       
        myIndex = tableUser.getSelectionModel().getSelectedIndex();
        txtiduser = Integer.parseInt(String.valueOf(tableUser.getItems().get(myIndex).getId_user()));
      
        
       
          
                Cc.deleteUser(txtiduser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("User Delete");
 
alert.setHeaderText("Confirm deleting the user? ");
alert.setContentText("User deleted!!!");
 
alert.showAndWait();
                table();
    }
    
}
