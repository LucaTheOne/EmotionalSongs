package emotionalsongs;


import emotionalsongs.Window;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Megaport
 */
public class LoadingFrame extends Window{
    JFrame loadingFrame = new JFrame();
    Image backGround;
    public void runWindow(){
        setFrame();
    }
    
    private void setFrame(){
        Layout layout = new Layout();
        backGround = layout.loadingFrameBG;
        loadingFrame.setSize(layout.loadingFrameDimension);
        loadingFrame.setBackground(Color.black);
        loadingFrame.setResizable(false);
        loadingFrame.setCursor(Cursor.WAIT_CURSOR);
        loadingFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loadingFrame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backGround,0,0,800,560, null);
         }
        });
        
        loadingFrame.setTitle("EMOTIONALSONGS 🎵");
        loadingFrame.setIconImage(Utilities.logo.getImage());
        loadingFrame.add(new JLabel());
        loadingFrame.setVisible(true);
    }
    
    public void closeWindow(){
        loadingFrame.setVisible(false);
        loadingFrame.dispose();
    }
}
