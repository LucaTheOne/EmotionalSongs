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
     * Metodo che controlla che i dati della playlist che si sta creando siano validi. Ritorna un array di interi con gli errori occorsi.
     * @param playlistName Nome della playlist
     * @param songsIds Array con gli ID delle canzoni da aggiungere alla playlist.
     * @return 
     * 0 - Operazione terminata con successo,
     * 1 - Almeno uno degli ID delle canzoni non è valido.
     * 2 - Il nome della playlist non è valido.
     * @throws java.rmi.RemoteException
     */
    public boolean[] validatePlaylist(String playlistName,String[] songsIds)throws RemoteException;
}
