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

    private static String basePath = generateBasePath();//System.getProperty("user.dir");
    
    //campi statici
    
    //Path verso files

    public static String pathToCanzoniDatiTxt = basePath + "/data/Canzoni.dati.txt";
    public static String pathToEmozioniDati = basePath + "/data/Emozioni.dati.txt";
    public static String pathToPlaylistDati = basePath + "/data/Playlist.dati.txt";
    public static String pathToUserDatabase = basePath + "/data/UtentiRegistrati.dati.txt";
    
    //immagini
    public static ImageIcon logo = new ImageIcon(basePath+"/Risorse/EmotionalSongsLogo.png");
    public static ImageIcon loadingImageIcon = new ImageIcon(basePath+"/Risorse/LoadingFrameWhite.png");
    public static ImageIcon loadingImageIconInsubria = new ImageIcon(basePath+"/Risorse/LoadingFrameWhite.png");
    public static ImageIcon mainBackGround = new ImageIcon(basePath+"/Risorse/mainBackground.png");
    public static ImageIcon searchIcon = new ImageIcon(basePath+"/Risorse/IconaRicerca.png");
    public static ImageIcon backButtonIcon = new ImageIcon(basePath+"/Risorse/BackButton.png");
    public static ImageIcon nextButtonIcon = new ImageIcon(basePath+"/Risorse/NextButton.png");  
    public static ImageIcon spaceImage = new ImageIcon(basePath+"/Risorse/space.png");
    public static ImageIcon logingBG = new ImageIcon(basePath+"/Risorse/LoginBG.png");
    public static ImageIcon regBG = new ImageIcon(basePath+"/Risorse/RegBg.png");
    public static ImageIcon chartButtonIcon = new ImageIcon(basePath+"/Risorse/chartButton.png");
    public static ImageIcon regIcon = new ImageIcon(basePath+"/Risorse/RegIcon.png");
    public static ImageIcon clearButtonIcon = new ImageIcon(basePath+"/Risorse/ClearButtonIcon.png");
    public static ImageIcon closeButton = new ImageIcon(basePath+"/Risorse/CloseButton.png");
    public static ImageIcon SongViewIcon = new ImageIcon(basePath+"/Risorse/SongViewBorder.png");
    public static ImageIcon RepoBgIcon = new ImageIcon(basePath+"/Risorse/RepoBG.png");
    public static ImageIcon CreditsIcon = new ImageIcon(basePath+"/Risorse/CREDITS.jpg");
    
// metodi
    public static String capitalize(String str){
        if(str == null || str.length()<=1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    private static String generateBasePath(){
        String stringPath = new File(System.getProperty("user.dir")).getParent();
        stringPath += stringPath.contains("/EmotionalSongs")?"":"/EmotionalSongs";
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
