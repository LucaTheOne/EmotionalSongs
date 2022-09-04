
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author luca
 */
public class EngineLogger extends EMOTIONALSONGS{
    
    DataBaseUsers database = EMOTIONALSONGS.userDataBase;
    User user;
    boolean idFounded = false;
    boolean passwordMatches = false;
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
                EMOTIONALSONGS.logged = true;
                EMOTIONALSONGS.loggedUser = user;
            }  
        }
        EMOTIONALSONGS.playListsManager = new PlayListsManager(dataBasePlaylists);
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
        EMOTIONALSONGS.logged = false;
        EMOTIONALSONGS.loggedUser = null;
    }
}
