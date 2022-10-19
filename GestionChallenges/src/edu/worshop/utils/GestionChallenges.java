/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.utils;

import edu.worshop.entites.Challenges;
import edu.worshop.entites.Studio;
import edu.worshop.services.ChallengeCrud;

/**
 *
 * @author msi
 */
public class GestionChallenges {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnexion c = MyConnexion.getIstance();
        Studio S=new Studio(1, "UBISOFT manager", "joseph kerssbi", "joseph123@gmail.com", "55619255", "Studio Manager");
          Studio S2=new Studio(2, "UBISOFT manager", "joseph kerssbi", "joseph123@gmail.com", "55619255", "We are an independent studio from Europe. Our stud..");
        Challenges g1=new Challenges( "1 mois", "500$", "create modelling 3D Using Blender and 3DMAX only");
        Challenges g2=new Challenges( "4 mois", "2000$", "Designing the Structures and Tools of The Forgotten Realms");
         Challenges g4=new Challenges( "7 semains", "1000$", "Environment Design Designing the Locations of The Forgotten Realms ...");
          Challenges g3=new Challenges( 3,"6 semaine", "2000$", "Designing the Structures and Tools of The Forgotten Realms");
        ChallengeCrud Cc= new ChallengeCrud();
      //  Cc.ajouterChallenges(g2, S);
      // Cc.ajouterChallenges(g2, S);
     // Cc.modifierChallenges(g3, S);
    // Cc.ajouterChallenges(g4, S2);
   // Cc.suprimerChallenges(3, 1);
       System.out.print("LIST DES CHALLENGES :\n"+ Cc.afficheMonChallanges(1));
        System.out.print("------------------------------------------------------------ \n");
        System.out.print("LIST DES CHALLENGES :\n"+ Cc.afficheStudioChallanges() );
         System.out.print("------------------------------------------------------------ \n");
        System.out.print("LIST DE NBR CHALLANGE PUBLIER PAR CHAQUE STUDIO{ :\n"+ Cc.afficheStudioNBChallanges() );
             System.out.print("------------------------------------------------------------ \n");
        
                      System.out.print("Aghla RECOMPONNCE :"+ Cc.HightRecompenseChallanges()+'\n' );
    }
    
}
