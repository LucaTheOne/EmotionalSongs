package emotionalsongs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *@hidden
 * @author big
 */
public class GUILoggedToolBarPanel extends javax.swing.JPanel {
    
    GUIMainFrame mainPage;
    /**
     * Creates new form UnloggedToolBarPanel
     */
    public GUILoggedToolBarPanel(GUIMainFrame correlated) {
        mainPage = correlated;
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

        jPanel1 = new javax.swing.JPanel();
        menuButton = new javax.swing.JToggleButton();
        profileButton = new javax.swing.JButton();
        CreditsButton = new javax.swing.JButton();
        LanguageButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(39,16,62,100)
        );
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(800, 30));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(390, 30));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        menuButton.setBackground(new java.awt.Color(15, 52, 96));
        menuButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        menuButton.setForeground(new java.awt.Color(255, 255, 255));
        menuButton.setText("Menu");
        menuButton.setAlignmentY(0.0F);
        menuButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuButton.setPreferredSize(new java.awt.Dimension(72, 18));
        menuButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                menuButtonStateChanged(evt);
            }
        });
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(menuButton, gridBagConstraints);

        profileButton.setBackground(new java.awt.Color(15, 52, 96));
        profileButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setText("Profile");
        profileButton.setAlignmentY(0.0F);
        profileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileButton.setPreferredSize(new java.awt.Dimension(72, 18));
        profileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(profileButton, gridBagConstraints);

        CreditsButton.setBackground(new java.awt.Color(15, 52, 96));
        CreditsButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        CreditsButton.setForeground(new java.awt.Color(255, 255, 255));
        CreditsButton.setText("Credits");
        CreditsButton.setAlignmentY(0.0F);
        CreditsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreditsButton.setPreferredSize(new java.awt.Dimension(72, 18));
        CreditsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CreditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(CreditsButton, gridBagConstraints);

        LanguageButton.setBackground(new java.awt.Color(15, 52, 96));
        LanguageButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        LanguageButton.setForeground(new java.awt.Color(255, 255, 255));
        LanguageButton.setText("English");
        LanguageButton.setAlignmentY(0.0F);
        LanguageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LanguageButton.setPreferredSize(new java.awt.Dimension(72, 18));
        LanguageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(LanguageButton, gridBagConstraints);

        logOutButton.setBackground(new java.awt.Color(15, 52, 96));
        logOutButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("LogOut");
        logOutButton.setAlignmentY(0.0F);
        logOutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logOutButton.setPreferredSize(new java.awt.Dimension(72, 18));
        logOutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(logOutButton, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuButtonStateChanged
        if(menuButton.isSelected()){
            mainPage.setLeftPanel(new GUILoggedMenuExpanded(mainPage));
        } else {
            mainPage.setLeftPanel(new GUILeftMenuUnespanded(mainPage));
        }
    }//GEN-LAST:event_menuButtonStateChanged

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed

        //visualizza dati utente
    }//GEN-LAST:event_profileButtonActionPerformed

    private void CreditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditsButtonActionPerformed
        mainPage.setMainPanel(new GUICreditsPanel());
    }//GEN-LAST:event_CreditsButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        mainPage.setUpperBar(new GUIUnloggedToolBarPanel(mainPage));
        mainPage.setLeftPanel(new GUILeftMenuUnespanded(mainPage));
        mainPage.update();
    }//GEN-LAST:event_logOutButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreditsButton;
    private javax.swing.JButton LanguageButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JToggleButton menuButton;
    private javax.swing.JButton profileButton;
    // End of variables declaration//GEN-END:variables
}
