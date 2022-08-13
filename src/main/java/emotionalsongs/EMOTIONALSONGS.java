
package emotionalsongs;

import java.io.*;

/**
 *@hidden
 * @author Luca
 */
public class EMOTIONALSONGS {
    
    
    public Utente loggedUser = null;
    public Repository REPOSITORY;
    public DataSetEmozioni dataSetEmozioni;
    public static UserDatabase userDatabase;
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();
        LogInPerformer logInPerformer = new LogInPerformer(userDatabase);
        
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
