/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_communication.utenti_registrati_table;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.regex.*;
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
    private boolean mailControl(String email)
    {
        char[] emailArray = email.toCharArray();
        int i;
        
        //Controllo la presenza di @
        for(i=1; i<email.length(); i++)
        {
            if(emailArray[i]=='@') break; //Se la trova esce dal ciclo
        }
        
        //Se è arrivato in fondo al ciclo vuol dire che non l'ha trovata: mail non valida
        if(i==email.length()) return false;  
        
        //Controllo la presenza del punto
        while(i<email.length()-2)
        {
            //Se lo trova all'interno del ciclo, la mail è valida
            if(emailArray[i] == '.') return true; 
        }
        
        //Se non ha fatto il return all'interno del ciclo, vuol dire che la mail non è valida
        return false;
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
    private static boolean checkPasswordValidity(String password) throws PatternSyntaxException{ 
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
    private static boolean verificaProvincia(String prov) {
        // Controlla se la stringa ha esattamente due caratteri
        if (prov.length() != 2) {
            return false;
        }

        // Controlla se entrambi i caratteri sono maiuscoli
        char char1 = prov.charAt(0);
        char char2 = prov.charAt(1);
        return Character.isUpperCase(char1) && Character.isUpperCase(char2);
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
    private static boolean checkNameValidity(String name){
        if(name == null) return false;
        if (name.isBlank()||name.length()>20||name.length()<2||name.matches(".*\\d.*")) {
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
    private static boolean checkSurnameValidity(String surname){
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
    private static boolean checkAddresValidity(String address){
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
    private static boolean checkCfValidity(String cf) throws PatternSyntaxException {
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
    private static boolean checkBirthDayValidity(String birthDay) throws PatternSyntaxException {
        if(birthDay == null) return false;
        String regex = "^([0-9]{2}[/][0-9]{2}[/][0-9]{4})$";
      /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(birthDay);

        return m.matches();
    }
    
    public UtentiDataChecker(Connection Conn) throws RemoteException{
        super();
        CONNECTION_TO_DB = Conn;
    }
    
    
    
    //Riccardo
    /**
     * Metodo il quale controlla che i dati inseriti dal nuovo utente siano validi.Ritorna un array di booleani in cui i "false" rappresentano gli errori occorsi.
     * @param userId Stringa contenente l' id del nuovo utente.
     * @param email Stringa contenente la mail del nuovo utente.
     * @param cf Stringa contenente il codice fiscale del nuovo utente.
     * @param password Stringa contenente la password scelta dal nuovo utente per l' accesso al suo account.
     * @param rePassword Stringa contenente per la verifica che la password inserita sia quella che l' utente voleva.
     * @param nome Stringa contenente il nome del nuovo utente.
     * @param cognome Stringa contenente il cognome del nuovo utente.
     * @param compleanno Stringa contenente la data di nascita
     * @param tipoIndirizzo Stringa contenente: "via" | "viale" | "piazza" | "piazzetta" | "salita" | "discesa".
     * @param indirizzo Stringa contenente l' indirizzo di residenza del nuovo utente.
     * @param civico Intero rappresentante il numero civico dell' indirizzo del nuovo utente.
     * @param cap Intero rappresentante il cap della citta di residenza del nuovo utente.
     * @param nazione Stringa contenente la nazione di residenza del nuovo utente.
     * @param provincia Stringa contenente la provincia di residenza del nuovo utente.
     * @param citta Stringa contenente la città di residenza del nuovo utente.
     * @return 
     * 0 - userId non valido.
     * 1 - userId già scelto da un altro utente.
     * 2 - email non valida.
     * 3 - email già presente nel DB.
     * 4 - codice fiscale non valido.
     * 5 - codice fiscale già presente nel DB.
     * 6 - password non valida.
     * 7 - password non coincidono.
     * 8 - nome non valido.
     * 9 - cognome non valido.
     * 10 - data di nascita non valida
     * 11 - tipo indirizzo non ammesso.
     * 12 - indirizzo non valido.
     * 13 - civico non valido.
     * 14 - cap non valido.
     * 15 - nazione non valida.
     * 16 - provincia non valida.
     * 17 - citta non valida.
     * @throws java.rmi.RemoteException
     */
    @Override
    public boolean[] validateNewUserData(String userId, String email, String cf, String password, String rePassword, String nome, String cognome, String compleanno, String tipoIndirizzo, String indirizzo, int civico, int cap, String nazione, String provincia, String citta) throws RemoteException
    {
        boolean[] errors = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
        boolean exception;
        try{
            //Inizializzazione
            String query;
            PreparedStatement statementControl;
            ResultSet resultSet;
            
            
            //Controllo dell'ID
            //Inserire controllo regole (quali sono?)
            query ="SELECT ID_USER FROM UTENTI_REGISTRATI WHERE ID_USER = ?;"; 
            statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, userId);
            resultSet = statementControl.executeQuery();
            //resultSet.next(); //non ho capito cosa fa questo
            
            if(resultSet!=null)
                errors[1]=true;
            
            //Controllo della mail
            if(!mailControl(email))
                errors[2]=true;
            else
            {
                query ="SELECT EMAIL FROM UTENTI_REGISTRATI WHERE EMAIL = ?;"; 
                statementControl = CONNECTION_TO_DB.prepareStatement(query);
                statementControl.setString(1, email);
                resultSet = statementControl.executeQuery();

                if(resultSet!=null)
                    errors[3]=true;
            }
            //Controllo del codice fiscale
            if(!checkCfValidity(cf))
                errors[4]=true;
            else
            {
                query ="SELECT CF FROM UTENTI_REGISTRATI WHERE CF = ?;"; 
                statementControl = CONNECTION_TO_DB.prepareStatement(query);
                statementControl.setString(1, cf);
                resultSet = statementControl.executeQuery();

                if(resultSet!=null)
                    errors[5]=true;
            }
            
            //Controllo Password
            if(!checkPasswordValidity(password))
                errors[6] = true;
            else if(!password.equals(rePassword))
                errors[7]=true;
            
            //Controllo Nome
            if(!checkNameValidity(nome))
                errors[8]=true;
            
            //Controllo Cognome
            if(!checkSurnameValidity(cognome))
                errors[9]=true;
            
            if(!checkBirthDayValidity(compleanno))
                errors[10]=true;
            
            //Tipo indirizzo non ha senso
            
            //I controlli su indirizzo non hanno senso se non si integra un database stradale
            //Nel dubbio controllo che i nomi delle vie abbiano almeno 3 lettere
            if(!checkAddresValidity(indirizzo))
                errors[12]=true;
            
            
            //Controllo che il civico non sia negativo 
            //(inserire eventuale interno?)
            if(civico<1)
                errors[13]=true;
            
            //Controllo CAP
            if(cap<10000 || cap >99999)
                errors[14]=true;
            
            //Controllo Nazione (è l'Oman quello con il nome più corto?)
            if(nazione.length()<4)
                errors[15]=true;
            
            //Controllo provincia
            if(!verificaProvincia(provincia))
                errors[16]=true;
            
            //Controllo città
            if(citta.length()<2)
                errors[17]=true;
            
            exception=false;
            
            
            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            exception=true;
            
        }
        
        //Inversione del vettore errors
        if(!exception)
            for(int j=0; j<17; j++)
                errors[j]=!errors[j];
        
        
        return errors;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            
            
            
            query ="SELECT USER_ID FROM EMOZIONI WHERE USER_PROP_ID = ? AND CANZONE_ID = ?;"; 
            statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, userId);
            statementControl.setString(2, songId);
            resultSet = statementControl.executeQuery();
            resultSet.next();
            
            if(resultSet==null)
                return true;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
        
        
        
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Riccardo deve implementare
    /**
     * Metodo per la verifica dei dati di login.
     * Ritorna un array di booleani in cui "false" rappresentano gli errori commessi, secondo la elegenda sottostante.
     * @param userId Stringa contenente l' user id del utente.
     * @param password Stringa contenente l'account id del utente.
     * @return
     * 0 - id utente non presente nel DB.
     * 1 - Password errata.
     */
    @Override
    public boolean[] validateLogin(String userId, String password) throws RemoteException
    {
        boolean[] errors = new boolean[]{false,false};
        boolean exception;
        try{
            //Inizializzazione
            String query;
            PreparedStatement statementControl;
            ResultSet resultSet;
            
            
            
            query ="SELECT PASSWORD FROM UTENTI_REGISTRATI WHERE ID_USER = ?;"; 
            statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, userId);
            resultSet = statementControl.executeQuery();
            resultSet.next();
            
            if(resultSet==null)
            {
                return errors;
            }
            errors[0]=true;
            
            if(password.equals(resultSet))
                errors[1]=true;
               
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return errors;


//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
