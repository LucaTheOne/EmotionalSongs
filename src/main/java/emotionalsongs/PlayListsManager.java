
package emotionalsongs;

/**
 *
 * @author big
 */
class PlayListsManager {
    GUIPlaylistsMainPanel mainPanel = new GUIPlaylistsMainPanel(EMOTIONALSONGS.loggedUser,this);
    GUIPlaylistsSubLeftPanel leftPanel;
    GUIPlaylistsSubRightPanel rightPanel;
    User user = EMOTIONALSONGS.loggedUser;
    
    final DataBasePlaylists dataBasePlaylists;
    Song[] songToAdd = new Song[0];
    private String nameNewPlaylist = "";

    PlayListsManager(DataBasePlaylists dataBasePlaylists) {
        mainPanel = new GUIPlaylistsMainPanel(EMOTIONALSONGS.loggedUser,this);
        setLeftPanel(new GUIPlaylistsSubLeftPanel(user.getPlaylistSet(), this));
        this.dataBasePlaylists = dataBasePlaylists;
    }
    
    public void registraPlaylist(){
        if(songToAdd.length == 0){
            //avviso che non si possono creare playlists vuote
            return;
        }
        Playlist newPlaylist = new Playlist(nameNewPlaylist, songToAdd);
        PlaylistSet userSet = dataBasePlaylists.getUserSet(user);
        if(userSet == null){
            userSet = new PlaylistSet(nameNewPlaylist, newPlaylist);
            dataBasePlaylists.add(userSet);
            return;
        }
        userSet.add(newPlaylist);
        dataBasePlaylists.save();
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    void setLeftPanel(GUIPlaylistsSubLeftPanel left){
        mainPanel.setLeftPanel(left);
    }
    
    void setRightPanel(GUIPlaylistsSubRightPanel guiPlaylistSubRightPanel) {
        mainPanel.setRightPanel(guiPlaylistSubRightPanel);
    }
    
    void showUserPlaylistsSet(){
        EMOTIONALSONGS.mainWindow.setMainPanel(mainPanel);
    }

    void addToSelectedSongs(Song song) {
        Song[] newOne = new Song[songToAdd.length+1];
        for (int i = 0; i < songToAdd.length; i++) {
            newOne[i] = songToAdd[i];
        }
        newOne[newOne.length-1] = song;
    }

    void removeToSelectedSongs(Song song) {
        Song[] newOne = new Song[songToAdd.length-1];
        int indexCounter = 0;
        for(int i = 0;i<songToAdd.length;i++){
            if(!songToAdd[i].equalsTo(song)){
                newOne[indexCounter++] = songToAdd[i];
            }
        }
    }

    boolean containInSongsToAdd(Song song) {
        if(songToAdd.length == 0) return false;
        EngineChecker checker = new EngineChecker();
        return checker.checkIfContains(songToAdd,song.getTag());    
    }

    int getNumberOfSongToAdd() {
        return songToAdd.length;
    }
    
    Song getSongToAdd(int index){
        return songToAdd[index];
    }
    
    void eraseSongToAdd(){
        songToAdd = new Song[0];
    }

    void eraseTitlePlaylist() {
        nameNewPlaylist = "";
    }

    void setTitlePlaylist(String title) {
        nameNewPlaylist = title;
    }
    
    void updateUser(User user){
        this.user = user;
    }
}
