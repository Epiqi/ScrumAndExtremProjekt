
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Team 12
 */
public class HomePage extends javax.swing.JFrame {

    private static InfDB scrumXPdb;
    public static String userName;
    private String imagePath;
    private String imageFetchPath;
    private BufferedImage image;
    DefaultListModel minLista = new DefaultListModel();
    private Path path;
    private Path copied;

    /**
     * Creates new form HomePage
     */
    public HomePage(InfDB scrumXPdb, String userName) {
        this.scrumXPdb = scrumXPdb;
        this.userName = userName;
        imagePath = " ";
        initComponents();
        welcomeUser();
        isAdmin();
        fillCbEmployee();
        setCbCategory();
        setCbCategoryKurs();
        setCbMeddelandenSocial();
        Notifications.fillCheckBoxesNotifications(scrumXPdb, userName);
        setCbMeeting();
        setCbMyMeeting();
        hideMyDetails();

    }

    private void welcomeUser() {

        String fetchFirstName = "Select Fornamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        String fetchLastName = "Select Efternamn From Anstalld Where Anvandarnamn = '" + userName + "'";
        try {

            String FirstName = scrumXPdb.fetchSingle(fetchFirstName);
            String LastName = scrumXPdb.fetchSingle(fetchLastName);
            lblUserName.setText(FirstName + " " + LastName);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Kunde inte hitta ditt namn");
        }
    }

    private void isAdmin() {

        try {
            String adminQuestion = "Select Administrator From anstalld Where Anvandarnamn ='" + userName + "'";
            String admin = scrumXPdb.fetchSingle(adminQuestion);
            if (admin.equalsIgnoreCase("n")) {
                pnlUser.remove(pnlUser); 
            } else {
                fillWithUsers();
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void fillCbEmployee() {
      
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
            cbChoosenParticipant.removeAllItems();
            for (HashMap<String, String> employees : allEmployees) {

                cmbxUsers.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                cbChoosenParticipant.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                cmbxUserNames.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                cmbxChooseUserToRemove.addItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                if (loginActive.get(i).equalsIgnoreCase("n")) {
                    cmbxUsers.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                    cmbxUserNames.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                    cmbxChooseUserToRemove.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                    cbChoosenParticipant.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                }
                if (userId.equalsIgnoreCase(employees.get("ANSTALLD_ID"))) {

                    cmbxUserNames.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                    cmbxChooseUserToRemove.removeItem(employees.get("FORNAMN") + " " + employees.get("EFTERNAMN") + " " + employees.get("ANSTALLD_ID"));
                }
                i++;
            }
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) {

            JOptionPane.showMessageDialog(null, "N?got gick fel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

    private void hideMyDetails() {
        pnlNotifications.remove(pnlDetails);
    }

    private void fillWithUsers() {

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

            JOptionPane.showMessageDialog(null, "L?mpligt fel");

        }
    }


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
        btnFile = new javax.swing.JButton();
        txtFile = new javax.swing.JTextField();
        btnShowFile = new javax.swing.JButton();
        lblFile = new javax.swing.JLabel();
        txtfldFile = new javax.swing.JTextField();
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
        txtFileForskning = new javax.swing.JTextField();
        btnFileForskning = new javax.swing.JButton();
        btnShowFileForskning = new javax.swing.JButton();
        txtfldFileForskning = new javax.swing.JTextField();
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
        lblImage = new javax.swing.JLabel();
        btnChoosePicture = new javax.swing.JButton();
        lblPicture = new javax.swing.JLabel();
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
        btnMeetingRequest = new javax.swing.JButton();
        btnAnswerMeeting = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtAreaMeetingAnswer = new javax.swing.JTextArea();
        cmbxMeetingName = new javax.swing.JComboBox<>();
        lblAddedPersons = new javax.swing.JLabel();
        lblMeetingRequestAnswers = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        lblHeadlineRemoveUser = new javax.swing.JLabel();
        lblChooseUserToRemove = new javax.swing.JLabel();
        cmbxChooseUserToRemove = new javax.swing.JComboBox<>();
        btnRemoveUser = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblChooseNotifications = new javax.swing.JLabel();
        btnSaveNotificationSettings = new javax.swing.JButton();
        chbxNewPostInCourse = new javax.swing.JCheckBox();
        chbxNewPostInResearch = new javax.swing.JCheckBox();
        chbxNewPostInInfoSocial = new javax.swing.JCheckBox();
        chbxNewMeetingRequest = new javax.swing.JCheckBox();
        btnReminder = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        textAreaChooseInfo = new javax.swing.JTextArea();
        jDateChooseDate = new com.toedter.calendar.JDateChooser();
        timePickerChooseTime = new com.github.lgooddatepicker.components.TimePicker();
        lblChooseDate = new javax.swing.JLabel();
        lblChooseTime = new javax.swing.JLabel();
        cmbMyMeeting = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pnlDetails = new javax.swing.JPanel();
        lblHeadlineDetails = new javax.swing.JLabel();
        lblChangeMail = new javax.swing.JLabel();
        lblChangeMobile = new javax.swing.JLabel();
        lblCurrentMail = new javax.swing.JLabel();
        lblPresentMobile = new javax.swing.JLabel();
        lblHeadlineChangePassword = new javax.swing.JLabel();
        lblCurrentPassword = new javax.swing.JLabel();
        lblNewPassword = new javax.swing.JLabel();
        lblNewPasswordAgain = new javax.swing.JLabel();
        txtfldChangeMail = new javax.swing.JTextField();
        txtfldChangeMobile = new javax.swing.JTextField();
        btnChangeMail = new javax.swing.JButton();
        btnChangeMobilenumber = new javax.swing.JButton();
        pswrdfldCurrent = new javax.swing.JPasswordField();
        pswrdfldNew = new javax.swing.JPasswordField();
        pswrdfldNewAgain = new javax.swing.JPasswordField();
        btnSavePasswordUser = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblHeadline = new javax.swing.JLabel();
        btnChangeUserDetails = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        btnCheckMyMessages = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbMessageKurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMessageKursActionPerformed(evt);
            }
        });

        lblMeddelanden3.setText("V?lj meddelanden nedan");

        txtAreaMeddelandenKurs.setColumns(20);
        txtAreaMeddelandenKurs.setEditable(false);
        txtAreaMeddelandenKurs.setRows(5);
        txtAreaMeddelandenKurs.setMaximumSize(new java.awt.Dimension(164, 94));
        jScrollPane6.setViewportView(txtAreaMeddelandenKurs);

        btnWriteMessageKurs.setText("Skriv nytt meddelande");
        btnWriteMessageKurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteMessageKursActionPerformed(evt);
            }
        });

        lblTitel2.setText("Skriv in titel p? meddelande:");

        lblSkrivMeddelande2.setText("Skriv in ditt meddelande:");

        txtAreaSkrivMeddelandeKurs.setColumns(20);
        txtAreaSkrivMeddelandeKurs.setLineWrap(true);
        txtAreaSkrivMeddelandeKurs.setRows(5);
        txtAreaSkrivMeddelandeKurs.setWrapStyleWord(true);
        jScrollPane7.setViewportView(txtAreaSkrivMeddelandeKurs);

        lblKategori1.setText("V?lj kategori:");

        lblAddNewCat1.setText("L?gg till ny kategori");

        btnAddNewCat1.setText("L?gg till");
        btnAddNewCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCat1ActionPerformed(evt);
            }
        });

        lblMeddelanden4.setText("V?lj kategori nedan");

        cmbCategoriesKurs.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                cmbCategoriesKursComponentRemoved(evt);
            }
        });
        cmbCategoriesKurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriesKursActionPerformed(evt);
            }
        });

        btnFile.setText("V?lj fil...");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        txtFile.setEditable(false);
        txtFile.setText("Ingen fil vald");

        btnShowFile.setText("Visa fil");
        btnShowFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowFileActionPerformed(evt);
            }
        });

        txtfldFile.setEditable(false);

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
                .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlResearch2Layout.createSequentialGroup()
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResearch2Layout.createSequentialGroup()
                                .addComponent(lblFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(pnlResearch2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtfldFile, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnShowFile))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResearch2Layout.createSequentialGroup()
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlResearch2Layout.createSequentialGroup()
                                .addComponent(lblTitel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKategori1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlResearch2Layout.createSequentialGroup()
                                .addComponent(txtTitelKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbKategoriKurs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlResearch2Layout.createSequentialGroup()
                                .addComponent(btnWriteMessageKurs)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtFile))
                        .addGap(79, 79, 79))
                    .addGroup(pnlResearch2Layout.createSequentialGroup()
                        .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSkrivMeddelande2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResearch2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFile)
                    .addComponent(btnShowFile)
                    .addComponent(lblFile)
                    .addComponent(txtfldFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnWriteMessageKurs)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCoursesLayout = new javax.swing.GroupLayout(pnlCourses);
        pnlCourses.setLayout(pnlCoursesLayout);
        pnlCoursesLayout.setHorizontalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1326, Short.MAX_VALUE)
            .addGroup(pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCoursesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlResearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlCoursesLayout.setVerticalGroup(
            pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
            .addGroup(pnlCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCoursesLayout.createSequentialGroup()
                    .addComponent(pnlResearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlNotifications.addTab("Kurser", pnlCourses);

        cmbMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMessageActionPerformed(evt);
            }
        });

        lblMeddelanden.setText("V?lj meddelanden nedan");

        txtAreaMeddelanden.setColumns(20);
        txtAreaMeddelanden.setEditable(false);
        txtAreaMeddelanden.setRows(5);
        txtAreaMeddelanden.setMaximumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(txtAreaMeddelanden);

        btnWriteMessage.setText("Skriv nytt meddelande");
        btnWriteMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteMessageActionPerformed(evt);
            }
        });

        lblTitel.setText("Skriv in titel p? meddelande:");

        lblSkrivMeddelande.setText("Skriv in ditt meddelande:");

        txtAreaSkrivMeddelande.setColumns(20);
        txtAreaSkrivMeddelande.setLineWrap(true);
        txtAreaSkrivMeddelande.setRows(5);
        txtAreaSkrivMeddelande.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtAreaSkrivMeddelande);

        lblKategori.setText("V?lj kategori:");

        lblAddNewCat.setText("L?gg till ny kategori");

        btnAddNewCat.setText("L?gg till");
        btnAddNewCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCatActionPerformed(evt);
            }
        });

        lblMeddelanden2.setText("V?lj kategori nedan");

        cmbCategories.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                cmbCategoriesComponentRemoved(evt);
            }
        });
        cmbCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriesActionPerformed(evt);
            }
        });

        txtFileForskning.setEditable(false);
        txtFileForskning.setText("Ingen fil vald");

        btnFileForskning.setText("V?lj fil...");
        btnFileForskning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileForskningActionPerformed(evt);
            }
        });

        btnShowFileForskning.setText("Visa fil");
        btnShowFileForskning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowFileForskningActionPerformed(evt);
            }
        });

        txtfldFileForskning.setEditable(false);

        javax.swing.GroupLayout pnlResearchLayout = new javax.swing.GroupLayout(pnlResearch);
        pnlResearch.setLayout(pnlResearchLayout);
        pnlResearchLayout.setHorizontalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddNewCat)
                            .addComponent(lblMeddelanden2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewCat)
                    .addComponent(txtAddNewCat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addComponent(txtfldFileForskning, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowFileForskning))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addComponent(lblSkrivMeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResearchLayout.createSequentialGroup()
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFileForskning))
                        .addContainerGap())
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addComponent(txtTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnWriteMessage)
                            .addComponent(btnFileForskning, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlResearchLayout.setVerticalGroup(
            pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResearchLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResearchLayout.createSequentialGroup()
                        .addComponent(lblMeddelanden2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMeddelanden, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAddNewCat)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddNewCat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddNewCat))
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
                        .addGap(4, 4, 4)
                        .addComponent(txtFileForskning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(pnlResearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFileForskning)
                    .addComponent(btnShowFileForskning)
                    .addComponent(txtfldFileForskning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnWriteMessage)
                .addGap(342, 342, 342))
        );

        pnlNotifications.addTab("Forskning", pnlResearch);

        cmbMessageSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMessageSocialActionPerformed(evt);
            }
        });

        lblMeddelandenSocial.setText("V?lj meddelanden nedan");

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

        lblTitelSocial.setText("Skriv in titel p? meddelande:");

        lblSkrivMeddelandeSocial.setText("Skriv in ditt meddelande:");

        txtAreaSkrivMeddelandeSocial.setColumns(20);
        txtAreaSkrivMeddelandeSocial.setLineWrap(true);
        txtAreaSkrivMeddelandeSocial.setRows(5);
        txtAreaSkrivMeddelandeSocial.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txtAreaSkrivMeddelandeSocial);

        btnChoosePicture.setText("V?lj bild...");
        btnChoosePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoosePictureActionPerformed(evt);
            }
        });

        lblPicture.setText("Ingen fil vald");

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
                .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlResearch1Layout.createSequentialGroup()
                        .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitelSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitelSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSkrivMeddelandeSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlResearch1Layout.createSequentialGroup()
                                .addComponent(btnChoosePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnWriteMessageSocial)))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addGap(79, 79, 79))
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
                        .addGap(4, 4, 4)
                        .addComponent(lblPicture)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlResearch1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnWriteMessageSocial)
                            .addComponent(btnChoosePicture)))
                    .addComponent(jScrollPane4)
                    .addGroup(pnlResearch1Layout.createSequentialGroup()
                        .addComponent(lblMeddelandenSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMessageSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSocialLayout = new javax.swing.GroupLayout(pnlSocial);
        pnlSocial.setLayout(pnlSocialLayout);
        pnlSocialLayout.setHorizontalGroup(
            pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1270, Short.MAX_VALUE)
            .addGroup(pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlResearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSocialLayout.setVerticalGroup(
            pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
            .addGroup(pnlSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSocialLayout.createSequentialGroup()
                    .addComponent(pnlResearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlNotifications.addTab("InfoSocial", pnlSocial);

        txtAreaSchedule.setColumns(20);
        txtAreaSchedule.setRows(5);
        jScrollPane3.setViewportView(txtAreaSchedule);

        btnSchedule.setText("Visa schema f?r vald person");
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

        lblChooseEmployee.setText("V?lj medarbetare:");

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
                .addGap(110, 110, 110)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(calendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(btnScheduleAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblChooseEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(474, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblChooseEmployee)
                        .addComponent(cmbxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnScheduleAll, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );

        pnlNotifications.addTab("Almanacka", panel1);

        lblChooseParticipants.setText("V?lj deltagare att l?gga till:");

        jScrollPane8.setViewportView(lstAddedParticipants);

        lblMeetingLocation.setText("Plats:");

        lblMeetingDescription.setText("Beskrivning:");

        lblMeetingDate.setText("Datum:");

        lblTime.setText("Tid:");

        lblTimeTo.setText("till");

        btnCompleteBooking.setText("Genomf?r bokning");
        btnCompleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteBookingActionPerformed(evt);
            }
        });

        txtMeetingDescription.setColumns(20);
        txtMeetingDescription.setRows(5);
        jScrollPane9.setViewportView(txtMeetingDescription);

        btnAddParticipant.setText("L?gg till");
        btnAddParticipant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddParticipantActionPerformed(evt);
            }
        });

        btnEmptyList.setText("T?m lista");
        btnEmptyList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmptyListActionPerformed(evt);
            }
        });

        lblMeetingName.setText("M?tesnamn:");

        btnMeetingRequest.setText("Skapa m?tesf?rfr?gan");
        btnMeetingRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeetingRequestActionPerformed(evt);
            }
        });

        btnAnswerMeeting.setText("Svara m?tesf?rfr?gningar");
        btnAnswerMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerMeetingActionPerformed(evt);
            }
        });

        txtAreaMeetingAnswer.setColumns(20);
        txtAreaMeetingAnswer.setRows(5);
        txtAreaMeetingAnswer.setWrapStyleWord(true);
        jScrollPane10.setViewportView(txtAreaMeetingAnswer);

        cmbxMeetingName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxMeetingNameActionPerformed(evt);
            }
        });
        cmbxMeetingName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbxMeetingNameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbxMeetingName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(cmbxMeetingName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblAddedPersons.setText("Tillagda personer:");

        lblMeetingRequestAnswers.setText("M?tesf?rfr?gningssvar:");

        jLabel3.setText("Gl?m inte att l?gga till dig sj?lv som deltagare!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAnswerMeeting)
                .addGap(18, 18, 18)
                .addComponent(btnMeetingRequest)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMeetingDescription)
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
                                .addComponent(datepickerDate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblChooseParticipants))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEmptyList)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddedPersons))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMeetingRequestAnswers)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnCompleteBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(450, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblChooseParticipants)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                                    .addComponent(lblTimeTo)
                                    .addComponent(btnEmptyList)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMeetingRequestAnswers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblAddedPersons)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMeetingRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnswerMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompleteBooking)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pnlNotifications.addTab("M?tesbokning", jPanel1);

        lblHeadlineAddUser.setText("L?gg till anv?ndare");
        lblHeadlineAddUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblHeadlinePassword.setText("Byt l?senord ?t anv?ndare");
        lblHeadlinePassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblFirstname.setText("F?rnamn:");

        lblUserNameInUserTab.setText("Username:");

        lblPassword.setText("L?senord:");

        lblEmail.setText("Email:");

        lblMobileNumber.setText("Mobilnr:");

        cmbxUserNames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblChooseUser.setText("V?lj anv?ndare:");

        lblWritePassword.setText("Ange l?senord:");

        lblWritePasswordAgain.setText("Ange l?senord igen:");

        btnAddUser.setText("L?gg till");
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

        chbxAdmin.setText("Checka i f?r att g?ra anv?ndaren till admin");

        lblHeadlineRemoveUser.setText("Ta bort anv?ndare");
        lblHeadlineRemoveUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblChooseUserToRemove.setText("V?lj anv?ndare att ta bort:");

        cmbxChooseUserToRemove.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnlUserLayout.createSequentialGroup()
                                        .addComponent(chbxAdmin)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtfldFirstName)
                                    .addComponent(txtfldLastName))
                                .addGap(196, 196, 196))
                            .addGroup(pnlUserLayout.createSequentialGroup()
                                .addComponent(lblHeadlineAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeadlinePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(lblHeadlineRemoveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserLayout.createSequentialGroup()
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblChooseUser)
                                    .addComponent(lblWritePassword)
                                    .addComponent(lblWritePasswordAgain))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbxUserNames, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtfldPasswordChange, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtfldPasswordChangeAgain, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSavePassword1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
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
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHeadlinePassword)
                            .addComponent(lblHeadlineAddUser))
                        .addGap(43, 43, 43)
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbxUserNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChooseUser))
                        .addGap(17, 17, 17))
                    .addGroup(pnlUserLayout.createSequentialGroup()
                        .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFirstname)
                            .addComponent(txtfldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
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
                    .addComponent(lblChooseUserToRemove)
                    .addComponent(cmbxChooseUserToRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(pnlUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbxAdmin)
                    .addComponent(btnRemoveUser))
                .addGap(31, 31, 31)
                .addComponent(btnAddUser)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        pnlNotifications.addTab("Anv?ndare", pnlUser);

        lblChooseNotifications.setText("N?r vill du f? notiser?");

        btnSaveNotificationSettings.setText("Spara");
        btnSaveNotificationSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNotificationSettingsActionPerformed(evt);
            }
        });

        chbxNewPostInCourse.setText("Vid nytt inl?gg i Kurser");

        chbxNewPostInResearch.setText("Vid nytt inl?gg i Forskning");

        chbxNewPostInInfoSocial.setText("Vid nytt inl?gg i InfoSocial");

        chbxNewMeetingRequest.setText("Vid ny m?tesf?rfr?gan");

        btnReminder.setText("S?tt p?minnelse");
        btnReminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReminderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Skapa p?minnelse");

        textAreaChooseInfo.setColumns(20);
        textAreaChooseInfo.setRows(5);
        jScrollPane11.setViewportView(textAreaChooseInfo);

        lblChooseDate.setText("V?lj datum");

        lblChooseTime.setText("V?lj tid");

        cmbMyMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMyMeetingActionPerformed(evt);
            }
        });

        jLabel2.setText("V?lj m?te:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblChooseTime, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(timePickerChooseTime, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(lblChooseDate))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbMyMeeting, 0, 107, Short.MAX_VALUE)
                                .addComponent(jDateChooseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMyMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseDate))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timePickerChooseTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseTime))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chbxNewPostInResearch)
                            .addComponent(chbxNewPostInCourse)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnSaveNotificationSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chbxNewMeetingRequest)
                    .addComponent(chbxNewPostInInfoSocial)
                    .addComponent(lblChooseNotifications))
                .addGap(286, 286, 286)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReminder)
                .addGap(0, 222, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(btnReminder))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblChooseNotifications)
                        .addGap(18, 18, 18)
                        .addComponent(chbxNewPostInInfoSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbxNewMeetingRequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chbxNewPostInCourse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chbxNewPostInResearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnSaveNotificationSettings))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(520, Short.MAX_VALUE))
        );

        pnlNotifications.addTab("Notisinst?llningar", jPanel2);

        lblHeadlineDetails.setText("H?r kan du ?ndra dina uppgifter");
        lblHeadlineDetails.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblChangeMail.setText("?ndra min mailadress till:");

        lblChangeMobile.setText("?ndra mitt mobilnummer till:");

        lblCurrentMail.setText("Din nuvarande mail ?r...");

        lblPresentMobile.setText("Ditt nuvarande mobilnummer ?r...");

        lblHeadlineChangePassword.setText("H?r kan du ?ndra ditt l?senord");
        lblHeadlineChangePassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        lblCurrentPassword.setText("Ditt nuvarande l?senord:");

        lblNewPassword.setText("Ange nytt l?senord:");

        lblNewPasswordAgain.setText("Ange nytt l?senord igen:");

        btnChangeMail.setText("Spara mail");
        btnChangeMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeMailActionPerformed(evt);
            }
        });

        btnChangeMobilenumber.setText("Spara mobilnr");
        btnChangeMobilenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeMobilenumberActionPerformed(evt);
            }
        });

        btnSavePasswordUser.setText("Spara");
        btnSavePasswordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePasswordUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurrentPassword)
                            .addComponent(lblNewPassword)
                            .addComponent(lblNewPasswordAgain))
                        .addGap(40, 40, 40)
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pswrdfldCurrent)
                            .addComponent(pswrdfldNew)
                            .addComponent(pswrdfldNewAgain)
                            .addComponent(btnSavePasswordUser, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                    .addComponent(lblHeadlineChangePassword)
                    .addComponent(lblHeadlineDetails)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetailsLayout.createSequentialGroup()
                                .addComponent(lblPresentMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblChangeMobile))
                            .addGroup(pnlDetailsLayout.createSequentialGroup()
                                .addComponent(lblCurrentMail, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblChangeMail)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfldChangeMobile, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtfldChangeMail))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnChangeMobilenumber, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(btnChangeMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 321, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblHeadlineDetails)
                .addGap(59, 59, 59)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentMail)
                    .addComponent(lblChangeMail)
                    .addComponent(txtfldChangeMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangeMail))
                .addGap(26, 26, 26)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPresentMobile)
                    .addComponent(lblChangeMobile)
                    .addComponent(txtfldChangeMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangeMobilenumber))
                .addGap(70, 70, 70)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblHeadlineChangePassword)
                .addGap(57, 57, 57)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentPassword)
                    .addComponent(pswrdfldCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassword)
                    .addComponent(pswrdfldNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPasswordAgain)
                    .addComponent(pswrdfldNewAgain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnSavePasswordUser)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        pnlNotifications.addTab("Mina uppgifter", pnlDetails);

        lblHeadline.setText("V?lkommen till InfoNet!");
        lblHeadline.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        btnChangeUserDetails.setText("?ndra dina uppgifter");
        btnChangeUserDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeUserDetailsActionPerformed(evt);
            }
        });

        lblUserName.setText("Anv?ndare");

        btnCheckMyMessages.setText("Visa mina meddelanden");
        btnCheckMyMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckMyMessagesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(lblHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckMyMessages)
                        .addGap(18, 18, 18)
                        .addComponent(btnChangeUserDetails)))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeadline)
                    .addComponent(lblUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeUserDetails)
                    .addComponent(btnCheckMyMessages))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMessageActionPerformed
        txtfldFileForskning.setText("");
        txtAreaMeddelanden.setText("");
        String selectedMessage = cmbMessage.getSelectedItem().toString();
        String queryOne;
        String firstname;
        String lastname;
        String Anstalld_ID;
        String fileToShow;
        try{
            queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '"+selectedMessage+ "'");
            Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '"+selectedMessage+ "'");
            firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            fileToShow = scrumXPdb.fetchSingle("select bild from blogginlagg where titel = '"+selectedMessage+"'");
            txtAreaMeddelanden.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaMeddelanden.append("Titel: " + selectedMessage + "\n");
            txtAreaMeddelanden.append(queryOne);
            txtAreaMeddelanden.setLineWrap(true);
            txtAreaMeddelanden.setWrapStyleWord(true);
            txtfldFileForskning.setText(fileToShow);

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_cmbMessageActionPerformed

    private void btnWriteMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteMessageActionPerformed
        String title = txtTitel.getText();
        String message = txtAreaSkrivMeddelande.getText();
        String category = cmbKategori.getSelectedItem().toString();
        String categoryID;
        String copiedPath;
        String sameCategory = cmbCategories.getSelectedItem().toString();
        if(Validering.textFieldHasValue(txtTitel) && Validering.textAreaHasValue(txtAreaSkrivMeddelande)&& Validering.textFieldLessThen30(txtTitel)){
        try{
            String messageID = scrumXPdb.getAutoIncrement("blogginlagg", "inlagg_ID");
            categoryID = scrumXPdb.fetchSingle("SELECT kategori_id from kategori WHERE kategori_namn ='"+category+"'");
            String userID = scrumXPdb.fetchSingle("SELECT anstalld_ID FROM anstalld WHERE Anvandarnamn = '"+userName+"'");
            int CategoryIntID = Integer.parseInt(categoryID);
            if(txtFileForskning.getText().equals("Ingen fil vald")){
                copiedPath = " ";
            }
            else{
                copiedPath = copied.toString();
                copiedPath = copiedPath.replaceAll("\\\\", "\\\\\\\\");
                Files.copy(path, copied, StandardCopyOption.REPLACE_EXISTING);
            }
            
            scrumXPdb.insert("insert into blogginlagg(inlagg_id,formell,titel,bild,text,ansvarig_anstalld,Kategori_ID_som_anvands,synlig) values ('"+messageID+"',1,'"+title+"','"+copiedPath+"','"+message+"','" + userID + "','"+CategoryIntID+"',1)");
            txtTitel.setText("");
            txtAreaSkrivMeddelande.setText("");

            if(sameCategory.equals(category)){
                cmbMessage.addItem(title);
            }

            JOptionPane.showMessageDialog(null, "Meddelande med titel " +title+ " ?r nu tillagt");
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
         catch(IOException e){       
        }
        }
        JavaMailUtil.ForskningNotifikationMail(scrumXPdb);
    }//GEN-LAST:event_btnWriteMessageActionPerformed

    public static void setCbMeddelandenSocial() {
        String query = "Select Titel from Blogginlagg where formell = 2 AND blogginlagg.synlig = 1";
        ArrayList<String> titleName;
        try {
            titleName = scrumXPdb.fetchColumn(query);
                    for (String titleNames : titleName) {

                    cmbMessageSocial.addItem(titleNames);

            }                       
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inget meddelande till den titeln");
            System.out.println("Internt felmeddelande" + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    }

    public static void setCbCategory() {
        //cmbCategories.removeAllItems();
        //cmbKategori.removeAllItems();
        String query = "SELECT Kategori_namn FROM Kategori WHERE Typ = 2";
        ArrayList<String> category;
        try {
            category = scrumXPdb.fetchColumn(query);              
                for (String categories : category) {
                cmbKategori.addItem(categories);
                cmbCategories.addItem(categories);
                }           
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga kategorier i valt formella");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }

    }

    public static void setCbCategoryKurs() {
        cmbKategoriKurs.removeAllItems();
        cmbCategoriesKurs.removeAllItems();
        String query = "SELECT Kategori_namn FROM Kategori WHERE Typ = 1";
        ArrayList<String> category;
        try {
            category = scrumXPdb.fetchColumn(query);
                    for (String categories : category) {
                        cmbKategoriKurs.addItem(categories);
                        cmbCategoriesKurs.addItem(categories);
            }                            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga kategorier i valt icke-formella");
        } catch (Exception e) {
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

        try {
            String password1 = txtfldPasswordChange.getText();
            String password2 = txtfldPasswordChangeAgain.getText();

            String bothNames = cmbxUserNames.getSelectedItem().toString();
            String[] names = bothNames.split(" ");
            String firstName = names[0];
            String lastName = names[1];

            if (Admin.changePassword(firstName, lastName, password1, password2, scrumXPdb)) {
                JOptionPane.showMessageDialog(null, "L?senordet har uppdaterats");
                txtfldPasswordChange.setText("");
                txtfldPasswordChangeAgain.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "L?senordet har inte uppdaterats, f?rs?k igen eller kontakta support");
        }
    }//GEN-LAST:event_btnSavePasswordActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        try {
            String firstName = txtfldFirstName.getText();
            String lastName = txtfldLastName.getText();
            String email = txtfldEmail.getText();
            String userName = txtfldUserName.getText();
            String password = txtfldPassword.getText();
            String telefon = txtfldTelefon.getText();
            String admin = "";
            if (chbxAdmin.isSelected()) {
                admin = "Y";
            } else {
                admin = "N";
            }

            if (Admin.addUser(firstName, lastName, email, userName, password, admin, telefon, scrumXPdb)) {
                JOptionPane.showMessageDialog(null, "En anv?ndare har lagts till"); 
                txtfldFirstName.setText("");
                txtfldLastName.setText("");
                txtfldEmail.setText("");
                txtfldUserName.setText("");
                txtfldPassword.setText("");
                txtfldTelefon.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Anv?ndaren har inte lagts till, f?rs?k igen eller kontakta support");
        }
    }//GEN-LAST:event_btnAddUserActionPerformed


    private void cmbxUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbxUsersActionPerformed

    private void btnAddParticipantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddParticipantActionPerformed

        String participant = cbChoosenParticipant.getSelectedItem().toString();
        lstAddedParticipants.setModel(minLista);

        if (!minLista.contains(participant)) {

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
        
        

        if (Validering.textFieldHasValue(txtLocation) && Validering.textFieldHasValue(txtMeetingName) && Validering.textAreaHasValue(txtMeetingDescription)
                && Validering.timePickerGotValue(tpFrom) && Validering.timePickerGotValue(tpTo) && Validering.dateChooserGotValue(datepickerDate1) && Validering.jListHasValue(lstAddedParticipants) && 
                Validering.isDateLaterAndTimeIsAfter(dtfDate.format(datepickerDate1.getDate()), tpFrom.getTimeStringOrEmptyString())) {
            String choosenLocation = txtLocation.getText();
            String meetingName = txtMeetingName.getText();
            String meetingDescription = txtMeetingDescription.getText();
            String choosenDate = dtfDate.format(datepickerDate1.getDate());
            String timeFrom = tpFrom.getTime().toString().replace(":", "");
            String timeTo = tpTo.getTime().toString().replace(":", "");

            int tFrom = Integer.parseInt(timeFrom);
            int tTo = Integer.parseInt(timeTo);

            if(tFrom < tTo) {
                
            BookMeeting.confirmBooking(userName, choosenLocation, meetingName, meetingDescription, choosenDate, tFrom, tTo, scrumXPdb);

            JavaMailUtil.Motes_bokningNotifikationMail(scrumXPdb);
            setCbMyMeeting();
            
            }
            else if(tFrom > tTo) {
                    JOptionPane.showMessageDialog(null, "Sluttiden m?ste vara senare ?n starttiden");
                    }
            
        }
    }//GEN-LAST:event_btnCompleteBookingActionPerformed


    private void btnAddNewCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCatActionPerformed

        String getCategory = txtAddNewCat.getText();

        try {
            String categoryID = scrumXPdb.getAutoIncrement("kategori", "kategori_ID");

            scrumXPdb.insert("insert into kategori(Kategori_ID,Kategori_namn,Typ) values ('" + categoryID + "', '" + getCategory + "',2)");
            txtAddNewCat.setText("");
            cmbCategories.addItem(getCategory);
            cmbKategori.addItem(getCategory);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "N?gonting gick fel");
            System.out.println("Internt felmeddelande" + e.getMessage());
        }
    }//GEN-LAST:event_btnAddNewCatActionPerformed

    private void cmbCategoriesComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cmbCategoriesComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriesComponentRemoved

    private void cmbCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriesActionPerformed
        String getSelectedCategory = cmbCategories.getSelectedItem().toString();
        ArrayList<String> queries;
        try {
            queries = scrumXPdb.fetchColumn("SELECT titel FROM blogginlagg JOIN kategori ON blogginlagg.Kategori_ID_som_anvands=kategori.kategori_ID WHERE Kategori_namn ='" + getSelectedCategory + "' AND blogginlagg.synlig = 1");
            cmbMessage.removeAllItems();

            for (String category : queries) {

                cmbMessage.addItem(category);

            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga meddelanden i den h?r kategorin");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "N?gonting gick fel");
        }
    }//GEN-LAST:event_cmbCategoriesActionPerformed

    private void cmbMessageKursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMessageKursActionPerformed
        txtAreaMeddelandenKurs.setText("");
        lblFile.setText("");
        String selectedMessage = cmbMessageKurs.getSelectedItem().toString();
        String queryOne;
        String firstname;
        String lastname;
        String Anstalld_ID;
        String fileToShow;
      
        try{
            queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '"+selectedMessage+ "'");
            Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '"+selectedMessage+ "'");
            firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            fileToShow = scrumXPdb.fetchSingle("select bild from blogginlagg where titel = '"+selectedMessage+"'");
            txtAreaMeddelandenKurs.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaMeddelandenKurs.append("Titel: " + selectedMessage + "\n");
            txtAreaMeddelandenKurs.append(queryOne);
            txtAreaMeddelandenKurs.setLineWrap(true);
            txtAreaMeddelandenKurs.setWrapStyleWord(true);
            txtfldFile.setText(fileToShow);

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }//GEN-LAST:event_cmbMessageKursActionPerformed

    private void btnWriteMessageKursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteMessageKursActionPerformed
        String title = txtTitelKurs.getText();
        String message = txtAreaSkrivMeddelandeKurs.getText();
        String category = cmbKategoriKurs.getSelectedItem().toString();
        String categoryID;
        String copiedPath;
        String sameCategory = cmbCategoriesKurs.getSelectedItem().toString();
        
        if(Validering.textFieldHasValue(txtTitelKurs) && Validering.textAreaHasValue(txtAreaSkrivMeddelandeKurs)&& Validering.textFieldLessThen30(txtTitelKurs)){
        try{
            String messageID = scrumXPdb.getAutoIncrement("blogginlagg", "inlagg_ID");
            categoryID = scrumXPdb.fetchSingle("SELECT kategori_id from kategori WHERE kategori_namn ='"+category+"'");
            String userID = scrumXPdb.fetchSingle("SELECT anstalld_ID FROM anstalld WHERE Anvandarnamn = '"+userName+"'");
            int CategoryIntID = Integer.parseInt(categoryID);
            if(txtFile.getText().equals("Ingen fil vald")){
                copiedPath = " ";
            }
            else{
                copiedPath = copied.toString();
                copiedPath = copiedPath.replaceAll("\\\\", "\\\\\\\\");
                Files.copy(path, copied, StandardCopyOption.REPLACE_EXISTING);
            }
            
            scrumXPdb.insert("insert into blogginlagg(inlagg_id,formell,titel,bild,text,ansvarig_anstalld,Kategori_ID_som_anvands,synlig) values ('"+messageID+"',0,'"+title+"','"+copiedPath+"','"+message+"','" + userID + "','"+CategoryIntID+"',1)");
            txtTitelKurs.setText("");
            txtAreaSkrivMeddelandeKurs.setText("");
            if(sameCategory.equals(category)){
                cmbMessageKurs.addItem(title);
            }
            
            
            JOptionPane.showMessageDialog(null, "Meddelande med titel " +title+ " ?r nu tillagt");
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
         catch(IOException e){       
        }
        }
    }//GEN-LAST:event_btnWriteMessageKursActionPerformed

    private void btnAddNewCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewCat1ActionPerformed

        String getCategory = txtAddNewCatKurs.getText();

        try {
            String categoryID = scrumXPdb.getAutoIncrement("kategori", "kategori_ID");
            scrumXPdb.insert("insert into kategori values ('" + categoryID + "', '" + getCategory + "',1)");
            txtAddNewCatKurs.setText("");

            cmbCategoriesKurs.addItem(getCategory);
            cmbKategoriKurs.addItem(getCategory);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "N?gonting gick fel");

            System.out.println("Internt felmeddelande" + e.getMessage());
        }
        JavaMailUtil.KursNotifikationMail(scrumXPdb);
    }//GEN-LAST:event_btnAddNewCat1ActionPerformed

    private void cmbCategoriesKursComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cmbCategoriesKursComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriesKursComponentRemoved

    private void cmbCategoriesKursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriesKursActionPerformed
        String getSelectedCategoryKurs = cmbCategoriesKurs.getSelectedItem().toString();

        ArrayList<String> queries;
        try {

            queries = scrumXPdb.fetchColumn("SELECT Titel FROM blogginlagg JOIN kategori ON blogginlagg.Kategori_ID_som_anvands=kategori.kategori_ID WHERE Kategori_namn = '" + getSelectedCategoryKurs + "' AND blogginlagg.synlig = 1");

            cmbMessageKurs.removeAllItems();

            for (String category : queries) {

                cmbMessageKurs.addItem(category);

            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga meddelanden i den h?r kategorin");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "N?gonting gick fel");
        }
    }//GEN-LAST:event_cmbCategoriesKursActionPerformed

    private void cmbMessageSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMessageSocialActionPerformed
        txtAreaMeddelandenSocial.setText("");
        String selectedMessage = cmbMessageSocial.getSelectedItem().toString();
        String queryOne;
        String firstname;
        String lastname;
        String Anstalld_ID;

        String picturePath;
        try {
            queryOne = scrumXPdb.fetchSingle("select text from blogginlagg where titel = '" + selectedMessage + "'");
            Anstalld_ID = scrumXPdb.fetchSingle("select Ansvarig_anstalld from blogginlagg where titel = '" + selectedMessage + "'");

            firstname = scrumXPdb.fetchSingle("select anstalld.fornamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            lastname = scrumXPdb.fetchSingle("select anstalld.efternamn from anstalld join blogginlagg on anstalld.anstalld_id = blogginlagg.Ansvarig_Anstalld where anstalld.Anstalld_ID =" + Anstalld_ID);
            picturePath = scrumXPdb.fetchSingle("select Bild from blogginlagg where titel = '" + selectedMessage + "'");
            txtAreaMeddelandenSocial.append("Skrivet av: " + firstname + " " + lastname + "\n");
            txtAreaMeddelandenSocial.append("Titel: " + selectedMessage + "\n");
            txtAreaMeddelandenSocial.append(queryOne);
            txtAreaMeddelandenSocial.setLineWrap(true);
            txtAreaMeddelandenSocial.setWrapStyleWord(true);
            if (!picturePath.equals(" ")) {

                lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(picturePath)));

            }

        } catch (InfException ex) {
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
            if(lblPicture.getText().equals("Ingen fil vald")){
                imagePath = " ";
                imageFetchPath = " ";
            }
            else{
                ImageIO.write(image, "jpg", new File(imagePath));
            }
            scrumXPdb.insert("insert into blogginlagg(inlagg_id,formell,titel,bild,text,ansvarig_anstalld,Kategori_ID_som_anvands,Synlig) values ('"+messageID+"',2,'"+title+"','" + imageFetchPath + "','"+message+"','" + userID + "',3,1)");
            txtTitelSocial.setText("");
            txtAreaSkrivMeddelandeSocial.setText("");
            cmbMessageSocial.addItem(title);

            JOptionPane.showMessageDialog(null, "Meddelande med titel " +title+ " ?r nu tillagt");
            lblPicture.setText("Ingen bild vald");


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Databasfel!");
                System.out.println("Internt felmeddelande" + ex.getMessage());
            }
            JavaMailUtil.InfoSocialNotifikationMail(scrumXPdb);

    }//GEN-LAST:event_btnWriteMessageSocialActionPerformed

    }

    private void btnSaveNotificationSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNotificationSettingsActionPerformed
        Notifications.checkNewCourseNotification(scrumXPdb, userName);
        Notifications.checkNewResearchNotification(scrumXPdb, userName);
        Notifications.checkNewInfoSocialNotification(scrumXPdb, userName);
        Notifications.checkNewMeetingRequestNotification(scrumXPdb, userName);
        JOptionPane.showMessageDialog(null, "Inst?llningar sparade");
    }//GEN-LAST:event_btnSaveNotificationSettingsActionPerformed

    private void btnMeetingRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeetingRequestActionPerformed
        new MeetingRequest(scrumXPdb, userName).setVisible(true);

    }//GEN-LAST:event_btnMeetingRequestActionPerformed

    private void btnAnswerMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerMeetingActionPerformed
        new AnswerMeeting(scrumXPdb, userName).setVisible(true);
    }//GEN-LAST:event_btnAnswerMeetingActionPerformed


    private void cmbxMeetingNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxMeetingNameActionPerformed

        txtAreaMeetingAnswer.setText(" ");
        txtAreaMeetingAnswer.setText("");
        ArrayList<HashMap<String, String>> allInfo;
        String meetingName = cmbxMeetingName.getSelectedItem().toString();
        try {
            String userID = scrumXPdb.fetchSingle("select Anstalld_ID from anstalld where anvandarnamn = '" + userName + "'");

            String query = "select moten_forfragning.Motes_ID_Forfragning, motes_aterskick.Tid1, motes_aterskick.Tid2, motes_aterskick.Tid3, datum1, datum2, datum3,person_som_aterskickar from motes_aterskick join moten_forfragning on moten_forfragning.Motes_ID_Forfragning = motes_aterskick.Mote_ID_som_besvaras where moten_forfragning.motesnamn = '" + meetingName + "'";
            allInfo = scrumXPdb.fetchRows(query);

            for (HashMap<String, String> info : allInfo) {

                txtAreaMeetingAnswer.append("Namn: " + scrumXPdb.fetchSingle("select fornamn from anstalld where anstalld_id =" + info.get("person_som_aterskickar")) + " " + scrumXPdb.fetchSingle("select efternamn from anstalld where anstalld_id =" + info.get("person_som_aterskickar")) + "\n");
                txtAreaMeetingAnswer.append("Tid1: " + info.get("Tid1") + "\n");
                txtAreaMeetingAnswer.append("Datum: " + info.get("datum1") + "\n");
                txtAreaMeetingAnswer.append("Tid2: " + info.get("Tid2") + "\n");
                txtAreaMeetingAnswer.append("Datum: " + info.get("datum2") + "\n");
                txtAreaMeetingAnswer.append("Tid3: " + info.get("Tid3") + "\n");
                txtAreaMeetingAnswer.append("Datum: " + info.get("datum3") + "\n");
                txtAreaMeetingAnswer.append("\n");
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_cmbxMeetingNameActionPerformed

    private void cmbxMeetingNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbxMeetingNameKeyPressed

    }//GEN-LAST:event_cmbxMeetingNameKeyPressed
    public void setCbMeeting() {
        ArrayList<String> titleName;
        try {
            String userID = scrumXPdb.fetchSingle("select Anstalld_ID from anstalld where anvandarnamn = '" + userName + "'");
            titleName = scrumXPdb.fetchColumn("select motesnamn from moten_forfragning where ansvarig_anstalld = '" + userID + "'");

            for (String titleNames : titleName) {

                cmbxMeetingName.addItem(titleNames);

            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!2");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Bara txt, doc, docx, pdf filer", "txt","doc","docx","pdf");
        chooser.setFileFilter(restrict);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String stringFile = file.getPath();
            try {
                if (JOptionPane.showConfirmDialog(null, "Du har valt fil:" + stringFile + "Vill du spara?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        txtFile.setText(stringFile);
                        path = Path.of(stringFile);
                        copied = Path.of(System.getProperty("user.dir") + "\\src\\files\\" + file.getName());
                }
                else{
                    copied = Path.of(" ");
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveUserActionPerformed
        try {
            String namesAndId = cmbxChooseUserToRemove.getSelectedItem().toString();
            String[] namesAndIdSplit = namesAndId.split(" ");
            String userId = namesAndIdSplit[2];

            if (Admin.makeUserInactive(userId, scrumXPdb)) {
                JOptionPane.showMessageDialog(null, "Anv?ndaren har inaktiverats");
                fillCbEmployee();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Anv?ndaren kanske inte ?r inaktiverad, f?rs?k igen eller kontakta support");

        }
    }//GEN-LAST:event_btnRemoveUserActionPerformed

    private void btnChangeMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeMailActionPerformed
        User.changeMail(txtfldChangeMail, userName, scrumXPdb);
        txtfldChangeMail.setText("");
        lblCurrentMail.setText("Din nuvarande email ?r: " + User.getMail(userName, scrumXPdb));
    }//GEN-LAST:event_btnChangeMailActionPerformed

    private void btnChangeMobilenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeMobilenumberActionPerformed
        User.changeMobile(txtfldChangeMobile, userName, scrumXPdb);
        txtfldChangeMobile.setText("");
        lblPresentMobile.setText("Ditt nuvarande mobilnummer ?r: " + 0 + User.getMobileNumber(userName, scrumXPdb));
    }//GEN-LAST:event_btnChangeMobilenumberActionPerformed

    private void btnSavePasswordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePasswordUserActionPerformed
        User.compareOldPassword(pswrdfldCurrent, pswrdfldNew, pswrdfldNewAgain, userName, scrumXPdb);
        pswrdfldCurrent.setText("");
        pswrdfldNew.setText("");
        pswrdfldNewAgain.setText("");
    }//GEN-LAST:event_btnSavePasswordUserActionPerformed

    private void btnChangeUserDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeUserDetailsActionPerformed
        pnlNotifications.add("Mina uppgifter", pnlDetails);
        pnlNotifications.setSelectedComponent(pnlDetails);
        lblCurrentMail.setText("Din nuvarande email ?r: " + User.getMail(userName, scrumXPdb));
        lblPresentMobile.setText("Ditt nuvarande mobilnummer ?r: " + 0 + User.getMobileNumber(userName, scrumXPdb));
    }//GEN-LAST:event_btnChangeUserDetailsActionPerformed


    private void cmbMyMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMyMeetingActionPerformed
        showMeeting();
    }//GEN-LAST:event_cmbMyMeetingActionPerformed

    private void btnReminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReminderActionPerformed
        if (Validering.timePickerGotValue(timePickerChooseTime) && Validering.dateChooserGotValue(jDateChooseDate)) {

            SimpleDateFormat dtfMonth = new SimpleDateFormat("MM");
            SimpleDateFormat dtfYear = new SimpleDateFormat("YYYY");
            SimpleDateFormat dtfDay = new SimpleDateFormat("dd");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            String choosenDate = sdf.format(jDateChooseDate.getDate());
            String choosenTime = timePickerChooseTime.getTimeStringOrEmptyString();
            
            if (Validering.isDateLaterAndTimeIsAfter(choosenDate, choosenTime)) {
                String timmar = timePickerChooseTime.getTime().toString().substring(0, 2);
                int timmen = Integer.parseInt(timmar);

                String minuten = timePickerChooseTime.getTime().toString().substring(3, 5);
                int minut = Integer.parseInt(minuten);

                String month = dtfMonth.format(jDateChooseDate.getDate());
                String year = dtfYear.format(jDateChooseDate.getDate());
                String day = dtfDay.format(jDateChooseDate.getDate());
                int month1 = Integer.parseInt(month);
                int year1 = Integer.parseInt(year);
                int day1 = Integer.parseInt(day);

                int month2 = month1 - 1;
                Reminder.TimerSendMail(month2, year1, day1, timmen, minut, scrumXPdb, userName);
                JOptionPane.showMessageDialog(null, "Din p?minnelse ?r nu inlagd");
            }
        }
    }//GEN-LAST:event_btnReminderActionPerformed

    public void setCbMyMeeting() {
        cmbMyMeeting.removeAllItems();

        ArrayList<String> titleName;
        try {
            String userID = scrumXPdb.fetchSingle("select Anstalld_ID from anstalld where anvandarnamn = '" + userName + "'");
            titleName = scrumXPdb.fetchColumn("select motesnamn from moten where ansvarig_anstalld = '" + userID + "'");

            for (String titleNames : titleName) {

                cmbMyMeeting.addItem(titleNames);

            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!2");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
    }

    public void showMeeting() {

        textAreaChooseInfo.setText(" ");
        String moteNamn = cmbMyMeeting.getSelectedItem().toString();
        ArrayList<HashMap<String, String>> allMeetings;

        try {

            String fraga = "SELECT MOTESNAMN, BESKRIVNING, PLATS, STARTTID, SLUTTID FROM MOTEN WHERE MotesNamn = '" + moteNamn + "'"; //AND MOTEN.MOTES_ID IN (SELECT MOTE_SOM_DELTAS FROM MOTES_DELTAGARE WHERE MOTES_DELTAGARE_ID = '" + choosenId + "');";

            allMeetings = scrumXPdb.fetchRows(fraga);

            for (HashMap<String, String> meetings : allMeetings) {
                textAreaChooseInfo.append("Namn: " + meetings.get("MOTESNAMN") + "\n");
                textAreaChooseInfo.append("Plats: " + meetings.get("PLATS") + "\n");
                textAreaChooseInfo.append("Beskrivning: " + meetings.get("BESKRIVNING") + "\n");
                textAreaChooseInfo.append("Klockan: " + meetings.get("STARTTID") + "-" + meetings.get("SLUTTID") + "\n");
                textAreaChooseInfo.append("\n");

            }

        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) { 
            JOptionPane.showMessageDialog(null, "Fel");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());

        }

    }

    private void btnChoosePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePictureActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, GIF, and PNG Images", "jpg", "gif", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String stringFile = file.toString();
            try {
                if (JOptionPane.showConfirmDialog(null, "Du har valt fil:" + stringFile + "Vill du spara?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    image = ImageIO.read(file);
                    imagePath = System.getProperty("user.dir") + "\\src\\images\\" + file.getName();
                    imagePath = imagePath.replaceAll("\\\\", "\\\\\\\\");
                    imageFetchPath = "\\\\images\\\\" + file.getName();
                    lblPicture.setText(stringFile);
                } else {
                    imagePath = " ";
                    imageFetchPath = " ";
                }

            } catch (IOException ex) {

            }
    }//GEN-LAST:event_btnChoosePictureActionPerformed
    }
    private void btnShowFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowFileActionPerformed
                String fileToShow;
        String selectedMessage = cmbMessageKurs.getSelectedItem().toString();
        try {

            fileToShow = scrumXPdb.fetchSingle("select bild from blogginlagg where titel = '"+selectedMessage+"'");
            File f = new File(fileToShow);
            java.awt.Desktop.getDesktop().open(f);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (Exception e){
        
        }
    }//GEN-LAST:event_btnShowFileActionPerformed

    private void btnFileForskningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileForskningActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Bara txt, doc, docx, pdf filer", "txt","doc","docx","pdf");
        chooser.setFileFilter(restrict);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String stringFile = file.getPath();
            try {
                if (JOptionPane.showConfirmDialog(null, "Du har valt fil:" + stringFile + "Vill du spara?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        txtFileForskning.setText(stringFile);
                        path = Path.of(stringFile);
                        copied = Path.of(System.getProperty("user.dir") + "\\src\\files\\" + file.getName());
                }
                else{
                   copied = Path.of(" ");
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnFileForskningActionPerformed

    private void btnShowFileForskningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowFileForskningActionPerformed
        String fileToShow;
        String selectedMessage = cmbMessage.getSelectedItem().toString();
        try {

            fileToShow = scrumXPdb.fetchSingle("select bild from blogginlagg where titel = '"+selectedMessage+"'");
            File f = new File(fileToShow);
            java.awt.Desktop.getDesktop().open(f);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (Exception e){
        
        }
    }//GEN-LAST:event_btnShowFileForskningActionPerformed

    private void btnCheckMyMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckMyMessagesActionPerformed
        new ChangeVisibility (scrumXPdb, userName).setVisible(true);
    }//GEN-LAST:event_btnCheckMyMessagesActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewCat;
    private javax.swing.JButton btnAddNewCat1;
    private javax.swing.JButton btnAddParticipant;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnAnswerMeeting;
    private javax.swing.JButton btnChangeMail;
    private javax.swing.JButton btnChangeMobilenumber;
    private javax.swing.JButton btnChangeUserDetails;
    private javax.swing.JButton btnCheckMyMessages;
    private javax.swing.JButton btnChoosePicture;
    private javax.swing.JButton btnCompleteBooking;
    private javax.swing.JButton btnEmptyList;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnFileForskning;
    private javax.swing.JButton btnMeetingRequest;
    private javax.swing.JButton btnReminder;
    private javax.swing.JButton btnRemoveUser;
    private javax.swing.JButton btnSaveNotificationSettings;
    private javax.swing.JButton btnSavePassword1;
    private javax.swing.JButton btnSavePasswordUser;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnScheduleAll;
    private javax.swing.JButton btnShowFile;
    private javax.swing.JButton btnShowFileForskning;
    private javax.swing.JButton btnWriteMessage;
    private javax.swing.JButton btnWriteMessageKurs;
    private javax.swing.JButton btnWriteMessageSocial;
    private com.toedter.calendar.JCalendar calendar1;
    private javax.swing.JComboBox<String> cbChoosenParticipant;
    private javax.swing.JCheckBox chbxAdmin;
    public static javax.swing.JCheckBox chbxNewMeetingRequest;
    public static javax.swing.JCheckBox chbxNewPostInCourse;
    public static javax.swing.JCheckBox chbxNewPostInInfoSocial;
    public static javax.swing.JCheckBox chbxNewPostInResearch;
    public static javax.swing.JComboBox<String> cmbCategories;
    public static javax.swing.JComboBox<String> cmbCategoriesKurs;
    public static javax.swing.JComboBox<String> cmbKategori;
    public static javax.swing.JComboBox<String> cmbKategoriKurs;
    public static javax.swing.JComboBox<String> cmbMessage;
    public static javax.swing.JComboBox<String> cmbMessageKurs;
    public static javax.swing.JComboBox<String> cmbMessageSocial;
    private javax.swing.JComboBox<String> cmbMyMeeting;
    public static javax.swing.JComboBox<String> cmbxChooseUserToRemove;
    public static javax.swing.JComboBox<String> cmbxMeetingName;
    public static javax.swing.JComboBox<String> cmbxUserNames;
    private javax.swing.JComboBox<String> cmbxUsers;
    public static com.toedter.calendar.JDateChooser datepickerDate1;
    private com.toedter.calendar.JDateChooser jDateChooseDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddNewCat;
    private javax.swing.JLabel lblAddNewCat1;
    private javax.swing.JLabel lblAddedPersons;
    private javax.swing.JLabel lblChangeMail;
    private javax.swing.JLabel lblChangeMobile;
    private javax.swing.JLabel lblChooseDate;
    private javax.swing.JLabel lblChooseEmployee;
    private javax.swing.JLabel lblChooseNotifications;
    private javax.swing.JLabel lblChooseParticipants;
    private javax.swing.JLabel lblChooseTime;
    private javax.swing.JLabel lblChooseUser;
    private javax.swing.JLabel lblChooseUserToRemove;
    private javax.swing.JLabel lblCurrentMail;
    private javax.swing.JLabel lblCurrentPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFile;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblHeadlineAddUser;
    private javax.swing.JLabel lblHeadlineChangePassword;
    private javax.swing.JLabel lblHeadlineDetails;
    private javax.swing.JLabel lblHeadlinePassword;
    private javax.swing.JLabel lblHeadlineRemoveUser;
    private javax.swing.JLabel lblImage;
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
    private javax.swing.JLabel lblMeetingRequestAnswers;
    private javax.swing.JLabel lblMobileNumber;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNewPasswordAgain;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblPresentMobile;
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
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTabbedPane pnlNotifications;
    private javax.swing.JPanel pnlResearch;
    private javax.swing.JPanel pnlResearch1;
    private javax.swing.JPanel pnlResearch2;
    private javax.swing.JPanel pnlSocial;
    private javax.swing.JPanel pnlUser;
    private javax.swing.JPasswordField pswrdfldCurrent;
    private javax.swing.JPasswordField pswrdfldNew;
    private javax.swing.JPasswordField pswrdfldNewAgain;
    public static javax.swing.JTextArea textAreaChooseInfo;
    private com.github.lgooddatepicker.components.TimePicker timePickerChooseTime;
    public static com.github.lgooddatepicker.components.TimePicker tpFrom;
    public static com.github.lgooddatepicker.components.TimePicker tpTo;
    private javax.swing.JTextField txtAddNewCat;
    private javax.swing.JTextField txtAddNewCatKurs;
    private javax.swing.JTextArea txtAreaMeddelanden;
    private javax.swing.JTextArea txtAreaMeddelandenKurs;
    private javax.swing.JTextArea txtAreaMeddelandenSocial;
    private javax.swing.JTextArea txtAreaMeetingAnswer;
    public static javax.swing.JTextArea txtAreaSchedule;
    private javax.swing.JTextArea txtAreaSkrivMeddelande;
    private javax.swing.JTextArea txtAreaSkrivMeddelandeKurs;
    private javax.swing.JTextArea txtAreaSkrivMeddelandeSocial;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextField txtFileForskning;
    public static javax.swing.JTextField txtLocation;
    public static javax.swing.JTextArea txtMeetingDescription;
    public static javax.swing.JTextField txtMeetingName;
    private javax.swing.JTextField txtTitel;
    private javax.swing.JTextField txtTitelKurs;
    private javax.swing.JTextField txtTitelSocial;
    private javax.swing.JTextField txtfldChangeMail;
    private javax.swing.JTextField txtfldChangeMobile;
    private javax.swing.JTextField txtfldEmail;
    private javax.swing.JTextField txtfldFile;
    private javax.swing.JTextField txtfldFileForskning;
    private javax.swing.JTextField txtfldFirstName;
    private javax.swing.JTextField txtfldLastName;
    private javax.swing.JTextField txtfldPassword;
    private javax.swing.JTextField txtfldPasswordChange;
    private javax.swing.JTextField txtfldPasswordChangeAgain;
    private javax.swing.JTextField txtfldTelefon;
    private javax.swing.JTextField txtfldUserName;
    // End of variables declaration//GEN-END:variables
}
