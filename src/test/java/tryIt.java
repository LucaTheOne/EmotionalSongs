
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author big
 */
public class tryIt {
    public static void main(String[] args) {
      
        JFrame frame = new JFrame();
        frame.setSize(100, 100);
        frame.setVisible(true);
        System.out.println(frame.isVisible());
        frame.dispose();
        System.out.println(frame.isVisible());
    }
}
