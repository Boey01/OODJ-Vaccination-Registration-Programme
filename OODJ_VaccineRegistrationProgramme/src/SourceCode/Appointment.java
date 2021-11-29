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
public class Appointment extends IO {
    public String apptID,Time,Date,Location,Status,FacilityName,RegisteredUser,usedVacc;
    private List<Appointment> applist = new ArrayList<>();

    public Appointment(String apptID,String time, String date, String loc, String status, String fac, String user, String vacc){
        super("appointment.txt");
        this.apptID = apptID;
        this.Time = time;
        this.Date = date;
        this.Location = loc;
        this.Status = status;
        this.FacilityName = fac;
        this.RegisteredUser = user;
        this.usedVacc = vacc;
    }
    
    // Getter Setter ----------------------------------------
    public String getApptID() {
        return apptID;
    }

    public void setApptID(String apptID) {
        this.apptID = apptID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getFacilityName() {
        return FacilityName;
    }

    public void setFacilityName(String FacilityName) {
        this.FacilityName = FacilityName;
    }    

    public String getRegisteredUser() {
        return RegisteredUser;
    }

    public void setRegisteredUser(String RegisteredUser) {
        this.RegisteredUser = RegisteredUser;
    }

    public String getUsedVacc() {
        return usedVacc;
    }

    public void setUsedVacc(String usedVacc) {
        this.usedVacc = usedVacc;
    }
    
     //End of Getter Setter ------------------------------------------------   
    
    //Methods
    public void RegisterNewAppointment(){
        String directory = super.getDirectory();
        int latest_apptid;

        Read(directory); //load all users from text file

        if (applist.isEmpty()) {
            latest_apptid = 1; // if it is first user, user id = 1
        } else {

            int lastappt = applist.size() - 1; //get latest user record

            latest_apptid = Integer.parseInt(applist.get(lastappt).getApptID()); //get id from the latest user record
            latest_apptid += 1; //increment of user id
        }

        this.apptID = Integer.toString(latest_apptid);
        applist.clear();
        Write(directory);
    }
    
       @Override
    public void Write(String file) {
        String id = this.apptID;
        String time = this.Time;
        String date = this.Date;
        String location = this.Location;
        String status = this.Status;
        String faci = this.FacilityName;
        String userid = this.RegisteredUser;
        String vacc = this.usedVacc;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter((file), true));
            bw.write(id + "/" + time + "/" + date + "/" + location + "/" + status + "/" + faci + "/" + userid + "/" + vacc +"\n");

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
                applist.add(new Appointment(line[0], line[1], line[2], line[3], line[4], line[5],line[6],line[7]));
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    } 
}

