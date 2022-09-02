/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package emotionalsongs;

/**
 *@hidden
 * @author big
 */
public class GUIUnloggedToolBarPanel extends javax.swing.JPanel {
    
    GUIMainFrame mainPage;
    /**
     * Creates new form UnloggedToolBarPanel
     */
    public GUIUnloggedToolBarPanel(GUIMainFrame correlated) {
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
        RegisterButton = new javax.swing.JButton();
        CreditsButton = new javax.swing.JButton();
        LanguageButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(15,27,54, 160)
        );
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(800, 25));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(390, 30));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0};
        jPanel1Layout.rowHeights = new int[] {0};
        jPanel1.setLayout(jPanel1Layout);

        menuButton.setBackground(new java.awt.Color(15, 52, 96));
        menuButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        menuButton.setForeground(new java.awt.Color(255, 255, 255));
        menuButton.setText("Menu");
        menuButton.setAlignmentY(0.0F);
        menuButton.setBorder(null);
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

        RegisterButton.setBackground(new java.awt.Color(15, 52, 96));
        RegisterButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterButton.setText("Register");
        RegisterButton.setAlignmentY(0.0F);
        RegisterButton.setBorder(null);
        RegisterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RegisterButton.setPreferredSize(new java.awt.Dimension(72, 18));
        RegisterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(RegisterButton, gridBagConstraints);

        CreditsButton.setBackground(new java.awt.Color(15, 52, 96));
        CreditsButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        CreditsButton.setForeground(new java.awt.Color(255, 255, 255));
        CreditsButton.setText("Credits");
        CreditsButton.setAlignmentY(0.0F);
        CreditsButton.setBorder(null);
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
        LanguageButton.setBorder(null);
        LanguageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LanguageButton.setPreferredSize(new java.awt.Dimension(72, 18));
        LanguageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(LanguageButton, gridBagConstraints);

        LoginButton.setBackground(new java.awt.Color(15, 52, 96));
        LoginButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setAlignmentY(0.0F);
        LoginButton.setBorder(null);
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginButton.setPreferredSize(new java.awt.Dimension(72, 18));
        LoginButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(LoginButton, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        new GUILogInFrame().setVisible(true);
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButtonActionPerformed

    private void menuButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuButtonStateChanged
        if(menuButton.isSelected()){
            mainPage.setLeftPanel(new GUIUnloggedMenuExpanded(mainPage));
        } else {
            mainPage.setLeftPanel(new GUILeftMenuUnespanded(mainPage));
        }
    }//GEN-LAST:event_menuButtonStateChanged

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed

            mainPage.setMainPanel(new GUIRegistrationPanel());            
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void CreditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditsButtonActionPerformed
        mainPage.setMainPanel(new GUICreditsPanel());
    }//GEN-LAST:event_CreditsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreditsButton;
    private javax.swing.JButton LanguageButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton menuButton;
    // End of variables declaration//GEN-END:variables
}