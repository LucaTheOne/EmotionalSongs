/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services.emozioni;

import serverES.server_services_common_interfaces.data_validator.EmotionsDataValidator;
import serverES.utils.ServerUtils;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

/**
 *
 * @author big
 */
public class EmozioniDataChecker extends UnicastRemoteObject implements EmotionsDataValidator{

    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    /**
     * Metodo costruttore della classe
     * @param Conn: connessione con il database
     * @throws RemoteException: sollevata se il collegamento con il database dovesse fallire
     */
    public EmozioniDataChecker(Connection Conn)throws RemoteException{
        super();
        CONNECTION_TO_DB = Conn;
    }
    
    
    //Eleonora
    /**
     * Metodo il quale verifica che tutti i parametri passati come argomento siano accettabili,
     * ritorna un array di interi contenenti tutti gli errori occorsi. 
     * @param songId Id canzone votata.
     * @param emotionalMarks array di 9 posizioni contenente i voti di ogni emozione.
     * @param comment commento opzionale
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
     * @throws java.rmi.RemoteException
     */
    @Override
    public boolean[] validateVote(String songId, int[] emotionalMarks, String comment)throws RemoteException{
        boolean[] errors = new boolean[]{false,false,false,false,false,false};
        try {
            String query ="SELECT COUNT(*) FROM CANZONI WHERE ID_UNIVOCO = ?;"; 
            PreparedStatement statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, songId);
            ResultSet resultSet = statementControl.executeQuery();
            resultSet.next();
            if(resultSet.getInt(1)<1)
            {
                errors[0] = true;
            }

            if(emotionalMarks.length > 9 || emotionalMarks.length < 1)
            {
                errors[1] = true;
            } 
            
            for(int i = 0; i < 9; i++)
            {
                if(emotionalMarks[i] < 1 || emotionalMarks[i] > 5)
                {
                    errors[2] = true;
                }
            }
            if(!ServerUtils.isFitToPostgresql(comment)) errors[3] = true;
            

            if(comment.length() > 256)
            {
                errors[4] = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            errors[0] = true;
        }
        return errors;
    }
    
}
