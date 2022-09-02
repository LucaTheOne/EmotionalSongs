package emotionalsongs;

import java.io.*;


/**
 *
 * @author big
 */
public class DataBaseUtenti {
    private Utente[] database;
    private String path = Utilities.pathToUserDatabase;
    DataBaseUtenti(){
        importData();
    }
    
    private void importData() {
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(Utilities.pathToUserDatabase)));
            database = new Utente[(int)Utilities.countLines(Utilities.pathToUserDatabase)];
            for(int i = 0; i<database.length;i++){
                String[] currentLine = buffer.readLine().split(";");
                database[i] = new Utente(currentLine[0], 
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
        
        /*
        try {
            Scanner scanner = new Scanner(new File(path));
            ArrayList<Utente> listaProvvisoria = new ArrayList<>();
            while(scanner.hasNextLine()){
                String currentLine = scanner.nextLine();
                listaProvvisoria.add(new Utente(currentLine.split(";")[0], 
                        currentLine.split(";")[1], 
                        currentLine.split(";")[2],
                        currentLine.split(";")[3], 
                        currentLine.split(";")[4], 
                        currentLine.split(";")[5], 
                        currentLine.split(";")[6], 
                        currentLine.split(";")[7]
                )); 
            }
            database = new Utente[listaProvvisoria.size()];
            for (int i = 0; i < listaProvvisoria.size(); i++) {
                database[i] = listaProvvisoria.getUser(i);
            }
        } catch (Exception e) {
            e.getMessage();
        } */ 
    }

    public int getSize() {
        return database.length;
    }
    
    public Utente getUser(int index){
        return database[index];
    }
    
    public void addNewUser(Utente user){
        Utente[] newArray = new Utente[database.length+1];
        for(int i = 0; i<database.length;i++){
            newArray[i]=database[i];
        }
        newArray[database.length] = user;
        database = newArray;
        sortById();
        saveData();
    }
    
    public void replace(int index, Utente daInserire){
        database[index] = daInserire;
    }
    
    public Utente searchUserId(String userId){
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
    
    public Utente[] getDatabase(){
        return database;
    }

    Utente searchUserCf(String cf) {
        EngineSearcher engineSearch = new EngineSearcher();
        return engineSearch.getUserFromCf(this, cf);
    }
    
}
