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
     * Metodo privato che controlla la validità della password
     * @param password
     * @return 
     */
    private static boolean passwordChecker(String password) 
    {
        
        // Inizializza dei flag per tenere traccia dei componenti richiesti
        boolean contieneNumero = false;
        boolean contieneMaiuscola = false;
        boolean contieneCarattereSpeciale = false;
        boolean lunghezzaMinima;
        
        //Controlla che la lunghezza sia uguale o maggiore di 8
        lunghezzaMinima = (password.length()>=8);

        // Definisci l'insieme di caratteri speciali
        String caratteriSpeciali = "!@#$%^&*()_-+=[]{}|;:'\",.<>?";

        // Scansiona ogni carattere nella stringa di input
        for (char ch : password.toCharArray()) 
        {
            if (Character.isDigit(ch)) 
            {
                contieneNumero = true;
            } else if (Character.isUpperCase(ch)) {
                contieneMaiuscola = true;
            } else if (caratteriSpeciali.contains(String.valueOf(ch))) {
                contieneCarattereSpeciale = true;
            }

            // Interrompi il ciclo se tutte le condizioni sono soddisfatte
            if (contieneNumero && contieneMaiuscola && contieneCarattereSpeciale) {
                break;
            }
        }

        // Restituisci true se tutte le condizioni sono soddisfatte, altrimenti false
        return contieneNumero && contieneMaiuscola && contieneCarattereSpeciale && lunghezzaMinima;
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
    
    public UtentiDataChecker(Connection Conn) throws RemoteException{
        super();
        CONNECTION_TO_DB = Conn;
    }
    
    
    
    //Riccardo
    /**
     * Metodo il quale controlla che i dati inseriti dal nuovo utente siano validi.
     * Ritorna un array di booleani in cui i "true" rappresentano gli errori occorsi.
     * @param userId Stringa contenente l' id del nuovo utente.
     * @param email Stringa contenente la mail del nuovo utente.
     * @param cf Stringa contenente il codice fiscale del nuovo utente.
     * @param password Stringa contenente la password scelta dal nuovo utente per l' accesso al suo account.
     * @param rePassword Stringa contenente per la verifica che la password inserita sia quella che l' utente voleva.
     * @param nome Stringa contenente il nome del nuovo utente.
     * @param cognome Stringa contenente il cognome del nuovo utente.
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
     * 10 - tipo indirizzo non ammesso.
     * 11 - indirizzo non valido.
     * 12 - civico non valido.
     * 13 - cap non valido.
     * 14 - nazione non valida.
     * 15 - provincia non valida.
     * 16 - citta non valida.
     */
    @Override
    public boolean[] validateNewUserData(String userId, String email, String cf, String password, String rePassword, String nome, String cognome, String tipoIndirizzo, String indirizzo, int civico, int cap, String nazione, String provincia, String citta) throws RemoteException
    {
        boolean[] errors = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
        
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
            if(cf.length()!=16)
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
            if(!passwordChecker(password))
                errors[6] = true;
            else if(!password.equals(rePassword))
                errors[7]=true;
            
            //Controllo Nome
            if(nome.length()<2)
                errors[8]=true;
            
            //Controllo Cognome
            if( cognome.length()<2)
                errors[9]=true;
            
            //Tipo indirizzo non ha senso
            
            //I controlli su indirizzo non hanno senso se non si integra un database stradale
            //Nel dubbio controllo che i nomi delle vie abbiano almeno 3 lettere
            if(indirizzo.length()<3)
                errors[11]=true;
            
            
            //Controllo che il civico non sia negativo 
            //(inserire eventuale interno?)
            if(civico<1)
                errors[12]=true;
            
            //Controllo CAP
            if(cap<10000 || cap >99999)
                errors[13]=true;
            
            //Controllo Nazione (è l'Oman quello con il nome più corto?)
            if(nazione.length()<4)
                errors[14]=true;
            
            //Controllo provincia
            if(provincia.length()!=2)
                errors[15]=true;
            else if(!verificaProvincia(privincia))
                errors[15]=true;
            
            //Controllo città
            if(citta.length()<2)
                errors[16]=true;
            
            
            
            
            //Se la validità degli inserimenti è stata controllata dal client,
            //non occorre controllare altro perché tutti gli altri valori
            //possono ripetersi
            
            
            
            
        }catch(SQLException e){
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public boolean userCanVoteSong(String userId, String songId) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Riccardo deve implementare
    /**
     * Metodo per la verifica dei dati di login.
     * Ritorna un array di interi rappresentanti tutti gli errori occorsi.
     * @param userId Stringa contenente l' user id del utente.
     * @param password Stringa contenente l'account id del utente.
     * @return 
     * 0 - dati validi.
     * 1 - id utente non presente nel DB.
     * 2 - Password errata.
     */
    @Override
    public boolean[] validateLogin(String userId, String password) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
