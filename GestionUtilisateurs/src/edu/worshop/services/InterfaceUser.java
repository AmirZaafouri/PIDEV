/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author msi
 */
public interface InterfaceUser<User> {
    public void createUser (User u);
    public void updateUser (User u);
    public void deleteUser (int  id);
    public List<User> readUser ();
}
