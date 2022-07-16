
package emotionalsongs;

import java.io.*;
import java.util.*;

/**
 *
 * @author luca
 */
public class Logger {
    Logger(){
        
    }
    Utente logIn() throws IOException{
        String userId = askUserId();
        String pswd = askPassword();
        Utente utente = matcher(userId, pswd);
        return utente;
    }
    
    private String askUserId(){
        System.out.print("Inserisca l' username scelto in fase di login: ");
        String user = new Scanner(System.in).nextLine(); 
        System.out.print("\r");
        return user;
    }
    
    private String askPassword(){
        System.out.print("Inserisca la password scelta in fase di login: ");
        String password = new Scanner(System.in).nextLine(); 
        System.out.print("\r");
        return password;
    }
    
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
               if(yesOrNot == true){
                   return Utente.Registrazione();
               }
            }
        }
        boolean passwordMatches = passwordMatcher(userId, pswd);
        while(!passwordMatches){
            System.out.println("Password errata!!");
            passwordMatches = passwordMatcher(userId, askPassword());    
        }
        
        BufferedReader buffer = new BufferedReader(new FileReader(new File("../EMOTIONALSONGS/data/UtentiRegistrati.dati.csv")));
        boolean lineFound = false;
        String stringaCorrente = "";
        while(!lineFound){
            stringaCorrente = buffer.readLine();
            lineFound = stringaCorrente.split(",")[0].equals(userId);    
        }
        String[] lineaDatiUtente = stringaCorrente.split(",");
        return new Utente(lineaDatiUtente[0],lineaDatiUtente[1],lineaDatiUtente[2],lineaDatiUtente[3],lineaDatiUtente[4],lineaDatiUtente[5],lineaDatiUtente[6],lineaDatiUtente[7]);
        
    }
    
    private boolean founderId(String userId) throws FileNotFoundException, IOException{
        BufferedReader buffer = new BufferedReader(new FileReader(new File(Utilities.pathToUserDatabase)));
        boolean foundId = false;
        String stringaCorrente;
        while(!foundId){
            stringaCorrente = buffer.readLine();
            if(stringaCorrente == null) break;
            foundId = stringaCorrente.split(",")[0].equals(userId);    
        }
        return foundId;
    }
    
    private boolean passwordMatcher(String userid,String password) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader(new File(Utilities.pathToUserDatabase)));
        String stringaId = "";
        boolean foundIdLine = false;
        while(!foundIdLine){
            stringaId = buffer.readLine();
            foundIdLine = stringaId.split(",")[0].equals(userid);
        }
        return stringaId.split(",")[1].equals(password);
    }
    
}
