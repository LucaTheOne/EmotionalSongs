/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.gui.repository;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.main_window.*;
import java.awt.*;
import java.io.*;

/**
 *Classe le cui istanze mostrano il repository di canzoni.
 * L' interfaccia offre strumenti di ricerca all' interno del database.
 */
public class RepositoryPanel extends javax.swing.JPanel {
    
    private MainFrame mainWindow = MainFrame.getIstance();
    private int tracksPerView = 100;
    private int startIndex = 0;
    private boolean firstPage = true;
    private boolean lastPage = false;
    
    private Repository repositoryCorrelated = Repository.getInstance();
    private Song[] actualArrayWorking = repositoryCorrelated.getArray();

    /**
     * Crea un nuovo pannello di ispezione nel repository.
     */
    public RepositoryPanel() throws IOException {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JToggleButton();
        X = new javax.swing.JButton();
        centerLowPanel = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        numberResultsLabel = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        TitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        scrollView = new javax.swing.JScrollPane();
        innerScroll = new javax.swing.JPanel();

        setBackground(new java.awt.Color(51, 51, 51));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.BorderLayout());

        SearchPanel.setBackground(new java.awt.Color(85, 124, 147));
        SearchPanel.setPreferredSize(new java.awt.Dimension(814, 50));
        SearchPanel.setLayout(new java.awt.BorderLayout());

        searchButton.setIcon(Utilities.searchIcon);
        searchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        searchButton.setPreferredSize(new java.awt.Dimension(100, 50));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        SearchPanel.add(searchButton, java.awt.BorderLayout.LINE_START);

        X.setBackground(new java.awt.Color(255, 51, 51));
        X.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        X.setForeground(new java.awt.Color(255, 255, 255));
        X.setIcon(Utilities.closeButton);
        X.setAlignmentY(0.0F);
        X.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 102), new java.awt.Color(255, 102, 102), new java.awt.Color(102, 0, 0), new java.awt.Color(153, 0, 0)));
        X.setPreferredSize(new java.awt.Dimension(50, 50));
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        SearchPanel.add(X, java.awt.BorderLayout.LINE_END);

        centerLowPanel.setOpaque(false);
        centerLowPanel.setLayout(new java.awt.BorderLayout());

        clearButton.setBackground(new java.awt.Color(85, 124, 147));
        clearButton.setIcon(Utilities.clearButtonIcon);
        clearButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clearButton.setOpaque(true);
        clearButton.setPreferredSize(new java.awt.Dimension(50, 50));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        centerLowPanel.add(clearButton, java.awt.BorderLayout.LINE_END);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        numberResultsLabel.setForeground(new java.awt.Color(255, 255, 255));
        numberResultsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberResultsLabel.setText(actualArrayWorking.length + " brani presenti!");
        numberResultsLabel.setPreferredSize(new java.awt.Dimension(190, 50));
        jPanel6.add(numberResultsLabel, java.awt.BorderLayout.LINE_END);

        searchBar.setText(EmotionalSongs.dialoghi.searchBarText());
        searchBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        jPanel6.add(searchBar, java.awt.BorderLayout.CENTER);

        centerLowPanel.add(jPanel6, java.awt.BorderLayout.CENTER);

        SearchPanel.add(centerLowPanel, java.awt.BorderLayout.CENTER);

        add(SearchPanel, java.awt.BorderLayout.SOUTH);

        TitlePanel.setMinimumSize(new java.awt.Dimension(379, 50));
        TitlePanel.setPreferredSize(new java.awt.Dimension(10, 50));
        TitlePanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(85, 124, 147));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Repository");
        jLabel1.setMaximumSize(new java.awt.Dimension(235, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(235, 40));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(235, 50));
        TitlePanel.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(133, 37, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel1.setLayout(new java.awt.BorderLayout());

        BackButton.setIcon(Utilities.backButtonIcon);
        BackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        BackButton.setPreferredSize(new java.awt.Dimension(50, 50));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel1.add(BackButton, java.awt.BorderLayout.CENTER);

        TitlePanel.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(133, 37, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(50, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        nextButton.setIcon(Utilities.nextButtonIcon);
        nextButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        nextButton.setPreferredSize(new java.awt.Dimension(50, 50));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel2.add(nextButton, java.awt.BorderLayout.CENTER);

        TitlePanel.add(jPanel2, java.awt.BorderLayout.LINE_END);

        add(TitlePanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setLayout(new java.awt.BorderLayout());

        scrollView.setBorder(null);
        scrollView.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollView.setAlignmentX(0.0F);
        scrollView.setAlignmentY(0.0F);
        scrollView.setOpaque(false);

        innerScroll.setBackground(new java.awt.Color(22, 33, 62));
        innerScroll.setPreferredSize(new Dimension(730,75*tracksPerView));
        innerScroll.setLayout(new java.awt.GridLayout(tracksPerView, 1));
        for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelView());
        }
        scrollView.setViewportView(innerScroll);

        mainPanel.add(scrollView, java.awt.BorderLayout.CENTER);

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        if(searchBar.getText().isBlank()) {
            actualArrayWorking = repositoryCorrelated.getArray();
            innerScroll.removeAll();

            for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
                innerScroll.add(actualArrayWorking[i].buildPanelView());
            }
            
            numberResultsLabel.setText(actualArrayWorking.length +" brani presenti!");
            numberResultsLabel.revalidate();
            numberResultsLabel.repaint();
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
            scrollView.revalidate();
            scrollView.repaint();
            numberResultsLabel.setText("0 brani trovati!");
            numberResultsLabel.revalidate();
            numberResultsLabel.repaint();
            firstPage = true;
            lastPage = true;
            return;
        }
       
        for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelView());   
        } 
        
        numberResultsLabel.setText(actualArrayWorking.length +" risultati trovati!");
        numberResultsLabel.revalidate();
        numberResultsLabel.repaint();
        firstPage = true;
        lastPage = false;
        scrollView.revalidate();
        scrollView.repaint();
        
    }//GEN-LAST:event_searchButtonActionPerformed

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
            innerScroll.add(actualArrayWorking[i].buildPanelView());
        }

        lastPage = false;
        innerScroll.revalidate();
        innerScroll.repaint();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        mainWindow.cleanUpMainPanel();
    }//GEN-LAST:event_XActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if((startIndex+tracksPerView) >= actualArrayWorking.length-1 ) lastPage = true;

        if (lastPage) return;
        firstPage = false;

        startIndex += tracksPerView;

        innerScroll.removeAll();

        for(int i = startIndex; i<(startIndex+tracksPerView) && i<actualArrayWorking.length;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelView());
        }

        innerScroll.revalidate();
        innerScroll.repaint();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        searchBar.setText("");
        actualArrayWorking = repositoryCorrelated.getArray();
        innerScroll.removeAll();
        for(int i = 0;i<actualArrayWorking.length && i<tracksPerView;i++){
            innerScroll.add(actualArrayWorking[i].buildPanelView());   
        }
        firstPage = true;
        lastPage = false;
        numberResultsLabel.setText(actualArrayWorking.length +" brani presenti!");
        innerScroll.revalidate();
        innerScroll.repaint();
        scrollView.revalidate();
        scrollView.repaint();
            
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton X;
    private javax.swing.JPanel centerLowPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel innerScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel numberResultsLabel;
    private javax.swing.JScrollPane scrollView;
    private javax.swing.JTextField searchBar;
    private javax.swing.JToggleButton searchButton;
    // End of variables declaration//GEN-END:variables
    
}
