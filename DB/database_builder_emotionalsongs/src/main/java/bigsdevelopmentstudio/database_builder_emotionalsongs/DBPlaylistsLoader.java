
package bigsdevelopmentstudio.database_builder_emotionalsongs;

import java.io.*;
import java.sql.*;
import org.apache.commons.lang.*;


/**
 *
 * @author big
 */
public class DBPlaylistsLoader {
    
    private Connection connector = null;
    private String currentLine = "";
    private String sourcePath = "/Users/big/Coding/javaDevelopment/GitHub/EmotionalSongs/data/Playlist.dati.txt";
    private File initializationFile = new File(sourcePath);
    public DBPlaylistsLoader(Connection DBConnection) {
        connector = DBConnection;
    }
    
    public synchronized void insertUsersplaylists(){
        try {
            BufferedReader reader = new BufferedReader( new FileReader(initializationFile));
            currentLine = reader.readLine();
            String[] currentLineSplittedIDUser;
            String[] currentLineSplittedPlaylists;
            String idUser;
            String currentPlaylistName;
            String[] currentsIdsSongs;
            
            System.out.println("Loading to DB users' playlists...\n\n");
            while(currentLine != null) {
                System.out.print("Current line threated: "+currentLine+"...");
                currentLineSplittedIDUser = currentLine.split("<EUID>");
                currentLineSplittedPlaylists = currentLineSplittedIDUser[1].split("<EPLS>");
                idUser = currentLineSplittedIDUser[0];
                
                for(int i=0;i<currentLineSplittedPlaylists.length;i++){
                    String idUniqueCurrentPlaylist = IDUniquegenerator.generateUniqueId();
                    currentPlaylistName = currentLineSplittedPlaylists[i].split(":")[0];
                    try {
                        String queryPlaylists = "INSERT INTO PLAYLIST(ID_PLAYLIST,USER_PROP_ID,NOME_PLAYLIST) VALUES(?,?,?);";
                        PreparedStatement statementPlaylist = connector.prepareStatement(queryPlaylists);
                        statementPlaylist.setString(1, idUniqueCurrentPlaylist);
                        statementPlaylist.setString(2, idUser);
                        statementPlaylist.setString(3, currentPlaylistName);
                        statementPlaylist.execute();
                        System.out.println("    Loaded playlist table with: "+ currentPlaylistName + ", having id unique: "+idUniqueCurrentPlaylist);
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    currentsIdsSongs = currentLineSplittedPlaylists[i].split(":")[1].split("<SEP>");

                    for (int j = 0; j < currentsIdsSongs.length; j++) {
                        try{
                            String querySongsInPlaylist = "INSERT INTO CONTENUTO_PLAYLIST(PLAYLIST_ID,CANZONE_ID) VALUES(?,?);";
                            PreparedStatement statementPlaylistContents = connector.prepareStatement(querySongsInPlaylist);
                            statementPlaylistContents.setString(1, idUniqueCurrentPlaylist);
                            statementPlaylistContents.setString(2, currentsIdsSongs[j]);
                            statementPlaylistContents.execute();
                        } catch (SQLException e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
                System.out.println("    added to DB!\n");            
                currentLine = reader.readLine();
            } 
            System.out.println("\n\n All users' playlists had been loaded to DB!\n\n");
        } catch (FileNotFoundException ex) {
            ex.getCause();
        } catch (IOException ex) {
            ex.getCause();
        }
       
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
                PreparedStatement statementPlaylist = connector.prepareStatement(query);
                statementPlaylist.setString(1, id);
                statementPlaylist.setString(2, titolo);
                statementPlaylist.setString(3, autore);
                statementPlaylist.setInt(4, annoint);
                System.out.println(statementPlaylist.executeUpdate());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }*/
    
    private class IDUniquegenerator {

        private static final int ID_LENGTH = 20;

        private static String generateUniqueId() {
            return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
        }
    }
    
}
