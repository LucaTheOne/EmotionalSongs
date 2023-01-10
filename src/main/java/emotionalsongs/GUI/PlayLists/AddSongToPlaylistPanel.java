
package emotionalsongs.GUI.PlayLists;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Managers.*;

/**
 *
 * @author big
 */
public class AddSongToPlaylistPanel extends javax.swing.JPanel {
    
    Song song;
    PlayListsManager playListsManager = PlayListsManager.getInstance();
    
    /**
     * Creates new form GUIbranoViewPanel
     */
    public AddSongToPlaylistPanel(Song brano,PlayListsManager playListsManager) {
        //this.playListsManager = playListsManager;
        this.song = brano;
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

        buttonsPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        labelsPanel = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        authorLabel1 = new javax.swing.JLabel();
        yearLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 24, 46));
        setMinimumSize(new java.awt.Dimension(720, 30));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 30));
        setLayout(new java.awt.BorderLayout());

        buttonsPanel.setBackground(new java.awt.Color(5, 23, 44));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(120, 100));
        buttonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        addButton.setText("+");
        addButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        addButton.setEnabled(!playListsManager.containInSongsToAdd(song));
        addButton.setOpaque(true);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(addButton);

        removeButton.setBackground(new java.awt.Color(204, 0, 51));
        removeButton.setText("-");
        removeButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 51), new java.awt.Color(255, 102, 102), new java.awt.Color(153, 51, 0), new java.awt.Color(153, 51, 0)));
        removeButton.setEnabled(playListsManager.containInSongsToAdd(song));
        removeButton.setOpaque(true);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(removeButton);

        add(buttonsPanel, java.awt.BorderLayout.LINE_END);

        labelsPanel.setBackground(new java.awt.Color(255, 255, 255));
        labelsPanel.setLayout(new java.awt.GridLayout(1, 0));

        titleLabel1.setBackground(new java.awt.Color(5, 23, 44));
        titleLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel1.setText(song.getTitle());
        titleLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        titleLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel1.setOpaque(true);
        titleLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        labelsPanel.add(titleLabel1);

        authorLabel1.setBackground(new java.awt.Color(5, 23, 44));
        authorLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        authorLabel1.setForeground(new java.awt.Color(255, 255, 255));
        authorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel1.setText(song.getAuthor());
        authorLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        authorLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        authorLabel1.setOpaque(true);
        authorLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        labelsPanel.add(authorLabel1);

        yearLabel1.setBackground(new java.awt.Color(5, 23, 44));
        yearLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        yearLabel1.setForeground(new java.awt.Color(255, 255, 255));
        yearLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearLabel1.setText(String.valueOf(song.getYear()));
        yearLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        yearLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        yearLabel1.setOpaque(true);
        yearLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        labelsPanel.add(yearLabel1);

        add(labelsPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        playListsManager.addToSelectedSongs(song);
        removeButton.setEnabled(true);
        addButton.setEnabled(false);
        playListsManager.increaseNumberOfSongToAdd();
        playListsManager.updateSongSelectedLabel();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        playListsManager.removeToSelectedSongs(song);
        removeButton.setEnabled(false);
        addButton.setEnabled(true);
        playListsManager.decreaseNumberOfSongToAdd();
        playListsManager.updateSongSelectedLabel();
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel authorLabel1;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel labelsPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel yearLabel1;
    // End of variables declaration//GEN-END:variables
}
