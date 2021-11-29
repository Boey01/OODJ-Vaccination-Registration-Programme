/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author devil
 */
public class UtilityTools {
    
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
    
    public boolean isValidPhoneNumber(String content){
        if(content == null){
            return false;
        }
        
        try{
            Integer.parseInt(content);
            return true;
        }catch(NumberFormatException e){ 
            System.out.println(e);
            return false;
        }
        
    }
    
    public boolean isValidDate(Date d, String time){
        int hour = Integer.parseInt(time);
       d.setHours(hour); 
      
        LocalDateTime now = LocalDateTime.now();  
        Date current = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        return (d.compareTo(current) > 0);
     
    }
    
    public ArrayList<String> LoadLocations(){
        ArrayList<String> locations = new ArrayList<String>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/location.txt"));
            String currentline;

            while ((currentline = br.readLine()) != null) {
                
                locations.add(currentline);

            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return locations;
    }
    
    public ArrayList<Facility> LoadFacilities(){
        ArrayList<Facility> facilities = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/facility.txt"));
            String currentline;

            while ((currentline = br.readLine()) != null) {
                String[] line = currentline.split("/");
                facilities.add(new Facility(line[0], line[1]));              

            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return facilities;
    }
    
    public ArrayList<Vaccine> LoadVaccine(){
        ArrayList<Vaccine> vaccine = new ArrayList<Vaccine>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/vaccine.txt"));
            String currentline;

            while ((currentline = br.readLine()) != null) {
                String[] line = currentline.split("/");
                vaccine.add(new Vaccine(line[0], line[1], line[2], line[3], line[4]));

            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return vaccine;
    }
    
    public void UpdateVaccineQuantity(String type, int n, String vaccine ){
        List<Vaccine> vaclist = new ArrayList<>();
        ArrayList<String> vaccrecords = new ArrayList<>()
                ;
   //load all vaccine info into objectlist
             try {
            BufferedReader br = new BufferedReader(new FileReader("src/vaccine.txt"));
            String currentline;

            while ((currentline = br.readLine()) != null) {
                String[] line = currentline.split("/");
                vaclist.add(new Vaccine(line[0], line[1], line[2],line[3],line[4]));

            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        for (int i = 0; i < vaclist.size(); i++) {
            if (vaclist.get(i).getVaccName().equals(vaccine)) {
                int quantity = Integer.parseInt(vaclist.get(i).getQuantity());
                if(type=="+"){quantity = quantity + n;}
                if(type=="-"){quantity = quantity - n;}
                String newQuantity = String.valueOf(quantity);
                 
                vaclist.get(i).setQuantity(newQuantity);
                Vaccine changedquantityvaccine = vaclist.get(i);
                

                vaccrecords.add(vaclist.get(i).toString()); //add the modified records into string arraylist

            } else {
                vaccrecords.add(vaclist.get(i).toString()); //add normal unchanged records
            }
        }

        try {
            FileWriter writer = new FileWriter("src/vaccine.txt");
            for (String str : vaccrecords) {  //write whole string arraylist into the file
                writer.write(str);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
