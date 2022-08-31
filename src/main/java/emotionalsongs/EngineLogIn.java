
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author luca
 */
public class EngineLogIn extends EMOTIONALSONGS{
    
    DataBaseUtenti database = EMOTIONALSONGS.userDataBase;
    Utente user;
    boolean idFounded = false;
    boolean passwordMatches = false;
    /**
     * 
     */

    public EngineLogIn() {
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
}
