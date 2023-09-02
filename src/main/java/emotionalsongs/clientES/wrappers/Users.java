/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package emotionalsongs.clientES.wrappers;

import emotionalsongs.clientES.gui.registration.RegistrationPanel;
import emotionalsongs.clientES.gui.main_window.MainFrame;

/**
 *
 * @author big
 */
public class Users {
    
    /**
     * Avvia il processo di registrazione
     */
    public static void registrazione(){
        MainFrame mainWindow = MainFrame.getIstance();
        mainWindow.setMainPanel(new RegistrationPanel(mainWindow));
    }
}
