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
public interface PlaylistsDataValidator extends Remote {
    
    public static final String SERVICE_NAME = "playlists_data_validator";
    
    //Eleonora
    /**
     * Metodo il quale controlla che i dati della playlist che si sta creando siano validi.
     * Ritorna un array di interi con gli errori occorsi.
     * @param playlistId Id della nuova playlist
     * @param songsIds array con gli ids delle canzoni da aggiungervi.
     * @return 
     * 0 - operazione terminata con successo,
     * 1 - almeno uno degli IDs delle canzoni non è valido.
     * 2 - il nome della playlist non è valido.
     */
    public boolean[] validatePlaylist(String playlistName,String[] songsIds)throws RemoteException;
}
