//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.engines;

import emotionalsongs.basic_structures.Song;
import emotionalsongs.basic_structures.UserJudgement;
import emotionalsongs.data_structures.DataBaseJudgements;
import emotionalsongs.data_structures.DataBaseUsers;

import java.util.regex.*;

/**
 * La classe si occupa di controllare i dati inseriti durante la registrazione.
 * @author big
 */
public class EngineChecker {
    
    //Methods checking data validity
    /**
     * Il metodo confronta la stringa nome che esegue il metodo con quella fornita 
     * come argomento e restituisce false se:
     * <ul>
     * <li>Se non e stato inserito nessun carattere.</li>
     * <li>Se i caratteri >20.</li>
     * <li>Se i caratteri <3.</li>
     * <li>Se contiene caratteri speciali. </li>
     * </ul>
     * Altrimeti restituisce true.
     * @param nome Nome dell'utente.
     * @return True o False.
     */
    public boolean checkNameValidity(String nome){
        if(nome == null) return false;
        if (nome.isBlank()||nome.length()>20||nome.length()<3||nome.matches(".*\\d.*")) {
            return false;   
        }
        return true;
    }
    
    /**
     * Il metodo confronta la stringa cognome che esegue il metodo con quella fornita 
     * come argomento e restituisce false se:
     * <ul>
     * <li>Se non e stato inserito nessun carattere.</li>
     * <li>Se i caratteri >20.</li>
     * <li>Se i caratteri <3.</li>
     * <li>Se contiene caratteri speciali. </li>
     * </ul>
     * Altrimeti restituisce true.
     * @param cognome
     * @return True o False.
     */
    public boolean checkCognomeValidity(String cognome){
        if(cognome == null) return false;
        if (cognome == null && cognome.length()>20||cognome.length()<3||cognome.isBlank()||cognome.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
    
    /**
     * Il metodo confronta la stringa indirizzo che esegue il metodo con quella fornita 
     * come argomento e restituisce false se e vuota, altrimenti true.
     * @param cognome
     * @return True o False.
     */    
    public boolean checkAddresValidity(String indirizzo){
        if(indirizzo == null) return false;
        if(indirizzo.isBlank()){
            return false;
        }
        return true;
    }
    
    /**
     * Il metodo controlla la validità della password.
    * La Stringa regex contenente i tipi di caratteri accettati; viene effettuato un controllo sulla presenza
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
    public boolean checkPasswordValidity(String password) throws PatternSyntaxException{ 
        if(password == null) return false;
    
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
    
    /**
     * 
     * @param password
     * @param controllo
     * @return 
     */
    public boolean passwordsMatch(String password,String controllo){
        if(controllo == null) return false;
        return password.equals(controllo);
    }
    
    public boolean checkMailValidity(String email) throws PatternSyntaxException{
        if(email == null) return false;
        // Regex to check valid password.
        String regex = "^(.+)@(.+)$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        // Pattern class contains matcher() method to find matching between given password and regular expression.
        Matcher m = p.matcher(email);
        // Nel caso la password non rispettasse i requisiti
      
        return m.matches();
    }
    
    public boolean checkCfValidity(String cf) throws PatternSyntaxException {
        if(cf == null) return false;
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
    
    public boolean checkBirthDayValidity(String birthDay) throws PatternSyntaxException {
        if(birthDay == null) return false;
        String regex = "^([0-9]{2}[/][0-9]{2}[/][0-9]{4})$";
      /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(birthDay);

        return m.matches();
    }
    
    public boolean checkIdValidity(String userId) {
        return userId != null && userId.length()>3 && userId.length()<20 && !userId.isBlank();
    }
    
    public boolean checkIdNotTaken(DataBaseUsers userDatabase,String id) {
        if(id == null) return false;
        return userDatabase.searchUserId(id) == null;
    }
    
    //
    public boolean checkCfNotPresent(DataBaseUsers userDatabase,String cf) {
        return cf != null && userDatabase.searchUserCf(cf) == null;
    }

    public boolean checkIfVoted(String userId, Song brano, DataBaseJudgements dataSetEmozioni) {
        if (dataSetEmozioni.isEmpty()) {
            return false;
        }
        UserJudgement[] arrayRecords = dataSetEmozioni.getArray();
        for (int i = 0; i < arrayRecords.length; i++) {
            if(arrayRecords[i].getBranoTag().equals(brano.getTag())){
                String userIDCurrentRecord = arrayRecords[i].getUserIDRecord();
                if(userIDCurrentRecord.equals(userId)) return true;
            }
        }
        return false;
    }    

    public boolean checkIfContains(Song[] songs,String songtag) {
        for (int i = 0; i < songs.length; i++) {
            if(songs[i].getTag().equals(songtag)) return true;
        }
        return false;
    }
    
    public boolean checkIfCanVote(String userId,String songTag){
        DataBaseJudgements dataBaseRecords = DataBaseJudgements.getInstance();
        if(dataBaseRecords.isEmpty()) return true;
        for(int i = 0; i<dataBaseRecords.getSize();i++){
            UserJudgement actualRecord = dataBaseRecords.getRecordFromIndex(i);
            if(actualRecord.getBranoTag().equals(songTag)&&actualRecord.getUserIDRecord().equals(userId)) return false;
        }
        return true;
    }
    
}
