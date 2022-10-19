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
public class Studio {
   private int id_user;
   private String role;
   private String login;
   private String emailadresse;

    public Studio(int id_user) {
        this.id_user = id_user;
    }
   private String password;
   private String mainsoftware;
   private String description;

    public Studio(int id_user, String role, String login, String emailadresse, String password, String description) {
        this.id_user = id_user;
        this.role = role;
        this.login = login;
        this.emailadresse = emailadresse;
        this.password = password;
        this.description = description;
    }

    public int getId_user() {
        return id_user;
    }

    public String getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getEmailadresse() {
        return emailadresse;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmailadresse(String emailadresse) {
        this.emailadresse = emailadresse;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Studio{" + "id_user=" + id_user + ", role=" + role + ", login=" + login + ", emailadresse=" + emailadresse + ", password=" + password + ", mainsoftware=" + mainsoftware + ", description=" + description + '}';
    }




    
}
