//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs;

import emotionalsongs.gui.generics.InitializationFrame;
import emotionalsongs.gui.main_window.*;
import emotionalsongs.dialogs.dialogs;
import emotionalsongs.dialogs.Italiano;
import emotionalsongs.basic_structures.User;
import emotionalsongs.data_structures.DataBasePlaylists;
import emotionalsongs.data_structures.DataBaseUsers;
import emotionalsongs.data_structures.Repository;

import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EmotionalSongs {
    
    
    private static User loggedUser = null;
    public static dialogs dialoghi = new Italiano();
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EmotionalSongs software = new EmotionalSongs();
        software.initialize();    
    }
    private void initialize() throws IOException{
        InitializationFrame init = new InitializationFrame();
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
        EmotionalSongs.loggedUser = loggedUser;
    }
    
}
