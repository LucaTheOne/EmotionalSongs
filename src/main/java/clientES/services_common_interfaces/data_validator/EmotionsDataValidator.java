/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package clientES.services_common_interfaces.data_validator;

import serverES.services_common_interfaces.data_validator.*;
import java.rmi.*;

/**
 *
 * @author big
 */
public interface EmotionsDataValidator extends Remote {
    
    public static final String SERVICE_NAME = "emotions_data_validator";
    
    //Eleonora
    /**
     * Metodo il quale verifica che tutti i parametri passati come argomento siano accettabili,
     * ritorna un array di interi contenenti tutti gli errori occorsi. 
     * @param songId Id canzone votata.
     * @param emotionalMarks array di 9 posizioni contenente i voti di ogni emozione.
     * @param Comment commento opzionale
     * @return 0 - tutti i dati sono stati verificati,
     * 1 - Id Canzone non presente nel database
     * 2 - Dimensione array voti non conforme
     * 3 - Almeno un voto fuori dal range 1-5 inclusi.
     * 4 - caratteri non ammessi nel commento.
     * 5 - Commento contiene più di 256 caratteri.
     * 6 - eccezione SQL.
     */
    public int[] validateVote(String songId,int[] emotionalMarks,String Comment)throws RemoteException;
}
