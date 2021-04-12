
import javax.swing.JOptionPane;
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
    //Behövs dessa?
    private InfDB scrumXPdb;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String mobilNumber;
    
   
    
    /*private static void addUser(){
        // skicka till validering eller innan, skicka om det lyckas?
        try {
            //Behöver räkna upp användarID i tabellen?
            String userData = "Insert into USER Values('" + name + "','" + userName + "','" + password + "','" + email + "','" + mobilNumber + "')";

            //scrumXPdb.insert(userData);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lämpligt felmeddelande");
        }
    }*/
        
    public static boolean changePassword(String firstName, String lastName, String password1, String password2){
        
        boolean changed = true;
        try{
            if(Validering.isPasswordValid(password1) && Validering.isPasswordValid(password2) && Validering.isTextSame(password1, password2)){
                String updatePassword = "Update Anstalld Set Losenord ='" + password1 + "' Where Fornamn ='" + firstName + "' and Efternamn ='" + lastName + "'";
                InfDB scrumXPdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
                scrumXPdb.update(updatePassword);
            
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Lösenordet har inte uppdaterats, försök igen eller kontakta support");
            changed = false;
            return changed;
        }
        return changed;
    }
}
