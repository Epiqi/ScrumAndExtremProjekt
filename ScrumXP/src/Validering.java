import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
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
    //Kollar om textf�ltet har v�rde
    public static boolean textFieldHasValue(JTextField checkText){
        boolean resultat = true;
        
        if(checkText.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Rutan �r tom!");
            resultat = false;
            
        }
            
        return resultat;
    }
    
    public static boolean textAreaHasValue(JTextArea checkText){
        boolean resultat = true;
        
        if(checkText.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Rutan �r tom!");
            resultat = false;
            
        }
            
        return resultat;
    }
    //Returnerar true eller false beroende p� ifall JTextField �r mindre �n 30 tecken 
    public static boolean textFieldLessThen30(JTextField checkText) {
    boolean resultat = true;
        if (checkText.getText().length()>= 30) {
            JOptionPane.showMessageDialog(null, "Angiven text �r l�ngre �n 30 tecken!");
            resultat = false;
            checkText.requestFocus();
        }

        return resultat;
    }
    
    public static boolean textAreaLessThen9999(JTextArea checkText) {
    boolean resultat = true;
        if (checkText.getText().length()> 9999) {
            JOptionPane.showMessageDialog(null, "Angiven text �r l�ngre �n 9999 tecken!");
            resultat = false;
            checkText.requestFocus();
        }

        return resultat;
    }
//Kollar om textf�ltet �r av bokst�ver
    public static boolean isString(JTextField checkText){        
        boolean resultat = false;
        
        if(checkText.getText().matches("[a-zA-Z+]")){
            resultat = true;
            JOptionPane.showMessageDialog(null, "Ange endast bokst�ver");
        }
           
        return resultat;
    }
    //Kollar om textf�ltet �r heltal
    public static boolean isInt(JTextField checkText) {        
        boolean resultat = true;
        
        try {
            String inStrang = checkText.getText();
            Integer.parseInt(inStrang);
            checkText.requestFocus();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Var god ange en siffra!");
            resultat = false;
        }
        
        return resultat;
    }
    //Kollar om textf�ltet �r ett positivt heltal
    public static boolean positiveInt(JTextField checkText) {        
        boolean resultat = true;
        
        if (checkText.getText().substring(0, 1).equals("-")) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Skriv in ett positivt v�rde");            
        }
        
        return resultat;
    }
    //Kollar om datumformatet �r YYYY-MM-DD
    public static boolean isDate(JTextField checkText){
        String datum = checkText.getText();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        df.setLenient(false);
        
        try {
            date = df.parse(datum);
            return true;
        } 
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Felaktigt datumformat v�nligen fyll i efter YYYY-MM-DD");
            return false;
        }
        
    }
    
    
}
