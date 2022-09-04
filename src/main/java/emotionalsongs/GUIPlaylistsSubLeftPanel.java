
package emotionalsongs;

import java.awt.*;

/**
 *
 * @author big
 */
public class GUIPlaylistsSubLeftPanel extends javax.swing.JPanel {
    
    private PlaylistSet userSet;
    private int numberOfButtons;
    PlayListsManager playlistManager = EMOTIONALSONGS.playListsManager;
    /**
     * Creates new form GUIPlaylistsButtons
     */
    public GUIPlaylistsSubLeftPanel(PlaylistSet userSet,PlayListsManager playListsManager) {
        
        this.userSet = userSet;
        if(userSet != null){
            numberOfButtons = this.userSet.getSize();
        } else {
            numberOfButtons = 0;
        }
       
        initComponents();
        for(int i = 0;i<numberOfButtons;i++){
            PlaylistsPanel.add(new GUIPlaylistButton(userSet.getPlaylist(i), playListsManager));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPane = new javax.swing.JPanel();
        newPlaylistButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PlaylistsPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        buttonPane.setOpaque(false);
        buttonPane.setPreferredSize(new java.awt.Dimension(300, 40));
        buttonPane.setLayout(new java.awt.BorderLayout());

        newPlaylistButton.setText("+");
        newPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlaylistButtonActionPerformed(evt);
            }
        });
        buttonPane.add(newPlaylistButton, java.awt.BorderLayout.CENTER);

        add(buttonPane, java.awt.BorderLayout.SOUTH);

        PlaylistsPanel.setPreferredSize(new Dimension(jScrollPane1.getWidth(),jScrollPane1.getHeight()> 60*numberOfButtons?jScrollPane1.getHeight():70*numberOfButtons));
        PlaylistsPanel.setLayout(new java.awt.GridLayout(numberOfButtons, 1, 0, 5));
        jScrollPane1.setViewportView(PlaylistsPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void newPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlaylistButtonActionPerformed
        GUIPlaylistCreationFrame f = new GUIPlaylistCreationFrame();
        f.run();
    }//GEN-LAST:event_newPlaylistButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PlaylistsPanel;
    private javax.swing.JPanel buttonPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newPlaylistButton;
    // End of variables declaration//GEN-END:variables
}
