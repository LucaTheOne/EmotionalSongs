/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services_common_interfaces.data_validator;

import java.rmi.*;

/**
 *
 * @author big
 */
public interface UsersDataValidator extends Remote {
    
    public static final String SERVICE_NAME = "user_data_validator";
    
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
     * false -> errore non occorso, true -> errore occorso
     * posizioni errori nell' array:
     * 0 - userId non valido.
     * 1 - userId già scelto da un altro utente.
     * 2 - codice fiscale non valido.
     * 3 - codice fiscale già presente nel DB.
     * 4 - password non valida.
     * 5 - password non coincidono.
     * 6 - nome non valido.
     * 7 - cognome non valido.
     * 8 - Compleanno non valido.
     * 9 - Indirizzo non valido.
     * 10 - email non valida
     * @throws java.rmi.RemoteException
     */
    public boolean[] validateNewUserData(
            String userId,
            String email,
            String cf,
            String password,
            String rePassword,
            String nome,String cognome,String compleanno,
            String indirizzo
        )throws RemoteException;
    
    //Eleonora
    /**
     * Metodo che verifica se un determinato utente (identificato dal CF) non abbia già espresso un parere
     * per una determinata canzone (identificata dal suo id).
     * @param userId Id dell'utente quale si vuole verificare la possibilità di voto.
     * @param songId Id della canzone da votare.
     * @return true se l' uente non ha già espresso un parere, false altrimenti.
     * @throws java.rmi.RemoteException
     */
    public boolean userCanVoteSong(String userId,String songId)throws RemoteException;
    
    //Riccardo
    /**
     * Metodo per la verifica dei dati di login.Ritorna un array di booleani in cui "false" rappresentano gli errori commessi, secondo la elegenda sottostante.
     * @param userId Stringa contenente l' user id del utente.
     * @param password Stringa contenente l'account id del utente.
     * @return
     * per ogni posizione dell' array: true errore occorso, false nessun errore occorso
     * posizioni errori:
     * 0 - id utente non presente nel DB.
     * 1 - Password errata.
     * @throws java.rmi.RemoteException
     */
    public boolean[] validateLogin(String userId,String password)throws RemoteException;
}
