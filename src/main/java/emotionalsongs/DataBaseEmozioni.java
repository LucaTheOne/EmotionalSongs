
package emotionalsongs;

/**
 * La classe DataSetEmozioni si occupa di importare ed esportare i dati delle 
 * emozioni.
 * @author Bolelli Luca
 */
public class DataBaseEmozioni {
    
    //Campi
    Repository repoCorrelato;
    
    
    /**
     * Crea un oggetto che importa i dati delle emozioni.
     */
    public DataBaseEmozioni(Repository repo) {
       
        repoCorrelato = repo;

    }  
  }
