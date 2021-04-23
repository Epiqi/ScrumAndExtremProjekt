import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fredr
 */
public class Validering {
    
    
    //Kollar om textfältet har värde
    public static boolean textFieldHasValue(JTextField rutaAttKolla){
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Rutan är tom!");
            resultat = false;
            
        }
            
        return resultat;
    }
    
    public static boolean textAreaHasValue(JTextArea rutaAttKolla){
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Rutan är tom!");
            resultat = false;
            
        }
            
        return resultat;
    }
    
    //Returnerar true eller false beroende på ifall JTextField är mindre än 30 tecken 
    public static boolean textFieldLessThen30(JTextField rutaAttKolla) {
    boolean resultat = true;
        if (rutaAttKolla.getText().length()>= 30) {
            JOptionPane.showMessageDialog(null, "Angiven text är längre än 30 tecken!");
            resultat = false;
            rutaAttKolla.requestFocus();
        }
        return resultat;
    }
    
  
    //Kollar om textfältet är av bokstäver
    public static boolean isStrang(JTextField textAttKolla){        
        boolean resultat = false;
        
        if(textAttKolla.getText().matches("[a-zåäöA-ZÅÄÖ+]")){
            resultat = true;
            JOptionPane.showMessageDialog(null, "Ange endast bokstäver");
        }
           
        return resultat;
    }
    //Kollar om textfältet är heltal
    public static boolean isHeltal(JTextField textAttKolla) {        
        boolean resultat = true;
        
        try {
            String inStrang = textAttKolla.getText();
            Integer.parseInt(inStrang);
            textAttKolla.requestFocus();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Var god ange en siffra!");
            resultat = false;
        }
        
        return resultat;
    }
    //Kollar om textfältet är ett positivt heltal
    public static boolean positivtHeltal(JTextField textAttKolla) {        
        boolean resultat = true;
        
        if (textAttKolla.getText().substring(0, 1).equals("-")) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Skriv in ett positivt värde");            
        }
        
        return resultat;
    }
    //Kollar om datumformatet är YYYY-MM-DD
    public static boolean isDatum(JTextField rutaAttKolla){
        String datum = rutaAttKolla.getText();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        df.setLenient(false);
        
        try {
            date = df.parse(datum);
            return true;
        } 
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Felaktigt datumformat vänligen fyll i efter YYYY-MM-DD");
            return false;
        }
        
    }
    public static boolean isPasswordValid(String password)
    {
            boolean resultat = true;
            String upperCaseChars = "(.*[A-ZÅÄÖ].*)";
            String lowerCaseChars = "(.*[a-zåäö].*)";
            String numbers = "(.*[0-9].*)";
            String specialChars = "(.*[!,@,#, £,¤,$,%,&,].*)";
            
            if (password.length() > 15 || password.length() < 6)
            {
                JOptionPane.showMessageDialog(null, "Lösenordet måste vara längre än 6 tecken och kortare än 15 tecken.");
                resultat = false;
            }
            
            else if (!password.matches(upperCaseChars ))
            {
                JOptionPane.showMessageDialog(null, "Lösenordet måste innehålla minst en stor bokstav");
                resultat = false;
            }
            
            else if (!password.matches(lowerCaseChars ))
            {
                    JOptionPane.showMessageDialog(null, "Lösenordet måste innehålla minst en liten bokstav");
                    resultat = false;
            }
            
            else if (!password.matches(numbers ))
            {
                JOptionPane.showMessageDialog(null, "Lösenordet måste innehålla minst en siffra");
                resultat = false;
            }
            
            else if (!password.matches(specialChars ))
            {
                JOptionPane.showMessageDialog(null, "Lösenordet måste innehålla något av följande specialtecken: !,@,#, £,¤,$,%,& ");
                resultat = false;
            }
            return resultat; 
    }
    public static boolean isTextSame(String word1, String word2){
    
            boolean resultat = true;
            
            if(!word1.equals(word2)){
                JOptionPane.showMessageDialog(null, "Lösenorden måste vara samma");
                resultat = false;
            }
            return resultat; 
    }
    public static boolean lessThen20andMoreThen2Characters(String stringToEvaluate){
        boolean resultat = true;
        if (stringToEvaluate.length()> 20 || stringToEvaluate.length()<= 2) {
            JOptionPane.showMessageDialog(null, "Minst två tecken och max tjugo i varje ruta");
            resultat = false;
        }
        return resultat;
    }
    public static boolean isEmail(String email){
        
        boolean resultat = true;
        String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@(([a-zA-Z]+\\.)+[a-zA-Z]{2,3})$";
        if (!email.matches(emailRegex)){
            JOptionPane.showMessageDialog(null, "Emailen har fel format");
            resultat = false;
        }
        return resultat;
    }
    
    public static boolean isMobileNumber(String mobileNumber){
        
        boolean resultat = true;
        String mobileRegex = "^07+([0-9]){8}$";
        if (!mobileNumber.matches(mobileRegex)){
            JOptionPane.showMessageDialog(null, "Mobilnummret ska vara 10 siffror och börja med 07");
            resultat = false;
        }
        return resultat;
    }
    
        public static boolean onlyLetters(String stringToCheck){        
        boolean resultat = true;
        
        if(!stringToCheck.matches("^[a-zåäöA-ZÅÄÖ]+$")){
            resultat = false;
            JOptionPane.showMessageDialog(null, "Ange endast bokstäver");
        }
           
        return resultat;
    }

        
    public static boolean isDateLaterAndTimeIsAfter(String startDatum, String startTime) {
        boolean resultat = false;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime localTimeStartTime = LocalTime.parse(startTime, formatter);

        LocalTime now = LocalTime.now();
        String dagensDatum = java.time.LocalDate.now().toString();

        String[] arrayStartDatum = dagensDatum.split("-");
        String[] arraySlutDatum = startDatum.split("-");

        String startSiffra = arrayStartDatum[0] + arrayStartDatum[1] + arrayStartDatum[2];
        String slutSiffra = arraySlutDatum[0] + arraySlutDatum[1] + arraySlutDatum[2];

        int startDatumet = Integer.parseInt(startSiffra);
        int slutDatumet = Integer.parseInt(slutSiffra);

        if (startDatumet <= slutDatumet) {
            if (startDatumet == slutDatumet) {
                if (localTimeStartTime.isAfter(now)) {
                    resultat = true;

                } else {
                    resultat = false;
                    JOptionPane.showMessageDialog(null, "Starttiden m�ste vara efter nuvarande klockslag!");
                }

            }
            else {
            resultat = true;
            }
            
            return resultat;
        } else {
            JOptionPane.showMessageDialog(null, "Startdatum m�ste vara efter dagens datum!");
        }

        return resultat;
    }
            
            
           
        public static boolean stringGotValue (String stringCheck) {
          boolean resultat = true;
          
          if (stringCheck.isEmpty()) {
              resultat = false;
              JOptionPane.showMessageDialog(null,"En ruta är tom!");
          }
          return resultat;
        }
        
        public static boolean dateChooserGotValue (JDateChooser dateToCheck) {
            boolean resultat = true;
            
            if(dateToCheck.getDate()==null){
            JOptionPane.showMessageDialog(null, "Inget datum är valt");
}
            return resultat;
        }
        
        public static boolean timePickerGotValue (TimePicker timeToCheck) {
            boolean resultat = true;
            
            if (timeToCheck.getTime() == null) {
                resultat = false;
                JOptionPane.showMessageDialog(null, "Ingen tid är vald");
            }
                    
            return resultat;        
        }
        
        public static boolean passwordFieldHasValue(JPasswordField fieldToCheck){

            boolean resultat = true;
            char[] password = fieldToCheck.getPassword();
            String stringPassword = new String(password);

            if (stringPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ange l�senord.");
                resultat = false;
                fieldToCheck.requestFocus();
            }
            return resultat;
    }

}


