//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

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
    /**
     * Il metodo prende come parametro il Database di UserID e gli mette in ordine alfabetico.
     * @param dataBaseUsers 
     */
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
    public void sortJudgements(DataBaseJudgements dataBaseEmozioni){
        SorterJudgements sorter = new SorterJudgements();
        sorter.sort(dataBaseEmozioni.getArray());
    }
    
    //Playlist sort methods
    public void sortSetOfPlaylists(PlaylistSet playlistSet){
        SorterPlaylistSet sorter = new SorterPlaylistSet();
        sorter.mergeSort(playlistSet.getArray());
    }
    
    
    public void sortDataBaseOfPlaylistSet(DataBasePlaylists dataBase){
        SorterDatabasePlaylists sorter = new SorterDatabasePlaylists();
        sorter.sort(dataBase.getArray());
    }
    
    //General sort methods
    public void sortIntArray(int[] arrayInt) {
        SortInt sorter = new SortInt();
        sorter.sort(arrayInt);
    }
    
    public void sortStringsArray(String[] arrayString, boolean caseSensitive){
        SortString sorter = new SortString();
        sorter.sort(arrayString,caseSensitive);
    }
}

