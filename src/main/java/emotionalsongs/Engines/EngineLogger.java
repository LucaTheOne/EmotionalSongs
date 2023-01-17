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
 *@hidden
 * @author luca
 */
public class EngineLogger extends EmotionalSongs{
    
    private DataBaseUsers database = DataBaseUsers.getInstance();
    private User user;
    public boolean idFounded = false;
    public boolean passwordMatches = false;
    
    /**
     * 
     */

    public EngineLogger() {
    }
    
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
     * 
     * @param userId
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void foundsId(String userId) {
            EngineSearcher engineSearch = new EngineSearcher();
            user = engineSearch.getUserFromId(database, userId);
            idFounded = user != null; 
    }
    
    /**
     * 
     * @param userid
     * @param password
     * @return
     * @throws IOException 
     */
    public void passwordsMatch(String password) {
            passwordMatches = user.getPassword().equals(password);
    }
    
    public static void logout(){
        EmotionalSongs.setLoggedUser(null);
        //EmotionalSongs.setUserSet(null);
        PlayListsManager.eraseInstance();
    }
}
