
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
       //LoadingPage.runPage();
       REPOSITORY = new Repository();
       SearchEngine serach = new SearchEngine();
       serach.cercaBranoMusicale();
    }
    
    private static void importaRepository() throws IOException{
        REPOSITORY = new Repository();
    }
    
}
