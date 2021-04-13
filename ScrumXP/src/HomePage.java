
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carolin
 */
public class HomePage extends javax.swing.JFrame {

    private static InfDB scrumXPdb;
    private String userName;


    /**
     * Creates new form HomePage
     */
    public HomePage(InfDB scrumXPdb, String userName) {
        this.scrumXPdb = scrumXPdb;
        this.userName = userName;
        initComponents();
        welcomeUser();
        isAdmin();
        fyllCbEmployer();
    }

    private void fyllCbEmployer() {

        ArrayList<HashMap<String, String>> allEmployees;

        try {
            String fraga = "SELECT ANSTALLD_ID, FORNAMN, EFTERNAMN FROM ANSTALLD ORDER BY FORNAMN;";
            allEmployees = scrumXPdb.fetchRows(fraga);

            for (HashMap<String, String> employees : allEmployees) {

                cmbxUsers.addItem(employees.get("FORNAMN")+" "+employees.get("EFTERNAMN")+" "+employees.get("ANSTALLD_ID"));
            }
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }


    private void welcomeUser(){

        String fetchFirstName = "Select Fornamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        String fetchLastName = "Select Efternamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        try {

           String FirstName = scrumXPdb.fetchSingle(fetchFirstName);
           String LastName = scrumXPdb.fetchSingle(fetchLastName);
            lblUserName.setText(FirstName + " " + LastName);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "L�mpligt fel");
        }
    }
    //Metoder f�r Anv�ndarfliken.
    private void isAdmin(){

        try{
            String adminQuestion = "Select Administrator From anstalld Where Anvandarnamn ='" + userName + "'";
            String admin = scrumXPdb.fetchSingle(adminQuestion);
            if(admin.equalsIgnoreCase("nej")){
            pnlCalendar.remove(pnlUser); //tar bort fliken f�r hantering av anv�ndare om du inte �r admin.
            }
            else{
            fillWithUsers();
            }
         } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void fillWithUsers(){

        String fetchFirstName = "Select Fornamn From Anstalld";
        String fetchLastName = "Select Efternamn From Anstalld";
        ArrayList<String> allFirstNames;
        ArrayList<String> allLastNames;
        try {
            cmbxUserNames.removeAllItems();
            allFirstNames = scrumXPdb.fetchColumn(fetchFirstName);
            allLastNames = scrumXPdb.fetchColumn(fetchLastName);
            for (int i = 0; i < allFirstNames.size(); i++) {
                String bothNames = allFirstNames.get(i) + " " + allLastNames.get(i);
                cmbxUserNames.addItem(bothNames);
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "L�mpligt fel");
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

        pnlCalendar = new javax.swing.JTabbedPane();
        pnlCourses = new javax.swing.JPanel();
        pnlResearch = new javax.swing.JPanel();
        cmbMeddelanden = new javax.swing.JComboBox<>();
        lblMeddelanden = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMeddelanden = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        txtTitel = new javax.swing.JTextField();
        lblTitel = new javax.swing.JLabel();
        lblSkrivMeddelande = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSkrivMeddelande = new javax.swing.JTextArea();
        pnlSocial = new javax.swing.JPanel();
        pnlUser = new javax.swing.JPanel();
        lblHeadlineAddUser = new javax.swing.JLabel();
        lblHeadlinePassword = new javax.swing.JLabel();
        lblErrorMessageUser = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtfldName = new javax.swing.JTextField();
        lblUserNameInUserTab = new javax.swing.JLabel();
        txtfldUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtfldPassword = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtfldEmail = new javax.swing.JTextField();
        lblMobileNumber = new javax.swing.JLabel();
        txtfldMobileNumber = new javax.swing.JTextField();
        cmbxUserNames = new javax.swing.JComboBox<>();
        lblChooseUser = new javax.swing.JLabel();
        txtfldPasswordChange = new javax.swing.JTextField();
        txtfldPasswordChangeAgain = new javax.swing.JTextField();
        lblWritePassword = new javax.swing.JLabel();
        lblWritePasswordAgain = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        lblErrorMessagePassword = new javax.swing.JLabel();
        btnSavePassword = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        calendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaSchedule = new javax.swing.JTextArea();
        btnSchedule = new javax.swing.JButton();
        cmbxUsers = new javax.swing.JComboBox<>();
        lblHeadline = new javax.swing.JLabel();
        btnChangeUserDetails = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlCoursesLayout = new javax.swing.GroupLayout(pnlCourses);
        pnlCourses.setLayout(pnlCoursesLayout);
        pnlCoursesLayout.setHorizontalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        pnlCoursesLayout.setVerticalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );

        pnlCalendar.addTab("Kurser", pnlCourses);

        cmbMeddelanden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblMeddelanden.setText("V�lj meddelanden nedan");

        txtAreaMeddelanden.setEditable(false);
        txtAreaMeddelanden.setColumns(20);
        txtAreaMeddelanden.setRows(5);
        jScrollPane1.setViewportView(txtAreaMeddelanden);

        jButton1.setText("Skriv nytt meddelande");

        lblTitel.setText("Skriv in titel p� meddelande:");

        lblSkrivMeddelande.setText("Skriv in ditt meddelande:");

        txtAreaSkrivMeddelande.setColumns(20);
        txtAreaSkrivMeddelande.setRows(5);
        jScrollPane2.setViewportView(txtAreaSkrivMeddelande);

        javax.swing.GroupLayout pnlResearchLayout = new javax.swing.GroupLayout(pnlResearch);
        pnlResearch.setLayout(pnlResearchLayout);
        pnlResearchLayout.setHorizontalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMeddelanden, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMeddelanden, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitel)
                            .addComponent(jButton1)
                            .addComponent(lblTitel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(lblSkrivMeddelande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlResearchLayout.setVerticalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearchLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlResearchLayout.createSequentialGroup()
                                .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblSkrivMeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addContainerGap(412, Short.MAX_VALUE))
        );

        pnlCalendar.addTab("Forskning", pnlResearch);

        javax.swing.GroupLayout pnlSocialLayout = new javax.swing.GroupLayout(pnlSocial);
        pnlSocial.setLayout(pnlSocialLayout);
        pnlSocialLayout.setHorizontalGroup(
            pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        pnlSocialLayout.setVerticalGroup(
            pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );

        pnlCalendar.addTab("InfoSocial", pnlSocial);

        lblHeadlineAddUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblHeadlineAddUser.setText("L�gg till anv�ndare");

        lblHeadlinePassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblHeadlinePassword.setText("Byt l�senord �t anv�ndare");

        lblErrorMessageUser.setText("Felmeddelande");

        lblName.setText("Namn:");

        lblUserNameInUserTab.setText("Username:");

        lblPassword.setText("L�senord:");

        lblEmail.setText("Email:");

        lblMobileNumber.setText("Mobilnr:");

        cmbxUserNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblChooseUser.setText("V�lj anv�ndare:");

        lblWritePassword.setText("Ange l�senord:");

        lblWritePasswordAgain.setText("Ange l�senord igen:");

        btnAddUser.setText("L�gg till");

        lblErrorMessagePassword.setText("Felmeddelande");

        btnSavePassword.setText("Spara");
        btnSavePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserLayout = new javax.swing.GroupLayout(pnlUser);
        pnlUser.setLayout(pnlUserLayout);
        pnlUserLayout.setHorizontalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addComponent(lblErrorMessageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(198, 198, 198))
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addComponent(lblHeadlineAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(lblMobileNumber)
                            .addComponent(lblPassword)
                            .addComponent(lblUserNameInUserTab)
                            .addComponent(lblName))
                        .addGap(59, 59, 59)
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUserLayout.createSequentialGroup()
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlUserLayout.createSequentialGroup()
                                        .addComponent(txtfldName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtfldMobileNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE))
                            .addGroup(pnlUserLayout.createSequentialGroup()
                                .addComponent(txtfldUserName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorMessagePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeadlinePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChooseUser)
                            .addComponent(lblWritePassword)
                            .addComponent(lblWritePasswordAgain))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSavePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtfldPasswordChangeAgain)
                            .addComponent(txtfldPasswordChange)
                            .addComponent(cmbxUserNames, 0, 156, Short.MAX_VALUE))))
                .addGap(265, 265, 265))
        );
        pnlUserLayout.setVerticalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblHeadlinePassword)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeadlineAddUser)
                        .addGap(31, 31, 31)))
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorMessageUser)
                    .addComponent(lblErrorMessagePassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtfldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxUserNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseUser))
                .addGap(47, 47, 47)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserNameInUserTab)
                    .addComponent(txtfldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldPasswordChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWritePassword))
                .addGap(49, 49, 49)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtfldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfldPasswordChangeAgain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWritePasswordAgain))
                .addGap(63, 63, 63)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSavePassword))
                        .addGap(61, 61, 61)
                        .addComponent(txtfldMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMobileNumber))
                .addGap(68, 68, 68)
                .addComponent(btnAddUser)
                .addContainerGap(376, Short.MAX_VALUE))
        );

        pnlCalendar.addTab("Anv�ndare", pnlUser);

        txtAreaSchedule.setColumns(20);
        txtAreaSchedule.setRows(5);
        jScrollPane3.setViewportView(txtAreaSchedule);

        btnSchedule.setText("Visa schema f�r vald person");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(cmbxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(434, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );

        pnlCalendar.addTab("Almanacka", panel1);

        lblHeadline.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHeadline.setText("V�lkommen till InfoNet!");

        btnChangeUserDetails.setText("�ndra dina uppgifter");

        lblUserName.setText("Anv�ndare");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCalendar)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(lblHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangeUserDetails))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeadline)
                    .addComponent(lblUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnChangeUserDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSavePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePasswordActionPerformed

        try{
        String password1 = txtfldPasswordChange.getText();
        String password2 = txtfldPasswordChangeAgain.getText();

        String bothNames = cmbxUserNames.getSelectedItem().toString();
        String[] names = bothNames.split(" ");
        String firstName = names[0];
        String lastName = names[1];

        Admin.changePassword(firstName, lastName, password1, password2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "L�senordet har inte uppdaterats, f�rs�k igen eller kontakta support");
        }
    }//GEN-LAST:event_btnSavePasswordActionPerformed

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
       String choosenName = cmbxUsers.getSelectedItem().toString();
          String choosenId = choosenName.replaceAll("\\D+","");
          
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
          String ChoosenDate = sdf.format(calendar1.getDate());

          
         ArrayList<HashMap<String, String>> allMeetings;

        try {

              String fraga = "SELECT MOTESNAMN, BESKRIVNING, STARTTID, SLUTTID FROM MOTEN WHERE STARTDATUM = '"+ChoosenDate + "' AND MOTEN.MOTES_ID IN (SELECT MOTE_SOM_DELTAS FROM MOTES_DELTAGARE WHERE MOTES_DELTAGARE_ID = '" + choosenId +"');";  

            allMeetings = scrumXPdb.fetchRows(fraga);

            for (HashMap<String, String> meetings : allMeetings) {
            
                txtAreaSchedule.append(meetings.get("MOTESNAMN")+ "\t");
                 txtAreaSchedule.append(meetings.get("BESKRIVNING")+ "\t");
                  txtAreaSchedule.append("Klockan: "+meetings.get("STARTTID")+"-"+meetings.get("SLUTTID"));
                
            }
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) { //L�gger �ven till NullPointerException
            JOptionPane.showMessageDialog(null, "Det finns f�r nuvarande ingen alien i detta omr�de!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
                
    }                                           
    }//GEN-LAST:event_btnScheduleActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnChangeUserDetails;
    private javax.swing.JButton btnSavePassword;
    private javax.swing.JButton btnSchedule;
    private com.toedter.calendar.JCalendar calendar1;
    private javax.swing.JComboBox<String> cmbMeddelanden;
    private javax.swing.JComboBox<String> cmbxUserNames;
    private javax.swing.JComboBox<String> cmbxUsers;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblChooseUser;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrorMessagePassword;
    private javax.swing.JLabel lblErrorMessageUser;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblHeadlineAddUser;
    private javax.swing.JLabel lblHeadlinePassword;
    private javax.swing.JLabel lblMeddelanden;
    private javax.swing.JLabel lblMobileNumber;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSkrivMeddelande;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNameInUserTab;
    private javax.swing.JLabel lblWritePassword;
    private javax.swing.JLabel lblWritePasswordAgain;
    private java.awt.Panel panel1;
    private javax.swing.JTabbedPane pnlCalendar;
    private javax.swing.JPanel pnlCourses;
    private javax.swing.JPanel pnlResearch;
    private javax.swing.JPanel pnlSocial;
    private javax.swing.JPanel pnlUser;
    private javax.swing.JTextArea txtAreaMeddelanden;
    private javax.swing.JTextArea txtAreaSchedule;
    private javax.swing.JTextArea txtAreaSkrivMeddelande;
    private javax.swing.JTextField txtTitel;
    private javax.swing.JTextField txtfldEmail;
    private javax.swing.JTextField txtfldMobileNumber;
    private javax.swing.JTextField txtfldName;
    private javax.swing.JTextField txtfldPassword;
    private javax.swing.JTextField txtfldPasswordChange;
    private javax.swing.JTextField txtfldPasswordChangeAgain;
    private javax.swing.JTextField txtfldUserName;
    // End of variables declaration//GEN-END:variables
}
