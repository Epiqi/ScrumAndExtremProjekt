
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
public class Admin {
    
    
    
    public static boolean addUser(String firstName, String lastName, String email, String userName, String password, String admin, String telephone, InfDB scrumXPdb){
        // skicka till validering eller innan, skicka om det lyckas? username m�ste vara unikt
        try {
            if(Validering.lessThen20andMoreThen2Characters(firstName) && Validering.onlyLetters(firstName) && Validering.lessThen20andMoreThen2Characters(lastName) && Validering.onlyLetters(lastName)
                && Validering.lessThen20andMoreThen2Characters(email)&& Validering.isEmail(email) && Validering.lessThen20andMoreThen2Characters(userName)&& Validering.isPasswordValid(password)
                    && Validering.isMobileNumber(telephone)){
            //Beh�ver r�kna upp anv�ndarID i tabellen?
            int intTelephone = Integer.parseInt(telephone);
            String userID = scrumXPdb.getAutoIncrement("anstalld", "anstalld_id");
            ArrayList<String> userNames = scrumXPdb.fetchColumn("SELECT anvandarnamn FROM anstalld");
            
            for(String names : userNames){
                if(names.equals(userName)){
                    JOptionPane.showMessageDialog(null, "Det finns redan en anv�ndare med detta anv�ndarnamn");
                }
                else{
                    String userData = "Insert into anstalld(Anstalld_ID, Fornamn, Efternamn, Email, Anvandarnamn, Losenord, Administrator, Telefon) "
                            + "Values('" + userID + "','" + firstName + "','" + lastName + "','" + email + "','" + userName + "','" + password + "','" + admin + "','" + intTelephone + "')";
                    scrumXPdb.insert(userData);
                    return true;
                    }       
                }
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ett fel har uppst�tt, v�nligen f�rs�k igen");
        }
        catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Anv�ndare har ej sparats, v�nligen f�rs�k igen eller kontakta support");
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
            JOptionPane.showMessageDialog(null, "L�senordet har inte uppdaterats.");
            return false;
        }
        return false;
    }
}
