
package emotionalsongs;

import java.io.*;
import java.util.regex.*;

/**
* La classe si occupa di fornire all'utente i metodi necessari per registrarsi inserendo dati come:
* <ul>
* <li>UserID.
* <li>Codice fiscale(formato italiano).
* <li>Nome.
* <li>Cognome.
* <li>Indirizzo di residenza.
* <li>Indirizzo email.
* <li>Data di nascita.
* <li>Password a scelta dell'utente.
* </ul>
* La classe in essere implementa anche vari metodi di controllo che verificano:
* <ul>
* <li>La validità del formato dei dati.
* <li>Che l' utente non vi sia già registrato.
* <li>Che l' utente sappia quale password ha scelto.
* </ul>
* Oltreciò si occupa anche di salvarne i dati su un file .txt con una precisa impostazione,
* denominato utentiRegistrati.dati.txt .
* nb v1.0 non vi è forma di controllo sull' indirizzo.
**/
public class EngineRegistration {

    private UserDatabase userDatabase;
    boolean validCF;
    boolean cfNotSigned;
    boolean validNome;
    boolean validCognome;
    boolean validDataNascita;
    boolean validIndirizzo;
    boolean validUserId;
    boolean idNotTaken;
    boolean validEmail;
    boolean validPassword;
    boolean passwordMatches;
    
    boolean allRight = false;
    
    /**
     * Costruisce un oggetto vuoto.
     */
    public EngineRegistration(UserDatabase database) { 
        userDatabase = database;
    }
    
    /**
    * Il metodo chiede all'utente di inserire l'userID, nome, 
    * cognome, codice fiscale, indirizzo, indirizzo email, password, data di nascita.
    * Dopodichè viene eseguito un controllo del codice fiscale: se il codice fiscale è stato già utilizzato 
    * l'utente verrà avvisato, se non è stato utilizzato si procederà alla registrazione dell'utente su file.
    * @throws IOException 
    */ 
    public void registraNuovoUtente(String userId,String nome,String cognome,String cf,String indirizzo,String email,String pswd,String contrPswd,String dataNascita) throws IOException{
        Utente nuovo;
        
        validCF = isValidCF(cf);
        cfNotSigned = userCFNotSigned(cf);
        validNome = isValidName(nome);
        validCognome = isValidCognome(cognome);
        validDataNascita = isValidBirthDate(dataNascita);
        validIndirizzo = isValidInd(indirizzo);
        validUserId = isValidUserID(userId);
        idNotTaken = userIDNotTaken(userId);
        System.out.println("id controllato");
        validEmail = isValidMail(email);
        System.out.println("mail controllato");
        validPassword = isValidPassword(pswd);
        passwordMatches = passwordsMatch(pswd, contrPswd);
        System.out.println("psw controllato");
        
        if(validCF 
                && cfNotSigned 
                && validNome 
                && validCognome 
                && validDataNascita 
                && validIndirizzo
                && validUserId
                && idNotTaken
                && validEmail
                && validPassword
                && passwordMatches
            ){
            nuovo = new Utente(userId, pswd, cf, nome, cognome, dataNascita, email, indirizzo); 
            System.out.println("utente creato");
            userDatabase.addNewUser(nuovo);
            System.out.println("utente aggiunto");
            EMOTIONALSONGS.loggedUser = nuovo;
            EMOTIONALSONGS.logged = true;
            allRight = true;
            System.out.println("fine");
        }        
    }
    
     /**
      * Il metodo si occupa di chiedere all'utente di inserire il suo primo nome.
      * Succesivamente effettuerà un controllo sul nome, che non deve: 
      * <ul>
      * <li>Superare 20 caratteri.
      * <li>Avere meno di 3 caratteri.
      * <li>Essere vuoto.
      * <li>Contenere i caratteri (.*\\d.*).
      * Se rispetta le 4 condizioni il boolean del metodo ritornerà 
      * true e il nome dell'utente verrà assegnato alla stringa.
      * @return il nome dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
      */
    private boolean isValidName(String nome){
        if (nome.length()>20||nome.length()<3||nome.isBlank()||nome.matches(".*\\d.*")) {
            return false;   
        }
        return true;
    }
     
    /**
      * Il metodo si occupa di chiedere all'utente di inserire il suo primo cognome.
      * Succesivamente effettuerà un controllo sul primo cognome, che non deve: 
      * <ul>
      * <li>Superare 20 caratteri.
      * <li>Avere meno di 3 caratteri.
      * <li>Essere vuoto.
      * <li>Contenere i caratteri (.*\\d.*).
      * Se rispetta le 4 condizioni il boolean del metodo ritornerà 
      * true e il cognome dell'utente verrà assegnato alla stringa.
      * @return il cognome dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
      */
    private boolean isValidCognome(String cognome){
        if (cognome.length()>20||cognome.length()<3||cognome.isBlank()||cognome.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
    
    /**
     * Il metodo si occupa di chiedere all'utente di inserire il suo indirizzo; 
     * se il campo non è vuoto, verrà assegnato alla stringa.
     * @return l'indirizzo dell'utente scritto in minuscolo.
     */
    private boolean isValidInd(String indirizzo){
        if(indirizzo.isBlank()){
            return false;
        }
        return true;
    }

    /**
* Il metodo si occupa di far inserire la Password
* all'utente e di verificare che rispetti i requisiti.
* Inoltre verifica che l'utente abbia inserito la stessa password entrambe le volte.
* @throws PatternSyntaxException
* @return la password inserita dall'utente. 
**/
    private boolean isValidPassword(String password) throws PatternSyntaxException{  
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
  
    public boolean passwordsMatch(String password,String controllo){
        return password.equals(controllo);
    }

    /**
    * Il metodo si occupa di chiedere l'email all'utente, e di controllare la sua 
    * validita.
    * @return l'email dell'utente.
    * @throws PatternSyntaxException 
    */
    private boolean isValidMail(String email) throws PatternSyntaxException{
      
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
    * Stringa contenente i tipi di caratteri ed il formato
    * che deve presentare un codice fiscale italiano corretto:
    * <ul>
    * <li>[A-Za-z]{6} -> 6 lettere dell' alfabeto da a a z.
    * <li>[0-9lmnpqrstuvLMNPQRSTUV]{2} -> due valori tra 0-9 o lmnpqrstuv.
    * <li>[abcdehlmprstABCDEHLMPRST]{1} -> una lettera tra abcdehlmprst
    * <li>[0-9lmnpqrstuvLMNPQRSTUV]{3} -> nuovamente tre valori tra 0-9 o lmnpqrstuv.
    * <li>[A-Za-z]{1} -> una lettera del alfabeto.
    * </ul>
    **/
    private boolean isValidCF(String cf) throws PatternSyntaxException, FileNotFoundException{
    
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
   * Il metodo si occupa di chiedere all'utente la data di nascita, 
   * nel formato: GG/MM/AAAA; dopodichè verrà eseguito un controllo con il codice fiscale.
   * @return la data di nascita dell'utente.
   * @throws PatternSyntaxException 
   */
    private boolean isValidBirthDate(String birthDate) throws PatternSyntaxException {
    
        String regex = "^([0-9]{2}[/][0-9]{2}[/][0-9]{4})$";
      /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(birthDate);

        return m.matches();
    }

    /**
    * Il metodo si occupa di chiedere all'utente di inserire l'userID. 
    * L'userID inserito non deve: 
    * <ul>
    * <li>essere composto da meno di 3 caratteri o da più di 10 caratteri,
    * <li>non deve contenere spazi.
    * </ul>
    * Se rispetta queste tre condizioni, l'userID sarà registrato.
    * @return - userID dell'utente.
    * @throws FileNotFoundException 
    */
    private boolean isValidUserID(String userId) throws FileNotFoundException{
        return userId.length()>3 && userId.length()<20 && !userId.isBlank();
    }
  
    /**
    * Il metodo si occupa di controllare se l'userID inserito dall'utente non sia 
    * già presente nel database.
    * @param id - userID dell'utente.
    * @return true - se l'userID è presente nel database, false - se l'userID non è presente nel database.
    * @throws FileNotFoundException 
    */
    private boolean userIDNotTaken(String id) throws FileNotFoundException{
        return userDatabase.cercaId(id) == null;
    }  

    /**
    * Il metodo controlla se all'interno dell'userDatabase il codice fiscale è già presente.
    * @param cf - il codice fiscale dell'utente
    * @return true - se codice fiscale è presente nel database, false - se il codice fiscale non è presente nel database.
    * @throws FileNotFoundException 
    */  
    private boolean userCFNotSigned(String cf) throws FileNotFoundException {
        return userDatabase.cercaCf(cf) == null;
    }  
    
}
