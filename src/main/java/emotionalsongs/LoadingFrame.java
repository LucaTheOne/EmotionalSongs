package emotionalsongs;


import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Megaport
 */
public class LoadingFrame extends Window{
    static JLabel loadingPageLabel = new JLabel(Utilities.loadingImageIconInsubria);
    JFrame loadingFrame = new JFrame();

    public void runWindow(){
        setFrame();
        setLabel();
        
    }
    
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
    
    private void setFrame(){
        loadingFrame.setSize(818,608);
        loadingFrame.setResizable(false);
        loadingFrame.setCursor(Cursor.WAIT_CURSOR);
        loadingFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        loadingFrame.setTitle("EMOTIONALSONGS 🎵");
        loadingFrame.setIconImage(Utilities.logo.getImage());
        loadingFrame.setTitle("EMOTIONALSONGS 🎵");
        loadingFrame.setIconImage(Utilities.logo.getImage());
        loadingFrame.add(loadingPageLabel);
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
