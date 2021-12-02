/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author devil
 */
public class Personnel extends User {

    private String personnelID;
    public String contactNumber,Facility;
    private List<Personnel> pslist = new ArrayList<>();

    public Personnel() {
        super.setFileName("Personnel.txt");

    }

    public Personnel(String userid, String un, String pw, String email, String name, String acctype) {
        super(userid, un, pw, email, name, acctype);
        super.setFileName("Personnel.txt");

    }

    public Personnel(String psid, String userid, String contactnumber,String facility) {
        this.personnelID = psid;
        this.userID = userid;
        this.contactNumber = contactnumber;
        this.Facility = facility;
    }

    //Getter and setter -----------------------
    public String getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(String personnelID) {
        this.personnelID = personnelID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFacility() {
        return Facility;
    }

    public void setFacility(String Facility) {
        this.Facility = Facility;
    }

    //End of getter and setter
    public boolean CheckForFirstLogin() {
        String directory = super.getDirectory();
        int found = 0;
        Read(directory);

        for (int i = 0; i < pslist.size(); i++) {
            if (pslist.get(i).getUserID().equals(this.getUserID())) {// found match ID? break and set personnelID
                this.personnelID = pslist.get(i).getPersonnelID();
                this.contactNumber = pslist.get(i).getContactNumber();
                this.Facility = pslist.get(i).getFacility();
                        
                found = 1;
                break;

            } else {
                found = 0;
            }
        }
        pslist.clear();
        return found == 0;
    }
    
    public void RegisterNewPersonnel(){
        String directory = super.getDirectory();
            int latest_psid;
            Read(directory);
            
            if (pslist.isEmpty()) {
                latest_psid = 1; // if it is first personnel, ps id = 1
            } else {

                int lastps = pslist.size() - 1; //get latest personnel record
                latest_psid = Integer.parseInt(pslist.get(lastps).getPersonnelID()); //get id from the latest personnel record
                latest_psid += 1; //increment of personnel id
            }

            this.personnelID = Integer.toString(latest_psid);

            Write(directory);
    }

    public void UpdatePersonnelProfile(String un, String password, String email, String name, String pnumber, String facility) {
        String dircPers = super.getDirectory();
        super.setFileName("user.txt");
        String dircUsr = super.getDirectory();
        String loggedID = this.getUserID();
        List<String> Usersrecord = new ArrayList<String>();
        List<String> Personnelrecord = new ArrayList<String>();
        
        userlist.clear();
        pslist.clear();

        super.Read(dircUsr);
        this.Read(dircPers);

        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getUserID().equals(loggedID)) {
                User tempusr = new User(loggedID, un, password, email, name, "Personnel");
                userlist.set(i, tempusr); //replace this matching id record with the new record(tempusr)
                Usersrecord.add(userlist.get(i).AccountInfo()); //add the modified records into string arraylist

            } else {
                Usersrecord.add(userlist.get(i).AccountInfo()); //add normal unchanged records
            }
        }

        try {
            FileWriter writer = new FileWriter(dircUsr);
            for (String str1 : Usersrecord) { //write whole string arraylist into the file
                writer.write(str1);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        // Now we update the personnel text file

        for (int n = 0; n < pslist.size(); n++) {
            if (pslist.get(n).getUserID().equals(loggedID)) {
                Personnel tempps = new Personnel(this.personnelID, loggedID, pnumber,facility);
                pslist.set(n, tempps);
                Personnelrecord.add(pslist.get(n).AccountInfo());

            } else {
                Personnelrecord.add(pslist.get(n).AccountInfo());
            }
        }

        try {
            FileWriter writer = new FileWriter(dircPers);
            for (String str : Personnelrecord) {
                writer.write(str);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        userlist.clear();
        pslist.clear();
    }

    @Override
    public String AccountInfo() {
        return personnelID + "/" + userID + "/" + contactNumber + "/" + Facility +"\n";
    }

    @Override
    public void Write(String file) {
        String psid = this.personnelID;
        String usid = this.userID;
        String number = this.contactNumber;
        String facility = this.Facility;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter((file), true));
            bw.write(psid + "/" + usid + "/" + number + "/" + facility +"\n");

            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    ;
    
    @Override
    public void Read(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String currentline;

            while ((currentline = br.readLine()) != null) {
                String[] line = currentline.split("/");
                pslist.add(new Personnel(line[0], line[1], line[2],line[3]));

            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
