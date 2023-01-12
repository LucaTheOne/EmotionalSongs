//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.BasicsStructure;

import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import java.io.*;
import java.util.regex.*;

/**
 * La classe si occupa di creare l'oggetto User con i suoi parametri, 
 ed implementa i metodi di registrazione e controllo dei parametri dell'oggetto User.
 * @author Luca
 * @version 1.2.
 */
public class User {
    //campi
    //boolean autenticated = false;
    private String userId,nome,cognome,cf,indirizzo,email,password,dataNascita;
    private PlaylistSet playlistSet; 

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
    public User(String userId, String password,String cf,String nome,String cognome,String dataNascita,String email,String indirizzo){
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
      * Il metodo si occupa di chiedere all'utente di inserire il suo primo nome; succesivamente
      * effettua un controllo. Il nome non deve : 
      * <ul>
      * <li>superare 20 caratteri.
      * <li>avere meno di 3 caratteri.
      * <li>essere vuoto.
      * <li>contenere caratteri (.*\\d.*).
      * </ul>
      * Se rispetta le 4 condizioni il boolean creato all'inizio
      * del metodo tornerà true e il nome dell'utente verrà assegnato alla stringa.
      * @return il nome dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
      */
    private void setNewNome(String nome){
        if(!nome.isBlank()){
            this.nome = nome;
        }
    }
    
    /**
      * Il metodo si occupa di chiedere all'utente di inserire il primo cognome; succesivamente
      * effettua un controllo. Il cognome non deve : 
      * <ul>
      * <li>superare 20 caratteri.
      * <li>avere meno di 3 caratteri.
      * <li>essere vuoto.
      * <li>contenere caratteri (.*\\d.*).
      * </ul>
      * Se rispetta le 4 condizioni il boolean creato all'inizio
      * del metodo tornerà true e il cognome dell'utente verrà assegnato alla stringa.
      * @return il Cognome dell'utente con la prima lettera in maiuscolo e le successive in minuscolo.
      */
    private void setNewCognome(String Cognome){
        if(!Cognome.isBlank()){
            this.cognome = cognome;
        }
    }
    
     /**
     * Il metodo si occupa di chiedere all'utente di inserire il suo indirizzo, 
     * se il campo non è vuoto, verrà assegnato alla stringa.
     * @return l'indirizzio dell'utente scritto in minuscolo.
     */
    private void setNewInd(String indirizzo){
        if(!indirizzo.isBlank()){
            this.indirizzo = indirizzo;
        }
    }
    
    /**
    * Il metodo si occupa di far inserire la Password
    * all'utente e di verificare che rispetti i requisiti.
    * Inoltre verifica anche che l'utente non abbia sbagliato a scriverla nel primo inserimento
    * mediante confronto.
    * @throws PatternSyntaxException
    * @return la password inserita dall'utente. 
    **/
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
    
    /**
    * Il metodo si occupa si far inserire l'email all'utente, e di controllare la sua 
    * validità.
    * @return l'email dell'utente.
    * @throws PatternSyntaxException 
    */
    private void setNewMail(String email) throws PatternSyntaxException{
        EngineChecker checker = new EngineChecker();
        if(checker.checkMailValidity(email)){
            this.email = email;
        }
    }
    
   /**
   * Il metodo si occupa di chiedere all'utente la data di nascita, 
   * nel formato: GG/MM/AAAA; dopodichè verrà eseguito un controllo con il codice fiscale.
   * @return la data di nascita dell'utente.
   * @throws PatternSyntaxException 
   */
    private void setNewBirthDate(String birthdate) throws PatternSyntaxException {
        EngineChecker checker = new EngineChecker();
        if(checker.checkBirthDayValidity(birthdate)){
            dataNascita = birthdate;
        }
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
    private void setNewUserID(String UserId) throws FileNotFoundException{
        EngineChecker checker = new EngineChecker();
        if(checker.checkIdValidity(UserId)){
            if(checker.checkIdNotTaken(DataBaseUsers.getInstance(), userId)){
                this.userId = userId;
            }
        }
    }
    
    /**
     * Il meteodo si occupa di creare la PlaylistSet vuota.
     * @param userId - userID dell'utente.
     * @throws IOException 
     */
    static private void creaPlaylistSetVuoto(String userId) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Utilities.pathToPlaylistDati,true));
        bufferedWriter.write("Proprietario: "+ userId + "/n"+"_.-._.-._.-._.-._.-._.-._\n");
        bufferedWriter.close();
        System.out.println("Spazio generato con successo");
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
     * Il metodo restiuisce il nome dell'utente.
     * @return  nome - nome dell'utente.
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Il metodo restituisce il cognome dell'utente.
     * @return cognome -  cognome dell'utente.
     */
    public String getCognome(){
        return cognome;
    }

    /**
     * Il metodo restituisce il codice fiscale dell'utente.
     * @return cf - codice fiscale dell'utente.
     */
    public String getCF(){
        return cf;
    }
    
    /**
     * Il metodo restituisce l'indirizzo dell'utente.
     * @return indirizzo - indirizzo dell'utente.
     */
    public String getIndirizzo(){
        return indirizzo;
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
     * @return dataNascita - la data di nascita dell'utente.
     */
    public String getDataDiNascita(){
        return dataNascita;
    }
    
    /**
     * Il metodo restituisce la password dell'utente.
     * @return password - password dell'utente.
     */
    public String getPassword() {
        return password;
    }
    
    public PlaylistSet getPlaylistSet(){
        EngineSearcher searcher = new EngineSearcher();
        return searcher.searchUserSet(this, DataBasePlaylists.getInstance());
    }
    
    //modifyng method
    
    
     /**
     * Il metodo aggiunge una nuova playlist.
     * @param addplay
     */
    public void addToPlaylistSet(Playlist addplay){
        playlistSet.addPlaylist(addplay);
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
    public String componiStringa() {
        return userId +";"+ password +";"+ cf +";"+ nome +";"+ cognome +";"+ dataNascita +";"+ email +";"+ indirizzo + ";"+"\r";
    }

    public int compareId(User user) {
        return this.userId.compareToIgnoreCase(user.getUserId());
    }
    
    public int compareCf(User user) {
        return this.cf.compareToIgnoreCase(user.getCF());
    }
}

