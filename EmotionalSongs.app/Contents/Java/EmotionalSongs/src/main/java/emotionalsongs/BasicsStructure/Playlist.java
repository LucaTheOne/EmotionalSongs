//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.BasicsStructure;

import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.PlayLists.*;
import emotionalsongs.Managers.*;
import java.io.*;

/**
 *  La classe si occupa di creare e di registrare la Playlist.
 * @author Luca
 * @version 1.4
 *
 */
public class Playlist {

    //CAMPI 
  
    private String playlistName;//no special characters ;
    private String[] songsTags;
    private Song[] playlist; 
    private PlayListsManager manager = PlayListsManager.getInstance();

    /**
     * Crea l'oggetto Playlist prendendo come argomenti un oggetto owner di tipo User,
        un oggetto playlistName di tipo String e un oggetto playlist di tipo ArrayList<Brano>.
     * @throws IOException 
     */
    public Playlist(String nomePlaylist,String listaCanzoniPlaylist) {
        this.playlistName = nomePlaylist;
        this.songsTags = listaCanzoniPlaylist.split(",");
        playlist = new Song[songsTags.length];
        for (int i = 0; i < songsTags.length; i++) {
            playlist[i] = searchFromTag(songsTags[i]);
        }
        sortByTitles();
    }
    
    /**
     * Costruttore che costruisce una playlist usando le righie di un file. 
     * @param stringFromFile Righe del file rappresentanti le canzoni. 
     */
    public Playlist(String stringFromFile){
        this(stringFromFile.split(":")[0], stringFromFile.split(":")[1]);
    }
    
    /**
     * Costruisce un oggetto Playlist prendendo come argomenti nome della Playlist e un array di canzoni
     * quali la rappresentano.
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
     * @return il nome della playlist.
     */
    public String getName(){
        return this.playlistName;
    }
    
    /**
     * Il metodo restituisce la dimensione della playlist.
     * @return Dimensione playlist.
     */
    public int getSize(){
        return playlist.length;
    }
    
    /**
     * Il metodo metodo prende come argomento un intero che rappresenta l'indice della canzione ricercata
     * e ne restituisce il tag. 
     * @param index Indice della canzone.
     * @return Tag della canzone in posizione index.
     */
    public String getSongByIndex(int index){
        return songsTags[index];
    }
    
    /**
     * Il metodo restituisce il tag delle canzoni.
     * @return  Tag delle canzoni.
     */
    public String[] getArrayTags() {
        return songsTags;
    }
    
    /**
     * Il metodo restituisce un array di canzoni.
     * @return Array di canzoni.
     */
    public Song[] getArraySongs() {
        return playlist;
    }
    
    //methods modifier
    
    /**
     * Il metodo prende come argomento una canzone e l'aggiunge alla playlist.
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
     * <li>Un numero negativo se il nome della playlist che chiama il metodo
     * è lessicograficamente precedente al nome della playlist passata come argomento </li>
     * <li>Un intero positivo se lessicograficamente seguente al nome della playlist passata come argomento </li>
     * <li>Zero se sono uguali </li>
     * </ul>
     * @param playlist Playlist.
     * @return Ritorna un numero intero.
     */
    public int compareTo(Playlist playlist) {
        return this.playlistName.compareToIgnoreCase(playlist.getName());
    }
    
    //building methods
    /**
     * Il metodo costruisce il pannello della Playlist.
     * @return Il pannello.
     */
    public PlaylistSongsViewPanel buildPlaylistView(){
        return new PlaylistSongsViewPanel(this);
    }
    
    /**
     * Il metodo costruisce il pulsante per creare una Playlist.
     * @return Il pulsante.
     */
    public PlaylistButton buildPlaylistButton(){
        return new PlaylistButton(this);
    }
    
    /**
     * Il metodo compone la stringa con il nome della playlist e i tag
     * delle canzoni che contiene.
     * @return La stringa corrispondente alla playlist.
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
        return finder.searchByBranoTag(Repository.getInstance(), songTag);
    }
    
    private void sortByTags(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortStringsArray(songsTags,false); 
    }
    
    private void sortByTitles(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortTracksByAuthors(playlist);
    }
  
}
 
 