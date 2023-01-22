//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.Engines;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.managers.*;

/**
 * La classe le cui istanze offrono dei metodi per effettuare il login al software. 
 */
public class EngineLogger extends EmotionalSongs{
    
    private DataBaseUsers database = DataBaseUsers.getInstance();
    private User user;
    public boolean idFounded = false;
    public boolean passwordMatches = false;

    public EngineLogger() {
    }
    
    /**
     * Il metodo prende come parametro un userID e una password e controlla nel database 
     * che siano presenti e corrispondenti.
     * Nel caso lo siano modifica il campo della classe principale EmotionalSongs loggedUser.
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
                PlaylistsManager.getInstanceFirstTime(DataBasePlaylists.getInstance());
                
            }  
        }
    }
    
    /**
     * Il metodo prende come parametro un userID e controlla che sia presente nel database.
     * @param userId UserID.
     */
    public void foundsId(String userId) {
            EngineSearcher engineSearch = new EngineSearcher();
            user = engineSearch.getUserFromId(database, userId);
            idFounded = user != null; 
    }
    
   
    /**
     * Il metodo prende come argomento la password e controlla che sia uguale
     * a quella assegnata durante la registrazione.
     * @param password password da controllare che combaci con quella dell'userID associato.
     */
    public void passwordsMatch(String password) {
            passwordMatches = user.getPassword().equals(password);
    }
    
    /**
     * Il metodo effettua il logout dell'utente, settando a null il campo loggedUser della classe principale del software EmotionalSongs.
     * Inoltre resetta anche il manager delle playlist.
     */
    public static void logout(){
        EmotionalSongs.setLoggedUser(null);
        PlaylistsManager.eraseInstance();
    }
}
