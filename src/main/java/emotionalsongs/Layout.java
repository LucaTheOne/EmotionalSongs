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

    Dimension QVGA = new Dimension(320,240);
    Dimension HVGA = new Dimension(480,320);
    Dimension WVGA = new Dimension(800,480);
    Dimension FWVGA = new Dimension(854,480);
    Dimension qHD = new Dimension(960, 540); //<-
    Dimension WSVGA = new Dimension(1024,600);
    Dimension XGA = new Dimension(1024,768);
    Dimension HD = new Dimension(1280, 720); //<-
    Dimension WXGA = new Dimension(1280,800);
    Dimension fullHD = new Dimension(1920, 1080); //<-
    Dimension WUXGA = new Dimension(1920,1200);
    Dimension k2 = new Dimension(2048, 1080);
    Dimension QuadHD = new Dimension(2560, 1440);
    Dimension WQXGA = new Dimension(2560,1600); //<-
    Dimension UHD = new Dimension(3840, 2160); //<-
    Dimension WQUXGA = new Dimension(3840, 2400);
    Dimension k4 = new Dimension(4096, 2560); //<-
    Dimension k5 = new Dimension(5120, 2880);
    Dimension k8 = new Dimension(7680, 4320);
    Dimension k16 = new Dimension(15360, 8640);


    public Dimension frameDimension;
    public Dimension upperBarDimension;
    public Dimension centerLeftPanelDimension;
    public Dimension centerRightPanelDimension;
    public Dimension lowerBarDimension;
    public Dimension centerPanelDimension;

    public Image backGrImage;


    public Layout(Dimension frameDimension) {
        this.frameDimension =new Dimension(frameDimension.width,frameDimension.height-35);
        //apropriateBackground(frameDimension);
        int widthFrame = this.frameDimension.width;
        int heightFrame = this.frameDimension.height;

        upperBarDimension = new Dimension(widthFrame,heightFrame/36);

        upperBarDimension = new Dimension(widthFrame,heightFrame/40);
        lowerBarDimension = new Dimension(widthFrame,heightFrame/90);
        centerLeftPanelDimension = new Dimension(widthFrame/8,heightFrame-(upperBarDimension.height+lowerBarDimension.height));
        centerRightPanelDimension = new Dimension(widthFrame-centerLeftPanelDimension.width,heightFrame-(upperBarDimension.height+lowerBarDimension.height));
        centerPanelDimension = new Dimension(widthFrame,heightFrame-(upperBarDimension.height+lowerBarDimension.height));
    }

    private void apropriateBackground(Dimension d1){
        if (lowerDimension(d1, HD)) {/*imposta immagine di background relativa alla risoluzione*/}
        else if (equalDimensions(HD, d1)){/*imposta immagine di background relativa alla risoluzione*/}
        else if (lowerDimension(d1, fullHD)){/*imposta immagine di background relativa alla risoluzione*/}
        else if (equalDimensions(fullHD, d1)){/*imposta immagine di background relativa alla risoluzione*/}
        else if (lowerDimension(d1, WQXGA)){}
    }

    private boolean equalDimensions(Dimension d1, Dimension d2){
        return d1.width==d2.width && d1.height==d2.height;
    }

    private boolean lowerDimension(Dimension d1, Dimension d2){
        return d1.width < d2.width || d1.width == d2.width && d1.height<d2.height;
    }

}
