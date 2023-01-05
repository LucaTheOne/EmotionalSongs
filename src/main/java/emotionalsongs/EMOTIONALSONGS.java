
package emotionalsongs;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Dialoghi.*;
import emotionalsongs.GUI.Generics.*;
import emotionalsongs.GUI.mainWindow.*;
import emotionalsongs.Managers.*;
import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    
    public static User loggedUser = null;
    public static Repository REPOSITORY = new Repository();
    public static DataBaseRecords dataSetEmozioni;
    public static DataBaseUsers userDataBase;
    public static DataBasePlaylists dataBasePlaylists;
    public static boolean logged = false;
    public static MainFrame mainWindow;
    public static PlayListsManager playListsManager;
    public static Dialoghi dialoghi = new DialoghiIta();
    public static int lenguage = 1;
    public static PlaylistSet userPlaylistSet;
    public static VoteManager voteManager;
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();    
    }
    
    private void initialize() throws IOException{
        GUIInitializationFrame init = new GUIInitializationFrame();
        REPOSITORY = new Repository();
        userDataBase = new DataBaseUsers();
        dataBasePlaylists = new DataBasePlaylists();
        voteManager = new VoteManager();
        init.dispose();
        mainWindow = MainFrame.getIstance();
        mainWindow.setVisible(true);
    }
    
    public static User getLoggedUser(){
        return loggedUser;
    }
    
}
