//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Eleonora Macchi - 748736 - VA
//Riccardo Maria Rosarin - 749914 -VA

package serverES.database_connector;

import java.sql.*;

/**
 * Classe contenente un solo metodo statico "getConnection(String hostAddress,int hostPort)" 
 * il cui ruolo è quello di fornire un oggetto di tipo Connection rappresentante la connessione
 * con il DB di cui si ha passato indirizzo e porta come argomenti.
 */
public class DBConnector {
    private static Connection DBConnector = null;
    
    /**
     * Metodo che restituisce un oggetto di tipo Connection che rappresenta la connessione
     * con il DataBase di cui si hanno passato, come argomenti, indirizzo e porta d' accesso.
     * Se database e server (software che utilizza questo metodo) risiedono sulla stessa macchina
     * si può passare come primo argomento "localhost" oppure "127.0.0.1".
     * @param hostAddress Indirizzo IP della macchina su cui risiede il DataBase a cui ci si vuole Connettere.
     * @param hostPort Porta di accesso al DataBase
     * @return Oggetto di tipo Connection rappresentante la connessione ad un database.
     */
    private DBConnector (String hostAddress,int hostPort) {
        Connection connection = null;
        final String url = "jdbc:postgresql://"+hostAddress+":"+hostPort+"/postgres";
        final String id = "postgres";
        final String pswd = "root";
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,id,pswd);
            if(connection!=null){
                System.out.println("Connection to DB successfully Established!");
                DBConnector = connection;
            } else {
                throw new DBConnectionException("Connection to DB failed!");
            }  
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Connection getDBConnection(){
        if (DBConnector == null) {
            System.out.println("Errore: non è presenta alcuna connessione ad un DB!");
        }
        return DBConnector;
    }
    
    public static Connection getDBConnection(String hostAddress,int hostPort){
        new DBConnector(hostAddress,hostPort);
        return DBConnector;
    }
    
    public static void main(String[] args) {
        getDBConnection("localhost", 5432);
    }
}
