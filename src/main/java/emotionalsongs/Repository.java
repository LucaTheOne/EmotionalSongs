
package emotionalsongs;

import java.io.*;

/**
 * La classe Repository si occupa della gestione del repository Brani e della
 * sua visualizzazione sul terminale.
 * @author Luca
 * @version 1.3
 */
public class Repository {

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
    public Repository() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("../EMOTIONALSONGS/data/Canzoni.dati.txt")));
            repository = new Song[(int)Utilities.countLines(Utilities.pathToCanzoniDatiTxt)];
            for(int i = 0; i<repository.length;i++){
                String[] splittedLine = buffer.readLine().split("<SEP>");
                repository[i] = new Song(splittedLine[3],splittedLine[2],splittedLine[0],splittedLine[1]);
            }            
        } catch (FileNotFoundException exception) {
            exception.getMessage();
        } catch (IOException exception){
            exception.getMessage();
        }
        
    }
    
    //modify methods
    private void addTrack(Song brano){
        
            Song[] newArray = new Song[repository.length+1];
            for(int i = 0; i<repository.length;i++){
                newArray[i] = repository[i];
            }
            newArray[newArray.length-1] = brano;
        
    }
    
    void sortByTags(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortTracksByTags(repository);
    }
    
    void sortByTitles(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortTracksByTitles(repository);
    }
    
    void sortByAuthor(){
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
    
    public Song[] getRepo(){
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