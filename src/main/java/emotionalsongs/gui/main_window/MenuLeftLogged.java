//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.gui.main_window;

import emotionalsongs.gui.repository.*;
import emotionalsongs.managers.*;
import java.io.*;

/**
 * Classi le cui istanze sono il pannello laterale della schermata principale del software, quando un utente ha efettuato il login.
 * Contiene:
 * <ul>
 * <li> Il pulsante per ispezionare il repository </li>
 * <li> Il pulsante per ispezionare le playlist dell' utente</li>
 * <li> il pulsante per iniziare la creazione di una nuova playlist</li>
 * <li> Il pulsante di chiusura del software </li>
 * <ul>
 */
public class MenuLeftLogged extends javax.swing.JPanel {
    
    MainFrame mainPage;

    /** Crea il menu sinistro della schermata principale del software, passata come argomento, quando un utente è loggato. */
    public MenuLeftLogged(MainFrame correlated) {
        mainPage = correlated;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        PlayListButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        leftSpaceVoidPanel = new javax.swing.JPanel();
        rightSpaceVoidPanel = new javax.swing.JPanel();
        upperSpaceVoidPanel = new javax.swing.JPanel();
        closeButtonPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(22,33,62, 160));
        setPreferredSize(new java.awt.Dimension(200, 600));
        setLayout(new java.awt.BorderLayout(0, 5));

        buttonsPanel.setBackground(new java.awt.Color(0, 0, 0,45));
        buttonsPanel.setOpaque(false);
        buttonsPanel.setPreferredSize(new java.awt.Dimension(120, 300));
        buttonsPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 300));
        jPanel2.setLayout(new java.awt.GridLayout(6, 1, 5, 5));

        jButton3.setBackground(new java.awt.Color(15, 52, 96));
        jButton3.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Repository");
        jButton3.setToolTipText("");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        PlayListButton.setBackground(new java.awt.Color(15, 52, 96));
        PlayListButton.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        PlayListButton.setForeground(new java.awt.Color(255, 255, 255));
        PlayListButton.setText("PlayList Utente");
        PlayListButton.setToolTipText("");
        PlayListButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        PlayListButton.setOpaque(true);
        PlayListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayListButtonActionPerformed(evt);
            }
        });
        jPanel2.add(PlayListButton);

        jButton4.setBackground(new java.awt.Color(15, 52, 96));
        jButton4.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Crea Nuova Playlist");
        jButton4.setToolTipText("");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        buttonsPanel.add(jPanel2, java.awt.BorderLayout.NORTH);

        add(buttonsPanel, java.awt.BorderLayout.CENTER);

        leftSpaceVoidPanel.setOpaque(false);
        add(leftSpaceVoidPanel, java.awt.BorderLayout.WEST);

        rightSpaceVoidPanel.setOpaque(false);
        add(rightSpaceVoidPanel, java.awt.BorderLayout.EAST);

        upperSpaceVoidPanel.setOpaque(false);
        upperSpaceVoidPanel.setPreferredSize(new java.awt.Dimension(10, 5));
        add(upperSpaceVoidPanel, java.awt.BorderLayout.NORTH);

        closeButtonPanel.setOpaque(false);
        closeButtonPanel.setPreferredSize(new java.awt.Dimension(10, 60));
        closeButtonPanel.setLayout(new java.awt.GridBagLayout());

        closeButton.setBackground(new java.awt.Color(255, 0, 51));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("Esci");
        closeButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, javax.swing.UIManager.getDefaults().getColor("Objects.Red"), javax.swing.UIManager.getDefaults().getColor("Component.custom.borderColor"), new java.awt.Color(102, 0, 0), new java.awt.Color(153, 0, 0)));
        closeButton.setOpaque(true);
        closeButton.setPreferredSize(new java.awt.Dimension(160, 50));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        closeButtonPanel.add(closeButton, new java.awt.GridBagConstraints());

        add(closeButtonPanel, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        mainPage.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            mainPage.setMainPanel(new RepositoryPanel());
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void PlayListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayListButtonActionPerformed
        PlaylistsManager.getInstance().updatePlaylistsPanel();
    }//GEN-LAST:event_PlayListButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        PlaylistsManager.getInstance().startCreation();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PlayListButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel closeButtonPanel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel leftSpaceVoidPanel;
    private javax.swing.JPanel rightSpaceVoidPanel;
    private javax.swing.JPanel upperSpaceVoidPanel;
    // End of variables declaration//GEN-END:variables

}
