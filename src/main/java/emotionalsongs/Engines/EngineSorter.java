//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.engines;

import emotionalsongs.basic_structures.PlaylistsSet;
import emotionalsongs.basic_structures.Song;
import emotionalsongs.data_structures.DataBaseJudgements;
import emotionalsongs.data_structures.DataBasePlaylists;
import emotionalsongs.data_structures.DataBaseUsers;
import emotionalsongs.sorting_algos.general_sorting_algos.*;
import emotionalsongs.sorting_algos.judgements_sorting_algo.SorterJudgements;
import emotionalsongs.sorting_algos.playlists_database_sorting_algo.*;
import emotionalsongs.sorting_algos.playlists_set_sorting_algo.*;
import emotionalsongs.sorting_algos.songs_sorting_algos.*;
import emotionalsongs.sorting_algos.users_sorting_algos.*;

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
    public void sortSetOfPlaylists(PlaylistsSet playlistSet){
        SorterPlaylistSet sorter = new SorterPlaylistSet();
        sorter.mergeSort(playlistSet.getArray());
    }
    
    
    public void sortDataBaseOfPlaylistSet(DataBasePlaylists dataBase){
        SorterDatabasePlaylists sorter = new SorterDatabasePlaylists();
        sorter.sort(dataBase.getArray());
    }
    
    //General sort methods
    public void sortIntArray(int[] arrayInt) {
        SorterInt sorter = new SorterInt();
        sorter.sort(arrayInt);
    }
    
    public void sortStringsArray(String[] arrayString, boolean caseSensitive){
        SorterString sorter = new SorterString();
        sorter.sort(arrayString,caseSensitive);
    }
}

