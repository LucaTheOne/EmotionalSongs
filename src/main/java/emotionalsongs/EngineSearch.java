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
public class EngineSearch {

    public ArrayList<Brano> risultatiRicerca = new ArrayList<>();
    public Repository repository = EMOTIONALSONGS.REPOSITORY;
    
    //metodi di ricerca canzoni
    /**
     * Il metodo permette di selezionare la modalita di ricerca per autore ed anno opppure
     * per titolo.
     * @param stringaCercata 
     * @return il brano, in base alla tipologia di ricerca scelta, per autore ed anno o per titolo.
     */

    public ArrayList<Brano> cercaBranoMusicale(String stringaCercata){
        boolean flag = stringaCercata.contains(";");
        
        if(flag){
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
    private ArrayList<Brano> ricercaPerTitolo(String titolo){
        
        ArrayList<Brano> risultatiRicerca = new ArrayList<>();
        
        for(int i = 0;i<repository.getDimensioneRepository();i++){
            Brano corrente = repository.getBrano(i);
            if (corrente.getTitle().toLowerCase().contains(titolo.toLowerCase())){
                risultatiRicerca.add(corrente);
            }
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
    private ArrayList<Brano> ricercaPerAutoreEdAnno(String autore, String anno){

        ArrayList<Brano> risultatiRicerca = new ArrayList<>();
        
        for(int i = 0;i<repository.getDimensioneRepository();i++){
            Brano branoCorrente = repository.getBrano(i);
            if (branoCorrente.getAuthor().equalsIgnoreCase(autore) && branoCorrente.getYear().equalsIgnoreCase(anno)){
                risultatiRicerca.add(branoCorrente);
            }
        }
        return risultatiRicerca;
    }
    
    /*
    public static Brano cercaBranoEsatto(String datiBrano,Repository repository){
        String[] daCercare = datiBrano.split(",");//0 titolo, 1 autore, 2 anno, 3 id
        for (int low = 0;low<repository.getDimensioneRepository();low++){
            Brano corrente = repository.getBrano(low);
           if(daCercare[0].equals(corrente.getTitle())&& daCercare[1].equals(corrente.getAuthor()) && daCercare[2].equals(corrente.getYear()) && daCercare[3].equals(corrente.getTag())){
               return corrente;
           } 
        }
        return null;
    }*/
    
    //metodi ricerca utenti nel database
    public Utente ricercaId(DatabaseUtenti database, String id){
        
        int size = database.getDimensione();
        
        if(size<1000){
            for (int i = 0; i < size; i++) {
                if(database.get(i).getUserId().equals(id)){
                    return database.get(i);
                }
            }
            return null;
        }

        int low = 0;
        int high = size-1;
        while(low<=high){
            int mid = low+high/2;
            Utente pointedUser = database.get(mid);
            String userPointedId = pointedUser.getUserId();
            if(userPointedId.equals(id)) return pointedUser;
            else if(id.compareTo(userPointedId)<0) high = mid-1;
            else low = mid+1;
        }
        return null;
    }
    
    Utente trovaCf(DatabaseUtenti database,String cf) {
        
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
}
