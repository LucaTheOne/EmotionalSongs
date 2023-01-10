
package emotionalsongs.Managers;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.ErrorMessage.*;
import emotionalsongs.GUI.PlayLists.*;
import emotionalsongs.GUI.mainWindow.*;


/**
 *
 * @author big
 */
public class PlayListsManager {
    
    private static PlayListsManager instance = null;
    PlaylistsMainPanel playlistPanel ;
    PlaylistCreationFrame creationFrame;
    final DataBasePlaylists dataBasePlaylists ;
        
    User user = EMOTIONALSONGS.getLoggedUser();
    
    PlaylistSet userSet;
    int userSetDimension;
    
    Playlist selectedPlaylist;
    int numberOfSongSelectedPlaylist;
    private String nameNewPlaylist = "";
    
    private Song[] songsToAdd = new Song[0];
    private int numberOfSongsSelected = 0;
    
    public static PlayListsManager getInstanceFirstTime(DataBasePlaylists dataBasePlaylists){
        if(instance==null) instance = new PlayListsManager(dataBasePlaylists);
        return instance;
    }
    
    public static PlayListsManager getInstance(){
        return instance;
    }

    private PlayListsManager(DataBasePlaylists dataBasePlaylists) {
        EngineSearcher finder = new EngineSearcher();
        EMOTIONALSONGS.userPlaylistSet = finder.searchUserSet(user, dataBasePlaylists);
        userSet = EMOTIONALSONGS.userPlaylistSet;
        userSetDimension = userSet==null ? 0 : userSet.getSize();
        this.dataBasePlaylists = dataBasePlaylists;
    }
    
    //getter method
    public PlaylistSet getUserSet(){
        return EMOTIONALSONGS.userPlaylistSet;
    }
    
    public int getNumberOfSongToAdd() {
        return numberOfSongsSelected;
    }
    
    public Song getSongToAdd(int index){
        return songsToAdd[index];
    }
    
    public Song[] getSongsToAdd() {
        return songsToAdd;
    }
    
    //generator method
    public void registraPlaylist(){
        if(songsToAdd.length == 0){
            new PopUpAllert("Le playlist vuote non sono consentite!");
            return;
        }
        Playlist newPlaylist = new Playlist(nameNewPlaylist, songsToAdd);
        userSet = EMOTIONALSONGS.userPlaylistSet;
        if(userSet == null){
            userSet = new PlaylistSet(user.getUserId(), newPlaylist);
            dataBasePlaylists.addNewSet(userSet);
            userSet = new EngineSearcher().searchUserSet(user, DataBasePlaylists.getInstance());
        } else {
            dataBasePlaylists.addToSet(newPlaylist);
            //EMOTIONALSONGS.dataBasePlaylists = new DataBasePlaylists();
            userSet = new EngineSearcher().searchUserSet(user, DataBasePlaylists.getInstance());
        } 
        
        playlistPanel.setLeftInnerPanel(userSet);
        MainFrame.getIstance().setMainPanel(playlistPanel);
        
    }
    
    //updater methods
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
    
    public void eraseSongToAdd(){
        songsToAdd = new Song[0];
    }

    public void eraseTitlePlaylist() {
        nameNewPlaylist = "";
    }
    
    public void setTitlePlaylist(String title) {
        nameNewPlaylist = title;
    }
    
    public void updateUser(User user){
        this.user = user;
    }
    
    public void updateSongSelectedLabel(){
        creationFrame.numberSelectedSongLabel.setText(numberOfSongsSelected+" brani selezionati");
        creationFrame.revalidate();
        creationFrame.repaint();
    }
    
    public void increaseNumberOfSongToAdd(){
        numberOfSongsSelected++;
    }
    
    public void decreaseNumberOfSongToAdd(){
        numberOfSongsSelected--;
    }
    
    public void eraseNumberOfSongsToAdd(){
        numberOfSongsSelected = 0;
    }
    
    public void setPlaylistsButtonPanel(){
        playlistPanel.setLeftInnerPanel(userSet);
    }
    
    //checker methods
    public boolean containInSongsToAdd(Song song) {
        if(songsToAdd.length == 0) return false;
        EngineChecker checker = new EngineChecker();
        return checker.checkIfContains(songsToAdd,song.getTag());    
    }
    
    private PlaylistsMainPanel buildUserPlaylistsPanel(){
       return new PlaylistsMainPanel();
    }
    
    public void startCreation(){
        creationFrame = new PlaylistCreationFrame();
        creationFrame.setVisible(true);
    }

    public int getNumberOfPlaylists() {
        return userSetDimension;
    }

    public int getNumberOfSongOfSelectedPlaylist() {
        return numberOfSongSelectedPlaylist;
    }
    
    public void setRightPane(PlaylistSongsViewPanel viewPanel){
       playlistPanel.redrawRightPanel(viewPanel);
    }

    public void selectPlaylist(Playlist correlatedPlaylist) {
        this.selectedPlaylist = correlatedPlaylist;
        numberOfSongSelectedPlaylist = correlatedPlaylist.getSize();
    }

    public void addToPlaylistSet(Playlist playlist) {
        userSet.addPlaylist(playlist);
        playlistPanel.addToLeftPanel(playlist.buildPlaylistButton());
        updatePlaylistsPanel();
    }

    public void updatePlaylistsPanel() {
        playlistPanel = new PlaylistsMainPanel();
        MainFrame.getIstance().setMainPanel(playlistPanel);
        MainFrame.getIstance().revalidate();
        MainFrame.getIstance().repaint();
    }
    
    public void addSongToPlaylist(Song songToAdd,Playlist playlistWhereToAddSong){
        //da implementare insieme a GUI per aggiungere una canzone alla playlist.
    }
    
    public void deleteAsongFromAPlaylist(Song songToDelete){
        selectedPlaylist.removeSong(songToDelete);
        dataBasePlaylists.save();
        setRightPane(new PlaylistSongsViewPanel(selectedPlaylist));
    }
    
    public void setSelectedPlaylist(Playlist selectedPlaylist){
        this.selectedPlaylist = selectedPlaylist;
    }

    public void reset() {
        selectedPlaylist = null;
        numberOfSongSelectedPlaylist = 0;
        songsToAdd = new Song[0];
        numberOfSongsSelected = 0;
    }

    
}

