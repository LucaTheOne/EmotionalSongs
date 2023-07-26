
package bigsdevelopmentstudio.database_builder_emotionalsongs;

import java.sql.*;


/**
 *
 * @author big
 */
public class Database_builder_emotionalsongs {
    
    public static void main(String[] args) {
        Connection connection = DBConnector.getConnection();
        boolean ok = true;
        DBRelationsBuilder DBStructureBuilder = new DBRelationsBuilder(connection);
        DBStructureBuilder.createDBTables();
        
        DBRepoLoader repoLoader = new DBRepoLoader(connection);
        repoLoader.insertSongs();
        DBUsersLoader usersLoader = new DBUsersLoader(connection);
        usersLoader.insertUsers();
        DBPlaylistsLoader playlistsLoader = new DBPlaylistsLoader(connection);
        playlistsLoader.insertUsersplaylists();
        DBEmotionsLoader emotionsLoader = new DBEmotionsLoader(connection);
        emotionsLoader.insertEmos();
        
        System.out.println("DB SUCCESSFULLY LOADED WITH ALL AVAIABLE AND VALID DATA!");
    }
}
