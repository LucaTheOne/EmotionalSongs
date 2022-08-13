package emotionalsongs;


import java.awt.*;
import javax.swing.*;


/**
 *@hidden
 * @author Megaport
 */
public class Layout {
    
    public Dimension frameDimension;
    public Dimension upperBarDimension;
    
    public Dimension centerPanelDimension;
        public Dimension centerLeftPanelDimension;
    
        public Dimension centerRightPanelDimension;
            public Dimension lowerPartOfRepoView;
            public Dimension upperPartOfRepoView;
        public Dimension lowerBarDimension;
    
    
    public Dimension loadingFrameDimension = new Dimension(800,600);
    
    public Image mainFrameBG = Toolkit.getDefaultToolkit().getImage("../EmotionalSongs/Risorse/BackGround.png");
    public ImageIcon prova = new ImageIcon("../EmotionalSongs/Risorse/LoadingFrameBlack.png");
   
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
        lowerPartOfRepoView = new Dimension(centerLeftPanelDimension.width,(centerLeftPanelDimension.height)/5);
        upperPartOfRepoView = new Dimension(centerLeftPanelDimension.width/4,((centerLeftPanelDimension.height)/5)*4);
    }
    
    private Dimension adaptedDimension(Dimension d){
        
        Dimension x = new Dimension(d.width,d.height-40);
        return x;
    }
    
    
}

