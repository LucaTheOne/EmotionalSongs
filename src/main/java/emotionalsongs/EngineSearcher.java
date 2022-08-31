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
     * salva in un arraylist di brani.
     * @param titolo - del brano.
     * @return il brano ricercato.
     */
    private Brano[] ricercaPerTitolo(String titolo){
        
        ArrayList<Brano> risultatiLista = new ArrayList<>();
        
        for(int i = 0;i<repository.getDimensioneRepository();i++){
            Brano corrente = repository.getBrano(i);
            if (corrente.getTitle().toLowerCase().contains(titolo.toLowerCase())){
                risultatiRicerca.add(corrente);
            }
        }
        
        Brano[] risultatiRicerca = new Brano[risultatiLista.size()];
        for (int i = 0; i < risultatiRicerca.length; i++) {
            risultatiRicerca[i] = risultatiLista.get(i);
        }
        
        return risultatiRicerca;
    }
    
    /**
     * Il metodo effettua la ricerca per autore ed anno e salva low risultati 
 di ricerca in un arraylist di brani.
     * @param autore - del brano.
     * @param anno - del brano.
     * @return il brano ricercato.
     */
    private Brano[] ricercaPerAutoreEdAnno(String autore, String anno){

        ArrayList<Brano> risultatiLista = new ArrayList<>();
        
        for(int i = 0;i<repository.getDimensioneRepository();i++){
            Brano branoCorrente = repository.getBrano(i);
            if (branoCorrente.getAuthor().equalsIgnoreCase(autore) && branoCorrente.getYear().equalsIgnoreCase(anno)){
                risultatiRicerca.add(branoCorrente);
            }
        }
        
        Brano[] risultatiRicerca = new Brano[risultatiLista.size()];
        for (int i = 0; i < risultatiRicerca.length; i++) {
            risultatiRicerca[i] = risultatiLista.get(i);
        }
        
        return risultatiRicerca;
    }
    
    Brano cercaBranoTag(Repository repository,String id) {
        repository.sortRepoByTags();
        int size = repository.getDimensioneRepository();
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
        
        int size = database.getDimensione();
        
        if(size<1000){
            for (int i = 0; i < size; i++) {
                Utente user = database.get(i);
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
            Utente pointedUser = database.get(mid);
            String userPointedCf = pointedUser.getCF();
            if(userPointedCf.equalsIgnoreCase(cf)) return pointedUser;
            else if(cf.compareToIgnoreCase(userPointedCf)<0) high = mid-1;
            else low = mid+1;
        }
        return null;

    }

    Utente getUserFromId(DataBaseUtenti dataBaseUtenti,String id) {
        
        int size = dataBaseUtenti.getDimensione();
        
        
        if(size<1000){
            for (int i = 0; i < size; i++) {
                Utente user = dataBaseUtenti.get(i);
                if(user.getUserId().equalsIgnoreCase(id)){
                    return user;
                }
            }
            
            return null;
        }
        
        EngineSorter sorter = new EngineSorter();
        sorter.sortDatabaseById(dataBaseUtenti);
        
        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = low+high/2;
            Utente pointedUser = dataBaseUtenti.get(mid);
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
        sorter.sortDatabaseById(userDataBase);
        int size = userDataBase.getDimensione();
        for (int i = 0; i < utenti.length; i++) {
            String id = splittedString[i];
            int low = 0;
            int high = size-1;
            while(low<=high){
                int mid = low+high/2;
                Utente pointedUser = userDataBase.get(mid);
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
}
