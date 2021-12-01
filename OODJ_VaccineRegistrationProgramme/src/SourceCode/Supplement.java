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
public class Supplement extends IO {

    public String SupplyID, VaccineName, Quantity, Facility, Status, PersonnelID;
    private List<Supplement> suplist = new ArrayList<>();

    public Supplement() {
        super("supplement.txt");
    }

    public Supplement(String sID, String vName, String qt, String fc, String st, String pID) {
        super("supplement.txt");
        this.SupplyID = sID;
        this.VaccineName = vName;
        this.Quantity = qt;
        this.Facility = fc;
        this.Status = st;
        this.PersonnelID = pID;
    }

    //Getter and Setter
    public String getSupplyID() {
        return SupplyID;
    }

    public void setSupplyID(String SupplyID) {
        this.SupplyID = SupplyID;
    }

    public String getVaccineName() {
        return VaccineName;
    }

    public void setVaccineName(String VaccineName) {
        this.VaccineName = VaccineName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getFacility() {
        return Facility;
    }

    public void setFacility(String Facility) {
        this.Facility = Facility;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getPersonnelID() {
        return PersonnelID;
    }

    public void setPersonnelID(String PersonnelID) {
        this.PersonnelID = PersonnelID;
    }

    public List<Supplement> getSuplist() {
        return suplist;
    }
  

    //End of Getter and Setter
    public void RequestNewSupplement() {
        String directory = super.getDirectory();
        int latest_supid;

        Read(directory); //load all users from text file

        if (suplist.isEmpty()) {
            latest_supid = 1; // if it is first user, user id = 1
        } else {

            int lastsup = suplist.size() - 1; //get latest user record

            latest_supid = Integer.parseInt(suplist.get(lastsup).getSupplyID()); //get id from the latest user record
            latest_supid += 1; //increment of user id
        }

        this.SupplyID = Integer.toString(latest_supid);
        suplist.clear();
        Write(directory);
    }
    
        public void UpdateSupply(ArrayList<String> supply){
        String directory = super.getDirectory();
        
    try {
            FileWriter writer = new FileWriter(directory);
            for (String str : supply) {  //write whole string arraylist into the file
                writer.write(str);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }   
    }

    @Override
    public void Write(String file) {
        String sid = this.SupplyID;
        String vname = this.VaccineName;
        String qt = this.Quantity;
        String fc = this.Facility;
        String st = this.Status;
        String pid = this.PersonnelID;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter((file), true));
            bw.write(sid + "/" + vname + "/" + qt + "/" + fc + "/" + st + "/" + pid + "\n");

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
                suplist.add(new Supplement(line[0], line[1], line[2], line[3], line[4], line[5]));
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return SupplyID + "/" + VaccineName + "/" + Quantity + "/" + Facility + "/" + Status + "/" + PersonnelID + '\n';
    }

    
}
