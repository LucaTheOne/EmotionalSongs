/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services_common_interfaces.data_handler;

import java.rmi.*;

/**
 * Interfaccia che specifica i metodi necessari a gestire i dati degli utenti presenti nel DB.
 */
public interface UsersDataHandler extends Remote{
    
    public static final String SERVICE_NAME = "users_data_handler";
    
    //update methods
    //luca - fatto
    /**
     * Metodo che aggiorna il DB con un nuovo utente, ed il suo indirizzo.Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param userId
     * @param email
     * @param cf
     * @param password
     * @param nome
     * @param cognome
     * @param dataNascita
     * @param indirizzo
     * @return 
     * 0 - Operazione completata con successo.
     * 1 - Operazione non andata a buon fine.
     * @throws java.rmi.RemoteException
     */
    public int registraNuovoUtente(
            String userId,
            String email,
            String cf,
            String password,
            String nome,String cognome,
            String dataNascita,
            String indirizzo
    )throws RemoteException;
    
    //Eleonora
    /** Metodo che verifica se un determinato utente (identificato dal userId) non abbia già espresso un parere
    * per una determinata canzone (identificata dal suo id).
    * @param userId Id dell'utente quale si vuole verificare la possibilità di voto.
    * @param songId Id della canzone da votare.
    * @return true se l' uente non ha già espresso un parere, false altrimenti.
     * @throws java.rmi.RemoteException
    */
    public boolean userCanVoteSong(String userId,String songId)throws RemoteException;
    
    /**
     * Metodo usato per notificare al DB che l' utente ha già effettuato il login!
     * @param userId user id dell' utente che vuole eseguire il login.
     * @return 1 se qualcosa non va a buon fine.
     * @throws RemoteException 
     */
    public int login(String userId)throws RemoteException;
    
    /**
     * Metodo usato per notificare il logout dell' utente al DB.
     * @param userId userId dell' utente che vuole effettuare il log out;
     * @return 1 se qualcosa non va a buon fine.
     * @throws RemoteException 
     */
    public int logout(String userId) throws RemoteException;
}   

