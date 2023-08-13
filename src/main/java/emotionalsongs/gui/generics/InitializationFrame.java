/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.gui.generics;


import emotionalsongs.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Classe le cui istanze mostrano l' immagine di caricamento del software.
 */
public class InitializationFrame extends javax.swing.JFrame {

    /**
     * Crea il pannello di caricamento del software.
     */
    public InitializationFrame() {
        setUndecorated(true);
        initComponents();
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG = new javax.swing.JPanel();
        BGLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setIconImage(new ImageIcon("../EmotionalSongs/Risorse/EmotionalSongsLogo.png").getImage());
        setResizable(false);
        setShape(new RoundRectangle2D.Double(0, 0, 790, 560, 20, 20)
        );
        setSize(new java.awt.Dimension(790, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BG.setBackground(new java.awt.Color(0, 0, 0));
        BG.setMaximumSize(new java.awt.Dimension(790, 560));
        BG.setMinimumSize(new java.awt.Dimension(790, 560));

        BGLabel.setBackground(new java.awt.Color(255, 255, 255));
        BGLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BGLabel.setIcon(ClientUtilities.loadingFrame);
        BGLabel.setToolTipText("");
        BGLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        BGLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        BGLabel.setMaximumSize(new java.awt.Dimension(790, 560));
        BGLabel.setMinimumSize(new java.awt.Dimension(790, 560));
        BGLabel.setOpaque(true);
        BGLabel.setPreferredSize(new java.awt.Dimension(790, 560));
        BGLabel.setRequestFocusEnabled(false);
        BGLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout BGLayout = new javax.swing.GroupLayout(BG);
        BG.setLayout(BGLayout);
        BGLayout.setHorizontalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BGLayout.setVerticalGroup(
            BGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BGLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.JLabel BGLabel;
    // End of variables declaration//GEN-END:variables
}
