package emotionalsongs;

import java.io.*;
import java.util.*;


/**
 *
 * @author big
 */
public class UserDatabase {
    private ArrayList<Utente> datiUtentiRegistrati;
    
    UserDatabase(){
        datiUtentiRegistrati = importData(Utilities.pathToUserDatabase);
    }
    
    private ArrayList<Utente> importData(String path) {
        ArrayList<Utente> userList = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(new File(path)));
            String currentLine = buffer.readLine();
                while (currentLine != null) {
                    userList.add(new Utente(currentLine.split(";")[0], 
                        currentLine.split(";")[1], 
                        currentLine.split(";")[2],
                        currentLine.split(";")[3], 
                        currentLine.split(";")[4], 
                        currentLine.split(";")[5], 
                        currentLine.split(";")[6], 
                        currentLine.split(";")[7]
                    ));
                    currentLine = buffer.readLine();
                }    
        } catch (Exception e) {
            e.getMessage();
        }
        return userList;   
    }
    
    public ArrayList<Utente> getUserDatabase(){
        return datiUtentiRegistrati;
    }

    public int getDimensione() {
        return datiUtentiRegistrati.size();
    }
    
    public Utente get(int index){
        return datiUtentiRegistrati.get(index);
    }
}
