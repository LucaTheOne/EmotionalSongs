
package emotionalsongs.GUI.PlayLists;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.Managers.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.Managers.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author big
 */
public class PlaylistCreationFrame extends javax.swing.JFrame {

    /**
     * Creates new form PlaylistCreationFrame
     */
    PlayListsManager playlistsManager = EMOTIONALSONGS.playListsManager;
    Repository repositoryCorrelato = EMOTIONALSONGS.REPOSITORY;
    Song[] actualArrayWorking = repositoryCorrelato.getArray();
    
    int tracksPerView = 100;
    int startIndex = 0;
    boolean firstPage = true;
    boolean lastPage = false;
    
    public PlaylistCreationFrame() {
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, 800, 650, 20, 20));
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
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(Utilities.regBG.getImage(), 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }
        };
        createButtonPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        annullaButton = new javax.swing.JButton();
        selectedSongsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedSongScrollViewPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        SearchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JToggleButton();
        numberSelectedSongLabel = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        TitlePanel = new javax.swing.JPanel();
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
        innerScroll = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(Utilities.RepoBgIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));

        mainPanel.setOpaque(true);
        mainPanel.setLayout(new java.awt.BorderLayout());

        createButtonPanel.setOpaque(false);
        createButtonPanel.setPreferredSize(new java.awt.Dimension(120, 40));
        java.awt.GridBagLayout createButtonPanelLayout = new java.awt.GridBagLayout();
        createButtonPanelLayout.columnWidths = new int[] {0, 60, 0};
        createButtonPanelLayout.rowHeights = new int[] {0};
        createButtonPanel.setLayout(createButtonPanelLayout);

        createButton.setText("Crea nuova playlist");
        createButton.setPreferredSize(new java.awt.Dimension(150, 40));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        createButtonPanel.add(createButton, gridBagConstraints);

        annullaButton.setText("annulla");
        annullaButton.setPreferredSize(new java.awt.Dimension(120, 40));
        annullaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        createButtonPanel.add(annullaButton, gridBagConstraints);

        mainPanel.add(createButtonPanel, java.awt.BorderLayout.PAGE_END);

        selectedSongsPanel.setOpaque(false);
        selectedSongsPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setOpaque(false);

        selectedSongScrollViewPanel.setBackground(new Color(0,0,0,160));
        selectedSongScrollViewPanel.setOpaque(false);
        selectedSongScrollViewPanel.setPreferredSize(new Dimension(jScrollPane1.getWidth(),30*EMOTIONALSONGS.playListsManager.getNumberOfSongToAdd()));
        selectedSongScrollViewPanel.setLayout(new java.awt.GridLayout(EMOTIONALSONGS.playListsManager.getNumberOfSongToAdd(), 1));

        searchPanel.setBackground(new java.awt.Color(51, 51, 51));
        searchPanel.setOpaque(false);
        searchPanel.setPreferredSize(new java.awt.Dimension(900, 700));
        searchPanel.setLayout(new java.awt.BorderLayout());

        SearchPanel.setBackground(new java.awt.Color(85, 124, 147));
        SearchPanel.setPreferredSize(new java.awt.Dimension(814, 50));
        SearchPanel.setLayout(new java.awt.BorderLayout());

        searchButton.setIcon(Utilities.searchIcon);
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
        numberSelectedSongLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        numberSelectedSongLabel.setPreferredSize(new java.awt.Dimension(190, 50));
        SearchPanel.add(numberSelectedSongLabel, java.awt.BorderLayout.EAST);

        searchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        SearchPanel.add(searchBar, java.awt.BorderLayout.CENTER);

        searchPanel.add(SearchPanel, java.awt.BorderLayout.SOUTH);

        TitlePanel.setMinimumSize(new java.awt.Dimension(379, 50));
        TitlePanel.setPreferredSize(new java.awt.Dimension(10, 50));
        TitlePanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(133, 37, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        BackButton.setIcon(Utilities.backButtonIcon);
        BackButton.setPreferredSize(new java.awt.Dimension(50, 50));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel2.add(BackButton, java.awt.BorderLayout.CENTER);

        TitlePanel.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(133, 37, 240));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        nextButton.setIcon(Utilities.nextButtonIcon);
        nextButton.setPreferredSize(new java.awt.Dimension(50, 50));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel3.add(nextButton, java.awt.BorderLayout.CENTER);

        TitlePanel.add(jPanel3, java.awt.BorderLayout.LINE_END);

        selectPlaylistNamePanel.setBackground(new java.awt.Color(85, 124, 147));
        selectPlaylistNamePanel.setPreferredSize(new java.awt.Dimension(700, 50));
        selectPlaylistNamePanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome della nuova playlist:    ");
        selectPlaylistNamePanel.add(jLabel1, new java.awt.GridBagConstraints());

        playlistNameTextField.setText("newPlaylist");
        playlistNameTextField.setPreferredSize(new java.awt.Dimension(250, 30));
        playlistNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistNameTextFieldActionPerformed(evt);
            }
        });
        selectPlaylistNamePanel.add(playlistNameTextField, new java.awt.GridBagConstraints());

        TitlePanel.add(selectPlaylistNamePanel, java.awt.BorderLayout.CENTER);

        searchPanel.add(TitlePanel, java.awt.BorderLayout.PAGE_START);

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
        titleLabel1.setText("Titolo");
        titleLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        titleLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel1.setOpaque(true);
        titleLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel8.add(titleLabel1);

        authorLabel1.setBackground(new java.awt.Color(5, 23, 44));
        authorLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        authorLabel1.setForeground(new java.awt.Color(255, 255, 255));
        authorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel1.setText("Autore");
        authorLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        authorLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        authorLabel1.setOpaque(true);
        authorLabel1.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel8.add(authorLabel1);

        yearLabel1.setBackground(new java.awt.Color(5, 23, 44));
        yearLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        yearLabel1.setForeground(new java.awt.Color(255, 255, 255));
        yearLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearLabel1.setText("Anno");
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
        innerScroll.setPreferredSize(new java.awt.Dimension(800, 3000));
        innerScroll.setLayout(new java.awt.GridLayout(100, 1));
        for(int i = 0;i<tracksPerView;i++){
            innerScroll.add(repositoryCorrelato.getBrano(i).buildPanelAddToPlaylist());
        }
        scrollView.setViewportView(innerScroll);

        mainPanel1.add(scrollView, java.awt.BorderLayout.CENTER);

        searchPanel.add(mainPanel1, java.awt.BorderLayout.CENTER);

        selectedSongScrollViewPanel.add(searchPanel);

        jScrollPane1.setViewportView(selectedSongScrollViewPanel);

        selectedSongsPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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
        EMOTIONALSONGS.playListsManager.setTitlePlaylist(playlistNameTextField.getText().isBlank()?"newPlaylist":playlistNameTextField.getText());
        EMOTIONALSONGS.playListsManager.registraPlaylist();
        close();
    }//GEN-LAST:event_createButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        if(searchBar.getText().isBlank()) {
            actualArrayWorking = repositoryCorrelato.getArray();
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
            actualArrayWorking = repositoryCorrelato.getArray();
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaylistCreationFrame().setVisible(true);
            }
        });
    }
    
    public void close() {
        this.dispose();
        EMOTIONALSONGS.playListsManager.eraseSongToAdd();
        EMOTIONALSONGS.playListsManager.eraseTitlePlaylist();
    }
    
    public void updateSongSelectedLabel(){
        numberSelectedSongLabel.revalidate();
        numberSelectedSongLabel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton annullaButton;
    private javax.swing.JLabel authorLabel1;
    private javax.swing.JButton createButton;
    private javax.swing.JPanel createButtonPanel;
    private javax.swing.JPanel innerScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPanel1;
    private javax.swing.JButton nextButton;
    public javax.swing.JLabel numberSelectedSongLabel;
    private javax.swing.JTextField playlistNameTextField;
    private javax.swing.JScrollPane scrollView;
    private javax.swing.JTextField searchBar;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel selectPlaylistNamePanel;
    private javax.swing.JPanel selectedSongScrollViewPanel;
    private javax.swing.JPanel selectedSongsPanel;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JPanel titlesPanel;
    private javax.swing.JLabel yearLabel1;
    // End of variables declaration//GEN-END:variables
}
