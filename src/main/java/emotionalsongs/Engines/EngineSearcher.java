//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.engines;

import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import java.util.*;

/**
 * Classe adibita alla ricerca di canzoni all' interno del repository di canzoni
 * tramite due tipologie di ricerca:
 * <ul>
 * <li>Ricerca per autore ed anno
 * <li>Ricerca per titolo.
 * </ul>
 * @author Luca
 * @version 1.2
 */
public class EngineSearcher {

    private Repository repository = Repository.getInstance();
    
    //metodi di ricerca canzoni
    /**
     * Il metodo permette di selezionare la modalita di ricerca per autore ed anno opppure
     * per titolo.
     * @param stringaCercata 
     * @return il brano, in base alla tipologia di ricerca scelta, per autore ed anno o per titolo.
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
     * Il metodo effettua la ricerca per title nella repository di brani e li 
 salva in un array di brani.
     * @param title - del brano.
     * @return il brano ricercato.
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
     * Il metodo effettua la ricerca per autore ed anno e salva low risultati 
     * di ricerca in un arraylist di brani.
     * @param autore - del brano.
     * @param anno - del brano.
     * @return il brano ricercato.
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
     * Il metodo prende come parametri la repository e songTag ed effettua la ricerca.
     * @param repository 
     * @param songTag
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
     * Il metodo prende come parametri il codice fiscale e database ed
     * effettua una ricerca nella databse dell'userID.
     * @param database DataBaseUser.
     * @param cf Codice Fiscale. 
     * @return userID.
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
     * 
     * @param dataBaseUsers
     * @param id
     * @return 
     */
    public User getUserFromId(DataBaseUsers dataBaseUsers,String id) {
        
        int size = dataBaseUsers.getSize();
        
        for(int i = 0; i<size;i++){
            if(dataBaseUsers.getUser(i).getUserId().equalsIgnoreCase(id)) return dataBaseUsers.getUser(i);
        }
        /*
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
        }*/
        return null;
    }
    
    //metodi di ricerca records
    /**
     * 
     * @param dataBase
     * @param branoTag
     * @return 
     */
    public UserJudgement getJudgementFromSongTag(DataBaseJudgements dataBase, String branoTag){
        if(dataBase == null) return null;
        int size = dataBase.getSize();
        EngineSorter sorter = new EngineSorter();
        sorter.sortJudgements(dataBase);
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = (low+high)/2;
            UserJudgement pointedRecord = dataBase.getRecordFromIndex(mid);
            String pointedTag = pointedRecord.getBranoTag();
            if(pointedTag.equals(branoTag)) return pointedRecord;
            else if(branoTag.compareTo(pointedTag)<0) high = mid-1;
            else low = mid+1;
        }
        return null;
    }
    
    //metodi di ricerca playlist
    /**
     * 
     * @param user
     * @param dataBasePlaylists
     * @return 
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
     * 
     * @param dataBase
     * @param branoTag
     * @return 
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
                UserJudgement pointedRecord = dataBase.getRecordFromIndex(mid);
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
            sorter.sortTracksByAuthors(tracks);
        }
    }
    
    private void sortByTitle(Song[] tracks){
        if(tracks[0] != null && tracks.length > 1){
            EngineSorter sorter = new EngineSorter();
            sorter.sortTracksByTitles(tracks);
        }
    }
    
}
