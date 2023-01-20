//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA

package emotionalsongs;

import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.dialogs.*;
import emotionalsongs.gui.generics.*;
import emotionalsongs.gui.main_window.*;
import java.io.*;

/**
 * <h3>Descrizione:</h3>
 * Classe contenente l' unico metodo main del software, da qui viene lanciata la sua funzione principale
 * che da via alla iniziallizazione del software, offre l' accesso ad un campo publico 
 * statico detto dialoghi
 * che permette di reperire i dialogi all' inetrno del software sia in italiano che in inglese.
 */
public class EmotionalSongs {
    
    
    private static User loggedUser = null;
    /**
     * rappresenta l' idioma attualmente attivo nel sistema.
     */
    public static dialogs dialoghi = new Italiano();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EmotionalSongs software = new EmotionalSongs();
        software.initialize();    
    }
    
    private void initialize() throws IOException{
        InitializationFrame init = new InitializationFrame();
        Repository.getInstance();
        DataBaseUsers.getInstance();
        DataBasePlaylists.getInstance();
        init.dispose();
        MainFrame.getIstance().setVisible(true);
        
    }
    
    /**
     * Metodo che permette di interrogare la classe principale su quale istanza di User sia 
     * attualmente loggata.
     * @return L' istanza rappresentante l' utente attualmente loggato, null se l' utente non è loggato.
     */
    public static User getLoggedUser(){
        return loggedUser;
    }
    /**
     * Metodo che permette di modificare l' istanza di utente attualmente loggato al sistema.
     */
    public static void setLoggedUser(User loggedUser){
        EmotionalSongs.loggedUser = loggedUser;
    }
    
}
