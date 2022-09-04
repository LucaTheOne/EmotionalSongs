package emotionalsongs;


import java.awt.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Megaport
 */
public class GUIMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public GUIMainFrame() {
        
        initComponents();
        
        setLeftPanel(new GUIMenuLeftVoid(this));
        setUpperBar(new GUIMainUpperBarUnloggedPanel(this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        globalPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(Utilities.mainBackGround.getImage(), 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }
        };
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        upperBar = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        lowerBarStatusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmotionalSongs");
        setAutoRequestFocus(false);
        setIconImage(Utilities.logo.getImage());
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("mainPageFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setSize(new java.awt.Dimension(1000, 700));

        globalPanel.setLayout(new java.awt.BorderLayout());

        leftPanel.setPreferredSize(new java.awt.Dimension(0, 659));
        leftPanel.setLayout(new java.awt.BorderLayout());
        globalPanel.add(leftPanel, java.awt.BorderLayout.WEST);

        rightPanel.setPreferredSize(new java.awt.Dimension(0, 659));
        rightPanel.setLayout(new java.awt.BorderLayout());
        globalPanel.add(rightPanel, java.awt.BorderLayout.EAST);

        upperBar.setPreferredSize(new java.awt.Dimension(1000, 0));
        upperBar.setLayout(new java.awt.BorderLayout());
        globalPanel.add(upperBar, java.awt.BorderLayout.NORTH);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());
        globalPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        lowerBarStatusLabel.setBackground(new java.awt.Color(0, 0, 0));
        lowerBarStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        lowerBarStatusLabel.setText("EmotionalSongs ");
        lowerBarStatusLabel.setOpaque(true);
        globalPanel.add(lowerBarStatusLabel, java.awt.BorderLayout.SOUTH);
        lowerBarStatusLabel.getAccessibleContext().setAccessibleName("LowerBarStatusLabel");

        getContentPane().add(globalPanel, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel globalPanel;
    public javax.swing.JPanel leftPanel;
    private javax.swing.JLabel lowerBarStatusLabel;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JPanel rightPanel;
    public javax.swing.JPanel upperBar;
    // End of variables declaration//GEN-END:variables

    void update() {
        revalidate();
        repaint();
    }
    
    public void setLeftPanel(JPanel newLeftPanel){
        leftPanel.removeAll();
        leftPanel.setPreferredSize(new Dimension(newLeftPanel.getPreferredSize()));
        leftPanel.add(newLeftPanel,BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void setUpperBar(JPanel newUpperBar){
        upperBar.removeAll();
        upperBar.setPreferredSize(new Dimension(newUpperBar.getPreferredSize()));
        upperBar.add(newUpperBar,BorderLayout.CENTER);
        revalidate();
        repaint(); 
    }
    
    public void setMainPanel(JPanel newMainPanel){
        mainPanel.removeAll();
        mainPanel.add(newMainPanel,BorderLayout.CENTER);
        mainPanel.setOpaque(true);
        newMainPanel.setVisible(true);
        revalidate();
        repaint();
    }
    
    public void cleanUpMainPanel(){
        mainPanel.removeAll();
        mainPanel.setOpaque(false);
        revalidate();
        repaint();
    }

    void updateView() {
        revalidate();
        repaint();
    }
}
