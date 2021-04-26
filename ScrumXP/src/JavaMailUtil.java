import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 * @author Efe
 * @author Magnus
 */
public class JavaMailUtil {

    public static void KursNotifikationMail(InfDB scrumXPdb) {

        final String username = "Grupp12Ateam@gmail.com";
        final String password = "@teamg12";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            ArrayList<String> emails;

            String hamtaEmail = "select Email from anstalld join notifikationer on anstalld.Anstalld_ID = AnstalldsNotifikationer where KursNotifikation = 1;";

            emails = scrumXPdb.fetchColumn(hamtaEmail);

            for (String mail : emails) {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(mail)
                );
                message.setSubject("Nytt inl�gg p� kurser!");
                message.setText("Hej!"
                        + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i kurser!");

                Transport.send(message);
            }

            System.out.println("Done");
            //SmsNotification.sendSMSKurs();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

    public static void ForskningNotifikationMail(InfDB scrumXPdb) {

        final String username = "Grupp12Ateam@gmail.com";
        final String password = "@teamg12";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            ArrayList<String> emails;

            String hamtaEmail = "select Email from anstalld join notifikationer on anstalld.Anstalld_ID = AnstalldsNotifikationer where ForskningNotifikation = 1;";

            emails = scrumXPdb.fetchColumn(hamtaEmail);

            for (String mail : emails) {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(mail)
                );
                message.setSubject("Nytt inl�gg p� Forskning!");
                message.setText("Hej!"
                        + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i forskning!");

                Transport.send(message);
            }

            System.out.println("Done");
            //SmsNotification.sendSMSForskning();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

    public static void InfoSocialNotifikationMail(InfDB scrumXPdb) {

        final String username = "Grupp12Ateam@gmail.com";
        final String password = "@teamg12";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            ArrayList<String> emails;

            String hamtaEmail = "select Email from anstalld join notifikationer on anstalld.Anstalld_ID = AnstalldsNotifikationer where InfoSocialNotifikation = 1;";

            emails = scrumXPdb.fetchColumn(hamtaEmail);

            for (String mail : emails) {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(mail)
                );
                message.setSubject("Nytt inl�gg p� InfoSociala!");
                message.setText("Hej!"
                        + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i Infosociala!");

                Transport.send(message);
            }

            System.out.println("Done");
            //SmsNotification.sendSMSInfoSocial();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

    public static void Motes_bokningNotifikationMail(InfDB scrumXPdb) {

        final String username = "Grupp12Ateam@gmail.com";
        final String password = "@teamg12";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            for (int i = 0; i < HomePage.lstAddedParticipants.getModel().getSize(); i++) {

                SimpleDateFormat dtfDate = new SimpleDateFormat("yyyy-MM-dd");
                String choosenDate = dtfDate.format(HomePage.datepickerDate1.getDate());

                String deltagarID = HomePage.lstAddedParticipants.getModel().getElementAt(i).replaceAll("\\D+", "");
                String fetchAnstalld_email = "SELECT EMAIL FROM ANSTALLD WHERE Anstalld_ID = '" + deltagarID + "'";
                String anstalldEmail = scrumXPdb.fetchSingle(fetchAnstalld_email);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(anstalldEmail)
                );
                message.setSubject("Du har blivit inbjuden till ett m�te!");
                message.setText("Hej!"
                        + "\n\n Du har blivit inbjuden till m�tet " + HomePage.txtMeetingName.getText() + "!"
                        + "\n\n Platsen �r " + HomePage.txtLocation.getText() + " och det �ger rum den " + choosenDate + " mellan klockan " + HomePage.tpFrom.getTime().toString() + " och " + HomePage.tpTo.getTime().toString() + "."
                        + "\n\n M�tesbeskrivning: "
                        + "\n\n" + HomePage.txtMeetingDescription.getText() + "");

                Transport.send(message);

            }

            System.out.println("Done");
            //SmsNotification.sendSMSMote();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception ettUndantag) { //L�gger �ven till NullPointerException
            JOptionPane.showMessageDialog(null, "Fel");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

    public static void Mote_forfragningNotifikationMail(InfDB scrumXPdb, String email) {

        final String username = "Grupp12Ateam@gmail.com";
        final String password = "@teamg12";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Ny m�tesf�rfr�gning!");
            message.setText("Hej!"
                    + "\n\n Du har f�tt en ny m�tesf�rfr�gning!"
                    + "\n\n Var sn�ll och skicka in vilken tid som passar dig!");

            Transport.send(message);

            System.out.println("Klar!");
            //SmsNotification.sendSMSMotesForfragan();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void Meeting_Notification(InfDB scrumXPdb, String userName) {


        
        final String username = "Grupp12Ateam@gmail.com";
        final String password = "@teamg12";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

                    
            
            String email = "select Email from anstalld where Anvandarnamn = '" + userName + "'";
            String anstalldEmail = scrumXPdb.fetchSingle(email);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(anstalldEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(anstalldEmail)
            );
            message.setSubject("P�minnelse om ditt m�te!");
            message.setText("Hej h�r kommer din p�minnelse f�r f�ljande m�te!"
                    + "\n\n"
                    + "\n\n" + HomePage.textAreaChooseInfo.getText() + "");
            Transport.send(message);

            System.out.println("Klar!");
            //SmsNotification.sendSMSMeetingNotification();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (InfException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
