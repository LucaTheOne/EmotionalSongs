/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.gui.main_window;

import emotionalsongs.*;
import emotionalsongs.clientES.dialogs.*;
import emotionalsongs.clientES.gui.generics.*;
import emotionalsongs.clientES.gui.login.*;
import emotionalsongs.clientES.wrappers.*;

/**
 * Le istanze di questa classe costruiscono la barra superiore della schermata principale del software
 * quando un utente non ha effettuato il login ad esso.
 * Contiene i pulsanti per: 
 * <ul>
 * <li>Cambiare lingua</li>
 * <li>Aprire e chiudere il menù laterale</li>
 * <li>Effettuare il login</li>
 * <li>Registrarsi</li>
 * <li>Visualizzare il pannello dei crediti</li>
 * </ul>
 */
public class UpperBarUnloggedPanel extends javax.swing.JPanel {
    
    MainFrame mainWindow;
    /**
     * Crea il pannello superiore della schermata principale 
     * che viene mostrato quando un utente non ha effettuato il login.
     */
    public UpperBarUnloggedPanel(MainFrame correlated) {
        mainWindow = correlated;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        menuButton = new javax.swing.JToggleButton();
        RegistrerButton = new javax.swing.JButton();
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
        menuButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        menuButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuButton.setOpaque(true);
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

        RegistrerButton.setBackground(new java.awt.Color(15, 52, 96));
        RegistrerButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        RegistrerButton.setForeground(new java.awt.Color(255, 255, 255));
        RegistrerButton.setText(EmotionalSongs.dialoghi.registration());
        RegistrerButton.setAlignmentY(0.0F);
        RegistrerButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        RegistrerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RegistrerButton.setOpaque(true);
        RegistrerButton.setPreferredSize(new java.awt.Dimension(72, 18));
        RegistrerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RegistrerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(RegistrerButton, gridBagConstraints);

        CreditsButton.setBackground(new java.awt.Color(15, 52, 96));
        CreditsButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        CreditsButton.setForeground(new java.awt.Color(255, 255, 255));
        CreditsButton.setText(EmotionalSongs.dialoghi.credits());
        CreditsButton.setAlignmentY(0.0F);
        CreditsButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        CreditsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CreditsButton.setOpaque(true);
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
        LanguageButton.setText(EmotionalSongs.dialoghi instanceof Italiano ? "English":"Italiano");
        LanguageButton.setAlignmentY(0.0F);
        LanguageButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        LanguageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LanguageButton.setOpaque(true);
        LanguageButton.setPreferredSize(new java.awt.Dimension(72, 18));
        LanguageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LanguageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageButtonActionPerformed(evt);
            }
        });
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
        LoginButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginButton.setOpaque(true);
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
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButtonActionPerformed

    private void menuButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuButtonStateChanged
        if(menuButton.isSelected()){
            mainWindow.setLeftPanel(new MenuLeftUnlogged(mainWindow));
            mainWindow.setMenuOpened();
        } else {
            mainWindow.setLeftPanel(new MenuLeftVoid(mainWindow));
            mainWindow.setMenuClosed();
        }
    }//GEN-LAST:event_menuButtonStateChanged

    private void RegistrerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrerButtonActionPerformed
        Users.registrazione();
    }//GEN-LAST:event_RegistrerButtonActionPerformed

    private void CreditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditsButtonActionPerformed
        mainWindow.setMainPanel(new CreditsPanel());
    }//GEN-LAST:event_CreditsButtonActionPerformed

    private void LanguageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanguageButtonActionPerformed
        if(EmotionalSongs.dialoghi instanceof Italiano){
            EmotionalSongs.dialoghi = new English();
            LanguageButton.setText("Italiano");
            RegistrerButton.setText("Registration");
            CreditsButton.setText("Credits");
            if(mainWindow.getIfLeftOpened()) mainWindow.setLeftPanel(new MenuLeftUnlogged(mainWindow));
            else mainWindow.setLeftPanel(new MenuLeftVoid(mainWindow));
            mainWindow.updateView();
        } else {
           EmotionalSongs.dialoghi = new Italiano();
           LanguageButton.setText("English");
           RegistrerButton.setText("Registrazione");
           CreditsButton.setText("Crediti");
           if(mainWindow.getIfLeftOpened()) mainWindow.setLeftPanel(new MenuLeftUnlogged(mainWindow));
           else mainWindow.setLeftPanel(new MenuLeftVoid(mainWindow));
           mainWindow.updateView();
        }
    }//GEN-LAST:event_LanguageButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreditsButton;
    private javax.swing.JButton LanguageButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton RegistrerButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton menuButton;
    // End of variables declaration//GEN-END:variables
}
