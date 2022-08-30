
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    
    public static Utente loggedUser = null;
    public static Repository REPOSITORY;
    public RaccoltaDatiEmozioniBrano dataSetEmozioni;
    public static UserDatabase userDatabase;
    public static boolean logged = false;
    public static GUIMainFrame mainWindow;
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();      
    }
    
    private void initialize() throws IOException{
        GUIInitializationFrame init = new GUIInitializationFrame();
        REPOSITORY = new Repository();
        userDatabase = new UserDatabase();
        init.dispose();
        mainWindow = new GUIMainFrame();
        mainWindow.setVisible(true);
    }
    
}
