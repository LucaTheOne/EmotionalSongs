/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_communication.emozioni;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import serverES.db_communication.*;
import serverES.services_common_interfaces.data_validator.*;

/**
 *
 * @author big
 */
public class EmozioniDataChecker extends UnicastRemoteObject implements EmotionsDataValidator{

    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
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
     * @param Comment commento opzionale
     * @return 0 - tutti i dati sono stati verificati,
     * 1 - Id Canzone non presente nel database
     * 2 - Dimensione array voti non conforme
     * 3 - Almeno un voto fuori dal range 1-5 inclusi.
     * 4 - caratteri non ammessi nel commento.
     * 5 - Commento contiene più di 256 caratteri.
     * 6 - eccezione SQL.
     */
    @Override
    public int[] validateVote(String songId, int[] emotionalMarks, String Comment)throws RemoteException{
        int[] errors = new int[]{0,0,0,0,0,0};
        try {
            String query ="SELECT COUNT(*) FROM CANZONI WHERE ID_UNIVOCO = ?;"; 
            PreparedStatement statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, songId);
            ResultSet resultSet = statementControl.executeQuery();
            resultSet.next();
            if(resultSet.getInt(1)<1)
            {
                errors[0] = 1;
            }

            if(emotionalMarks.length > 9 || emotionalMarks.length < 1)
            {
                errors[1] = 2;
            } 
            
            for(int i = 0; i < 9; i++)
            {
                if(emotionalMarks[i] < 1 || emotionalMarks[i] > 5)
                {
                    errors[2] = 3;
                }
            }

            if(!ServerUtils.isFitToPostgresql(Comment)) errors[3] = 4;
            

            if(Comment.length() > 256)
            {
                errors[4] = 5;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            errors[0] = 6;
        }
        return errors;
    }
    
}
