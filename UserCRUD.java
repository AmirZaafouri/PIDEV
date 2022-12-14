/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import edu.worshop.entites.User;
import edu.worshop.utils.MyConnexion;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class UserCRUD implements InterfaceUser<User> {

    Connection cnx;

    public UserCRUD() {
        cnx = MyConnexion.getIstance().getConx();
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

        PreparedStatement st = null;
        PreparedStatement stCheckUserExists = null;
        ResultSet resultSet = null;
        PreparedStatement stCheckEmailExists = null;
        ResultSet resultSet1 = null;
        try {
            stCheckUserExists = cnx.prepareStatement("SELECT * FROM user WHERE login = ?");
            stCheckUserExists.setString(1, u.getLogin());
            resultSet = stCheckUserExists.executeQuery();
            stCheckEmailExists = cnx.prepareStatement("SELECT * FROM user WHERE email = ?");
            stCheckEmailExists.setString(1, u.getEmail());
            resultSet1 = stCheckEmailExists.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("user already exists!!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("you cannot use this username.");
                alert.show();
            }
            if (resultSet1.isBeforeFirst()) {
                System.out.println("email already exists!!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("you cannot use this email.");
                alert.show();
            } else {

                String req = "INSERT INTO user(roles, `login`, `password`, email, `main_software`, `description`) VALUES ('" + u.getRoles() + "', '" + u.getLogin() + "', '" + u.getPassword() + "', '" + u.getEmail() + "', '" + u.getMain_software() + "', '" + u.getDescription() + "')";
                st = cnx.prepareStatement(req);
                //Statement st;
                //try {
                //st = cnx.createStatement();
                st.executeUpdate(req);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void updateUser(User u) {
        //PreparedStatement st = null;
        PreparedStatement stCheckUserExists = null;
        ResultSet resultSet = null;
        PreparedStatement stCheckEmailExists = null;
        ResultSet resultSet1 = null;
//        try {
//            stCheckUserExists = cnx.prepareStatement("SELECT * FROM user WHERE login = ?");
//            stCheckUserExists.setString(1, u.getLogin());
//            resultSet = stCheckUserExists.executeQuery();
//            stCheckEmailExists = cnx.prepareStatement("SELECT * FROM user WHERE adresse_email = ?");
//            stCheckEmailExists.setString(1, u.getAdresse_email());
//            resultSet1 = stCheckEmailExists.executeQuery();
//            if (resultSet.isBeforeFirst()) {
//                System.out.println("user already exists!!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("you cannot use this username.");
//                alert.show();
//            }
//            if (resultSet1.isBeforeFirst()) {
//                System.out.println("email already exists!!");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("you cannot use this email.");
//                alert.show();
//            } else {
        String req = "UPDATE user SET id='" + u.getId() + "', roles='" + u.getRoles() + "',login='" + u.getLogin() + "',password='" + u.getPassword() + "',email='" + u.getEmail() + "',main_software='" + u.getMain_software() + "',description='" + u.getDescription() + "' WHERE id=" + u.getId();
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("A user was updated successfully!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) {
        String req = "DELETE FROM user WHERE `id`='" + id + "'";
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("A user was deleted successfully!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List readUser() {
        List<User> list = new ArrayList<>();
        // ObservableList<User> list = FXCollections.observableArrayList();
        try {
            String req;
            req = "SELECT id,login,email,roles,main_software,description FROM user";
            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                User e = new User(rs.getInt("id_user"), rs.getString("adresse_email"), rs.getString("role"), rs.getString("login"), rs.getString("main_software"), rs.getString("description"));
                list.add(e);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public int getNbrUserTotale() {
        int Nb = 0;
        try {
            String req = "select count(*) as 'nb' from user ";

            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Nb = rs.getInt("nb");

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Nb;
    }

    @Override
    public int getNbrArtist() {
        int Nb = 0;
        try {
            String req = "select count(*) as 'nb' from user u where u.roles like 'ARTIST' ";

            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Nb = rs.getInt("nb");

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Nb;
    }

    @Override
    public int getNbrStudio() {
        int Nb = 0;
        try {
            String req = "select count(*) as 'nb' from user u where u.roles like 'MANAGER' ";

            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Nb = rs.getInt("nb");

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Nb;
    }

    @Override
    public int getNbrStudioActif() {
        int nb = 0;
        try {
            String req = "select id_studio ,count(*) as 'nb' from challanges group  by id_studio order by id_studio";

            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                if (rs.getInt("nb") >= 2) {
                    nb++;
                }

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return nb;
    }

    @Override
    public int getNbrStudioNonActif() {

        return getNbrStudio() - getNbrStudioActif();

    }
}
