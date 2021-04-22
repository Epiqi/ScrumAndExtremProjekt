
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
public class BookMeeting {
    
    public static void confirmBooking(String userName, String location, String name, String description, String date, int timeA, int timeB, InfDB scrumXPdb) {
        
        try {
            
        String fetchAnstalld_id = "SELECT ANSTALLD_ID FROM ANSTALLD WHERE ANVANDARNAMN = '" + userName + "'";
        String anstalldId = scrumXPdb.fetchSingle(fetchAnstalld_id);
        int ansId = Integer.parseInt(anstalldId);
        
        String newMotesId = scrumXPdb.getAutoIncrement("MOTEN", "MOTES_ID");
        String fragan = "INSERT INTO MOTEN VALUES (" + newMotesId + ",'" + name + "','" + description + "',"
                        + "'" + date + "','" + timeA + "'," + timeB + ",'" + ansId + "','" + location + "')";
                scrumXPdb.insert(fragan);

          for(int i = 0; i< HomePage.lstAddedParticipants.getModel().getSize();i++){

              String deltagarId = HomePage.lstAddedParticipants.getModel().getElementAt(i).replaceAll("\\D+","");
              int deltId = Integer.parseInt(deltagarId);
              String fragaMotesdeltagare = "INSERT INTO MOTES_DELTAGARE VALUES(" + deltId + "," + newMotesId +")";
            scrumXPdb.insert(fragaMotesdeltagare);
            
          } }
         
          catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) { //Lägger även till NullPointerException
            JOptionPane.showMessageDialog(null, "Fel");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());   
        } 
        
         JOptionPane.showMessageDialog(null, "Möte bokat");
    }
    
}
