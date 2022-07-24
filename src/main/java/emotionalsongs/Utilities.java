
package emotionalsongs;

import java.util.*;

/**
 *
 * @author Megaport
 */
public class Utilities {
    //campi statici
    static String pathToCanzoniDatiTxt = "../EMOTIONALSONGS/data/Canzoni.dati.txt";
    static String pathToEmozioniDati = "../EMOTIONALSONGS/data/Emozioni.dati.csv";
    static String pathToPlaylistDati = "../EMOTIONALSONGS/data/Canzoni.dati.txt";
    static String pathToUserDatabase = "../EMOTIONALSONGS/data/UtentiRegistrati.dati.csv";
    
    static String divisioreFinale = "_.-._.-._.-._.-._.-._.-._";
    
    static boolean readYesOrNot(){
        System.out.println("Digiti 's' in caso affermativo, altrimenti digiti 'n' :");
        String scelta = new Scanner(System.in).nextLine();
        return scelta.toLowerCase().contains("s")? true:false;    
    }
    
    static boolean richiestaUscita() {
        System.out.println("Vuole tornare al menu precedente? ");
        System.out.println("Digiti 's' in caso affermativo, altrimenti digiti 'n' :");
        String scelta = new Scanner(System.in).nextLine();
        return scelta.toLowerCase().contains("s")? true:false; 
    }
}
