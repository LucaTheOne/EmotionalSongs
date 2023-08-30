/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_connector;

import emotionalsongs.clientES.gui.allerter.*;
import java.io.*;
import java.sql.*;
import serverES.*;

/**
 *
 * @author big
 */
public class DBConnector implements Serializable{
    
    private static final long serialVersionUID = 1L;
    protected static int PORT_TO_DB;
    public static String SEP = ServerUtils.STRING_SEPARATOR;
    public static Connection connection;
    
    protected static void connectToPostgres(String idPostgres,String passwordPostgres,int portPostgres) {
        PORT_TO_DB = portPostgres;
        final String url = "jdbc:postgresql://localhost:"+portPostgres+"/postgres";
        final String id = idPostgres;
        final String pswd = passwordPostgres;
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,id,pswd);
            if(connection!=null){
                new PopUpAllert("Connected to DB!");
            } else {
                new PopUpAllert("Error; impossible to connect with DB!");
            }  
        } catch (ClassNotFoundException | SQLException e) {
            new PopUpAllert(e.getMessage());          
        }  
    }
    
    public static Connection getConnection(){
        return connection;
    }
    // only for texting purpose
    public static Connection getTextConn(){
        connectToPostgres("postgres", "root", 9876);
        return connection;
    }
    
    //debugging main
    /** 
    public static void main(String[] args) {
        DBConnector.getConnection(9876);
    }*/
}
