/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import static SourceCode.Main.USERS;
import interfaceGUI.LoginGUI;
import interfaceGUI.PersonnelHomeScreen;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class User extends IO {

    protected String userID, Username, Password, AccType, Email;
    public String Fullname;
    protected List<User> userlist = new ArrayList<>();

    public User() {
        super("user.txt");
    }

    public User(String un, String pw, String email, String name) {
        super("user.txt");
        this.Username = un;
        this.Password = pw;
        this.Email = email;
        this.Fullname = name;

    }

    public User(String id, String un, String pw, String email, String name, String acctype) {
        super("user.txt");
        this.userID = id;
        this.Username = un;
        this.Password = pw;
        this.Email = email;
        this.Fullname = name;
        this.AccType = acctype;

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

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullmame) {
        this.Fullname = Fullname;
    }

    public List<User> getUserlist() {
        return userlist;
    }
    
    // End of Getter and Setter -----------------------------------------------------------------------------------------

    //***Methods from User class***
    public boolean Login(String username, String password) {
        String directory = super.getDirectory();
        String inputUsername = username;
        String inputPassword = password;
        int found=0;

        Read(directory);

        for (int i = 0; i < userlist.size(); i++) { //LOOP to check user record one by one
            if (userlist.get(i).getUsername().equals(username) && userlist.get(i).getPassword().equals(password)) { //check if theres matching user
                String acctype = userlist.get(i).getAccType();
                switch (acctype) { //verify which account type is this
                    case "Personnel":
                        PersonnelHomeScreen phs = new PersonnelHomeScreen( //navigates to personnel homescreen, while transferring data
                                userlist.get(i).userID,
                                userlist.get(i).Username,
                                userlist.get(i).Password,
                                userlist.get(i).Email,
                                userlist.get(i).Fullname,
                                userlist.get(i).AccType);
                                
                        LogActivity("Login",userlist.get(i).userID,userlist.get(i).AccType);
                        
                        phs.setVisible(true);
                        break;

                    case "People":
                        System.out.println("Account found, People!");
                        //code to open people GUI here
                        break;
                    default:
                        System.out.println("Invalid account type!");
                }
                found = 1;
                break;
            } else { //set found = 0 if not found any matching user
                found = 0;
            }
        }

        if (found == 0) { //if until the end of the user record still don't have match user
            return false;
        } else {
            return true;
        }

    }
    
    public void Logout(){
        LogActivity("Logout",this.userID,this.AccType);
        new LoginGUI().setVisible(true);
    }

    public void Register() {
        String directory = super.getDirectory();
        int latest_userid;

        Read(directory); //load all users from text file

        if (userlist.isEmpty()) {
            latest_userid = 1; // if it is first user, user id = 1
        } else {

            int lastuser = userlist.size() - 1; //get latest user record

            latest_userid = Integer.parseInt(userlist.get(lastuser).getUserID()); //get id from the latest user record
            latest_userid += 1; //increment of user id
        }

        this.userID = Integer.toString(latest_userid);

        Write(directory);
    }

        private void LogActivity(String type, String userid, String acctype){
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String LogTime = "[" + date.format(now) + "] "+ "[" + time.format(now) + "] ";
        
        String logtype = "[" + type + "]" + ": ";
        String user = "User ID: " + userid + " ," +"Account Type: " + acctype;
        
         try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(("src/log.txt"), true));
            bw.write(LogTime + logtype + user + "\n");

            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
        
        
    protected String AccountInfo() {
        return userID + "/" + Username + "/" + Password + "/" + Email + "/" + Fullname + "/" + AccType + "\n";
    }
    
    // ***Override methods from Abstract class IO.***

    @Override
    public void Write(String file) {
        String id = this.userID;
        String u = this.Username;
        String p = this.Password;
        String em = this.Email;
        String fn = this.Fullname;
        String at = "People";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter((file), true));
            bw.write(id + "/" + u + "/" + p + "/" + em + "/" + fn + "/" + at + "\n");

            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void Read(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String currentline;

            while ((currentline = br.readLine()) != null) {
                String[] line = currentline.split("/");
                userlist.add(new User(line[0], line[1], line[2], line[3], line[4], line[5]));
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
