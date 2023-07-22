
package serverES.db_communication;

import java.io.*;
import java.sql.*;

/**
 *
 * @author big
 */
public class QuerierTemplate {
    private int index = 0;
    Connection connector = null;
    String currentString = "";
    File initializationFile = new File("/Users/big/Desktop/FiveHundredThousandSongs.txt");
    public QuerierTemplate(Connection DBConnection) {
        connector = DBConnection;
    }
    
    public synchronized boolean insertSongs(Connection connector){
        try {
            BufferedReader reader = new BufferedReader( new FileReader(initializationFile));
            currentString = reader.readLine();
            System.out.println(currentString);
            while(currentString != null) {
                //System.out.println(currentString);
                String id,titolo,autore;
                int anno;
                id=currentString.split("<SEP>")[1];
                titolo = currentString.split("<SEP>")[3];
                autore = currentString.split("<SEP>")[2];
                anno = Integer.parseInt(currentString.split("<SEP>")[0]);
                String query = "INSERT INTO CANZONI(REPO_INDEX,ID_UNIVOCO,TITOLO,AUTORE,ANNO) VALUES(?,?,?,?,?);";
                PreparedStatement statement = connector.prepareStatement(query);
                statement.setInt(1, index++);
                statement.setString(2, id);
                statement.setString(3, titolo);
                statement.setString(4, autore);
                statement.setInt(5, anno);
                statement.executeUpdate();
                //System.out.println(currentString.replace("<SEP>"," ") + " added!");
                currentString = reader.readLine();
            } 
            System.out.println("OK!");
        } catch (FileNotFoundException ex) {
            ex.getCause();
        } catch (IOException ex) {
            ex.getCause();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
       return true;
    }
    
    /*
    public static void main(String[] args) {
        try {
                String currenString = "1922<SEP>TRSGHLU128F421DF83<SEP>Alberta Hunter<SEP>Don't Pan Me";
                String id,titolo,autore,anno;
                id=currenString.split("<SEP>")[1];
                titolo = currenString.split("<SEP>")[3];
                autore = currenString.split("<SEP>")[2];
                anno = currenString.split("<SEP>")[0];
                int annoint = Integer.parseInt(anno);
                String query = "INSERT INTO CANZONI(ID,TITOLO,AUTORE,ANNO) VALUES(?,?,?,?);";
                Connection connector = DBConnector.getConnection();
                PreparedStatement statement = connector.prepareStatement(query);
                statement.setString(1, id);
                statement.setString(2, titolo);
                statement.setString(3, autore);
                statement.setInt(4, annoint);
                System.out.println(statement.executeUpdate());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }*/
}
