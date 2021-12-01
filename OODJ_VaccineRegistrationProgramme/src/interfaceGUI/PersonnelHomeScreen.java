/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGUI;
import SourceCode.Facility;
import SourceCode.Personnel;
import SourceCode.UtilityTools;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author devil
 */
public class PersonnelHomeScreen extends javax.swing.JFrame {
    private Personnel loggedPS;
    private String facility;
    ArrayList<String> location = new ArrayList<String>();   
    ArrayList<Facility> fac = new ArrayList<>();
    
    /**
     * Creates new form Personnel
     */
    public PersonnelHomeScreen() {
        initComponents();

    }
    

    public PersonnelHomeScreen(String userid,String un,String pw,String email,String name,String at){
    initComponents();
    
    loggedPS = new Personnel(userid,un,pw,email,name,at);
    
    if(loggedPS.CheckForFirstLogin()==true){

    UtilityTools u = new UtilityTools();
    location = u.LoadLocations();
    fac = u.LoadFacilities();

        for(int i = 0; i<location.size();i++){ //Load locations
        comboLocation.addItem(location.get(i));
        }
    
        this.setEnabled(false);
        testdialog.setLocationRelativeTo(null);
        testdialog.setAlwaysOnTop(this.isAlwaysOnTopSupported());
        testdialog.setVisible(true);
        
        
    }
   
    this.lblUsernameTitle.setText(loggedPS.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testdialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        comboFacilityName = new javax.swing.JComboBox<>();
        comboLocation = new javax.swing.JComboBox<>();
        lblLocation = new javax.swing.JLabel();
        lblFacilityName = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        lblWelcomeBack = new javax.swing.JLabel();
        lblUsernameTitle = new javax.swing.JLabel();
        lblWhatToDo = new javax.swing.JLabel();
        btnMyProfile = new javax.swing.JButton();
        btnAppointment = new javax.swing.JButton();
        btnVaccineStorage = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        testdialog.setSize(new java.awt.Dimension(420, 240));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Under which facility you working for?");

        comboFacilityName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pick a facility" }));

        comboLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pick a location" }));
        comboLocation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboLocationItemStateChanged(evt);
            }
        });

        lblLocation.setText("Location");

        lblFacilityName.setText("FacilityName");

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testdialogLayout = new javax.swing.GroupLayout(testdialog.getContentPane());
        testdialog.getContentPane().setLayout(testdialogLayout);
        testdialogLayout.setHorizontalGroup(
            testdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testdialogLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(testdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(testdialogLayout.createSequentialGroup()
                        .addGroup(testdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocation))
                        .addGap(29, 29, 29)
                        .addGroup(testdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFacilityName)
                            .addComponent(comboFacilityName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        testdialogLayout.setVerticalGroup(
            testdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testdialogLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(testdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocation)
                    .addComponent(lblFacilityName))
                .addGap(6, 6, 6)
                .addGroup(testdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFacilityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        lblWelcomeBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcomeBack.setText("Welcome back,");

        lblUsernameTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsernameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsernameTitle.setText("username");

        lblWhatToDo.setText("What do you want to do?");

        btnMyProfile.setText("My Profile");
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileActionPerformed(evt);
            }
        });

        btnAppointment.setText("Appointment");
        btnAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentActionPerformed(evt);
            }
        });

        btnVaccineStorage.setText("Vaccine Storage");
        btnVaccineStorage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineStorageActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(255, 86, 75));
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnVaccineStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblWhatToDo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWelcomeBack))))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsernameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblWelcomeBack, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsernameTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWhatToDo)
                .addGap(18, 18, 18)
                .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVaccineStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
    ProfileGUI pf = new ProfileGUI(loggedPS);
    pf.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentActionPerformed
     
    this.dispose();
    new AppointmentGUI(loggedPS).setVisible(true);               
    }//GEN-LAST:event_btnAppointmentActionPerformed

    private void btnVaccineStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineStorageActionPerformed
        this.dispose();
        new VaccineStorageGUI(loggedPS).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnVaccineStorageActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
    int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?","Confirm Logout",JOptionPane.OK_CANCEL_OPTION);
    if (input==0){
     loggedPS.Logout();
     this.dispose();
    }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
    facility = comboFacilityName.getSelectedItem().toString();
    
    JFrame jf = new JFrame();
    jf.setAlwaysOnTop(true);
    int input = JOptionPane.showConfirmDialog(jf, "You are working for : " +facility+ "\n !! no reverting once set !!","Confirm your work place",JOptionPane.OK_CANCEL_OPTION);
    if (input==0){
     
     testdialog.setVisible(false);
     loggedPS.setFacility(facility);
     loggedPS.RegisterNewPersonnel();
     this.setVisible(true);
     this.setEnabled(true);
     
    }   
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void comboLocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboLocationItemStateChanged
        comboFacilityName.removeAllItems();
        for(int i = 0; i < fac.size();i++){
            if(comboLocation.getSelectedItem().toString().equals(fac.get(i).getFacLocation())==true){
                comboFacilityName.addItem(fac.get(i).getFacName());
            }
        }
        
    }//GEN-LAST:event_comboLocationItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonnelHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonnelHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonnelHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonnelHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonnelHomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAppointment;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnVaccineStorage;
    private javax.swing.JComboBox<String> comboFacilityName;
    private javax.swing.JComboBox<String> comboLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFacilityName;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblUsernameTitle;
    private javax.swing.JLabel lblWelcomeBack;
    private javax.swing.JLabel lblWhatToDo;
    private javax.swing.JDialog testdialog;
    // End of variables declaration//GEN-END:variables
}
