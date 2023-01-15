//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.BasicsStructure;

import emotionalsongs.*;
import emotionalsongs.Engines.*;

/**
 *
 * @author alexandruboitor
 */
public class PlaylistSet {
   
    //campi
    private Playlist[] set;
    private String idOwner;
    //costructors
    /**
     * 
     */
    public PlaylistSet(String stringFromFile){
        String[] str = stringFromFile.split(";"); 
        idOwner = str[0];
        Playlist[] newOne = new Playlist[str.length-1];
        for(int i = 1;i<str.length;i++){
            newOne[i-1] = new Playlist(str[i]);
        }
        set = newOne;
    }
    
    public PlaylistSet(String idOwner,Playlist[] playlists){
        this.idOwner = idOwner;
        set = playlists;
        sort();
    }
    
    public PlaylistSet(String idOwner, Playlist singlePlaylist){
        this.idOwner = idOwner;
        set = new Playlist[1];
        set[0] = singlePlaylist;
    }
    
    //getterMethod
    public Playlist[] getArray(){
        return this.set;
    }
    
    public int getSize(){
        return set.length;
    }
     
    public String getOwnerId(){
        return idOwner;
    }
    //setter methods
    /**
     * 
     * @param playlist 
     */    
    public void addPlaylist(Playlist playlist){
        Playlist[] newOne = new Playlist[set.length+1];
        for (int i = 0; i < set.length; i++) {
            newOne[i] = set[i];
        }
        newOne[newOne.length-1] = playlist;
        EMOTIONALSONGS.getUserSet().updateSet(newOne);
        if(set.length >1){
            sort();
        }
    }
    
    //sorter method
    private void sort(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortSetOfPlaylists(this);
    }
    
    //String methods
    public String componiStringa(){
        String stringa = idOwner+";";
        for (int i = 0; i < set.length; i++) {
            stringa += set[i].composeString();
        }
        return stringa+"\n";
    }

    public Playlist getPlaylist(int index) {
        return set[index];
    }

    public int compareTo(PlaylistSet playlistSet) {
        return this.idOwner.compareTo(playlistSet.getOwnerId());
    }

    public void updateSet(Playlist[] newSet) {
        this.set = newSet;
        
    }  
    /*
    public void removePlaylist(Playlist playlistToDelete) {
        int counter = 0;
        Playlist[] newSet = new Playlist[set.length-1];
        for (int i = 0; i < set.length; i++) {
            if(set[i].equals(playlistToDelete)) set[i] = null;    
        }
        
        for (int i = 0; i < set.length; i++) {
            if(set[i] == null) continue;
            newSet[counter++] = set[i];
        }
        
        set = newSet;
        DataBasePlaylists.getInstance().save();
    }*/
}

