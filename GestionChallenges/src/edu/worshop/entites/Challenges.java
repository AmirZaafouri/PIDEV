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
public class Challenges {
    private int idchallange;
    private String duree;
    private String recompense;
    private String description;
    private int studio_id;

    public Challenges(String duree, String recomponce, String descrption, int txtidStudio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public Challenges(int idchallange, String duree, String recompense, String description, int studio_id) {
        this.idchallange = idchallange;
        this.duree = duree;
        this.recompense = recompense;
        this.description = description;
        this.studio_id = studio_id;
    }
    public Challenges( String duree, String recompense, String description) {
       
        this.duree = duree;
        this.recompense = recompense;
        this.description = description;
    }

    public Challenges(int idchallange, String duree, String recompense, String description) {
        this.idchallange = idchallange;
        this.duree = duree;
        this.recompense = recompense;
        this.description = description;
    }



    public int getIdchallange() {
        return idchallange;
    }

    public String getDuree() {
        return duree;
    }

    public String getRecompense() {
        return recompense;
    }

    public String getDescription() {
        return description;
    }

    public void setIdchallange(int idchallange) {
        this.idchallange = idchallange;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setRecompense(String recompense) {
        this.recompense = recompense;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Challenges{" + "idchallange=" + idchallange + ", duree=" + duree + ", recompense=" + recompense + ", description=" + description + ", studio_id=" + studio_id + '}'+'\n';
    }

  
    
    
}
