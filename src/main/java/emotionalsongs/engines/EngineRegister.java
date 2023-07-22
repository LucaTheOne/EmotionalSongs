/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.engines;

import emotionalsongs.*;
import emotionalsongs.basic_structures.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.welcome_email.*;
import java.io.*;

/**
* La classe le cui istanze si occupano di fornire all'utente i metodi necessari per registrarsi inserendo i seguenti dati:
* <ul>
* <li>UserID.
* <li>Codice fiscale(formato italiano).
* <li>Nome.
* <li>Cognome.
* <li>Indirizzo di residenza.
* <li>Indirizzo email.
* <li>Data di nascita.
* <li>Password scelta dall'utente.
* </ul>
* La classe in essere implementa anche vari metodi di controllo che verificano:
* <ul>
* <li>la validità del formato dei dati.
* <li>che l'utente non sia già registrato.
* <li>che l'utente sappia quale password ha scelto.
* </ul>
* Oltre a ciò, si occupa anche di salvare i dati su un file .txt, con una precisa impostazione,
* denominato utentiRegistrati.dati.txt .
**/
public class EngineRegister {

    private DataBaseUsers userDatabase;
    
    /**
     * Costruttore della classe a cui si passa il database Utenti di appoggio.
     */
    public EngineRegister(DataBaseUsers database) { 
        userDatabase = database;
    }
    
    /**
    * Il metodo riceve i dati userID, nome, 
    * cognome, codice fiscale, indirizzo, indirizzo email, password, data di nascita per costruire una nuova istanza di User da inserire nel database.
    * Effettua verifiche per ogni dato assicurandosi che esso sia valido.
    * Qualora lo siano completa la registrazione dell'utente spedendogli una mail di benvenuto.
    * @throws IOException
    */ 
    public void registraNuovoUtente(String userId,String name,String surname,String cf,String address,String email,String pswd,String contrPswd,String birthDate) throws IOException{
        User nuovo;
        nuovo = new User(userId, pswd, cf, name, surname, birthDate, email, address); 
        userDatabase.addNewUser(nuovo);
        EmotionalSongs.setLoggedUser(nuovo);
        WelcomeMailSender.sendMailToNewUser();
    }
}
