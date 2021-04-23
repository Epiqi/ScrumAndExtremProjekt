import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Carolin
 */
public class SmsNotification {
    
    //System.out.println(message.getSid()); (kan användas vid test då det bara skrivs ut om smset skickas.)
     public static void sendSMSForskning(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Det finns ett nytt inlägg på Forskning").create();
    }
    
    public static void sendSMSInfoSocial(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Det finns ett nytt inlägg på InfoSocial").create();
    }
    
    public static void sendSMSKurs(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Det finns ett nytt inlägg på Kurser").create();
    }
    
    public static void sendSMSMote(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Du har blivit inbjuden till ett nytt möte").create();
    }
    
    public static void sendSMSMotesForfragan(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Du har fått en ny mötesförfrågan").create();
    }
    
    public static void sendSMSMeetingNotification(){        
        Twilio.init("ACe08eae2b1e382dd26eb6f53878cb2e6e", "8fc5d001cc022208149e91933b0222e3");
        Message.creator( new PhoneNumber("+46733245520"), new PhoneNumber("+12565768147"), "Du blir härmed påmind om ditt möte").create();
    }
    
}
