package emotionalsongs.BasicsStructure;

import emotionalsongs.Engines.*;
import java.io.*;

/**
 *  La classe si occupa di creare e di registrare la Playlist.
 * @author Luca
 * @version 1.4
 *
 */
public class Playlist {

    //campi
    /**
     * Nome playlist.
     */
    String playlistName;//no special characters ;

    String[] songsTags;

    //costruttore
    /**
     * Crea l'oggetto Playlist prendendo come argomenti un oggetto owner di tipo User,
        un oggetto playlistName di tipo String e un oggetto playlist di tipo ArrayList<Brano>.
     * @throws IOException 
     */
    public Playlist(String nomePlaylist,String listaCanzoniPlaylist) {
        this.playlistName = nomePlaylist;
        this.songsTags = listaCanzoniPlaylist.split(",");
        //sort();
    }
    
    public Playlist(String stringFromFile){
        this(stringFromFile.split(":")[0], stringFromFile.split(":")[1]);
    }
    
    public Playlist(String playlistName,Song[] selectedSongs){
        this.playlistName = playlistName;
        this.songsTags = new String[selectedSongs.length];
        for(int i = 0; i<selectedSongs.length;i++){
            songsTags[i] = selectedSongs[i].getTag();
            System.out.println("song"+selectedSongs[i].getTitle());
        }
        //sort();
    }
    //Getter methods
    /**
     * Il metodo restituisce una Stringa con il nome della playlist.
     * @return il nome della playlist.
     */
    public String getName(){
        return this.playlistName;
    }
    
    public int getSize(){
        return songsTags.length;
    }
    
    public String get(int index){
        return songsTags[index];
    }
    
    /**
     * Il metodo preleva il songTag e lo aggiunge alla playlist.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void add(String songTag) {
        String[] newOne = new String[songsTags.length+1];
        for(int i = 0;i<songsTags.length;i++){
            newOne[i] = songsTags[i];
        }
        newOne[newOne.length-1] = songTag;
        sort();
    }

    /**
     * Il metodo restituisce la playlist.
     * @return  playlist.
     */
    public String[] getArray() {
        return songsTags;
    }
    
    public String componiStringa(){
        sort();
        String stringa = playlistName+":"; 
        for (int i = 0; i < songsTags.length; i++) {
            stringa += i>0 ? "," + songsTags[i] : songsTags[i];
        }
        return stringa + ";";
    }
    
    public void sort(){
        EngineSorter sorter = new EngineSorter();
        //sorter.sortStringsArray(songsTags,false); capire perchè non funge!
    }

    public int compareTo(Playlist playlist) {
        return this.playlistName.compareToIgnoreCase(playlist.getName());
    }
}
 