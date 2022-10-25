/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.utils;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
public class MyConnexion {

    String url = "jdbc:mysql://localhost:3306/users";
    String user = "root";
    String pwd = "";
    private Connection conx;
    public static MyConnexion instance;

    private MyConnexion() {
        try {
            conx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Coonnexion Established !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static MyConnexion getIstance() {//tnajem taaytelha maghir ma taamel instance llclasse just kan be esm lclasse
        if (instance == null) {
            instance = new MyConnexion();
        }
        return instance;
    }

    public Connection getConx() {
        return conx;
    }

}
