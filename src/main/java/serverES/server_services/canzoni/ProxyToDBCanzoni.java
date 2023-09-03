/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services.canzoni;

import serverES.utils.ServerUtils;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
//import serverES.*;
import serverES.db_connector.*;
import serverES.server_services_common_interfaces.data_handler.*;

/**
 *
 * @author big
 */
public class ProxyToDBCanzoni extends UnicastRemoteObject implements SongsDataHandler {

    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    /**
     * Metodo costruttore della classe
     * @param DBConn: istanza di connessione al database
     * @throws RemoteException: sollevata se il collegamento con il database fallisce
     */
    public ProxyToDBCanzoni(Connection DBConn)throws RemoteException{
        super();
        CONNECTION_TO_DB = DBConn;
    }

    
    //luca
    /**
     * Metodo che ritorna i dati di una canzone di cui se ne passa l' id.-Formato: 
     * "ID_UNIVOCO£SEP£REPO_INDEX£SEP£TITOLO£SEP£AUTORE£SEP£ANNO" -
     * @param songId stringa con l' id della canzone di cui cercare i dati.
     * @return Stringa con i dati della canzone corrispondente all' id, null in caso di errori.
     * @throws java.rmi.RemoteException
     */
    @Override
    public String requestSongData(String songId)throws RemoteException{
        try {
            String query = "SELECT * FROM CANZONI WHERE ID_UNIVOCO = ?;" ;
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            statement.setString(1, songId);
            ResultSet result = statement.executeQuery();
            String resulString[] = ServerUtils.convToArrayStr(result);
            if(resulString.length != 1) return null;
            statement.close();
            return resulString[0];
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    //Luca
    /**
     * Metodo che ritorna un array di stringhe, in ogni sua posizione ci sono i dati
     * di una canzone cui il titolo coincide alla stringa passata come argomento, 
     * oppure che vi è contenuta in esso.NB: i match precisi sono nelle prime posizioni dell' array.
     * @param title Stringa da cercare nei titoli delle canzoni.
     * @return array di stringhe rappresentanti le canzoni che soddisfano i criteri di ricerca.
     * @throws java.rmi.RemoteException
     */
    @Override
    public String[] cercaBranoMusicale(String title)throws RemoteException{
        try {
            String query = "SELECT ID_UNIVOCO,REPO_INDEX,TITOLO,AUTORE,ANNO FROM CANZONI WHERE LOWER(TITOLO) LIKE LOWER('%"+title+"%') ORDER BY TITOLO,AUTORE,ANNO ASC;";
            Statement statement = CONNECTION_TO_DB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            String[] resultArray = ServerUtils.convToArrayStr(queryResult);
            statement.close();
            return resultArray;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }   
    }
    
    //Luca
    /**
     * Metodo che interroga il DB ed ottiene un array di stringhe, in ogni sua posizione ci sono i dati
     * di una canzone cui il autore coincide alla stringa passata come argomento, 
     * oppure che vi è contenuta in esso e l' anno coincide con l' intero passato come argomento.
     * @param author Stringa da cercare negli autori delle canzoni.
     * @param year Anno delle canzoni ricercate
     * @return array di stringhe rappresentanti le canzoni che soddisfano i criteri di ricerca.
     * @throws java.rmi.RemoteException
     */
    @Override
    public String[] cercaBranoMusicale(String author, int year)throws RemoteException{
        try {
            String query = "SELECT * FROM CANZONI WHERE LOWER(AUTORE) LIKE LOWER('%"+author+"%')"+
                    "INTERSECT"+
                    " SELECT * FROM CANZONI WHERE ANNO = "+year+
                    " ORDER BY AUTORE,ANNO,TITOLO ASC;";
            PreparedStatement statement = DBConnector.getConnection().prepareStatement(query);
            //PreparedStatement statement = DBConnector.getTextConn().prepareStatement(query);
            ResultSet queryResult = statement.executeQuery();
            String[] resultArray = ServerUtils.convToArrayStr(queryResult);
            statement.close();
            return resultArray;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    //Luca
    /**
     * Metodo che interroga il DB ed ottiene un array di canzoni comprese tra i due indici (che sono compresi).
     * Gli elementi sono adeguatamente formattati come da interfaccia "SongsDataManager".
     * @param startIndex Indice prima canzone.
     * @param endIndex Indice ultima canzone.
     * @return Array di stringhe con i dati delle canzoni contenute tra startIndex ed endIndex compresi.
     * @throws java.rmi.RemoteException
     */
    @Override
    public String[] requestRepositorysSongByIndex(int startIndex, int endIndex)throws RemoteException {
        try {
            String query = "SELECT * FROM CANZONI WHERE REPO_INDEX BETWEEN "+startIndex+" AND "+endIndex+";";
            Statement statement = CONNECTION_TO_DB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            String[] results = serverES.utils.ServerUtils.convToArrayStr(queryResult);
            return results;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    //luca
    /**
     * @return Numero di canzoni presenti nel DB. 
     * @throws java.rmi.RemoteException 
     */
    @Override
    public int getRepoSize()throws RemoteException{
        try {
            String query = "SELECT MAX(REPO_INDEX) FROM CANZONI;";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    /*
    public static void main(String[] args) throws RemoteException {
        ProxyToDBCanzoni pc = new ProxyToDBCanzoni(DBConnector.getTextConn());
        String[] res = pc.cercaBranoMusicale("barrington levy",1922);
        for(String str:res) System.out.println(str);
    }*/
}
