package emotionalsongs;

import java.io.*;
import java.util.*;

/**
 *  La classe si occupa di creare e di registrare la Playlist.
 * @author Luca
 * @version 1.4
 *
 */
public class Playlist extends EMOTIONALSONGS {

    //campi
    /**
     * Nome playlist.
     */
    String nomePlaylist;
    
    /**
     * Utente.
     */
    Utente proprietario;
    /**
     * Dimensione playlist.
     */
    int dimensione;

    ArrayList<Brano> listaCanzoniPlaylist = new ArrayList<Brano>();

    //costruttore
    /**
     * Crea l'oggetto Playlist prendendo come argomenti un oggetto proprietario di tipo Utente,
     * un oggetto nomePlaylist di tipo String e un oggetto listaCanzoniPlaylist di tipo ArrayList<Brano>.
     * @throws IOException 
     */
    public Playlist(Utente proprietario,String nomePlaylist,ArrayList<Brano> listaCanzoniPlaylist) throws IOException{
        this.proprietario = proprietario;
        this.nomePlaylist = nomePlaylist;
        this.listaCanzoniPlaylist = listaCanzoniPlaylist;
    }
    
    
    /**
     * Il metodo crea una nuova Playlist e la registra.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void registraPlaylist(Utente user,String nome,ArrayList<Brano> brani) throws FileNotFoundException, IOException{
        
        Playlist playlist = new Playlist(user, nome, brani);
        aggiungiPlaylistASetPlaylistsUtente(user,playlist);
    }
    
    /**
     * Il metodo aggiunge la playlist all'utente.
     * @param proprietario - dati dell'utente.
     * @param playlist - playlist.
     */
    private static void aggiungiPlaylistASetPlaylistsUtente(Utente proprietario,Playlist playlist){
        proprietario.addToPlaylistSet(playlist);
        
    }
    
    /**
     * Il metodo restituisce una Stringa con il nome della playlist.
     * @return il nome della playlist.
     */
    public String getNomePlaylist(){
        return this.nomePlaylist;
    }

    /**
     * Il metodo preleva il brano e lo aggiunge alla playlist.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void aggiungiCanzone(Brano brano) throws FileNotFoundException, IOException{
        listaCanzoniPlaylist.add(brano);
        riordinaPlaylist();
    }

    /**
     * Il metodo restituisce la playlist.
     * @return  playlist.
     */
    public ArrayList<Brano> getListaCanzoniPlaylist() {
        return listaCanzoniPlaylist;
    }
        

    //implementare metodo per riordinare la Playlist
    private void riordinaPlaylist(){
        
    }
    
    //implementare metodo di ricerca interno alla playlist
    public void filtraPerTitolo(){
        
    }
    
    public void filtraPerAutore(){
        
    }
    
}
 