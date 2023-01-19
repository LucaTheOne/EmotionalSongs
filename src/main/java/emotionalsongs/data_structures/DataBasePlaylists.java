//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.data_structures;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.allerter.*;
import emotionalsongs.managers.*;
import java.io.*;
import java.util.logging.*;

/**
 *
 * @author big
 */
public class DataBasePlaylists {
    
    private static DataBasePlaylists instance = null;
    PlaylistsSet[] dataBase = new PlaylistsSet[0];
    boolean empty = true;
    
    private DataBasePlaylists() {
        importData();
    }
    
    public static DataBasePlaylists getInstance(){
        if(instance==null) instance = new DataBasePlaylists();
        return instance;
    }
    public void importData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Utilities.pathToPlaylistDati));
            int n = (int)Utilities.countLines(Utilities.pathToPlaylistDati);
            if(n==0) return;
            
            dataBase = new PlaylistsSet[n];
            for(int i = 0; i<n;i++){
                dataBase[i] = new PlaylistsSet(reader.readLine());
            }
            empty = false;
            sort();
        } catch (FileNotFoundException ex) {
            new PopUpAllert("File Playlist.dati.txt non trovato!").setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(DataBasePlaylists.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    //updating methods
    public void addNewSet(PlaylistsSet set){
        PlaylistsSet[] newOne = new PlaylistsSet[dataBase.length+1];
        for (int i = 0; i < dataBase.length; i++) {
            newOne[i] = dataBase[i];
        }
        newOne[newOne.length-1] = set;
        dataBase = newOne;
        sort();
        save();
    }
    
    public void addToLoggedUserSet(Playlist playlist){
        PlaylistsManager.getInstance().getUserSet().addPlaylist(playlist);
        save();
    }
    
    //saving method
    public void save(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Utilities.pathToPlaylistDati));
            if(dataBase.length != 0){
                for (int i = 0; i < dataBase.length; i++) {
                writer.write(dataBase[i].componiStringa());
                }
                writer.flush();
                writer.close();
            } else {
                System.out.println("database is void");
            }
        } catch (IOException ex) {
            Logger.getLogger(DataBasePlaylists.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //getter methods
    public int getSize(){
        return dataBase.length;
    }
    
    public PlaylistsSet[] getArray(){
        return dataBase;
    }
    
    public PlaylistsSet getSet(int index) {
        return dataBase[index];
    }
    
    public PlaylistsSet getUserSet(User user){
        if(empty) return null;
        EngineSearcher finder = new EngineSearcher();
        return finder.searchUserSet(user, this);    
    }
    
    
    //sort method
    public void sort(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortDataBaseOfPlaylistSet(this);
    }
}
