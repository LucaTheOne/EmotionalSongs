package emotionalsongs;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * La classe si occupa di creare l'oggetto Utente con i parametri : userID, password, codice fiscale,
 * data di nascita, email, indirizzio, ed implementa i metodi di registrazione e controllo dei parametri dell'oggetto Utente.
 * @author Luca
 * @version 1.2.
 */
public class Utente {
    //campi
    //boolean autenticated = false;
    private String userId,nome,cognome,cf,indirizzo,email,password,dataNascita;
    private ArrayList<Playlist> playlistSet; 

    /**
     * Costruice l'oggetto Utente.
     * @param userId - userId dell'utente.
     * @param password - password dell'utente.
     * @param cf - codice fiscale dell'utente.
     * @param nome - il primo nome dell'utente.
     * @param cognome - il primo cognome dell'utente.
     * @param dataNascita - la data di nascita dell'utente.
     * @param email - l'email dell'utente.
     * @param indirizzo  - indirizzio dell'utente.
     */
    Utente(String userId, String password,String cf,String nome,String cognome,String dataNascita,String email,String indirizzo){
        this.userId = userId;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.indirizzo = indirizzo;
        this.email = email;
        this.password = password;
        this.dataNascita = dataNascita;
        
    }
    
    /**
     * Il metodo crea un nuovo oggetto regEngine in cui verrà registrato i dati
     * del nuovo utente.
     * @throws IOException 
     */
    static public void Registrazione() throws IOException {
        RegistrationPerformer regEngine = new RegistrationPerformer();
        regEngine.registraNuovoUtente();
    }
    
    /**
     * Il metodo stampa sul termine: Codice fiscale, Nome, Cognome, Data di nascita, Indirizzio, ID Utente, Email, Password.
     */
    public void stampaUtenteSuTerminale() {
        System.out.println("Codice fiscale: " + cf);
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Data di Nascita: " + dataNascita);
        System.out.println("Indirizzo: " + indirizzo);
        System.out.println("ID Utente: " + userId); 
        System.out.println("email: " + email);
        System.out.println("Password: " + password);
    }
    
    /**
      * Il metodo si occupa di chiedere all'utente di inserire il suo primo nome, succesivamente
      * effettuera un controllo, dove : non deve superare 20 caratteri, non deve avere meno di 3 caratteri,
      * non deve essere vuoto e non deve contenere caratteri (.*\\d.*), se rispetta le 4 condizioni il boolean creato all'inizio
      * del metodo tornera true e il nome dell'utente verrà assegnato alla stringa.
      * @return il nome dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
      */
    static private String setNome(){
        String nome = null;
        boolean valid = true;
        do{
            System.out.println("Inserisca il suo primo nome:");
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
      * Il metodo si occupa di chiedere all'utente di inserire il suo primo cognome, succesivamente
      * effettuera un controllo, dove : non deve superare 20 caratteri, non deve avere meno di 3 caratteri,
      * non deve essere vuoto e non deve contenere caratteri (.*\\d.*), se rispetta le 4 condizioni il boolean creato all'inizio
      * del metodo tornera true e il nome dell'utente verrà assegnato alla stringa.
      * @return il Cognome dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
      */
    static private String setCognome(){
        String cognome = null;
        boolean valid = true;
        do{
            System.out.println("Inserisca il suo primo cognome:");
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
     * Il metodo si occupa di chiedere all'utente di inserire il suo indirizzio, 
     * se il campo non è vuoto, verrà assegnato alla stringa.
     * @return l'indirizzio dell'utente scritto in minuscolo.
     */
    static private String setInd(){
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
    * metodo che si occupa di far inserire la Password
    * al utente e di verificarne che rispetti i requisiti.
    * Inoltre verifica anche che l'utente non abbia sbagliato a scriverla nel primo inserimento
    * mediante confronto.
    * @throws PatternSyntaxException
    * @return la password inserità dall'utente. 
    **/
    static private String setPassword() throws PatternSyntaxException{
        String password,passwordCtrl;
        System.out.println("Scelga una password:");
        do{
            System.out.println("Minimo 8 - massimo 20 caratteri,\n"+"una minuscola, una maiuscola, un numero \n "+"ed almeno un carattere speciale tra: @#$%^&+=");
            password = new Scanner(System.in).nextLine();
    /**
    * Stringa contenente i tipi di caratteri da controllare ve ne sia la presenza
    * di almeno uno per tipologia:
    * (?=.*[0-9]) -> almeno un numero tra 0 e 9,
    * (?=.*[a-z]) -> Almeno una lettera minuscola,
    * (?=.*[A-Z]) -> Almeno una lettera maiuscola,
    * (?=.*[@#$%^&+=!]) -> almeno uno dei seguenti caratteri speciali @#$%^&+=!,
    * (?=\\S+$) -> spazi bianchi non ammessi,
    * {8,20} -> minimo 8, massimo 20 caratteri.
    **/
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}";
    /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
    /** Pattern class contiene il metodo .matcher() per verificare se la password coincide con il pattern.**/
        Matcher m = p.matcher(password);
    /**
    * Questa parte del codice gestissce la situazione
    * nel caso la password non rispettasse tutti i requisiti
    **/
        while(!(m.matches())){
            System.out.println("Password non valida! \n"+" Prego inserire una password valida: ");
            System.out.println("Minimo 8 - massimo 20 caratteri,\n"+"una minuscola, una maiuscola, un numero \n "+"ed almeno un carattere speciale tra: @#$%^&+=");
            password = new Scanner(System.in).nextLine();
            m = p.matcher(password);
        }
    /**
    *Per verificare che l' utente sappia che password abbia inserito
    *gli si chiede di reinserirle per poi successivamente confrontarla
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
    * Il metodo si occupa si far inserire l'email all'utente, e di controllare la sua 
    * validita.
    * @return l'email dell'utente.
    * @throws PatternSyntaxException 
    */
    static private String setMail() throws PatternSyntaxException{
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
    
    
    static private String setCFUser() throws PatternSyntaxException{
        String cf;
        System.out.println("Inserisca il suo codice fiscale:");
        cf = new Scanner(System.in).nextLine().toUpperCase();
    /**
    * Stringa contenente i tipi di caratteri ed il formato
    * che deve presentare un codice fiscale italiano corretto:
    * [A-Za-z]{6} -> 6 lettere dell' alfabeto da a a z.
    * [0-9lmnpqrstuvLMNPQRSTUV]{2} -> due valori tra 0-9 o lmnpqrstuv.
    * [abcdehlmprstABCDEHLMPRST]{1} -> una lettera tra abcdehlmprst
    * [0-9lmnpqrstuvLMNPQRSTUV]{3} -> nuovamente tre valori tra 0-9 o lmnpqrstuv.
    * [A-Za-z]{1} -> una lettera del alfabeto.
    **/
        String regex = "^([A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1})$|([0-9]{11})$";
    /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
    /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(cf);
    /**
    * Questa parte del codice gestissce la situazione
    * nel caso il cf non rispettasse il pattern
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
   * il formato da rispettare: GG/MM/AAAA , succesivamente si eseguira un controllo 
   * con il codice fiscale.
   * @return la data di nascita dell'utente.
   * @throws PatternSyntaxException 
   */
    static private String setBirthDate() throws PatternSyntaxException {
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
   * @return true - se codice fiscale è presente nella database, false - se il codice fiscal non è presente nella database.
   * @throws FileNotFoundException 
   */  
    static private boolean userCFSigned(String cf) throws FileNotFoundException{
    
            String fileUtenti = "../data/UtentiRegistrati.dati.csv";
            Scanner inputStream = new Scanner(new FileReader(fileUtenti));
            inputStream.useDelimiter("\n");

            while(inputStream.hasNext()){
            String line = inputStream.next();//prendo l' intera linea
            if(line.contains("Codice fiscale:")){
                if (line.contains(cf)) {
                inputStream.close();
                return true;
                }
            }
        }
        return false;
    }
    
   /**
   * Il metodo si occupa di chiedere all'utente di inserire il userID, 
   * l'userID inserito non deve: essere composto da meno di 3 caratteri o da più di 10 caratteri,
   * non deve contenere spazzi, se rispetta queste tre condizioni, l'userID sarà registrato.
   * @return - userID dell'utente.
   * @throws FileNotFoundException 
   */
    static private String setUserID() throws FileNotFoundException{
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
   * Il metodo si occupa di controllare se l'userID inserito dall'utente non sià 
   * già registrato.
   * @param id - userID dell'utente.
   * @return true - se l'userid è presente nella database, false - se l'userID non è presente nella database.
   * @throws FileNotFoundException 
   */
    static private boolean userIDTaken(String id) throws FileNotFoundException {
            String fileUtenti = "../data/UtentiRegistrati.dati.csv";
            Scanner inputStream = new Scanner(new FileReader(fileUtenti));
            inputStream.useDelimiter("\n");

            while(inputStream.hasNext()){
            int countline = 0;
            String line = inputStream.next();//prendo l' intera linea
            if(countline%9==0){
                if (line.contains(id)) {
                    inputStream.close();
                    return true;
                }
            }
            countline++;
            inputStream.close();
            }  
        return false;
    }
    
    /**
     * Il meteodo si occupa di creare la PlaylistSet vuota.
     * @param userId userID dell'utente.
     * @throws IOException 
     */
    static private void creaPlaylistSetVuoto(String userId) throws IOException{
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Utilities.pathToPlaylistDati,true));
      bufferedWriter.write("Proprietario: "+ userId + "/n"+"_.-._.-._.-._.-._.-._.-._\n");
      bufferedWriter.close();
      System.out.println("Spazio generato con successo");
  }
    
    /**
     * Il metodo restituisce il userID dell'utente.
     * @return userId dell'utente che esegue il metodo.
     */
    public String getUserId(){
    return userId;
  }
    
    /**
     * Il metodo restiuisce il nome dell'utente.
     * @return  nome dell'utente che esegue il metodo.
     */
    public String getNome(){
    return nome;
  }
    
    /**
     * Il metodo restiusice il cognome dell'utente.
     * @return cognome dell'utente che esegue il metodo.
     */
    public String getCognome(){
    return cognome;
  }

    /**
     * Il metodo restituisce il codice fiscale dell'utente.
     * @return codice fiscale dell'utente che esegue il metodo.
     */
    public String getCF(){
    return cf;
  }
    
    /**
     * Il metodo restituisce l'indirzio dell'utente.
     * @return indirizzio dell'utente che esegue il metodo.
     */
    public String getIndirizzo(){
    return indirizzo;
  }
    
    /**
     * Il metodo restituisce l'email dell'utente.
     * @return l'email dell'utente che esegue il metodo.
     */
    public String getEmail(){
    return email;
  }
    
    /**
     * Il metodo restituisce la data di nascia dell'utente.
     * @return data di nascita dell'utente che esegue il metodo.
     */
    public String getDataDiNascita(){
    return dataNascita;
  }
    
     /**
     * Il metodo aggiunge una nuova playlist.
     * @param addplay
     */
    public void addToPlaylistSet(Playlist addplay){
        playlistSet.add(addplay);
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
}

