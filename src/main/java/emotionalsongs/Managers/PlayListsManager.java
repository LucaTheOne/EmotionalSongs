//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.managers;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.allerter.*;
import emotionalsongs.gui.main_window.*;
import emotionalsongs.gui.playlists.*;


/**
 * Classe che si occupa di gestire le playlist all' interno del software, la loro rappresentazione, manipolazione e tutto ciò che le riguarda.
 * Siccome vi è la necessità che l' istanza di questa classe sia la stessa per tutto il sistema, questa classe è strutturata come singleton.
 * Questa classe può differire in base al utente che ha effettuato il login, quindi esiste un metodo di cancellazione per questa classe, così
 * che sia possibile de-istanziarla quando si effettua un logout e reinstanziarla sulla base del nuovo utente che effettua il logout.
 */
public class PlaylistsManager {
    
    private static PlaylistsManager instance = null;
    private PlaylistsMainPanel playlistPanel ;
    private PlaylistCreationFrame creationFrame;
    final DataBasePlaylists dataBasePlaylists ;
        
    private User user = EmotionalSongs.getLoggedUser();
    
    private PlaylistsSet userSet;
    private int userSetDimension;
    /**
     * Buffer contenente la playlist cui punta il playlist manager.
     */
    private Playlist selectedPlaylist;
    private int numberOfSongSelectedPlaylist;
    /**
     * Buffer contenente il nome della playlist in fase di creazione.
     */
    private String nameNewPlaylist = "";
    /**
     * Buffer delle canzoni in attesa di essere aggiunte alla playlist in creazione.
     */
    private Song[] songsToAdd = new Song[0];
    private int numberOfSongsSelected = 0;
    
    /**
     * Metodo che istanzia per la prima volta la classe.
     * @param dataBasePlaylists
     * @return Playlist manager
     */
    public static PlaylistsManager getInstanceFirstTime(DataBasePlaylists dataBasePlaylists){
        if(instance==null) instance = new PlaylistsManager(dataBasePlaylists);
        return instance;
    }
    /**
     * Metodo per accedere alla classe, richiamandone la sua unica istanza.
     * @return playlist manager
     */
    public static PlaylistsManager getInstance(){
        return instance;
    }
    /**
     * Metodo di de-instanziazione della classe.
     */
    public static void eraseInstance(){
        if(instance != null) instance=null;
    }
    
    private PlaylistsManager(DataBasePlaylists dataBasePlaylists) {
        EngineSearcher finder = new EngineSearcher();
        userSet = finder.searchUserSet(user, dataBasePlaylists);
        userSetDimension = userSet==null ? 0 : userSet.getSize();
        this.dataBasePlaylists = dataBasePlaylists;
    }
    
    //getter method
    /**
     * Metodo per accedere al PlaylistSet del utente loggato.
     * @return PlaylistSet del utente attualmente loggato.
     */
    public PlaylistsSet getUserSet(){
        return userSet;
    }
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
    public Song getSongToAdd(int index){
        return songsToAdd[index];
    }
    /**
     *
     * @return array contenente l' intero buffer delle canzoni in attesa di essere aggiunte ad una playlist.
     */
    public Song[] getSongsToAdd() {
        return songsToAdd;
    }
    
    //generator method
    /**
     * Metodo che avvia il processo responsabile della creazione di una nuova playlist.
     * Il form associato è fortemente guidato dai metodi di questa classe.
     * Una volta creata, la playlist, viene mostrata nella finestra prrincipale del software.
     */
    public void registraPlaylist(){
        if(songsToAdd.length == 0){
            new PopUpAllert(EmotionalSongs.dialoghi.voidPlaylistsDenied());
            return;
        }
        Playlist newPlaylist = new Playlist(nameNewPlaylist, songsToAdd);
        userSet = getUserSet();
        if(userSet == null){
            userSet = new PlaylistsSet(user.getUserId(), newPlaylist);
            dataBasePlaylists.addNewSet(userSet);
            userSet = new EngineSearcher().searchUserSet(user, DataBasePlaylists.getInstance());
        } else {
            dataBasePlaylists.getUserSet(user).addPlaylist(newPlaylist);
            dataBasePlaylists.save();
            userSet = (new EngineSearcher().searchUserSet(user, DataBasePlaylists.getInstance())) ;
        } 
        playlistPanel = new PlaylistsMainPanel(userSet);
        MainFrame.getIstance().setMainPanel(playlistPanel);
        
    }
    
    //updater methods
    /**
     * Aggiunge la canzone passata come argomento al buffer ddelle canzoni in attesa di essere
     * aggiunte ad una playlist.
     * @param song Canzone da aggiungere al buffer.
     */
    public void addToSelectedSongs(Song song) {
        Song[] newOne = new Song[songsToAdd.length+1];
        if(newOne.length==1) {
            newOne[0] = song;
            System.out.println("song added!");
        }
        for (int i = 0; i < songsToAdd.length; i++) {
            newOne[i] = songsToAdd[i];
        }
        newOne[newOne.length-1] = song;
        songsToAdd = newOne;
        System.out.println("song added in position" + (newOne.length-1));
    }
    /**
     * Rimuove la canzone passata come argomento dal buffer 
     * delle canzoni in attesa di essere aggiunte ad una playlist.
     * @param song 
     */
    public void removeToSelectedSongs(Song song) {
        Song[] newOne = new Song[songsToAdd.length-1];
        if(newOne.length == 0) {
            songsToAdd = new Song[0];
            return;
        }
        int indexCounter = 0;
        for(int i = 0;i<songsToAdd.length;i++){
            if(!songsToAdd[i].equalsTo(song)){
                newOne[indexCounter++] = songsToAdd[i];
            }
        }
    }
    /**
     * Ripulisce il buffer delle anzoni in attesa di essere aggiunte ad una playlist.
     */
    public void eraseSongToAdd(){
        songsToAdd = new Song[0];
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
    /*
    public void updateUser(User user){
        this.user = user;
    }
    */
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
        playlistPanel.setLeftInnerPanel(userSet);
    }
    
    //checker methods
    /**
     * Metodo che verifica la presenza della canzone passata come argomento nel buffer delle canzoni in attesa
     * di essere aggiunte ad una playlist.
     * @param song Canzone di cui verificare la presenza.
     * @return true -> se la canzone è presente.
     */
    public boolean containInSongsToAdd(Song song) {
        if(songsToAdd.length == 0) return false;
        EngineChecker checker = new EngineChecker();
        return checker.checkIfContains(songsToAdd,song.getTag());    
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
        return userSetDimension;
    }
    /**
     * Ritorna il numero di canzoni presenti nel buffer delle playlist selezionate.
     * @return 
     */
    public int getNumberOfSongOfSelectedPlaylist() {
        return numberOfSongSelectedPlaylist;
    }
    /**
     * Metodo che opera sulla gui per far si che il pannello passato come argomento, Pannello che mostra
     * il contenuto di una playlist, venga impostato e mostrato come pannello centrale dell' interfaccia.
     * @param viewPanel Pannello delle canzoni di una playlist.
     */
    public void setRightPane(PlaylistSongsViewPanel viewPanel){
       playlistPanel.redrawRightPanel(viewPanel);
    }
    /**
     * Inserisce la playlist passata come argomento nel buffer delle playlist in attesa.
     * @param selectedPlaylist playlist da mettere in attesa. 
     */
    public void selectPlaylist(Playlist selectedPlaylist) {
        this.selectedPlaylist = selectedPlaylist;
        numberOfSongSelectedPlaylist = selectedPlaylist.getSize();
    }
    /**
     * Metodo per gestire l' aggiornamento del PlaylistSet del utente loggato.
     * @param playlist Playlist da aggiungere al set.
     */
    public void addToPlaylistSet(Playlist playlist) {
        userSet.addPlaylist(playlist);
        playlistPanel.addToLeftPanel(playlist.buildPlaylistButton());
        updatePlaylistsPanel();
    }
    /**
     * Metodo per aggiornare il pannello delle playlist del utente.
     */
    public void updatePlaylistsPanel() {
        playlistPanel = new PlaylistsMainPanel(userSet);
        MainFrame.getIstance().setMainPanel(playlistPanel);
        MainFrame.getIstance().revalidate();
        MainFrame.getIstance().repaint();
    }
    /**
     * Metodo che permette di puntare il manager della playlist alla playlist passata come argomento,
     * inserendola in un buffer.
     * @param selectedPlaylist Playlist a cui far puntare il playlists manager. 
     */
    public void setSelectedPlaylist(Playlist selectedPlaylist){
        this.selectedPlaylist = selectedPlaylist;
    }
    
    /**
     * Metodo per resettare tutti i buffer presenti nel playlist manager.
     */
    public void reset() {
        selectedPlaylist = null;
        numberOfSongSelectedPlaylist = 0;
        songsToAdd = new Song[0];
        numberOfSongsSelected = 0;
    }
    /**
     * Metodo per liberare il buffer delle canzoni in attesa di essere aggiunte ad una playlist.
     */
    public void eraseNumberOfSelectedSong() {
        numberOfSongsSelected = 0;
    }

    
}

