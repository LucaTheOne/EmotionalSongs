//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.gui.playlists;

import emotionalsongs.basic_structures.*;
import emotionalsongs.managers.*;
import java.awt.*;

/**
 *Classe le cui istanze sono pannelli per la visulizzazione di pulsanti delle playlist ed il loro contenuto.
 */
public class PlaylistsMainPanel extends javax.swing.JPanel {

    PlaylistsSet userSet;
    PlaylistsManager playListsManager = PlaylistsManager.getInstance();
    
    
    /**
     * Crea il form generale per l' ispezione del playlist set dell' utente passato come argomento e delle 
     * canzoni contenute nelle playlist.
     * In questo form ci sono pulsanti che permettono:
     * <ul>
     * <li> Esprimere giudizi emozionali per ogni canzone di ogni playlist del utente</li>
     * <li> Aprire il report dei giudizi per ogni canzone </li>
     * <li> Ricercare le canzoni su youtube</li>
     * <li> Creare una nuova playlist</li>
     * </ul>
     */
    public PlaylistsMainPanel(PlaylistsSet userSet) {
        this.userSet = playListsManager.getUserSet();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        viewPlaylistSetPanel = new javax.swing.JScrollPane();
        innerPanelLeft = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        newPlaylistButton = new javax.swing.JButton();
        viewPlaylistScroll = new javax.swing.JScrollPane();
        innerPanelRight = new javax.swing.JPanel();

        setBackground(new java.awt.Color(22,33,62,160));
        setLayout(new java.awt.BorderLayout());

        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(300, 300));
        leftPanel.setLayout(new java.awt.BorderLayout());

        viewPlaylistSetPanel.setBackground(new java.awt.Color(22,33,62,160));
        viewPlaylistSetPanel.setOpaque(false);

        innerPanelLeft.setBackground(new java.awt.Color(22, 33, 62));
        innerPanelLeft.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(51, 153, 255), new java.awt.Color(0, 0, 102), new java.awt.Color(0, 0, 153)));
        innerPanelLeft.setPreferredSize(new Dimension(viewPlaylistScroll.getWidth(),(60*playListsManager.getNumberOfPlaylists())+240));
        innerPanelLeft.setLayout(new java.awt.GridLayout(playListsManager.getNumberOfPlaylists()<15? 15 : playListsManager.getNumberOfPlaylists(), 1, 5, 5));
        if(userSet != null){
            for(int i = 0; i<userSet.getSize();i++){
                innerPanelLeft.add(userSet.getPlaylist(i).buildPlaylistButton(), playListsManager);
            }
        }
        viewPlaylistSetPanel.setViewportView(innerPanelLeft);

        leftPanel.add(viewPlaylistSetPanel, java.awt.BorderLayout.CENTER);

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)));
        buttonPanel.setPreferredSize(new java.awt.Dimension(100, 30));
        buttonPanel.setLayout(new java.awt.BorderLayout());

        newPlaylistButton.setBackground(new java.awt.Color(239, 239, 239));
        newPlaylistButton.setText(emotionalsongs.EmotionalSongs.dialoghi.creaNuovaPlaylistpiu());
        newPlaylistButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        newPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlaylistButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(newPlaylistButton, java.awt.BorderLayout.CENTER);

        leftPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        add(leftPanel, java.awt.BorderLayout.LINE_START);

        viewPlaylistScroll.setOpaque(false);

        innerPanelRight.setBackground(new java.awt.Color(22, 33, 62));
        innerPanelRight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(51, 51, 255), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 51), new java.awt.Color(0, 0, 102)));
        innerPanelRight.setPreferredSize(new java.awt.Dimension(viewPlaylistScroll.getWidth()<720 ? 720 : viewPlaylistScroll.getWidth(),viewPlaylistScroll.getHeight()<75*playListsManager.getNumberOfSongOfSelectedPlaylist()?75*playListsManager.getNumberOfSongOfSelectedPlaylist():viewPlaylistScroll.getHeight()));
        innerPanelRight.setLayout(new java.awt.BorderLayout());
        viewPlaylistScroll.setViewportView(innerPanelRight);

        add(viewPlaylistScroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void newPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlaylistButtonActionPerformed
        playListsManager.startCreation();
    }//GEN-LAST:event_newPlaylistButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel innerPanelLeft;
    private javax.swing.JPanel innerPanelRight;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton newPlaylistButton;
    private javax.swing.JScrollPane viewPlaylistScroll;
    private javax.swing.JScrollPane viewPlaylistSetPanel;
    // End of variables declaration//GEN-END:variables

    public void setLeftInnerPanel(PlaylistsSet userSet) {
        innerPanelLeft.removeAll();
        for(int i = 0; i<userSet.getSize();i++){
            innerPanelLeft.add(new PlaylistButton(userSet.getArray()[i]));
        }
        innerPanelLeft.revalidate();
        innerPanelLeft.repaint();
    }
    
    public void redrawRightPanel(PlaylistSongsViewPanel viewPanel){
        innerPanelRight.removeAll();
        innerPanelRight.add(viewPanel);
        innerPanelRight.revalidate();
        innerPanelRight.repaint();
    }

    public void addToLeftPanel(PlaylistButton playlistButton) {
        innerPanelLeft.add(playlistButton);
        innerPanelLeft.revalidate();
        innerPanelLeft.repaint();
    }
}
