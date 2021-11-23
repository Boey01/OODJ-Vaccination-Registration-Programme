/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_vaccineregistrationprogramme;

public class User {
    protected String userID,Username,Password,AccType,Email;
    public String Fullmame;
    
    
    public User(){       
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
        return Fullmame;
    }

    public void setFullmame(String Fullmame) {
        this.Fullmame = Fullmame;
    }
    // End of Getter and Setter -----------------------------------------------------------------------------------------
    
    public boolean Login(String username,String password){
        String username_file;
        String password_file;
        
      //  return username.equals(username_file) && password.equals(password_file);
    }
    
}
