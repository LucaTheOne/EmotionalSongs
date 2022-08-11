
package emotionalsongs;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author Luca
 * @version 1.3
 */
public class Repository {

    /**
     * 
     */
    ArrayList<Brano> repository = new ArrayList<Brano>();
    ArrayList<JButton> repositoryButtons = new ArrayList<>();
    private int numeroBrani = 0;

  //Costruttore
    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Repository() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(Utilities.pathToCanzoniDatiTxt)));
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
     * Il metodo restituisce il numero di brani presenti nella repository.
     * @return numero di brani.
     */
    public int getDimensioneRepository(){
      return this.numeroBrani;
    }
    
    /**
     * Il metodo restituisce il Brano che si trova nella posizione richiesto dal
     * parametro.
     * @param index - richida la posizione del brano.
     * @return Restituisce il brano.
     */
    public Brano getBrano(int index){
        return repository.get(index);
    }
    
    /**
     * Il metodo stampa la repostiory : <p>
     * <p>
     *      Titolo: 
     * <p>
     *      Autore:  
     * <p>
     *      Anno: 
     */
    public void mostraRepository(JScrollPane pannello){
        for(int i = 0;i<numeroBrani;i++){
            pannello.add(repositoryButtons.get(i));
        }
    }
    
    /**
     * 
     * @param index 
     */
    public void stampaBrano(int index){
        System.out.println(getBrano(index).toStringOrdinato());
    }
    
}
