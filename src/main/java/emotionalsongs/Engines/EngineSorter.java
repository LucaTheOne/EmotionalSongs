package emotionalsongs.Engines;

import emotionalsongs.DataBases.*;
import emotionalsongs.HeapSorter.*;
import emotionalsongs.BasicsStructure.PlaylistSet;
import emotionalsongs.BasicsStructure.Song;

/**
 *
 * @author big
 */
public class EngineSorter {
    
    //User sort methods
    public void sortUsersById(DataBaseUsers dataBaseUsers){
        HeapSortId heap = new HeapSortId();
        heap.sort(dataBaseUsers.getArray());
    }
    
    public void sortUserByCf(DataBaseUsers dataBaseUsers){
        HeapSortCf heap = new HeapSortCf();
        heap.sort(dataBaseUsers.getArray());
    }
    
    //Tracks sort methods
    public void sortTracksByTags(Song[] arrayBrani){
        HeapSortTag heap = new HeapSortTag();
        heap.sort(arrayBrani);
    }
   
    public void sortTracksByTitles(Song[] arrayBrani) {
        HeapSortTitle heap = new HeapSortTitle();
        heap.sort(arrayBrani);
    }

    public void sortTracksByAuthors(Song[] arrayBrani) {
        HeapSortAuthor heap = new HeapSortAuthor();
        heap.sort(arrayBrani);
    }
    
    // records sort method
    public void sortRecords(DataBaseRecords dataBaseEmozioni){
        HeapSortRecord heap = new HeapSortRecord();
        heap.sort(dataBaseEmozioni.getArray());
    }
    
    //Playlist sort methods
    public void sortSetOfPlaylists(PlaylistSet playlistSet){
        HeapSortPlaylistSet heap = new HeapSortPlaylistSet();
        heap.sort(playlistSet.getArray());
    }
    
    
    public void sortDataBaseOfPlaylistSet(DataBasePlaylists dataBase){
        HeapSortDatabasePlaylists heap = new HeapSortDatabasePlaylists();
        heap.sort(dataBase.getArray());
    }
    
    //General sort methods
    public void sortIntArray(int[] arrayInt) {
        HeapSortInt heap = new HeapSortInt();
        heap.sort(arrayInt);
    }
    
    public void sortStringsArray(String[] arrayString, boolean caseSensitive){
        HeapSortString heap = new HeapSortString(caseSensitive);
        heap.sort(arrayString);
    }
}

