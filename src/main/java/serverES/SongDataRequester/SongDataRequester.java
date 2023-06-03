//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Eleonora Macchi - 748736 - VA
//Riccardo Maria Rosarin - 749914 -VA

package serverES.SongDataRequester;

import java.sql.*;
import serverES.database_connector.*;

/**
 *
 * @author big
 */
public class SongDataRequester {
    private Connection DBConnection = null;

    public SongDataRequester(Connection DBConnection) {
        this.DBConnection = DBConnection;
    }
    
    public ResultSet requestSongData(String SongID){
        try {
            String query = " SELECT * FROM EMOZIONI WHERE CANZONE_ID = '"+ SongID+"';";
            Statement stm = DBConnection.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
        }
        return null;
    }
    
    private int getResultSetSize(ResultSet rs){
        if(rs != null){
            try {
                rs.last();
                int size = rs.getRow();
                rs.first();
                return size;
            } catch (SQLException ex) {
                System.out.println(ex.getCause());
            }
        }
        return 0;
    }
    
    private String[] resultArray(ResultSet rs){
        String[] resultsArray = new String[getResultSetSize(rs)];
        try {
            rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
        }
        for (int i = 0; i < resultsArray.length; i++) {
            try {
                resultsArray[i] = rs.getString("COMMENTO") + ";" +
                        rs.getInt("MERAVIGLIA") + ";"+
                        rs.getInt("SOLENNITA") + ";" +
                        rs.getInt("TENEREZZA") + ";" +
                        rs.getInt("NOSTALGIA") + ";"+
                        rs.getInt("PACATEZZA") + ";" +
                        rs.getInt("POTERE") + ";" +
                        rs.getInt("GIOIA") + ";"+
                        rs.getInt("TENSIONE") + ";" +
                        rs.getInt("TRISTEZZA") + ";" ;
                
                if(i<resultsArray.length-1) rs.next();
            } catch (SQLException ex) {
                System.out.println(ex.getCause());
            }  
        }
        return resultsArray;
    }
    
    public String resultSetToString(ResultSet rs){
        try {
            String result = "";
            do{
                rs.next();
                result += rs.getString("COMMENTO") + ";" +
                        rs.getInt("MERAVIGLIA") + ";"+
                        rs.getInt("SOLENNITA") + ";" +
                        rs.getInt("TENEREZZA") + ";" +
                        rs.getInt("NOSTALGIA") + ";"+
                        rs.getInt("PACATEZZA") + ";" +
                        rs.getInt("POTERE") + ";" +
                        rs.getInt("GIOIA") + ";"+
                        rs.getInt("TENSIONE") + ";" +
                        rs.getInt("TRISTEZZA") +
                        (rs.isLast()? "" : "<SEP>");
            } while(!rs.isLast());
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    //debugging
    public static void main(String[] args) throws SQLException {
        SongDataRequester sdr = new SongDataRequester(DBConnector.getDBConnection("localhost", 5432));
        ResultSet rs =sdr.requestSongData("TRUEUUK128F92FD462");
        System.out.println(sdr.resultSetToString(rs));    
    }
}
