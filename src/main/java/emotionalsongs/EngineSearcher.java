package emotionalsongs;

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

    public ArrayList<Brano> risultatiRicerca = new ArrayList<>();
    public Repository repository = EMOTIONALSONGS.REPOSITORY;
    
    //metodi di ricerca canzoni
    /**
     * Il metodo permette di selezionare la modalita di ricerca per autore ed anno opppure
     * per titolo.
     * @param stringaCercata 
     * @return il brano, in base alla tipologia di ricerca scelta, per autore ed anno o per titolo.
     */
    public Brano[] cercaBranoMusicale(String stringaCercata){
        
        if(stringaCercata.contains(";")){
            String autore = stringaCercata.split(";")[0];
            String anno = stringaCercata.split(";")[1];
            return ricercaPerAutoreEdAnno(autore,anno);
        } 
        
        return ricercaPerTitolo(stringaCercata);    
    }   
    
    /**
     * Il metodo effettua la ricerca per titolo nella repository di brani e li 
     * salva in un array di brani.
     * @param titolo - del brano.
     * @return il brano ricercato.
     */
    private Brano[] ricercaPerTitolo(String titolo){
        
        ArrayList<Brano> resultsList = new ArrayList<>();
        Brano[] resultsArray;
        
        for(int i = 0;i<repository.getSize();i++){
            Brano current = repository.getBrano(i);
            String currentTitle = current.getTitle().toLowerCase();
            if (currentTitle.contains(titolo.toLowerCase())){
                resultsList.add(current);
            }
        }
        if(resultsList.isEmpty()) return null;
        resultsArray=new Brano[resultsList.size()];
        for(int i = 0;i<resultsList.size();i++){
            resultsArray[i] = resultsList.get(i);
        }
        sortByTitle(resultsArray);
        
        return resultsArray;
    }
    
    /**
     * Il metodo effettua la ricerca per autore ed anno e salva low risultati 
 di ricerca in un arraylist di brani.
     * @param autore - del brano.
     * @param anno - del brano.
     * @return il brano ricercato.
     */
    private Brano[] ricercaPerAutoreEdAnno(String autore, String anno){
        
        ArrayList<Brano> resultsList = new ArrayList<>();
        Brano[] results;
        
        for(int i = 0;i<repository.getSize();i++){
            Brano current = repository.getBrano(i);
            String currentAuthor = current.getAuthor().toLowerCase();
            if (currentAuthor.equalsIgnoreCase(autore) && current.getYear()==Integer.parseInt(anno)){
                resultsList.add(current);
            }
        }
        if(resultsList.isEmpty()) return null;
        results = new Brano[resultsList.size()];
        for (int i = 0; i < resultsList.size(); i++) {
            results[i] = resultsList.get(i);
        }
        sortByAuthor(results);
        
        return results;
    }
    
    Brano searchBranoTag(Repository repository,String id) {
        repository.sortByTags();
        int size = repository.getSize();
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = low+high/2;
            Brano pointedBrano = repository.getBrano(mid);
            String pointedBranoTag = pointedBrano.getTag();
            if(pointedBrano.equals(id)) return pointedBrano;
            else if(id.compareTo(pointedBranoTag)<0) high = mid-1;
            else low = mid+1;
        }
        return null;
    }
    
    //metodi ricerca utenti nel database
    
    Utente getUserFromCf(DataBaseUtenti database,String cf) {
        
        int size = database.getSize();
        
        if(size<1000){
            for (int i = 0; i < size; i++) {
                Utente user = database.getUser(i);
                if(user.getCF().equalsIgnoreCase(cf)){
                    return user;
                }
            }
            
            return null;
        }
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = low+high/2;
            Utente pointedUser = database.getUser(mid);
            String userPointedCf = pointedUser.getCF();
            if(userPointedCf.equalsIgnoreCase(cf)) return pointedUser;
            else if(cf.compareToIgnoreCase(userPointedCf)<0) high = mid-1;
            else low = mid+1;
        }
        return null;

    }

    Utente getUserFromId(DataBaseUtenti dataBaseUtenti,String id) {
        
        int size = dataBaseUtenti.getSize();
        
        
        if(size<1000){
            for (int i = 0; i < size; i++) {
                Utente user = dataBaseUtenti.getUser(i);
                if(user.getUserId().equalsIgnoreCase(id)){
                    return user;
                }
            }
            
            return null;
        }
        
        EngineSorter sorter = new EngineSorter();
        sorter.sortUsersById(dataBaseUtenti);
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = low+high/2;
            Utente pointedUser = dataBaseUtenti.getUser(mid);
            String userPointedId = pointedUser.getUserId();
            if(userPointedId.equalsIgnoreCase(id)) return pointedUser;
            else if(id.compareToIgnoreCase(userPointedId)<0) high = mid-1;
            else low = mid+1;
        }
        return null;
    }

    Utente[] getUsersFromId(DataBaseUtenti userDataBase, String stringaIds) {
        String[] splittedString = stringaIds.split(",");
        Utente[] utenti = new Utente[splittedString.length];
        int posCounter = 0;
        
        EngineSorter sorter = new EngineSorter();
        sorter.sortUsersById(userDataBase);
        int size = userDataBase.getSize();
        for (int i = 0; i < utenti.length; i++) {
            String id = splittedString[i];
            int low = 0;
            int high = size-1;
            while(low<=high){
                int mid = low+high/2;
                Utente pointedUser = userDataBase.getUser(mid);
                String userPointedId = pointedUser.getUserId();
                if(userPointedId.equalsIgnoreCase(id)) {
                    utenti[posCounter++]=pointedUser;
                    break;
                }
                else if(id.compareToIgnoreCase(userPointedId)<0) high = mid-1;
                else low = mid+1;
            }
        }
        return utenti;
    }
    
    //supportMethods
    private void addTo(Brano[] array,Brano track){
        if(array.length == 1) array[0] = track;
        else {
            Brano[] newOne = new Brano[array.length+1];
            for (int i = 0; i < array.length; i++) {
                newOne[i] = array[i];
            }
            newOne[array.length] = track;
            array=newOne;
        }    
    }
    
    private void sortByAuthor(Brano[] tracks){
        if(tracks[0] != null && tracks.length > 1){
            EngineSorter sorter = new EngineSorter();
            sorter.sortTracksByAuthors(tracks);
        }
    }
    
    private void sortByTitle(Brano[] tracks){
        if(tracks[0] != null && tracks.length > 1){
            EngineSorter sorter = new EngineSorter();
            sorter.sortTracksByTitles(tracks);
        }
    }
}
