
package bigsdevelopmentstudio.database_builder_emotionalsongs;

import java.sql.*;

/**
 *
 * @author big
 */
public class DBConnector {
    public static Connection getConnection() {
        Connection connection = null;
        final String url = "jdbc:postgresql://localhost:9876/postgres";
        final String id = "postgres";
        final String pswd = "root";
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,id,pswd);
            if(connection!=null){
                System.out.println("Connection to DB estabilished!\n");
                return connection;
            } else {
                System.out.println("error, connection to db failed!\n");
            }  
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    /*
    public static void main(String[] args) {
        DBConnector.getConnection();
    }*/
}
