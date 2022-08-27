
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
    public static MainWindow mainWindow;
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EMOTIONALSONGS software = new EMOTIONALSONGS();
        software.initialize();      
    }
    
    private void initialize() throws IOException{
        InitializationFrame init = new InitializationFrame();
        REPOSITORY = new Repository();
        userDatabase = new UserDatabase();
        init.dispose();
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
    
}
