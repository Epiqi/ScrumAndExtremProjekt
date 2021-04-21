
import java.util.ArrayList;
import java.util.HashMap;
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
 * @author benga
 */
public class Notifications {
 
    public static void fillCheckBoxesNotifications (InfDB scrumXPdb, String userName) {
        
       ArrayList<HashMap<String, String>> allCheckBoxes;
       
       try {
           String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
           String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
            
           String fraga = "SELECT KURSNOTIFIKATION, FORSKNINGNOTIFIKATION, INFOSOCIALNOTIFIKATION, MOTE_FORFRAGNINGNOTIFIKATION FROM NOTIFIKATIONER WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
           allCheckBoxes = scrumXPdb.fetchRows(fraga);
           
           for (HashMap<String, String> checkBox : allCheckBoxes) {
               String kursNot = checkBox.get("KURSNOTIFIKATION");
               String forskNot = checkBox.get("FORSKNINGNOTIFIKATION");
               String infSocNot = checkBox.get("INFOSOCIALNOTIFIKATION");
               String motForFragNot = checkBox.get("MOTE_FORFRAGNINGNOTIFIKATION");
             
             
               if (kursNot.equals("1")) {
                    HomePage.chbxNewPostInCourse.setSelected(true);
                }
               
               if (forskNot.equals("1")) {
                    HomePage.chbxNewPostInResearch.setSelected(true);
                }
               
               if (infSocNot.equals("1")) {
                    HomePage.chbxNewPostInInfoSocial.setSelected(true);
                }
               
               if (motForFragNot.equals("1")) {
                    HomePage.chbxNewMeetingRequest.setSelected(true);
                }
               
               }}
        
        catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }}
       
    
    
    public static void checkNewCourseNotification (InfDB scrumXPdb, String userName) {
        
        
            try{
            if (HomePage.chbxNewPostInCourse.isSelected()) {
            String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
            String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
        
            String fraga = "UPDATE NOTIFIKATIONER SET KURSNOTIFIKATION = 1 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
            scrumXPdb.fetchSingle(fraga);   
        }
            else {
               String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
               String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
               String fraga1 = "UPDATE NOTIFIKATIONER SET KURSNOTIFIKATION = 0 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
               scrumXPdb.fetchSingle(fraga1);  
            }
                
            }
      
            catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
      
    }
    
    public static void checkNewResearchNotification (InfDB scrumXPdb, String userName) {
       
             try{
            if (HomePage.chbxNewPostInResearch.isSelected()) {
            String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
            String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
        
            String fraga = "UPDATE NOTIFIKATIONER SET FORSKNINGNOTIFIKATION = 1 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
            scrumXPdb.fetchSingle(fraga);
       
        }
            else {
               String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
               String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
               String fraga1 = "UPDATE NOTIFIKATIONER SET FORSKNINGNOTIFIKATION = 0 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
               scrumXPdb.fetchSingle(fraga1);  
            } 
            
             }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
        }
    
    
     public static void checkNewInfoSocialNotification (InfDB scrumXPdb, String userName) {
        
        
             try{
            if (HomePage.chbxNewPostInInfoSocial.isSelected()) {
            String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
            String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
        
            String fraga = "UPDATE NOTIFIKATIONER SET INFOSOCIALNOTIFIKATION = 1 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
            scrumXPdb.fetchSingle(fraga);
            }
            
            else {
               String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
               String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
               String fraga1 = "UPDATE NOTIFIKATIONER SET INFOSOCIALNOTIFIKATION = 0 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
               scrumXPdb.fetchSingle(fraga1);  
            } 
            
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
        }
    
     
      public static void checkNewMeetingRequestNotification (InfDB scrumXPdb, String userName) {
        
        
             try{
            if (HomePage.chbxNewMeetingRequest.isSelected()) {
            String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
            String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
        
            String fraga = "UPDATE NOTIFIKATIONER SET MOTE_FORFRAGNINGNOTIFIKATION = 1 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
            scrumXPdb.fetchSingle(fraga);
            }
           
            else {
               String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
               String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
               String fraga1 = "UPDATE NOTIFIKATIONER SET MOTE_FORFRAGNINGNOTIFIKATION = 0 WHERE ANSTALLDSNOTIFIKATIONER = '" + anstalldId + "'";
               scrumXPdb.fetchSingle(fraga1);  
            } 
            
        }catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ex.getMessage());
        }
        }
    
      
   
    
}
