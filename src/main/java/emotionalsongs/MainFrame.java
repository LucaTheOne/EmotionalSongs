package emotionalsongs;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {
    JPanel upperBar;
    JPanel centerPanel;
    JPanel lowerBar;
    JButton b1 = new JButton("Bottone");
    JButton b2 = new JButton("Bottone");
    JButton b3 = new JButton("Bottone");
    JButton b4 = new JButton("Bottone");
    JButton b5 = new JButton("Bottone");
    JButton b6 = new JButton("Bottone");
    Layout layout = new Layout();
    
    Image img = layout.mainFrameBG;
    
    public MainFrame() throws IOException {
        setPreferredSize(layout.frameDimension);
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0,layout.frameDimension.width,layout.frameDimension.height, null);
         }
        });
        
        setTitle("EMOTIONALSONGS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Utilities.logo.getImage());
        setLayout(new BorderLayout());

        
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
        
        JPanel left = new JPanel(new GridLayout(6,1));
        JPanel right = new JPanel();
        
        left.setPreferredSize(layout.centerLeftPanelDimension);
        left.setBackground(Color.PINK);
        left.setOpaque(false);
        left.add(b1);
        left.add(b2);
        left.add(b3);
        left.add(b4);
        left.add(b5);
        left.add(b6);
        
        right.setLayout(new BorderLayout());
        right.add(new inspectRepoPanel(),BorderLayout.CENTER);
        
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