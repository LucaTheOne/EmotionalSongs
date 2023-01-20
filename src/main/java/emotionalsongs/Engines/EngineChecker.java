//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.engines;

import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import java.util.regex.*;

/**
 * Classe le cui istanze si occupano di validare dati.
 * 
 */
public class EngineChecker {
    
    //Methods checking data validity
    /**
     * Il metodo convalida la stringa name passata come argomento
     * e restituisce false se:
     * <ul>
     *  <li>Se non e stato inserito nessun carattere.</li>
     *  <li>Se il numero di caratteri e maggiore di 20.</li>
     *  <li>Se il numero di caratteri è minore di 3.</li>
     *  <li>Se contiene caratteri speciali. </li>
     * </ul>
     * Altrimeti restituisce true.
     * @param name Nome dell'utente da validare.
     * @return True o False.
     */
    public boolean checkNameValidity(String name){
        if(name == null) return false;
        if (name.isBlank()||name.length()>20||name.length()<3||name.matches(".*\\d.*")) {
            return false;   
        }
        return true;
    }
    
    /**
     * Il metodo convalida la stringa surname passata come argomento restituisce false se:
     * <ul>
     * <li>Se non e stato inserito nessun carattere.</li>
     * <li>Se i caratteri sono più di 20.</li>
     * <li>Se i caratteri sono meno di 3.</li>
     * <li>Se contiene caratteri speciali. </li>
     * </ul>
     * Altrimeti restituisce true.
     * @param surname cognome da convalidare.
     * @return True o False.
     */
    public boolean checkSurnameValidity(String surname){
        if(surname == null) return false;
        if (surname == null && surname.length()>20||surname.length()<3||surname.isBlank()||surname.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
    
    /**
     * Il metodo convalida la stringa address passata come argomento
     * e restituisce false se è nulla opppure bianca.
     * @param address Indirizzo da validare.
     * @return True o False.
     */    
    public boolean checkAddresValidity(String address){
        if(address == null) return false;
        if(address.isBlank()){
            return false;
        }
        return true;
    }
    
    /**
     * Il metodo controlla la validità della password.
     * Per fare ciò sfrutta le regular expressions (regex),
    *  tramite il quale viene effettuato un controllo sulla presenza
    * di almeno una occorrenza, nella password analizzata, di:
    * <ul>
    * <li>(?=.*[0-9]) -> almeno un numero tra 0 e 9,
    * <li>(?=.*[a-z]) -> Almeno una lettera minuscola,
    * <li>(?=.*[A-Z]) -> Almeno una lettera maiuscola,
    * <li>(?=.*[@#$%^&+=!]) -> almeno uno dei seguenti caratteri speciali @#$%^&+=!,
    * <li>(?=\\S+$) -> spazi bianchi non ammessi,
    * <li>{8,20} -> minimo 8, massimo 20 caratteri.
    * </ul>
    * @param password password da validare
    * @return True se la password rispetta tutti i criteri, altrimenti false.
    * @throws PatternSyntaxException.
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
     * Metodo che verifica che entrambi le passwords immesse dal utente coincidano.
     * Ritorna true qualora coincidano
     * @param password password da validare
     * @param controllo password da validare
     * @return true qualora coincidano, altrimenti false.
     */
    public boolean passwordsMatch(String password,String controllo){
        if(controllo == null) return false;
        return password.equals(controllo);
    }
    /**
     * Verifica la validità dell' indirizzo mail.
     * @param email da validare
     * @return true se valida, altrimenti false.
     * @throws PatternSyntaxException 
     */
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
    /**
     * Metodo che valida il CF immesso dal nuovo utente, tramite Regular Expressions (regex).
     * @param cf da validare
     * @return true se valido, false altrimenti.
     * @throws PatternSyntaxException 
     */
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
    /**
     * Metodo che convalida che la data inserita sia nel formato corretto: dd/mm/yyyy.
     * @param birthDay data di nascita da validare.
     * @return true se valida, false altrimenti.
     * @throws PatternSyntaxException 
     */
    public boolean checkBirthDayValidity(String birthDay) throws PatternSyntaxException {
        if(birthDay == null) return false;
        String regex = "^([0-9]{2}[/][0-9]{2}[/][0-9]{4})$";
      /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(birthDay);

        return m.matches();
    }
    /**
     * Metodo che verifica che l' id scelto dal nuovo utente rispetti determinati requisiti:
     * <ul>
     * <li>Non nullo</li>
     * <li>Almeno tre caratteri e non più di 19</li>
     * <li>Non sia una stringa vuota</li>
     * @param userId Id da validare.
     * @return true se rispetta i requisiti, false altrimenti.
     */
    public boolean checkIdValidity(String userId) {
        return userId != null && userId.length()>3 && userId.length()<20 && !userId.isBlank();
    }
    /**
     * Metodo che verifica che l' id scelto dal utente non sia già stato scelto da un altro.
     * @param userId id la cui unicità va verificata.
     * @return true se unico, false altrimenti.
     */
    public boolean checkIdNotTaken(DataBaseUsers userDatabase,String id) {
        if(id == null) return false;
        return userDatabase.searchUserById(id) == null;
    }
    
    /**
     * Metodo che verifica che nel database utenti non vi sia già presente il CF fornito dal nuovo utente.
     * @param userDatabase database utenti in cui effettuare la ricerca.
     * @param cf CF da validare
     * @return true se non è già presente nel database passato come argomento, false altrimenti.
     */
    public boolean checkCfNotPresent(DataBaseUsers userDatabase,String cf) {
        return cf != null && userDatabase.searchByUserCf(cf) == null;
    }
    
    /**
     * Metodo che verifica se un utente ha già espresso un giudizio emozionale per una determinata canzone, ricercandola nel database passato come argomento.
     * @param userId id del utente su cui si vuole effettuare la verifica.
     * @param song canzone di cui si vuole effettuare la verifica.
     * @param databaseJudgements database su cui effettuare la ricerca.
     * @return true se l' utente non ha ancora valutato la canzone, false altrimenti.
     */
    public boolean checkIfVoted(String userId, Song song, DataBaseJudgements databaseJudgements) {
        if (databaseJudgements.isEmpty()) {
            return false;
        }
        EmotionalJudgement[] arrayRecords = databaseJudgements.getArray();
        for (int i = 0; i < arrayRecords.length; i++) {
            if(arrayRecords[i].getBranoTag().equals(song.getTag())){
                String userIDCurrentRecord = arrayRecords[i].getUserIDRecord();
                if(userIDCurrentRecord.equals(userId)) return true;
            }
        }
        return false;
    }    
    /**
     * Verifica se un array di canzoni ne contiene una associata al tag passato come argomento.
     * @param songs array di canzoni
     * @param songtag tag della canzone di cui se ne vuole verificare la presenza.
     * @return true se presente, false altrimenti.
     */
    public boolean checkIfContains(Song[] songs,String songtag) {
        for (int i = 0; i < songs.length; i++) {
            if(songs[i].getTag().equals(songtag)) return true;
        }
        return false;
    }
    /**
     * Metodo che verifica se un utente può esprimere giudizi su una determinata canzone.
     * @param userId id del utente
     * @param songTag tag della canzone
     * @return true se non ha già espresso giudizi, false altrimenti.
     */
    public boolean checkIfCanVote(String userId,String songTag){
        DataBaseJudgements dataBaseRecords = DataBaseJudgements.getInstance();
        if(dataBaseRecords.isEmpty()) return true;
        for(int i = 0; i<dataBaseRecords.getSize();i++){
            EmotionalJudgement actualRecord = dataBaseRecords.getRecordFromIndex(i);
            if(actualRecord.getBranoTag().equals(songTag)&&actualRecord.getUserIDRecord().equals(userId)) return false;
        }
        return true;
    }
    
}
