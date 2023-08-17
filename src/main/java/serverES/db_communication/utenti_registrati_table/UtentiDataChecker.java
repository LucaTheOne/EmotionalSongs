/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_communication.utenti_registrati_table;

import serverES.ServerUtils;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.regex.*;
import serverES.db_communication.*;
import serverES.services_common_interfaces.data_validator.*;

/**
 *
 * @author big
 */
public class UtentiDataChecker extends UnicastRemoteObject implements UsersDataValidator{
    
    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    /**
     * Metodo privato che controlla la validita morfologica di un indirizzo email
     * @param email
     * @return 
     */
    private boolean isValidMail(String email)
    {
        if(email == null) return false;
        // Regex to check valid password.
        String regex = "^(.+)@(.+)$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        // Pattern class contains matcher() method to find matching between given password and regular expression.
        Matcher m = p.matcher(email);
        // Nel caso la password non rispettasse i requisiti
      
        return m.matches() && ServerUtils.isFitToPostgresql(email);
    }
    
    /**
    * Il metodo controlla la validità della password.
    * Per fare ciò sfrutta le regular expressions (regex),
    * tramite cui viene effettuato un controllo sulla presenza
    * di almeno un'occorrenza, nella password analizzata, di:
    * <ul>
    * <li>(?=.*[0-9]) -> almeno un numero tra 0 e 9,
    * <li>(?=.*[a-z]) -> almeno una lettera minuscola,
    * <li>(?=.*[A-Z]) -> almeno una lettera maiuscola,
    * <li> almeno un carattere speciale,
    * <li>(?=\\S+$) -> spazi bianchi non ammessi,
    * <li>{8,20} -> minimo 8, massimo 20 caratteri.
    * </ul>
    * @param password Password da validare
    * @return True se la password rispetta tutti i criteri, false altrimenti.
    * 
    **/
    private boolean checkPasswordValidity(String password) throws PatternSyntaxException{ 
        if(password == null) return false;
    
        String regex = "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[@#$%^&+=!])" + "(?=\\S+$).{8,20}";
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
     * Metodo privato che controlla che la provincia sia scritta in maiuscolo
     * @param prov
     * @return 
     */
    private boolean verificaProvincia(String prov) {
        // Controlla se la stringa ha esattamente due caratteri
        return prov.length() != 2;
    }
    
    //Methods checking data validity
    /**
     * Il metodo convalida la stringa name passata come argomento
     * e restituisce false se:
     * <ul>
     *  <li>non e stato inserito nessun carattere.</li>
     *  <li>il numero di caratteri e maggiore di 20.</li>
     *  <li>il numero di caratteri è minore di 3.</li>
     *  <li>contiene caratteri speciali. </li>
     * </ul>
     * Altrimenti restituisce true.
     * @param name Nome dell'utente da validare.
     * @return True o False.
     */
    private boolean checkNameValidity(String name){
        if(name == null) return false;
        if (name.isBlank() || name.length()>20 || name.length()<2 || name.matches(".*\\d.*")) {
            return false;   
        }
        return true;
    }
    
    
    /**
     * Il metodo convalida la stringa surname passata come argomento restituisce false se:
     * <ul>
     * <li>non e stato inserito nessun carattere.</li>
     * <li>i caratteri sono più di 20.</li>
     * <li>i caratteri sono meno di 3.</li>
     * <li>contiene caratteri speciali. </li>
     * </ul>
     * Altrimenti restituisce true.
     * @param surname cognome da convalidare.
     * @return True o False.
     */
    private boolean checkSurnameValidity(String surname){
        if(surname == null) return false;
        if (surname == null && surname.length()>20||surname.length()<2||surname.isBlank()||surname.matches(".*\\d.*")) {
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
    private boolean checkAddresValidity(String address){
        if(address == null) return false;
        if(address.isBlank()){
            return false;
        }
        return true;
    }
    
    /**
     * Metodo che valida il CF immesso dal nuovo utente, tramite Regular Expressions (regex).
     * @param cf da validare
     * @return true se valido, false altrimenti.
     * @throws PatternSyntaxException 
     */
    private boolean checkCfValidity(String cf) throws PatternSyntaxException {
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
     * 
     */
    private boolean checkBirthDayValidity(String birthDay) throws PatternSyntaxException {
        if(birthDay == null) return false;
        String regex = "^([0-9]{2}[/][0-9]{2}[/][0-9]{4})$";
      /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(birthDay);

        return m.matches();
    }
    
    /**
     * Metodo che convalida la validità dell'indirizzo.
     * Il formato supportato è: via/piazza/largo/... NomeStrada Civico Città CAP Provincia Nazione
     * @param indirizzo
     * @return true se è valida, false altrimenti
     */
    private boolean checkAddressValidity(String indirizzo) 
    {
        if(indirizzo == null) return false;
        String regex = "^([A-Za-z]{3,}" + "\s[A-Za-z]{2,}" + "\s[0-9]{1,4}" + "\s[A-Za-z]{2,}" + "\s[0-9]{5}" + "\s[A-Z]{2}" + "\s[A-Za-z]{4,})$";
        /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
        /** Pattern class contiene il metodo .matcher() per verificare se l'indirizzo coincide con il pattern.**/
        Matcher m = p.matcher(indirizzo);
        /**
        * Questa parte del codice gestisce la situazione
        * nel caso in cui l'indirizzo non rispetti il pattern.
        **/
        return m.matches();
    }
    
    
    private boolean checkUserId(String userId){
        return ( 
                (userId != null) && 
                (userId.length()>3) && 
                (userId.length()<20) && 
                (!userId.isBlank()) && 
                (ServerUtils.isFitToPostgresql(userId))
               );
    }
    
    public UtentiDataChecker(Connection Conn) throws RemoteException{
        super();
        CONNECTION_TO_DB = Conn;
    }
    
    //Riccardo
    /**
     * Metodo il quale controlla che i dati inseriti dal nuovo utente siano validi.Ritorna un array di booleani, il quale per ogni posizione identifica se un errore è occorso o meno.
     * @param userId Stringa contenente l' id del nuovo utente.
     * @param email Stringa contenente la mail del nuovo utente.
     * @param cf Stringa contenente il codice fiscale del nuovo utente.
     * @param password Stringa contenente la password scelta dal nuovo utente per l' accesso al suo account.
     * @param rePassword Stringa contenente per la verifica che la password inserita sia quella che l' utente voleva.
     * @param nome Stringa contenente il nome del nuovo utente.
     * @param cognome Stringa contenente il cognome del nuovo utente.
     * @param compleanno compleanno dell' utente formato dd/mm/yyyy.
     * @param indirizzo Stringa contenente l' indirizzo di residenza del nuovo utente.
     * @return 
     * false - dato non valido, true dato valido.
     * posizioni errori nell' array:
     * 0 - userId non valido.
     * 1 - userId già scelto da un altro utente.
     * 2 - codice fiscale non valido.
     * 3 - codice fiscale già presente nel DB.
     * 4 - password non valida.
     * 5 - password non coincidono.
     * 6 - nome non valido.
     * 7 - cognome non valido.
     * 8 - compleanno non valido.
     * 9 - indirizzo non valido.
     * @throws java.rmi.RemoteException
     */
    @Override
    public boolean[] validateNewUserData(
            String userId, 
            String email, 
            String cf, 
            String password, 
            String rePassword, 
            String nome, 
            String cognome, 
            String compleanno,
            String indirizzo
        ) throws RemoteException {
        boolean userIdValid = false,
                userIdAvailable = false,
                emailValid = false,
                emailNotPresent = false,
                cfValid = false,
                cfNotPresent = false,
                passwordValid = false, 
                passwordsMatch = false,
                nomeValid= false,
                cognomeValid= false,
                compleannoValid= false,
                indirizzoValid = false;
        try{
            //Inizializzazione
            String query;
            PreparedStatement statementControl;
            ResultSet resultSet;
            
            //Controllo dell'ID
            userIdValid = checkUserId(userId);
            
            //controllo la presenza dell' id nel DB
            query ="SELECT COUNT(ID_USER) FROM UTENTI_REGISTRATI WHERE ID_USER = ?;"; 
            statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, userId);
            resultSet = statementControl.executeQuery();
            resultSet.next(); //non ho capito cosa fa questo -> quando ottenuto, il result set punta alla posizione precedente al primo dato valido, quindio serve .next()
            
            userIdAvailable = resultSet.getInt(1) == 0;
            
            //Controllo della mail
            emailValid = isValidMail(email);
            if(!isValidMail(email)) {}
            else
            {
                query ="SELECT COUNT(EMAIL) FROM UTENTI_REGISTRATI WHERE EMAIL = ?;"; 
                statementControl = CONNECTION_TO_DB.prepareStatement(query);
                statementControl.setString(1, email);
                resultSet = statementControl.executeQuery();
                resultSet.next();
                emailNotPresent = resultSet.getInt(1) == 0; 
            }
            
            //Controllo del codice fiscale
            cfValid = checkCfValidity(cf);
            if(!cfValid){ }
            else {
                query ="SELECT CF FROM UTENTI_REGISTRATI WHERE CF = ?;"; 
                statementControl = CONNECTION_TO_DB.prepareStatement(query);
                statementControl.setString(1, cf);
                resultSet = statementControl.executeQuery();
                resultSet.next();
                cfNotPresent = resultSet.getInt(1) == 0;   
            }
            
            //Controllo Password
            passwordValid = checkPasswordValidity(password);
            passwordsMatch = password.equals(rePassword);
            
            //Controllo Nome
            nomeValid = checkNameValidity(nome);
            
            //Controllo Cognome
            cognomeValid = checkSurnameValidity(cognome);
            
            compleannoValid = checkBirthDayValidity(compleanno);
            
            //I controlli su indirizzo non hanno senso se non si integra un database stradale -> basta assicurarsi non sia vuoto.
            indirizzoValid = checkAddressValidity(indirizzo);    
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        boolean[] errors = new boolean[]{
            userIdValid,
            userIdAvailable,
            emailValid,
            emailNotPresent,
            cfValid,
            passwordValid,
            passwordsMatch,
            nomeValid,
            cognomeValid,
            compleannoValid,
            indirizzoValid
        };
        return reverseArrayValues(errors);
    }
    
    //Riccardo deve implementare
    /**
     * Metodo che verifica se un determinato utente (identificato dal CF) non abbia già espresso un parere
     * per una determinata canzone (identificata dal suo id).
     * @param userId Id dell'utente quale si vuole verificare la possibilità di voto.
     * @param songId Id della canzone da votare.
     * @return true se l' uente non ha già espresso un parere, false altrimenti.
     */
    @Override
    public boolean userCanVoteSong(String userId, String songId) throws RemoteException
    {
        try{
            //Inizializzazione
            String query;
            PreparedStatement statementControl;
            ResultSet resultSet;
            
            query ="SELECT COUNT(*) FROM EMOZIONI WHERE USER_PROP_ID = ? AND CANZONE_ID = ?;"; //chiedo al db quante righe ci sono corrispondenti al criterio di ricerca espresso nella query
            statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, userId);
            statementControl.setString(2, songId);
            resultSet = statementControl.executeQuery();
            resultSet.next();
            
            if(resultSet.getInt(1) == 0) //se ottengo esattamente 0, vuol dire che l' utente non ha già espresso un parere riguardo l' emozione, quindi può votarla.
                return true;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
        
    }
    
    //Riccardo deve implementare
    /**
     * Metodo per la verifica dei dati di login.
     * Ritorna un array di booleani in cui "false" rappresentano gli errori commessi, secondo la elegenda sottostante.
     * @param userId Stringa contenente l' user id del utente.
     * @param password Stringa contenente l'account id del utente.
     * @return
     * per ogni posizione dell' array: true errore occorso, false nessun errore occorso
     * posizioni errori:
     * 0 - id utente non presente nel DB.
     * 1 - Password errata.
     */
    @Override
    public boolean[] validateLogin(String userId, String password) throws RemoteException
    {
        boolean[] errors = new boolean[]{false,false};
        try{
            //Inizializzazione
            String query;
            PreparedStatement statementControl;
            ResultSet resultSet;            
            
            query = "SELECT COUNT(ID_USER) FROM UTENTI_REGISTRATI WHERE ID_USER = ?;";
            statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, userId);
            resultSet = statementControl.executeQuery();
            resultSet.next();
            
            if(!(resultSet.getInt(1)==1)){
                errors[0] = true;
                return errors;
            }else{
                statementControl.close();
                query ="SELECT PASSWORD FROM UTENTI_REGISTRATI WHERE ID_USER = ?;"; 
                statementControl = CONNECTION_TO_DB.prepareStatement(query);
                statementControl.setString(1, userId);
                resultSet = statementControl.executeQuery();
                resultSet.next();
            
                if(!(resultSet.getString(1).equals(password))) errors[1] = true;
            }   
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return errors;
    }
    
    private boolean[] reverseArrayValues(boolean[] arrayToReverse){
        boolean[] temp = new boolean[arrayToReverse.length];
        for(int i = 0; i<arrayToReverse.length;i++) 
            temp[i] = !arrayToReverse[i];
        return temp;
    }
    
    
    //public static void main(String[] args) throws RemoteException {
        //System.out.println(new UtentiDataChecker(DBConnector.getDefaultConnection()).userCanVoteSong("theOne","TRGDRZV128F92DC96D" ));
        /*
        boolean[] bool = new boolean[]{true,true,true,false,false};
        bool = reverseArrayValues(bool);
        System.out.print("[ ");
        for(boolean booleans: bool) {
            System.out.print(String.valueOf(booleans)+",");
        }
        System.out.println(" ]");
        */
    //} 
    
}
