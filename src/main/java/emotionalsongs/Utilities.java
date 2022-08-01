
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
    static ImageIcon loadingImageIcon = new ImageIcon("../EmotionalSongs/Risorse/LoadingPage.png");
    public static ImageIcon loadingImageIconInsubria = new ImageIcon("../EmotionalSongs/Risorse/LoadingPageInsubriaLogo.png");
    static ImageIcon backGround = new ImageIcon("../EmotionalSongs/Risorse/BackGround.png");

    
    //Stringhe ricorrenti
    static String divisioreFinale = "_.-._.-._.-._.-._.-._.-._";
    static String comma = ",";
    static String semiColon = ";";
    static String separatorRepository = "<SEP>";
    public static Dimension LOADINGFRAMESIZE = new Dimension(832, 610);
    public static Font fontLoadingFrame;
    
    
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
