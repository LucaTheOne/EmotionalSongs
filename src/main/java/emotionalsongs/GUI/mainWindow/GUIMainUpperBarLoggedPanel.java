//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.GUI.mainWindow;

import emotionalsongs.Dialoghi.*;
import emotionalsongs.*;
import emotionalsongs.Dialoghi.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.Generics.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *@hidden
 * @author big
 */
public class GUIMainUpperBarLoggedPanel extends javax.swing.JPanel {
    
    MainFrame mainWindow;
    /**
     * Creates new form UnloggedToolBarPanel
     */
    public GUIMainUpperBarLoggedPanel(MainFrame correlated) {
        mainWindow = correlated;
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
        CreditsButton = new javax.swing.JButton();
        LanguageButton = new javax.swing.JButton();
        LogOutButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(39,16,62,100)
        );
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(800, 25));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 30));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0};
        jPanel1Layout.rowHeights = new int[] {0};
        jPanel1.setLayout(jPanel1Layout);

        menuButton.setBackground(new java.awt.Color(15, 52, 96));
        menuButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        menuButton.setForeground(new java.awt.Color(255, 255, 255));
        menuButton.setText("Menu");
        menuButton.setAlignmentY(0.0F);
        menuButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        CreditsButton.setBackground(new java.awt.Color(15, 52, 96));
        CreditsButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        CreditsButton.setForeground(new java.awt.Color(255, 255, 255));
        CreditsButton.setText(EmotionalSongs.dialoghi.credits());
        CreditsButton.setAlignmentY(0.0F);
        CreditsButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(CreditsButton, gridBagConstraints);

        LanguageButton.setBackground(new java.awt.Color(15, 52, 96));
        LanguageButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        LanguageButton.setForeground(new java.awt.Color(255, 255, 255));
        LanguageButton.setText("English");
        LanguageButton.setAlignmentY(0.0F);
        LanguageButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(LanguageButton, gridBagConstraints);

        LogOutButton.setBackground(new java.awt.Color(15, 52, 96));
        LogOutButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        LogOutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogOutButton.setText("LogOut");
        LogOutButton.setAlignmentY(0.0F);
        LogOutButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LogOutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LogOutButton.setOpaque(true);
        LogOutButton.setPreferredSize(new java.awt.Dimension(72, 18));
        LogOutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(LogOutButton, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuButtonStateChanged
        if(menuButton.isSelected()){
            mainWindow.setLeftPanel(new GUIMainMenuLeftLogged(mainWindow));
        } else {
            mainWindow.setLeftPanel(new GUIMenuLeftVoid(mainWindow));
        }
    }//GEN-LAST:event_menuButtonStateChanged

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButtonActionPerformed

    private void CreditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditsButtonActionPerformed
        mainWindow.setMainPanel(new GUICreditsPanel());
    }//GEN-LAST:event_CreditsButtonActionPerformed

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
        EngineLogger.logout();
        mainWindow.setUpperBar(new GUIMainUpperBarUnloggedPanel(mainWindow));
        mainWindow.setLeftPanel(new GUIMenuLeftVoid(mainWindow));
        mainWindow.cleanUpMainPanel();
    }//GEN-LAST:event_LogOutButtonActionPerformed

    private void LanguageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanguageButtonActionPerformed
       if(emotionalsongs.EmotionalSongs.dialoghi instanceof DialoghiIta){
            emotionalsongs.EmotionalSongs.dialoghi = new DialoghiEng();
            LanguageButton.setText("English");
            mainWindow.updateView();
       } else {
           emotionalsongs.EmotionalSongs.dialoghi = new DialoghiIta();
            LanguageButton.setText("Italiano");
            mainWindow.updateView();
       }
    }//GEN-LAST:event_LanguageButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreditsButton;
    private javax.swing.JButton LanguageButton;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton menuButton;
    // End of variables declaration//GEN-END:variables
}
