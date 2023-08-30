/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.clientES.client_internal_services;

import emotionalsongs.clientES.gui.playlists.PlaylistsMainPanel;
import emotionalsongs.clientES.gui.playlists.PlaylistSongsViewPanel;
import emotionalsongs.clientES.gui.playlists.PlaylistCreationFrame;
import emotionalsongs.clientES.gui.main_window.MainFrame;
import emotionalsongs.clientES.gui.allerter.PopUpAllert;
import emotionalsongs.clientES.ServicesProvider;
import serverES.server_services_common_interfaces.data_validator.PlaylistsDataValidator;
import serverES.server_services_common_interfaces.data_handler.PlaylistsDataHandler;
import emotionalsongs.*;
import java.rmi.*;
import java.util.*;


/**
 * Classe che si occupa di gestire le playlist all' interno del software, la loro rappresentazione, manipolazione e tutto ciò che le riguarda.
 * Siccome vi è la necessità che l'istanza di questa classe sia la stessa per tutto il sistema, questa classe è strutturata come singleton.
 * Questa classe può differire in base al utente che ha effettuato il login, quindi esiste un metodo di cancellazione per questa classe, così
 * che sia possibile de-istanziarla quando si effettua un logout e reinstanziarla sulla base del nuovo utente che effettua il logout.
 */
public class PlaylistsManager {
    
    private static PlaylistsManager instance = null;
    private PlaylistsMainPanel playlistmainPanel ;
    private PlaylistCreationFrame creationFrame;
    private final MainFrame mainFrame;
        
    private String user;
    private String nameNewPlaylist = "";
    private final Vector<String> songsToAddIds = new Vector<>();
    
    private final PlaylistsDataHandler playlistsDataHandler;
    private final PlaylistsDataValidator playlistsDataValidator;
    
    /**
     * Metodo per accedere alla classe, richiamandone la sua unica istanza.
     * @return playlist manager
     */
    public static PlaylistsManager getInstance(){
        if(instance == null) instance = new PlaylistsManager();
        return instance;
    }
    
    private PlaylistsManager() {
        user = EmotionalSongs.getLoggedUser();
        ServicesProvider sp = ServicesProvider.getInstance();
        playlistsDataHandler = (PlaylistsDataHandler) sp.getService(ServicesProvider.PLAYLISTS_DATA_HANDLER);
        playlistsDataValidator = (PlaylistsDataValidator) sp.getService(ServicesProvider.PLAYLISTS_DATA_VALIDATOR);
        mainFrame = MainFrame.getIstance();
    }
    
    //getter method
    
    /**
     * 
     * @return Numero di canzoni nel buffer in attesa di essere aggiunte ad una playlist.
     */
    public int getNumberOfSongToAdd() {
        return songsToAddIds.size();
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
     * Una volta creata, la playlist, viene mostrata nella finestra principale del software.
     */
    public void registraPlaylist(){
        if(songsToAddIds.isEmpty()){
            new PopUpAllert(EmotionalSongs.dialoghi.voidPlaylistsDenied());
            return;
        }
        try {
            playlistsDataHandler.updatePlaylistTable(nameNewPlaylist, user, songsToAddArray());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        openUserPlaylistsView();
    }
    
    //updater methods
    /**
     * Aggiunge la canzone passata come argomento al buffer ddelle canzoni in attesa di essere
     * aggiunte ad una playlist.
     * @param songId id della canzone da aggiungere al buffer.
     */
    public void addToSelectedSongs(String songId) {
        songsToAddIds.add(songId);
        System.out.println("song added in position" + (songsToAddIds.size()-1));
    }
    /**
     * Rimuove la canzone passata come argomento dal buffer 
     * delle canzoni in attesa di essere aggiunte ad una playlist.
     * @param songId id della canzone da rimuovere dal buffer. 
     */
    public void removeToSelectedSongs(String songId) {
        for(String str:songsToAddIds){
            if(str.equals(songId)) songsToAddIds.remove(str);
        }
        System.out.println(songId +": id of the removed song from the add list");
        
    }
    /**
     * Resetta tutti i dati contenuti nel manager.
     */
    public void resetManager(){
        songsToAddIds.removeAllElements();
        nameNewPlaylist = "";
    }
    
    /**
     * salva nel buffer il titolo della playlist in fase di creazione.
     * @param title titolo da assegnare alla nuova playlist.
     */
    public void setTitlePlaylist(String title) {
        nameNewPlaylist = title;
    }
    
    public void updateUser(String user){
        resetManager();
        this.user = user;
    }
    
    /**
     * Metodo che gestisce la parte della gui che indica il numero di canzoni presenti nel buffer delle canzoni 
     * in attesa di essere aggiunte ad una playlist.
     */
    public void updateSongSelectedLabel(){
        creationFrame.numberSelectedSongLabel.setText(songsToAddIds.size()+" brani selezionati");
        creationFrame.revalidate();
        creationFrame.repaint();
    }

    /**
     * Metodo di gestione della GUI, fa si che venga mostrata la lista di playlist dell' utente loggato.
     */
    public void setPlaylistsButtonPanel(){
        try {
            playlistmainPanel.setLeftInnerPanel(playlistsDataHandler.requestPlaylistsUser(user));
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //checker methods
    /**
     * Metodo che verifica la presenza della canzone passata come argomento nel buffer delle canzoni in attesa
     * di essere aggiunte ad una playlist.
     * @param songId id univoco della canzone di cui verificare la presenza nel buffer.
     * @return true -> se la canzone è presente, false altrimenti.
     */
    public boolean containInSongsToAdd(String songId) {
        if(!(songsToAddIds.isEmpty())) {
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
        try {
            creationFrame = new PlaylistCreationFrame();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        creationFrame.setVisible(true);
    }
    /**
     * Ritorna il numero di playlist dell' utente loggato.
     * @return Numero di playlist create dall' utente loggato.
     */
    public int getNumberOfPlaylists() {
        try {
            return playlistsDataHandler.getUserPlaylistsNumber(user);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
             return -1;
        }  
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
    public void openUserPlaylistsView() {
        try {
            int nplaylists = playlistsDataHandler.getUserPlaylistsNumber(EmotionalSongs.getLoggedUser());
            if(nplaylists==0){
                new PopUpAllert(EmotionalSongs.dialoghi.noPlaylists());
                return;
            }
            playlistmainPanel = new PlaylistsMainPanel(user);
            mainFrame.setMainPanel(playlistmainPanel);
            mainFrame.revalidate();
            mainFrame.repaint();
        } catch (RemoteException ex) {
            new PopUpAllert(ex.getMessage());
        }
    }
}

