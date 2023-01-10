
package emotionalsongs.GUI.PlayLists;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Managers.*;

/**
 *
 * @author big
 */
public class PlaylistButton extends javax.swing.JPanel {

    /**
     * Creates new form PlaylistButton
     */
    Playlist correlatedPlaylist;
    PlaylistSet originSet;
    PlayListsManager playListsManager = PlayListsManager.getInstance();
    public PlaylistButton(Playlist playlist,PlayListsManager playListsManager) {
        correlatedPlaylist = playlist;
        this.originSet = EMOTIONALSONGS.userPlaylistSet;
        //this.playListsManager = playListsManager;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        playListButton.setText(correlatedPlaylist.getName());
        playListButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), java.awt.Color.darkGray, java.awt.Color.gray));
        playListButton.setOpaque(true);
        playListButton.setPreferredSize(new java.awt.Dimension(300, 60));
        playListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playListButtonActionPerformed(evt);
            }
        });
        add(playListButton, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void playListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playListButtonActionPerformed
        playListsManager.setRightPane(correlatedPlaylist.buildPlaylistView());
        playListsManager.setSelectedPlaylist(correlatedPlaylist);
    }//GEN-LAST:event_playListButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton playListButton;
    // End of variables declaration//GEN-END:variables
}
