//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.gui.playlists;

import emotionalsongs.managers.PlaylistsManager;
import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.engines.*;
import javax.swing.*;

/**
 * Classe le cui istanze sono form per la creazione di nuove playlist.
 * Questa classe è fortemente dipendente dal playlistManager
 */
public class PlaylistCreationFrame extends javax.swing.JFrame {

    /**
     * Crea il form per la creazione di nuove playlist.
     */
    PlaylistsManager playlistsManager = PlaylistsManager.getInstance();
    Repository repositoryCorrelated = Repository.getInstance();
    Song[] actualArrayWorking = repositoryCorrelated.getArray();
    
    int tracksPerView = 100;
    int startIndex = 0;
    boolean firstPage = true;
    boolean lastPage = false;
    
    public PlaylistCreationFrame() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        annullaButton = new javax.swing.JButton();
        selectedSongsPanel = new javax.swing.JPanel();
        SearchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JToggleButton();
        numberSelectedSongLabel = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        intestationPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        selectPlaylistNamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        playlistNameTextField = new javax.swing.JTextField();
        mainPanel1 = new javax.swing.JPanel();
        titlesPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        authorLabel1 = new javax.swing.JLabel();
        yearLabel1 = new javax.swing.JLabel();
        scrollView = new javax.swing.JScrollPane();
        innerScroll = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 660));

        mainPanel.setMinimumSize(new java.awt.Dimension(1000, 660));
        mainPanel.setOpaque(true);
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 660));
        mainPanel.setLayout(new java.awt.BorderLayout());

        buttonPanel.setBackground(new java.awt.Color(85, 124, 147));
        buttonPanel.setPreferredSize(new java.awt.Dimension(120, 46));
        java.awt.GridBagLayout createButtonPanelLayout = new java.awt.GridBagLayout();
        createButtonPanelLayout.columnWidths = new int[] {0, 60, 0};
        createButtonPanelLayout.rowHeights = new int[] {0};
        buttonPanel.setLayout(createButtonPanelLayout);

        createButton.setText(emotionalsongs.EmotionalSongs.dialoghi.creaNuovaPlaylistButton());
        createButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createButton.setOpaque(true);
        createButton.setPreferredSize(new java.awt.Dimension(150, 40));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        buttonPanel.add(createButton, gridBagConstraints);

        annullaButton.setBackground(new java.awt.Color(255, 0, 51));
        annullaButton.setForeground(new java.awt.Color(255, 255, 255));
        annullaButton.setText(emotionalsongs.EmotionalSongs.dialoghi.abort());
        annullaButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        annullaButton.setOpaque(true);
        annullaButton.setPreferredSize(new java.awt.Dimension(120, 40));
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        buttonPanel.add(annullaButton, gridBagConstraints);

        mainPanel.add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        selectedSongsPanel.setOpaque(false);
        selectedSongsPanel.setLayout(new java.awt.BorderLayout());

        SearchPanel.setBackground(new java.awt.Color(85, 124, 147));
        SearchPanel.setPreferredSize(new java.awt.Dimension(814, 50));
        SearchPanel.setLayout(new java.awt.BorderLayout());

        searchButton.setIcon(Utilities.searchIcon);
        searchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        searchButton.setPreferredSize(new java.awt.Dimension(100, 50));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        SearchPanel.add(searchButton, java.awt.BorderLayout.WEST);

        numberSelectedSongLabel.setForeground(new java.awt.Color(255, 255, 255));
        numberSelectedSongLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberSelectedSongLabel.setText(playlistsManager.getNumberOfSongToAdd() + " brani selezionati!");
        numberSelectedSongLabel.setPreferredSize(new java.awt.Dimension(190, 50));
        SearchPanel.add(numberSelectedSongLabel, java.awt.BorderLayout.EAST);

        searchBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        SearchPanel.add(searchBar, java.awt.BorderLayout.CENTER);

        selectedSongsPanel.add(SearchPanel, java.awt.BorderLayout.SOUTH);

        intestationPanel.setMinimumSize(new java.awt.Dimension(379, 50));
        intestationPanel.setPreferredSize(new java.awt.Dimension(10, 50));
        intestationPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(133, 37, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        BackButton.setIcon(Utilities.backButtonIcon);
        BackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BackButton.setPreferredSize(new java.awt.Dimension(50, 50));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel2.add(BackButton, java.awt.BorderLayout.CENTER);

        intestationPanel.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(133, 37, 240));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        nextButton.setIcon(Utilities.nextButtonIcon);
        nextButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nextButton.setPreferredSize(new java.awt.Dimension(50, 50));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel3.add(nextButton, java.awt.BorderLayout.CENTER);

        intestationPanel.add(jPanel3, java.awt.BorderLayout.LINE_END);

        selectPlaylistNamePanel.setBackground(new java.awt.Color(85, 124, 147));
        selectPlaylistNamePanel.setPreferredSize(new java.awt.Dimension(700, 50));
        java.awt.GridBagLayout selectPlaylistNamePanelLayout = new java.awt.GridBagLayout();
        selectPlaylistNamePanelLayout.columnWidths = new int[] {0, 15, 0};
        selectPlaylistNamePanelLayout.rowHeights = new int[] {0};
        selectPlaylistNamePanel.setLayout(selectPlaylistNamePanelLayout);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(emotionalsongs.EmotionalSongs.dialoghi.newPlaylistLabel());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        selectPlaylistNamePanel.add(jLabel1, gridBagConstraints);

        playlistNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playlistNameTextField.setText("<new playlist>");
        playlistNameTextField.setPreferredSize(new java.awt.Dimension(250, 30));
        playlistNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistNameTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        selectPlaylistNamePanel.add(playlistNameTextField, gridBagConstraints);

        intestationPanel.add(selectPlaylistNamePanel, java.awt.BorderLayout.CENTER);

        selectedSongsPanel.add(intestationPanel, java.awt.BorderLayout.NORTH);

        mainPanel1.setLayout(new java.awt.BorderLayout());

        titlesPanel.setPreferredSize(new java.awt.Dimension(100, 30));
        titlesPanel.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(5, 23, 44));
        jPanel4.setMinimumSize(new java.awt.Dimension(720, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 30));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(5, 23, 44));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(136, 100));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel5, java.awt.BorderLayout.LINE_END);

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        titleLabel1.setBackground(new java.awt.Color(5, 23, 44));
        titleLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel1.setText(emotionalsongs.EmotionalSongs.dialoghi.title()
        );
        titleLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        titleLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel1.setOpaque(true);
        titleLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel8.add(titleLabel1);

        authorLabel1.setBackground(new java.awt.Color(5, 23, 44));
        authorLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        authorLabel1.setForeground(new java.awt.Color(255, 255, 255));
        authorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel1.setText(emotionalsongs.EmotionalSongs.dialoghi.author());
        authorLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        authorLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        authorLabel1.setOpaque(true);
        authorLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel8.add(authorLabel1);

        yearLabel1.setBackground(new java.awt.Color(5, 23, 44));
        yearLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        yearLabel1.setForeground(new java.awt.Color(255, 255, 255));
        yearLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearLabel1.setText(emotionalsongs.EmotionalSongs.dialoghi.year());
        yearLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        yearLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        yearLabel1.setOpaque(true);
        yearLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel8.add(yearLabel1);

        jPanel4.add(jPanel8, java.awt.BorderLayout.CENTER);

        titlesPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        mainPanel1.add(titlesPanel, java.awt.BorderLayout.PAGE_START);

        scrollView.setBackground(new java.awt.Color(0, 24, 46));
        scrollView.setBorder(null);
        scrollView.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollView.setAlignmentX(0.0F);
        scrollView.setAlignmentY(0.0F);

        innerScroll.setBackground(new java.awt.Color(0, 24, 46));
        innerScroll.setOpaque(false);
        innerScroll.setPreferredSize(new java.awt.Dimension(810, 3200));
        innerScroll.setLayout(new java.awt.GridLayout(100, 1));
        for(int i = 0;i<tracksPerView;i++){
            innerScroll.add(repositoryCorrelated.getBrano(i).buildPanelAddToPlaylist());
        }
        scrollView.setViewportView(innerScroll);

        mainPanel1.add(scrollView, java.awt.BorderLayout.CENTER);

        selectedSongsPanel.add(mainPanel1, java.awt.BorderLayout.CENTER);

        mainPanel.add(selectedSongsPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void playlistNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlistNameTextFieldActionPerformed
        
    }//GEN-LAST:event_playlistNameTextFieldActionPerformed

    private void annullaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaButtonActionPerformed
        close();
    }//GEN-LAST:event_annullaButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        playlistsManager.setTitlePlaylist(playlistNameTextField.getText().isBlank()?"newPlaylist":playlistNameTextField.getText());
        playlistsManager.registraPlaylist();
        
        close();
    }//GEN-LAST:event_createButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        if(searchBar.getText().isBlank()) {
            actualArrayWorking = repositoryCorrelated.getArray();
            innerScroll.removeAll();

            for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
                innerScroll.add(actualArrayWorking[i].buildPanelAddToPlaylist());
            }

            numberSelectedSongLabel.revalidate();
            numberSelectedSongLabel.repaint();
            firstPage = true;
            lastPage = false;
            scrollView.revalidate();
            scrollView.repaint();
            return;
        }

        EngineSearcher searchEngine = new EngineSearcher();
        actualArrayWorking = searchEngine.cercaBranoMusicale(searchBar.getText());
        innerScroll.removeAll();

        if(actualArrayWorking == null){
            innerScroll.removeAll();
            innerScroll.revalidate();
            innerScroll.repaint();
            numberSelectedSongLabel.revalidate();
            numberSelectedSongLabel.repaint();
            firstPage = true;
            lastPage = true;
            return;
        }

        for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelAddToPlaylist());
        }

        numberSelectedSongLabel.revalidate();
        numberSelectedSongLabel.repaint();
        firstPage = true;
        lastPage = false;
        innerScroll.revalidate();
        innerScroll.repaint();

    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        if(searchBar.getText().isBlank()) {
            actualArrayWorking = repositoryCorrelated.getArray();
            innerScroll.removeAll();

            for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
                innerScroll.add(actualArrayWorking[i].buildPanelAddToPlaylist());
            }

            numberSelectedSongLabel.revalidate();
            numberSelectedSongLabel.repaint();
            firstPage = true;
            lastPage = false;
            scrollView.revalidate();
            scrollView.repaint();
            return;
        }

        EngineSearcher searchEngine = new EngineSearcher();
        actualArrayWorking = searchEngine.cercaBranoMusicale(searchBar.getText());
        innerScroll.removeAll();

        if(actualArrayWorking == null){
            innerScroll.removeAll();
            innerScroll.revalidate();
            innerScroll.repaint();
            numberSelectedSongLabel.revalidate();
            numberSelectedSongLabel.repaint();
            firstPage = true;
            lastPage = true;
            return;
        }

        for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelAddToPlaylist());
        }

        numberSelectedSongLabel.revalidate();
        numberSelectedSongLabel.repaint();
        firstPage = true;
        lastPage = false;
        innerScroll.revalidate();
        innerScroll.repaint();
    }//GEN-LAST:event_searchBarActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        if (firstPage) {
            return;
        }
        startIndex -= tracksPerView;
        if (startIndex == 0) {
            firstPage = true;
        }
        innerScroll.removeAll();

        for(int i = startIndex; i<(startIndex+tracksPerView) && i<actualArrayWorking.length;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelAddToPlaylist());
        }

        lastPage = false;
        innerScroll.revalidate();
        innerScroll.repaint();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if((startIndex+tracksPerView) >= actualArrayWorking.length-1 ) lastPage = true;

        if (lastPage) return;
        firstPage = false;

        startIndex += tracksPerView;

        innerScroll.removeAll();

        for(int i = startIndex; i<(startIndex+tracksPerView) && i<actualArrayWorking.length;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelAddToPlaylist());
        }

        innerScroll.revalidate();
        innerScroll.repaint();
    }//GEN-LAST:event_nextButtonActionPerformed

    
    public void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaylistCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaylistCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaylistCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaylistCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaylistCreationFrame().setVisible(true);
            }
        });
    }
    
    public void close() {
        this.dispose();
        playlistsManager.eraseSongToAdd();
        playlistsManager.eraseTitlePlaylist();
        playlistsManager.eraseNumberOfSelectedSong();
    }
    
    public void updateSongSelectedLabel(){
        numberSelectedSongLabel.revalidate();
        numberSelectedSongLabel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JButton annullaButton;
    private javax.swing.JLabel authorLabel1;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton createButton;
    private javax.swing.JPanel innerScroll;
    private javax.swing.JPanel intestationPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPanel1;
    private javax.swing.JButton nextButton;
    public javax.swing.JLabel numberSelectedSongLabel;
    private javax.swing.JTextField playlistNameTextField;
    private javax.swing.JScrollPane scrollView;
    private javax.swing.JTextField searchBar;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JPanel selectPlaylistNamePanel;
    private javax.swing.JPanel selectedSongsPanel;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JPanel titlesPanel;
    private javax.swing.JLabel yearLabel1;
    // End of variables declaration//GEN-END:variables
}
