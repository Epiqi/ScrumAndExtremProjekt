
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;


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
    public String userName;
    DefaultListModel minLista = new DefaultListModel();


    /**
     * Creates new form HomePage
     */
    public HomePage(InfDB scrumXPdb, String userName) {
        this.scrumXPdb = scrumXPdb;
        this.userName = userName;
        initComponents();
        welcomeUser();
        isAdmin();
        fillCbEmployee();
        setCbCategory();
        setCbCategoryKurs();
        setCbMeddelandenSocial();
        Notifications.fillCheckBoxesNotifications(scrumXPdb, userName);
    }

     private void welcomeUser() {

        String fetchFirstName = "Select Fornamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        String fetchLastName = "Select Efternamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        try {

            String FirstName = scrumXPdb.fetchSingle(fetchFirstName);
            String LastName = scrumXPdb.fetchSingle(fetchLastName);
            lblUserName.setText(FirstName + " " + LastName);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "LÃ¤mpligt fel");
        }
    }

     private void isAdmin() {

        try{
            String adminQuestion = "Select Administrator From anstalld Where Anvandarnamn ='" + userName + "'";
            String admin = scrumXPdb.fetchSingle(adminQuestion);
            if(admin.equalsIgnoreCase("n")){
            pnlUser.remove(pnlUser); //tar bort fliken fÃ¶r hantering av anvÃ¤ndare om du inte Ã¤r admin.
            }

         } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void fillCbEmployee() {
       cmbxUsers.removeAllItems();
       cbChoosenParticipant.removeAllItems();
        ArrayList<HashMap<String, String>> allEmployees;

        try {
            int i = 0;
            String fraga = "SELECT ANSTALLD_ID, FORNAMN, EFTERNAMN FROM ANSTALLD ORDER BY FORNAMN;";
            allEmployees = scrumXPdb.fetchRows(fraga);

            String userIdQuery = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE Anvandarnamn = '" + userName + "';";
            String userId = scrumXPdb.fetchSingle(userIdQuery);

            var loginActive = scrumXPdb.fetchColumn("SELECT Aktiv from anstalld ORDER BY FORNAMN");

            cmbxUsers.removeAllItems();
            cmbxUserNames.removeAllItems();
            cmbxChooseUserToRemove.removeAllItems();
            for (HashMap<String, String> employees : allEmployees) {

                cmbxUsers.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                cbChoosenParticipant.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                cmbxUserNames.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                cmbxChooseUserToRemove.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                if(loginActive.get(i).equalsIgnoreCase("n")){
                    cmbxUsers.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                    cmbxUserNames.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                    cmbxChooseUserToRemove.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                }
                if(userId.equalsIgnoreCase(employees.get("ANSTALLD_ID"))){

                    cmbxUserNames.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                    cmbxChooseUserToRemove.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                }
                i ++;

            }
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) {

            JOptionPane.showMessageDialog(null, "NÃ¥got gick fel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
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

        pnlNotifications = new javax.swing.JTabbedPane();
        pnlCourses = new javax.swing.JPanel();
        pnlResearch2 = new javax.swing.JPanel();
        cmbMessageKurs = new javax.swing.JComboBox<>();
        lblMeddelanden3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAreaMeddelandenKurs = new javax.swing.JTextArea();
        btnWriteMessageKurs = new javax.swing.JButton();
        txtTitelKurs = new javax.swing.JTextField();
        lblTitel2 = new javax.swing.JLabel();
        lblSkrivMeddelande2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtAreaSkrivMeddelandeKurs = new javax.swing.JTextArea();
        cmbKategoriKurs = new javax.swing.JComboBox<>();
        lblKategori1 = new javax.swing.JLabel();
        txtAddNewCatKurs = new javax.swing.JTextField();
        lblAddNewCat1 = new javax.swing.JLabel();
        btnAddNewCat1 = new javax.swing.JButton();
        lblMeddelanden4 = new javax.swing.JLabel();
        cmbCategoriesKurs = new javax.swing.JComboBox<>();
        pnlResearch = new javax.swing.JPanel();
        cmbMessage = new javax.swing.JComboBox<>();
        lblMeddelanden = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMeddelanden = new javax.swing.JTextArea();
        btnWriteMessage = new javax.swing.JButton();
        txtTitel = new javax.swing.JTextField();
        lblTitel = new javax.swing.JLabel();
        lblSkrivMeddelande = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSkrivMeddelande = new javax.swing.JTextArea();
        cmbKategori = new javax.swing.JComboBox<>();
        lblKategori = new javax.swing.JLabel();
        txtAddNewCat = new javax.swing.JTextField();
        lblAddNewCat = new javax.swing.JLabel();
        btnAddNewCat = new javax.swing.JButton();
        lblMeddelanden2 = new javax.swing.JLabel();
        cmbCategories = new javax.swing.JComboBox<>();
        pnlSocial = new javax.swing.JPanel();
        pnlResearch1 = new javax.swing.JPanel();
        cmbMessageSocial = new javax.swing.JComboBox<>();
        lblMeddelandenSocial = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaMeddelandenSocial = new javax.swing.JTextArea();
        btnWriteMessageSocial = new javax.swing.JButton();
        txtTitelSocial = new javax.swing.JTextField();
        lblTitelSocial = new javax.swing.JLabel();
        lblSkrivMeddelandeSocial = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaSkrivMeddelandeSocial = new javax.swing.JTextArea();
        panel1 = new java.awt.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaSchedule = new javax.swing.JTextArea();
        btnSchedule = new javax.swing.JButton();
        cmbxUsers = new javax.swing.JComboBox<>();
        lblChooseEmployee = new javax.swing.JLabel();
        calendar1 = new com.toedter.calendar.JCalendar();
        btnScheduleAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblChooseParticipants = new javax.swing.JLabel();
        cbChoosenParticipant = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstAddedParticipants = new javax.swing.JList<>();
        lblMeetingLocation = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        lblMeetingDescription = new javax.swing.JLabel();
        lblMeetingDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblTimeTo = new javax.swing.JLabel();
        btnCompleteBooking = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtMeetingDescription = new javax.swing.JTextArea();
        btnAddParticipant = new javax.swing.JButton();
        btnEmptyList = new javax.swing.JButton();
        tpTo = new com.github.lgooddatepicker.components.TimePicker();
        tpFrom = new com.github.lgooddatepicker.components.TimePicker();
        lblMeetingName = new javax.swing.JLabel();
        txtMeetingName = new javax.swing.JTextField();
        datepickerDate1 = new com.toedter.calendar.JDateChooser();
        pnlUser = new javax.swing.JPanel();
        lblHeadlineAddUser = new javax.swing.JLabel();
        lblHeadlinePassword = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        txtfldFirstName = new javax.swing.JTextField();
        lblUserNameInUserTab = new javax.swing.JLabel();
        txtfldUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtfldPassword = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtfldEmail = new javax.swing.JTextField();
        lblMobileNumber = new javax.swing.JLabel();
        txtfldTelefon = new javax.swing.JTextField();
        cmbxUserNames = new javax.swing.JComboBox<>();
        lblChooseUser = new javax.swing.JLabel();
        txtfldPasswordChange = new javax.swing.JTextField();
        txtfldPasswordChangeAgain = new javax.swing.JTextField();
        lblWritePassword = new javax.swing.JLabel();
        lblWritePasswordAgain = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        btnSavePassword1 = new javax.swing.JButton();
        txtfldLastName = new javax.swing.JTextField();
        lblLastname = new javax.swing.JLabel();
        chbxAdmin = new javax.swing.JCheckBox();

        jPanel2 = new javax.swing.JPanel();
        lblChooseNotifications = new javax.swing.JLabel();
        btnSaveNotificationSettings = new javax.swing.JButton();
        chbxNewPostInCourse = new javax.swing.JCheckBox();
        chbxNewPostInResearch = new javax.swing.JCheckBox();
        chbxNewPostInInfoSocial = new javax.swing.JCheckBox();
        chbxNewMeetingRequest = new javax.swing.JCheckBox();
        chbxNewMeetingBooking = new javax.swing.JCheckBox();
        lblHeadlineRemoveUser = new javax.swing.JLabel();
        cmbxChooseUserToRemove = new javax.swing.JComboBox<>();
        lblChooseUserToRemove = new javax.swing.JLabel();
        btnRemoveUser = new javax.swing.JButton();
        lblHeadline = new javax.swing.JLabel();
        btnChangeUserDetails = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbMessageKurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMessageKursActionPerformed(evt);
            }
        });

        lblMeddelanden3.setText("Välj meddelanden nedan");

        txtAreaMeddelandenKurs.setEditable(false);
        txtAreaMeddelandenKurs.setColumns(20);
        txtAreaMeddelandenKurs.setRows(5);
        txtAreaMeddelandenKurs.setMaximumSize(new java.awt.Dimension(164, 94));
        jScrollPane6.setViewportView(txtAreaMeddelandenKurs);

        btnWriteMessageKurs.setText("Skriv nytt meddelande");
        btnWriteMessageKurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteMessageKursActionPerformed(evt);
            }
        });

        lblTitel2.setText("Skriv in titel på meddelande:");

        lblSkrivMeddelande2.setText("Skriv in ditt meddelande:");

        txtAreaSkrivMeddelandeKurs.setColumns(20);
        txtAreaSkrivMeddelandeKurs.setLineWrap(true);
        txtAreaSkrivMeddelandeKurs.setRows(5);
        txtAreaSkrivMeddelandeKurs.setWrapStyleWord(true);
        jScrollPane7.setViewportView(txtAreaSkrivMeddelandeKurs);

        lblKategori1.setText("Välj kategori:");

        lblAddNewCat1.setText("Lägg till ny kategori");

        btnAddNewCat1.setText("Lägg till");
        btnAddNewCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCat1ActionPerformed(evt);
            }
        });

        lblMeddelanden4.setText("Välj kategori nedan");

        cmbCategoriesKurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriesKursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResearch2Layout = new javax.swing.GroupLayout(pnlResearch2);
        pnlResearch2.setLayout(pnlResearch2Layout);
        pnlResearch2Layout.setHorizontalGroup(
            pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearch2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddNewCatKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddNewCat1)
                            .addComponent(btnAddNewCat1)
                            .addComponent(lblMeddelanden4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblMeddelanden3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMessageKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbCategoriesKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearch2Layout.createSequentialGroup()
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResearch2Layout.createSequentialGroup()
                                .addComponent(lblTitel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKategori1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                            .addGroup(pnlResearch2Layout.createSequentialGroup()
                                .addComponent(txtTitelKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbKategoriKurs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane7))
                        .addGap(79, 79, 79))
                    .addGroup(pnlResearch2Layout.createSequentialGroup()
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSkrivMeddelande2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWriteMessageKurs))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlResearch2Layout.setVerticalGroup(
            pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearch2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlResearch2Layout.createSequentialGroup()
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKategori1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitelKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbKategoriKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSkrivMeddelande2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnWriteMessageKurs))
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResearch2Layout.createSequentialGroup()
                        .addComponent(lblMeddelanden4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cmbCategoriesKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMeddelanden3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMessageKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAddNewCat1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAddNewCatKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddNewCat1)))
                .addContainerGap(412, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCoursesLayout = new javax.swing.GroupLayout(pnlCourses);
        pnlCourses.setLayout(pnlCoursesLayout);
        pnlCoursesLayout.setHorizontalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1299, Short.MAX_VALUE)
            .addGroup(pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCoursesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlResearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlCoursesLayout.setVerticalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
            .addGroup(pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCoursesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlResearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlNotifications.addTab("Kurser", pnlCourses);

        cmbMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMessageActionPerformed(evt);
            }
        });

        lblMeddelanden.setText("Välj meddelanden nedan");

        txtAreaMeddelanden.setEditable(false);
        txtAreaMeddelanden.setColumns(20);
        txtAreaMeddelanden.setRows(5);
        txtAreaMeddelanden.setMaximumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(txtAreaMeddelanden);

        btnWriteMessage.setText("Skriv nytt meddelande");
        btnWriteMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteMessageActionPerformed(evt);
            }
        });

        lblTitel.setText("Skriv in titel på meddelande:");

        lblSkrivMeddelande.setText("Skriv in ditt meddelande:");

        txtAreaSkrivMeddelande.setColumns(20);
        txtAreaSkrivMeddelande.setLineWrap(true);
        txtAreaSkrivMeddelande.setRows(5);
        txtAreaSkrivMeddelande.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtAreaSkrivMeddelande);

        lblKategori.setText("Välj kategori:");

        lblAddNewCat.setText("Lägg till ny kategori");

        btnAddNewCat.setText("Lägg till");
        btnAddNewCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCatActionPerformed(evt);
            }
        });

        lblMeddelanden2.setText("Välj kategori nedan");

        cmbCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResearchLayout = new javax.swing.GroupLayout(pnlResearch);
        pnlResearch.setLayout(pnlResearchLayout);
        pnlResearchLayout.setHorizontalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddNewCat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddNewCat)
                            .addComponent(btnAddNewCat)
                            .addComponent(lblMeddelanden2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResearchLayout.createSequentialGroup()
                                .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                            .addGroup(pnlResearchLayout.createSequentialGroup()
                                .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addGap(79, 79, 79))
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSkrivMeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWriteMessage))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlResearchLayout.setVerticalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearchLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSkrivMeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnWriteMessage))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResearchLayout.createSequentialGroup()
                        .addComponent(lblMeddelanden2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAddNewCat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAddNewCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddNewCat)))
                .addContainerGap(412, Short.MAX_VALUE))
        );

        pnlNotifications.addTab("Forskning", pnlResearch);

        cmbMessageSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMessageSocialActionPerformed(evt);
            }
        });

        lblMeddelandenSocial.setText("Välj meddelanden nedan");

        txtAreaMeddelandenSocial.setEditable(false);
        txtAreaMeddelandenSocial.setColumns(20);
        txtAreaMeddelandenSocial.setRows(5);
        txtAreaMeddelandenSocial.setMaximumSize(new java.awt.Dimension(164, 94));
        jScrollPane4.setViewportView(txtAreaMeddelandenSocial);

        btnWriteMessageSocial.setText("Skriv nytt meddelande");
        btnWriteMessageSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteMessageSocialActionPerformed(evt);
            }
        });

        lblTitelSocial.setText("Skriv in titel på meddelande:");

        lblSkrivMeddelandeSocial.setText("Skriv in ditt meddelande:");

        txtAreaSkrivMeddelandeSocial.setColumns(20);
        txtAreaSkrivMeddelandeSocial.setLineWrap(true);
        txtAreaSkrivMeddelandeSocial.setRows(5);
        txtAreaSkrivMeddelandeSocial.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txtAreaSkrivMeddelandeSocial);

        javax.swing.GroupLayout pnlResearch1Layout = new javax.swing.GroupLayout(pnlResearch1);
        pnlResearch1.setLayout(pnlResearch1Layout);
        pnlResearch1Layout.setHorizontalGroup(
            pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearch1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMeddelandenSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMessageSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearch1Layout.createSequentialGroup()
                        .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addGroup(pnlResearch1Layout.createSequentialGroup()
                                .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitelSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTitelSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(79, 79, 79))
                    .addGroup(pnlResearch1Layout.createSequentialGroup()
                        .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSkrivMeddelandeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWriteMessageSocial))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlResearch1Layout.setVerticalGroup(
            pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearch1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlResearch1Layout.createSequentialGroup()
                        .addComponent(lblTitelSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitelSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSkrivMeddelandeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnWriteMessageSocial))
                    .addComponent(jScrollPane4)
                    .addGroup(pnlResearch1Layout.createSequentialGroup()
                        .addComponent(lblMeddelandenSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMessageSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(423, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSocialLayout = new javax.swing.GroupLayout(pnlSocial);
        pnlSocial.setLayout(pnlSocialLayout);
        pnlSocialLayout.setHorizontalGroup(
            pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1299, Short.MAX_VALUE)
            .addGroup(pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlResearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSocialLayout.setVerticalGroup(
            pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
            .addGroup(pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSocialLayout.createSequentialGroup()
                    .addComponent(pnlResearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlNotifications.addTab("InfoSocial", pnlSocial);

        txtAreaSchedule.setColumns(20);
        txtAreaSchedule.setRows(5);
        jScrollPane3.setViewportView(txtAreaSchedule);

        btnSchedule.setText("Visa schema för vald person");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        cmbxUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxUsersActionPerformed(evt);
            }
        });

        lblChooseEmployee.setText("Välj medarbetare:");

        btnScheduleAll.setText("Visa allas schema");
        btnScheduleAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnScheduleAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblChooseEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(406, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChooseEmployee)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnScheduleAll, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(100, 100, 100)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );

        pnlNotifications.addTab("Almanacka", panel1);

        lblChooseParticipants.setText("Välj deltagare:");

        jScrollPane8.setViewportView(lstAddedParticipants);

        lblMeetingLocation.setText("Plats:");

        lblMeetingDescription.setText("Beskrivning:");

        lblMeetingDate.setText("Datum:");

        lblTime.setText("Tid:");

        lblTimeTo.setText("till");

        btnCompleteBooking.setText("Genomför bokning");
        btnCompleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteBookingActionPerformed(evt);
            }
        });

        txtMeetingDescription.setColumns(20);
        txtMeetingDescription.setRows(5);
        jScrollPane9.setViewportView(txtMeetingDescription);

        btnAddParticipant.setText("Lägg till");
        btnAddParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddParticipantActionPerformed(evt);
            }
        });

        btnEmptyList.setText("Töm lista");
        btnEmptyList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyListActionPerformed(evt);
            }
        });

        lblMeetingName.setText("Mötesnamn:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMeetingDescription)
                            .addComponent(lblChooseParticipants)
                            .addComponent(lblMeetingDate)
                            .addComponent(lblTime)
                            .addComponent(lblMeetingLocation)
                            .addComponent(lblMeetingName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbChoosenParticipant, javax.swing.GroupLayout.Alignment.LEADING, 0, 166, Short.MAX_VALUE)
                                    .addComponent(txtMeetingName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddParticipant))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tpFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTimeTo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tpTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(datepickerDate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(213, 213, 213)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEmptyList)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(btnCompleteBooking)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChooseParticipants)
                            .addComponent(cbChoosenParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddParticipant))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMeetingName)
                            .addComponent(txtMeetingName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMeetingLocation)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(lblMeetingDescription)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMeetingDate)
                            .addComponent(datepickerDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTime)
                            .addComponent(tpFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tpTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimeTo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmptyList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCompleteBooking)
                .addContainerGap())
        );




        lblHeadlineAddUser.setText("Lägg till användare");
        lblHeadlineAddUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblHeadlinePassword.setText("Byt lösenord åt användare");
        lblHeadlinePassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblFirstname.setText("Förnamn:");

        lblUserNameInUserTab.setText("Username:");

        lblPassword.setText("Lösenord:");

        lblEmail.setText("Email:");

        lblMobileNumber.setText("Mobilnr:");

        cmbxUserNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblChooseUser.setText("Välj användare:");

        lblWritePassword.setText("Ange lösenord:");

        lblWritePasswordAgain.setText("Ange lösenord igen:");

        btnAddUser.setText("Lägg till");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnSavePassword1.setText("Spara");
        btnSavePassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePasswordActionPerformed(evt);
            }
        });

        lblLastname.setText("Efternamn:");

        chbxAdmin.setText("Checka i för att göra användaren till admin");

        lblHeadlineRemoveUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblHeadlineRemoveUser.setText("Ta bort användare");

        cmbxChooseUserToRemove.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblChooseUserToRemove.setText("Välj användare att ta bort:");

        btnRemoveUser.setText("Ta bort");
        btnRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveUserActionPerformed(evt);
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
                        .addComponent(lblFirstname)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUserLayout.createSequentialGroup()
                                .addComponent(lblHeadlineAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlUserLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmail)
                                    .addComponent(lblMobileNumber)
                                    .addComponent(lblPassword)
                                    .addComponent(lblUserNameInUserTab)
                                    .addComponent(lblLastname))
                                .addGap(68, 68, 68)
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfldUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldTelefon, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                    .addGroup(pnlUserLayout.createSequentialGroup()
                                        .addComponent(chbxAdmin)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtfldFirstName)
                                    .addComponent(txtfldLastName))
                                .addGap(196, 196, 196)))
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeadlinePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblChooseUser)
                                    .addComponent(lblWritePassword)
                                    .addComponent(lblWritePasswordAgain))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbxUserNames, javax.swing.GroupLayout.Alignment.TRAILING, 0, 180, Short.MAX_VALUE)
                                    .addComponent(txtfldPasswordChange, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldPasswordChangeAgain, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSavePassword1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblHeadlineRemoveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                                .addComponent(lblChooseUserToRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRemoveUser, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(cmbxChooseUserToRemove, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(265, 265, 265))))
        );
        pnlUserLayout.setVerticalGroup(
            pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirstname)
                            .addComponent(txtfldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeadlinePassword)
                            .addComponent(lblHeadlineAddUser))
                        .addGap(43, 43, 43)
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbxUserNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChooseUser))
                        .addGap(17, 17, 17)))
                .addGap(51, 51, 51)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastname)
                    .addComponent(lblWritePassword)
                    .addComponent(txtfldPasswordChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserNameInUserTab)
                    .addComponent(lblWritePasswordAgain)
                    .addComponent(txtfldPasswordChangeAgain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword)
                    .addComponent(btnSavePassword1))
                .addGap(65, 65, 65)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(lblHeadlineRemoveUser))
                .addGap(70, 70, 70)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMobileNumber)
                    .addComponent(cmbxChooseUserToRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseUserToRemove))
                .addGap(59, 59, 59)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbxAdmin)
                    .addComponent(btnRemoveUser))
                .addGap(31, 31, 31)
                .addComponent(btnAddUser)
                .addContainerGap(209, Short.MAX_VALUE))
        );




        lblChooseNotifications.setText("N�r vill du f� notiser?");

        btnSaveNotificationSettings.setText("Spara");
        btnSaveNotificationSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNotificationSettingsActionPerformed(evt);
            }
        });

        chbxNewPostInCourse.setText("Vid nytt inl�gg i Kurser");

        chbxNewPostInResearch.setText("Vid nytt inl�gg i Forskning");

        chbxNewPostInInfoSocial.setText("Vid nytt inl�gg i InfoSocial");

        chbxNewMeetingRequest.setText("Vid ny m�tesf�rfr�gan");

        chbxNewMeetingBooking.setText("Vid ny m�tesbokning");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbxNewPostInInfoSocial)
                    .addComponent(chbxNewPostInResearch)
                    .addComponent(chbxNewPostInCourse)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnSaveNotificationSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chbxNewMeetingRequest)
                    .addComponent(chbxNewMeetingBooking)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblChooseNotifications)))
                .addContainerGap(1012, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblChooseNotifications)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbxNewPostInCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbxNewPostInResearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbxNewPostInInfoSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbxNewMeetingRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chbxNewMeetingBooking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveNotificationSettings)
                .addContainerGap(668, Short.MAX_VALUE))
        );

        pnlNotifications.addTab("Notisinst�llningar", jPanel2);

      

        lblHeadline.setText("Välkommen till InfoNet!");
        lblHeadline.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        btnChangeUserDetails.setText("Ändra dina uppgifter");

        lblUserName.setText("Användare");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(lblHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangeUserDetails)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
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
                .addComponent(pnlNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMessageActionPerformed

        txtAreaMeddelanden.setText("");
        String selectedMessage = cmbMessage.getSelectedItem().toString();
        String queryOne;
        String firstname ;
        String lastname ;
        String Anstalld_ID;
        try{
            queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '"+selectedMessage+ "'");
            Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '"+selectedMessage+ "'");
            firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            txtAreaMeddelanden.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaMeddelanden.append("Titel: " + selectedMessage + "\n");
            txtAreaMeddelanden.append(queryOne);
            txtAreaMeddelanden.setLineWrap(true);
            txtAreaMeddelanden.setWrapStyleWord(true);

        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_cmbMessageActionPerformed

    private void btnWriteMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteMessageActionPerformed
        String title = txtTitel.getText();
        String message = txtAreaSkrivMeddelande.getText();
        String category = cmbKategori.getSelectedItem().toString();
        String categoryID;
        if(Validering.textFieldHasValue(txtTitel) && Validering.textAreaHasValue(txtAreaSkrivMeddelande)&& Validering.textFieldLessThen30(txtTitel)){


        try{
            String messageID = scrumXPdb.getAutoIncrement("blogginlagg", "inlagg_ID");
            categoryID = scrumXPdb.fetchSingle("SELECT kategori_id from kategori WHERE kategori_namn ='"+category+"'");
            String userID = scrumXPdb.fetchSingle("SELECT anstalld_ID FROM anstalld WHERE Anvandarnamn = '"+userName+"'");
            int CategoryIntID = Integer.parseInt(categoryID);
            scrumXPdb.insert("insert into blogginlagg(inlagg_id,formell,titel,bild,text,ansvarig_anstalld,kategori_ID) values ('"+messageID+"',1,'"+title+"','','"+message+"','" + userID + "','"+CategoryIntID+"')");


            txtTitel.setText("");
            txtAreaSkrivMeddelande.setText("");
            cmbMessage.addItem(title);
            JOptionPane.showMessageDialog(null, "Meddelande med titel " +title+ " Ã¤r nu tillagt");
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
        }
    }//GEN-LAST:event_btnWriteMessageActionPerformed

    private void setCbMeddelandenSocial() {

        String query = "Select Titel from Blogginlagg where formell = 2";
        ArrayList<String> titleName;
        try {

            titleName = scrumXPdb.fetchColumn(query);

            for (String titleNames : titleName) {

                cmbMessageSocial.addItem(titleNames);

            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Det finns inget meddelande till den titeln");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    }
    private void setCbCategory(){
        cmbKategori.removeAllItems();
        cmbCategories.removeAllItems();
        String query = "SELECT kategori_namn FROM kategori WHERE typ = 2";
        ArrayList<String> category;
        try{

            category = scrumXPdb.fetchColumn(query);

            for(String categories : category){
              cmbKategori.addItem(categories);
              cmbCategories.addItem(categories);
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Det finns inga kategorier i valt formella");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
  }
    private void setCbCategoryKurs(){
        cmbKategoriKurs.removeAllItems();
        cmbCategoriesKurs.removeAllItems();
        String query = "SELECT kategori_namn FROM kategori WHERE typ = 1";
        ArrayList<String> category;
        try{

            category = scrumXPdb.fetchColumn(query);

            for(String categories : category){
              cmbKategoriKurs.addItem(categories);
              cmbCategoriesKurs.addItem(categories);
            }
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Det finns inga kategorier i valt icke-formella");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
  }

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed

        String choosenName = cmbxUsers.getSelectedItem().toString();
        String choosenId = choosenName.replaceAll("\\D+", "");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String choosenDate = sdf.format(calendar1.getDate());

        Calendar.showMeeting(choosenId, choosenDate, scrumXPdb);
        fillCbEmployee();

    }//GEN-LAST:event_btnScheduleActionPerformed

    private void btnSavePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePasswordActionPerformed

        try{
            String password1 = txtfldPasswordChange.getText();
            String password2 = txtfldPasswordChangeAgain.getText();

            String bothNames = cmbxUserNames.getSelectedItem().toString();
            String[] names = bothNames.split(" ");
            String firstName = names[0];
            String lastName = names[1];

            if(Admin.changePassword(firstName, lastName, password1, password2, scrumXPdb)){
                JOptionPane.showMessageDialog(null, "LÃ¶senordet har uppdaterats");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LÃ¶senordet har inte uppdaterats, fÃ¶rsÃ¶k igen eller kontakta support");
        }
    }//GEN-LAST:event_btnSavePasswordActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        try{
            String firstName = txtfldFirstName.getText();
            String lastName = txtfldLastName.getText();
            String email = txtfldEmail.getText();
            String userName = txtfldUserName.getText();
            String password = txtfldPassword.getText();
            String telefon = txtfldTelefon.getText();
            String admin = "";
            if (chbxAdmin.isSelected()){
                admin = "j";
            }else {
                admin = "n";
            }

            if(Admin.addUser( firstName, lastName, email, userName, password, admin, telefon, scrumXPdb)){
                JOptionPane.showMessageDialog(null, "En anvÃ¤ndare har lagts till");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "AnvÃ¤ndaren har inte lagts till, fÃ¶rsÃ¶k igen eller kontakta support");
        }
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveUserActionPerformed
        try {
            String namesAndId = cmbxChooseUserToRemove.getSelectedItem().toString();
            String[] namesAndIdSplit = namesAndId.split(" ");
            String userId = namesAndIdSplit[2];

            if (Admin.makeUserInactive(userId, scrumXPdb)) {
                JOptionPane.showMessageDialog(null, "Användaren har inaktiverats");
                fillCbEmployee();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Användaren kanske inte är inaktiverad, försök igen eller kontakta support");

        }
    }//GEN-LAST:event_btnRemoveUserActionPerformed


    private void cmbxUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxUsersActionPerformed

    private void btnAddParticipantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddParticipantActionPerformed

        String participant = cbChoosenParticipant.getSelectedItem().toString();
        lstAddedParticipants.setModel(minLista);

       if(!minLista.contains(participant)) {

           minLista.addElement(participant);

        }

    }//GEN-LAST:event_btnAddParticipantActionPerformed

    private void btnEmptyListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmptyListActionPerformed
        minLista.clear();
        lstAddedParticipants.setModel(minLista);
    }//GEN-LAST:event_btnEmptyListActionPerformed

    private void btnScheduleAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleAllActionPerformed
        fillCbEmployee();
        SimpleDateFormat sdfAll = new SimpleDateFormat("yyyy-MM-dd");
        String choosenDateForAll = sdfAll.format(calendar1.getDate());
        Calendar.showMeetingForAll(choosenDateForAll, scrumXPdb);

    }//GEN-LAST:event_btnScheduleAllActionPerformed

    private void btnCompleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteBookingActionPerformed

        SimpleDateFormat dtfDate = new SimpleDateFormat("yyyy-MM-dd");


        if (Validering.textFieldHasValue(txtLocation) && Validering.textFieldHasValue(txtMeetingName) && Validering.textAreaHasValue(txtMeetingDescription) && Validering.timePickerGotValue(tpFrom) && Validering.timePickerGotValue(tpTo) && Validering.dateChooserGotValue(datepickerDate1)) {
        String choosenLocation = txtLocation.getText();
        String meetingName = txtMeetingName.getText();
        String meetingDescription = txtMeetingDescription.getText();
        String choosenDate = dtfDate.format(datepickerDate1.getDate());
        String timeFrom = tpFrom.getTime().toString().replace(":","");
        String timeTo = tpTo.getTime().toString().replace(":","");

        int tFrom = Integer.parseInt(timeFrom);
        int tTo = Integer.parseInt(timeTo);

        BookMeeting.confirmBooking(userName, choosenLocation, meetingName, meetingDescription, choosenDate, tFrom, tTo, scrumXPdb);
        }
    }//GEN-LAST:event_btnCompleteBookingActionPerformed


    private void btnAddNewCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCatActionPerformed

        String getCategory = txtAddNewCat.getText();

        try{
            String categoryID = scrumXPdb.getAutoIncrement("kategori", "kategori_ID");
            scrumXPdb.insert("insert into kategori values ('"+categoryID+"', '"+getCategory+"',2)");
            txtAddNewCat.setText("");
            setCbCategory();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NÃ¥gonting gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    }//GEN-LAST:event_btnAddNewCatActionPerformed

    private void cmbCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriesActionPerformed
        String getSelectedCategory = cmbCategories.getSelectedItem().toString();
        ArrayList<String>queries;
        try{
        queries = scrumXPdb.fetchColumn("SELECT titel FROM blogginlagg JOIN kategori ON blogginlagg.Kategori_ID_som_anvands=kategori.kategori_ID WHERE Kategori_namn ='"+getSelectedCategory+"'");
        cmbMessage.removeAllItems();

        for(String category: queries){

        cmbMessage.addItem(category);

        }

        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Det finns inga meddelanden i den hÃ¤r kategorin");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "NÃ¥gonting gick fel");
        }
    }//GEN-LAST:event_cmbCategoriesActionPerformed

    private void cmbMessageKursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMessageKursActionPerformed

        txtAreaMeddelandenKurs.setText("");
        String selectedMessage = cmbMessage.getSelectedItem().toString();
        String queryOne;
        String firstname ;
        String lastname ;
        String Anstalld_ID;
        try{
            queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '"+selectedMessage+ "'");
            Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '"+selectedMessage+ "'");
            firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            txtAreaMeddelandenKurs.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaMeddelandenKurs.append("Titel: " + selectedMessage + "\n");
            txtAreaMeddelandenKurs.append(queryOne);
            txtAreaMeddelandenKurs.setLineWrap(true);
            txtAreaMeddelandenKurs.setWrapStyleWord(true);

        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_cmbMessageKursActionPerformed

    private void btnWriteMessageKursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteMessageKursActionPerformed
        String title = txtTitelKurs.getText();
        String message = txtAreaSkrivMeddelandeKurs.getText();
        String category = cmbKategoriKurs.getSelectedItem().toString();
        String categoryID;
        if(Validering.textFieldHasValue(txtTitelKurs) && Validering.textAreaHasValue(txtAreaSkrivMeddelandeKurs)&& Validering.textFieldLessThen30(txtTitelKurs)){


        try{
            String messageID = scrumXPdb.getAutoIncrement("blogginlagg", "inlagg_ID");
            categoryID = scrumXPdb.fetchSingle("SELECT kategori_id from kategori WHERE kategori_namn ='"+category+"'");
            String userID = scrumXPdb.fetchSingle("SELECT anstalld_ID FROM anstalld WHERE Anvandarnamn = '"+userName+"'");
            int CategoryIntID = Integer.parseInt(categoryID);
            scrumXPdb.insert("insert into blogginlagg(inlagg_id,formell,titel,bild,text,ansvarig_anstalld,Kategori_ID_som_anvands) values ('"+messageID+"',0,'"+title+"','','"+message+"','" + userID + "','"+CategoryIntID+"')");


            txtTitelKurs.setText("");
            txtAreaSkrivMeddelandeKurs.setText("");
            cmbKategoriKurs.addItem(title);
            JOptionPane.showMessageDialog(null, "Meddelande med titel " +title+ " Ã¤r nu tillagt");
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }

        }
    }//GEN-LAST:event_btnWriteMessageKursActionPerformed

    private void btnAddNewCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCat1ActionPerformed

        String getCategory = txtAddNewCatKurs.getText();

        try{
            String categoryID = scrumXPdb.getAutoIncrement("kategori", "kategori_ID");
            scrumXPdb.insert("insert into kategori values ('"+categoryID+"', '"+getCategory+"',1)");
            txtAddNewCatKurs.setText("");
            setCbCategoryKurs();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NÃ¥gonting gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    }//GEN-LAST:event_btnAddNewCat1ActionPerformed

    private void cmbCategoriesKursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriesKursActionPerformed
        String getSelectedCategoryKurs = cmbCategoriesKurs.getSelectedItem().toString();

        ArrayList<String>queries;
        try{

        queries = scrumXPdb.fetchColumn("SELECT Titel FROM blogginlagg JOIN kategori ON blogginlagg.Kategori_ID_som_anvands=kategori.kategori_ID WHERE Kategori_namn = '"+getSelectedCategoryKurs+"'");

        cmbMessageKurs.removeAllItems();

        for(String category: queries){

        cmbMessageKurs.addItem(category);

        }

        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Det finns inga meddelanden i den hÃ¤r kategorin");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "NÃ¥gonting gick fel");
        }
    }//GEN-LAST:event_cmbCategoriesKursActionPerformed

    private void cmbMessageSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMessageSocialActionPerformed
        txtAreaMeddelandenSocial.setText("");
        String selectedMessage = cmbMessageSocial.getSelectedItem().toString();
        String queryOne;
        String firstname ;
        String lastname ;
        String Anstalld_ID;
        try{
            queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '"+selectedMessage+ "'");
            Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '"+selectedMessage+ "'");
            firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            txtAreaMeddelandenSocial.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaMeddelandenSocial.append("Titel: " + selectedMessage + "\n");
            txtAreaMeddelandenSocial.append(queryOne);
            txtAreaMeddelandenSocial.setLineWrap(true);
            txtAreaMeddelandenSocial.setWrapStyleWord(true);

        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_cmbMessageSocialActionPerformed

    private void btnWriteMessageSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteMessageSocialActionPerformed
        String title = txtTitelSocial.getText();
        String message = txtAreaSkrivMeddelandeSocial.getText();
        if(Validering.textFieldHasValue(txtTitelSocial) && Validering.textAreaHasValue(txtAreaSkrivMeddelandeSocial)&& Validering.textFieldLessThen30(txtTitelSocial)){
        try{
            String messageID = scrumXPdb.getAutoIncrement("blogginlagg", "inlagg_ID");
            String userID = scrumXPdb.fetchSingle("SELECT anstalld_ID FROM anstalld WHERE Anvandarnamn = '"+userName+"'");
            scrumXPdb.insert("insert into blogginlagg(inlagg_id,formell,titel,bild,text,ansvarig_anstalld,Kategori_ID_som_anvands) values ('"+messageID+"',2,'"+title+"','','"+message+"','" + userID + "', 3)");
            txtTitelSocial.setText("");
            txtAreaSkrivMeddelandeSocial.setText("");
            cmbMessageSocial.addItem(title);
            JOptionPane.showMessageDialog(null, "Meddelande med titel " +title+ " Ã¤r nu tillagt");
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_btnWriteMessageSocialActionPerformed
    }

    private void btnSaveNotificationSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNotificationSettingsActionPerformed
        Notifications.checkNewCourseNotification(scrumXPdb, userName);
        Notifications.checkNewResearchNotification(scrumXPdb, userName);
        Notifications.checkNewInfoSocialNotification(scrumXPdb, userName);
        Notifications.checkNewMeetingRequestNotification(scrumXPdb, userName);
        Notifications.checkNewMeetingIsBookedNotification(scrumXPdb, userName);
        JOptionPane.showMessageDialog(null, "Inst�llningar sparade");
    }//GEN-LAST:event_btnSaveNotificationSettingsActionPerformed






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewCat;
    private javax.swing.JButton btnAddNewCat1;
    private javax.swing.JButton btnAddParticipant;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnChangeUserDetails;
    private javax.swing.JButton btnRemoveUser;
    private javax.swing.JButton btnCompleteBooking;
    private javax.swing.JButton btnEmptyList;
    private javax.swing.JButton btnSaveNotificationSettings;
    private javax.swing.JButton btnSavePassword1;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnScheduleAll;
    private javax.swing.JButton btnWriteMessage;
    private javax.swing.JButton btnWriteMessageKurs;
    private javax.swing.JButton btnWriteMessageSocial;
    private com.toedter.calendar.JCalendar calendar1;
    private javax.swing.JComboBox<String> cbChoosenParticipant;
    private javax.swing.JCheckBox chbxAdmin;
    public static javax.swing.JCheckBox chbxNewMeetingBooking;
    public static javax.swing.JCheckBox chbxNewMeetingRequest;
    public static javax.swing.JCheckBox chbxNewPostInCourse;
    public static javax.swing.JCheckBox chbxNewPostInInfoSocial;
    public static javax.swing.JCheckBox chbxNewPostInResearch;
    private javax.swing.JComboBox<String> cmbMeddelanden;
    private javax.swing.JComboBox<String> cmbxChooseUserToRemove;
    private javax.swing.JComboBox<String> cmbCategories;
    private javax.swing.JComboBox<String> cmbCategoriesKurs;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JComboBox<String> cmbKategoriKurs;
    private javax.swing.JComboBox<String> cmbMessage;
    private javax.swing.JComboBox<String> cmbMessageKurs;
    private javax.swing.JComboBox<String> cmbMessageSocial;
    private javax.swing.JComboBox<String> cmbxUserNames;
    private javax.swing.JComboBox<String> cmbxUsers;
    private com.toedter.calendar.JDateChooser datepickerDate1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblAddNewCat;
    private javax.swing.JLabel lblAddNewCat1;
    private javax.swing.JLabel lblChooseEmployee;
    private javax.swing.JLabel lblChooseNotifications;
    private javax.swing.JLabel lblChooseParticipants;
    private javax.swing.JLabel lblChooseUser;
    private javax.swing.JLabel lblChooseUserToRemove;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblHeadlineAddUser;
    private javax.swing.JLabel lblHeadlinePassword;
    private javax.swing.JLabel lblHeadlineRemoveUser;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblKategori1;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblMeddelanden;
    private javax.swing.JLabel lblMeddelanden2;
    private javax.swing.JLabel lblMeddelanden3;
    private javax.swing.JLabel lblMeddelanden4;
    private javax.swing.JLabel lblMeddelandenSocial;
    private javax.swing.JLabel lblMeetingDate;
    private javax.swing.JLabel lblMeetingDescription;
    private javax.swing.JLabel lblMeetingLocation;
    private javax.swing.JLabel lblMeetingName;
    private javax.swing.JLabel lblMobileNumber;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSkrivMeddelande;
    private javax.swing.JLabel lblSkrivMeddelande2;
    private javax.swing.JLabel lblSkrivMeddelandeSocial;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimeTo;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblTitel2;
    private javax.swing.JLabel lblTitelSocial;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNameInUserTab;
    private javax.swing.JLabel lblWritePassword;
    private javax.swing.JLabel lblWritePasswordAgain;
    public static javax.swing.JList<String> lstAddedParticipants;
    private java.awt.Panel panel1;
    private javax.swing.JPanel pnlCourses;
    private javax.swing.JTabbedPane pnlNotifications;
    private javax.swing.JPanel pnlResearch;
    private javax.swing.JPanel pnlResearch1;
    private javax.swing.JPanel pnlResearch2;
    private javax.swing.JPanel pnlSocial;
    private javax.swing.JPanel pnlUser;
    private com.github.lgooddatepicker.components.TimePicker tpFrom;
    private com.github.lgooddatepicker.components.TimePicker tpTo;
    private javax.swing.JTextField txtAddNewCat;
    private javax.swing.JTextField txtAddNewCatKurs;
    private javax.swing.JTextArea txtAreaMeddelanden;
    private javax.swing.JTextArea txtAreaMeddelandenKurs;
    private javax.swing.JTextArea txtAreaMeddelandenSocial;
    public static javax.swing.JTextArea txtAreaSchedule;
    private javax.swing.JTextArea txtAreaSkrivMeddelande;
    private javax.swing.JTextArea txtAreaSkrivMeddelandeKurs;
    private javax.swing.JTextArea txtAreaSkrivMeddelandeSocial;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextArea txtMeetingDescription;
    private javax.swing.JTextField txtMeetingName;
    private javax.swing.JTextField txtTitel;
    private javax.swing.JTextField txtTitelKurs;
    private javax.swing.JTextField txtTitelSocial;
    private javax.swing.JTextField txtfldEmail;
    private javax.swing.JTextField txtfldFirstName;
    private javax.swing.JTextField txtfldLastName;
    private javax.swing.JTextField txtfldPassword;
    private javax.swing.JTextField txtfldPasswordChange;
    private javax.swing.JTextField txtfldPasswordChangeAgain;
    private javax.swing.JTextField txtfldTelefon;
    private javax.swing.JTextField txtfldUserName;
    // End of variables declaration//GEN-END:variables
}
