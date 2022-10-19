/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.worshop.utils;
import edu.worshop.entites.User;
import edu.worshop.services.UserCRUD;
import edu.worshop.utils.MyConnexion;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author msi
 */
public class Firstproject {

 
    public static void main(String[] args) {
       MyConnexion c = MyConnexion.getIstance();
       User u1 = new User("ok","op","oio","po","io","oiiu");
       User u2 = new User(4,"ok","op","oio","po","io","oiiud");//lezem el id yebda mawjoud fel BD fel update
     
       UserCRUD Pc= new UserCRUD();
       //Pc.createUser(u1);
       //Pc.updateUser(u2);
       //Pc.deleteUser(4);
       System.out.println(Pc.readUser());
      
        //   Pc.ajouterpersonne(e1);
       //Pc.ajouterpersonne(e2);
   //    Pc.ajouterpersonne(e3);
    //   Pc.suprimerpersonne(2);
 
   
     //  Pc.modifierpersonne(e5);
       
    }

  
    
}
