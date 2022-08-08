package emotionalsongs;


import emotionalsongs.Window;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Megaport
 */
public class LoadingFrame extends Window{
    static JLabel loadingPageLabel = new JLabel(Utilities.loadingImageIconInsubria);
    JFrame loadingFrame = new JFrame();
    Image scaledImage = Toolkit.getDefaultToolkit().getImage("../EmotionalSongs/Risorse/LoadingPage.png")/*.getScaledInstance(800,550,Image.SCALE_SMOOTH)*/;
    public void runWindow(){
        setFrame();
    }
    /*
    public void setLabel(){
        loadingPageLabel.setText("Caricamento...");
        loadingPageLabel.setForeground(Color.WHITE);
        loadingPageLabel.setHorizontalTextPosition(JLabel.CENTER);
        loadingPageLabel.setVerticalTextPosition(JLabel.BOTTOM);
        loadingPageLabel.setVerticalAlignment(JLabel.BOTTOM);
        loadingPageLabel.setIconTextGap(1);
        loadingPageLabel.setBackground(Color.BLACK);
        loadingPageLabel.setOpaque(true);
        loadingPageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
    */
    private void setFrame(){
        loadingFrame.setSize(800,576);
        loadingFrame.setResizable(false);
        loadingFrame.setCursor(Cursor.WAIT_CURSOR);
        loadingFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loadingFrame.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaledImage, 0, 0, null);
         }
        });
        loadingFrame.setTitle("EMOTIONALSONGS 🎵");
        loadingFrame.setIconImage(Utilities.logo.getImage());
        loadingFrame.add(loadingPageLabel);
        loadingFrame.add(new JLabel());
        loadingFrame.setVisible(true);
    }
    
    public static void setText(String testo){
       loadingPageLabel.setText(testo);
    }
    
    public void closeWindow(){
        loadingFrame.setVisible(false);
        loadingFrame.dispose();
    }
}
