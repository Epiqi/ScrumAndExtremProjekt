


import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 46736
 */
public class MeetingRequest extends javax.swing.JFrame {
    
    private static InfDB scrumXPdb;
    private String userName;
    
    public MeetingRequest(InfDB scrumXPdb, String userName) {
        this.userName = userName;
        this.scrumXPdb = scrumXPdb;
        String id = "";
        initComponents();
        System.out.println(userName);
        setCbMeeting();
        //String selectedCbItem = CbMeeting.getSelectedItem().toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        CbMeeting = new javax.swing.JComboBox<>();
        lblPlace = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        cbxTime1 = new javax.swing.JCheckBox();
        cbxTime2 = new javax.swing.JCheckBox();
        cbxTime3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("M�tes f�rfr�gningar");

        CbMeeting.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "v�lj m�te" }));
        CbMeeting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CbMeetingMouseClicked(evt);
            }
        });
        CbMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbMeetingActionPerformed(evt);
            }
        });

        lblPlace.setText("Plats:");

        txtAreaDescription.setEditable(false);
        txtAreaDescription.setColumns(20);
        txtAreaDescription.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescription);

        cbxTime1.setText(":Tid");
        cbxTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTime1ActionPerformed(evt);
            }
        });

        cbxTime2.setText(":Tid");
        cbxTime2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTime2ActionPerformed(evt);
            }
        });

        cbxTime3.setText(":Tid");

        jButton1.setText("Skicka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbltitle.setText("Titel:");

        jButton2.setText("Tillbaka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbldate.setText("Datum");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(49, 612, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbltitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CbMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbldate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDate)
                                .addContainerGap())
                            .addComponent(cbxTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTime2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTime3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltitle)
                    .addComponent(CbMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlace)
                            .addComponent(lblDate))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxTime1)
                                .addGap(18, 18, 18)
                                .addComponent(cbxTime2)
                                .addGap(28, 28, 28)
                                .addComponent(cbxTime3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbldate)))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTime1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTime1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //insert into motes_aterskick values (1,'12:00','13:00','14:00','5','1')
        String userID = "";
        String meetingID = "";
        String meetingName = CbMeeting.getSelectedItem().toString();
        int h = CbMeeting.getSelectedIndex() ;
        String time1 = "";
        String time2 = "";
        String time3 = "";
        System.out.println("h�r �r jag:"+meetingName);
        if(meetingName.equals("v�lj m�te")){
        
        JOptionPane.showMessageDialog(null, "V�lj ett m�te!");
        
        }else{
        
        if(cbxTime1.isSelected()){
        try{
        time1 = scrumXPdb.fetchSingle("select starttid1 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
            
        } else{
        time1 = null;
        
        }
         if(cbxTime2.isSelected()){
        try{
        time2 = scrumXPdb.fetchSingle("select starttid2 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
            
        } else{
        time2 = null;
        }
        if(cbxTime3.isSelected()){
        try{
        time3 = scrumXPdb.fetchSingle("select starttid3 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
        } else{
        time3 = null;
        }
        // fixa get userID fr�n f�lt


        try{
            meetingID = scrumXPdb.fetchSingle("select motes_id_forfragning from moten_forfragning where motesNamn = '" + meetingName +"'");
            userID = scrumXPdb.fetchSingle("select Anstalld_ID from anstalld where anvandarnamn = '"+ userName+ "'");
            String aterskickid = scrumXPdb.getAutoIncrement("motes_aterskick", "Motes_ID_aterskick");
            System.out.println(aterskickid);
            System.out.println(meetingID);
            scrumXPdb.insert("insert into motes_aterskick (Motes_id_aterskick,tid1,tid2,tid3,person_som_aterskickar,mote_id_som_besvaras) values ("+aterskickid+", '"+time1+"', '"+time2+"', '"+time3+"', "+userID+", "+meetingID+")");
            scrumXPdb.delete("delete from motes_deltagare_forfragning where Motes_Deltagare_Forfragning_ID = "+userID+" and Mote_som_deltas_Forfragning = "+ meetingID );
            JOptionPane.showMessageDialog(null, "M�tes svaret �r skickat!");
            CbMeeting.removeItem(meetingName); 
            
            
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!66");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
        //if(CbMeeting.get){
        
        //}else{
        
        //}
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTime2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTime2ActionPerformed

    private void CbMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbMeetingActionPerformed
       String meetingName = CbMeeting.getSelectedItem().toString();
     if(meetingName.equals("v�lj m�te")){
     cbxTime1.setText("Tid: ");
     cbxTime2.setText("Tid: ");
     cbxTime3.setText("Tid: ");   
     lbltitle.setText("Titel: ");
     lblPlace.setText("Plats: ");
     lbldate.setText("Datum: ");
     }else{
    setTitlelbl();
    setlblPlace();
    setTxtAreaDescription();
    setcbxTime1();
    setcbxTime2();
    setcbxTime3();
    //setlebDate();
     }
    }//GEN-LAST:event_CbMeetingActionPerformed

    private void CbMeetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbMeetingMouseClicked
     
    }//GEN-LAST:event_CbMeetingMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    new HomePage(scrumXPdb,userName).setVisible(true);
        setVisible(false);        
    }//GEN-LAST:event_jButton2ActionPerformed

   
    private void setTitlelbl(){
     String title;
    String titleName = CbMeeting.getSelectedItem().toString();

    try{
        title = scrumXPdb.fetchSingle("select motesnamn from moten_forfragning where moten_forfragning.motesnamn = '" + titleName + "'");
        lbltitle.setText("Titel: " + title);

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!1");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    //beh�ver skriva en sql fe�ga som h�mtar m�tenNamn p� m�ten som en anv�ndare har f�tt, men inte m�ten som anv�ndaren har redan svarat p� och fylla comboboxen med det.
    public void setCbMeeting() {
    String userID = "";
        
        ArrayList<String> titleName;
        try {
            userID = scrumXPdb.fetchSingle("select Anstalld_ID from anstalld where anvandarnamn = '"+ userName +"'");
            System.out.println(userID);
            titleName = scrumXPdb.fetchColumn("select moten_forfragning.MotesNamn from moten_forfragning join motes_deltagare_forfragning on moten_forfragning.motes_id_forfragning = motes_deltagare_forfragning.Mote_som_deltas_Forfragning where motes_deltagare_forfragning.Motes_Deltagare_Forfragning_ID  =" + userID);

            for (String titleNames : titleName) {

                CbMeeting.addItem(titleNames);

            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!2");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    
    private void setlblPlace(){
    String place;
    String meetingName = CbMeeting.getSelectedItem().toString();
    String meetingID = "";

    try{
        meetingID = scrumXPdb.fetchSingle("select motes_id_forfragning from moten_forfragning where motesNamn = '" + meetingName +"'");

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!3");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }try{

        place = scrumXPdb.fetchSingle("select plats from moten_forfragning where moten_forfragning.Motes_ID_Forfragning = '" + meetingID + "'");

        lblPlace.setText("Plats: " +place);

        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel! 354354435");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }


    } 
    
    
    private void setTxtAreaDescription(){
   String description;
    String meetingName = CbMeeting.getSelectedItem().toString();
    try{
        description = scrumXPdb.fetchSingle("select beskrivning from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        txtAreaDescription.setText(description);

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!4");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    } 
    
    private void setcbxTime1(){
    String Time1;
    String meetingName = CbMeeting.getSelectedItem().toString();
    String endTime1;
    String date1;
    try{
        Time1 = scrumXPdb.fetchSingle("select starttid1 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        endTime1 = scrumXPdb.fetchSingle("select sluttid1 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        date1 = scrumXPdb.fetchSingle("select startdatum1 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");;
        cbxTime1.setText("B�rjar:" +Time1 + "    Slutar: " +endTime1 + " Datum: " + date1);

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!5");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }  
    private void setcbxTime2(){
   String Time2;
    String meetingName = CbMeeting.getSelectedItem().toString();
    String endTime2;
    String date2;
    try{
        endTime2 = scrumXPdb.fetchSingle("select sluttid2 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        Time2 = scrumXPdb.fetchSingle("select starttid2 from moten_forfragning where moten_forfragning.motesnamn = '"+meetingName+"'");
        date2 = scrumXPdb.fetchSingle("select startdatum2 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");;
        cbxTime2.setText("B�rjar:" +Time2 + "    Slutar: " +endTime2 + " Datum: " + date2);
        //cbxTime2.setText(Time2);
    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!6");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }   
     private void setcbxTime3(){
    String Time3;
    String meetingName = CbMeeting.getSelectedItem().toString();
    String endTime3;
    String date3;
    try{
        endTime3 = scrumXPdb.fetchSingle("select sluttid2 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        Time3 = scrumXPdb.fetchSingle("select starttid3 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        date3 = scrumXPdb.fetchSingle("select startdatum2 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");;

        cbxTime3.setText("B�rjar:" +Time3 + "    Slutar: " +endTime3 + " Datum: " + date3);
       
    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!7");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    } 
   /*
     private void setlebDate(){
    String date;
    String meetingName = CbMeeting.getSelectedItem().toString();
    
    try{
        date = scrumXPdb.fetchSingle("select startdatum from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        
        lbldate.setText("Datum:  " +date );

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!7");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    } 
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbMeeting;
    private javax.swing.JCheckBox cbxTime1;
    private javax.swing.JCheckBox cbxTime2;
    private javax.swing.JCheckBox cbxTime3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextArea txtAreaDescription;
    // End of variables declaration//GEN-END:variables
}
