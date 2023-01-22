//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.GUI.PlayLists;

import emotionalsongs.basic_structures.*;
import java.awt.*;

/**
 * Classe le cui istanze sono pannelli il cui compito è quello di fare da contenitore per
 * istanze di SongPanel.
 */
public class PlaylistSongsViewPanel extends javax.swing.JPanel {

    
    private Playlist playlist;
    /**
     * Crea il contenitore che mostra le rappresentazioni grafiche delle canzoni di una playlist
     * passata come argomento.
     * @param playList Playlist di cui mostrare le canzoni.
     */
    public PlaylistSongsViewPanel(Playlist playList) {
        this.playlist = playList;
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
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getWidth(),playlist.getSize()>7?75*playlist.getSize():7*75));
        for(int i = 0; i<playlist.getSize();i++){
            jPanel1.add(playlist.getArraySongs()[i].buildPanelForPlaylist(playlist));
        }
        jPanel1.setLayout(new java.awt.GridLayout(playlist.getSize()>7?playlist.getSize():7, 1));
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
