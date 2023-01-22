//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.data_structures;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.allerter.*;
import java.io.*;

/**
 * Classe che rappresenta il contenitore di tutti i giudizi emozionali contenuti nel file Emozioni.dati.txt.
 * Di fatto funge da database locale, inquanto fornisce metodi per la gestione, modifica e manipolazione dei dati.
 * Essendovi la necessita che l' istanza dela classe sia la stessa per tutto il sistema, essa è stata strutturata come singleton.
 */
public class DataBaseJudgements {
    
    //Campi
    private EmotionalJudgement[] dataBaseRecordsArray;
    private boolean empty = true;
    private static DataBaseJudgements dataBaseRecords = null;
    //Costructor
    /**
     * Costruttore privato del database
     */
    private DataBaseJudgements() {       
        importFromFile();
    }  
    
    //singleton instancer
    /**
     * Metodo che permette di accedere al database dei giudizi emozionali.
     * @return Istanza del database.
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
            dataBaseRecordsArray = new EmotionalJudgement[linesNumber];
            for(int i = 0; i<linesNumber;i++){
                dataBaseRecordsArray[i] = new EmotionalJudgement(reader.readLine());
            }
            empty = false;
        } catch (FileNotFoundException ex) {
            new PopUpAllert(EmotionalSongs.dialoghi.fileNotFound() + "\n Emozioni.dati.txt").setVisible(true);
        } catch (IOException ex) {
            ex.getMessage();    
        }
        
    }
    /**
     * Metodo che permette di aggiornare il database aggiungendo un nuovo giudizio emozionale ed automaticamente
     * rendere il nuovo dato accessibile e consistente.
     * Riordina il database dopo averlo aggiornatao, ma prima di salvarlo su file sorgente.
     * @param userJudgement giudizio emozionale da aggiungere.
     */    
    public void addNewUserJudgement(EmotionalJudgement userJudgement){
        if(!empty){
            EmotionalJudgement[] newDataBase = new EmotionalJudgement[dataBaseRecordsArray.length+1];
            for (int i = 0; i < dataBaseRecordsArray.length; i++) {
                newDataBase[i] = dataBaseRecordsArray[i];
            }
            newDataBase[newDataBase.length-1] = userJudgement;
            dataBaseRecordsArray = newDataBase;
            sortByBranoTag();
        }
        else {
            dataBaseRecordsArray = new EmotionalJudgement[1];
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
     * Il metodo restituisce l' array alla base del database contenente tutti i giudizi emozionali. 
     */
    public EmotionalJudgement[] getArray() {
        return this.dataBaseRecordsArray;
    }
    
    /**
     * Il metodo restituisce la dimensione del database in termini di numero di giudizi contenuti.
     * @return Dimensione Database.
     */
    public int getSize() {
        return this.dataBaseRecordsArray.length;
    }
    /**
     * Il metodo ritorna un intero rappresentante la posizione del giudizio sul brano con tag uguale a quello passato come argomento.
     * @param branoTag tag del brano di cui si cerca la posizione del giudizio nel database.
     * @return 
     */
    private int getJudgementIndexFromTag(String branoTag){
        EngineSearcher searcher = new EngineSearcher();
        return searcher.searchJudgementIndexBySongTag(this, branoTag);
    }
    
    /**
     * Ritorna il giudizio emozionale di posizione index nel database
     * @param index posizione del database da esaminare.
     * @return Il giudizio emozionale di indice index.
     */
    public EmotionalJudgement getRecordFromIndex(int index){
        return dataBaseRecordsArray[index];
    }
    
    /**
     * 
     * @return <ul>
     * <li> true -> il database è vuoto.</li>
     * <li> false -> il database posside almeno un giudizio emozionale.</li>
     * </ul>
     */
    public boolean isEmpty() {
        return empty;
    }
    
    //searching methods
    /**
     * Metodo utilizzato per cercare tutti i giudizi sul brano rappresentato dal tag passato come argomento.
     * @param songTag tag della canzone di cui cercare i giudizi emozionali.
     * @return Un arrai con tutti i giudizi della canzone cercata.
     */
    public EmotionalJudgement[] searchJudgements(String songTag){
        int firstIndexFound = getJudgementIndexFromTag(songTag);
        if(firstIndexFound<0) return null;
        EmotionalJudgement[] founds = new EmotionalJudgement[]{getRecordFromIndex(firstIndexFound)};
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
    
    private EmotionalJudgement[] addTo(EmotionalJudgement[] judgements, EmotionalJudgement toAdd, int before_0_or_after_1){
        EmotionalJudgement[] newOne = new EmotionalJudgement[judgements.length +1];
        if(before_0_or_after_1 == 0){
            for(int i = judgements.length;i>0;i--) newOne[i] = judgements[i];
            newOne[0] = toAdd;
        } else if(before_0_or_after_1 == 1){
            for(int i = 0;i<judgements.length;i++) newOne[i] = judgements[i];
            newOne[newOne.length-1] = toAdd;
        } else {
            new PopUpAllert("error");
            newOne = judgements;
        }
        return newOne;
    }
}
