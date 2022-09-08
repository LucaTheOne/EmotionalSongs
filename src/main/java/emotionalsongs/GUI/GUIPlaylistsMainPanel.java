
package emotionalsongs.GUI;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.*;
import emotionalsongs.Engines.*;
import emotionalsongs.Managers.*;
import java.awt.*;

/**
 *
 * @author big
 */
public class GUIPlaylistsMainPanel extends javax.swing.JPanel {

    /**
     * Creates new form GUIPlaylistsMainPanel
     */
    
    User user;
    PlaylistSet userSet;
    PlayListsManager playListsManager = EMOTIONALSONGS.playListsManager;
    public GUIPlaylistsMainPanel(User user,PlayListsManager playListsManager) {
        EngineSearcher searcher = new EngineSearcher();
        this.user = user;
        initComponents();
        //this.playListsManager = playListsManager;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        createNewPlaylistButton = new javax.swing.JButton();
        viewPlaylistSetPanel = new javax.swing.JScrollPane();
        innerPanelLeft = new javax.swing.JPanel();
        viewPlaylistScroll = new javax.swing.JScrollPane();
        innerPanelRight = new javax.swing.JPanel();

        setBackground(new java.awt.Color(22,33,62,160));
        setLayout(new java.awt.BorderLayout());

        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(200, 300));
        leftPanel.setLayout(new java.awt.BorderLayout());

        createNewPlaylistButton.setText("Crea nuova playlist");
        createNewPlaylistButton.setPreferredSize(new java.awt.Dimension(78, 30));
        createNewPlaylistButton.setSize(new java.awt.Dimension(78, 30));
        createNewPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewPlaylistButtonActionPerformed(evt);
            }
        });
        leftPanel.add(createNewPlaylistButton, java.awt.BorderLayout.PAGE_END);

        viewPlaylistSetPanel.setBackground(new java.awt.Color(22,33,62,160));
        viewPlaylistSetPanel.setOpaque(false);

        innerPanelLeft.setOpaque(false);
        innerPanelLeft.setPreferredSize(new Dimension(viewPlaylistScroll.getWidth(),50*playListsManager.getNumberOfPlaylists()));
        innerPanelLeft.setLayout(new java.awt.GridLayout(playListsManager.getNumberOfPlaylists()<20 ? 20 : playListsManager.getNumberOfPlaylists(), 1, 0, 5));
        for(int i = 0; i<playListsManager.getNumberOfPlaylists();i++){
            innerPanelLeft.add(new GUIPlaylistButton(playListsManager.getUserSet().getPlaylist(i), playListsManager));
        }
        viewPlaylistSetPanel.setViewportView(innerPanelLeft);

        leftPanel.add(viewPlaylistSetPanel, java.awt.BorderLayout.CENTER);

        add(leftPanel, java.awt.BorderLayout.LINE_START);

        viewPlaylistScroll.setOpaque(false);

        innerPanelRight.setOpaque(false);
        innerPanelRight.setPreferredSize(new java.awt.Dimension(viewPlaylistScroll.getWidth(),viewPlaylistScroll.getHeight()<75*playListsManager.getNumberOfSongOfSelectedPlaylist()?75*playListsManager.getNumberOfSongOfSelectedPlaylist():viewPlaylistScroll.getHeight()));
        viewPlaylistScroll.setViewportView(innerPanelRight);

        add(viewPlaylistScroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void createNewPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewPlaylistButtonActionPerformed
        playListsManager.openCreationFrame();
    }//GEN-LAST:event_createNewPlaylistButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewPlaylistButton;
    private javax.swing.JPanel innerPanelLeft;
    private javax.swing.JPanel innerPanelRight;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JScrollPane viewPlaylistScroll;
    private javax.swing.JScrollPane viewPlaylistSetPanel;
    // End of variables declaration//GEN-END:variables

    public void setLeftInnerPanel(PlaylistSet userSet) {
        for(int i = 0; i<userSet.getSize();i++){
            innerPanelLeft.add(new GUIPlaylistButton(userSet.getArray()[i],playListsManager));
        }
        innerPanelLeft.revalidate();
        innerPanelLeft.repaint();
    }
}