package emotionalsongs.Engines;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.SorterAlgorithms.SorterPlaylistsDatabaseAlgo.*;
import emotionalsongs.SorterAlgorithms.SorterPlaylistsSetAlgo.*;
import emotionalsongs.SorterAlgorithms.SorterRecordsAlgo.*;
import emotionalsongs.SorterAlgorithms.SorterSongsAlgos.*;
import emotionalsongs.SorterAlgorithms.UserSortingAlgos.*;
import emotionalsongs.SorterAlgorithms.generalSortingAlgos.*;

/**
 *
 * @author big
 */
public class EngineSorter {
    
    //User sort methods
    public void sortUsersById(DataBaseUsers dataBaseUsers){
        SorterUserById sorter = new SorterUserById();
        sorter.mergeSort(dataBaseUsers.getArray());
    }
    
    public void sortUserByCf(DataBaseUsers dataBaseUsers){
        SorterUsersByCF sorter = new SorterUsersByCF();
        sorter.mergeSort(dataBaseUsers.getArray());
    }
    
    //Tracks sort methods
    public void sortTracksByTags(Song[] arrayBrani){
        SorterSongsByTag sorter = new SorterSongsByTag();
        sorter.mergeSort(arrayBrani);
    }
   
    public void sortTracksByTitles(Song[] arrayBrani) {
        SorterSongsByTitle sorter = new SorterSongsByTitle();
        sorter.mergeSort(arrayBrani);
    }

    public void sortTracksByAuthors(Song[] arrayBrani) {
        SorterSongsByAuthor sorter = new SorterSongsByAuthor();
        sorter.mergeSort(arrayBrani);
    }
    
    // records sort method
    public void sortRecords(DataBaseRecords dataBaseEmozioni){
        SorterRecords sorter = new SorterRecords();
        sorter.mergeSort(dataBaseEmozioni.getArray());
    }
    
    //Playlist sort methods
    public void sortSetOfPlaylists(PlaylistSet playlistSet){
        SorterPlaylistSet sorter = new SorterPlaylistSet();
        sorter.mergeSort(playlistSet.getArray());
    }
    
    
    public void sortDataBaseOfPlaylistSet(DataBasePlaylists dataBase){
        SorterDatabasePlaylists sorter = new SorterDatabasePlaylists();
        sorter.mergeSort(dataBase.getArray());
    }
    
    //General sort methods
    public void sortIntArray(int[] arrayInt) {
        SortInt sorter = new SortInt();
        sorter.mergeSort(arrayInt);
    }
    
    public void sortStringsArray(String[] arrayString, boolean caseSensitive){
        HeapSortString sorter = new HeapSortString(caseSensitive);
        sorter.sort(arrayString);
    }
}

