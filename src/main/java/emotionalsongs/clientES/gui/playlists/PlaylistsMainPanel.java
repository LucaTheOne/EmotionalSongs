/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.clientES.gui.playlists;

import emotionalsongs.*;
import emotionalsongs.clientES.*;
import emotionalsongs.clientES.client_internal_services.*;
import emotionalsongs.clientES.wrappers.*;
import java.awt.*;
import java.rmi.*;
import serverES.server_services_common_interfaces.data_handler.*;

/**
 * Classe le cui istanze sono pannelli per la visulizzazione di pulsanti delle playlist ed il loro contenuto.
 */
public class PlaylistsMainPanel extends javax.swing.JPanel {

    private final String userId;
    private final PlaylistsDataHandler playlistsDataHandler;
    private final PlaylistsManager playlistsManager = PlaylistsManager.getInstance();
    private String[] playlistsData;
    private final String SEP = ClientUtilities.STRING_SEPARATOR;
    
    
    /**
     * Crea il form generale per l'ispezione del PlaylistSet dell'utente passato come argomento e delle 
     * canzoni contenute nelle playlist.
     * In questo form ci sono pulsanti che permettono di:
     * <ul>
     * <li> esprimere giudizi emozionali per ogni canzone di ogni playlist del utente</li>
     * <li> aprire il report dei giudizi per ogni canzone </li>
     * <li> ricercare le canzoni su youtube</li>
     * <li> creare una nuova playlist</li>
     * </ul>
     */
    public PlaylistsMainPanel(String userId) {
        this.userId = userId;
        playlistsDataHandler = (PlaylistsDataHandler) ServicesProvider.getInstance().getService(ServicesProvider.PLAYLISTS_DATA_HANDLER);
        try {
            playlistsData = playlistsDataHandler.requestPlaylistsUser(userId);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
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
        innerPanelLeft.setPreferredSize(new Dimension(viewPlaylistScroll.getWidth(),(60*playlistsData.length)+240));
        innerPanelLeft.setLayout(new java.awt.GridLayout(playlistsData.length<15? 15 : playlistsData.length, 1, 5, 5));
        if(playlistsData.length != 0){
            for(int i = 0; i<playlistsData.length;i++){
                String playlistId = playlistsData[i].split("£SEP£")[0];
                String playlistName = playlistsData[i].split("£SEP£")[2];
                innerPanelLeft.add(Playlist.buildPlaylistButton(playlistName, playlistId), playlistsManager);
            }
        }
        viewPlaylistSetPanel.setViewportView(innerPanelLeft);

        leftPanel.add(viewPlaylistSetPanel, java.awt.BorderLayout.CENTER);

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));
        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204)));
        buttonPanel.setPreferredSize(new java.awt.Dimension(100, 30));
        buttonPanel.setLayout(new java.awt.BorderLayout());

        newPlaylistButton.setBackground(new java.awt.Color(239, 239, 239));
        newPlaylistButton.setText(EmotionalSongs.dialoghi.creaNuovaPlaylistButton());
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
        innerPanelRight.setLayout(new java.awt.BorderLayout());
        viewPlaylistScroll.setViewportView(innerPanelRight);

        add(viewPlaylistScroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void newPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlaylistButtonActionPerformed
        playlistsManager.startCreation();
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

    public void setLeftInnerPanel(String[] userPlaylistsData) {
        innerPanelLeft.removeAll();
        for(int i = 0; i<userPlaylistsData.length;i++){
            String[] lineData = userPlaylistsData[i].split(SEP);
            innerPanelLeft.add(new PlaylistButton(lineData[0], lineData[2]));
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
