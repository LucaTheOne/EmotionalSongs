/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package emotionalsongs;

/**
 *@hidden
 * @author big
 */
public class UnloggedToolBarPanel extends javax.swing.JPanel {
    
    MainWindow mainPage;
    /**
     * Creates new form UnloggedToolBarPanel
     */
    public UnloggedToolBarPanel(MainWindow correlated) {
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

        upperToolBar = new javax.swing.JToolBar();
        menuButton = new javax.swing.JToggleButton();
        LoginButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        CreditsButton = new javax.swing.JButton();
        LanguageButton = new javax.swing.JButton();

        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(800, 30));
        setLayout(new java.awt.BorderLayout());

        upperToolBar.setRollover(true);
        upperToolBar.setOpaque(false);
        upperToolBar.setPreferredSize(new java.awt.Dimension(350, 30));

        menuButton.setText("menu");
        menuButton.setFocusable(false);
        menuButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        upperToolBar.add(menuButton);

        LoginButton.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        LoginButton.setText("Login");
        LoginButton.setFocusable(false);
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        upperToolBar.add(LoginButton);

        RegisterButton.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        RegisterButton.setText("Register");
        RegisterButton.setFocusable(false);
        RegisterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RegisterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        upperToolBar.add(RegisterButton);

        CreditsButton.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        CreditsButton.setText("Credits");
        CreditsButton.setFocusable(false);
        CreditsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreditsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        upperToolBar.add(CreditsButton);

        LanguageButton.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        LanguageButton.setText("English");
        LanguageButton.setFocusable(false);
        LanguageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LanguageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        upperToolBar.add(LanguageButton);

        add(upperToolBar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        new LogInFrame().setVisible(true);
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButtonActionPerformed

    private void menuButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuButtonStateChanged
        if(menuButton.isSelected()){
            mainPage.setLeftPanel(new UnloggedMenuExpanded(mainPage));
        } else {
            mainPage.setLeftPanel(new MenuUnespanded(mainPage));
        }
    }//GEN-LAST:event_menuButtonStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreditsButton;
    private javax.swing.JButton LanguageButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JToggleButton menuButton;
    private javax.swing.JToolBar upperToolBar;
    // End of variables declaration//GEN-END:variables
}
