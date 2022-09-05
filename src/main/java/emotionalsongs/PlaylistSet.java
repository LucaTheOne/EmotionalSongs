package emotionalsongs;

/**
 *
 * @author alexandruboitor
 */
public class PlaylistSet {
   
    //campi
    private Playlist[] playlistArray;
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
        playlistArray = newOne;
    }
    
    public PlaylistSet(String idOwner,Playlist[] playlists){
        this.idOwner = idOwner;
        playlistArray = playlists;
        sort();
    }
    
    public PlaylistSet(String idOwner, Playlist singlePlaylist){
        this.idOwner = idOwner;
        playlistArray = new Playlist[1];
        playlistArray[0] = singlePlaylist;
    }
    
    //getterMethod
    public Playlist[] getArray(){
        return this.playlistArray;
    }
    
    public int getSize(){
        return playlistArray.length;
    }
     
    public String getOwnerId(){
        return idOwner;
    }
    //setter methods
    /**
     * 
     * @param playlist 
     */    
    public void add(Playlist playlist){
        Playlist[] newOne = new Playlist[playlistArray.length+1];
        for (int i = 0; i < playlistArray.length; i++) {
            newOne[i] = playlistArray[i];
        }
        newOne[newOne.length-1] = playlist;
        playlistArray = newOne;
        //sort();
    }
    
    //sorter method
    private void sort(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortSetOfPlaylists(this);
    }
    
    //String methods
    public String componiStringa(){
        String stringa = idOwner+";";
        for (int i = 0; i < playlistArray.length; i++) {
            stringa += playlistArray[i].componiStringa();
        }
        return stringa+"\n";
    }

    Playlist getPlaylist(int index) {
        return playlistArray[index];
    }

    int compareTo(PlaylistSet playlistSet) {
        return this.idOwner.compareToIgnoreCase(playlistSet.getOwnerId());
    }

     
}

