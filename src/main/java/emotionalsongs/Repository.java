
package emotionalsongs;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * La classe Repository si occupa della gestione del repository Brani e della
 * sua visualizzazione sul terminale.
 * @author Luca
 * @version 1.3
 */
public class Repository {

    /**
     * @hidden
     */
    ArrayList<Brano> repository = new ArrayList<Brano>();
    /**
     * @hidden
     */
    ArrayList<JButton> repositoryButtons = new ArrayList<>();
    private int numeroBrani = 0;

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
            String line;
            while((line = buffer.readLine()) != null){
            String[] splittedLine = line.split("<SEP>");//Divido la line in stringhe divise da <SEP> e le salvo in un array
            Brano branoCorrente = new Brano(splittedLine[3],splittedLine[2],splittedLine[0],splittedLine[1]);
            repository.add(branoCorrente);
            repositoryButtons.add(branoCorrente.button);
            numeroBrani++;
        }
        } catch (FileNotFoundException exception) {
            exception.getMessage();
        } catch (IOException exception){
            exception.getMessage();
        }
        
    }
    
    /**
     * Il metodo restituisce il numero di brani presenti nel repository.
     * @return numeroBrani - numero di brani.
     */
    public int getDimensioneRepository(){
      return this.numeroBrani;
    }
    
    /**
     * Il metodo restituisce il Brano che si trova nella posizione richiesta dal
     * parametro.
     * @param index richiede la posizione del brano.
     * @return Restituisce il brano.
     */
    public Brano getBrano(int index){
        return repository.get(index);
    }
    
    /**
     * Il metodo stampa la repository, scrivendo i dettagli di ogni brano.
     * 
     */
    public void mostraRepository(JScrollPane pannello){
        for(int i = 0;i<numeroBrani;i++){
            pannello.add(repositoryButtons.get(i));
        }
    }
    
    /**
     * Il metodo stampa il Brano richiesto dall'utente.
     * @param index posizione Brano.
     */
    public void stampaBrano(int index){
        System.out.println(getBrano(index).toStringOrdinato());
    }
    
}
