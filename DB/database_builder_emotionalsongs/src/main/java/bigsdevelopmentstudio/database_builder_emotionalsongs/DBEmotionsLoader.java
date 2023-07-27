
package bigsdevelopmentstudio.database_builder_emotionalsongs;

import java.io.*;
import java.sql.*;

/**
 *
 * @author big
 */
public class DBEmotionsLoader {
    private Connection connector = null; // la connessione con il DB.
    private String currentString = ""; //buffer contenente la stringa correntemente trattata.
    private String sourcePath = "/home/lola/repo/EmotionalSongs/data/Emozioni.dati.txt"; //da modificare secondo il proprio path
    private File initializationFile = new File(sourcePath);
    public DBEmotionsLoader(Connection DBConnection) {
        connector = DBConnection;
    }
    
    public synchronized boolean insertEmos(){
        try {
            BufferedReader reader = new BufferedReader( new FileReader(initializationFile));
            currentString = reader.readLine();
            System.out.println("Loading to DB info about Emotions...\n\n");
            while(currentString != null) {
                System.out.println("current line of file threated: "+currentString);
                String idSong,idUser,commento;
                int[] arrayVoti = new int[9];
                String currentSplitted[] = currentString.split(";");
                idSong = currentSplitted[0];
                idUser = currentSplitted[1];
                commento = currentSplitted[2];
                for(int i = 3; i<currentSplitted.length;i++){
                    for(int j = 0; j<arrayVoti.length;j++){
                        arrayVoti[j] = Integer.parseInt(currentSplitted[i]);
                    }
                }
                String queryEmotions = "INSERT INTO EMOZIONI(USER_PROP_ID,CANZONE_ID,COMMENTO,MERAVIGLIA,SOLENNITA,TENEREZZA,NOSTALGIA,PACATEZZA,POTERE,GIOIA,TENSIONE,TRISTEZZA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
                
                try {
                    PreparedStatement statement = connector.prepareStatement(queryEmotions);
                    statement.setString(1, idUser);
                    statement.setString(2, idSong);
                    statement.setString(3, commento);
                    statement.setInt(4,arrayVoti[0]);
                    statement.setInt(5,arrayVoti[1]);
                    statement.setInt(6,arrayVoti[2]);
                    statement.setInt(7,arrayVoti[3]);
                    statement.setInt(8,arrayVoti[4]);
                    statement.setInt(9,arrayVoti[5]);
                    statement.setInt(10,arrayVoti[6]);
                    statement.setInt(11,arrayVoti[7]);
                    statement.setInt(12,arrayVoti[8]);
                    statement.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                
                System.out.println(currentString.replace(";"," ") + " successfully added to database!\n");
                currentString = reader.readLine();
            } 
            System.out.println("all users loaded!\n");
        } catch (FileNotFoundException ex) {
            ex.getCause();
        } catch (IOException ex) {
            ex.getCause();
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
                String queryEmotions = "INSERT INTO CANZONI(ID,TITOLO,AUTORE,ANNO) VALUES(?,?,?,?);";
                Connection connector = DBConnector.getConnection();
                PreparedStatement statement = connector.prepareStatement(queryEmotions);
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
