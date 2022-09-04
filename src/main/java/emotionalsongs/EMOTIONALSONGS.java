
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    
    public static User loggedUser = null;
    public static Repository REPOSITORY;
    public static DataBaseRecords dataSetEmozioni;
    public static DataBaseUsers userDataBase;
    public static DataBasePlaylists dataBasePlaylists;
    public static boolean logged = false;
    public static GUIMainFrame mainWindow;
    public static PlayListsManager playListsManager;
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();      
    }
    
    private void initialize() throws IOException{
        GUIInitializationFrame init = new GUIInitializationFrame();
        REPOSITORY = new Repository();
        userDataBase = new DataBaseUsers();
        dataSetEmozioni = new DataBaseRecords();
        dataBasePlaylists = new DataBasePlaylists();
        init.dispose();
        mainWindow = new GUIMainFrame();
        mainWindow.setVisible(true);
    }
    
}
