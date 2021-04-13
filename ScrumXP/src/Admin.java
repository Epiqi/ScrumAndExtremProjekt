
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
    
    
    
    public static boolean addUser(String firstName, String lastName, String email, String userName, String password, String admin, JTextField telefon, InfDB scrumXPdb){
        // skicka till validering eller innan, skicka om det lyckas? username måste vara unikt
        try {
            if(Validering.lessThen20andMoreThen2Characters(firstName) && Validering.isStrang(firstName) && Validering.lessThen20andMoreThen2Characters(lastName) && Validering.isStrang(lastName)
                && Validering.lessThen20andMoreThen2Characters(email) && Validering.lessThen20andMoreThen2Characters(userName)&& Validering.lessThen20andMoreThen2Characters(password)){
            //Behöver räkna upp användarID i tabellen?
            
            String userData = "Insert into USER Values('" + firstName + "','" + lastName + "','" + email + "','" + userName + "','" + password + "','" + admin + "','" + intTelefon + "')";
            scrumXPdb.insert(userData);
            return true;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Användare har ej sparats");
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
}
