/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import edu.worshop.entites.Studio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author msi
 */
public interface InterfaceFormations<Formation,Studio> {
       public void ajouterFormation (Formation c,Studio s);
    public void modifierFormation (Formation c,Studio s);
    public void suprimerFormation (int idformation);
    public List<Formation> afficheFormation ();
}
