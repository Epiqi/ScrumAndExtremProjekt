import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Efe
 * @author Magnus
 */
public class JavaMailUtil {
    
        public static void main(String[] args) {

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
            message.setSubject("Test");
            message.setText("Detta �r ett test meddelande.");

            Transport.send(message);

            System.out.println("Klar!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}