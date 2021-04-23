import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Carolin
 */
public class SmsNotification {
    
    //System.out.println(message.getSid()); (kan anv�ndas vid test d� det bara skrivs ut om smset skickas.)
     public static void sendSMSForskning(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Det finns ett nytt inl�gg p� Forskning").create();
    }
    
    public static void sendSMSInfoSocial(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Det finns ett nytt inl�gg p� InfoSocial").create();
    }
    
    public static void sendSMSKurs(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Det finns ett nytt inl�gg p� Kurser").create();
    }
    
    public static void sendSMSMote(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Du har blivit inbjuden till ett nytt m�te").create();
    }
    
    public static void sendSMSMotesForfragan(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Du har f�tt en ny m�tesf�rfr�gan").create();
    }
    
    public static void sendSMSMeetingNotification(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Du blir h�rmed p�mind om ditt m�te").create();
    }
    
}
