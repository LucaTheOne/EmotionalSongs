/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.gui.main_window;

import emotionalsongs.*;
import emotionalsongs.clientES.client_internal_services.*;
import emotionalsongs.clientES.gui.repository.*;
import java.io.*;

/**
 * Classi le cui istanze sono il pannello laterale della schermata principale del software, quando un utente ha efettuato il login.
 * Contiene:
 * <ul>
 * <li> Il pulsante per ispezionare il repository </li>
 * <li> Il pulsante per ispezionare le playlist dell' utente</li>
 * <li> il pulsante per iniziare la creazione di una nuova playlist</li>
 * <li> Il pulsante di chiusura del software </li>
 * </ul>
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
        repoButton = new javax.swing.JButton();
        PlayListButton = new javax.swing.JButton();
        createPlaylistsButton = new javax.swing.JButton();
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

        repoButton.setBackground(new java.awt.Color(15, 52, 96));
        repoButton.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        repoButton.setForeground(new java.awt.Color(255, 255, 255));
        repoButton.setText("Repository");
        repoButton.setToolTipText("");
        repoButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        repoButton.setOpaque(true);
        repoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repoButtonActionPerformed(evt);
            }
        });
        jPanel2.add(repoButton);

        PlayListButton.setBackground(new java.awt.Color(15, 52, 96));
        PlayListButton.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        PlayListButton.setForeground(new java.awt.Color(255, 255, 255));
        PlayListButton.setText(EmotionalSongs.dialoghi.myPlaylistsText());
        PlayListButton.setToolTipText("");
        PlayListButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        PlayListButton.setOpaque(true);
        PlayListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayListButtonActionPerformed(evt);
            }
        });
        jPanel2.add(PlayListButton);

        createPlaylistsButton.setBackground(new java.awt.Color(15, 52, 96));
        createPlaylistsButton.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        createPlaylistsButton.setForeground(new java.awt.Color(255, 255, 255));
        createPlaylistsButton.setText(EmotionalSongs.dialoghi.createNewPlaylist());
        createPlaylistsButton.setToolTipText("");
        createPlaylistsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        createPlaylistsButton.setOpaque(true);
        createPlaylistsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlaylistsButtonActionPerformed(evt);
            }
        });
        jPanel2.add(createPlaylistsButton);

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
        closeButton.setText(EmotionalSongs.dialoghi.exit());
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
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void repoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repoButtonActionPerformed
        try {
            mainPage.setMainPanel(new RepositoryPanel());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_repoButtonActionPerformed

    private void PlayListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayListButtonActionPerformed
        PlaylistsManager.getInstance().openUserPlaylistsView();
    }//GEN-LAST:event_PlayListButtonActionPerformed

    private void createPlaylistsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlaylistsButtonActionPerformed
        PlaylistsManager.getInstance().startCreation();
    }//GEN-LAST:event_createPlaylistsButtonActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PlayListButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel closeButtonPanel;
    private javax.swing.JButton createPlaylistsButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel leftSpaceVoidPanel;
    private javax.swing.JButton repoButton;
    private javax.swing.JPanel rightSpaceVoidPanel;
    private javax.swing.JPanel upperSpaceVoidPanel;
    // End of variables declaration//GEN-END:variables

}
