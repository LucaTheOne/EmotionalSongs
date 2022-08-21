package emotionalsongs;


import java.awt.*;
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
    }
    
    private void setFrame(){
        Layout layout = new Layout();
        backGround = layout.prova.getImage();
        loadingFrame.setSize(layout.loadingFrameDimension);
        loadingFrame.setBackground(Color.black);
        loadingFrame.setResizable(false);
        loadingFrame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        loadingFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loadingFrame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backGround,0,0,790,560, null);
         }
        });
        
        loadingFrame.setTitle("EMOTIONALSONGS 🎵");
        loadingFrame.setIconImage(Utilities.logo.getImage());
        loadingFrame.add(new JLabel());
        loadingFrame.setVisible(true);
    }
}
