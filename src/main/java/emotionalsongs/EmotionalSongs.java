/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */

package emotionalsongs;

import clientES.*;
import emotionalsongs.dialogs.*;
import java.io.*;
/**
 * 
 * Classe contenente l' unico metodo main del software. Da qui viene lanciata la sua funzione principale
 * che dà via all'inizializzazione del software, offrendo l'accesso ad un campo pubblico 
 * statico detto dialogs, 
 * il quale permette di reperire i dialogi all'interno del software, sia in italiano che in inglese.
 */
public class EmotionalSongs {
    
    
    private static String loggedUser = "";
    /**
     * Rappresenta la lingua attualmente attiva nel sistema.
     */
    public static ClientDialogs dialoghi = new Italiano();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EmotionalSongs software = new EmotionalSongs();
        software.initialize();    
    }
    
    private void initialize() throws IOException{
        new ClientInitializer();
    }
    
    
    
    /**
     * Metodo che permette di interrogare la classe principale riguardo a quale istanza di User abbia 
     * attualmente effettuato il login.
     * @return L'istanza rappresentante l'utente attualmente loggato, null se l'utente non è loggato.
     */
    public static String getLoggedUser(){
        return loggedUser;
    }
    /**
     * Metodo che permette di modificare l'istanza di utente attualmente loggato al sistema.
     */
    public static void setLoggedUser(String loggedUser){
        EmotionalSongs.loggedUser = loggedUser;
    }
    
}
