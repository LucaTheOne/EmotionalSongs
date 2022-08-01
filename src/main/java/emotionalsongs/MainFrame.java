/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Megaport
 */
public class MainFrame extends Window {
    
    JFrame mainFrame;
    JPanel basePanel;
    JPanel staticPanel;
    JPanel dinamicPanel;
    JPanel centerPanel;
    JPanel upperBar;
    JPanel lowerBar;
    JLabel background = new JLabel(Utilities.backGround);
    
    Dimension frameDimension = new Dimension(1024, 780);
    Dimension upperBarDimension = new Dimension(frameDimension.width,frameDimension.height/38);
    Dimension lowerBarDimension = new Dimension(frameDimension.width,5);
    Dimension staticPanelDimension = new Dimension((frameDimension.width/7)*3,frameDimension.height-upperBarDimension.height-lowerBarDimension.height);
    Dimension dinamicPanelDimension = new Dimension((frameDimension.width/7)*4,frameDimension.height-upperBarDimension.height-lowerBarDimension.height);
    
    public void setFrame() {
        mainFrame = new JFrame("EMOTIONALSONGS");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(Utilities.logo.getImage());
        mainFrame.setSize(frameDimension);
        mainFrame.setLayout(new BorderLayout()); 
        setBasePanel();
        mainFrame.add(basePanel);
 
        mainFrame.setVisible(true);
        
    }
    
    public void setBackground(){
        
    }
    
    public void setBasePanel(){
        basePanel = new JPanel();
        basePanel.setPreferredSize(frameDimension);
        basePanel.setLayout(new BorderLayout(1,1));
        setCenterPanel();
        setUpperBar();
        setLowerBar();
        
        basePanel.add(upperBar, BorderLayout.NORTH);
        basePanel.add(centerPanel,BorderLayout.CENTER);
        basePanel.add(lowerBar,BorderLayout.SOUTH);   
    }
    
    public void setCenterPanel(){
        centerPanel = new JPanel();
        setStaticPanel();
        setDinamicPanel();
        background.setPreferredSize(frameDimension);
        centerPanel.add(background, BorderLayout.CENTER);
        
        centerPanel.add(staticPanel,BorderLayout.WEST);
        centerPanel.add(dinamicPanel,BorderLayout.CENTER);
        centerPanel.setOpaque(false);

    }
    
    public void setStaticPanel(){
        staticPanel = new JPanel();
        staticPanel.setPreferredSize(staticPanelDimension);
        staticPanel.setBackground(Color.orange);
        staticPanel.setOpaque(false);
    }
    
    public void setDinamicPanel(){
        dinamicPanel = new JPanel();
        dinamicPanel.setPreferredSize(dinamicPanelDimension);
        dinamicPanel.setBackground(Color.CYAN);
        dinamicPanel.setOpaque(false);
    }
    
    public void setUpperBar(){
        upperBar = new JPanel();
        upperBar.setPreferredSize(upperBarDimension);
        upperBar.setBackground(Color.pink);
        upperBar.setOpaque(false);
    }

    public void runWindow() {
        setFrame();
    }
    
    public void closeWindow(){
        
    }

    private void setLowerBar() {
        lowerBar = new JPanel();
        lowerBar.setPreferredSize(lowerBarDimension);
        lowerBar.setBackground(Color.black);
    }
   
}
