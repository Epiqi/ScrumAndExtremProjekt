
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carolin
 */
public class User {
    
    
    public static String getMail(String userName, InfDB scrumXPdb){
        
        String mail = "";
        try{
            
            mail = scrumXPdb.fetchSingle("Select Email From Anstalld Where Anvandarnamn = '" + userName + "'");
            return mail;
        }
        catch(InfException e){
            return mail = "Din mail kan inte hittas";
        }  
    }
    
    public static String getMobileNumber(String userName, InfDB scrumXPdb){
        
        String mobile = "";
        try{
            
            mobile = scrumXPdb.fetchSingle("Select Telefon From Anstalld Where Anvandarnamn = '" + userName + "'");
            return mobile;
        }
        catch(InfException e){
            return mobile = "Ditt mobilnr kan inte hittas";
        }  
    }
    
    private static String getPassword(String userName, InfDB scrumXPdb){
        
        try{
            
            String password = scrumXPdb.fetchSingle("Select Losenord From Anstalld Where Anvandarnamn = '" + userName + "'");
            return password;
        }
        catch(InfException e){
            return "";
        }  
    }
    
    public static void compareOldPassword(JPasswordField currentPassword, JPasswordField newPassword, JPasswordField newPasswordAgain, String userName, InfDB scrumXPdb) {

        if (Validering.passwordFieldHasValue(currentPassword)) {
            char[] currentPassw = currentPassword.getPassword(); 
            String stringPassword = new String(currentPassw);

            if (stringPassword.equals(getPassword(userName, scrumXPdb))) {
                compareTheNewPasswords(newPassword, newPasswordAgain, userName, scrumXPdb);

            } else {
               JOptionPane.showMessageDialog(null, "Lösenordet du angett stämmer ej med ditt lösenord");
                currentPassword.setText("");
                currentPassword.requestFocus();
            }
        }
    }
    
    private static void compareTheNewPasswords(JPasswordField newPassword, JPasswordField newPasswordAgain, String userName, InfDB scrumXPdb) {

        if (Validering.passwordFieldHasValue(newPassword) && Validering.passwordFieldHasValue(newPasswordAgain)) {

            char[] NewPassw = newPassword.getPassword(); //Passwordfields returnerar en array of char och omvandals till String för att jämföras.
            String stringNewPassw = new String(NewPassw);

            char[] newPasswAgain = newPasswordAgain.getPassword();
            String stringnewPasswAgain = new String(newPasswAgain);

            if (Validering.isPasswordValid(stringNewPassw) && stringNewPassw.equals(stringnewPasswAgain)) {

                changePassword(stringNewPassw, userName, scrumXPdb);

            } else {

                JOptionPane.showMessageDialog(null, "De nytt angivna lösenorden stämmer inte överens");

            }
        }
    }
    
    private static void changePassword(String stringNewPassw, String userName, InfDB scrumXPdb) {

        try {
            String passwordQuery = "Update Anstalld Set Losenord = '" + stringNewPassw + "' Where Anvandarnamn = '" + userName + "'";
            scrumXPdb.update(passwordQuery);
                    
            String newPasswordCorrect = scrumXPdb.fetchSingle("Select LOSENORD From Anstalld Where Anvandarnamn = '" + userName + "'");
            
            if (newPasswordCorrect.equals(stringNewPassw)) {
                JOptionPane.showMessageDialog(null, "Ditt lösenord har uppdaterats!");
            } else {
                JOptionPane.showMessageDialog(null, "Ditt lösenord har inte uppdaterats!");
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ditt lösenord kanske inte har uppdaterats, testa igen eller kontakta support");
        }
    }
    
    public static void changeMail(JTextField mail, String userName, InfDB scrumXPdb) {
        String stringMail = "";
        try {
            if (Validering.textFieldHasValue(mail)) {
                stringMail = mail.getText();
                if (Validering.isEmail(stringMail)) {
                    String emailQuery = "Update Anstalld Set Email = '" + stringMail + "' Where Anvandarnamn = '" + userName + "'";
                    scrumXPdb.update(emailQuery);

                    String newEmailCorrect = scrumXPdb.fetchSingle("Select Email From Anstalld Where Anvandarnamn = '" + userName + "'");

                    if (newEmailCorrect.equals(stringMail)) {
                        JOptionPane.showMessageDialog(null, "Din email har uppdaterats!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Din email har inte uppdaterats försök igen!");
                    }
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Din email kanske inte har uppdaterats, testa igen eller kontakta support");
        }
    }
    
    public static void changeMobile(JTextField mobilenumber, String userName, InfDB scrumXPdb) {
        String stringMobilenumber = "";
        try {
            if (Validering.textFieldHasValue(mobilenumber)) {
                stringMobilenumber =mobilenumber.getText();
                if (Validering.isMobileNumber(stringMobilenumber)) {
                    
                    String mobileQuery = "Update Anstalld Set Telefon = '" + stringMobilenumber + "' Where Anvandarnamn = '" + userName + "'";
                    scrumXPdb.update(mobileQuery);

                    String newMobileCorrect = scrumXPdb.fetchSingle("Select Telefon From Anstalld Where Anvandarnamn = '" + userName + "'");

                    if (stringMobilenumber.equals(0 + newMobileCorrect)) {
                        JOptionPane.showMessageDialog(null, "Ditt mobilnummer har uppdaterats!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ditt mobilnummer har inte uppdaterats försök igen!");
                    }
                }
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Ditt mobilnummer kanske inte har uppdaterats, testa igen eller kontakta support");
        }
    }
}
