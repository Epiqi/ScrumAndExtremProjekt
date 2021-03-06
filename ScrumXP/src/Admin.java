
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 *
 * @author Carolin
 */
public class Admin {
    
    
    
    public static boolean addUser(String firstName, String lastName, String email, String userName, String password, String admin, String telephone, InfDB scrumXPdb){
        
        try {
            if(Validering.lessThen20andMoreThen2Characters(firstName) && Validering.onlyLetters(firstName) && Validering.lessThen20andMoreThen2Characters(lastName) && Validering.onlyLetters(lastName)
                && Validering.lessThen20andMoreThen2Characters(email)&& Validering.isEmail(email) && Validering.lessThen20andMoreThen2Characters(userName)&& Validering.isPasswordValid(password)
                    && Validering.isMobileNumber(telephone)){
            
            int intTelephone = Integer.parseInt(telephone);
            String userID = scrumXPdb.getAutoIncrement("anstalld", "anstalld_id");
            ArrayList<String> userNames = scrumXPdb.fetchColumn("SELECT anvandarnamn FROM anstalld");
            
            for(String names : userNames){
                if(names.equals(userName)){
                    JOptionPane.showMessageDialog(null, "Det finns redan en användare med detta användarnamn");
                }
                else{
                    String userData = "Insert into anstalld(Anstalld_ID, Fornamn, Efternamn, Email, Anvandarnamn, Losenord, Administrator, Telefon, Aktiv) "
                            + "Values('" + userID + "','" + firstName + "','" + lastName + "','" + email + "','" + userName + "','" + password + "','" + admin + "','" + intTelephone + "','j')";
                    scrumXPdb.insert(userData);
                    HomePage.cmbxUserNames.addItem(firstName + " " + lastName + " " + userID);
                    HomePage.cmbxChooseUserToRemove.addItem(firstName + " " + lastName + " " + userID);
                    return true;
                    }       
                }

            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ett fel har uppstått, vänligen försök igen");
        }
        catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Användare har ej sparats, vänligen försök igen eller kontakta support");
            return false;
        }
        return false;
    }
        
    public static boolean changePassword(String firstName, String lastName, String password1, String password2, InfDB scrumXPdb){
        
        
        try{
            
            if(Validering.isPasswordValid(password1) && Validering.isPasswordValid(password2) && Validering.isTextSame(password1, password2)){
                String updatePassword = "Update Anstalld Set Losenord ='" + password1 + "' Where Fornamn ='" + firstName + "' and Efternamn ='" + lastName + "'";
                scrumXPdb.update(updatePassword);
             return true;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Lösenordet har inte uppdaterats.");
            return false;
        }
        return false;
    }

    public static boolean makeUserInactive(String userId, InfDB scrumXPdb) {
        try {

            String updateNoLongerEmployed = "Update anstalld Set Aktiv = 'n' Where Anstalld_ID = " + userId;

            scrumXPdb.update(updateNoLongerEmployed);
            return true;

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Användaren har inte tagits bort.");
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
}
