import java.util.ArrayList;
import java.util.HashMap;
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
                System.out.println(mail);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(mail)
                );
                message.setSubject("Nytt inlägg på kurser!");
                message.setText("Hej!"
                        + "\n\n Nu kan ni gå in och kolla på det nya inlägget i kurser!");

                Transport.send(message);
            }

            System.out.println("Done");

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

            String hamtaEmail = "select Email from anstalld join notifikationer on anstalld.Anstalld_ID = AnstalldsNotifikationer where KursNotifikation = 1;";

            emails = scrumXPdb.fetchColumn(hamtaEmail);

            for (String mail : emails) {
                System.out.println(mail);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(mail)
                );
                message.setSubject("Nytt inlägg på Forskning!");
                message.setText("Hej!"
                        + "\n\n Nu kan ni gå in och kolla på det nya inlägget i forskning!");

                Transport.send(message);
            }


            System.out.println("Done");

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

            String hamtaEmail = "select Email from anstalld join notifikationer on anstalld.Anstalld_ID = AnstalldsNotifikationer where KursNotifikation = 1;";

            emails = scrumXPdb.fetchColumn(hamtaEmail);

            for (String mail : emails) {
                System.out.println(mail);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(mail)
                );
                message.setSubject("Nytt inlägg på InfoSociala!");
                message.setText("Hej!"
                        + "\n\n Nu kan ni gå in och kolla på det nya inlägget i Infosociala!");

                Transport.send(message);
            }

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    }

        public static void Mote_forfragningNotifikationMail(InfDB scrumXPdb) {

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
                    InternetAddress.parse("Grupp12Ateam@gmail.com")
            );
            message.setSubject("Se det nya inlï¿½gget pï¿½ InfoSociala!");
            message.setText("Hej!"
                    + "\n\n Nu kan ni gï¿½ in och kolla pï¿½ det nya inlï¿½gget i InfoSociala!");

            Transport.send(message);

            System.out.println("Klar!");

        } catch (MessagingException e) {
            e.printStackTrace();
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

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("Grupp12Ateam@gmail.com")
            );
            message.setSubject("Se det nya inlï¿½gget pï¿½ InfoSociala!");
            message.setText("Hej!"
                    + "\n\n Nu kan ni gï¿½ in och kolla pï¿½ det nya inlï¿½gget i InfoSociala!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        } 
    }




}
