
package emotionalsongs;

import java.io.*;

/**
 *
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    public static Utente loggedUser = null;
    public static Repository REPOSITORY;
    public static DataSetEmozioni dataSetEmozioni;
    
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Window page = new LoadingFrame();
        MainFrame.run();
       
        //REPOSITORY = new Repository();
        //dataSetEmozioni = new DataSetEmozioni();
        //System.out.println(REPOSITORY.getBrano(1257).toStringOrdinato());
       
    }
    
}
