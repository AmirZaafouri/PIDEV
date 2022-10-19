/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;
import edu.worshop.entites.User;
import edu.worshop.utils.MyConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author msi 
 */
public class UserCRUD implements InterfaceUser<User>  {
   Connection cnx  ;
    public UserCRUD() {
        cnx =MyConnexion.getIstance().getConx() ;
    }
  
   // Connection cnx =MyConnexion.getIstance().getConx() ;
   
//    public void ajouterpersonne(User p) { 
//       String req = "INSERT INTO user(`role`, `login`, `password`, `adresse_email`, `main_software`, `description`) VALUES ('"+p.getRole()+"', '"+p.getLogin()+"', '"+p.getPassword()+"', '"+p.getAdresse_email()+"', '"+p.getMain_software()+"', '"+p.getDescription()+"')";
//        Statement st;
//        try {
//            st =cnx.createStatement();
//          //  st.executeUpdate(req);
//        }catch (SQLException ex){
//            System.err.println(ex.getMessage());
//        }
//        
//    }
//
//
//
//    @Override
//    public void modifierpersonne(User e) {
//      // String req = "UPDATE etudiant SET nom = '" + e.getNom()+"', prenom = '"+ e.getPrenom()+"'  WHERE etudiant.`id`"+"="+e.getId();
//        Statement st;
//        try {
//            st =cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("A user was updated successfully!");
//        }catch (SQLException ex){
//            System.err.println(ex.getMessage());
//        }
//    }
//    
//
//  
//
//    @Override
//    public List<User> ajouterpersonne() {
//        List <User> list = new ArrayList<>();
//        try {
//            String req = "SELECT * FROM etudiant";
//            Statement st;
//            st =cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while(rs.next()){
//                User e = new User (rs.getInt(1), rs.getString("nom"),rs.getString("prenom"));
//                list.add(e);
//            }
//            
//        }
//        catch (SQLException ex){
//            System.err.println(ex.getMessage());
//        }
//        return list;
//    }
//  
//   
//
//
//    @Override
//    public void suprimerpersonne(int id) {
//       String req = "DELETE FROM etudiant WHERE `id`='"+id+"'" ;
//        Statement st;
//        try {
//            st =cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("A user was deleted successfully!");
//        }catch (SQLException ex){
//            System.err.println(ex.getMessage());
//        }
//    }
//
//  

    public void createUser(User u) {
       String req = "INSERT INTO user(`role`, `login`, `password`, `adresse_email`, `main_software`, `description`) VALUES ('"+u.getRole()+"', '"+u.getLogin()+"', '"+u.getPassword()+"', '"+u.getAdresse_email()+"', '"+u.getMain_software()+"', '"+u.getDescription()+"')";
        Statement st;
        try {
            st =cnx.createStatement();
            st.executeUpdate(req);
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void updateUser(User u) {
        String req = "UPDATE user SET id_user='"+u.getId_user()+"', role='"+u.getRole()+"',login='"+u.getLogin()+"',password='"+u.getPassword()+"',adresse_email='"+u.getAdresse_email()+"',main_software='"+u.getMain_software()+"',description='"+u.getDescription()+"' WHERE id_user="+u.getId_user();
        Statement st;
        try {
            st =cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("A user was updated successfully!");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void deleteUser(int id) {
        String req = "DELETE FROM user WHERE `id_user`='"+id+"'" ;
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
    public List readUser() {
        List <User> list = new ArrayList<>();
        try {
            String req;
            req = "SELECT id_user,login,adresse_email,role,main_software,description FROM user";
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                User e = new User (rs.getInt("id_user"), rs.getString("adresse_email"), rs.getString("role"),rs.getString("login"), rs.getString("main_software"), rs.getString("description"));
                list.add(e);
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }

  
   

  
 
}
