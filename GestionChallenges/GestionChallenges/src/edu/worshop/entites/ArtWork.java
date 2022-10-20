/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.entites;

/**
 *
 * @author Sami
 */
public class ArtWork {
    
    private int idArtWork;
    private String TagsArt;
    private String TitreArt;
    private String descriptionArt;

    public ArtWork(int idArtWork, String TagsArt, String TitreArt, String descriptionArt) {
        this.idArtWork = idArtWork;
        this.TagsArt = TagsArt;
        this.TitreArt = TitreArt;
        this.descriptionArt = descriptionArt;
    }

    public ArtWork() {
    }

    public ArtWork(String TagsArt, String TitreArt, String descriptionArt) {
        this.TagsArt = TagsArt;
        this.TitreArt = TitreArt;
        this.descriptionArt = descriptionArt;
    }

    public ArtWork(int aInt, String string, String string0, String string1, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdArtWork() {
        return idArtWork;
    }

    public String getTagsArt() {
        return TagsArt;
    }

    public String getTitreArt() {
        return TitreArt;
    }

    public String getDescriptionArt() {
        return descriptionArt;
    }

    public void setIdArtWork(int idArtWork) {
        this.idArtWork = idArtWork;
    }

    public void setTagsArt(String TagsArt) {
        this.TagsArt = TagsArt;
    }

    public void setTitreArt(String TitreArt) {
        this.TitreArt = TitreArt;
    }

    public void setDescriptionArt(String descriptionArt) {
        this.descriptionArt = descriptionArt;
    }
    
    
    
    
    
}
