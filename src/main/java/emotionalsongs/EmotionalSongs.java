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
 * 
 * Classe contenente l' unico metodo main del software. Da qui viene lanciata la sua funzione principale
 * che dà via all'inizializzazione del software, offrendo l'accesso ad un campo pubblico 
 * statico detto dialogs, 
 * il quale permette di reperire i dialogi all'interno del software, sia in italiano che in inglese.
 */
public class EmotionalSongs {
    
    
    private static User loggedUser = null;
    /**
     * Rappresenta la lingua attualmente attiva nel sistema.
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
     * Metodo che permette di interrogare la classe principale riguardo a quale istanza di User abbia 
     * attualmente effettuato il login.
     * @return L'istanza rappresentante l'utente attualmente loggato, null se l'utente non è loggato.
     */
    public static User getLoggedUser(){
        return loggedUser;
    }
    /**
     * Metodo che permette di modificare l'istanza di utente attualmente loggato al sistema.
     */
    public static void setLoggedUser(User loggedUser){
        EmotionalSongs.loggedUser = loggedUser;
    }
    
}