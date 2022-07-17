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
    
    public PlaylistSet(Utente proprietario){
        this.proprietario = proprietario;
        this.playlistSet = new ArrayList<Playlist>();    
    }
    
        
     public static void aggiungiPlaylistaSet(Utente proprietario, Playlist playlist){
      proprietario.addtoPlaylistSet(playlist); 
     }
     
     
     
   }
    
/** aggiungere metodo per comporre stringa che rappresenta la playlistset.
 * un metodo per ordinare la playlistset.
 * un metodo per stamparla su file.
 * un metodo per importarla dal file.
 * 
 */
