/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services.playlist;

import serverES.server_services_common_interfaces.data_validator.PlaylistsDataValidator;
import serverES.utils.ServerUtils;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

/**
 *
 * @author big
 */
public class PlaylistsDataChecker extends UnicastRemoteObject implements PlaylistsDataValidator {
    
    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    /**
     * Metodo costruttore della classe
     * @param Conn: connessione con il database
     * @throws RemoteException: sollevata se il collegamento con il database dovesse fallire
     */
    public PlaylistsDataChecker(Connection Conn) throws RemoteException{
        super();
        CONNECTION_TO_DB = Conn;
    }
    
    //Eleonora
    /**
     * Metodo il quale controlla che i dati della playlist che si sta creando siano validi.
     * Ritorna 0 se si, altrimenti un intero rappresentante un errore.
     * @param playlistName nome della nuova playlist
     * @param songsIds array con gli ids delle canzoni da aggiungervi.
     * @return 0 - operazione terminata con successo,
     * 1 - almeno uno degli IDs delle canzoni non è valido.
     * 2 - il nome della playlist non è valido.
     */
    @Override
    public boolean[] validatePlaylist(String playlistName,String[] songsIds)throws RemoteException{
        boolean[] errors = new boolean[]{false,false,false};
        
        try{
            if(!ServerUtils.isFitToPostgresql(playlistName)) errors[0] = true;
            
            String str = String.join(",", songsIds); // creo una stringa con i codici separati da una virgola
            System.out.println(str);

            String query ="SELECT COUNT(*) FROM CANZONI WHERE ID_UNIVOCO IN (?"; //creo una query con tanti punti interrogativi quanti elementi dell'array di canzoni
            String quest = ",?".repeat(songsIds.length - 1);
            query += quest += ");";                                 

            PreparedStatement statementControl = CONNECTION_TO_DB.prepareStatement(query); //assegno ad ogni ? un elemento dell'array
            for (int i=0; i<songsIds.length; i++)
            {
                statementControl.setString(i+1, songsIds[i]);
            }
            
            ResultSet resultSet = statementControl.executeQuery();
            resultSet.next();

            if (resultSet.getInt(1) != songsIds.length) errors[1] = true;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            errors[2] = false;
        }
        return errors;
    }
    
}
