/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import edu.worshop.entites.Challenges;
import edu.worshop.entites.Studio;
import edu.worshop.entites.StudioNbChallenge;
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
public class ChallengeCrud implements InterfaceChallenges<Challenges,Studio> {
  Connection cnx  ;
    public ChallengeCrud() {
        cnx =MyConnexion.getIstance().getConx() ;
     
    }
    @Override
    public void ajouterChallenges(Challenges c)   {
                String req = "INSERT INTO challangeaccepted(`duree`, `recompense`, `description`) VALUES ('"+c.getDuree()+"', '"+c.getRecompense()+"', '"+c.getDescription()+"')";
 
              String req1 = "DELETE FROM challanges WHERE `id_challange`="+c.getIdchallange()+"" ;
                Statement st;
        try {
            st =cnx.createStatement();
            st.executeUpdate(req);
            st.executeUpdate(req1);
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
 
   @Override
    public void modifierChallenges(Challenges c) {
              String req = "UPDATE challanges SET duree = '" + c.getDuree()+"', recompense = '"+ c.getRecompense()+"', description = '"+ c.getDescription()+"'  WHERE challanges.`id_challange`"+"="+c.getIdchallange();
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
    public void suprimerChallenges(int idchallenges )   {
              String req = "DELETE FROM challanges WHERE `id_challange`="+idchallenges+"" ;
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
    public List<Challenges> afficheMonChallanges(int idstudio) {
            List <Challenges> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM challanges where id_studio="+idstudio+"";
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Challenges e = new Challenges (rs.getInt("id_challange"), rs.getString("duree"),rs.getString("recompense"),rs.getString("description"));
                list.add(e);
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
       
    }
    @Override
    public List<Challenges> afficheChallanges() {
       List <Challenges> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM challanges";
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Challenges e = new Challenges (rs.getInt("id_challange"), rs.getString("duree"),rs.getString("recompense"),rs.getString("description"),rs.getInt("id_studio"));
                list.add(e);
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
//Affichage avec jointure GROUPE CHALLANGE PAR ID_STUDIO
    @Override
    public List<Challenges> afficheStudioChallanges() {
          List <Challenges> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM challanges c inner join user u on c.id_studio = u.id_user GROUP  BY c.id_studio ";
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Challenges e = new Challenges (rs.getInt("id_challange"), rs.getString("duree"),rs.getString("recompense"),rs.getString("description"),rs.getInt("id_studio"));
                list.add(e);
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
//KOl STUDIO NBR DU CHALLANGE LMHABTHOM
    @Override
    public List<StudioNbChallenge> afficheStudioNBChallanges() {
                  List <StudioNbChallenge> list = new ArrayList<>();
        try {
            String req = "select id_studio ,count(*) as 'nb' from challanges group  by id_studio order by id_studio";   
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                StudioNbChallenge e = new StudioNbChallenge (rs.getInt("id_studio"),rs.getInt("nb"));
                list.add(e);
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }
//AGHLA CHALLENGE MAWJOUD
    @Override
    public int HightRecompenseChallanges() {
              
        try {
            String req = "SELECT MAX( CAST(TRIM(TRAILING '$' FROM recompense) AS INT)) as 'max' FROM challanges";
            
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               // System.out.print("Dkhalet llwhile");
                int  e = rs.getInt("max");
               // System.out.print("\n7atit lmax fi e\n");
                return e;
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
      return 0;
    }

 


 
    
}
