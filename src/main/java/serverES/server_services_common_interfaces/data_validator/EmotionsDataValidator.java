/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services_common_interfaces.data_validator;

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
     * @return 
     * per ogni posizione dell' array:
     *      -True errore occorso.
     *      -False errore non occorso.
     * Indice - errore
     * 0 - Id Canzone non presente nel database
     * 1 - Dimensione array voti non conforme
     * 2 - Almeno un voto fuori dal range 1-5 inclusi.
     * 3 - caratteri non ammessi nel commento.
     * 4 - Commento contiene più di 256 caratteri.
     * 5 - eccezione SQL.
     */
    public boolean[] validateVote(String songId,int[] emotionalMarks,String Comment)throws RemoteException;
}
