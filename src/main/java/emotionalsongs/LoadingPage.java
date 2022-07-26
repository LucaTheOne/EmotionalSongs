package emotionalsongs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class LoadingPage extends JPanel {
    private JLabel logingLabel;

    public LoadingPage() {
        
        //Immagine di sfondo
        logingLabel = new JLabel ("Caricamento");
        logingLabel.setIcon(Utilities.loadingImageIcon);
        logingLabel.setBackground(Color.BLACK);
        logingLabel.setOpaque(true);
        logingLabel.setBounds(0, 0, 802, 572);
        logingLabel.setText("Caricamento");
        logingLabel.setForeground(Color.WHITE);
        logingLabel.setHorizontalTextPosition(JLabel.CENTER);
        //logingLabel.setHorizontalAlignment(JLabel.LEFT);
        logingLabel.setVerticalTextPosition(JLabel.BOTTOM);
        logingLabel.setVerticalAlignment(JLabel.TOP);
        logingLabel.setIconTextGap(2);
        logingLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
        logingLabel.setVisible(true);
        setPreferredSize (new Dimension (802,571));
        
        setLayout(null);

        //add components
        add (logingLabel);
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