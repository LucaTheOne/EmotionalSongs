/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services_common_interfaces.data_handler;

import java.rmi.*;

/**
 * Interfaccia che specifica i metodi necessari a gestire i dati dei giudizi emozionali presenti nel DB.
 */
public interface EmotionsDataHandler extends Remote{
    
    public static final String SERVICE_NAME = "emotions_data_handler";
    
    // data request methods
    
    //Luca - fatto
    /**
     * Metodo che interroga il DB per ottenere informazioni riguardo 
     * ai giudizi emozionali relativi alla canzone il cui id è passato come argomento.
     * Ritorna un array contenente in ogni posizione un giudizio ricevuto da un utente.
     *      -Formato: "meraviglia_voto£SEP£solennita_voto£SEP£tenerezza_voto£SEP£nostalgia_voto£SEP£pacatezza_voto£SEP£potere_voto£SEP£gioia_voto£SEP£tensione_voto£SEP£tristezza_voto£SEP£commento"
     * @param idSong id della canzone il quale si vogliono ottenere i giudizi emozionali.
     * @return array contenente in ogni posizione un giudizio ricevuto da un utente, null se non sono presenti dati.
     */
    public String[] requestDataJudgementsSong(String idSong) throws RemoteException;
    
    //data update methods
    
    //luca - fatto
    /**
     * Comando che aggiorna il DB con un nuovo giudizio emozionale.Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param idUser id dell' utente votante.
     * @param idSong id della canzone votata.
     * @param emotionalMarks array di 9 interi con i voti delle 9 emozioni.
     * @param Comment eventuale commento dell' utente, null altrimenti.
     * @return 0 - operazione completata con successo.
     * 1 - operazione non andata a buon fine.
     * 2 - operazione abortita causa: array voti non valido;
     */
    public int InserisciEmozioniBrano(String idUser,String idSong,int[] emotionalMarks,String Comment) throws RemoteException;
    
    
}
