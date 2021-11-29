/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

/**
 *
 * @author devil
 */
public class Vaccine {
    public String vaccineID,vaccName,DoseNum,weeksPerDose,quantity;

    
    public Vaccine(String vID,String vName, String DoseNum, String weeksPerDose, String quantity){
        this.vaccineID = vID;
        this.vaccName = vName;
        this.DoseNum = DoseNum;
        this.weeksPerDose = weeksPerDose;
        this.quantity = quantity;
    }
    
    //Getter Setter
    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccName() {
        return vaccName;
    }

    public void setVaccName(String vaccName) {
        this.vaccName = vaccName;
    }

    public String getDoseNum() {
        return DoseNum;
    }

    public void setDoseNum(String DoseNum) {
        this.DoseNum = DoseNum;
    }

    public String getWeeksPerDose() {
        return weeksPerDose;
    }

    public void setWeeksPerDose(String weeksPerDose) {
        this.weeksPerDose = weeksPerDose;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    //End of getter setter
    
    @Override
    public String toString(){
        return this.vaccineID +"/"+this.vaccName+"/"+this.DoseNum+"/"+this.weeksPerDose+"/"+this.quantity+"\n";
    }
}
