/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.basic_structures;

import emotionalsongs.data_structures.*;
import emotionalsongs.engines.*;
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
    private String[] songsTags;
    private Song[] playlist; 

    /**
     * Crea l'oggetto Playlist prendendo due stringhe come argomenti. Nota : l'oggetto risulta già ordinato secondo i titoli delle canzoni che contiene.<ul>
     *  <li> @param playlistName - una stringa rappresentante il nome della playlist</li>
     *  <li> @param listSongsTag - una stringa contenente tutti i tag delle canzoni che contiene</li>
     * </ul>
     * 
     * @param playlistName Nome da assegnare alla playlist
     * @param listSongsTag Lista dei tag delle canzoni della playlist.
     */
    public Playlist(String playlistName,String listSongsTag) {
        this.playlistName = playlistName;
        this.songsTags = listSongsTag.split(",");
        playlist = new Song[songsTags.length];
        for (int i = 0; i < songsTags.length; i++) {
            playlist[i] = searchFromTag(songsTags[i]);
        }
        sortByTitles();
    }
    
    /**
     * Costruttore che costruisce una playlist usando le righe del file associato.
     * @param stringFromFile Righe del file rappresentanti le canzoni. 
     */
    public Playlist(String stringFromFile){
        this(stringFromFile.split(":")[0], stringFromFile.split(":")[1]);
    }
    
    /**
     * Costruisce un oggetto Playlist prendendo come argomenti nome della Playlist e un array di canzoni
     * quali la compongono.
     * Nota: l'oggetto risulta già ordinato secondo i titoli delle canzoni che contiene.
     * @param playlistName Nome Playlist.
     * @param selectedSongs Array di canzoni.
     */
    public Playlist(String playlistName,Song[] selectedSongs){
        this.playlistName = playlistName;
        this.songsTags = new String[selectedSongs.length];
        this.playlist = selectedSongs;
        for(int i = 0; i<selectedSongs.length;i++){
            songsTags[i] = selectedSongs[i].getTag();
        }
        sortByTitles();
    }
    
    //Getter methods
    /**
     * Il metodo restituisce una Stringa con il nome della playlist.
     * @return Nome della playlist.
     */
    public String getName(){
        return this.playlistName;
    }
    
    /**
     * Il metodo restituisce un intero rappresentante il numero di brani presenti nella playlist.
     * @return Dimensione della playlist.
     */
    public int getSize(){
        return playlist.length;
    }
    
    /**
     * Il metodo prende come argomento un intero,
     * rappresentante l'indice della canzone ricercata 
     * all'interno del repository e ne restituisce il tag. 
     * @param index Indice della canzone.
     * @return Tag della canzone in posizione index.
     */
    public String getSongTagByIndex(int index){
        return songsTags[index];
    }
    
    /**
     * Il metodo restituisce un array di stringhe contenente tutti i tag di tutte le canzoni della playlist.
     * @return Tag delle canzoni.
     */
    public String[] getArrayTags() {
        return songsTags;
    }
    
    /**
     * Il metodo restituisce un array di istanze di Song (canzoni).
     * @return Array di canzoni.
     */
    public Song[] getArraySongs() {
        return playlist;
    }
    
    //methods modifier
    
    /**
     * Il metodo prende come argomento una canzone (istanza di Song) e l'aggiunge alla playlist,
     * successivamente riordina la playlist sulla base dei titoli delle canzoni.
     * @param newSong Nuova canzone.
     */
    public void addSong(Song newSong){
        Song[] newPlaylist = new Song[playlist.length+1];
        for (int i = 0; i < playlist.length; i++) {
            newPlaylist[i] = playlist[i];
        }
        newPlaylist[newPlaylist.length-1] = newSong;
        sortByTitles();
    }
    
    //compare method
    /**
     * Il metodo restituisce:
     * <ul>
     * <li><b>Un intero negativo</b> se il nome della playlist che chiama il metodo.
     * è <b>lessicograficamente precedente</b> al nome della playlist passata come argomento.</li>
     * <li><b>Un intero positivo</b> se il nome della playlist che chiama il metodo è <b>lessicograficamente seguente</b> al nome della playlist passata come argomento.</li>
     * <li><b>Zero</b> se i titoli della canzone che richiama il metodo e quella passata come argomento <b>sono uguali</b></li>
     * </ul>
     * Nota: il metodo non è case sensitive, la capitalizzazione delle lettere che compongono le stringhe non è rilevante.
     * @param playlist Playlist.
     * @return Ritorna un numero intero.
     */
    public int compareTo(Playlist playlist) {
        return this.playlistName.compareToIgnoreCase(playlist.getName());
    }
    
    //building methods
    /**
     * Il metodo costruisce un'istanza di PlaylistSongsViewPanel, che estende JPanel, che rappresenta graficamente il contenuto della Playlist.
     * @return Rappresentazione grafica del contenuto dell playlist.
     */
    public PlaylistSongsViewPanel buildPlaylistView(){
        return new PlaylistSongsViewPanel(this);
    }
    
    /**
     * Il metodo restistuisce un'istanza di PlaylistButton, che estende JButton, relativa a questa playlist.
     * L'interazione con questo bottone causa una variazione della GUI che mostrerà il contenuto della playlist.
     * @return Pulsante per attivare la rappresentazione grafica della playlist.
     */
    public PlaylistButton buildPlaylistButton(){
        return new PlaylistButton(this);
    }
    
    /**
     * Il metodo compone la stringa nel formato deciso per rappresentare la playlist ed il suo contenuto
     * all'interno del file di di sistema atto a memorizzarle, con il fine poi di avere un file su cui il costruttore possa appoggiarcisi.
     * 
     * Il formato è composta da: " |playlistName|:|songTag1|,|songTag2|,...,|songTagn|; "
     * @return Stringa formattata rappresentante la playlist.
     */
    public String composeString(){
        sortByTags();
        String stringa = playlistName+":"; 
        for (int i = 0; i < songsTags.length; i++) {
            stringa += i>0 ? "," + songsTags[i] : songsTags[i];
        }
        return stringa + ";";
    }
    
    //internal methods
   
    private Song searchFromTag(String songTag){
        EngineSearcher finder = new EngineSearcher();
        return finder.searchBySongTag(Repository.getInstance(), songTag);
    }
    
    private void sortByTags(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortStringsArray(songsTags,false); 
    }
    
    private void sortByTitles(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortSongsByTitles(playlist);
    }
  
}
 
 