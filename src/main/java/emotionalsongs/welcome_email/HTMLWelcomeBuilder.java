/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.welcome_email;


import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import java.io.*;
import java.util.logging.*;
/**
 * Classe che si occupa di fornire metodi per la compilazione del form html di benvenuto.
 */
class HTMLWelcomeBuilder {
    
    private User user = EmotionalSongs.getLoggedUser();
    private String message ="";
    private String[] userdata = new String[8];
    private String[] identifiers = {"%&0","%&1","%&2","%&3","%&4","%&5","%&6","%&7"};
    
    /**
     * Costruttore della classe che si occupa di compilare il form html di benvenuto sulla base dei dati dell' utente appena registrato.
     */
    public HTMLWelcomeBuilder() {
        userdata[0] = user.getName();
        userdata[1] = user.getSurname();
        userdata[2] = user.getBirthDate();
        userdata[3] = user.getCF();
        userdata[4] = user.getAddress();
        userdata[5] = user.getEmail();
        userdata[6] = user.getUserId();
        userdata[7] = user.getPassword();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(Utilities.HtmlPath)));
            String current = "";
            while((current = reader.readLine()) != null){
                message += current;
            }
            for (int i = 0; i < 8; i++) {
                message = message.replace(identifiers[i], userdata[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HTMLWelcomeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HTMLWelcomeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Restituisce il form compilato sotto forma di stringa.
     * @return stringa rappresentante il form compilato.
     */
    public String getwelcomeMessage(){
        return message;
    }
     
}
