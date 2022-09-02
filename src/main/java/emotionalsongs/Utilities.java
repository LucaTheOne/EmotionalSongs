
package emotionalsongs;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
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
    public static ImageIcon mainBackGround = new ImageIcon("../EmotionalSongs/Risorse/mainBackground.png");
    public static ImageIcon searchIcon = new ImageIcon("../EmotionalSongs/Risorse/IconaRicerca.png");
    public static ImageIcon backButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/BackButton.png");
    public static ImageIcon nextButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/NextButton.png");  
    public static ImageIcon spaceImage = new ImageIcon("../EmotionalSongs/Risorse/space.png");
    public static ImageIcon logingBG = new ImageIcon("../EmotionalSongs/Risorse/LoginBG.png");
    public static ImageIcon regBG = new ImageIcon("../EmotionalSongs/Risorse/RegBg.png");
    public static ImageIcon chartButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/chartButton.png");
    public static ImageIcon regIcon = new ImageIcon("../EmotionalSongs/Risorse/RegIcon.png");
    public static ImageIcon clearButtonIcon = new ImageIcon("../EmotionalSongs/Risorse/ClearButtonIcon.png");
    public static ImageIcon closeButton = new ImageIcon("../EmotionalSongs/Risorse/CloseButton.png");
    
    
//Stringhe ricorrenti
    static String divisioreFinale = "_.-._.-._.-._.-._.-._.-._";
    static String comma = ",";
    static String commaSpace = ", ";
    static String semiColon = ";";
    static String separatorRepository = "<SEP>";
    public static Dimension LOADINGFRAMESIZE = new Dimension(832, 610);
    public static Font fontLoadingFrame;
    
// metodi
    public static String capitalize(String str){
        if(str == null || str.length()<=1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static long countLines(String fileName) {
        
      Path path = Paths.get(fileName);
      long lines = 0;
      try {
          lines = Files.lines(path).count();

        } catch (IOException e) {
          e.printStackTrace();
        }

        return lines;
        
    }
    
}
