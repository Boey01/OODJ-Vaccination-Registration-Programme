/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import interfaceGUI.AppointmentGUI;
import interfaceGUI.CreateAppointmentGUI;
import interfaceGUI.LoginGUI;
import interfaceGUI.PersonnelHomeScreen;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author devil
 */
public class Main {
public static List<User> USERS;
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        USERS = new ArrayList<>();
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
//    PersonnelHomeScreen ps = new PersonnelHomeScreen();
//    ps.setVisible(true);
//        new CreateAppointmentGUI().setVisible(true);
    }
    
}
