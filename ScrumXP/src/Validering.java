import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
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
    public static boolean textFaltHarVarde(JTextField rutaAttKolla){
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Rutan är tom!");
            resultat = false;
            
        }
            
        return resultat;
    }
    //Returnerar true eller false beroende på ifall JTextField är mindre än 30 tecken 
    public static boolean textFaltMindreAn30(JTextField rutaAttKolla) {
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
        
        if(textAttKolla.getText().matches("[a-zA-Z+]")){
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
}
