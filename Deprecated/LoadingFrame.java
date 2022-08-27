package emotionalsongs;


import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

/**
 *@hidden
 * @author Megaport
 */
public class LoadingFrame {
    JFrame loadingFrame = new JFrame();
    Image backGround;
    public void runWindow(){
        setFrame();
        loadingFrame.setVisible(true);
    }
    
    private void setFrame(){
        loadingFrame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backGround,0,0,790,560, null);
         }
        });
        loadingFrame.setSize(new Dimension(790, 560));
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setUndecorated(true);
        loadingFrame.setShape(new RoundRectangle2D.Double(0, 0, 790, 560, 20, 20));
        loadingFrame.setBackground(Color.black);
        loadingFrame.setResizable(false);
        loadingFrame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        loadingFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        
        loadingFrame.setTitle("EMOTIONALSONGS 🎵");
        loadingFrame.setIconImage(new ImageIcon("../EmotionalSongs/Risorse/EmotionalSongsLogo.png").getImage());
        loadingFrame.add(new JLabel());
        loadingFrame.setVisible(true);
    }
}
