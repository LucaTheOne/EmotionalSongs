package emotionalsongs;

import java.awt.*;
import javax.swing.*;

public class LoadingPage extends JPanel {
    private JLabel loadingLabel;

    public LoadingPage() {
        
        //Immagine di sfondo
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
        
        setLayout(null);

        //add components
        add (loadingLabel);
    }

    
    public static void main (String[] args) {
        JFrame frame = new JFrame ("EMOTIONALSONGS");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(Utilities.logo.getImage());
        frame.getContentPane().add (new LoadingPage());
        frame.pack();
        frame.setVisible (true);
    }
}

