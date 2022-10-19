/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.utils;

import edu.worshop.entites.Formation;
import edu.worshop.entites.Studio;
import edu.worshop.services.FormationCrud;

/**
 *
 * @author msi
 */
public class GestionFormations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnexion c = MyConnexion.getIstance();
        Studio S=new Studio(1, "UBISOFT manager", "joseph kerssbi", "joseph123@gmail.com", "55619255", "Studio Manager");
          Studio S2=new Studio(2, "UBISOFT manager", "joseph kerssbi", "joseph123@gmail.com", "55619255", "We are an independent studio from Europe. Our stud..");
        Formation g1=new Formation("Adobe", "1 mois", "Photoshop Course",156);
        Formation g2=new Formation( "Adobe","4 mois", "Adobe  illustrator",65,6);
         Formation g4=new Formation( "Adobe","7 semains", "3D Modeling",35,6);
         Formation g5=new Formation( 1,"Adobe","7 semains", "3D Modeling",35,6);
          Formation g3=new Formation( "Adobe","6 semaine", "Formation en Lightroom ",95,6);
        FormationCrud Cc= new FormationCrud();
       // Cc.ajouterFormation(g1, S);
      // Cc.ajouterFormation(g2, S);
     // Cc.modifierFormation(g5, S);
    // Cc.ajouterFormation(g4, S2);
   // Cc.suprimerFormation(4, 1);
    //System.out.print( "Liste des Formation : \n"+Cc.afficheFormation ()+"\n");
    }
    
}
