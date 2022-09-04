package emotionalsongs;

import java.io.*;
import java.util.logging.*;

/**
 *
 * @author big
 */
public class DataBasePlaylists {
    
    PlaylistSet[] dataBase;
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
            //sort();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataBasePlaylists.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBasePlaylists.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void add(PlaylistSet set){
        PlaylistSet[] newOne = new PlaylistSet[dataBase.length+1];
        for (int i = 0; i < dataBase.length; i++) {
            newOne[i] = dataBase[i];
        }
        newOne[newOne.length-1] = set;
        sort();
        save();
    }
    
    public void save(){
        
    }
    
    //getter methods
    public int getSize(){
        return dataBase.length;
    }
    
    public PlaylistSet[] getArray(){
        return dataBase;
    }
    
    //sort method
    public void sort(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortDataBase(this);
    }

    PlaylistSet getSet(int index) {
        return dataBase[index];
    }
    
    PlaylistSet getUserSet(User user){
        if(empty) return null;
        EngineSearcher finder = new EngineSearcher();
        return finder.searchUserSet(user, this);    
    }
}
