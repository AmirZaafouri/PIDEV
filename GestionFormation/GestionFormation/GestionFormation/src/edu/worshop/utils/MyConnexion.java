/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.utils;

import edu.worshop.entites.Formation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author msi
 */
public class MyConnexion {
       String url= "jdbc:mysql://localhost:3306/cloud9";
    String user= "root";
    String pwd= "";
    private Connection conx;
    public static MyConnexion instance;
    private MyConnexion()
            {
        try {
             conx = DriverManager.getConnection(url,user ,pwd);
            System.out.println("Coonnexion Jawha Bhi !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
}
    public static MyConnexion getIstance(){//tnajem taaytelha maghir ma taamel instance llclasse just kan be esm lclasse
            if(instance == null)
                instance = new MyConnexion();
            return instance;
            }

    public Connection getConx() {
        return conx;
    }
  
    }
    

