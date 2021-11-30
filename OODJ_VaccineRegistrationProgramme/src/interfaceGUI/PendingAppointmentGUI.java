/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGUI;

import SourceCode.Appointment;
import SourceCode.Personnel;
import SourceCode.User;
import SourceCode.UtilityTools;
import SourceCode.Vaccine;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devil
 */
public class PendingAppointmentGUI extends javax.swing.JFrame {

    private List<Appointment> appointments = new ArrayList<>();
    private ArrayList<Vaccine> vaccine = new ArrayList<Vaccine>();
    private DefaultTableModel AppointmentTable;
    private List<User> users = new ArrayList<>();
    private Personnel loggedPS;

    /**
     * Creates new form PendingAppointmentGUI
     */

    public PendingAppointmentGUI() {
        initComponents();
    }

    public PendingAppointmentGUI(List<Appointment> ap, Personnel p) {
        User usr = new User();
        usr.Read(usr.getDirectory());
        users = usr.getUserlist();
        loggedPS = p;

        appointments = ap;
        UtilityTools u = new UtilityTools();
        vaccine = u.LoadVaccine();
        initComponents();

        AppointmentTable = (DefaultTableModel) tblAppointment.getModel();
              for(int i = 0; i<appointments.size();i++){
          if(appointments.get(i).getFacilityName().equals(loggedPS.getFacility())){
              if(appointments.get(i).getStatus().equals("Pending")){
                AppointmentTable.addRow(new Object[]{
                appointments.get(i).getApptID(),
                appointments.get(i).getTime(),
                appointments.get(i).getDate(),
                appointments.get(i).getLocation(),
                appointments.get(i).getFacilityName(),
                appointments.get(i).getStatus(),
                appointments.get(i).getRegisteredUser(),
                appointments.get(i).getUsedVacc()});

              }
          }
      }

        for (int i = 0; i < 24; i++) { //Load Time 0 - 23
            String time = Integer.toString(i);
            comboTime.addItem(time);
        }

        for (int i = 0; i < vaccine.size(); i++) { //Load available vaccines
            int quantity = Integer.parseInt(vaccine.get(i).getQuantity());
            if (quantity > 0) {
                comboVaccine.addItem(vaccine.get(i).getVaccName());
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        jdateDate = new com.toedter.calendar.JDateChooser();
        comboVaccine = new javax.swing.JComboBox<>();
        comboTime = new javax.swing.JComboBox<>();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblVaccine = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblAppointmentID = new javax.swing.JLabel();
        lbltheAppointmentID = new javax.swing.JLabel();
        lbltheFullname = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        lblPassport = new javax.swing.JLabel();
        lblthePassport = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtSearch.setText("Search");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ApptID", "Time", "Date", "Location", "FacilityName", "Status", "UserID", "Vaccine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAppointmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAppointment);

        comboVaccine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pick a vaccine." }));

        comboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pick a time." }));

        lblTime.setText("Time");

        lblDate.setText("Date");

        lblVaccine.setText("Vaccine");

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTitle.setText("Approve Appointment");

        lblAppointmentID.setText("Appointment ID: ");

        lbltheAppointmentID.setText("apptID");

        lbltheFullname.setText("Full name");

        lblFullname.setText("Full Name:");

        lblPassport.setText("Passport:");

        lblthePassport.setText("passport");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTime)
                                .addComponent(lblVaccine)
                                .addComponent(comboVaccine, 0, 267, Short.MAX_VALUE)
                                .addComponent(lblDate)
                                .addComponent(comboTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdateDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnApprove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAppointmentID)
                                    .addComponent(lblFullname)
                                    .addComponent(lblPassport))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblthePassport)
                                    .addComponent(lbltheFullname)
                                    .addComponent(lbltheAppointmentID)))))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppointmentID)
                            .addComponent(lbltheAppointmentID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFullname)
                            .addComponent(lbltheFullname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassport)
                            .addComponent(lblthePassport))
                        .addGap(18, 18, 18)
                        .addComponent(lblTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDate)
                        .addGap(5, 5, 5)
                        .addComponent(jdateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lblVaccine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Search")) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().isEmpty()) {
            txtSearch.setText("Search");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
//        TableRowSorter<DefaultTableModel> sort = new TableRowSorter<DefaultTableModel>(AppointmentTable);
//        tblAppointment.setRowSorter(sort);
//        sort.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));          // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tblAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAppointmentMouseClicked
        int row = tblAppointment.getSelectedRow();
        String userid = AppointmentTable.getValueAt(row, 6).toString();
        lbltheAppointmentID.setText(AppointmentTable.getValueAt(row, 0).toString());

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserID().equals(userid)) {
                lbltheFullname.setText(users.get(i).getFullname());
            }
        }


    }//GEN-LAST:event_tblAppointmentMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new AppointmentGUI(loggedPS).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        int row = tblAppointment.getSelectedRow();

        String time = comboTime.getSelectedItem().toString();
        String date;
        String loc = AppointmentTable.getValueAt(row, 3).toString();
        String status = "First Dose";
        String facility = loggedPS.getFacility();
        String user = AppointmentTable.getValueAt(row, 6).toString();
        String vacc = comboVaccine.getSelectedItem().toString();
        ArrayList<String> appointmentrecords = new ArrayList<>();

        UtilityTools u = new UtilityTools();

        if (comboTime.getSelectedIndex() == 0
                || comboVaccine.getSelectedIndex() == 0
                || jdateDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "There is information not selected!");
        } else if (u.isValidDate(jdateDate.getDate(), time) == false) {
            JOptionPane.showMessageDialog(null, "Please select a valid date");
        } else {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to register an appointment for this user?", "", JOptionPane.OK_CANCEL_OPTION);
            if (input == 0) {

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                date = df.format(jdateDate.getDate());

                for (int i = 0; i < appointments.size(); i++) {
                    if (appointments.get(i).getApptID().equals(this.lbltheAppointmentID.getText())) {
                        appointments.get(i).setTime(time);
                        appointments.get(i).setDate(date);
                        appointments.get(i).setLocation(loc);
                        appointments.get(i).setFacilityName(facility);
                        appointments.get(i).setStatus(status);
                        appointments.get(i).setRegisteredUser(user);
                        appointments.get(i).setUsedVacc(vacc);

                        appointmentrecords.add(appointments.get(i).toString());
                    } else {
                        appointmentrecords.add(appointments.get(i).toString());
                    }
                }
                
                if (appointmentrecords.isEmpty() == false) { //if the string arraylist is not empty
                    Appointment apt = new Appointment();
                    apt.UpdateAppointment(appointmentrecords);

                    this.dispose();
                    new AppointmentGUI(loggedPS).setVisible(true);
                }
                u.UpdateVaccineQuantity("-", vacc);
                JOptionPane.showMessageDialog(null, "Appointment has been created successfully.");

                this.dispose();
                new AppointmentGUI(loggedPS).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnApproveActionPerformed

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
            java.util.logging.Logger.getLogger(PendingAppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PendingAppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PendingAppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PendingAppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PendingAppointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> comboTime;
    private javax.swing.JComboBox<String> comboVaccine;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdateDate;
    private javax.swing.JLabel lblAppointmentID;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblPassport;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaccine;
    private javax.swing.JLabel lbltheAppointmentID;
    private javax.swing.JLabel lbltheFullname;
    private javax.swing.JLabel lblthePassport;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}