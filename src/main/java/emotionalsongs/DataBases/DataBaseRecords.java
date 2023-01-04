
package emotionalsongs.DataBases;

import emotionalsongs.BasicsStructure.Record;
import emotionalsongs.Engines.*;
import emotionalsongs.*;
import emotionalsongs.Engines.*;
import java.io.*;

/**
 * La classe DataSetEmozioni si occupa di importare ed esportare i dati delle 
 * emozioni.
 * @author Bolelli Luca
 */
public class DataBaseRecords {
    
    //Campi
    private Record[] dataBaseRecordsArray;
    private boolean empty = true;
    private static DataBaseRecords dataBaseRecords = null;
    //Costructor
    /**
     * Crea un oggetto che importFromFile i dati delle emozioni.
     */
    private DataBaseRecords() {       
        importFromFile();
    }  
    
    //singleton instancer
    public static DataBaseRecords getDatabase(){
        if (dataBaseRecords == null){
            dataBaseRecords = new DataBaseRecords();
            return dataBaseRecords;
        } else return dataBaseRecords;
    }
    
    //updating methods
    private void importFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(Utilities.pathToEmozioniDati)));
            int linesNumber = (int)Utilities.countLines(Utilities.pathToEmozioniDati);
            if(linesNumber==0) return;
            dataBaseRecordsArray = new Record[linesNumber];
            for(int i = 0; i<linesNumber;i++){
                dataBaseRecordsArray[i] = new Record(reader.readLine());
            }
            empty = false;
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();    
        }
        
    }
        
    public void addNewRecord(Record record){
        if(!empty){
            Record[] newDataBase = new Record[dataBaseRecordsArray.length+1];
            for (int i = 0; i < dataBaseRecordsArray.length; i++) {
                newDataBase[i] = dataBaseRecordsArray[i];
            }
            newDataBase[newDataBase.length-1] = record;
            dataBaseRecordsArray = newDataBase;
            sortByBranoTag();
        }
        else {
            dataBaseRecordsArray = new Record[1];
            dataBaseRecordsArray[0] = record;
        }
        save();
    }
    
    //internal methods
    private void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Utilities.pathToEmozioniDati));
            for(int i = 0; i<dataBaseRecordsArray.length;i++){
                writer.write(dataBaseRecordsArray[i].stringaRecord()+ (i<dataBaseRecordsArray.length-1 ?"\n" : ""));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.getMessage();
        }   
    }
    
    //sorting method (internal)
    private void sortByBranoTag(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortRecords(this);   
    }
    
    //getter methods
    public Record[] getArray() {
        return this.dataBaseRecordsArray;
    }
    
    public int getSize() {
        return this.dataBaseRecordsArray.length;
    }
    
    public Record getSongFromTag(String branoTag){
        EngineSearcher searcher = new EngineSearcher();
        return searcher.getRecordFromTag(this, branoTag);
    }
    
    public Record getRecordFromIndex(int index){
        return dataBaseRecordsArray[index];
    }

    public boolean isEmpty() {
        return empty;
    }
    
    /* debugger Code*/
    
    public static void main(String[] args) {
        
        DataBaseRecords data = DataBaseRecords.getDatabase();
        System.out.println(data.getRecordFromIndex(1).getBranoTag());
    }

}
