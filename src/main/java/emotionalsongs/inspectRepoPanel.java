/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author big
 */
public class inspectRepoPanel extends javax.swing.JPanel {
    int counterIndex = 30;
    boolean firstPage = true;
    Repository repo = new Repository();
    /**
     * Creates new form inspectRepoPanel
     */
    public inspectRepoPanel() throws IOException {
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

        Repository repo = new Repository();
        repoButtonsView = new javax.swing.JScrollPane();
        subPanelRepoView = new javax.swing.JPanel();
        SearchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JToggleButton();
        searchBar = new javax.swing.JTextField();
        space = new javax.swing.JLabel();
        space1 = new javax.swing.JLabel();
        TitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.BorderLayout());

        repoButtonsView.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        repoButtonsView.setAlignmentX(0.0F);
        repoButtonsView.setAlignmentY(0.0F);
        repoButtonsView.setOpaque(false);

        subPanelRepoView.setOpaque(false);
        subPanelRepoView.setPreferredSize(new java.awt.Dimension(500, 1500));
        subPanelRepoView.setLayout(new java.awt.GridLayout(30, 1));
        for(int i = 0; i<30;i++){
            subPanelRepoView.add(repo.getBrano(i).getButton());
        }
        repoButtonsView.setViewportView(subPanelRepoView);

        add(repoButtonsView, java.awt.BorderLayout.CENTER);

        SearchPanel.setBackground(new java.awt.Color(89, 193, 201));
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
        SearchPanel.add(searchButton, java.awt.BorderLayout.LINE_START);

        searchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        SearchPanel.add(searchBar, java.awt.BorderLayout.CENTER);

        space.setIcon(Utilities.spaceImage);
        space.setPreferredSize(new java.awt.Dimension(50, 50));
        space.setSize(new java.awt.Dimension(50, 50));
        SearchPanel.add(space, java.awt.BorderLayout.LINE_END);

        space1.setIcon(Utilities.spaceImage);
        space1.setPreferredSize(new java.awt.Dimension(50, 50));
        SearchPanel.add(space1, java.awt.BorderLayout.LINE_END);

        add(SearchPanel, java.awt.BorderLayout.SOUTH);

        TitlePanel.setMinimumSize(new java.awt.Dimension(379, 50));
        TitlePanel.setPreferredSize(new java.awt.Dimension(10, 50));
        TitlePanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(0, 196, 205));
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
        nextButton.setPreferredSize(new java.awt.Dimension(50, 50));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel2.add(nextButton, java.awt.BorderLayout.CENTER);

        TitlePanel.add(jPanel2, java.awt.BorderLayout.LINE_END);

        add(TitlePanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        counterIndex -= 30;
        if (counterIndex==30) {
            BackButton.setBorderPainted(false);
            BackButton.setFocusPainted(false);  
        }
        subPanelRepoView.removeAll();
        for(int i = counterIndex-30;i<counterIndex;i++){
            subPanelRepoView.add(repo.getBrano(i).getButton());
        }
        subPanelRepoView.revalidate();
        subPanelRepoView.repaint();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        counterIndex += 30;
        
        subPanelRepoView.removeAll();
        for(int i = counterIndex-30;i<counterIndex;i++){
            subPanelRepoView.add(repo.getBrano(i).getButton());
        }
        subPanelRepoView.revalidate();
        subPanelRepoView.repaint();    }//GEN-LAST:event_nextButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nextButton;
    private javax.swing.JScrollPane repoButtonsView;
    private javax.swing.JTextField searchBar;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JLabel space;
    private javax.swing.JLabel space1;
    private javax.swing.JPanel subPanelRepoView;
    // End of variables declaration//GEN-END:variables
    
}
