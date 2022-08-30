package emotionalsongs;

import java.io.*;
import java.util.*;


/**
 *
 * @author big
 */
public class UserDatabase {
    private Utente[] arrayUtenti;
    private String path = Utilities.pathToUserDatabase;
    UserDatabase(){
        importData();
    }
    
    private void importData() {
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
            arrayUtenti = new Utente[listaProvvisoria.size()];
            for (int i = 0; i < listaProvvisoria.size(); i++) {
                arrayUtenti[i] = listaProvvisoria.get(i);
            }
        } catch (Exception e) {
            e.getMessage();
        }  
    }

    public int getDimensione() {
        return arrayUtenti.length;
    }
    
    public Utente get(int index){
        return arrayUtenti[index];
    }
    
    public void addNewUser(Utente user){
        Utente[] newArray = new Utente[arrayUtenti.length+1];
        for(int i = 0; i<arrayUtenti.length;i++){
            newArray[i]=arrayUtenti[i];
        }
        newArray[arrayUtenti.length] = user;
        arrayUtenti = newArray;
        riordina();
        salvaDati();
    }
    
    public void sostituisciIndice(int index, Utente daInserire){
        arrayUtenti[index] = daInserire;
    }
    
    public Utente cercaId(String userId){
        EngineSearch engineSearch = new EngineSearch();
        return engineSearch.ricercaId(this, userId);
    }
    
    public void riordina(){
        EngineSort sortEngine = new EngineSort();
        sortEngine.riordinaDatabase(this);    
    }
    
    public void salvaDati(){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
            for (int i = 0; i < arrayUtenti.length; i++) {
               writer.write(get(i).componiStringa());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
    }
    
    public Utente[] getArrayData(){
        return arrayUtenti;
    }

    Utente cercaCf(String cf) {
        EngineSearch engineSearch = new EngineSearch();
        return engineSearch.trovaCf(this, cf);
    }
    
}
