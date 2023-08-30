/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.gui.playlists;

import emotionalsongs.clientES.wrappers.Song;
import emotionalsongs.*;
import java.awt.*;

/**
 * Classe le cui istanze sono pannelli il cui compito è quello di fare da contenitore per
 * istanze di SongPanel.
 */
public class PlaylistSongsViewPanel extends javax.swing.JPanel {

    private String[] songsData;
    
    /**
     * Crea il contenitore che mostra le rappresentazioni grafiche delle canzoni di una playlist
     * passata come argomento.
     * @param playlistContents Playlist di cui mostrare le canzoni.
     */
    public PlaylistSongsViewPanel(String[] playlistContents) {
        songsData = playlistContents;
        if(playlistContents.length<1|| playlistContents == null) {
            System.out.println("Error: invalid playlists");
            return;
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanelScroll = new javax.swing.JScrollPane();
        mainPanelContainer = new javax.swing.JPanel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 800));
        setLayout(new java.awt.BorderLayout());

        mainPanelContainer.setBackground(new java.awt.Color(22, 33, 62));
        mainPanelContainer.setPreferredSize(new Dimension(mainPanelScroll.getWidth(),songsData.length>7?75*songsData.length:7*75));
        for(int i = 0; i<songsData.length;i++){
            mainPanelContainer.add(Song.buildPanelForPlaylist(songsData[i],EmotionalSongs.getLoggedUser()));
        }
        mainPanelContainer.setLayout(new java.awt.GridLayout(songsData.length>7?songsData.length:7, 1));
        mainPanelScroll.setViewportView(mainPanelContainer);

        add(mainPanelScroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanelContainer;
    private javax.swing.JScrollPane mainPanelScroll;
    // End of variables declaration//GEN-END:variables
}
