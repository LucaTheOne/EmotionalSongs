//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Dialoghi.*;
import emotionalsongs.GUI.Generics.*;
import emotionalsongs.GUI.mainWindow.*;
import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    
    private static User loggedUser = null;
    public static Dialoghi dialoghi = new DialoghiIta();
    private static PlaylistSet userPlaylistSet;
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();    
    }

    public static void setUserSet(PlaylistSet newUserSet) {
        userPlaylistSet = newUserSet;
    }
    
    private void initialize() throws IOException{
        GUIInitializationFrame init = new GUIInitializationFrame();
        Repository.getInstance();
        DataBaseUsers.getInstance();
        DataBasePlaylists.getInstance();
        init.dispose();
        MainFrame.getIstance().setVisible(true);
    }
    
    public static User getLoggedUser(){
        return loggedUser;
    }
    
    public static void setLoggedUser(User loggedUser){
        EMOTIONALSONGS.loggedUser = loggedUser;
    }
    
    public static PlaylistSet getUserSet(){
        return userPlaylistSet;
    }
    
}
