//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.DataBases;

import emotionalsongs.GUI.comunicator.PopUpAllert;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Engines.*;
import emotionalsongs.*; 
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Engines.*;
import java.io.*;

/**
 * La classe DataSetEmozioni si occupa di importare ed esportare i dati delle 
 * emozioni.
 * @author Bolelli Luca
 */
public class DataBaseJudgements {
    
    //Campi
    private UserJudgement[] dataBaseRecordsArray;
    private boolean empty = true;
    private static DataBaseJudgements dataBaseRecords = null;
    //Costructor
    /**
     * Crea un oggetto che importFromFile i dati delle emozioni.
     */
    private DataBaseJudgements() {       
        importFromFile();
    }  
    
    //singleton instancer
    /**
     * 
     * @return 
     */
    public static DataBaseJudgements getInstance(){
        if (dataBaseRecords == null){
            dataBaseRecords = new DataBaseJudgements();
            return dataBaseRecords;
        } else return dataBaseRecords;
    }
    
    //updating methods
    private void importFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(Utilities.pathToEmozioniDati)));
            int linesNumber = (int)Utilities.countLines(Utilities.pathToEmozioniDati);
            if(linesNumber==0) return;
            dataBaseRecordsArray = new UserJudgement[linesNumber];
            for(int i = 0; i<linesNumber;i++){
                dataBaseRecordsArray[i] = new UserJudgement(reader.readLine());
            }
            empty = false;
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();    
        }
        
    }
        
    public void addNewUserJudgement(UserJudgement userJudgement){
        if(!empty){
            UserJudgement[] newDataBase = new UserJudgement[dataBaseRecordsArray.length+1];
            for (int i = 0; i < dataBaseRecordsArray.length; i++) {
                newDataBase[i] = dataBaseRecordsArray[i];
            }
            newDataBase[newDataBase.length-1] = userJudgement;
            dataBaseRecordsArray = newDataBase;
            sortByBranoTag();
        }
        else {
            dataBaseRecordsArray = new UserJudgement[1];
            dataBaseRecordsArray[0] = userJudgement;
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
        sorter.sortJudgements(this);   
    }
    
    //getter methods
    /**
     * Il metodo restituisce un array con le votazioni assegnate ad ogni emozione.
     * 
     */
    public UserJudgement[] getArray() {
        return this.dataBaseRecordsArray;
    }
    
    /**
     * Il metodo restituisce la dimensione dell'array.
     * @return Dimensione array.
     */
    public int getSize() {
        return this.dataBaseRecordsArray.length;
    }
    
    private int getJudgementIndexFromTag(String branoTag){
        EngineSearcher searcher = new EngineSearcher();
        return searcher.getJudgementIndexFromSongTag(this, branoTag);
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    public UserJudgement getRecordFromIndex(int index){
        return dataBaseRecordsArray[index];
    }

    public boolean isEmpty() {
        return empty;
    }
    
    //searching methods
    /**
     * 
     * @param songTag
     * @return Il tag.
     */
    public UserJudgement[] searchJudgements(String songTag){
        int firstIndexFound = getJudgementIndexFromTag(songTag);
        if(firstIndexFound<0) return null;
        UserJudgement[] founds = new UserJudgement[]{getRecordFromIndex(firstIndexFound)};
        for(int i = firstIndexFound-1;i!=0;i--){
            if(dataBaseRecordsArray[i].getBranoTag().equals(songTag))
                founds = addTo(founds, dataBaseRecordsArray[i], 0);
            else 
                break;
        }
        for(int i = firstIndexFound+1;i<dataBaseRecordsArray.length;i++){
            if(dataBaseRecordsArray[i].getBranoTag().equals(songTag))
                founds = addTo(founds, dataBaseRecordsArray[i], 1);
            else 
                break;
        }
         return  founds;
    }
    
    private UserJudgement[] addTo(UserJudgement[] judgements, UserJudgement toAdd, int before_0_or_after_1){
        UserJudgement[] newOne = new UserJudgement[judgements.length +1];
        if(before_0_or_after_1 == 0){
            for(int i = judgements.length;i>0;i--) newOne[i] = judgements[i];
            newOne[0] = toAdd;
        } else if(before_0_or_after_1 == 1){
            for(int i = 0;i<judgements.length;i++) newOne[i] = judgements[i];
            newOne[newOne.length-1] = toAdd;
        } else {
            new PopUpAllert("errore, dato non valido");
            newOne = judgements;
        }
        return newOne;
    }
    
    /* debugger Code*/
    /*
    public static void main(String[] args) {
        
        DataBaseJudgements data = DataBaseJudgements.getInstance();
        UserJudgement[] judgement = data.getArray();
        UserJudgement jud = judgement[14];
        UserJudgement[] searched = data.searchJudgements(jud.getBranoTag());
        System.out.println(jud.getBranoTag());
        System.out.println(searched.length);
        System.out.println(searched[0].getUserIDRecord());
    }
    */
}
