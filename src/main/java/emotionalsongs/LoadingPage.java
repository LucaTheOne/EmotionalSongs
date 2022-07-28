package emotionalsongs;

import java.awt.*;
import javax.swing.*;

public class LoadingPage extends JPanel {
<<<<<<< Updated upstream
    private JLabel loadingLabel;
=======
    public static JLabel loadingFrameLabel;
>>>>>>> Stashed changes

    public LoadingPage() {
        
        //Immagine di sfondo
<<<<<<< Updated upstream
        loadingLabel.setIcon(Utilities.loadingImageIcon);
        loadingLabel.setBackground(Color.BLACK);
        loadingLabel.setOpaque(true);
        loadingLabel.setBounds(0, 0, 802, 572);
        loadingLabel.setText("Caricamento...");
        loadingLabel.setForeground(Color.WHITE);
        loadingLabel.setHorizontalTextPosition(JLabel.CENTER);
        loadingLabel.setVerticalTextPosition(JLabel.BOTTOM);
        loadingLabel.setIconTextGap(2);
        loadingLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        loadingLabel.setVisible(true);
        setPreferredSize (new Dimension (802,572));
=======
        loadingFrameLabel = new JLabel();
        loadingFrameLabel.setIcon(Utilities.loadingImageIcon);
        loadingFrameLabel.setBackground(Color.BLACK);
        loadingFrameLabel.setOpaque(true);
        loadingFrameLabel.setBounds(0, 0, 802, 572);
        loadingFrameLabel.setText("Caricamento...");
        loadingFrameLabel.setForeground(Color.WHITE);
        loadingFrameLabel.setHorizontalTextPosition(JLabel.CENTER);
        loadingFrameLabel.setVerticalTextPosition(JLabel.BOTTOM);
        loadingFrameLabel.setIconTextGap(2);
        loadingFrameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        loadingFrameLabel.setVisible(true);
        setPreferredSize (new Dimension (802,571));
>>>>>>> Stashed changes
        
        setLayout(null);

        //add components
<<<<<<< Updated upstream
        add (loadingLabel);
    }

    
    public static void main (String[] args) {
=======
        add (loadingFrameLabel);
    }
    
    public static void runPage(){
>>>>>>> Stashed changes
        JFrame frame = new JFrame ("EMOTIONALSONGS");
        frame.setCursor(Cursor.WAIT_CURSOR);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(Utilities.logo.getImage());
        frame.getContentPane().add (new LoadingPage());
        frame.pack();
        frame.setVisible (true);
        
    }
}

