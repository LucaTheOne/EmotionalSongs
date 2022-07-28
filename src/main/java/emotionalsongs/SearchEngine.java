
package emotionalsongs;

import java.util.*;

/**
 * Classe adibita alla ricerca di canzoni all' interno del repository di canzoni
 * tramite due tipologie di ricerca:
 * -Ricerca per autore ed anno
 * -Ricerca per titolo
 */
class SearchEngine {
    
    public ArrayList<Brano> risultatiRicerca = new ArrayList<>();
    
    public ArrayList<Brano> cercaBranoMusicale(){
        
        System.out.println("Digiti 't' per effettuare una ricerca per titolo, digiti invece 'a' per una ricerca tramite autore ed anno, digiti 'e' per tornare al menu principale: ");
        Character scelta = (new Scanner(System.in).nextLine()).toLowerCase().charAt(0);
        
        switch (scelta) {
            case 't':
                ricercaPerTitolo();
                break;
            case 'a':
                ricercaPerAutoreEdAnno();
                break;
            case 'e':
                //da implementare metodo per tornare al menu principale
                break;
            default:
                System.out.println("Scelta non valida!");
                cercaBranoMusicale();
                break;
        }
        
        return risultatiRicerca;    
    }
    
    private void ricercaPerTitolo(){
        System.out.println("Digiti il titolo della canzone che vuole cercare: digiti 'e' per tornare alla scelta della tipologia di ricerca: ");
        String titoloCercato = new Scanner(System.in).nextLine().toLowerCase();
        if(titoloCercato.equals("e")){
            cercaBranoMusicale();
        }
        for(int i = 0;i<EMOTIONALSONGS.REPOSITORY.getDimensioneRepository();i++){
            Brano corrente = EMOTIONALSONGS.REPOSITORY.getBrano(i);
            if (corrente.getTitle().toLowerCase().contains(titoloCercato)){
                risultatiRicerca.add(corrente);
            }
        }
        if(risultatiRicerca.isEmpty()){
            System.out.println("Nessun brano contenente "+ titoloCercato + "presente nel repository! ");
            if(!Utilities.richiestaUscita()){
                ricercaPerTitolo();
            }
        }
    }

    private void ricercaPerAutoreEdAnno(){
        System.out.println("Digiti Autore ed Anno, separati da uno spazio e nell' ordine descritto, del brano che vuole cercare all' interno del repository; ");
        System.out.println("Digiti 'e' per tornare alla scelta di tipologia di ricerca: ");

        String autoreAnno = new Scanner(System.in).nextLine().toLowerCase();
        if(autoreAnno.equals("e")){
            cercaBranoMusicale();
        }
        String[] autoreAnnoSplitted = autoreAnno.split(" ");
        for(int i = 0;i<EMOTIONALSONGS.REPOSITORY.getDimensioneRepository();i++){
            Brano corrente = EMOTIONALSONGS.REPOSITORY.getBrano(i);
            if (corrente.getAuthor().toLowerCase().contains(autoreAnnoSplitted[0]) && corrente.getYear().equals(autoreAnnoSplitted[1])){
                risultatiRicerca.add(corrente);
            }
        }
        if(risultatiRicerca.isEmpty()){
            System.out.println("Nessun brano contenente come autore : "+ autoreAnnoSplitted[0]+ "di anno: " + autoreAnnoSplitted[1] + "presente nel repository!");
            if(!Utilities.richiestaUscita()){
                ricercaPerTitolo();
            }
        }
    }

    public String stampaRisultati(){
        String stringa = "";
        for(int i = 0; i<risultatiRicerca.size();i++){
            stringa = stringa + (i+1)+". " + risultatiRicerca.get(i).toStringOrdinato();
        }
        return stringa;
    }
    
    private void mostraRisultatiRicercaSuTerminale(){
        System.out.println("Risultati ricerca: ");
        if(risultatiRicerca.isEmpty()){
            System.out.println("Nessun risultato presente nella ricerca");    
        }
        
    }
    
    public static Brano cercaBranoEsatto(String datiBrano,Repository repository){
        String[] daCercare = datiBrano.split(",");//0 titolo, 1 autore, 2 anno, 3 id
        for (int i = 0;i<repository.getDimensioneRepository();i++){
            Brano corrente = repository.getBrano(i);
           if(daCercare[0].equals(corrente.getTitle())&& daCercare[1].equals(corrente.getAuthor()) && daCercare[2].equals(corrente.getYear()) && daCercare[3].equals(corrente.getTag())){
               return corrente;
           } 
        }
        return null;
    }
}
