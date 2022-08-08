package emotionalsongs;


import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Megaport
 */
public class Layout {
    
    public Dimension frameDimension;
    public Dimension upperBarDimension;
    public Dimension centerLeftPanelDimension;
    public Dimension centerRightPanelDimension;
    public Dimension lowerBarDimension;
    public Dimension centerPanelDimension;
    public Dimension loadingFrameDimension = new Dimension(800,600);
    public Image mainFrameBG = Toolkit.getDefaultToolkit().getImage("../EmotionalSongs/Risorse/BackGround.png");
    public Image loadingFrameBG = Toolkit.getDefaultToolkit().getImage("../EmotionalSongs/Risorse/LoadingPage.png");

    public Layout() {
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frameDimension = adaptedDimension(monitorSize);
        int widthFrame = this.frameDimension.width;
        int heightFrame = this.frameDimension.height;

        upperBarDimension = new Dimension(widthFrame,heightFrame/36);

        upperBarDimension = new Dimension(widthFrame,heightFrame/40);
        lowerBarDimension = new Dimension(widthFrame,heightFrame/90);
        centerLeftPanelDimension = new Dimension(widthFrame/8,heightFrame-(upperBarDimension.height+lowerBarDimension.height));
        centerRightPanelDimension = new Dimension(widthFrame-centerLeftPanelDimension.width,heightFrame-(upperBarDimension.height+lowerBarDimension.height));
        centerPanelDimension = new Dimension(widthFrame,heightFrame-(upperBarDimension.height+lowerBarDimension.height));
    }
    
    private Dimension adaptedDimension(Dimension d){
        
        Dimension x = new Dimension(d.width,d.height-40);
        return x;
    }
    
    
}
