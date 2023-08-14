/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.gui.playlists;

import clientES.*;
import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import java.awt.*;
import java.rmi.*;
import serverES.services_common_interfaces.data_handler.*;

/**
 * Classe le cui istanze sono pannelli il cui compito è quello di fare da contenitore per
 * istanze di SongPanel.
 */
public class PlaylistSongsViewPanel extends javax.swing.JPanel {

    
    private String[] songsIds;
    /**
     * Crea il contenitore che mostra le rappresentazioni grafiche delle canzoni di una playlist
     * passata come argomento.
     * @param playList Playlist di cui mostrare le canzoni.
     */
    public PlaylistSongsViewPanel(String[] songsIds) {
        this.songsIds = songsIds;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 800));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(22, 33, 62));
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getWidth(),songsIds.length>7?75*songsIds.length:7*75));
        SongsDataHandler sdh = (SongsDataHandler) ServicesProvider.getInstance().getService(ServicesProvider.SONGS_DATA_HANDLER);
        for(int i = 0; i<songsIds.length;i++){
            try{
                String songData = sdh.requestSongData(songsIds[i]);
                jPanel1.add(Song.buildPanelForPlaylist(songData,EmotionalSongs.getLoggedUser()));
            } catch (RemoteException ex){
                System.out.println(ex.getMessage());
            }
        }
        jPanel1.setLayout(new java.awt.GridLayout(songsIds.length>7?songsIds.length:7, 1));
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
