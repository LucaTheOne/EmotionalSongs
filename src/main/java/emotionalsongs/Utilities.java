
package emotionalsongs;

import java.util.*;

/**
 *
 * @author Megaport
 */
public class Utilities {
    //campi statici
    static String pathToCanzoniDatiTxt = "../GitHub/EMOTIONALSONGS/data/Canzoni.dati.txt";
    static String pathToEmozioniDati = "../GitHub/EMOTIONALSONGS/data/Emozioni.dati.csv";
    static String pathToPlaylistDati = "../GitHub/EMOTIONALSONGS/data/Canzoni.dati.txt";
    static String pathToUserDatabase = "../GitHub/EMOTIONALSONGS/data/UtentiRegistrati.dati.csv";
    
    static String divisioreFinale = "_.-._.-._.-._.-._.-._.-._";
    
    static boolean readYesOrNot(){
        System.out.println("Digiti Si in caso affermativo, digiti invece No in caso negativo");
        String scelta = new Scanner(System.in).nextLine();
        return scelta.toLowerCase().contains("s")? true:false;    
    }
}
