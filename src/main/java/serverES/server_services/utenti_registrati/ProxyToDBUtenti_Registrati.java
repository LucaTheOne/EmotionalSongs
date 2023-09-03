/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services.utenti_registrati;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.time.*;
import serverES.server_services_common_interfaces.data_handler.*;
import serverES.welcome_email_sender.*;

/**
 *
 * @author big
 */
public class ProxyToDBUtenti_Registrati extends UnicastRemoteObject implements UsersDataHandler{
    
    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    /**
     * Metodo costruttore della classe
     * @param DBConn: istanza di connessione al database
     * @throws RemoteException 
     */
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
     * Metodo che aggiorna il DB con un nuovo utente, ed il suo address.Ritorna 0 se l' operazione termina con successo, 1 altrimenti.
     * @param userId
     * @param email
     * @param cf
     * @param password
     * @param name
     * @param surname
     * @param birthDay
     * @param address
     * @return 
     * 0 - operazione completata con successo.
     * 1 - operazione non andata a buon fine.
     * @throws java.rmi.RemoteException
     */
    @Override
    @SuppressWarnings("deprecation")
    public synchronized int registraNuovoUtente(
            String userId, 
            String email, 
            String cf, 
            String password, 
            String name, 
            String surname,
            String birthDay,  
            String address
        ) throws RemoteException{
        try {
            String query = "INSERT INTO UTENTI_REGISTRATI(ID_USER,EMAIL,CF,PASSWORD,NOME,COGNOME,DATA_NASCITA,INDIRIZZO) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            int yyyy,mm,dd;
            yyyy = Integer.parseInt(birthDay.split("/")[2]);
            mm = Integer.parseInt(birthDay.split("/")[1]);
            dd = Integer.parseInt(birthDay.split("/")[0]);
            statement.setString(1, userId);
            statement.setString(2, email);
            statement.setString(3, cf);
            statement.setString(4, password);
            statement.setString(5, name);
            statement.setString(6, surname);
            LocalDate localDate = LocalDate.of(yyyy, mm, dd);
            statement.setDate(7, Date.valueOf(localDate));
            statement.setString(8, address);
            statement.executeUpdate();
            statement.close();
            login(userId);
            WelcomeMailSender.sendMailToNewUser(name, surname, birthDay, cf, address, email, userId, password);
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 1;
        }
    }
    
    /**
     * Esegue il logout dell'utente.
     * Setta il parametro logged nel database come FALSE
     * @param loggedUserId
     * @return 0 se logout andato a buon fine, 1 se l'utente non risultava loggato
     * @throws RemoteException 
     */
    @Override
    public int logout(String loggedUserId) throws RemoteException{
        try {
            String query = "UPDATE UTENTI_REGISTRATI SET LOGGED = FALSE WHERE ID_USER = (SELECT ID_USER FROM UTENTI_REGISTRATI WHERE ID_USER = ?);";
            PreparedStatement preparedStatement = CONNECTION_TO_DB.prepareStatement(query);
            preparedStatement.setString(1, loggedUserId);
            preparedStatement.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 1;
        }
    }
    
    /**
     * Metodo usato per notificare al DB che l' utente ha già effettuato il login!
     * @param loggedUserId user id dell' utente che vuole eseguire il login. 
     */
    @Override
    public int login(String loggedUserId) throws RemoteException{
        try {
            String query = "UPDATE UTENTI_REGISTRATI SET LOGGED = TRUE WHERE ID_USER = (SELECT ID_USER FROM UTENTI_REGISTRATI WHERE ID_USER = ?);";
            PreparedStatement preparedStatement = CONNECTION_TO_DB.prepareStatement(query);
            preparedStatement.setString(1, loggedUserId);
            preparedStatement.execute();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 1;
        }
    }
    
    /*
    public static void main(String[] args) throws RemoteException {
        ProxyToDBUtenti_Registrati proxy = new ProxyToDBUtenti_Registrati(DBConnector.getTextConn());
        proxy.registraNuovoUtente("vdanailova", "nddanailov@outlook.com", "DNLVYG73R68Z104G", "Password123!", "Vanya Georgieva", "Danailova", "1/1/1970", "varese");
    }*/
}
