/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.common_interfaces_and_services;

import java.rmi.*;

/**
 *
 * @author big
 */
public interface DataManager extends Remote {
    
    //Songs and playlists data management

    //luca
    /**
     * Metodo che ritorna i dati di una canzone di cui se ne passa l' id.
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param songId stringa con l' id della canzone di cui cercare i dati.
     * @return Stringa con i dati della canzone corrispondente all' id, null in caso di errori.
     */
    public String requestSongdata(String songId);
    
    //luca - fatto
    /**
     * Metodo usato per interrogare il database, ritorna un array di stringhe, 
     * nel quale in ogni posizione ci sono i dati di una canzone contenente nel titolo la stringa passata
     * come argomento.
     * Gli elementi saranno separati da "£SEP£". 
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param title stringa da ricercare nel titolo delle canzoni.
     * @return Array di stringhe con i dati delle canzoni contenenti la stringa argomento nel titolo.
     */
    public String[] cercaBranoMusicale(String title);
    
    //luca - fatto
    /**
     * Metodo usato per interrogare il database; ritorna un array di stringhe, 
     * nel quale in ogni posizione ci sono i dati di una canzone che contiene sia, nel campo autore, la stringa passata
     * come argomento che , nel campo anno, l' intero passato come argomento.
     * Gli elementi saranno separati da "£SEP£".
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param author Stringa che si vuole ricercare nel campo autore.
     * @param year anno che si intende cercare.
     * @return Array di stringhe con i dati delle canzoni cui la stringa argomento compare nel campo autore e l' intero compare nel campo anno.
     */
    public String[] cercaBranoMusicale(String author,int year);
    
//luca - fatto
    /**
     * Metodo usato per interrogare il database, ritorna un array di stringhe, nel quale in ogni posizione ci sono i dati di una canzone,
     * Separati da "£SEP£", a partire dalla canzone di indice startIndex fino a quella di indice endIndex inclusa.
     *      -Formato: "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param startIndex indice della prima canzone richiesta.
     * @param endIndex indice dell' ultima canzone richiesta.
     * @return Array di stringhe con i dati delle canzoni contenute tra startIndex ed endIndex compresi.
     */
    public String[] requestRepositorysSongByIndex(int startIndex,int endIndex);
    
    //Luca -  fatto
    /**
     * Metodo usato per richiedere al DB un array di stringhe, 
     * nel quale ogni posizione contiene l'id univoco di una playlist dell' utente
     * ed il suo nome separati da "£SEP£".
     *      -Formato: "ID_PLAYLIST£SEP£User_PROP_ID£SEP£NOME_PLAYLIST" -
     * @param idUser id utente di cui si vuole sapere il nome delle playlist.
     * @return array di Stringhe contenente id e nomi delle playlist.
     */
    public String[] requestPlaylistsUser(String idUser);
    
    //Luca - fatto
    /**
     * Metodo usato per interrogare il DB, ritorna un array di stringhe il quale in ogni posizione sono contenuti
     * i dati di una canzone  della playlist passata come argomento, separati da £SEP£;
     *      -Formato: "REPO_INDEX£SEP£ID_UNIVOCO£SEP£TITOLO£SEP£AUTORE£SEP£ANNO"
     * @param PlaylistID id della playlist il quale si vuole sapere il contenuto.
     * @return array di stringhe contenenti i dati delle canzoni della playlist.
     */
    public String[] requestPlaylistSongs(String playlistId);
    
    //Luca - fatto
    /**
     * Metodo che interroga il DB per ottenere informazioni riguardo 
     * ai giudizi emozionali relativi alla canzone il cui id è passato come argomento.
     * Ritorna un array contenente in ogni posizione un giudizio ricevuto da un utente.
     *      -Formato: "meraviglia_voto£SEP£solennita_voto£SEP£tenerezza_voto£SEP£nostalgia_voto£SEP£pacatezza_voto£SEP£potere_voto£SEP£gioia_voto£SEP£tensione_voto£SEP£tristezza_voto£SEP£commento"
     * @param idSong id della canzone il quale si vogliono ottenere i giudizi emozionali.
     * @return array contenente in ogni posizione un giudizio ricevuto da un utente.
     */
    public String[] requestDataJudgementsSong(String idSong);
    
    //luca - fatto
    /**
     * Comando per aggiornare il DB con una nuova playlist.
     * Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param IDNuovaPlaylist id della nuova playlist.
     * @param nomeNuovaPlaylist nome della nuova playlist.
     * @param userIdProprietario userid del proprietario della playlist.
     * @param idsSongsContenute array di stringhe con gli ids delle canzoni nella nuova playlists.
     * @return 0 - operazione completata con successo.
     * 1 - operazione non andata a buon fine.
     */
    public int updatePlaylistTable(String nomeNuovaPlaylist,String userIdProprietario,String[] idsSongsContenute);
    
    //luca - fatto
    /**
     * Comando che aggiorna il DB con un nuovo giudizio emozionale.
     * Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param IDSong id della canzone votata.
     * @param emotionalMarks array di 9 interi con i voti delle 9 emozioni.
     * @param Comment eventuale commento dell' utente, null altrimenti.
     * @return 0 - operazione completata con successo.
     * 1 - operazione non andata a buon fine.
     * 2 - operazione abortita causa: array voti non valido;
     */
    public int voteSongEmotion(String idUser,String idSong,int[] emotionalMarks,String Comment);
    
    //user data management
    //Riccardo
    /**
     * Metodo che aggiorna il DB con un nuovo utente.
     * Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param userId
     * @param email
     * @param cf
     * @param password
     * @param nome
     * @param cognome
     * @param tipoIndirizzo
     * @param indirizzo
     * @param civico
     * @param cap
     * @param nazione
     * @param provincia
     * @param città
     * @return 0 - operazione completata con successo.
     * 1 - operazione non andata a buon fine.
     */
    public int requestToUpdateUsersTable(
            String userId,
            String email,
            String cf,
            String password,
            String nome,String cognome,
            String tipoIndirizzo,
            String indirizzo,
            int civico,
            int cap,
            int nazione,
            String provincia,
            String città
    );
    
}
