/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.engines;

import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import java.util.*;

/**
 * Classe le cui istanze offrono metodi per effetture ricerche di dati all'interno del database delle valutazioni emozionali.
 */
public class EngineSearcher {

    private Repository repository = Repository.getInstance();
    
    //metodi di ricerca canzoni
    /**
     * Il metodo permette di effettuare la ricerca di una canzone per:
     * <ul>
     * <li>Titolo, se sono presenti nell'argomento passato alla funzione;</li>
     * <li>Autore ed anno se questi sono presenti nell'argomento passato alla funzione.</li>
     * </ul>
     * @param stringaCercata Criterio di ricerca.
     * @return Un array di brani che corrispondono ai criteri di ricerca passati come argomento.
     */
    public Song[] cercaBranoMusicale(String stringaCercata){
        
        if(stringaCercata.contains(";")){
            String autore = stringaCercata.split(";")[0];
            String anno = stringaCercata.split(";")[1];
            return ricercaPerAutoreEdAnno(autore,anno);
        } 
        
        return ricercaPerTitolo(stringaCercata);    
    }   
    
    /**
     * Il metodo effettua la ricerca per titolo nel repository di brani e salva i risultati in un array di brani.
     * @param title titolo del brano da cercare.
     * @return Un array contenente tutti i brani che contengono nel titolo la parola cercata.
     */
    private Song[] ricercaPerTitolo(String title){
        
        
        ArrayList<Song> resultsList = new ArrayList<>();
        Song[] resultsArray;
        
        for(int i = 0;i<repository.getSize();i++){
            Song current = repository.getBrano(i);
            String currentTitle = current.getTitle().toLowerCase();
            if (currentTitle.contains(title.toLowerCase())){
                resultsList.add(current);
            }
        }
        if(resultsList.isEmpty()) return null;
        resultsArray=new Song[resultsList.size()];
        for(int i = 0;i<resultsList.size();i++){
            resultsArray[i] = resultsList.get(i);
        }
        sortByTitle(resultsArray);
        
        return resultsArray;
        
    }
    
    /**
     * Il metodo effettua la ricerca per autore ed anno e restituisce i risultati 
     * in un array di brani.
     * @param autore - nome dell'autore del brano.
     * @param anno - anno di pubblicazione del brano.
     * @return Array di canzoni aventi come autore ed anno quelli ricercati.
     */
    private Song[] ricercaPerAutoreEdAnno(String autore, String anno){
        
        ArrayList<Song> resultsList = new ArrayList<>();
        Song[] results;
        
        for(int i = 0;i<repository.getSize();i++){
            Song current = repository.getBrano(i);
            String currentAuthor = current.getAuthor().toLowerCase();
            if (currentAuthor.toLowerCase().contains(autore.toLowerCase()) && current.getYear()==Integer.parseInt(anno)){
                resultsList.add(current);
            }
        }
        if(resultsList.isEmpty()) return null;
        results = new Song[resultsList.size()];
        for (int i = 0; i < resultsList.size(); i++) {
            results[i] = resultsList.get(i);
        }
        sortByAuthor(results);
        
        return results;
    }
    
    /**
     * Il metodo prende come parametri un repository di canzoni ed un songTag, ed effettua la ricerca del brano associato.
     * @param repository Repository in cui cercare.
     * @param songTag Tag della canzone da cercare.
     * 
     */
    public Song searchBySongTag(Repository repository,String songTag) {
        
        int size = repository.getSize();
        for (int i = 0; i < size; i++) {
            if(repository.getBrano(i).getTag().equals(songTag)) return repository.getBrano(i);
        }
        return null;
    }
    
    //metodi ricerca utenti nel database
    /**
     * Il metodo prende come parametri il codice fiscale e il database utenti ed
     * effettua una ricerca nel databse dell'utente a cui i dati sono associati.
     * @param database DataBaseUsers interrogato.
     * @param cf Codice Fiscale. 
     * @return Utente il cui CF coincide con quello passato come argomento.
     */
    public User searchUserFromCF(DataBaseUsers database,String cf) {
        
        new EngineSorter().sortUserByCf(database);
        int size = database.getSize();
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = (low+high)/2;
            User pointedUser = database.getUser(mid);
            String userPointedCf = pointedUser.getCF();
            if(userPointedCf.equalsIgnoreCase(cf)) return pointedUser;
            else if(cf.compareToIgnoreCase(userPointedCf)<0) high = mid-1;
            else low = mid+1;
        }
        return null;

    }
    
    /**
     * Il metodo prende come parametri un id utente e il database utenti ed
     * effettua una ricerca nel databse dell'utente associato ai dati.
     * @param dataBaseUsers DataBaseUser.
     * @param id id utente da cercare. 
     * @return Utente il cui Id coincide con quello passato come argomento.
     */
    public User getUserFromId(DataBaseUsers dataBaseUsers,String id) {
        
        int size = dataBaseUsers.getSize();
        /*
        for(int i = 0; i<size;i++){
            if(dataBaseUsers.getUser(i).getUserId().equalsIgnoreCase(id)) return dataBaseUsers.getUser(i);
        }
        */
        new EngineSorter().sortUsersById(dataBaseUsers);
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = (low+high)/2;
            User pointedUser = dataBaseUsers.getUser(mid);
            String userPointedId = pointedUser.getUserId();
            if(userPointedId.equalsIgnoreCase(id)) return pointedUser;
            else if(id.compareToIgnoreCase(userPointedId)<0) high = mid-1;
            else low = mid+1;
        }
        return null;
    }
    
    //metodi di ricerca records
    /**
     * Metodo che ritorna un giudizio emozionale relativo al brano rappresentato dal tag passato come argomento, nel database, anche questo passato come argomento.
     * @param dataBase Database in cui effettuare la ricerca.
     * @param branoTag Tag del brano di cui cercarne i giudizi emozionali.
     * @return il giudizio emozionale del brano rappresentato dal tag.
     */
    public EmotionalJudgement getJudgementFromSongTag(DataBaseJudgements dataBase, String branoTag){
        if(dataBase == null) return null;
        int size = dataBase.getSize();
        EngineSorter sorter = new EngineSorter();
        sorter.sortJudgements(dataBase);
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = (low+high)/2;
            EmotionalJudgement pointedRecord = dataBase.getRecordFromIndex(mid);
            String pointedTag = pointedRecord.getBranoTag();
            if(pointedTag.equals(branoTag)) return pointedRecord;
            else if(branoTag.compareTo(pointedTag)<0) high = mid-1;
            else low = mid+1;
        }
        return null;
    }
    
    //metodi di ricerca playlist
    /**
     * Metodo che ricerca il PlaylistSet dell'utente passato come argomento, nel database anch'esso passato come argomento.
     * @param user Utente da ricercare.
     * @param dataBasePlaylists Database in cui effettuare la ricerca.
     * @return Il PlaylistSet del utente.
     */
    public PlaylistsSet searchUserSet(User user,DataBasePlaylists dataBasePlaylists) {
        
        PlaylistsSet[] sets = dataBasePlaylists.getArray();
        if(sets == null) return null;        
        new EngineSorter().sortDataBaseOfPlaylistSet(dataBasePlaylists);
        int size = dataBasePlaylists.getSize();
        
        for (int i = 0; i < size; i++) {
            if(dataBasePlaylists.getSet(i).getOwnerId().equals(user.getUserId())) return dataBasePlaylists.getSet(i);
        }
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = (low+high)/2;
            PlaylistsSet pointedSet = dataBasePlaylists.getSet(mid);
            String pointedSetUser = pointedSet.getOwnerId();
            if(pointedSetUser.equals(user.getUserId())) return pointedSet;
            else if(pointedSetUser.compareTo(user.getUserId())<0) high = mid-1;
            else low = mid+1;
        }
        return null;
    }
    
    /**
     * Metodo che ritorna la posizione del giudizio emozionale relativo al brano rappresentato dal tag 
     * passato come argomento, nel database passato anch'esso come argomento.
     * @param dataBase Database in cui cercare.
     * @param branoTag Tag del brano di cui cercare il giudizio emozionale.
     * @return Posizione del giudizio emozionale del brano corrispondente al tag, all'interno del database.
     */
    public int searchJudgementIndexBySongTag(DataBaseJudgements dataBase, String branoTag) {
        if(!(dataBase == null)){
            int size = dataBase.getSize();
            EngineSorter sorter = new EngineSorter();
            sorter.sortJudgements(dataBase);
        
            int low = 0;
            int high = size-1;
            while(low<=high){
                int mid = (low+high)/2;
                EmotionalJudgement pointedRecord = dataBase.getRecordFromIndex(mid);
                String pointedTag = pointedRecord.getBranoTag();
                if(pointedTag.equals(branoTag)) return mid;
                else if(branoTag.compareTo(pointedTag)<0) high = mid-1;
                else low = mid+1;
            }    
        }
        return -1;
    }
    
    //supportMethods
    
    private void sortByAuthor(Song[] tracks){
        if(tracks[0] != null && tracks.length > 1){
            EngineSorter sorter = new EngineSorter();
            sorter.sortSongsByAuthors(tracks);
        }
    }
    
    private void sortByTitle(Song[] tracks){
        if(tracks[0] != null && tracks.length > 1){
            EngineSorter sorter = new EngineSorter();
            sorter.sortSongsByTitles(tracks);
        }
    }
    
}
