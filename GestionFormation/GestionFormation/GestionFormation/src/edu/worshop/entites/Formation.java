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
public class Formation {
    private int idformation;
    private String nom;
   private String duree;
    private String description;
    private int studio_id;
    private int prix;

    public Formation(String nom,String duree, String description, int prix) {
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.prix = prix;
       
    }

    public Formation(int idformation, String nom,String duree, String description, int studio_id, int prix) {
        this.idformation = idformation;
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.studio_id = studio_id;
        this.prix = prix;
       

    }

    public Formation(String nom, String duree, String description, int studio_id, int prix) {
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.studio_id = studio_id;
        this.prix = prix;
       

    }

    public Formation(String nom, String duree, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    

 



    public int getIdformation() {
        return idformation;
    }

    public String getDuree() {
        return duree;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public int getPrix() {
        return prix;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    
    public String getDescription() {
        return description;
    }

    public void setIdformation(int idformation) {
        this.idformation = idformation;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Formation{" + "idformation=" + idformation + ", duree=" + duree + ", description=" + description + ", studio_id=" + studio_id + ", prix=" + prix + '}'+'\n';
    }


    
    
}
