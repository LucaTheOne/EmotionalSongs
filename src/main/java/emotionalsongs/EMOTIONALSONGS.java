
package emotionalsongs;

import java.io.*;

/**
 *
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    public static Utente loggedUser = null;
    public static Repository REPOSITORY;
    
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //importaRepository();
        //Brano brano = REPOSITORY.getBrano(3567);
        //System.out.println(brano.toStringOrdinato());
        RegistrationForm regEngine = new RegistrationForm();
        regEngine.registraNuovoUtente();
        Logger logEngine = new Logger();
        loggedUser = logEngine.logIn();
    }
    
    private static void importaRepository() throws IOException{
        REPOSITORY = new Repository();
    }
}
