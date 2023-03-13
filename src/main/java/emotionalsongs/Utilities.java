//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs;

import emotionalsongs.gui.allerter.PopUpAllert;
import java.awt.image.*;
import java.io.*;
import java.nio.file.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * 
 * Classe statica contenente i percorsi per giungere ai file sorgente 
 * cui si appoggia il software e le immagini che sfrutta per costruire
 * la sua GUI.
 * Contiene anche dei metodi di uso comune nel sistema.
 * I path sono generati automaticamente da un metodo interno sulla base del sistema operativo utilizzato
 * e sulla struttura delle directory del software.
 * 
 */
public class Utilities {
    //campi inetrni privati
    private static String osFileSeparator = FileSystems.getDefault().getSeparator();
    private static String basePath = generateBasePath();
    
    //Path verso files
    /**
     * La stringa che rappresenta il percorso verso il file html
     * usato come tamplate per costruire la mail di benvenuto.
     */
    public static String HtmlPath = basePath+ osFileSeparator+"Risorse"+osFileSeparator+"email-registration-confirm-def"+osFileSeparator+"registration-confirm.html";

    /**
     * La stringa che rappresenta il percorso verso il file
     * dove le canzoni del repository sono memorizzate.
     */
    public static String pathToCanzoniDatiTxt =basePath +  osFileSeparator+"data"+osFileSeparator+"Canzoni.dati.txt";
    /**
     * La stringa che rappresenta il percorso verso il file
     * dove i dati dei giudizi emozionali sono memorizzati.
     */
    public static String pathToEmozioniDati = basePath + osFileSeparator +"data" +osFileSeparator+"Emozioni.dati.txt";
    /**
     * La stringa che rappresenta il percorso verso il file
     * dove le playlist di ogni utente sono memorizzate.
     */
    public static String pathToPlaylistDati = basePath + osFileSeparator +"data" +osFileSeparator+"Playlist.dati.txt";
    /**
     * La stringa che rappresenta il percorso verso il file
     * dove i dati di tutti gli utenti registrati sono memorizzati.
     */
    public static String pathToUserDatabase = basePath + osFileSeparator +"data" +osFileSeparator+"UtentiRegistrati.dati.txt";
    
    //immagini
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine del logo del software.
     */
    //public static ImageIcon logo = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"EmotionalSongsLogo.png");
    public static ImageIcon logo = new ImageIcon(loadImage("EmotionalSongsLogo.png"));

    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine della schermata di caricamento del software.
     */
    //public static ImageIcon loadingFrame = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"LoadingFrameWhite.png");
    public static ImageIcon loadingFrame = new ImageIcon(loadImage("LoadingFrameWhite.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine della finestra principale del software.
     */
    //public static ImageIcon mainBackGround = new ImageIcon(basePath+ osFileSeparator+"Risorse"+osFileSeparator+"mainBackground.png");
    public static ImageIcon mainBackGround = new ImageIcon(loadImage("mainBackground.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine dell'icona del pulsante di ricerca delle canzoni.
     */
    public static ImageIcon searchIcon = new ImageIcon(loadImage("IconaRicerca.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine dell'icona del pulsante indietro della visualizzazione del repository.
     */
    public static ImageIcon backButtonIcon = new ImageIcon(loadImage("BackButton.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine dell'icona del pulsante avanti della visualizzazione del repository.
     */
    public static ImageIcon nextButtonIcon = new ImageIcon(loadImage("NextButton.png"));  
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine dello sfondo del form di login al software.
     */
    public static ImageIcon logingBG = new ImageIcon(loadImage("LoginBG.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine dello sfondo del form di registrazione al software.
     */
    public static ImageIcon regBG = new ImageIcon(loadImage("RegBg.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine dell'icona sullo sfondo del form di login al software.
     */
    public static ImageIcon regIcon = new ImageIcon(loadImage("RegIcon.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine del pulsante di reset della ricerca di canzoni nel repository.
     */
    public static ImageIcon clearButtonIcon = new ImageIcon(loadImage("ClearButtonIcon.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta l'immagine del pulsante di chiusura del menu di visualizzazione del repository.
     */
    public static ImageIcon closeButton = new ImageIcon(loadImage("CloseButton.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta lo sfondo del pannello che raffigura ogni singola canzone.
     */
    public static ImageIcon SongViewIcon = new ImageIcon(loadImage("SongViewBorder.png"));
    
    /**
     * Oggetto di tipo ImageIcon che rappresenta il pannello dei crediti.
     */
    public static ImageIcon CreditsIcon = new ImageIcon(loadImage("credits.png"));
    
    // metodi
    /**
     * 
     * @param stringToCapitalize La stringa cui si vuole rendere maiuscola la prima lettera.
     * @return La stringa passata come argomento con la prima lettera capitalizzata.
     */
    public static String capitalize(String stringToCapitalize){
        if(stringToCapitalize == null || stringToCapitalize.length()<=1) return stringToCapitalize;
        return stringToCapitalize.substring(0, 1).toUpperCase() + stringToCapitalize.substring(1);
    }

    /**
     * 
     * @param fileName Stringa che rappresenta un percorso verso il file di testo di cui si vuole contare le righe (le righe si considerano divise da "\n").
     * @return Il numero di righe contenute nel file formato long.
     */
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
    
    /**
     * <h3>Descrizione:</h3>
     * Metodo interno privato che costruisce il path comune a tutti i path verso i file sorgente
     * sulla base del sistema operativo in essere.
     *
     * <h3> Struttura delle cartelle:</h3>
     * Si consideri fondamentale che
     * <ul>
     *  <li>I file <i>X.dati.txt</i> risiedano nella cartella <i>data</i>.</li>
     *  <li>I file <i>y.png</i> risiedano nella cartella <i>risorse</i> e con essi anche la cartella contenente il template html.</li>
     *  <li>Il file <i>eseguibile</i>.jar risieda nella cartella <i>bin</i>.</li>
     *  <li><b>Tutte le precedenti cartelle risiedano nella cartella EmotionalSongs.</b></li>
     * </ul>
     * @return La stringa rappresentante il path comune.
     */  
    
    private static String generateBasePath(){
        String stringPath = new File(System.getProperty("user.dir")).getParent();
        //new PopUpAllert(stringPath).setVisible(true);
        stringPath += stringPath.endsWith("EmotionalSongs") ? "" : (osFileSeparator+"EmotionalSongs");
        //new PopUpAllert(stringPath).setVisible(true);
        return stringPath;
    }
    
    private static BufferedImage loadImage(String pathString){
        BufferedImage img = null;
        try {
            //new PopUpAllert(EmotionalSongs.class.getResource(osFileSeparator+"images"+osFileSeparator+pathString).getPath()).setVisible(true);
            img = ImageIO.read(EmotionalSongs.class.getResource("/"+"images"+"/"+pathString));
        } catch (IOException ex) {
            ex.getCause();
        }
        return img;
    }
}
