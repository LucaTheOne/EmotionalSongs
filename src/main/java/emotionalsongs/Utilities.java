
package emotionalsongs;

import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Megaport
 */
public class Utilities {
    //campi statici
    
    //Path verso files
    static String pathToCanzoniDatiTxt = "../EMOTIONALSONGS/data/Canzoni.dati.txt";
    static String pathToEmozioniDati = "../EMOTIONALSONGS/data/Emozioni.dati.csv";
    static String pathToPlaylistDati = "../EMOTIONALSONGS/data/Canzoni.dati.txt";
    static String pathToUserDatabase = "../EMOTIONALSONGS/data/UtentiRegistrati.dati.csv";
    
    //immagini
    static ImageIcon logo = new ImageIcon("../EmotionalSongs/Risorse/EmotionalSongsLogo.png");
    static ImageIcon loadingImageIcon = new ImageIcon("../EmotionalSongs/Risorse/LoadingPage.png");
    
    static String divisioreFinale = "_.-._.-._.-._.-._.-._.-._";
    
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
