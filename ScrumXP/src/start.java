import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Carolin
 */
public class start {

    private static InfDB scrumXPdb;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            scrumXPdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            new Login(scrumXPdb).setVisible(true);
           //new MeetingRequests(scrumXPdb,"Barre").setVisible(true);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
