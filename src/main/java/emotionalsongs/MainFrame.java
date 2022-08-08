package emotionalsongs;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {
    JPanel upperBar;
    JPanel centerPanel;
    JPanel lowerBar;
    Layout layout = new Layout();
    
    Image img = Toolkit.getDefaultToolkit().getImage("../EmotionalSongs/Risorse/BackGround.png");
    Image scaledImage = img.getScaledInstance(layout.frameDimension.width,layout.frameDimension.height,Image.SCALE_SMOOTH);
    public MainFrame() throws IOException {
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaledImage, 0, 0, null);
         }
        });
        
        setTitle("EMOTIONALSONGS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Utilities.logo.getImage());
        setLayout(new BorderLayout());
        setPreferredSize(layout.frameDimension);
        
        setUpperBar();
        setCenterPanel();
        setLowerBar();
        
        add(upperBar,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
        add(lowerBar,BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public void setUpperBar() {
        upperBar = new JPanel();
        upperBar.setPreferredSize(layout.upperBarDimension);
        upperBar.setBackground(Color.red);
        upperBar.setOpaque(true);
    }
    
    public void setCenterPanel(){
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setPreferredSize(layout.centerPanelDimension);
        JPanel left = new JPanel(new GridLayout());
        JPanel right = new JPanel();
        
        left.setPreferredSize(layout.centerLeftPanelDimension);
        left.setBackground(Color.PINK);
        left.setOpaque(false);
        
        right.setPreferredSize(layout.centerRightPanelDimension);
        right.setBackground(Color.GREEN);
        right.setOpaque(false);
        
        centerPanel.add(left,BorderLayout.WEST);
        centerPanel.add(right,BorderLayout.CENTER);
        centerPanel.setOpaque(false);
        
    }
    
    public void setLowerBar(){
        lowerBar = new JPanel();
        lowerBar.setPreferredSize(layout.lowerBarDimension);
        lowerBar.setBackground(Color.black);
        lowerBar.setOpaque(true);
    }
    
    public static void run() throws IOException {
        new MainFrame();
    }
}