/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services_common_interfaces.data_handler;

import java.rmi.*;

/**
 * Interfaccia che specifica i metodi necessari a gestire i dati delle canzoni, nonchè il repository di esse,
 * presenti nel DB.
 */
public interface SongsDataHandler extends Remote{
    
    public static final String SERVICE_NAME = "songs_data_handler";
    
    //luca
    /**
     * Metodo che ritorna i dati di una canzone di cui se ne passa l' id.
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param songId stringa con l' id della canzone di cui cercare i dati.
     * @return Stringa con i dati della canzone corrispondente all' id, null in caso di errori.
     */
    public String requestSongData(String songId)throws RemoteException;
    
    //luca - fatto
    /**
     * Metodo usato per interrogare il database, ritorna un array di stringhe, 
     * nel quale in ogni posizione ci sono i dati di una canzone contenente nel titolo la stringa passata
     * come argomento.
     * Gli elementi saranno separati da SEP. 
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param title stringa da ricercare nel titolo delle canzoni.
     * @return Array di stringhe con i dati delle canzoni contenenti la stringa argomento nel titolo.
     */
    public String[] cercaBranoMusicale(String title)throws RemoteException;
    
    //luca - fatto
    /**
     * Metodo usato per interrogare il database; ritorna un array di stringhe, 
     * nel quale in ogni posizione ci sono i dati di una canzone che contiene sia, nel campo autore, la stringa passata
     * come argomento che , nel campo anno, l' intero passato come argomento.
     * Gli elementi saranno separati da SEP.
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param author Stringa che si vuole ricercare nel campo autore.
     * @param year anno che si intende cercare.
     * @return Array di stringhe con i dati delle canzoni cui la stringa argomento compare nel campo autore e l' intero compare nel campo anno.
     */
    public String[] cercaBranoMusicale(String author,int year)throws RemoteException;
    
    //luca - fatto
    /**
     * Metodo usato per interrogare il database, ritorna un array di stringhe, nel quale in ogni posizione ci sono i dati di una canzone,
     * Separati da SEP, a partire dalla canzone di indice startIndex fino a quella di indice endIndex inclusa.
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param startIndex indice della prima canzone richiesta.
     * @param endIndex indice dell' ultima canzone richiesta.
     * @return Array di stringhe con i dati delle canzoni contenute tra startIndex ed endIndex compresi.
     */
    public String[] requestRepositorysSongByIndex(int startIndex,int endIndex)throws RemoteException;
    
    //luca - fatto
    /**
     * @return Ritorna il numero di canzoni presenti nel DB. 
     */
    public int getRepoSize()throws RemoteException;
}
