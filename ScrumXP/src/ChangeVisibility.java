import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class ChangeVisibility extends javax.swing.JFrame {

    private static InfDB scrumXPdb;
    private String userName;
   
    public ChangeVisibility(InfDB scrumXPdb, String userName) {
        initComponents();
        this.scrumXPdb = scrumXPdb;
        this.userName = userName;
        fyllOchMAtchaID();
        welcomeUser();
        //CheckVisibility();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCmbMessage = new javax.swing.JLabel();
        cmbMessages = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaVisibleMessage = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();
        JboxVisible = new javax.swing.JCheckBox();
        lblNamn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCmbMessage.setText("Välj meddelande nedan:");

        cmbMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMessagesActionPerformed(evt);
            }
        });

        txtAreaVisibleMessage.setColumns(20);
        txtAreaVisibleMessage.setRows(5);
        jScrollPane1.setViewportView(txtAreaVisibleMessage);

        jLabel2.setText("Välj om detta meddelande ska vara synligt för alla");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        JboxVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JboxVisibleActionPerformed(evt);
            }
        });

        lblNamn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTillbaka)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCmbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(JboxVisible))
                            .addComponent(cmbMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCmbMessage)
                        .addGap(18, 18, 18)
                        .addComponent(cmbMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JboxVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnTillbaka)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMessagesActionPerformed

        String selectedVisibility = cmbMessages.getSelectedItem().toString();
        txtAreaVisibleMessage.setText("");
        try {
            String checkVisibleMessage = scrumXPdb.fetchSingle("SELECT synlig FROM blogginlagg WHERE titel = '"+selectedVisibility+"' ");
            if (checkVisibleMessage.equals("1")) {
            String queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '"+selectedVisibility+ "'");
            String Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '"+selectedVisibility+ "'");
            String firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            String lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            txtAreaVisibleMessage.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaVisibleMessage.append("Titel: " + selectedVisibility + "\n");
            txtAreaVisibleMessage.append(queryOne);
            txtAreaVisibleMessage.setLineWrap(true);
            txtAreaVisibleMessage.setWrapStyleWord(true);
            JboxVisible.setSelected(true);                
            } 
            else {
            String queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '"+selectedVisibility+ "'");
            String Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '"+selectedVisibility+ "'");
            String firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            String lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            txtAreaVisibleMessage.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaVisibleMessage.append("Titel: " + selectedVisibility + "\n");
            txtAreaVisibleMessage.append(queryOne);
            txtAreaVisibleMessage.setLineWrap(true);
            txtAreaVisibleMessage.setWrapStyleWord(true);
            JboxVisible.setSelected(false);
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
         
    }//GEN-LAST:event_cmbMessagesActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void JboxVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JboxVisibleActionPerformed
        boolean OK = JboxVisible.isSelected();
        String selectedVisibility = cmbMessages.getSelectedItem().toString();

        try {
            String userID = scrumXPdb.fetchSingle("select Anstalld_ID from anstalld where anvandarnamn = '" + userName + "'");
            String BloggID = scrumXPdb.fetchSingle("SELECT Inlagg_ID from blogginlagg where Titel = '" + selectedVisibility + "' and Ansvarig_Anstalld ='" + userID + "'");
            if (OK) {
                scrumXPdb.update("update blogginlagg SET Synlig = 1 where Inlagg_ID = '" + BloggID + "' and Ansvarig_Anstalld = '" + userID + "'");
            } else {
                scrumXPdb.update("update blogginlagg SET Synlig = 0 where Inlagg_ID = '" + BloggID + "' and Ansvarig_Anstalld = '" + userID + "'");
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_JboxVisibleActionPerformed

        private void welcomeUser() {

        String fetchFirstName = "Select Fornamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        String fetchLastName = "Select Efternamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        try {

            String FirstName = scrumXPdb.fetchSingle(fetchFirstName);
            String LastName = scrumXPdb.fetchSingle(fetchLastName);
            lblNamn.setText("Meddelanden av: " + FirstName + " " + LastName);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "LÃ?Æ?Ã?Â¤mpligt fel");
        }
    }
    private void fyllOchMAtchaID() {

        ArrayList<String> queries;
        try {

            String userID = scrumXPdb.fetchSingle("select Anstalld_ID from anstalld where anvandarnamn = '" + userName + "'");
            queries = scrumXPdb.fetchColumn("SELECT Titel FROM blogginlagg JOIN anstalld ON anstalld.Anstalld_ID = blogginlagg.Ansvarig_Anstalld WHERE Ansvarig_Anstalld = '" + userID + "'");

            for (String category : queries) {

                cmbMessages.addItem(category);

            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga meddelanden i den hÃ?Æ?Ã?Â¤r kategorin");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NÃ?Æ?Ã?Â¥gonting gick fel");
        }
    }
    private void CheckVisibility(){
        String SynligTitel = cmbMessages.getSelectedItem().toString();
        try{
        String Synlighet = scrumXPdb.fetchSingle("select Synlig from blogginlagg where Titel = '"+SynligTitel+"'");

        if(Synlighet.equals("1")){
            JboxVisible.setSelected(true);

        }
        else{
            JboxVisible.setSelected(false);
        }
        }
        catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JboxVisible;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JComboBox<String> cmbMessages;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCmbMessage;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JTextArea txtAreaVisibleMessage;
    // End of variables declaration//GEN-END:variables
}
