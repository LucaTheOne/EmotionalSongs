
package emotionalsongs;

import java.io.*;
import java.util.*;
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
public class RegistrationPerformer {

    private File utentiRegistrati;
    private UserDatabase userDatabase = EMOTIONALSONGS.userDatabase;
    final RegistrationPanel panel;
    /**
     * Costruisce un oggetto vuoto.
     */
    public RegistrationPerformer(RegistrationPanel form) {
        utentiRegistrati = new File(Utilities.pathToUserDatabase);
        panel = form;
    }
    
    /**
    * Il metodo chiede all'utente di inserire l'userID, nome, 
    * cognome, codice fiscale, indirizzo, indirizzo email, password, data di nascita.
    * Dopodichè viene eseguito un controllo del codice fiscale: se il codice fiscale è stato già utilizzato 
    * l'utente verrà avvisato, se non è stato utilizzato si procederà alla registrazione dell'utente su file.
    * @throws IOException 
    */ 
    public void registraNuovoUtente(String userId,String nome,String cognome,String cf,String indirizzo,String email,String pswd,String dataNascita) throws IOException{
        Utente nuovo;
        boolean validCF = isValidCF(cf);
        boolean validNome = isValidName(nome);
        boolean validCognome = isValidCognome(cognome);
        boolean validDataNascita = isValidBirthDate(dataNascita);
        boolean validIndirizzo = isValidInd(indirizzo);
        boolean validUserId = isValidUserID(userId);
        boolean validEmail = isValidMail(email);
        boolean validPassword = isValidPassword(pswd);
        if(validCF&&validNome&&validCognome&&validDataNascita&&validIndirizzo&&validUserId&&validEmail&&validPassword){
            nuovo = new Utente(userId, pswd, cf, nome, cognome, dataNascita, email, indirizzo);    
            userDatabase.addUser(nuovo);
            salva();
        }
        
        
    }
    
     /**
     * Il metodo si occupa di scrivere il proprio parametro sul file utentiRegistrati.
     * @param testoDaScrivere - Prende la stringa con i dati dell'utente.
     * @throws IOException 
     */
    public void salva() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(utentiRegistrati));
        for (int i = 0; i < userDatabase.getDimensione(); i++) {
            bufferedWriter.write(userDatabase.get(i).componiStringa());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
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

        if (nome.length()>20||nome.length()<3||nome.isEmpty()||nome.matches(".*\\d.*")) {
            return false;
            panel.
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
        if (cognome.length()>20||cognome.length()<3||cognome.isEmpty()||cognome.matches(".*\\d.*")) {
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
        if(indirizzo.isEmpty()){
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
      boolean validForm;
      boolean passwordsEqual;
    
      //System.out.println("Minimo 8 - massimo 20 caratteri,\n"+"una minuscola, una maiuscola, un numero \n "+"ed almeno un carattere speciale tra: @#$%^&+=");
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
    validForm = m.matches();
      
    /**
    *Per verificare che l'utente ricordi la password inserita
    *gli si chiede di reinserirla, per poi successivamente confrontarla con la prima.
    **/
    String passwordCtrl = new Scanner(System.in).nextLine();//da modificare
    passwordsEqual = password.equals(passwordCtrl);
    
    return validForm&&passwordsEqual;
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
    
    
    boolean valid = m.matches();
   
    boolean notSigned = userCFSigned(cf);
    
    return valid && notSigned;
  }

  /**
   * Il metodo si occupa di chiedere all'utente la data di nascita, 
   * nel formato: GG/MM/AAAA; dopodichè verrà eseguito un controllo con il codice fiscale.
   * @return la data di nascita dell'utente.
   * @throws PatternSyntaxException 
   */
    private boolean isValidBirthDate(String birthDate) throws PatternSyntaxException {
    
        String regex = "^([0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4})$";
      /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(birthDate);

        return m.matches();
    }

   /**
   * Il metodo controlla se all'interno dell'userDatabase il codice fiscale è già presente.
   * @param cf - il codice fiscale dell'utente
   * @return true - se codice fiscale è presente nel database, false - se il codice fiscale non è presente nel database.
   * @throws FileNotFoundException 
   */  
  private boolean userCFSigned(String cf) throws FileNotFoundException {
      Scanner inputStream = new Scanner(new FileReader(Utilities.pathToUserDatabase));
      inputStream.useDelimiter("\n");

      while(inputStream.hasNext()){
        int countline = 0;
        String line = inputStream.next();//prendo l' intera linea
        if(countline%9==1){
          if (line.contains(cf)) {
            return true;
          }
        }
        countline++;
      }
    return false;
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
        boolean valid;
        boolean notTaken;
        valid = userId.length()<3||userId.length()>10||userId.contains(" ");
        notTaken = !userIDTaken(userId);


        return valid&&notTaken;
    }
  
   /**
   * Il metodo si occupa di controllare se l'userID inserito dall'utente non sia 
   * già presente nel database.
   * @param id - userID dell'utente.
   * @return true - se l'userID è presente nel database, false - se l'userID non è presente nel database.
   * @throws FileNotFoundException 
   */
  private boolean userIDTaken(String id) throws FileNotFoundException{
      Scanner inputStream = new Scanner(new FileReader(Utilities.pathToUserDatabase));
      inputStream.useDelimiter("\n");

      while(inputStream.hasNext()){
        int countline = 0;
        String line = inputStream.next();//prendo l' intera linea
        if(countline%9==0){
          if (line.contains(id)) {
            return true;
          }
        }
        countline++;
      }
    return false;
  }
}
