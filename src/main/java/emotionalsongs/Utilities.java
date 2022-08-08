
package emotionalsongs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Megaport
 */
public class Utilities {
    //campi statici
    
    //Path verso files
    static String pathToCanzoniDatiTxt = "../EMOTIONALSONGS/data/Canzoni.dati.txt";
    static String pathToEmozioniDati = "../EMOTIONALSONGS/data/Emozioni.dati.txt";
    static String pathToPlaylistDati = "../EMOTIONALSONGS/data/Playlist.dati.txt";
    static String pathToUserDatabase = "../EMOTIONALSONGS/data/UtentiRegistrati.dati.txt";
    
    //immagini
    public static ImageIcon logo = new ImageIcon("../EmotionalSongs/Risorse/EmotionalSongsLogo.png");
    public static ImageIcon loadingImageIcon = new ImageIcon("../EmotionalSongs/Risorse/LoadingPage.png");
    public static ImageIcon loadingImageIconInsubria = new ImageIcon("../EmotionalSongs/Risorse/LoadingPageInsubriaLogo.png");
    public static ImageIcon backGround = new ImageIcon("../EmotionalSongs/Risorse/BackGround.png");

    
    //Stringhe ricorrenti
    static String divisioreFinale = "_.-._.-._.-._.-._.-._.-._";
    static String comma = ",";
    static String semiColon = ";";
    static String separatorRepository = "<SEP>";
    public static Dimension LOADINGFRAMESIZE = new Dimension(832, 610);
    public static Font fontLoadingFrame;
    
    //dimensions
    
    static Dimension qHD = new Dimension(960, 540);
    public static Dimension HD = new Dimension(1280, 720);
    static Dimension fullHd = new Dimension(1920, 1080);
    static Dimension k2 = new Dimension(2048, 1080);
    static Dimension QuadHD = new Dimension(2560, 1440);
    static Dimension UHD = new Dimension(3840, 2160);
    static Dimension k4 = new Dimension(4096, 2160);
    static Dimension k5 = new Dimension(5120, 2880);
    static Dimension k8 = new Dimension(7680, 4320);
    
    //metodi ricorrenti
    /**
     * 
     * @return 
     */
    static boolean readYesOrNot(){
        System.out.println("Digiti 's' in caso affermativo, altrimenti digiti 'n' :");
        String scelta = new Scanner(System.in).nextLine();
        return scelta.toLowerCase().contains("s")? true:false;    
    }
    
    /**
     * 
     * @return 
     */
    static boolean richiestaUscita() {
        System.out.println("Vuole tornare al menu precedente? ");
        System.out.println("Digiti 's' in caso affermativo, altrimenti digiti 'n' :");
        String scelta = new Scanner(System.in).nextLine();
        return scelta.toLowerCase().contains("s")? true:false; 
    }
}
