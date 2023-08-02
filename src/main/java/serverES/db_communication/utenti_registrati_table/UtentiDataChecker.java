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
    
    public UtentiDataChecker(Connection Conn) throws RemoteException{
        super();
        CONNECTION_TO_DB = Conn;
    }
    
    //Riccardo
    /**
     * Metodo il quale controlla che i dati inseriti dal nuovo utente siano validi.
     * Ritorna un array di interi rappresentante tutti gli errori occorsi.
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
     * @param città Stringa contenente la città di residenza del nuovo utente.
     * @return 
     * 0 - tutti i dati risultano validi.
     * 1 - userId non valido.
     * 2 - userId già scelto da un altro utente.
     * 3 - codice fiscale non valido.
     * 4 - codice fiscale già presente nel DB.
     * 5 - password non valida.
     * 6 - password non coincidono.
     * 7 - nome non valido.
     * 8 - cognome non valido.
     * 9 - tipo indirizzo non ammesso.
     * 10 - indirizzo non valido.
     * 11 - civico non valido.
     * 12 - cap non valido.
     * 13 - nazione non valida.
     * 14 - provincia non valida.
     * 15 - citta non valida.
     */
    @Override
    public int[] validateNewUserData(String userId, String email, String cf, String password, String rePassword, String nome, String cognome, String tipoIndirizzo, String indirizzo, int civico, int cap, int nazione, String provincia, String città) throws RemoteException{
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
    public int[] validateLogin(String userId, String password) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
