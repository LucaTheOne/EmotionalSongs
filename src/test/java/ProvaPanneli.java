
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Megaport
 */
public class ProvaPanneli {
    
    public void paintComponent(Graphics g) {
        Image img = new ImageIcon("../EmotionalSongs/Risorse/BackGround.png").getImage();
        g.drawImage(img, 0, 0, Color.graygetWidth(), getHeight(), this); // draw the image
    }
}
