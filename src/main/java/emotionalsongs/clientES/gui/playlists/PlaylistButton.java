/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.clientES.gui.playlists;

import emotionalsongs.clientES.wrappers.Playlist;
import emotionalsongs.clientES.client_internal_services.PlaylistsManager;
import emotionalsongs.clientES.client_internal_services.ClientUtilities;
import emotionalsongs.clientES.ServicesProvider;
import java.rmi.*;
import serverES.server_services_common_interfaces.data_handler.*;

/**
 * Classe le cui istanze rappresentano i bottoni di ispezione delle playlist passate come argomenti al
 * costruttore.
 */
public class PlaylistButton extends javax.swing.JPanel {

    /**
     * Crea il bottone con il nome della playlist passata come argomento che, qualora premuto, ne
     * mostra nella schermata principale del pannello di visualizzazione delle playlist il contenuto.
     */
    private final String playlistName;
    private final String playlistId;
    private final PlaylistsDataHandler PLAYLISTS_DATA_HANDLER;
    private final SongsDataHandler SONGS_DATA_HANDLER;
    private final PlaylistsManager playListsManager = PlaylistsManager.getInstance();
    private final String SEP = ClientUtilities.STRING_SEPARATOR;
    
    /**
     * Metodo costruttore della classe.
     * Crea l'istanza e inserisce nei campi i nomi e ID della playlist
     * @param playlistName: nome della playlist
     * @param playlistId: ID della playlist
     */
    public PlaylistButton(String playlistName, String playlistId) {
        this.playlistName = playlistName;
        this.playlistId = playlistId;
        PLAYLISTS_DATA_HANDLER = (PlaylistsDataHandler) ServicesProvider.getInstance().getService(ServicesProvider.PLAYLISTS_DATA_HANDLER);
        SONGS_DATA_HANDLER = (SongsDataHandler) ServicesProvider.getInstance().getService(ServicesProvider.SONGS_DATA_HANDLER);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playListButton = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(300, 60));
        setLayout(new java.awt.BorderLayout());

        playListButton.setBackground(new java.awt.Color(56, 98, 139));
        playListButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        playListButton.setForeground(new java.awt.Color(255, 255, 255));
        playListButton.setText(playlistName);
        playListButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.darkGray, java.awt.Color.gray));
        playListButton.setOpaque(true);
        playListButton.setPreferredSize(new java.awt.Dimension(280, 60));
        playListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playListButtonActionPerformed(evt);
            }
        });
        add(playListButton, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void playListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playListButtonActionPerformed
        try {
            String[] research = PLAYLISTS_DATA_HANDLER.requestPlaylistSongs(playlistId);
            String[] songsData = new String[research.length];
            for(int i = 0; i<songsData.length;i++) songsData[i] = SONGS_DATA_HANDLER.requestSongData(research[i].split(SEP)[1]);
            playListsManager.setRightPane(Playlist.buildPlaylistContentsView(songsData));
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_playListButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton playListButton;
    // End of variables declaration//GEN-END:variables
}
