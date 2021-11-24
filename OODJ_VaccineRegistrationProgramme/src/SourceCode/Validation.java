/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author devil
 */
public class Validation {
    
    public boolean isValidUsername(String content){
    String regex = "^[A-Za-z]\\w{3,14}$"; //Starts with alphabert, min 4, max 15, no special characters
  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the username is empty
        // return false
        if (content == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(content);
  
        // Return if the username
        // matched the ReGex
        return m.matches();
}
       public boolean isValidPassword(String content){
        if (content.contains(" ")==true){ // no spaces
            return false;
        }
       
     
        if (content == null) { //not null,empty
            return false;
        }
        
        if (content.length()< 4 | content.length() > 20){ //minimum 4, maximum 20 characters
            return false;
        }
        
        return true;
    }
       
       
    public boolean isValidName(String content){
        String regex = "^[\\p{L} .'-]+$"; //allow unicode property, and 
        Pattern p = Pattern.compile(regex);
     
        if (content == null) {
            return false;
        }
        
        Matcher m = p.matcher(content);
        
        return m.matches();
    }
    
    public boolean isValidEmail(String content){
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return content.matches(regex);
    }
}
