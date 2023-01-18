//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.DataBases;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.comunicator.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.comunicator.*;
import java.io.*;

/**
 * La classe Repository si occupa della gestione del repository Brani e della
 * sua visualizzazione sul terminale.
 * @author Luca
 * @version 1.3
 */
public class Repository {
    
    private static Repository instance;
    private Song[] repository;

    //Costruttore
    /**
     * Il costruttore crea un oggetto di tipo Repository. Usando il metodo BufferedReader accede al
     * file contenente la lista di Brani e crea un array di stringhe le cui righe contengono i dati di ogni
     * brano.
     *
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private Repository() {
        try {
            //Repository.class.getClassLoader().getResourceAsStream(name)
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(Utilities.pathToCanzoniDatiTxt)));
            repository = new Song[(int)Utilities.countLines(Utilities.pathToCanzoniDatiTxt)];
            for(int i = 0; i<repository.length;i++){
                String[] splittedLine = buffer.readLine().split("<SEP>");
                repository[i] = new Song(splittedLine[3],splittedLine[2],splittedLine[0],splittedLine[1]);
            }            
        } catch (FileNotFoundException exception) {
            new PopUpAllert("Il file sorgente non è stato trovato" + " \n"+Utilities.pathToCanzoniDatiTxt).setVisible(true);
        } catch (IOException exception){
            exception.getMessage();
        }
        
    }
    
    /**
     * 
     * @return 
     */
    public static Repository getInstance(){
        if(instance== null) instance=new Repository();
        return instance;
    }
    
    //modify methods
    private void addTrack(Song brano){
        
            Song[] newArray = new Song[repository.length+1];
            for(int i = 0; i<repository.length;i++){
                newArray[i] = repository[i];
            }
            newArray[newArray.length-1] = brano;
        
    }
    
    /**
     * 
     */
    public void sortByTags(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortTracksByTags(repository);
    }
    
    /**
     * 
     */
    public void sortByTitles(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortTracksByTitles(repository);
    }
    
    /**
     * 
     */
    public void sortByAuthor(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortTracksByAuthors(repository);
    }
    
    //getter methods   
    /**
     * Il metodo restituisce il numero di repository presenti nel repository.
     * @return numeroBrani - numero di repository.
     */
    public int getSize(){
        return repository.length;
    }
    
    /**
     * Il metodo restituisce il Song che si trova nella posizione richiesta dal
 parametro.
     * @param index richiede la posizione del brano.
     * @return Restituisce il brano.
     */
    public Song getBrano(int index){
        return repository[index];
    }
    
    /**
     * 
     * @return 
     */
    public Song[] getArray(){
        return repository;
    }
    
    //view methods
    /**
     * Il metodo stampa il Song richiesto dall'utente.
     * @param index posizione Song.
     */
    public void stampaBrano(int index){
        System.out.println(getBrano(index).toStringOrdinato());
    }
    
    
}