
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
    public boolean logged = false;
    public static MainPage mainWindow = new MainPage();
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        mainWindow.setVisible(true);
        /*
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        
        InitializationFrame frame = new InitializationFrame();
        frame.setVisible(true);
        */
        //MainFrame.run();

        //MainFrame.run();
        
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
