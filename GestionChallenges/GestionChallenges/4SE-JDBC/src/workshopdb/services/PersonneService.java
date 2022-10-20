/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopdb.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workshodb.entities.Personne;
import workshopdb.utils.MyDB;

/**
 *
 * @author bhk
 */
public class PersonneService {

    Connection connexion;

    public PersonneService() {
        connexion = MyDB.getInstance().getConnection();
    }

    public void ajouterPersonne(Personne p) throws SQLException {
        String req = "INSERT INTO `personne` (`nom`, `prenom`) VALUES ( '"
                + p.getNom() + "', '" + p.getPrenom() + "') ";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    public void ajouterProduitPs(Personne p) throws SQLException {
        String req = "INSERT INTO `personne` (`nom`, `prenom`) "
                + "VALUES ( ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.executeUpdate();
    }

    public List<Personne> getAllPersonnes() throws SQLException {

        List<Personne> presonnes = new ArrayList<>();
        String req = "select * from personne";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Personne p = new Personne(rst.getInt("id")
                    , rst.getString("nom")
                    , rst.getString("prenom"));
            presonnes.add(p);
        }
        return presonnes;
    }
}
