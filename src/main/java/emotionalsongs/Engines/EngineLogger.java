//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.Engines;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Managers.*;
import java.io.*;

/**
 * La classe implementa dei metodi per il controllo della userID e password. 
 * @author luca
 */
public class EngineLogger extends EmotionalSongs{
    
    private DataBaseUsers database = DataBaseUsers.getInstance();
    private User user;
    public boolean idFounded = false;
    public boolean passwordMatches = false;
    
    /**
     * Crea un oggetto vuoto.
     */
    public EngineLogger() {
    }
    
    /**
     * Il metodo prende come parametro il userID e password e controlla nel database 
     * che siano presenti.
     * @param UserId UserID.
     * @param Password Password.
     */
    public void login(String UserId, String Password){
        foundsId(UserId);
        if(idFounded){
          passwordsMatch(Password);
            if(idFounded&&passwordMatches){
                EngineSearcher finder = new EngineSearcher();
                EmotionalSongs.setLoggedUser(finder.getUserFromId(database, UserId));
                PlayListsManager.getInstanceFirstTime(DataBasePlaylists.getInstance());

            }  
        }
    }
    
    /**
     * Il metodo prende come parametro il userID e controlla che sia presente in database.
     * @param userId UuserID.
     */
    public void foundsId(String userId) {
            EngineSearcher engineSearch = new EngineSearcher();
            user = engineSearch.getUserFromId(database, userId);
            idFounded = user != null; 
    }
    
   
    /**
     * Il metodo prende come argomento la password e controlla che sia uguale
     * a quella assegnata durante la registrazione.
     * @param password 
     */
    public void passwordsMatch(String password) {
            passwordMatches = user.getPassword().equals(password);
    }
    
    /**
     * Il metodo effettua il logout dell'utente.
     */
    public static void logout(){
        EmotionalSongs.setLoggedUser(null);
        //EmotionalSongs.setUserSet(null);
        PlayListsManager.eraseInstance();
    }
}
