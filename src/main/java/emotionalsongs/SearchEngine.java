package emotionalsongs;

import java.util.*;

/**
 * Classe adibita alla ricerca di canzoni all' interno del repository di canzoni
 * tramite due tipologie di ricerca:
 * <p>-Ricerca per autore ed anno
 * -Ricerca per titolo
 * @author Luca
 * @version 1.2
 */
class SearchEngine {
    
    
   /**
    * 
    */
    public ArrayList<Brano> risultatiRicerca = new ArrayList<>();
    public Repository repository;
    /**
    *
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
        for (int i = 0;i<repository.getDimensioneRepository();i++){
            Brano corrente = repository.getBrano(i);
           if(daCercare[0].equals(corrente.getTitle())&& daCercare[1].equals(corrente.getAuthor()) && daCercare[2].equals(corrente.getYear()) && daCercare[3].equals(corrente.getTag())){
               return corrente;
           } 
        }
        return null;
    }*/
    
}
