//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.data_structures;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.sorting_algos.users_sorting_algos.*;
import java.io.*;


/**
 *
 * @author big
 */
public class DataBaseUsers {
    private static DataBaseUsers instance = null;
    private User[] database;
    private String path = Utilities.pathToUserDatabase;
    private DataBaseUsers(){
        importData();
    }
    
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

    public int getSize() {
        return database.length;
    }
    
    public User getUser(int index){
        return database[index];
    }
    
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
    
    public void replace(int index, User daInserire){
        database[index] = daInserire;
    }
    
    public User searchUserId(String userId){
        EngineSearcher engineSearch = new EngineSearcher();
        return engineSearch.getUserFromId(this, userId);
    }
    
    public void sortById(){
        EngineSorter sortEngine = new EngineSorter();
        sortEngine.sortUsersById(this);    
    }
    
    public void saveData(){
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
    
    public User[] getArray(){
        return database;
    }

    public User searchUserCf(String cf) {
        EngineSearcher engineSearch = new EngineSearcher();
        return engineSearch.searchUserFromCF(this, cf);
    }
    
}
