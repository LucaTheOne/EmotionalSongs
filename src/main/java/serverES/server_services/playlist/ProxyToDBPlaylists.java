/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services.playlist;

import serverES.utils.ServerUtils;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import serverES.*;
import serverES.server_services_common_interfaces.data_handler.*;

/**
 *
 * @author big
 */
public class ProxyToDBPlaylists extends UnicastRemoteObject implements PlaylistsDataHandler {

    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    /**
     * Metodo costruttore della classe
     * @param DBConn: istanza di connessione al database
     * @throws RemoteException: sollevata nel caso la connessione al database dovesse fallire
     */
    public ProxyToDBPlaylists(Connection DBConn) throws RemoteException{
        super();
        CONNECTION_TO_DB = DBConn;
    }

    //luca
    /**
     * Metodo che ritorna un array di stringhe, 
     * nel quale ogni posizione contiene l'id univoco di una playlist dell' utente
     * ed il suo nome separati da SEP.
     *      -Formato: "ID_PLAYLIST£SEP£User_PROP_ID£SEP£NOME_PLAYLIST" -
     * @param idUser id utente di cui si vuole sapere il nome delle playlist.
     * @return array di Stringhe contenente id e nomi delle playlist, null se l' utente non ha playlist.
     */
    @Override
    public String[] requestPlaylistsUser(String idUser) throws RemoteException{
        try {
            String query = "SELECT * FROM PLAYLIST WHERE USER_PROP_ID = '"+idUser+"';";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            return ServerUtils.convToArrayStr(result);    
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            return null;
        }
    }

    //luca
    /**
     * Metodo usato per interrogare il DB, ritorna un array di stringhe il quale in ogni posizione sono contenuti
     * i dati di una canzone  della playlist passata come argomento, separati da £SEP£;
     *      -Formato: "REPO_INDEX£SEP£ID_UNIVOCO£SEP£TITOLO£SEP£AUTORE£SEP£ANNO"-
     * @param playlistId id della playlist il quale si vuole sapere il contenuto.
     * @return array di stringhe contenenti i dati delle canzoni della playlist, null in caso di anomalie.
     */
    @Override
    public String[] requestPlaylistSongs(String playlistId) throws RemoteException{
        try {
            String query = "SELECT * FROM CONTENUTO_PLAYLIST WHERE PLAYLIST_ID = '"+playlistId+"';";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            return ServerUtils.convToArrayStr(result);    
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            return null;
        }
    }

    //Luca
    /**
     * Metodo che si occupa di aggiungere al db una nuova playlist.
     * Le sue operazioni compongono una transazione, se qualcosa va storto viene annullato tutto.
     * NB: genera anche l' id univoco per la nuova playlist.
     * @param newPlaylistName Nome della nuova playlist.
     * @param userIdOwner ID univoco del proprietario della playlist
     * @param idsSongs Contenuto della playlist, che verrà inserito nella tabella contenuto_playlist.
     * @return 0 - operazione avvenuta con successo.
     * 1 - transazione abortita.
     */
    @Override
    public synchronized int updatePlaylistTable(String newPlaylistName,String userIdOwner,String[] idsSongs) throws RemoteException{
        //query to update playlist table.
        String queryPlaylist = "INSERT INTO PLAYLIST(ID_PLAYLIST,USER_PROP_ID,NOME_PLAYLIST) VALUES(?,?,?);";
        //query to update contenuto_playlist table.
        String queryContenuto_playlist = "INSERT INTO CONTENUTO_PLAYLIST(PLAYLIST_ID,CANZONE_ID) VALUES (?,?);";
        //generate an unique id for this new playlist.
        String idUniqueNewPlaylist = ServerUtils.generateIdUnique(20,CONNECTION_TO_DB);
        
        //statement to build's container
        PreparedStatement statement = null;
        
        //disable the autocommit, this operation need to be a transaction; if something went wrong, all operation must been aborted.
        try {
            CONNECTION_TO_DB.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Impossible to start transaction!");
            System.out.println(ex.getMessage());
            return 1;
        }
        
        //prepare and execute the statement to insert a new playlist in the db.
        try {
            statement = CONNECTION_TO_DB.prepareStatement(queryPlaylist);
            statement.setString(1, idUniqueNewPlaylist);
            statement.setString(2, userIdOwner);
            statement.setString(3, newPlaylistName);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            try {
                System.out.println("Impossible to insert the new playlist, transation aborted!");
                System.out.println(ex.getMessage());
                CONNECTION_TO_DB.rollback(); //everithing is aborted
                return 1;
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
                return 1;
            }
        }
        
        //prepare and execute the statement to update contenuto_playlist, every line is composed by the new playlist id and one song id in it.
        try {
            statement = CONNECTION_TO_DB.prepareStatement(queryContenuto_playlist);
            //Create in the DB one line for each song in the playlist.
            for (int i = 0; i < idsSongs.length; i++) {
                statement.setString(1, idUniqueNewPlaylist);
                statement.setString(2, idsSongs[i]);
                statement.execute();
            }
            statement.close();
        } catch (SQLException ex) {
            try {
                System.out.println("Impossible to insert some songs, transation aborted!");
                System.out.println(ex.getMessage());
                CONNECTION_TO_DB.rollback();
                return 1;
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
                return 1;
            }
        }
        
        //at the moment all gone right, now it try to commit the transaction.
        try {
            CONNECTION_TO_DB.commit();
        } catch (SQLException ex) {
            System.out.println("Impossible to commit, operation aborted!");
            System.out.println(ex.getMessage());
            return 1;
        }
        
        // now autocommit is reabled.
        try {
            CONNECTION_TO_DB.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        //all is gone right
        return 0;
    }
  
    //luca
    //Non utilizzato
    @Override
    public int getUserPlaylistsNumber(String userId) throws RemoteException{
        try {
            String query = "SELECT COUNT(*) FROM PLAYLIST WHERE USER_PROP_ID = ?;";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            statement.setString(1, userId);
            ResultSet result = statement.executeQuery();
            result.next();
            int n = result.getInt(1);
            statement.close();
            return n;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    
    //luca - fatto
    /**
     * @param playlistId ID playlist di cui si vuole sapere il numero di canzoni contenute.
     * @return Il numero di canzoni contenute nbella playlist corrispondente al ID passato come argomento.
     */
    @Override
    public int getPlaylistDimension(String playlistId)throws RemoteException{
        try {
            String query = "SELECT COUNT(*) FROM CONTENUTO_PLAYLIST WHERE PLAYLIST_ID = '"+playlistId+"';";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}
