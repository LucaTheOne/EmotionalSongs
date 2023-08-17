/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_communication.utenti_registrati_table;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import serverES.services_common_interfaces.data_handler.*;

/**
 *
 * @author big
 */
public class ProxyToDBUtenti_Registrati extends UnicastRemoteObject implements UsersDataHandler{
    
    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    public ProxyToDBUtenti_Registrati(Connection DBConn) throws RemoteException{
        super();
        CONNECTION_TO_DB = DBConn;
    }
    
    //Eleonora
    /** Metodo che verifica se un determinato utente (identificato dal userId) non abbia già espresso un parere
    * per una determinata canzone (identificata dal suo id).
    * @param userId Id dell'utente quale si vuole verificare la possibilità di voto.
    * @param songId Id della canzone da votare.
    * @return true se l' uente non ha già espresso un parere, false altrimenti.
    * @throws java.rmi.RemoteException
    */
    @Override
    public boolean userCanVoteSong(String userId,String songId) throws RemoteException{ 
        try {
            String query ="SELECT COUNT(*) FROM EMOZIONI WHERE USER_PROP_ID = ? AND CANZONE_ID = ?;";
            PreparedStatement statementControl = CONNECTION_TO_DB.prepareStatement(query);
            statementControl.setString(1, userId);
            statementControl.setString(2, songId);
            ResultSet resultSet = statementControl.executeQuery();
            resultSet.next();
            if(resultSet.getInt(1)==0) return true; 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    //luca - fatto
    /**
     * Metodo che aggiorna il DB con un nuovo utente, ed il suo indirizzo.Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param userId
     * @param email
     * @param cf
     * @param password
     * @param nome
     * @param cognome
     * @param dataNascita
     * @param indirizzo
     * @return 
     * 0 - operazione completata con successo.
     * 1 - operazione non andata a buon fine.
     * @throws java.rmi.RemoteException
     */
    @Override
    @SuppressWarnings("deprecation")
    public int requestToUpdateUsersTable(
            String userId, 
            String email, 
            String cf, 
            String password, 
            String nome, 
            String cognome,
            String dataNascita,  
            String indirizzo
        ) throws RemoteException{
        try {
            String query = "INSERT INTO UTENTI_REGISTRATI(ID_USER,EMAIL,CF,PASSWORD,NOME,COGNOME,DATA_NASCITA,INDIRIZZO) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            int yyyy,mm,dd;
            yyyy = Integer.parseInt(dataNascita.split("/")[2]);
            mm = Integer.parseInt(dataNascita.split("/")[1]);
            dd = Integer.parseInt(dataNascita.split("/")[0]);
            statement.setString(1, userId);
            statement.setString(2, email);
            statement.setString(3, cf);
            statement.setString(4, password);
            statement.setString(5, nome);
            statement.setString(6, cognome);
            statement.setDate(7, new Date(yyyy, mm,dd));
            statement.setString(8, indirizzo);
            statement.executeUpdate();
            statement.close();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 1;
        }
    }
    /*
    public static void main(String[] args) throws RemoteException {
        boolean can = new ProxyToDBUtenti_Registrati(DBConnector.getDefaultConnection()).userCanVoteSong("theOne", "TRYVYLV128F4222E69");
        System.out.println(can);
    }*/
}
