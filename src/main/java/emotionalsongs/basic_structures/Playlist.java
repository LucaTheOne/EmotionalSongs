/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.basic_structures;

import emotionalsongs.gui.playlists.*;

/**
 * 
 * Classe le cui istanze rappresentano una playlist, cioè un insieme di canzoni (istanze di Song).
 * La classe si compone di:
 * <ul>
 *  <li>Un nome rappresentato da una stringa.</li>
 *  <li>Un array di stringhe contenente tutti i tag che rappresentano le canzoni che contiene.</li>
 *  <li>Un array di istanze di Song (canzoni).</li>
 *  <li>Metodi per gestire le proprie istanze ed interrogarle per ottenere dati.</li>
 * </ul>
 *
 */
public class Playlist {

    //CAMPI 
  
    private String playlistName;//no special characters ;
    private String[] songsData;
    
    /**
     * Il metodo prende come argomento una canzone (istanza di Song) e l'aggiunge alla playlist,
     * successivamente riordina la playlist sulla base dei titoli delle canzoni.
     * @param newSong Nuova canzone.
     */
    /*
    public void addSong(Song newSong){
        Song[] newPlaylist = new Song[playlist.length+1];
        for (int i = 0; i < playlist.length; i++) {
            newPlaylist[i] = playlist[i];
        }
        newPlaylist[newPlaylist.length-1] = newSong;
        sortByTitles();
    }
    */
    
    //building methods
    /**
     * Il metodo costruisce un'istanza di PlaylistSongsViewPanel, che estende JPanel, che rappresenta graficamente il contenuto della Playlist.
     * @return Rappresentazione grafica del contenuto dell playlist.
     */
    public static PlaylistSongsViewPanel buildPlaylistSongsView(String[] playlistSongsIds){
        return new PlaylistSongsViewPanel(playlistSongsIds);
    }
    
    /**
     * Il metodo restistuisce un'istanza di PlaylistButton, che estende JButton, relativa a questa playlist.
     * L'interazione con questo bottone causa una variazione della GUI che mostrerà il contenuto della playlist.
     * @return Pulsante per attivare la rappresentazione grafica della playlist.
     */
    public static PlaylistButton buildPlaylistButton(String PlaylistName, String playlistId){
        return new PlaylistButton(PlaylistName,playlistId);
    }
}
 
 