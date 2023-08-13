/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.gui.generics;
import emotionalsongs.*;
import java.awt.*;

/**
 * Classe le cui istanze mostrano il pannello dei crediti e ringraziamenti.
 */
public class CreditsPanel extends javax.swing.JPanel {

    /**
     * Crea il pannello dei crediti e ringraziamenti.
     */
    public CreditsPanel() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
        @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(ClientUtilities.CreditsIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
