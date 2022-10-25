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
public class User {

    private Integer id_user;
    private String password;
    private String adresse_email;
    private String role;
    private String login;
    private String main_software;
    private String description;
//    private final StringProperty id_user;
//    private final StringProperty adresse_email;
//    private final StringProperty role;
//    private final StringProperty login;
//    private final StringProperty main_software;
//    private final StringProperty description;

    public User(Integer id_user, String password, String adresse_email, String role, String login, String main_software, String description) {
        this.id_user = id_user;
        this.password = password;
        this.adresse_email = adresse_email;
        this.role = role;
        this.login = login;
        this.main_software = main_software;
        this.description = description;

    }

    public User(Integer id_user, String adresse_email, String role, String login, String main_software, String description) {
        this.id_user = id_user;
        this.adresse_email = adresse_email;
        this.role = role;
        this.login = login;
        this.main_software = main_software;
        this.description = description;
    }

    public User(Integer id_user, String adresse_email, String role, String main_software, String description) {
        this.id_user = id_user;
        this.adresse_email = adresse_email;
        this.role = role;
        this.main_software = main_software;
        this.description = description;
    }

    public User(String password, String adresse_email, String role, String login, String main_software, String description) {
        this.password = password;
        this.adresse_email = adresse_email;
        this.role = role;
        this.login = login;
        this.main_software = main_software;
        this.description = description;
    }

//    public User(String adresse_email, String role, String login, String main_software, String description) {
//        this.adresse_email = adresse_email;
//        this.role = role;
//        this.login = login;
//        this.main_software = main_software;
//        this.description = description;
    public User(String password, String adresse_email, String role, String login, String main_software) {
        this.password = password;
        this.adresse_email = adresse_email;
        this.role = role;
        this.login = login;
        this.main_software = main_software;
    }

//    }
    public Integer getId_user() {
        return id_user;
    }

    public String getPassword() {
        return password;
    }

    public String getAdresse_email() {
        return adresse_email;
    }

    public String getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getMain_software() {
        return main_software;
    }

    public String getDescription() {
        return description;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdresse_email(String adresse_email) {
        this.adresse_email = adresse_email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMain_software(String main_software) {
        this.main_software = main_software;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", password=" + password + ", adresse_email=" + adresse_email + ", role=" + role + ", login=" + login + ", main_software=" + main_software + ", description=" + description + '}';
    }

}
