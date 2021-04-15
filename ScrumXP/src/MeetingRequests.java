
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;



public class MeetingRequests extends javax.swing.JFrame {

    private static InfDB scrumXPdb;
    private String userName;

    public MeetingRequests(InfDB scrumXPdb, String userName) {
        this.userName = userName;
        this.scrumXPdb = scrumXPdb;
        initComponents();

        setCbMeeting();
       //fixa get user id s� det kan anv�ndas som variabel
       //beh�ver fixa texten i tid boxarna just nu skickas "Tid:12:00" in till db
       //fixa sql fr�ga till combobox
    }


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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("M�ten f�rfr�gningar");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxTime2)
                                    .addComponent(cbxTime3)
                                    .addComponent(cbxTime1)))
                            .addComponent(lbltitle)
                            .addComponent(lblPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                        .addComponent(CbMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltitle)
                    .addComponent(CbMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblPlace)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(cbxTime1)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTime2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTime3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTime1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTime1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String meetingID = "";
        String meetingName = CbMeeting.getSelectedItem().toString();
        String time1 = "";
        String time2 = "";
        String time3 = "";
        if(cbxTime1.isSelected()){
        time1 = cbxTime1.getText();
        } else{
        time1 = null;
        }
         if(cbxTime2.isSelected()){
        time2 = cbxTime2.getText();
        } else{
        time2 = null;
        }
        if(cbxTime3.isSelected()){
        time3 = cbxTime3.getText();
        } else{
        time3 = null;
        }
        // fixa get userID fr�n f�lt


        try{
            meetingID = scrumXPdb.fetchSingle("select motes_id_forfragning from moten_forfragning where motesNamn = '" + meetingName +"'");

            String aterskickid = scrumXPdb.getAutoIncrement("motes_aterskick", "Motes_ID_aterskick");
            System.out.println(aterskickid);
            System.out.println(meetingID);
            scrumXPdb.insert("insert into motes_aterskick (Motes_id_aterskick,tid1,tid2,tid3,person_som_aterskickar,mote_id_som_besvaras) values ("+aterskickid+",'"+time1+"','"+time2+"','"+time3+"','1','"+meetingID+"')");
            scrumXPdb.delete("delete from motes_deltagare_forfragning where Motes_Deltagare_Forfragning_ID = 2 and Mote_som_deltas_Forfragning = "+ meetingID );
            JOptionPane.showMessageDialog(null, "M�tes svaret �r skickat!");
            CbMeeting.removeItem(meetingName);
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!666");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTime2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTime2ActionPerformed

    private void CbMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbMeetingActionPerformed
    setTitlelbl();
    setlblPlace();
    setTxtAreaDescription();
    setcbxTime1();
    setcbxTime2();
    setcbxTime3();
    }//GEN-LAST:event_CbMeetingActionPerformed

    private void CbMeetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbMeetingMouseClicked

    }//GEN-LAST:event_CbMeetingMouseClicked


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


        String query = "select moten_forfragning.MotesNamn from moten_forfragning join motes_deltagare_forfragning on moten_forfragning.motes_id_forfragning = motes_deltagare_forfragning.Mote_som_deltas_Forfragning where motes_deltagare_forfragning.Motes_Deltagare_Forfragning_ID  = 2";
        ArrayList<String> titleName;
        try {

            titleName = scrumXPdb.fetchColumn(query);

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
    try{
        Time1 = scrumXPdb.fetchSingle("select starttid1 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        cbxTime1.setText("Tid: " +Time1);

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!5");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    private void setcbxTime2(){
    String Time2;
    String meetingName = CbMeeting.getSelectedItem().toString();

    try{
        Time2 = scrumXPdb.fetchSingle("select starttid2 from moten_forfragning where moten_forfragning.motesnamn = '"+meetingName+"'");
        cbxTime2.setText("Tid: " +Time2);

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!6");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
     private void setcbxTime3(){
    String Time3;
    String meetingName = CbMeeting.getSelectedItem().toString();

    try{
        Time3 = scrumXPdb.fetchSingle("select starttid3 from moten_forfragning where moten_forfragning.motesnamn = '" + meetingName + "'");
        cbxTime3.setText("Tid: " +Time3);

    }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!7");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbMeeting;
    private javax.swing.JCheckBox cbxTime1;
    private javax.swing.JCheckBox cbxTime2;
    private javax.swing.JCheckBox cbxTime3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextArea txtAreaDescription;
    // End of variables declaration//GEN-END:variables
}
