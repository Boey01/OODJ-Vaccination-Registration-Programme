/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_vaccineregistrationprogramme;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User extends IO{
    protected String userID,Username,Password,AccType,Email;
    public String Fullname;
    
    
    public User(String un,String pw,String email,String name){ 
        super("user.txt");
        this.Username = un;
        this.Password = pw;
        this.Email = email;
        this.Fullname = name;
        
    }

    // Getter and Setter ---------------------------------------------------------------------------------------------------
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAccType() {
        return AccType;
    }

    public void setAccType(String AccType) {
        this.AccType = AccType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFullmame() {
        return Fullname;
    }

    public void setFullmame(String Fullmame) {
        this.Fullname = Fullname;
    }
    // End of Getter and Setter -----------------------------------------------------------------------------------------
    
    public void Login(String username,String password){
        try{
            String inputUsername = username;
            String inputPassword = password;
        Scanner read = new Scanner(new File(super.path + super.getFileName()));
        
        
        
           }catch (FileNotFoundException e){
            System.out.println("Unable to open file due to "+e);
         }
    
    
    
    }
    
    public void Register(){
        String u = this.Username;
        String p = this.Password;
        String em = this.Email;
        String fn = this.Fullname;
        String at = "People";

    }
    
    
    
    
    
    public void Write(String fileName){
        try {
               BufferedWriter bw = new BufferedWriter(new FileWriter((super.path + super.getFileName()),true));
              bw.write(u +"/"+p +"/"+em +"/"+ fn +"/"+ at +"\n");
              
                bw.flush();
               bw.close();
           } catch (IOException e) {
              System.out.println(e);
        }
    }
}
