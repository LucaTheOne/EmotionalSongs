/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package emotionalsongs;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Megaport
 */
public class UnloggedMenuExpanded extends javax.swing.JPanel {
    
    MainWindow mainPage;

    /** Creates new form UnloggedMenu */
    public UnloggedMenuExpanded(MainWindow correlated) {
        mainPage = correlated;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(120, 600));
        setLayout(new java.awt.BorderLayout(0, 5));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0,45));
        jPanel3.setPreferredSize(new java.awt.Dimension(120, 300));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 300));
        jPanel2.setLayout(new java.awt.GridLayout(6, 1, 5, 5));

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jButton2.setText("Repository");
        jButton2.setToolTipText("");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jPanel3.add(jPanel2, java.awt.BorderLayout.NORTH);

        jButton1.setText("Chiudi");
        jButton1.setPreferredSize(new java.awt.Dimension(75, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, java.awt.BorderLayout.PAGE_END);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mainPage.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            mainPage.setMainPanel(new InspectRepoPanel());
            changeButtonColorsActive(jButton2);
        } catch (IOException ex) {
            ex.getMessage();
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void changeButtonColorsActive(JButton button){
        button.setBackground(new Color(133, 35, 240));
        button.setForeground(Color.WHITE);   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}