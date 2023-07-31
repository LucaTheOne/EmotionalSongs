/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.managers;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.gui.allerter.*;
import emotionalsongs.gui.main_window.*;
import emotionalsongs.gui.playlists.*;
import java.util.*;
import serverES.db_communication.*;


/**
 * Classe che si occupa di gestire le playlist all' interno del software, la loro rappresentazione, manipolazione e tutto ciò che le riguarda.
 * Siccome vi è la necessità che l'istanza di questa classe sia la stessa per tutto il sistema, questa classe è strutturata come singleton.
 * Questa classe può differire in base al utente che ha effettuato il login, quindi esiste un metodo di cancellazione per questa classe, così
 * che sia possibile de-istanziarla quando si effettua un logout e reinstanziarla sulla base del nuovo utente che effettua il logout.
 */
public class PlaylistsCreationManager {
    
    private static PlaylistsCreationManager instance = null;
    private PlaylistsMainPanel playlistmainPanel ;
    private PlaylistCreationFrame creationFrame;
        
    private User user = EmotionalSongs.getLoggedUser();
    private String nameNewPlaylist = "";
    private Vector<String> songsToAddIds = new Vector<>();
    private int numberOfSongsSelected = 0;
    
    private DBQuerier service = new DBQuerier(DBConnector.getDefaultConnection());
    
    /**
     * Metodo per accedere alla classe, richiamandone la sua unica istanza.
     * @return playlist manager
     */
    public static PlaylistsCreationManager getInstance(){
        if(instance != null)return instance;
        else return new PlaylistsCreationManager();
    }
    
    private PlaylistsCreationManager() {
    }
    
    //getter method
    
    /**
     * 
     * @return Numero di canzoni nel buffer in attesa di essere aggiunte ad una playlist.
     */
    public int getNumberOfSongToAdd() {
        return numberOfSongsSelected;
    }
    /**
     * Ritorna la canzone, nel buffer delle canzoni in attesa di essere aggiunte ad una playlist, in posizione index.
     * @param index posizione a cui riferirsi.
     * @return Canzone di posizione index nel buffer.
     */
    public String getSongToAdd(int index){
        return songsToAddIds.elementAt(index);
    }
    /**
     *
     * @return array contenente l' intero buffer delle canzoni in attesa di essere aggiunte ad una playlist.
     */
    public String[] songsToAddArray() {
        String[] temp = new String[songsToAddIds.size()];
        for(int i = 0;i<temp.length;i++ ){
            temp[i] = songsToAddIds.get(i);
        }
        return temp;
    }
    
    //generator method
    /**
     * Metodo che avvia il processo responsabile della creazione di una nuova playlist.
     * Il form associato è fortemente guidato dai metodi di questa classe.
     * Una volta creata, la playlist, viene mostrata nella finestra prrincipale del software.
     */
    public void registraPlaylist(){
        if(songsToAddIds.isEmpty()){
            new PopUpAllert(EmotionalSongs.dialoghi.voidPlaylistsDenied());
            return;
        }
        service.updatePlaylistTable(nameNewPlaylist, user.getUserId(), songsToAddArray());
        updatePlaylistsPanel();
    }
    
    //updater methods
    /**
     * Aggiunge la canzone passata come argomento al buffer ddelle canzoni in attesa di essere
     * aggiunte ad una playlist.
     * @param song Canzone da aggiungere al buffer.
     */
    public void addToSelectedSongs(String songId) {
        songsToAddIds.add(songId);
        System.out.println("song added in position" + (songsToAddIds.size()-1));
        numberOfSongsSelected++;
    }
    /**
     * Rimuove la canzone passata come argomento dal buffer 
     * delle canzoni in attesa di essere aggiunte ad una playlist.
     * @param song 
     */
    public void removeToSelectedSongs(String songId) {
        for(String str:songsToAddIds){
            if(str.equals(songId)) songsToAddIds.remove(str);
        }
        System.out.println(songId +": id of the removed song from the add list");
        numberOfSongsSelected--;
    }
    /**
     * Ripulisce il buffer delle anzoni in attesa di essere aggiunte ad una playlist.
     */
    public void eraseSongToAdd(){
        songsToAddIds.removeAllElements();
        numberOfSongsSelected = 0;
    }
    
    /**
     * Resetta il buffer contenente il titolo della playlist in fase di creazione.
     */
    public void eraseTitlePlaylist() {
        nameNewPlaylist = "";
    }
    /**
     * salva nel buffer il titolo della playlist in fase di creazione.
     */
    public void setTitlePlaylist(String title) {
        nameNewPlaylist = title;
    }
    
    public void updateUser(User user){
        this.user = user;
    }
    
    /**
     * Metodo che gestisce la parte della gui che indica il numero di canzoni presenti nel buffer delle canzoni 
     * in attesa di essere aggiunte ad una playlist.
     */
    public void updateSongSelectedLabel(){
        creationFrame.numberSelectedSongLabel.setText(numberOfSongsSelected+" brani selezionati");
        creationFrame.revalidate();
        creationFrame.repaint();
    }
    /**
     * Incrementa il numero che rappresenta le canzoni nel buffer di attesa.
     */
    public void increaseNumberOfSongToAdd(){
        numberOfSongsSelected++;
    }
    /**
     * Decrementa il numero che rappresenta le canzoni nel buffer di attesa.
     */
    public void decreaseNumberOfSongToAdd(){
        numberOfSongsSelected--;
    }
    /**
     * Azzera il numero che rappresenta le canzoni nel buffer di attesa.
     */
    public void eraseNumberOfSongsToAdd(){
        numberOfSongsSelected = 0;
    }
    /**
     * Metodo di gestione della GUI, fa si che venga mostrata la lista di playlist dell' utente loggato.
     */
    public void setPlaylistsButtonPanel(){
        playlistmainPanel.setLeftInnerPanel(service.requestPlaylistsUser(EmotionalSongs.getLoggedUser().getUserId()));
    }
    
    //checker methods
    /**
     * Metodo che verifica la presenza della canzone passata come argomento nel buffer delle canzoni in attesa
     * di essere aggiunte ad una playlist.
     * @param song Canzone di cui verificare la presenza.
     * @return true -> se la canzone è presente.
     */
    public boolean containInSongsToAdd(String songId) {
        if(!(songsToAddIds.size() == 0)) {
            for(String str:songsToAddIds){
                if(str.equals(songId)){
                    return true;
                }
            }  
        }
        return false;
    }
    /**
     * Metodo cha avvia il form per la creazione di una nuova playlist.
     */
    public void startCreation(){
        creationFrame = new PlaylistCreationFrame();
        creationFrame.setVisible(true);
    }
    /**
     * Ritorna il numero di playlist dell' utente loggato.
     * @return Numero di playlist create dall' utente loggato.
     */
    public int getNumberOfPlaylists() {
        return service.getUserPlaylistsNumber(EmotionalSongs.getLoggedUser().getUserId());
    }
    
    /**
     * Metodo che opera sulla gui per far si che il pannello passato come argomento, Pannello che mostra
     * il contenuto di una playlist, venga impostato e mostrato come pannello centrale dell' interfaccia.
     * @param viewPanel Pannello delle canzoni di una playlist.
     */
    public void setRightPane(PlaylistSongsViewPanel viewPanel){
       playlistmainPanel.redrawRightPanel(viewPanel);
    }
    
    /**
     * Metodo per aggiornare il pannello delle playlist del utente.
     */
    public void updatePlaylistsPanel() {
        playlistmainPanel = new PlaylistsMainPanel(EmotionalSongs.getLoggedUser().getUserId());
        MainFrame.getIstance().setMainPanel(playlistmainPanel);
        MainFrame.getIstance().revalidate();
        MainFrame.getIstance().repaint();
    }
    
    /**
     * Metodo per resettare tutti i buffer presenti nel playlist manager.
     */
    public void reset() {
        numberOfSongsSelected = 0;
        songsToAddIds.removeAllElements();
    }
    /**
     * Metodo per liberare il buffer delle canzoni in attesa di essere aggiunte ad una playlist.
     */
    public void eraseNumberOfSelectedSong() {
        numberOfSongsSelected = 0;
    }

    
}

