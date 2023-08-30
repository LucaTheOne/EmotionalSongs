/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services_common_interfaces.data_handler;

import java.rmi.*;

/**
 * Interfaccia che specifica i metodi necessari a gestire i dati delle playlist presenti nel DB.
 */
public interface PlaylistsDataHandler extends Remote{
    
    public static final String SERVICE_NAME = "playlists_data_handler";
    
    //Luca -  fatto
    /**
     * Metodo usato per richiedere al DB un array di stringhe, 
     * nel quale ogni posizione contiene l'id univoco di una playlist dell' utente
     * ed il suo nome separati da SEP.
     *      -Formato: "ID_PLAYLIST£SEP£User_PROP_ID£SEP£NOME_PLAYLIST" -
     * @param idUser id utente di cui si vuole sapere il nome delle playlist.
     * @return array di Stringhe contenente id e nomi delle playlist.
     */
    public String[] requestPlaylistsUser(String idUser) throws RemoteException;
    
    //Luca - fatto
    /**
     * Metodo usato per interrogare il DB, ritorna un array di stringhe dove in ogni posizione sono contenuti
     * i dati di una canzone della playlist passata come argomento, separati da £SEP£;
     *      - Formato: "REPO_INDEX£SEP£ID_UNIVOCO£SEP£TITOLO£SEP£AUTORE£SEP£ANNO"
     * @param playlistId ID della playlist.
     * @return Array di stringhe contenenti i dati delle canzoni della playlist.
     * @throws java.rmi.RemoteException
     */
    public String[] requestPlaylistSongs(String playlistId) throws RemoteException;
    
    //Update methods
    
    //luca - fatto
    /**
     * Comando per aggiornare il DB con una nuova playlist.Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param nomeNuovaPlaylist nome della nuova playlist.
     * @param userIdProprietario userid del proprietario della playlist.
     * @param idsSongsContenute array di stringhe con gli ids delle canzoni nella nuova playlists.
     * @return 0 - operazione completata con successo.
     * 1 - operazione non andata a buon fine.
     * @throws java.rmi.RemoteException
     */
    public int updatePlaylistTable(String nomeNuovaPlaylist,String userIdProprietario,String[] idsSongsContenute)throws RemoteException;
    
    //luca - fatto
    /**
     * Ritorna il numero di playlists 
     * possedute dall' utente corrispondente all' id passato come argomento.
     * @param userId ID Utente di cui si vuole sapere il numero di playlists in possesso.
     * @return numero di playlists in possesso dell' utente.
     * @throws java.rmi.RemoteException
     */
    public int getUserPlaylistsNumber(String userId)throws RemoteException; 
    
    //luca - fatto
    /**
     * @param playlistId ID playlist di cui si vuole sapere il numero di canzoni contenute.
     * @return Il numero di canzoni contenute nbella playlist corrispondente al ID passato come argomento.
     * @throws java.rmi.RemoteException
     */
    public int getPlaylistDimension(String playlistId)throws RemoteException;

}
