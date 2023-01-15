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
    /**
     * Nome playlist.
     */
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
     * Crea l'oggetto Playlist 
     * @param stringFromFile 
     */
    public Playlist(String stringFromFile){
        this(stringFromFile.split(":")[0], stringFromFile.split(":")[1]);
    }
    
    /**
     * 
     * @param playlistName
     * @param selectedSongs 
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
     * Il metodo metodo prenede come argomento una posizione nella playlist e 
     * restituisce la canazone. 
     * @param index Posizione canzone.
     * @return 
     */
    public String getSongByIndex(int index){
        return songsTags[index];
    }
    
    /**
     * Il metodo restituisce la playlist.
     * @return  playlist.
     */
    public String[] getArrayTags() {
        return songsTags;
    }
    
    /**
     * Il metodo restituisce un'array della playlist.
     * @return 
     */
    public Song[] getArraySongs() {
        return playlist;
    }
    
    //methods modifier
    
    /**
     * 
     * @param newSong 
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
    public int compareTo(Playlist playlist) {
        return this.playlistName.compareToIgnoreCase(playlist.getName());
    }
    
    //building methods
    
    public PlaylistSongsViewPanel buildPlaylistView(){
        return new PlaylistSongsViewPanel(this);
    }
    
    public PlaylistButton buildPlaylistButton(){
        return new PlaylistButton(this);
    }
    
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
    
    /*
    public void removeSong(Song songToRemove) {
        Song[] newPlaylist = new Song[playlist.length-1];
        int counter = 0;
        for(int i = 0; i<playlist.length;i++){
            if(!playlist[i].equalsTo(songToRemove)){
                newPlaylist[counter++] = playlist[i];
            }
        }
        playlist = newPlaylist;
    }
    */
}
 