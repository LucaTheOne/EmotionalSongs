/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.engines;

import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.sorting_algos.general_sorting_algos.*;
import emotionalsongs.sorting_algos.judgements_sorting_algo.*;
import emotionalsongs.sorting_algos.playlists_database_sorting_algo.*;
import emotionalsongs.sorting_algos.playlists_set_sorting_algo.*;
import emotionalsongs.sorting_algos.songs_sorting_algos.*;
import emotionalsongs.sorting_algos.users_sorting_algos.*;

/**
 * Classe le cui istanze offrono metodi per effettuare degli ordinamenti di insiemi di dati.
 */
public class EngineSorter {
    
    //User sort methods
    /**
     * Il metodo prende come parametro il Database di Utenti e lo ordina alfabeticamente relativamente agli
     * ID degli utenti.
     * @param dataBaseUsers Database da ordinare.
     */
    public void sortUsersById(DataBaseUsers dataBaseUsers){
        SorterUserById sorter = new SorterUserById();
        sorter.mergeSort(dataBaseUsers.getArray());
    }
    /**
     * Il metodo prende come parametro il Database di Utenti e lo ordina alfabeticamente relativamente ai
     * CF degli utenti.
     * @param dataBaseUsers Database da ordinare.
     */
    public void sortUserByCf(DataBaseUsers dataBaseUsers){
        SorterUsersByCF sorter = new SorterUsersByCF();
        sorter.mergeSort(dataBaseUsers.getArray());
    }
    
    //Tracks sort methods
    /**
     * Metodo che riordina un array di canzoni alfabeticamente in base ai loro tag.
     * @param arrayBrani Array di canzoni da riordinare.
     */
    public void sortSongsByTags(Song[] arrayBrani){
        SorterSongsByTag sorter = new SorterSongsByTag();
        sorter.mergeSort(arrayBrani);
    }
    /**
     * Metodo che riordina un array di canzoni alfabeticamente in base ai loro titoli.
     * @param arrayBrani Array di canzoni da riordinare.
     */
    public void sortSongsByTitles(Song[] arrayBrani) {
        SorterSongsByTitle sorter = new SorterSongsByTitle();
        sorter.mergeSort(arrayBrani);
    }
    /**
     * Metodo che riordina un array di canzoni alfabeticamente in base ai loro Autori.
     * @param arrayBrani Array di canzoni da riordinare.
     */
    public void sortSongsByAuthors(Song[] arrayBrani) {
        SorterSongsByAuthor sorter = new SorterSongsByAuthor();
        sorter.mergeSort(arrayBrani);
    }
    
    /**
     * Metodo per riordinare il database dei giudizi emozionali alfabeticamente rispetto ai tag delle canzoni giudicate.
     * @param dataBaseEmozioni database da riordinare.
     */
    public void sortJudgements(DataBaseJudgements dataBaseEmozioni){
        SorterJudgements sorter = new SorterJudgements();
        sorter.sort(dataBaseEmozioni.getArray());
    }
    
    /**
     * Metodo per riordinare un insieme di playlist alfabeticamente rispetto ai loro nomi.
     * @param playlistSet Set di playlist da riordinare.
     */
    public void sortSetOfPlaylists(PlaylistsSet playlistSet){
        SorterPlaylistSet sorter = new SorterPlaylistSet();
        sorter.mergeSort(playlistSet.getArray());
    }
    
    /**
     * Metodo che riordina un DataBase di PlaylistSet alfabeticamente rispetto agli ID dei loro proprietari.
     * @param dataBase Database da riordinare.
     */
    public void sortDataBaseOfPlaylistSet(DataBasePlaylists dataBase){
        SorterDatabasePlaylists sorter = new SorterDatabasePlaylists();
        sorter.sort(dataBase.getArray());
    }
    
    //General sort methods
    /**
     * Metodo che ordina, in ordine crescente, un array di interi passato come argomento.
     * @param arrayInt Arrai di interi da ordinare.
     */
    public void sortIntArray(int[] arrayInt) {
        SorterInt sorter = new SorterInt();
        sorter.sort(arrayInt);
    }
    /**
     * Metodo che riordina un array di stringhe alfabeticamente.
     * Il parametro caseSensitive identifica se l'ordinamento deve tenere conto delle lettere capitalizzate.
     * @param arrayString Array di stringhe da ordinare.
     * @param caseSensitive true -> Tiene conto delle capitalizzazioni, false -> non tiene conto delle capitalizzazioni.
     */
    public void sortStringsArray(String[] arrayString, boolean caseSensitive){
        SorterString sorter = new SorterString();
        sorter.sort(arrayString,caseSensitive);
    }
}

