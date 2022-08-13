
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author luca
 */
public class LogInPerformer extends EMOTIONALSONGS{
    
    LogInFrame loginWindow;
    UserDatabase database;
    Utente user;
    /**
     * 
     */
    LogInPerformer(UserDatabase database){
        loginWindow = new LogInFrame();
        loginWindow.setVisible(true);
        this.database = database;
        
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public void logIn() throws IOException{
        
        boolean idExists = foundId(loginWindow.idField.getText());
        boolean passwordIsCorrect = passwordsMatch(String.valueOf(loginWindow.passwordField.getPassword()));
        if(!idExists){
            loginWindow.wrongId.setVisible(true);
            loginWindow.revalidate();
            loginWindow.repaint();
        }
        if(!passwordIsCorrect){
            loginWindow.wrongPassword.setVisible(true);
            loginWindow.revalidate();
            loginWindow.repaint();
        }
        if(idExists&&passwordIsCorrect){
            super.loggedUser = user;
            //ridisegnare il mainFrame
            loginWindow.dispose();
        }
    }
    
    /**
     * 
     * @param userId
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private boolean foundId(String userId) throws FileNotFoundException, IOException{
        user = ricercaBinaria(database, userId);
        return user != null;
    }
    
    /**
     * 
     * @param userid
     * @param password
     * @return
     * @throws IOException 
     */
    private boolean passwordsMatch(String password) throws IOException{
        if(user == null) return false;
        return user.getPassword().equals(password);
    }
    
    private Utente ricercaBinaria(UserDatabase database, String utente){
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
