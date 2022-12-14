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

    private Integer id;
    private String password;
    private String email;
    private String roles;
    private String login;
    private String main_software;
    private String description;
    private boolean is_verified;
//    private final StringProperty id_user;
//    private final StringProperty adresse_email;
//    private final StringProperty role;
//    private final StringProperty login;
//    private final StringProperty main_software;
//    private final StringProperty description;

    public User(Integer id, String password, String email, String roles, String login, String main_software, String description) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.login = login;
        this.main_software = main_software;
        this.description = description;

    }

    public User(Integer id, String email, String roles, String login, String main_software, String description) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.login = login;
        this.main_software = main_software;
        this.description = description;
    }

    public User(Integer id, String email, String roles, String main_software, String description) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.main_software = main_software;
        this.description = description;
    }

    public User(String password, String email, String roles, String login, String main_software, String description) {
        this.password = password;
        this.email = email;
        this.roles = roles;
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
    public User(String password, String email, String roles, String login, String main_software) {
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.login = login;
        this.main_software = main_software;
    }

    public User(Integer id, String password, String email, String roles, String login, String main_software, String description, boolean is_verified) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.login = login;
        this.main_software = main_software;
        this.description = description;
        this.is_verified = is_verified;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    //    }
    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRoles() {
        return roles;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles='" + roles + '\'' +
                ", login='" + login + '\'' +
                ", main_software='" + main_software + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
