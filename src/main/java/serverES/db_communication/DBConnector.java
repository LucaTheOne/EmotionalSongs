/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_communication;

import emotionalsongs.gui.allerter.*;
import java.io.*;
import java.sql.*;
import serverES.*;

/**
 *
 * @author big
 */
public class DBConnector implements Serializable{
    
    private static final long serialVersionUID = 1L;
    protected static final int PORT_TO_DB = 9876;
    public static String SEP = ServerUtils.STRING_SEPARATOR;

    public static Connection getConnection(int DBPort) {
        Connection connection = null;
        final String url = "jdbc:postgresql://localhost:"+DBPort+"/postgres";
        final String id = "postgres";
        final String pswd = "root";
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,id,pswd);
            if(connection!=null){
                System.out.println("Connected to DB");
                return connection;
            } else {
                new PopUpAllert("Error; impossible to connect with DB!");
            }  
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            
        }  
        return null;
    }
    
    public static Connection getDefaultConnection(){
        return getConnection(PORT_TO_DB);
    }
    
    //debugging main
    /** 
    public static void main(String[] args) {
        DBConnector.getConnection(9876);
    }*/
}
