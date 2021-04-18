/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hannes
 * 
 * 
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;



public class MeetingRequest extends javax.swing.JFrame {

    private static InfDB scrumXPdb;
    private static ArrayList<String> employees = new ArrayList<>();
    private static ArrayList<String> dates = new ArrayList<>();
    private static ArrayList<String> startTimes = new ArrayList<>();
    private static ArrayList<String> endTimes = new ArrayList<>();
    
    public MeetingRequest(InfDB scrumXPdb) {
        initComponents();
        this.scrumXPdb = scrumXPdb;
        fyllCbEmployer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpckEnd = new com.github.lgooddatepicker.components.TimePicker();
        tpckStart = new com.github.lgooddatepicker.components.TimePicker();
        lblHeadline = new javax.swing.JLabel();
        txtfldTitle = new javax.swing.JTextField();
        txtfldPlace = new javax.swing.JTextField();
        txtfldDescription = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaWho = new javax.swing.JTextArea();
        btnAddParticipant = new javax.swing.JButton();
        btnCreateRequest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareaSentRequests = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbxEmployeeNames = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtareaDatesAndTimes = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAddDateAndTime = new javax.swing.JButton();
        jdChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Skicka en m�tesf�rfr�gan");
        lblHeadline.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel2.setText("Titel:");

        jLabel3.setText("Plats:");

        jLabel4.setText("Beskrivning:");

        txtareaWho.setColumns(20);
        txtareaWho.setRows(5);
        jScrollPane1.setViewportView(txtareaWho);

        btnAddParticipant.setText("L�gg till deltagare");
        btnAddParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddParticipantActionPerformed(evt);
            }
        });

        btnCreateRequest.setText("Skapa m�tesf�rfr�gan");
        btnCreateRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRequestActionPerformed(evt);
            }
        });

        txtareaSentRequests.setColumns(20);
        txtareaSentRequests.setRows(5);
        jScrollPane2.setViewportView(txtareaSentRequests);

        jLabel5.setText("Skickade m�tesf�rfr�gningar:");

        jLabel6.setText("M�tesinformation:");

        cmbxEmployeeNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Vem ska f� f�rfr�gan?");

        jLabel8.setText("Starttid:");

        jLabel9.setText("Sluttid:");

        jLabel10.setText("V�lj datum");

        txtareaDatesAndTimes.setColumns(20);
        txtareaDatesAndTimes.setRows(5);
        jScrollPane3.setViewportView(txtareaDatesAndTimes);

        jLabel11.setText("Valda Tider:");

        btnAddDateAndTime.setText("L�gg till datum och tid");
        btnAddDateAndTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDateAndTimeActionPerformed(evt);
            }
        });

        jdChooser.setDateFormatString("yyyy-MM- dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(txtfldTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtfldPlace)
                                    .addComponent(txtfldDescription))
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(69, 69, 69)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(cmbxEmployeeNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddParticipant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(tpckStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tpckEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddDateAndTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3)
                                        .addComponent(btnCreateRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(lblHeadline)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblHeadline)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbxEmployeeNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtfldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtfldPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtfldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tpckStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tpckEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddParticipant)
                    .addComponent(btnCreateRequest)
                    .addComponent(btnAddDateAndTime))
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddParticipantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddParticipantActionPerformed
        
        if(employees.contains(cmbxEmployeeNames.getSelectedItem().toString())){
        JOptionPane.showMessageDialog(null, cmbxEmployeeNames.getSelectedItem().toString() + " har redan lagts till");
        }else{
        employees.add(cmbxEmployeeNames.getSelectedItem().toString());
        }
        txtareaWho.setText("");
        for(String Employee : employees){
            txtareaWho.append(Employee+ "\n");
        } 
    }//GEN-LAST:event_btnAddParticipantActionPerformed

    private void btnAddDateAndTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDateAndTimeActionPerformed
        
        if(Validering.textFieldHasValue((JTextField)jdChooser.getDateEditor().getUiComponent()) && Validering.textFieldHasValue(tpckStart.getComponentTimeTextField()) && Validering.textFieldHasValue(tpckEnd.getComponentTimeTextField())){
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
            String choosenDate = sdf.format(jdChooser.getDate());
            
            String choosenStartTime = tpckStart.getTimeStringOrEmptyString();
            String choosenEndTime = tpckEnd.getTimeStringOrEmptyString();
            
            var startTime = tpckStart.getTime();
            var endTime = tpckEnd.getTime();
            if(endTime.isBefore(startTime)){
                JOptionPane.showMessageDialog(null, "Starttiden m�ste vara innan sluttiden");
            }
            else{
                dates.add(choosenDate);
                startTimes.add(choosenStartTime);
                endTimes.add(choosenEndTime);
            
                txtareaDatesAndTimes.setText("");
                for (int i = 0; i < dates.size(); i++){
                    txtareaDatesAndTimes.append("Datum: " + dates.get(i)+ "\n" + "Starttid: " + startTimes.get(i) + "\n" + "Sluttid: " + endTimes.get(i) + "\n\n");
                }
            }
        }
    }//GEN-LAST:event_btnAddDateAndTimeActionPerformed

    private void btnCreateRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRequestActionPerformed
   
        String date1 = dates.get(0);
        String date2 = dates.get(1);
        String date3 = dates.get(2);
        String starttid1 = startTimes.get(0);
        String starttid2 = startTimes.get(1);
        String starttid3 = startTimes.get(2);
        String sluttid1 = endTimes.get(0);
        String sluttid2 = endTimes.get(1);
        String sluttid3 = endTimes.get(2);
        String titel = txtfldTitle.getText();
        String plats = txtfldPlace.getText();
        String beskrivning = txtfldDescription.getText();
try {
        String fraga = ("Select MAX(Motes_ID_Forfragning) From moten_forfragning");

        String id = scrumXPdb.fetchSingle(fraga);

        int MoteID = Integer.parseInt(id);

        MoteID++;

        id = Integer.toString(MoteID);
        
        
            

        String queryMote = ("insert into moten_forfragning(Motes_ID_Forfragning, MotesNamn, Beskrivning, Startdatum, Plats, StartTid1, StartTid2, StartTid3, SlutTid1, SlutTid2, SlutTid3) values(" + MoteID + ", '" + titel + ", '" + beskrivning + ", '" + plats + ", '" + starttid1 + ", '" + starttid2 + ", '" + starttid3 + ", '" + sluttid1 + ", '" + sluttid2 + ", '" + sluttid3 + "')"
        );
    
    
    String person = txtareaWho.getText();
        String[] arr = person.split("\n");
        var testid = arr[0].split(" ");

        for (String person1 : arr) {
            var personen = person1.split(" ");
            String query = ("insert into motes_deltagare_forfragning(Motes_deltagare_Forfragning_ID, Mote_som_deltas_Forfragning) values(" + personen[2] + ", '" + id + "')");
            scrumXPdb.insert(query);

        }
    
        }catch (InfException ex) {}
    
    
    
    
    
    
    
    
  
        









    }//GEN-LAST:event_btnCreateRequestActionPerformed

    
    
    private void fyllCbEmployer() {
        
        ArrayList<HashMap<String, String>> allEmployees;
        
        try {
            cmbxEmployeeNames.removeAllItems();
            String fraga = "SELECT ANSTALLD_ID, FORNAMN, EFTERNAMN FROM ANSTALLD ORDER BY FORNAMN;";
            allEmployees = scrumXPdb.fetchRows(fraga);
            
            for (HashMap<String, String> employees : allEmployees) {
                
                cmbxEmployeeNames.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
            }
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }
    
    
    private void fillWithUsers() {
        
        String fetchFirstName = "Select Fornamn From Anstalld";
        String fetchLastName = "Select Efternamn From Anstalld";
        ArrayList<String> allFirstNames;
        ArrayList<String> allLastNames;
        try {
            cmbxEmployeeNames.removeAllItems();
            allFirstNames = scrumXPdb.fetchColumn(fetchFirstName);
            allLastNames = scrumXPdb.fetchColumn(fetchLastName);
            for (int i = 0; i < allFirstNames.size(); i++) {
                String bothNames = allFirstNames.get(i) + " " + allLastNames.get(i);
                cmbxEmployeeNames.addItem(bothNames);
            }
            
        } catch (InfException e) {

            JOptionPane.showMessageDialog(null, "L�mpligt fel");

        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDateAndTime;
    private javax.swing.JButton btnAddParticipant;
    private javax.swing.JButton btnCreateRequest;
    private javax.swing.JComboBox<String> cmbxEmployeeNames;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdChooser;
    private javax.swing.JLabel lblHeadline;
    private com.github.lgooddatepicker.components.TimePicker tpckEnd;
    private com.github.lgooddatepicker.components.TimePicker tpckStart;
    private javax.swing.JTextArea txtareaDatesAndTimes;
    private javax.swing.JTextArea txtareaSentRequests;
    private javax.swing.JTextArea txtareaWho;
    private javax.swing.JTextField txtfldDescription;
    private javax.swing.JTextField txtfldPlace;
    private javax.swing.JTextField txtfldTitle;
    // End of variables declaration//GEN-END:variables
}
