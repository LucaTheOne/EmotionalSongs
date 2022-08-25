
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    
    public static Utente loggedUser = null;
    public static Repository REPOSITORY;
    public DataSetEmozioni dataSetEmozioni;
    public static UserDatabase userDatabase;
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
<<<<<<< Updated upstream
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
=======
        //MainFrame.run();
>>>>>>> Stashed changes
        
        //MainFrame.run();
        //LoadingFrame frame = new LoadingFrame();
        //frame.runWindow();
         //JFrame frame= new FramePrincipale();
         //frame.setVisible(true);
        //REPOSITORY = new Repository();
        //dataSetEmozioni = new DataSetEmozioni();
        //System.out.println(REPOSITORY.getBrano(1257).toStringOrdinato());
        
    }
    
    private void initialize() throws IOException{
        REPOSITORY = new Repository();
        userDatabase = new UserDatabase();
        
    }
    
}
