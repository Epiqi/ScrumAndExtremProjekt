/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import java.text.SimpleDateFormat;


public class Login extends javax.swing.JFrame {
    private static InfDB scrumXPdb;

public Login (InfDB scrumXPdb){
   initComponents();
   this.scrumXPdb = scrumXPdb;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pfPassword = new javax.swing.JPasswordField();
        btnLoginUser = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblFelmeddelande = new javax.swing.JLabel();
        lblValkommstText = new javax.swing.JLabel();
        lblUppgText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnLoginUser.setText("Log in");
        btnLoginUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginUserActionPerformed(evt);
            }
        });

        txtUsername.setMaximumSize(new java.awt.Dimension(20, 20));

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Password");

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("Username");

        lblFelmeddelande.setToolTipText("");

        lblValkommstText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblValkommstText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValkommstText.setText("V�lkommen till InfoNet ");
        lblValkommstText.setToolTipText("");

        lblUppgText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUppgText.setText("V�nligen ange dina uppgifter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUppgText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblValkommstText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFelmeddelande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(btnLoginUser)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblValkommstText)
                .addGap(18, 18, 18)
                .addComponent(lblUppgText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lblFelmeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoginUser)
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginUserActionPerformed

        if (Validering.textFieldHasValue(txtUsername) && Validering.textFieldHasValue(pfPassword)) {

            try {
                String userName = txtUsername.getText();
                char[] passWord = pfPassword.getPassword();

                String login = scrumXPdb.fetchSingle("SELECT Losenord from anstalld where Anvandarnamn='" + userName + "'");
                String loginActive = scrumXPdb.fetchSingle("SELECT Aktiv from anstalld where Anvandarnamn='" + userName + "'");

                String spassWord = new String(passWord);
                if (loginActive.equalsIgnoreCase("j")) {
                    if (spassWord.equals(login)) {
                        new HomePage(scrumXPdb, userName).setVisible(true);
                      this.dispose();
                    } else {
                        lblFelmeddelande.setText("Fel användarnamn eller lösenord");
                        pfPassword.setText("");
                    }
                } else {
                    lblFelmeddelande.setText("Du har inte längre tillgång till systemet");
                }
            } catch (InfException ex) {
                JOptionPane.showMessageDialog(null, "Internt felmeddelande");
                System.out.println("Internt felmeddelande " + ex.getMessage());
            }



    }//GEN-LAST:event_btnLoginUserActionPerformed
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginUser;
    private javax.swing.JLabel lblFelmeddelande;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUppgText;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblValkommstText;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
