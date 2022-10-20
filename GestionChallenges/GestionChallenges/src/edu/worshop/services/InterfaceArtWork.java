/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import edu.worshop.entites.ArtWork;
import java.util.List;

/**
 *
 * @author Sami
 * @param <ArtWork>
 * @param <Studio>
 */
public interface InterfaceArtWork <ArtWork,Studio>{
    
    public void ajouterArtWork (ArtWork Aw);
    public void suprimerArtWork (int id_artwork );
    public List<ArtWork> afficheArtWork(int idstudio);

}
