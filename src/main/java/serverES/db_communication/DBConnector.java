/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_communication;

import java.sql.*;

/**
 *
 * @author big
 */
public class DBConnector {
    
    protected static final int PORT_TO_DB = 9876;
    
    public static Connection getConnection(int DBPort) {
        Connection connection = null;
        final String url = "jdbc:postgresql://localhost:9876/postgres";
        final String id = "postgres";
        final String pswd = "root";
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,id,pswd);
            if(connection!=null){
                System.out.println("Connected to DB");
                return connection;
            } else {
                System.out.println("Error");
            }  
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        DBConnector.getConnection(9876);
    }
}
