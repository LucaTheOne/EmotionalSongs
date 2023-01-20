//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.basic_structures;

import emotionalsongs.data_structures.*;
import emotionalsongs.engines.*;


/**
 * <h3> Descrizione: </h3>
 * Classe le cui istanze rappresentano un utente.
 */
public class User {
    //campi
    private String userId,name,surname,cf,address,email,password,birthDate;
    /**
     * Costruice un istanza di Utente.
     * @param userId - userId dell'utente.
     * @param password - password dell'utente.
     * @param cf - codice fiscale dell'utente.
     * @param name - il primo name dell'utente.
     * @param surname - il primo surname dell'utente.
     * @param birthDate - la data di nascita dell'utente.
     * @param email - l'email dell'utente.
     * @param address  - indirizzio dell'utente.
     */
    public User(String userId, String password,String cf,String name,String surname,String birthDate,String email,String address){
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.cf = cf;
        this.address = address;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;    
    }
    
    //metodi getter
    /**
     * Il metodo restituisce l'userID dell'utente.
     * @return userId - userID dell'utente.
     */
    public String getUserId(){
        return userId;
    }
    
    /**
     * Il metodo restiuisce il name dell'utente.
     * @return  name - name dell'utente.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Il metodo restituisce il surname dell'utente.
     * @return surname -  surname dell'utente.
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Il metodo restituisce il codice fiscale dell'utente.
     * @return cf - codice fiscale dell'utente.
     */
    public String getCF(){
        return cf;
    }
    
    /**
     * Il metodo restituisce l'address dell'utente.
     * @return address - address dell'utente.
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * Il metodo restituisce l'email dell'utente.
     * @return email - l'email dell'utente.
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Il metodo restituisce la data di nascita dell'utente.
     * @return birthDate - la data di nascita dell'utente.
     */
    public String getBirthDate(){
        return birthDate;
    }
    
    /**
     * Il metodo restituisce la password dell'utente.
     * @return password - password dell'utente.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Il metodo ritorna l'istanza di PlaylistSet contenente l' insieme di istanze di Playlist associate all' istanza di user che ne richiama il metodo.
     * @return PlaylistSet del utente.
     */
    public PlaylistsSet getPlaylistSet(){
        EngineSearcher searcher = new EngineSearcher();
        return searcher.searchUserSet(this, DataBasePlaylists.getInstance());
    }
    
    //modifyng method for a future service's implementation   
    
    /*
      * Il metodo si occupa di chiedere all'utente di inserire il suo primo name; succesivamente
      * effettua un controllo. Il name non deve : 
      * <ul>
      * <li>superare 20 caratteri.
      * <li>avere meno di 3 caratteri.
      * <li>essere vuoto.
      * <li>contenere caratteri (.*\\d.*).
      * </ul>
      * Se rispetta le 4 condizioni il boolean creato all'inizio
      * del metodo tornerà true e il name dell'utente verrà assegnato alla stringa.
      * @return il name dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
      */
    /* 
    private void setNewNome(String name){
        if(!name.isBlank()){
            this.name = name;
        }
    }
    */
    /*
      * Il metodo si occupa di chiedere all'utente di inserire il primo surname; succesivamente
      * effettua un controllo. Il surname non deve : 
      * <ul>
      * <li>superare 20 caratteri.
      * <li>avere meno di 3 caratteri.
      * <li>essere vuoto.
      * <li>contenere caratteri (.*\\d.*).
      * </ul>
      * Se rispetta le 4 condizioni il boolean creato all'inizio
      * del metodo tornerà true e il surname dell'utente verrà assegnato alla stringa.
      * @return il Cognome dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
    */
    /*
    private void setNewCognome(String surname){
        if(!surname.isBlank()){
            this.surname = surname;
        }
    }
    */
     /**
     * Il metodo si occupa di chiedere all'utente di inserire il suo indirizzo, 
     * se il campo non è vuoto, verrà assegnato alla stringa.
     * @return l'indirizzio dell'utente scritto in minuscolo.
     */
    /* 
    private void setNewInd(String address){
        if(!address.isBlank()){
            this.address = address;
        }
    }
    */
    /*
    * Il metodo si occupa di far inserire la Password
    * all'utente e di verificare che rispetti i requisiti.
    * Inoltre verifica anche che l'utente non abbia sbagliato a scriverla nel primo inserimento
    * mediante confronto.
    * @throws PatternSyntaxException
    * @return la password inserita dall'utente. 
    */
    /* 
    private void setNewPassword(String password, String controllo) {
        EngineChecker checker = new EngineChecker();
        if (checker.checkPasswordValidity(password)) {
            if(checker.passwordsMatch(password, controllo)){
                this.password = password;
            } else {
                //avvisa password non coincidenti
            }
                
        } else {
            //avvisa password non valida
        }
    }
    */
    /*
    * Il metodo si occupa si far inserire l'email all'utente, e di controllare la sua 
    * validità.
    * @return l'email dell'utente.
    * @throws PatternSyntaxException 
    */
    /* 
    private void setNewMail(String email) throws PatternSyntaxException{
        EngineChecker checker = new EngineChecker();
        if(checker.checkMailValidity(email)){
            this.email = email;
        }
    }
    */
   /*
   * Il metodo si occupa di chiedere all'utente la data di nascita, 
   * nel formato: GG/MM/AAAA; dopodichè verrà eseguito un controllo con il codice fiscale.
   * @return la data di nascita dell'utente.
   * @throws PatternSyntaxException 
   */
    /* 
    private void setNewBirthDate(String birthdate) throws PatternSyntaxException {
        EngineChecker checker = new EngineChecker();
        if(checker.checkBirthDayValidity(birthdate)){
            birthDate = birthdate;
        }
    }
    */
   /**
   * Il metodo si occupa di chiedere all'utente di inserire l'userID.L'userID inserito non deve: 
    <ul>
    <li>essere composto da meno di 3 caratteri o da più di 10 caratteri,
    <li>non deve contenere spazi. </ul>
   * Se rispetta queste tre condizioni, l'userID sarà registrato.
   * @return - userID dell'utente. 
   */
  /* 
    private void setNewUserID(String userId) throws FileNotFoundException{
        EngineChecker checker = new EngineChecker();
        if(checker.checkIdValidity(userId)){
            if(checker.checkIdNotTaken(DataBaseUsers.getInstance(), userId)){
                this.userId = userId;
            }
        }
    }
    */
    //metodi di composizione
    /*
     * Il metodo restituisce una stringa formata dall'userId, password, codice fiscale, name, surname,
     * data di Nascita, email, indirizzio, su un'unica riga separati dal simbolo ";".
     * Questo è il formato in cui gli utenti vengono salvati sul file Utenti.dati.txt.
     * @param cf Il codice fiscale dell'utente.
     * @param name Il nome dell'utente.
     * @param surname Il cognome dell'utente.
     * @param birthDate La data di nascita dell'utente.
     * @param address L'indirizzo di residenza dell'utente.
     * @param userId L'userid dell'utente.
     * @param email L'email dell'utente.
     * @param pswd La password dell'utente.
     * @return Una stringa formattata per il file UtentiRegistrati.dati.txt.
     */
    public String componiStringa() {
        return userId +";"+ password +";"+ cf +";"+ name +";"+ surname +";"+ birthDate +";"+ email +";"+ address + ";"+"\r";
    }
    
    //metodi di comparazione
    /**
     * 
     * @param user Istanza di User.
     * @return <ul>
     * <li><b>Un intero negativo</b> se l'id dell' istanza di User che chiama il metodo è <b>lessicograficamente precedente</b> l'id dell' istanza di User passata come argomento.</li>
     * <li><b>Un intero positivo</b> se l'id dell' istanza di User che chiama il metodo è <b>lessicograficamente seguente</b> l'id dell' istanza di User passata come argomento.</li>
     * <li>Zero se sono uguali. </li>
     * </ul>
     */
    public int compareId(User user) {
        return this.userId.compareToIgnoreCase(user.getUserId());
    }
    
    /**
     * 
     * @param user Istanza di User
     * @return <ul>
     * <li><b>Un intero negativo</b> se l'id dell' istanza di User che chiama il metodo è <b>lessicograficamente precedente</b> l'id dell' istanza di User passata come argomento.</li>
     * <li><b>Un intero positivo</b> se l'id dell' istanza di User che chiama il metodo è <b>lessicograficamente seguente</b> l'id dell' istanza di User passata come argomento.</li>
     * <li>Zero se sono uguali. </li>
     * </ul>
     */
    public int compareCf(User user) {
        return this.cf.compareToIgnoreCase(user.getCF());
    }
}

