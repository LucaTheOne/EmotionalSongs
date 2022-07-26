package emotionalsongs;

import java.util.*;

/**
 *
 * @author alexandruboitor
 */
public class PlaylistSet {
   
    //campi
    private List<Playlist> playlistSet;
    private Utente proprietario;
    
    /**
     * 
     */
    public PlaylistSet(){
        this.proprietario = proprietario;
        this.playlistSet = new ArrayList<Playlist>();    
    }
    
    /**
     * 
     * @param playlist 
     */    
    public void aggiungiPlaylistASet(Playlist playlist){
        EMOTIONALSONGS.loggedUser.addToPlaylistSet(playlist); 
    }
     
     
     
   }
    
/** aggiungere metodo per comporre stringa che rappresenta la playlistset.
 * un metodo per ordinare la playlistset.
 * un metodo per stamparla su file.
 * un metodo per importarla dal file.
 * 
 */
