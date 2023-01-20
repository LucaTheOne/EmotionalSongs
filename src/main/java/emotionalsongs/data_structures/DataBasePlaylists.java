//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


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
 * Classe che rappresenta il contenitore di tutti i PlaylistSet contenuti nel file Playlist.dati.txt.
 * Di fatto funge da database locale, inquanto fornisce metodi per la gestione, modifica e manipolazione dei dati.
 * Essendovi la necessita che l' istanza dela classe sia la stessa per tutto il sistema, essa è stata strutturata come singleton.
 */
public class DataBasePlaylists {
    
    private static DataBasePlaylists instance = null;
    PlaylistsSet[] dataBase = new PlaylistsSet[0];
    boolean empty = true;
    
    private DataBasePlaylists() {
        importData();
    }
    /**
     * Metodo che permette di accedere al database dei PlaylistSet.
     * @return Istanza del database.
     */
    public static DataBasePlaylists getInstance(){
        if(instance==null) instance = new DataBasePlaylists();
        return instance;
    }
    
    private void importData(){
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
    /**
     * Metodo che permette di aggiornare il database aggiungendo un nuovo PlaylistSet ed automaticamente
     * rendere il nuovo dato accessibile e consistente.
     * Riordina il database dopo averlo aggiornatao, ma prima di salvarlo su file sorgente.
     * @param set PlaylistSet da aggiungere.
     */ 
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
    
    /**
     * Metodo che permette di aggiungere al playlist set del utente loggato una nuova playlist.
     * @param playlist 
     */
    public void addToLoggedUserSet(Playlist playlist){
        PlaylistsManager.getInstance().getUserSet().addPlaylist(playlist);
        save();
    }
    
    //saving method
    /**
     * Rende i dati permanenti salvandoli sul file sorgente Playlist.dati.txt
     */
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
    /**
     * 
     * @return numero di set nel database
     */
    public int getSize(){
        return dataBase.length;
    }
    
    /**
     * @return L' arrai di Istanze di PlaylistSet che compone il database.
     */
    public PlaylistsSet[] getArray(){
        return dataBase;
    }
    
    /**
     * 
     * @param index int
     * @return Set in posizione index nel database.
     */
    public PlaylistsSet getSet(int index) {
        return dataBase[index];
    }
    
    /**
     * 
     * @param user Istanza di User di cui si vuole cercare il Playlist set associato.
     * @return PlaylistSet associato al utente passato come argomento.
     */
    public PlaylistsSet getUserSet(User user){
        if(empty) return null;
        EngineSearcher finder = new EngineSearcher();
        return finder.searchUserSet(user, this);    
    }
    
    
    //sort method
    private void sort(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortDataBaseOfPlaylistSet(this);
    }
}
