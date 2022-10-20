/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.entites;

/**
 *
 * @author msi
 */
public class StudioNbChallenge {
  private  int NbrChallangePublier;
  private  int IdStudio;

    public StudioNbChallenge(int NbrChallangePublier, int IdStudio) {
        this.NbrChallangePublier = NbrChallangePublier;
        this.IdStudio = IdStudio;
    }

   

    public void setNbrChallangePublier(int NbrChallangePublier) {
        this.NbrChallangePublier = NbrChallangePublier;
    }

    public void setIdStudio(int IdStudio) {
        this.IdStudio = IdStudio;
    }

    public int getNbrChallangePublier() {
        return NbrChallangePublier;
    }

    public int getIdStudio() {
        return IdStudio;
    }
     @Override
    public String toString() {
        return "" + "IdStudio=" + IdStudio +"   NbrChallangePublier=" + NbrChallangePublier +  '}'+'\n';
    }
}
