
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author luca
 */
public class LogInPerformer extends EMOTIONALSONGS{
    
    UserDatabase database;
    Utente user;
    /**
     * 
     */
    LogInPerformer(UserDatabase database){
        
        this.database = database;
        
    }
    
    /**
     * 
     * @param userId
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public boolean foundId(String userId) {
        try {
            user = ricercaBinaria(database, userId);
            return user != null;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    /**
     * 
     * @param userid
     * @param password
     * @return
     * @throws IOException 
     */
    public boolean passwordsMatch(String password) {
        try {
            if(user == null) return false;
            return user.getPassword().equals(password);
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public Utente ricercaBinaria(UserDatabase database, String utente){
	int low = 0;
	int high = database.getDimensione();	
	while (low<=high) {
            int mid = (low+high)/2;
            if(database.get(mid).getUserId().compareTo(utente)==0) {
                return database.get(mid);
	    } else if (database.get(mid).getUserId().compareTo(utente)<0) {
                low = mid + 1;
            }else {
		high = mid - 1;
            }
	}
	return null; //non l'ha trovato	
    }
}
