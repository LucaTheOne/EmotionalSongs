
package emotionalsongs;

import java.awt.*;
import java.util.*;
import javax.swing.*;

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
    public static ImageIcon searchIcon = new ImageIcon("../EmotionalSongs/Risorse/IconaRicerca.png");
    public static ImageIcon backButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/BackButton.png");
    public static ImageIcon nextButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/NextButton.png");  
    public static ImageIcon CreditsButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/Credits.png");
    public static ImageIcon EngFlagButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/EngFlag.png");
    public static ImageIcon ItaFlagButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/ItaFlag.png");
    public static ImageIcon EngLoginButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/EngLogin.png");
    public static ImageIcon ItaLoginButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/ItaLogin.png");
    public static ImageIcon EngRegButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/RegEng.png");
    public static ImageIcon ItaRegButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/RegIta.png");
    public static ImageIcon spaceImage = new ImageIcon("../EmotionalSongs/Risorse/space.png");
    public static ImageIcon logingBG = new ImageIcon("../EmotionalSongs/Risorse/LoginBG.png");
    
//Stringhe ricorrenti
    static String divisioreFinale = "_.-._.-._.-._.-._.-._.-._";
    static String comma = ",";
    static String commaSpace = ", ";
    static String semiColon = ";";
    static String separatorRepository = "<SEP>";
    public static Dimension LOADINGFRAMESIZE = new Dimension(832, 610);
    public static Font fontLoadingFrame;
    
    //dimensions
    public static Dimension FRAMESTARTDIMENSION = new Dimension(((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth())-80,((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-80);
    
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
