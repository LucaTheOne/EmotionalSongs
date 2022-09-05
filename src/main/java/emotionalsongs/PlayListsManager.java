
package emotionalsongs;

/**
 *
 * @author big
 */
class PlayListsManager {
    
    GUIPlaylistsMainPanel playlistPanel ;
    GUIPlaylistCreationFrame creationFrame;
    final DataBasePlaylists dataBasePlaylists;
        
    User user = EMOTIONALSONGS.loggedUser;
    
    PlaylistSet userSet;
    int userSetDimension;
    
    Playlist selectedOne;
    int numberOfSongSelectedPlaylist;
    private String nameNewPlaylist = "";
    
    private Song[] songsToAdd = new Song[0];
    private int numberOfSongsSelected = 0;
    


    PlayListsManager(DataBasePlaylists dataBasePlaylists) {
        EngineSearcher finder = new EngineSearcher();
        userSet = finder.searchUserSet(user, dataBasePlaylists);
        userSetDimension = userSet==null ? 0 : userSet.getSize();
        this.dataBasePlaylists = dataBasePlaylists;
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
            dataBasePlaylists.add(userSet);
        } else {
            userSet.add(newPlaylist);
        }
        dataBasePlaylists.save();    
    }
    
    void showUserPlaylistsSet(){
        buildUserPlaylistsPanel();
        EMOTIONALSONGS.mainWindow.setMainPanel(playlistPanel);
    }

    void addToSelectedSongs(Song song) {
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

    void removeToSelectedSongs(Song song) {
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

    boolean containInSongsToAdd(Song song) {
        if(songsToAdd.length == 0) return false;
        EngineChecker checker = new EngineChecker();
        return checker.checkIfContains(songsToAdd,song.getTag());    
    }

    int getNumberOfSongToAdd() {
        return numberOfSongsSelected;
    }
    
    Song getSongToAdd(int index){
        return songsToAdd[index];
    }
    
    void eraseSongToAdd(){
        songsToAdd = new Song[0];
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

    Song[] getSongsToAdd() {
        return songsToAdd;
    }
    
    private void buildUserPlaylistsPanel(){
       playlistPanel = new GUIPlaylistsMainPanel(EMOTIONALSONGS.loggedUser,this);
    }
    
    void openCreationFrame(){
        creationFrame = new GUIPlaylistCreationFrame();
        creationFrame.setVisible(true);
    }
    
    void updateSongSelectedLabel(){
        creationFrame.numberSelectedSongLabel.setText(numberOfSongsSelected+" brani selezionati");
        creationFrame.revalidate();
        creationFrame.repaint();
    }
    
    void increaseNumberOfSongToAdd(){
        numberOfSongsSelected++;
    }
    
    void decreaseNumberOfSongToAdd(){
        numberOfSongsSelected--;
    }
    
    void eraseNumberOfSongsToAdd(){
        numberOfSongsSelected = 0;
    }
}

