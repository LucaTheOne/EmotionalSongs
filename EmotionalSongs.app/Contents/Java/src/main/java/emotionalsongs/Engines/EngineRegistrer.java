//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.Engines;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.welcomeEmailSender.*;
import java.io.*;

/**
* La classe si occupa di fornire all'utente i metodi necessari per registrarsi inserendo dati come:
* <ul>
* <li>UserID.
* <li>Codice fiscale(formato italiano).
* <li>Nome.
* <li>Cognome.
* <li>Indirizzo di residenza.
* <li>Indirizzo email.
* <li>Data di nascita.
* <li>Password a scelta dell'utente.
* </ul>
* La classe in essere implementa anche vari metodi di controllo che verificano:
* <ul>
* <li>La validità del formato dei dati.
* <li>Che l' utente non vi sia già registrato.
* <li>Che l' utente sappia quale password ha scelto.
* </ul>
* Oltreciò si occupa anche di salvarne i dati su un file .txt con una precisa impostazione,
* denominato utentiRegistrati.dati.txt .
* nb v1.0 non vi è forma di controllo sull' indirizzo.
**/
public class EngineRegistrer {

    private DataBaseUsers userDatabase;
    
    /**
     * Costruisce un oggetto vuoto.
     */
    public EngineRegistrer(DataBaseUsers database) { 
        userDatabase = database;
    }
    
    /**
    * Il metodo chiede all'utente di inserire l'userID, nome, 
    * cognome, codice fiscale, indirizzo, indirizzo email, password, data di nascita.
    * Dopodichè viene eseguito un controllo del codice fiscale: se il codice fiscale è stato già utilizzato 
    * l'utente verrà avvisato, se non è stato utilizzato si procederà alla registrazione dell'utente su file.
    * @throws IOException 
    */ 
    public void registraNuovoUtente(String userId,String nome,String cognome,String cf,String indirizzo,String email,String pswd,String contrPswd,String dataNascita) throws IOException{
        User nuovo;
        nuovo = new User(userId, pswd, cf, nome, cognome, dataNascita, email, indirizzo); 
        System.out.println("utente creato");
        userDatabase.addNewUser(nuovo);
        System.out.println("utente aggiunto");
        EmotionalSongs.setLoggedUser(nuovo);
        WelcomeMailSender.sendMailToNewUser();
    }
}
