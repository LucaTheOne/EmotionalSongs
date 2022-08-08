
package emotionalsongs;

import java.io.*;
import java.util.*;

/**
 *
 * @author luca
 */
public class LogInPerformer {
    
    /**
     * 
     */
    LogInPerformer(){
        
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    Utente logIn() throws IOException{
        String userId = askUserId();
        String pswd = askPassword();
        Utente utente = matcher(userId, pswd);
        System.out.println("Accesso eseguito con successo!");
        System.out.println("Bentornato in  emotionalSongs");
        return utente;
    }
    
    /**
     * 
     * @return 
     */
    private String askUserId(){
        System.out.print("Inserisca l' username scelto in fase di registrazione: ");
        String user = new Scanner(System.in).nextLine(); 
        System.out.print("\r");
        return user;
    }
    
    /**
     * 
     * @return 
     */
    private String askPassword(){
        System.out.print("Inserisca la password scelta in fase di registrazione: ");
        String password = new Scanner(System.in).nextLine(); 
        System.out.print("\r");
        return password;
    }
    
    /**
     * 
     * @param userId
     * @param pswd
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private Utente matcher(String userId,String pswd)throws FileNotFoundException,IOException {
        boolean idFound = founderId(userId);
        while(!idFound){
            System.out.println("Utente non presente nel database!");
            System.out.println("Vuole reinserire il suo user id? ");
            boolean yesOrNot = Utilities.readYesOrNot();
            if(yesOrNot == true){
                userId = askUserId();
                idFound = founderId(userId);
            }else{
               System.out.println("Vuole registrarsi al programma EmotionalSongs? "); 
               yesOrNot = Utilities.readYesOrNot();
               if(Utilities.readYesOrNot()){
                   Utente.Registrazione();
                   return null;
               }
            }
        }
        boolean passwordMatches = passwordMatcher(userId, pswd);
        while(!passwordMatches){
            System.out.println("Password errata!!");
            passwordMatches = passwordMatcher(userId, askPassword());    
        }
        
        BufferedReader buffer = new BufferedReader(new FileReader(new File(Utilities.pathToUserDatabase)));
        boolean lineFound = false;
        String stringaCorrente = "";
        while(!lineFound){
            stringaCorrente = buffer.readLine();
            lineFound = stringaCorrente.split(";")[0].equals(userId);    
        }
        String[] lineaDatiUtente = stringaCorrente.split(";");
        return new Utente(lineaDatiUtente[0],lineaDatiUtente[1],lineaDatiUtente[2],lineaDatiUtente[3],lineaDatiUtente[4],lineaDatiUtente[5],lineaDatiUtente[6],lineaDatiUtente[7]);
        
    }
    
    /**
     * 
     * @param userId
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private boolean founderId(String userId) throws FileNotFoundException, IOException{
        BufferedReader buffer = new BufferedReader(new FileReader(new File(Utilities.pathToUserDatabase)));
        boolean foundId = false;
        String stringaCorrente;
        while(!foundId){
            stringaCorrente = buffer.readLine();
            if(stringaCorrente == null) break;
            foundId = stringaCorrente.split(";")[0].equals(userId);    
        }
        return foundId;
    }
    
    /**
     * 
     * @param userid
     * @param password
     * @return
     * @throws IOException 
     */
    private boolean passwordMatcher(String userid,String password) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader(new File(Utilities.pathToUserDatabase)));
        String stringaId = "";
        boolean foundIdLine = false;
        while(!foundIdLine){
            stringaId = buffer.readLine();
            foundIdLine = stringaId.split(";")[0].equals(userid);
        }
        return stringaId.split(";")[1].equals(password);
    }
    
}