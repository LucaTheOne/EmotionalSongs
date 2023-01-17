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
    //campi inetrni privati
    private static String osFileSeparator = FileSystems.getDefault().getSeparator();
    private static String basePath = generateBasePath();
    //private static String osFileSeparator = FileSystems.getDefault().getSeparator();
    //campi statici
    
    //Path verso files

    public static String pathToCanzoniDatiTxt =basePath +  osFileSeparator+"data"+osFileSeparator+"Canzoni.dati.txt";
    public static String pathToEmozioniDati = basePath + osFileSeparator +"data" +osFileSeparator+"Emozioni.dati.txt";
    public static String pathToPlaylistDati = basePath + osFileSeparator +"data" +osFileSeparator+"Playlist.dati.txt";
    public static String pathToUserDatabase = basePath + osFileSeparator +"data" +osFileSeparator+"UtentiRegistrati.dati.txt";
    
    //immagini
    public static ImageIcon logo = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"EmotionalSongsLogo.png");
    public static ImageIcon loadingFrame = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"LoadingFrameWhite.png");
    public static ImageIcon mainBackGround = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"mainBackground.png");
    public static ImageIcon searchIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"IconaRicerca.png");
    public static ImageIcon backButtonIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"BackButton.png");
    public static ImageIcon nextButtonIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"NextButton.png");  
    public static ImageIcon logingBG = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"LoginBG.png");
    public static ImageIcon regBG = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"RegBg.png");
    public static ImageIcon regIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"RegIcon.png");
    public static ImageIcon clearButtonIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"ClearButtonIcon.png");
    public static ImageIcon closeButton = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"CloseButton.png");
    public static ImageIcon SongViewIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"SongViewBorder.png");
    public static ImageIcon RepoBgIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"RepoBG.png");
    public static ImageIcon CreditsIcon = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"CREDITS.jpg");
    
// metodi
    public static String capitalize(String str){
        if(str == null || str.length()<=1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    private static String generateBasePath(){
        String stringPath = new File(System.getProperty("user.dir")).getParent();
        stringPath += stringPath.endsWith((osFileSeparator+"EmotionalSongs")) ? "" : (osFileSeparator+"EmotionalSongs");
        
        return stringPath;
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
