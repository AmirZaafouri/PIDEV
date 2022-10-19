/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import edu.worshop.entites.Formation;
import edu.worshop.entites.Studio;
import edu.worshop.utils.MyConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class FormationCrud implements InterfaceFormations<Formation,Studio> {
  Connection cnx  ;
    public FormationCrud() {
        cnx =MyConnexion.getIstance().getConx() ;
     
    }
    @Override
    public void ajouterFormation(Formation c, Studio s)   {
                String req = "INSERT INTO `formations`( `nom`,`duree`, `description`, `prix`, `studio_id`) VALUES ('"+c.getNom()+"','"+c.getDuree()+"', '"+c.getDescription()+"',"+c.getPrix()+", "+s.getId_user()+")";
        Statement st;
        try {
            st =cnx.createStatement();
            st.executeUpdate(req);
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
 
   @Override
    public void modifierFormation(Formation c, Studio s) {
              String req = "UPDATE formations SET duree = '" + c.getDuree()+"', description = '"+ c.getDescription()+"'  WHERE formation.`idformation`"+"="+c.getIdformation();
        Statement st;
        try {
            st =cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("A user was updated successfully!");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public void suprimerFormation(int idformation  )   {
              String req = "DELETE FROM formations WHERE `idformation`='"+idformation+"'" ;
        Statement st;
        try {
            st =cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("A user was deleted successfully!");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    } 

    @Override
    public List<Formation> afficheFormation() {
       List <Formation> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM formations";
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Formation e = new Formation (rs.getInt("idformation"),rs.getString("nom"), rs.getString("duree"),rs.getString("description"),rs.getInt("prix"),rs.getInt("studio_id"));
                list.add(e);
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }

   

 
    
}
