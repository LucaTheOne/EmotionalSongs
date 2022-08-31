
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    
    public static Utente loggedUser = null;
    public static Repository REPOSITORY;
    public DataBaseEmozioni dataSetEmozioni;
    public static DataBaseUtenti userDataBase;
    public static boolean logged = false;
    public static GUIMainFrame mainWindow;
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();      
    }
    
    private void initialize() throws IOException{
        GUIInitializationFrame init = new GUIInitializationFrame();
        REPOSITORY = new Repository();
        //userDataBase = new DataBaseUtenti();
        init.dispose();
        mainWindow = new GUIMainFrame();
        mainWindow.setVisible(true);
    }
    
}
