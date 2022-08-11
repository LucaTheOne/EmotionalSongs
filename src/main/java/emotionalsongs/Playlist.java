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
    String nomePlaylist;
    Utente proprietario;
    int dimensione;

    ArrayList<Brano> listaCanzoniPlaylist = new ArrayList<Brano>();

    //costruttore
    /**
     * 
     * @throws IOException 
     */
    public Playlist(Utente proprietario,String nomePlaylist,ArrayList<Brano> listaCanzoniPlaylist) throws IOException{
        this.proprietario = proprietario;
        this.nomePlaylist = nomePlaylist;
        this.listaCanzoniPlaylist = listaCanzoniPlaylist;
    }
    
    
    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void registraPlaylist(Utente user,String nome,ArrayList<Brano> brani) throws FileNotFoundException, IOException{
        
        Playlist playlist = new Playlist(user, nome, brani);
        aggiungiPlaylistASetPlaylistsUtente(user,playlist);
    }
    
    /**
     * 
     * 
     */
    private static void aggiungiPlaylistASetPlaylistsUtente(Utente proprietario,Playlist playlist){
        proprietario.addToPlaylistSet(playlist);
        
    }
    
    /**
     * Il metodo restituisce una Stringa con il nome della playlist
     * @return il campo nomePlayList.
     */
    public String getNomePlaylist(){
        return this.nomePlaylist;
    }

    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void aggiungiCanzone(Brano brano) throws FileNotFoundException, IOException{
        listaCanzoniPlaylist.add(brano);
        riordinaPlaylist();
    }

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
 