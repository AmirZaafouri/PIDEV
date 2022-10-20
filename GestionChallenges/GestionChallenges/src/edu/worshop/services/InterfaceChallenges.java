/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import edu.worshop.entites.StudioNbChallenge;
import java.util.List;

/**
 *
 * @author 
 * @param <Challenges>
 * @param <Studio>
 */
public interface InterfaceChallenges<Challenges,Studio> {
       public void ajouterChallenges (Challenges c);
    public void modifierChallenges (Challenges c);
    public void suprimerChallenges (int idchallenges);
    public List<Challenges> afficheMonChallanges(int idstudio);
    public List<Challenges> afficheChallanges ();
    public List<Challenges> afficheStudioChallanges ();
    public List<StudioNbChallenge> afficheStudioNBChallanges ();
     public int HightRecompenseChallanges ();
}
