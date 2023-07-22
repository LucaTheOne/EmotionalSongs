
package clientES.common_interfaces_and_services;


import java.rmi.*;

/**
 * Interfaccia che descrive i metodi dell' oggetto remoto che si dovrà occupare
 * di validare i dati prima del loro inserimento nel database.
 */
public interface DataValidator extends Remote{
    //Song and playlist data validation
    /**
     * Metodo che verifica se un determinato utente (identificato dal CF) non abbia già espresso un parere
     * per una determinata canzone (identificata dal suo id).
     * @param userId Id dell'utente quale si vuole verificare la possibilità di voto.
     * @param songId Id della canzone da votare.
     * @return true se l' uente non ha già espresso un parere, false altrimenti.
     */
    public boolean userCanVoteSong(String userId,String songId);
    /**
     * Metodo il quale verifica che tutti i parametri passati come argomento siano accettabili,
     * ritorna 0 se lo sono tutti, altrimenti un intero rappresentante un errore.
     * @param IDSong Id canzone votata.
     * @param emotionalMarks array di 9 posizioni contenente i voti di ogni emozione.
     * @param Comment commento opzionale
     * @return 0 - operazione terminata con successo,
     * 1 - Id Canzone non presente nel database
     * 2 - Dimensione array voti non conforme
     * 3 - Almeno un voto fuori dal range 1-5 inclusi.
     * 4 - caratteri non ammessi nel commento.
     * 5 - Commento contiene più di 256 caratteri.
     */
    public int validateVote(String IDSong,int[] emotionalMarks,String Comment);
    /**
     * Metodo il quale controlla che i dati della playlist che si sta creando siano validi.
     * Ritorna 0 se si, altrimenti un intero rappresentante un errore
     * @param playlistId Id della nuova playlist
     * @param songsIds array con gli ids delle canzoni da aggiungervi.
     * @return 0 - operazione terminata con successo,
     * 1 - almeno uno degli IDs delle canzoni non è valido.
     * 2 - l' id della canzone non è valido.
     */
    public int validatePlaylist(String playlistId,String[] songsIds);
    
    //User data validation
    /**
     * Metodo il quale controlla che i dati inseriti dal nuovo utente siano validi.
     * Rittorna 0 se lo sono, altrimenti un intero rappresentante il dato non valido e le cause.
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
     * @return 0 - tutti i dati risultano validi.
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
    public int validateNewUserData(
            String userId,
            String email,
            String cf,
            String password,
            String rePassword,
            String nome,String cognome,
            String tipoIndirizzo,
            String indirizzo,
            int civico,
            int cap,
            int nazione,
            String provincia,
            String città
    );
    /**
     * Metodo per la verifica dei dati di login.
     * Ritorna 0 se i dati sono validi.
     * @param userId Stringa contenente l' user id del utente.
     * @param password Stringa contenente l'account id del utente.
     * @return 0 - dati validi.
     * 1 - id e/o password errati.
     */
    public int validateLogin(String userId,String password);
    
}
