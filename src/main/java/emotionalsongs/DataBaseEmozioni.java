
package emotionalsongs;

import java.io.*;
import java.util.logging.*;

/**
 * La classe DataSetEmozioni si occupa di importare ed esportare i dati delle 
 * emozioni.
 * @author Bolelli Luca
 */
public class DataBaseEmozioni {
    
    //Campi
    BranoRecords[] database;
    int size;
    
    /**
     * Crea un oggetto che importa i dati delle emozioni.
     */
    public DataBaseEmozioni() {       
        importa();
    }  
    
    private void importa() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(Utilities.pathToEmozioniDati)));
            size = (int)Utilities.countLines(Utilities.pathToEmozioniDati);
            database = new BranoRecords[size];
            for(int i = 0; i<size;i++){
                String[] current = reader.readLine().split(";");
                database[i] = new BranoRecords(current[0], current[1], current[2], current[3], current[4], current[5], current[6], current[7], current[8], current[9], current[10], current[11], current[12], current[13], current[14], current[15], current[16], current[17], current[18], current[19]);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataBaseEmozioni.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBaseEmozioni.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
  }
