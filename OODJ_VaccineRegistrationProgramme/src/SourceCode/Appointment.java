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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author devil
 */
public class Appointment extends IO {
    public String apptID,Time,Date,Location,FacilityName,Status,RegisteredUser,usedVacc;
    private List<Appointment> applist = new ArrayList<>();

    
    public Appointment(){
        super("appointment.txt");
    }
    
    public Appointment(String apptID,String time, String date, String loc, String fac, String status, String user, String vacc){
        super("appointment.txt");
        this.apptID = apptID;
        this.Time = time;
        this.Date = date;
        this.Location = loc;
        this.FacilityName = fac;
        this.Status = status;
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

    public String getFacilityName() {
        return FacilityName;
    }

    public void setFacilityName(String FacilityName) {
        this.FacilityName = FacilityName;
    }    

    public String getStatus() {
    return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
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

        Read(directory); //load all appointments from text file

        if (applist.isEmpty()) {
            latest_apptid = 1; // if it is first appointment,id = 1
        } else {

            int lastappt = applist.size() - 1; //get latest appointment record

            latest_apptid = Integer.parseInt(applist.get(lastappt).getApptID()); //get id from the latest appoitnment record
            latest_apptid += 1; //increment of appointment id
        }

        this.apptID = Integer.toString(latest_apptid);
        applist.clear();
        Write(directory);
    }
    
    public void UpdateAppointment(ArrayList<String> appt){
        String directory = super.getDirectory();
        
    try {
            FileWriter writer = new FileWriter(directory);
            for (String str : appt) {  //write whole string arraylist into the file
                writer.write(str);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }   
    }
    
    
    
    public void UpdateAppointmentStatus(String id,String status,String time){
        try{
        String dirc = super.getDirectory();
        ArrayList<String> appointmentrecords = new ArrayList<>();
        this.Read(dirc);
        
                
                    for (int i = 0; i < applist.size(); i++) {
                        if (applist.get(i).getApptID().equals(id)) {
                         int week = Integer.parseInt(new UtilityTools().GetDoseWeek(applist.get(i).getUsedVacc()));//get week per dose
                         week = week*7; //week to day
                         
                         Calendar cal = Calendar.getInstance();
                         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                         cal.setTime(sdf.parse(applist.get(i).getDate())); // Get old date and convert it into Calender 
                         cal.add(Calendar.DAY_OF_YEAR,week);//add days
                         String newdate = sdf.format(cal.getTime()); // new date, in string format
                                                  
                           
                            applist.get(i).setStatus(status);
                            applist.get(i).setDate(newdate);
                            applist.get(i).setTime(time);
                            appointmentrecords.add(applist.get(i).toString());
                        } else {
                            appointmentrecords.add(applist.get(i).toString());
                        }
                    }
                    
                    this.UpdateAppointment(appointmentrecords);
        
    }catch(ParseException e){System.out.println(e);}
        
    }
    
    //OVerrides
    
       @Override
    public void Write(String file) {
        String id = this.apptID;
        String time = this.Time;
        String date = this.Date;
        String location = this.Location;
        String faci = this.FacilityName;
        String status = this.Status;
        String userid = this.RegisteredUser;
        String vacc = this.usedVacc;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter((file), true));
            bw.write(id + "/" + time + "/" + date + "/" + location + "/" + faci + "/" + status + "/" + userid + "/" + vacc +"\n");

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
    
    public String toString(){
        return apptID +"/"+Time+"/"+Date+"/"+Location+"/"+FacilityName+"/"+Status+"/"+RegisteredUser+"/"+usedVacc+"\n";
    }
}

