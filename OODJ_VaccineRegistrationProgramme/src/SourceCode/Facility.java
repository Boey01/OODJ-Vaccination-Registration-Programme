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
public class Facility {
    public String FacName,FacLocation;
    
    public Facility(String Name, String Loc){
        this.FacName = Name;
        this.FacLocation = Loc;
    }

    public String getFacName() {
        return FacName;
    }

    public void setFacName(String FacName) {
        this.FacName = FacName;
    }

    public String getFacLocation() {
        return FacLocation;
    }

    public void setFacLocation(String FacLocation) {
        this.FacLocation = FacLocation;
    }
    
}
