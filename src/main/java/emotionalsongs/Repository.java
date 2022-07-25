/**
 * Repository
 */
package emotionalsongs;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Luca
 * @version 1.3
 */
public class Repository {

    List<Brano> repository = new ArrayList<Brano>();
    private int numeroBrani = 0;
    private File CanzoniDati = new File(Utilities.pathToCanzoniDatiTxt);

  //Costruttore
    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Repository() throws FileNotFoundException, IOException {
        FileInputStream stream = new FileInputStream(CanzoniDati);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
        String line;
        while((line = buffer.readLine()) != null){
            String[] splittedLine = line.split("<SEP>");//Divido la line in stringhe divise da <SEP> e le salvo in un array
            Brano branoCorrente = new Brano(splittedLine[3],splittedLine[2],splittedLine[0],splittedLine[1]);
            repository.add(branoCorrente);
            numeroBrani++;
        }
    }

  /**private void addBrano(Brano brano){
    this.repository.add(brano);
  }**/
    
    /**
     * 
     * @return 
     */
    public int dimensioneRepository(){
      return this.numeroBrani;
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    public Brano getBrano(int index){
        return repository.get(index);
    }
    
    /**
     * 
     * 
     */
    public void stampaRepository(){
        System.out.print("CANZONI NEL REPOSITORY:\n");
        for(int i = 0;i<repository.size();i++){
            Brano branoCorrente = repository.get(i);
            System.out.print("Titolo: " + branoCorrente.getTitle().toUpperCase()+ "\n"
                        + "   Autore: " + branoCorrente.getAuthor() + "\n"
                        + "   Anno: " + branoCorrente.getYear() + ".\n");
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
