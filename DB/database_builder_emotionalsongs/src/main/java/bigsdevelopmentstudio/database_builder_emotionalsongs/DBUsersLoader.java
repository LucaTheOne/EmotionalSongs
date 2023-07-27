
package bigsdevelopmentstudio.database_builder_emotionalsongs;

import java.io.*;
import java.sql.*;

/**
 *
 * @author big
 */
public class DBUsersLoader {
    private int index = 0;
    private Connection connector = null;
    private String currentString = "";
    private String sourcePath = "/home/lola/repo/EmotionalSongs/data/UtentiRegistrati.dati.txt"; //da modificare secondo il proprio path
    private File initializationFile = new File(sourcePath);
    public DBUsersLoader(Connection DBConnection) {
        connector = DBConnection;
    }
    
    public synchronized boolean insertUsers(){
        try {
            BufferedReader reader = new BufferedReader( new FileReader(initializationFile));
            currentString = reader.readLine();
            System.out.println("Loading to DB all users' accounts...\n\n");
            while(currentString != null) {
                //System.out.println(currentString);
                String idUser,password,CF,nome,cognome,email;
                Date dataNascita;
                String[] currentSplitted = currentString.replace(";", "").split("<SEP>");
                idUser=currentSplitted[0];
                password = currentSplitted[1];
                CF= currentSplitted[2];
                nome = currentSplitted[3];
                cognome = currentSplitted[4];
                String[] dataNascitaSplitted = currentSplitted[5].split("/");
                int giorno,mese,anno;
                giorno = Integer.parseInt(dataNascitaSplitted[0]);
                mese = Integer.parseInt(dataNascitaSplitted[1]);
                anno = Integer.parseInt(dataNascitaSplitted[2]);
                dataNascita = new java.sql.Date(anno,mese,giorno);
                email = currentSplitted[6];
                
                String query = "INSERT INTO UTENTI_REGISTRATI(ID_USER,EMAIL,CF,PASSWORD,NOME,COGNOME,DATA_NASCITA) VALUES(?,?,?,?,?,?,?);";
                
                try {
                    PreparedStatement statement = connector.prepareStatement(query);
                    statement.setString(1, idUser);
                    statement.setString(2, email);
                    statement.setString(3, CF);
                    statement.setString(4, password);
                    statement.setString(5, nome);
                    statement.setString(6, cognome);
                    statement.setDate(7, dataNascita);
                    statement.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(currentString.replace("<SEP>"," ") + "error data in this line!");
                    System.out.println(ex.getMessage());
                    currentString = reader.readLine();
                    continue;
                }
                
                System.out.println(currentString.replace("<SEP>"," ") + " successfully added!");
                currentString = reader.readLine();
            } 
            System.out.println("All users had been loaded to db!\n\n");
        } catch (FileNotFoundException ex) {
            ex.getCause();
        } catch (IOException ex) {
            ex.getCause();
        }
       return true;
    }
    
    
  /*  public static void main(String[] args) {
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
