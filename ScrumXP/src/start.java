/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carolin
 */
public class start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< Updated upstream
        // TODO code application logic here
=======
        try {

            scrumXPdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            //new Login(scrumXPdb).setVisible(true);
            new HomePage(scrumXPdb,"user").setVisible(true);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
>>>>>>> Stashed changes
    }
    
}
