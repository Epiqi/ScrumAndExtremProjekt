import java.util.ArrayList;
import java.util.HashMap;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * @author Efe
 * @author Magnus
 */
public class JavaMailUtil {

        public static void KursNotifikationMail(InfDB scrumXPdb) {


                String hamtaEmail = "select Email from anstalld join notifikationer on anstalld.Anstalld_ID = AnstalldsNotifikationer where KursNotifikation = 1;";
            try {
                    ArrayList<HashMap<String, String>> email = scrumXPdb.fetchRows(hamtaEmail);
               System.out.println(email);
            } catch (InfException ex) {
                Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
            }




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
                    InternetAddress.parse("")
            );
            message.setSubject("Nytt inl�gg p� kurser!");
            message.setText("Hej!"
                    + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i kurser!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
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

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("Grupp12Ateam@gmail.com")
            );
            message.setSubject("Se det nya inl�gget p� InfoSociala!");
            message.setText("Hej!"
                    + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i InfoSociala!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
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

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Grupp12Ateam@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("Grupp12Ateam@gmail.com")
            );
            message.setSubject("Se det nya inl�gget p� InfoSociala!");
            message.setText("Hej!"
                    + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i InfoSociala!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
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
            message.setSubject("Se det nya inl�gget p� InfoSociala!");
            message.setText("Hej!"
                    + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i InfoSociala!");

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
            message.setSubject("Se det nya inl�gget p� InfoSociala!");
            message.setText("Hej!"
                    + "\n\n Nu kan ni g� in och kolla p� det nya inl�gget i InfoSociala!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }




}
