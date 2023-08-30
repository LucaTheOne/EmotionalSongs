/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.wrappers;

import emotionalsongs.clientES.gui.repository.SongPanelForRepositoryView;
import emotionalsongs.clientES.gui.playlists.SongToAddToAPlaylistPanel;
import emotionalsongs.clientES.gui.playlists.SongPanelForPlaylistView;
import emotionalsongs.clientES.gui.data_visualizer.DataVisualizationForm;

/**
* Classe le cui stanze rappresentano una canzone.
* Le sue istanze sono composte da tre stringhe:
* <ul>
*   <li> Titolo della canzone</li>
*   <li> Autore della canzone</li>
*   <li> Anno di pubblicazione della canzone</li>
* </ul>
*
*/
public class Song {
    
    /**
     * Questo metodo costruisce e poi mostra un istanza di DataVisualizationForm relativa alla canzone rappresentata.
     * Il frame che così appare contiene grafici con i dati relativi ai giudizi emozionali relativi alla Istanza di Song che chiama il metodo,
     * un report testuale e dei metodi per esportare tali dati.
     */
    public static void visualizzaEmozioneBrano(String idSong){
        new DataVisualizationForm(idSong).setVisible(true);
    }
    
    //metodi di costruzione
    /**
     * Il metodo crea un istanza di SongPanelForRepositoryView consistente in un Pannello (Estenzione di JPanel)
     * esponente i campi rappresentanti dell ' istanza di Song che chiama questo metodo.
     * @return Pannello rappresentativo della canzone durante l' ispezione del repository.
     */
    public static SongPanelForRepositoryView buildPanelView(String songString){
        return new SongPanelForRepositoryView(songString);
    }
    
    /**
     * Il metodo crea in istanza di SongToAddToAPlaylistPanel consistente in un Pannello (Estenzione di JPanel)
     * esponente i campi rappresentanti dell ' istanza di Song e che permette di aggiungere la canzone rappresentata dell' istanza che chiama il metodo ad una playlist
     * durante il form di creazione.
     * @return Pannello rappresentativo della canzone durante la creazione di una playlist.
     */
    public static SongToAddToAPlaylistPanel buildPanelAddToPlaylist(String songData) {
        return new SongToAddToAPlaylistPanel(songData);
    }
    
    /**
     * Il metodo ritorna una stringa con il link di ricerca della canzone, rappresentata dall' istanza che ne chiama il metodo, su youtube.
     * @return L'url di ricerca della canzone.
     */
    public static String buildResearchQueryUrl(String title,String author,int year){
        return "https://www.youtube.com/results?search_query=" + 
                title.replaceAll(" ", "+") +
                "+" + author.replaceAll(" ", "")+
                "+" + String.valueOf(year);
    }
    
    /**
     * Il metodo ritorna un istanza di SongPanelForPlaylistView, estensione di JPanel, la quale rappresenta graficamente l' istanza di Song che richiama il metodo
 come parte di una playlist.
     * @param songdata la Playlist in cui il brano è contenuto.
     * @return Il pannello con la Playlist.
     */
    public static SongPanelForPlaylistView buildPanelForPlaylist(String songdata,String userId){
        return new SongPanelForPlaylistView(songdata,userId);
    }
}
