
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;


public class Calendar {
    
    
    public static void showMeeting(String choosenId, String choosenDate, InfDB scrumXPdb) {
        
          HomePage.txtAreaSchedule.setText("");
        
        ArrayList<HashMap<String, String>> allMeetings;
        
        try {
            
            String fraga = "SELECT MOTESNAMN, BESKRIVNING, STARTTID, SLUTTID FROM MOTEN WHERE STARTDATUM = '" + choosenDate + "' AND MOTEN.MOTES_ID IN (SELECT MOTE_SOM_DELTAS FROM MOTES_DELTAGARE WHERE MOTES_DELTAGARE_ID = '" + choosenId + "');";            
            
            allMeetings = scrumXPdb.fetchRows(fraga);
            
            for (HashMap<String, String> meetings : allMeetings) {
                
                HomePage.txtAreaSchedule.append("Namn: " + meetings.get("MOTESNAMN") + "\n");
                HomePage.txtAreaSchedule.append("Beskrivning: " + meetings.get("BESKRIVNING") + "\n");
                HomePage.txtAreaSchedule.append("Klockan: " + meetings.get("STARTTID") + "-" + meetings.get("SLUTTID")+ "\n");
                HomePage.txtAreaSchedule.append("\n");
                
            }
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        } catch (Exception ettUndantag) { //Lägger även till NullPointerException
            JOptionPane.showMessageDialog(null, "Fel");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
            
        } 
        
}
    
    
    
}
