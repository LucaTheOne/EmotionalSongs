//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs;

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
    public static String pathToCanzoniDatiTxt = "../EMOTIONALSONGS/data/Canzoni.dati.txt";
    public static String pathToEmozioniDati = "../EMOTIONALSONGS/data/Emozioni.dati.txt";
    public static String pathToPlaylistDati = "../EMOTIONALSONGS/data/Playlist.dati.txt";
    public static String pathToUserDatabase = "../EMOTIONALSONGS/data/UtentiRegistrati.dati.txt";
    
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
    public static ImageIcon SongViewIcon = new ImageIcon("../EmotionalSongs/Risorse/SongViewBorder.png");
    public static ImageIcon RepoBgIcon = new ImageIcon("../EmotionalSongs/Risorse/RepoBG.png");
    public static ImageIcon CreditsIcon = new ImageIcon("../EmotionalSongs/Risorse/CREDITS.jpg");
    
//Stringhe ricorrenti
    public static String comma = ",";
    public static String commaSpace = ", ";
    public static String semiColon = ";";
    public static String separatorRepository = "<SEP>";
    
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
