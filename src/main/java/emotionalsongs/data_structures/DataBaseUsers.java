//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.data_structures;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.sorting_algos.users_sorting_algos.*;
import java.io.*;


/**
 * 
 * Classe che rappresenta il contenitore gli utenti registrati al software, contenuti nel file UtentiRegistrati.dati.txt.
 * Di fatto funge da database locale, inquanto fornisce metodi per la gestione, modifica e manipolazione dei dati.
 * Essendovi la necessita che l' istanza dela classe sia la stessa per tutto il sistema, essa è stata strutturata come singleton.
 */
public class DataBaseUsers {
    private static DataBaseUsers instance = null;
    private User[] database;
    private String path = Utilities.pathToUserDatabase;
    

    private DataBaseUsers(){
        importData();
    }
    
    /**
     * Metodo che permette di accedere al database degli utenti.
     * @return Istanza del database.
     */
    
    public static DataBaseUsers getInstance(){
        if(instance==null) instance = new DataBaseUsers();
        return instance;
    }
    
    private void importData() {
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(Utilities.pathToUserDatabase)));
            database = new User[(int)Utilities.countLines(Utilities.pathToUserDatabase)];
            for(int i = 0; i<database.length;i++){
                String[] currentLine = reader.readLine().split(";");
                database[i] = new User(currentLine[0], 
                        currentLine[1], 
                        currentLine[2],
                        currentLine[3], 
                        currentLine[4], 
                        currentLine[5], 
                        currentLine[6], 
                        currentLine[7]
                );
            }            
        } catch (FileNotFoundException exception) {
            exception.getMessage();
        } catch (IOException exception){
            exception.getMessage();
        }
    }
    
    /**
     * Il metodo restituisce la dimensione del database in termini di numero di Utenti contenuti.
     * @return Dimensione Database.
     */
    public int getSize() {
        return database.length;
    }
    /**
     * 
     * @param index int
     * @return L' istanza di user di posizione index nel database.
     */
    public User getUser(int index){
        return database[index];
    }
    /**
     * Metodo che permette di aggiornare il database aggiungendovi un nuovo utente, successivamente lo riordina e rende i dati permanenti.
     * @param user 
     */
    public void addNewUser(User user){
        User[] newArray = new User[database.length+1];
        for(int i = 0; i<database.length;i++){
            newArray[i]=database[i];
        }
        newArray[newArray.length-1] = user;
        database = newArray;
        SorterUserById sorter = new SorterUserById();
        sorter.mergeSort(database);
        saveData();
    }
    
    /**
     * Inserisce al database l' uetente passato come argomento in posizione index.
     * @param index int, posizione in cui inserire l' utente passato come argomento.
     * @param UserToInsert Utente da inserire in posizione index
     */
    public void insert(int index, User UserToInsert){
        database[index] = UserToInsert;
    }
    /**
     * Ritorna l' istanza di user contenuta nel database avente l' id uguale a quello passato come argomento.
     * @param userId id del utente da cercare.
     * @return L' istanza del utente cercato.
     */
    public User searchUserById(String userId){
        EngineSearcher engineSearch = new EngineSearcher();
        return engineSearch.getUserFromId(this, userId);
    }
    
    /**
     * Riordina il database in base agli id degli utenti al suo interno.
     */
    public void sortById(){
        EngineSorter sortEngine = new EngineSorter();
        sortEngine.sortUsersById(this);    
    }
    
    private void saveData(){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
            for (int i = 0; i < database.length; i++) {
               writer.write(getUser(i).componiStringa());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
    }
    /**
     * 
     * @return array di utenti alla base del database.
     */
    public User[] getArray(){
        return database;
    }
    
    /**
     * Ritorna l' istanza del utente avente il CF uguale a quello passato come argomento.
     * @param cf cosdice fiscale del utente da ricercare.
     * @return Istanza di User avente cf uguale a quello passato come argomento.
     */
    public User searchByUserCf(String cf) {
        EngineSearcher engineSearch = new EngineSearcher();
        return engineSearch.searchUserFromCF(this, cf);
    }
    
}
