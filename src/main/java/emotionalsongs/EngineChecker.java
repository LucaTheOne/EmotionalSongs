/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs;

import java.util.regex.*;

/**
 *
 * @author big
 */
public class EngineChecker {
    
    boolean checkNameValidity(String nome){
        if (nome.length()>20||nome.length()<3||nome.isBlank()||nome.matches(".*\\d.*")) {
            return false;   
        }
        return true;
    }
    
    boolean checkCognomeValidity(String cognome){
        if (cognome.length()>20||cognome.length()<3||cognome.isBlank()||cognome.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
    
    boolean checkAddresValidity(String indirizzo){
        if(indirizzo.isBlank()){
            return false;
        }
        return true;
    }
    
    boolean checkPasswordValidity(String password) throws PatternSyntaxException{  
    /**
    * Stringa contenente i tipi di caratteri accettati; viene effettuato un controllo sulla presenza
    * di almeno uno per tipologia:
    * <ul>
    * <li>(?=.*[0-9]) -> almeno un numero tra 0 e 9,
    * <li>(?=.*[a-z]) -> Almeno una lettera minuscola,
    * <li>(?=.*[A-Z]) -> Almeno una lettera maiuscola,
    * <li>(?=.*[@#$%^&+=!]) -> almeno uno dei seguenti caratteri speciali @#$%^&+=!,
    * <li>(?=\\S+$) -> spazi bianchi non ammessi,
    * <li>{8,20} -> minimo 8, massimo 20 caratteri.
    * </ul>
    **/
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}";
    /** Compila il pattern precedente. **/
        Pattern p = Pattern.compile(regex);
    /** Pattern class contiene il metodo .matcher() per verificare se la password coincide con il pattern.**/
        Matcher m = p.matcher(password);
    /**
    * Questa parte del codice gestisce la situazione
    * nel caso in cui la password non rispetti tutti i requisiti.
    **/
        return m.matches();
    }
    
    boolean passwordsMatch(String password,String controllo){
        return password.equals(controllo);
    }
    
    boolean checkMailValidity(String email) throws PatternSyntaxException{
      
        // Regex to check valid password.
        String regex = "^(.+)@(.+)$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        // Pattern class contains matcher() method to find matching between given password and regular expression.
        Matcher m = p.matcher(email);
        // Nel caso la password non rispettasse i requisiti
      
        return m.matches();
    }
    
    boolean checkCfValidity(String cf) throws PatternSyntaxException {
    
        String regex = "^([A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1})$|([0-9]{11})$";
        /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
        /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(cf);
        /**
        * Questa parte del codice gestisce la situazione
        * nel caso in cui il codice fiscale non rispetti il pattern.
        **/
        return m.matches();
    }
    
    boolean checkDateValidity(String date) throws PatternSyntaxException {
    
        String regex = "^([0-9]{2}[/][0-9]{2}[/][0-9]{4})$";
      /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(date);

        return m.matches();
    }
    
    boolean checkIdValidity(String userId) {
        return userId.length()>3 && userId.length()<20 && !userId.isBlank();
    }
    
    boolean checkIdNotTaken(DatabaseUtenti userDatabase,String id) {
        return userDatabase.cercaId(id) == null;
    }
    
    boolean checkCfNotPresent(DatabaseUtenti userDatabase,String cf) {
        return userDatabase.cercaCf(cf) == null;
    }
}
