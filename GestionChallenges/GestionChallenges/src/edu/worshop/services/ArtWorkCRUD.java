/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import edu.worshop.entites.ArtWork;
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
 * @author Sami
 */
public class ArtWorkCRUD implements InterfaceArtWork<ArtWork,Studio> {
       
    Connection cnx;
    public ArtWorkCRUD() {
        cnx =MyConnexion.getIstance().getConx() ;
     
    }
    @Override
    public void ajouterArtWork(ArtWork Aw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suprimerArtWork(int idchallenges) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  List<ArtWork> afficheArtWork(int idstudio) {
            List <ArtWork> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM artwork where id_studio="+idstudio+"";
            Statement st;
            st =cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ArtWork a = new ArtWork (rs.getInt("id_artwork"), rs.getString("tags"),rs.getString("titre"),rs.getString("description"));
                
                list.add(a);
            }
            
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return list;
    }




    
}
