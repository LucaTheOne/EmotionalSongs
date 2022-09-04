
package emotionalsongs;

import java.io.*;
import java.util.logging.*;

/**
 * La classe DataSetEmozioni si occupa di importare ed esportare i dati delle 
 * emozioni.
 * @author Bolelli Luca
 */
public class DataBaseRecords {
    
    //Campi
    private Record[] database;
    private boolean empty = true;
    //Costructor
    /**
     * Crea un oggetto che importFromFile i dati delle emozioni.
     */
    public DataBaseRecords() {       
        importFromFile();
    }  
    
    //updating methods
    private void importFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(Utilities.pathToEmozioniDati)));
            int linesNumber = (int)Utilities.countLines(Utilities.pathToEmozioniDati);
            if(linesNumber==0) return;
            database = new Record[linesNumber];
            for(int i = 0; i<linesNumber;i++){
                database[i] = new Record(reader.readLine());
            }
            empty = false;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataBaseRecords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBaseRecords.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
    }
        
    public void add(Record record){
        Record[] newDataBase = new Record[database.length+1];
        for (int i = 0; i < database.length; i++) {
            newDataBase[i] = database[i];
        }
        newDataBase[newDataBase.length-1] = record;
        save();
    }
    
    private void save() {
        sortByBranoTag();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Utilities.pathToEmozioniDati));
            for(int i = 0; i<database.length;i++){
                writer.write(database[i].stringaRecord()+"\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DataBaseRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //sorting method
    private void sortByBranoTag(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortRecords(this);   
    }
    
    //getter methods
    Record[] getArray() {
        return this.database;
    }
    
    int getSize() {
        return this.database.length;
    }
    
    Record get(String branoTag){
        EngineSearcher searcher = new EngineSearcher();
        return searcher.getRecordFromTag(this, branoTag);
    }
    
    Record getIndex(int index){
        return database[index];
    }

    boolean isEmpty() {
        return empty;
    }
    
}
