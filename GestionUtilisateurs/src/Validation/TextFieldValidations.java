/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class TextFieldValidations {
                public static boolean  isTextFieldNoEmpty(TextField tf){
            boolean b=false;
            if(tf.getText().length() !=0 || !tf.getText().isEmpty())
                b=true;
            return b;
            
            }
              public static boolean  isTextFieldNoEmpty(TextField tf,Label lb,String errorMessage){
            boolean b=true;
            String msg=null;
            if(!isTextFieldNoEmpty(tf)){
             b=false;
            msg=errorMessage;
            
            }
               lb.setText(msg);
            return b;
            
            }

    
    
}
