
package emotionalsongs.Managers;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.PlayLists.*;


/**
 *
 * @author big
 */
public class PlayListsManager {
    
    PlaylistsMainPanel playlistPanel ;
    PlaylistCreationFrame creationFrame;
    final DataBasePlaylists dataBasePlaylists;
        
    User user = EMOTIONALSONGS.loggedUser;
    
    PlaylistSet userSet;
    int userSetDimension;
    
    Playlist selectedPlaylist;
    int numberOfSongSelectedPlaylist;
    private String nameNewPlaylist = "";
    
    private Song[] songsToAdd = new Song[0];
    private int numberOfSongsSelected = 0;
    


    public PlayListsManager(DataBasePlaylists dataBasePlaylists) {
        EngineSearcher finder = new EngineSearcher();
        userSet = finder.searchUserSet(user, dataBasePlaylists);
        userSetDimension = userSet==null ? 0 : userSet.getSize();
        this.dataBasePlaylists = dataBasePlaylists;
    }
    
    public PlaylistSet getUserSet(){
        return userSet;
    }
    
    public void registraPlaylist(){
        if(songsToAdd.length == 0){
            //avviso che non si possono creare playlists vuote
            return;
        }
        Playlist newPlaylist = new Playlist(nameNewPlaylist, songsToAdd);
        userSet = dataBasePlaylists.getUserSet(user);
        if(userSet == null){
            userSet = new PlaylistSet(user.getUserId(), newPlaylist);
            userSet.addPlaylist(newPlaylist);
            dataBasePlaylists.add(userSet);
            
        } else {
            userSet.addPlaylist(newPlaylist);
        }
        dataBasePlaylists.save();    
    }
    
    public void showUserPlaylistsSet(){
        playlistPanel = buildUserPlaylistsPanel();
        EMOTIONALSONGS.mainWindow.setMainPanel(playlistPanel);
    }

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

    public boolean containInSongsToAdd(Song song) {
        if(songsToAdd.length == 0) return false;
        EngineChecker checker = new EngineChecker();
        return checker.checkIfContains(songsToAdd,song.getTag());    
    }

    public int getNumberOfSongToAdd() {
        return numberOfSongsSelected;
    }
    
    public Song getSongToAdd(int index){
        return songsToAdd[index];
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

    public Song[] getSongsToAdd() {
        return songsToAdd;
    }
    
    private PlaylistsMainPanel buildUserPlaylistsPanel(){
       return new PlaylistsMainPanel(EMOTIONALSONGS.loggedUser,this);
    }
    
    public void openCreationFrame(){
        creationFrame = new PlaylistCreationFrame();
        creationFrame.setVisible(true);
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
        playlistPanel = new PlaylistsMainPanel(user, this);
        EMOTIONALSONGS.mainWindow.cleanUpMainPanel();
        EMOTIONALSONGS.mainWindow.setMainPanel(playlistPanel);
        EMOTIONALSONGS.mainWindow.revalidate();
        EMOTIONALSONGS.mainWindow.repaint();
    }
    
    public void addSongToPlaylist(Song songToAdd,Playlist playlistWhereToAddSong){
        //da implementare insieme a GUI per aggiungere una canzone alla playlist.
    }
    
    public void deleteAsongFromAPlaylist(Song songToDelete){
        selectedPlaylist.removeSong(songToDelete);
        dataBasePlaylists.save();
        setRightPane(new PlaylistSongsViewPanel(selectedPlaylist));
    }
    
    public void deletePlaylistFromSet(Playlist playlistToDelete){
        userSet.deletePlaylist(playlistToDelete);
        dataBasePlaylists.updateSet(user, userSet);
        updatePlaylistsPanel();
    }
    
    public void setSelectedPlaylist(Playlist selectedPlaylist){
        this.selectedPlaylist = selectedPlaylist;
    }
    
}

