/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package emotionalsongs.GUI.VotingSongs;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.Managers.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author big
 */
public class voteEmotionPanel extends javax.swing.JPanel {

    /**
     * Creates new form voteEmotionPanel
     */
    Emozioni emotion;
    VoteManager manager = EMOTIONALSONGS.voteManager;
    public voteEmotionPanel(Emozioni emotion) {
        this.emotion = emotion;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numbersPanel = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(700, 200));
        setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(emotion.getName());
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));
        add(jLabel1);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 22)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(emotion.getDescription());
        jLabel3.setPreferredSize(new java.awt.Dimension(600, 50));
        add(jLabel3);

        numbersPanel.setLayout(new java.awt.GridBagLayout());

        jRadioButton1.setText("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        numbersPanel.add(jRadioButton1, new java.awt.GridBagConstraints());

        jRadioButton2.setText("2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        numbersPanel.add(jRadioButton2, gridBagConstraints);

        jRadioButton3.setText("3");
        jRadioButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton3StateChanged(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        numbersPanel.add(jRadioButton3, gridBagConstraints);

        jRadioButton4.setText("4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        numbersPanel.add(jRadioButton4, gridBagConstraints);

        jRadioButton5.setText("5");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        numbersPanel.add(jRadioButton5, gridBagConstraints);

        add(numbersPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jRadioButton4.setSelected(false);
            jRadioButton5.setSelected(false);
            manager.setEmotionVote(emotion,3);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton3StateChanged
        
    }//GEN-LAST:event_jRadioButton3StateChanged

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
            jRadioButton5.setSelected(false);
            manager.setEmotionVote(emotion,1);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jRadioButton5.setSelected(false);
        manager.setEmotionVote(emotion,2);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton5.setSelected(false);
        manager.setEmotionVote(emotion,4);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        manager.setEmotionVote(emotion,5);
    }//GEN-LAST:event_jRadioButton5ActionPerformed
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(750, 300);
        frame.setLayout(new BorderLayout());
        Emozioni emozione = Emozioni.AMAZEMENT;
        frame.add(emozione.buildVoteEmotionPanel());
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JPanel numbersPanel;
    // End of variables declaration//GEN-END:variables
}
