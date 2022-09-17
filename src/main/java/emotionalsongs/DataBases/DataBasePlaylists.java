package emotionalsongs.DataBases;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Engines.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Engines.*;
import java.io.*;
import java.util.logging.*;

/**
 *
 * @author big
 */
public class DataBasePlaylists {
    
    PlaylistSet[] dataBase = new PlaylistSet[0];
    boolean empty = true;
    
    public DataBasePlaylists() {
        importData();
    }
    
    public void importData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Utilities.pathToPlaylistDati));
            int n = (int)Utilities.countLines(Utilities.pathToPlaylistDati);
            if(n==0) return;
            dataBase = new PlaylistSet[n];
            for(int i = 0; i<n;i++){
                dataBase[i] = new PlaylistSet(reader.readLine());
            }
            empty = false;
            sort();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataBasePlaylists.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBasePlaylists.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    //updating methods
    public void addNewSet(PlaylistSet set){
        PlaylistSet[] newOne = new PlaylistSet[dataBase.length+1];
        for (int i = 0; i < dataBase.length; i++) {
            newOne[i] = dataBase[i];
        }
        newOne[newOne.length-1] = set;
        dataBase = newOne;
        sort();
        save();
    }
    
    public void addToSet(Playlist playlist){
        EMOTIONALSONGS.userPlaylistSet.addPlaylist(playlist);
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
    
    public PlaylistSet[] getArray(){
        return dataBase;
    }
    
    public PlaylistSet getSet(int index) {
        return dataBase[index];
    }
    
    public PlaylistSet getUserSet(User user){
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
