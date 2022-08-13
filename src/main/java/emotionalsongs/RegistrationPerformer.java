
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

    private File utentiRegistrati = new File(Utilities.pathToUserDatabase);
    
    /**
     * Costruisce un oggetto vuoto.
     */
    public RegistrationPerformer() {
        
    }
    
    /**
    * Il metodo chiede all'utente di inserire l'userID, nome, 
    * cognome, codice fiscale, indirizzo, indirizzo email, password, data di nascita.
    * Dopodichè viene eseguito un controllo del codice fiscale: se il codice fiscale è stato già utilizzato 
    * l'utente verrà avvisato, se non è stato utilizzato si procederà alla registrazione dell'utente su file.
    * @throws IOException 
    */ 
   public void registraNuovoUtente() throws IOException{
    String userId,nome,cognome,cf,indirizzo,email,pswd,dataNascita;

    System.out.print("\n"+"INSERIMENTO DATI UTENTE \n");
    System.out.print("-----------------------" + "\n");

    cf = setCFUser();
    if (userCFSigned(cf)) {
      System.out.println("utente già registrato!\n");
      //System.out.println("Vuole effettuare l' accesso?\n"+"  Si -> s"+"  No->quasiasi tasto \n");
      //if == s ->accessoUtente() -> futura implementazione
      return ;
    }
    nome = setNome();
    cognome = setCognome();
    dataNascita = setBirthDate();
    indirizzo = setInd();
    userId = setUserID();
    email = setMail();
    pswd = setPassword();

    salvaUtenteSuFile(componiStringa(cf,nome,cognome,dataNascita,indirizzo,userId,email,pswd));
  }


    /**
     * Il metodo restituisce una stringa formata dall'userId, password, codice fiscale, nome, cognome,
     * data di Nascita, email, indirizzio, su un'unica riga separati dal simbolo ";".
     * @param cf Il codice fiscale dell'utente.
     * @param nome Il nome dell'utente.
     * @param cognome Il cognome dell'utente.
     * @param dataNascita La data di nascita dell'utente.
     * @param indirizzo L'indirizzo dell'utente.
     * @param userId L'userid dell'utente.
     * @param email L'email dell'utente.
     * @param pswd La password dell'utente.
     * @return Una stringa formata dai parametri.
     */
    public String componiStringa(String cf,String nome,String cognome,String dataNascita,String indirizzo,String userId,String email,String pswd) {
        return userId +";"+ pswd +";"+ cf +";"+ nome +";"+ cognome +";"+ dataNascita +";"+ email +";"+ indirizzo + ";"+"\r";
    }

     /**
     * Il metodo si occupa di scrivere il proprio parametro sul file utentiRegistrati.
     * @param testoDaScrivere - Prende la stringa con i dati dell'utente.
     * @throws IOException 
     */
    public void salvaUtenteSuFile(String testoDaScrivere) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(utentiRegistrati,true));
        bufferedWriter.write(testoDaScrivere);
        bufferedWriter.close();
        System.out.println("Utente registrato con successo");
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
     private String setNome(){
        String nome = null;
        boolean valid = true;
        do{
            System.out.print("Inserisca il suo primo nome:");
            nome = new Scanner(System.in).nextLine();
            if (nome.length()>20||nome.length()<3||nome.isEmpty()||nome.matches(".*\\d.*")) {
                valid = false;
                System.out.println("nome non valido");
             }else{
                valid=true;
             }
        }while(!valid);
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
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
    private String setCognome(){
        String cognome = null;
        boolean valid = true;
        do{
            System.out.print("Inserisca il suo primo cognome:");
            cognome = new Scanner(System.in).nextLine();
            if (cognome.length()>20||cognome.length()<3||cognome.isEmpty()||cognome.matches(".*\\d.*")) {
                valid = false;
                System.out.println("nome non valido");
            }else{
                valid=true;
            }
        }while(!valid);
        return cognome.substring(0, 1).toUpperCase() + cognome.substring(1).toLowerCase();
    }
    
    /**
     * Il metodo si occupa di chiedere all'utente di inserire il suo indirizzo; 
     * se il campo non è vuoto, verrà assegnato alla stringa.
     * @return l'indirizzo dell'utente scritto in minuscolo.
     */
    private String setInd(){
        boolean valid = true;
        String indirizzo = null;
        do{
            System.out.print("Inserisca il suo indirizzo di residenza,\n"+"(via/piazza, numero civico, cap, comune, provincia): ");
		  indirizzo = new Scanner(System.in).nextLine();
             if(indirizzo.isEmpty()){
             System.out.print("Questo campo deve essere compilato! ");
            valid = false;
            }
         }while(!valid);
         return indirizzo.toLowerCase();
         }

/**
* Il metodo si occupa di far inserire la Password
* all'utente e di verificare che rispetti i requisiti.
* Inoltre verifica che l'utente abbia inserito la stessa password entrambe le volte.
* @throws PatternSyntaxException
* @return la password inserita dall'utente. 
**/
  private String setPassword() throws PatternSyntaxException{
    String password,passwordCtrl;
    System.out.println("Scelga una password:");
    do{
      System.out.println("Minimo 8 - massimo 20 caratteri,\n"+"una minuscola, una maiuscola, un numero \n "+"ed almeno un carattere speciale tra: @#$%^&+=");
      password = new Scanner(System.in).nextLine();
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
      while(!(m.matches())){
        System.out.println("Password non valida! \n"+" Prego inserire una password valida:");
        System.out.println("Minimo 8 - massimo 20 caratteri,\n"+"una minuscola, una maiuscola, un numero \n "+"ed almeno un carattere speciale tra: @#$%^&+=");
        password = new Scanner(System.in).nextLine();
        m = p.matcher(password);
      }
      
    /**
    *Per verificare che l'utente ricordi la password inserita
    *gli si chiede di reinserirla, per poi successivamente confrontarla con la prima.
    **/
      System.out.println("Reinserisca la password per verificare se è stata scritta correttamente");
      passwordCtrl = new Scanner(System.in).nextLine();
      if(!password.equals(passwordCtrl)){
        System.out.println("Le password non coincidono! \n"+"reinserisca la password: ");
      }
   } while(!password.equals(passwordCtrl));
   return password;
  }

    /**
    * Il metodo si occupa di chiedere l'email all'utente, e di controllare la sua 
    * validita.
    * @return l'email dell'utente.
    * @throws PatternSyntaxException 
    */
  private String setMail() throws PatternSyntaxException{
    String mail;
    System.out.println("Inserire un indirizzo email valido:");
      mail = new Scanner(System.in).nextLine();
    // Regex to check valid password.
      String regex = "^(.+)@(.+)$";
    // Compile the ReGex
      Pattern p = Pattern.compile(regex);
    // Pattern class contains matcher() method to find matching between given password and regular expression.
      Matcher m = p.matcher(mail);
    // Nel caso la password non rispettasse i requisiti
      while(!(m.matches())){
        System.out.println("Indirizzo mail non valido:");
        System.out.println("Inserire un indirizzo email valido:");
        mail = new Scanner(System.in).nextLine();
        m = p.matcher(mail);
      }
      return mail;
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
  private String setCFUser() throws PatternSyntaxException{
    String cf;
    System.out.println("Inserisca il suo codice fiscale:");
    cf = new Scanner(System.in).nextLine().toUpperCase();
    
    String regex = "^([A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1})$|([0-9]{11})$";
    /** compila il pattern precedente **/
    Pattern p = Pattern.compile(regex);
    /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
    Matcher m = p.matcher(cf);
    /**
    * Questa parte del codice gestisce la situazione
    * nel caso in cui il codice fiscale non rispetti il pattern.
    **/
    while(!(m.matches())){
      System.out.println("Codice fiscale errato! \n"+" Prego reinserire un codice fiscale valido "+"(formato Italiano):");
      cf = new Scanner(System.in).nextLine();
      m = p.matcher(cf);
    }
   return cf.toUpperCase();
  }

  /**
   * Il metodo si occupa di chiedere all'utente la data di nascita, 
   * nel formato: GG/MM/AAAA; dopodichè verrà eseguito un controllo con il codice fiscale.
   * @return la data di nascita dell'utente.
   * @throws PatternSyntaxException 
   */
  private String setBirthDate() throws PatternSyntaxException {
    String date;
    boolean valid = false;

    do{
      System.out.println("Inserisca la sua data di nascita (gg/mm/aaaa)");
      date = new Scanner(System.in).nextLine();
      String regex = "^([0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4})$";
      /** compila il pattern precedente **/
      Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
      Matcher m = p.matcher(date);
      if (!m.matches()) {
        System.out.println("Formato data errato! \n");
      }
      valid = m.matches();
    } while(!valid);
    return date;
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
  private String setUserID() throws FileNotFoundException{
    String id;
    boolean valid;
    do{

      do{
        System.out.println("Scelga un user ID;\n"+"sara neccessario per il suo accesso!\n"+"Max 10 caratteri, minimo 3 caratteri, niente spazi vuoti ammessi:");
        id = new Scanner(System.in).nextLine();
        if (id.length()<3||id.length()>10||id.contains(" ")) {
          System.out.println("User ID scelto non valido!");
          valid = false;
        }else {valid = true;}
      } while(!valid);

      if (userIDTaken(id)) {
        System.out.println("User ID già registrato!");
        valid=false;
      }

    } while (!valid);
    return id;
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
