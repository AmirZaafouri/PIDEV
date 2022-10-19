/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4infob1jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshodb.entities.Personne;
import workshopdb.services.PersonneService;
import workshopdb.utils.MyDB;


/**
 *
 * @author bhk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonneService productService = new PersonneService();
        Personne p = new  Personne("ali", " Ben Ali");
        

        try {
            //productService.ajouterPersonne(p);
            productService.ajouterProduitPs(p);
            System.out.println("personne ajouté");
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout"+ex.getMessage());
        }
        
        try {
            for(Personne p2 : productService.getAllPersonnes()){
                System.out.println(p2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
    
}
