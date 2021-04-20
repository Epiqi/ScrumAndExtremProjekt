
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
            
            String fraga = "SELECT MOTESNAMN, BESKRIVNING, PLATS, STARTTID, SLUTTID FROM MOTEN WHERE STARTDATUM = '" + choosenDate + "' AND MOTEN.MOTES_ID IN (SELECT MOTE_SOM_DELTAS FROM MOTES_DELTAGARE WHERE MOTES_DELTAGARE_ID = '" + choosenId + "');";            
            
            allMeetings = scrumXPdb.fetchRows(fraga);
            
            for (HashMap<String, String> meetings : allMeetings) {
                
                HomePage.txtAreaSchedule.append("Namn: " + meetings.get("MOTESNAMN") + "\n");
                HomePage.txtAreaSchedule.append("Plats: " + meetings.get("PLATS") + "\n");
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
    
    public static void showMeetingForAll(String date, InfDB scrumXPdb) {
        
        HomePage.txtAreaSchedule.setText("");
        ArrayList<HashMap<String, String>> allMeetingsForAll;
        
        try {
            
            String fraga = "SELECT ANSTALLD.FORNAMN, ANSTALLD.EFTERNAMN, MOTEN.MOTESNAMN, MOTEN.BESKRIVNING, MOTEN.STARTTID, MOTEN.STARTDATUM, MOTEN.SLUTTID, MOTEN.PLATS FROM ANSTALLD INNER JOIN MOTES_DELTAGARE ON MOTES_DELTAGARE.MOTES_DELTAGARE_ID = ANSTALLD.ANSTALLD_ID INNER JOIN MOTEN ON MOTES_DELTAGARE.MOTE_SOM_DELTAS = MOTEN.MOTES_ID WHERE MOTEN.STARTDATUM = '" + date + "' ORDER BY MOTEN.STARTTID;";             
            
            allMeetingsForAll = scrumXPdb.fetchRows(fraga);
            
            for (HashMap<String, String> meetingsAll : allMeetingsForAll) {
                HomePage.txtAreaSchedule.append("Medarbetare: " + meetingsAll.get("FORNAMN") + "-" + meetingsAll.get("EFTERNAMN")+ "\n");
                HomePage.txtAreaSchedule.append("Mötesnamn: " + meetingsAll.get("MOTESNAMN") + "\n");
                HomePage.txtAreaSchedule.append("Beskrivning: " + meetingsAll.get("BESKRIVNING") + "\n");
                HomePage.txtAreaSchedule.append("Plats: " + meetingsAll.get("PLATS") + "\n");
                HomePage.txtAreaSchedule.append("Klockan: " + meetingsAll.get("STARTTID") + "-" + meetingsAll.get("SLUTTID")+ "\n");
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
