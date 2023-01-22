//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.data_structures;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.allerter.*;
import java.io.*;

/**
 * Classe che rappresenta il contenitore dei brani dell software, contenuti nel file Canzoni.dati.txt.
 * Di fatto funge da database locale, in quanto fornisce metodi per la gestione, modifica e manipolazione dei dati.
 * Essendovi la necessità che l' istanza dela classe sia la stessa per tutto il sistema, essa è stata strutturata come singleton.
 */
public class Repository {
    
    private static Repository instance;
    private Song[] repository;

    //Costruttore
    /**
     * Il costruttore privato crea l'oggetto di tipo Repository, unico. 
     * Usando il metodo BufferedReader accede al file contenente la lista di Brani e 
     * li immagazzina nella struttura dati al suo interno.
     *
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private Repository() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Utilities.pathToCanzoniDatiTxt)));
            repository = new Song[(int)Utilities.countLines(Utilities.pathToCanzoniDatiTxt)];
            for(int i = 0; i<repository.length;i++){
                String[] splittedLine = reader.readLine().split("<SEP>");
                repository[i] = new Song(splittedLine[3],splittedLine[2],splittedLine[0],splittedLine[1]);
            }    
        } catch (FileNotFoundException exception) {
            new PopUpAllert(EmotionalSongs.dialoghi.fileNotFound()+ "\n"+Utilities.pathToCanzoniDatiTxt).setVisible(true);
        } catch (IOException exception){
            exception.getMessage();
        }
        
    }
    
    /**
     * Metodo che permette di accedere al database dei brani.
     * @return Istanza del database.
     */
    public static Repository getInstance(){
        if(instance== null) instance=new Repository();
        return instance;
    }
    
    //modify methods
    /**
     * Riordina il database in base ai tags delle canzoni che contiene
     */
    public void sortByTags(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortSongsByTags(repository);
    }
    
    /**
     * Riordina il database in base ai titoli delle canzoni che contiene
     */
    public void sortByTitles(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortSongsByTitles(repository);
    }
    
    /**
     * Riordina il database in base agli autori delle canzoni che contiene
     */
    public void sortByAuthor(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortSongsByAuthors(repository);
    }
    
    //getter methods   
    /**
     * Il metodo restituisce il numero di utenti presenti nel repository.
     * @return numeroBrani - numero di utenti.
     */
    public int getSize(){
        return repository.length;
    }
    
    /**
     * Il metodo restituisce il brano che si trova nella posizione richiesta indicata dal parametro passato come argomento.
     * @param index la posizione del brano.
     * @return Restituisce il brano di posizione index.
     */
    public Song getBrano(int index){
        return repository[index];
    }
    
    /**
     * ritorna un array contenente tutti i brani del repository.
     * @return 
     */
    public Song[] getArray(){
        return repository;
    }
    
    //view methods
    /**
     * Il metodo produce la stringa che rappresenta il brano di posizione index.
     * @param index int.
     */
    public void stampaBrano(int index){
        System.out.println(getBrano(index).toStringOrdinato());
    }
    
    
}