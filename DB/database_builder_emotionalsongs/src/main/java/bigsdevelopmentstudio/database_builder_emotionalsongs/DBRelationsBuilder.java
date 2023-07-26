/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package bigsdevelopmentstudio.database_builder_emotionalsongs;

import java.sql.*;

/**
 *
 * @author big
 */
public class DBRelationsBuilder {
    
    private Connection connectionToDB;

    public DBRelationsBuilder(Connection connection) {
        connectionToDB = connection;
    }
    
    private void buildCanzoniTable() throws SQLException{
        String CanzoniTable = "CREATE TABLE CANZONI ( " +
                                "ID_UNIVOCO VARCHAR(20) PRIMARY KEY, " +
                                "REPO_INDEX INT UNIQUE, " +
                                "TITOLO VARCHAR NOT NULL, " +
                                "AUTORE VARCHAR NOT NULL, " +
                                "ANNO INT NOT NULL);";
        Statement statement = connectionToDB.createStatement();
        statement.executeUpdate(CanzoniTable);
        statement.close();
        System.out.println("Table CANZONI created!");
    }
    
    private void buildUtenti_RegistratiTable() throws SQLException{
        String UtentiTable = "CREATE TABLE UTENTI_REGISTRATI ( " +
                                "ID_USER VARCHAR(20) PRIMARY KEY, " +
                                "EMAIL VARCHAR UNIQUE NOT NULL, " +
                                "CF VARCHAR(16) UNIQUE NOT NULL, " +
                                "PASSWORD VARCHAR(20) NOT NULL, " +
                                "NOME VARCHAR NOT NULL, "+
                                "COGNOME VARCHAR NOT NULL, "+
                                "DATA_NASCITA DATE NOT NULL);";
        Statement statement = connectionToDB.createStatement();
        statement.executeUpdate(UtentiTable);
        statement.close();
        System.out.println("Table UTENTI_REGISTRATI created!");
    }
    
    private void buildIndirizziTable() throws SQLException{
        String IndirizziTable = "CREATE TABLE INDIRIZZI ( " +
                                    "RESIDENTE_ID VARCHAR(20) PRIMARY KEY, " +
                                    "TIPO VARCHAR(11) NOT NULL, " +
                                    "INDIRIZZO VARCHAR(255) NOT NULL, " +
                                    "CIVICO INT NOT NULL, " +
                                    "CAP INT NOT NULL, " +
                                    "NAZIONE VARCHAR(20) NOT NULL, " +
                                    "PROVINCIA VARCHAR(20) NOT NULL, " +
                                    "CITTA VARCHAR(20) NOT NULL);";
        String foreignKey = "ALTER TABLE INDIRIZZI ADD FOREIGN KEY (RESIDENTE_ID) REFERENCES UTENTI_REGISTRATI(ID_USER) ON UPDATE CASCADE ON DELETE CASCADE;";
        //String tipoIndirizzoOk = "ALTER TABLE INDIRIZZI ADD CONSTRAINT TIPO_INDIRIZZO_OK CHECK( TIPO IN(‘Via’,’Viale’,’ControViale’,’Piazza’,’Piazzetta’,’Salita’,’Discesa’));"; non funziona
        Statement statement = connectionToDB.createStatement();
        statement.executeUpdate(IndirizziTable);
        statement.executeUpdate(foreignKey);
        statement.close();
        System.out.println("Table INDIRIZZI created!");
    }
    
    private void buildPlaylistTable() throws SQLException{
        String playlistTable = "CREATE TABLE PLAYLIST ( "+
                "ID_PLAYLIST VARCHAR(20) PRIMARY KEY, "+
                "USER_PROP_ID VARCHAR(20) NOT NULL, "+
                "NOME_PLAYLIST VARCHAR DEFAULT 'NewPlaylist');";
        String foreignKey = "ALTER TABLE PLAYLIST ADD FOREIGN KEY(USER_PROP_ID) REFERENCES UTENTI_REGISTRATI(ID_USER) ON UPDATE CASCADE ON DELETE CASCADE;";
        Statement statement = connectionToDB.createStatement();
        statement.executeUpdate(playlistTable);
        statement.executeUpdate(foreignKey);
        statement.close();
        System.out.println("Table PLAYLIST created!");
    }
    
    private void buildContenuto_PlaylistTable() throws SQLException{
        String contenuto_playlist = "CREATE TABLE CONTENUTO_PLAYLIST ( "+
                "PLAYLIST_ID VARCHAR(20), "+
                "CANZONE_ID VARCHAR(20), "+
                "PRIMARY KEY(PLAYLIST_ID,CANZONE_ID));";
        String foreignKey = "ALTER TABLE CONTENUTO_PLAYLIST ADD FOREIGN KEY(PLAYLIST_ID) REFERENCES PLAYLIST(ID_PLAYLIST) ON DELETE CASCADE ON UPDATE CASCADE;";
        String foreignKey2 = "ALTER TABLE CONTENUTO_PLAYLIST ADD FOREIGN KEY(CANZONE_ID) REFERENCES CANZONI(ID_UNIVOCO) ON DELETE CASCADE ON UPDATE CASCADE;";
        Statement statement = connectionToDB.createStatement();
        statement.executeUpdate(contenuto_playlist);
        statement.executeUpdate(foreignKey);
        statement.executeUpdate(foreignKey2);
        statement.close();
        System.out.println("Table CONTENUTO_PLAYLIST created!");
    }
    
    private void buildEmozioniTable() throws SQLException{
        String Emozioni = "CREATE TABLE EMOZIONI ( " +
            "USER_PROP_ID VARCHAR(20), " +
            "CANZONE_ID VARCHAR(20), " +
            "COMMENTO VARCHAR(256), " +
            "MERAVIGLIA INT CHECK(MERAVIGLIA BETWEEN 1 AND 5) NOT NULL, " +
            "SOLENNITA INT CHECK(SOLENNITA BETWEEN 1 AND 5) NOT NULL, " +
            "TENEREZZA INT CHECK(TENEREZZA BETWEEN 1 AND 5) NOT NULL, " +
            "NOSTALGIA INT CHECK(NOSTALGIA BETWEEN 1 AND 5) NOT NULL, " +
            "PACATEZZA INT CHECK(PACATEZZA BETWEEN 1 AND 5) NOT NULL, " +
            "POTERE INT CHECK(POTERE BETWEEN 1 AND 5) NOT NULL, " +
            "GIOIA INT CHECK(GIOIA BETWEEN 1 AND 5) NOT NULL, " +
            "TENSIONE INT CHECK(TENSIONE BETWEEN 1 AND 5) NOT NULL, " +
            "TRISTEZZA INT CHECK(TRISTEZZA BETWEEN 1 AND 5) NOT NULL, " +
            "PRIMARY KEY(USER_PROP_ID,CANZONE_ID));";
        String foreignKey1 = "ALTER TABLE EMOZIONI ADD FOREIGN KEY(CANZONE_ID) REFERENCES CANZONI(ID_UNIVOCO) ON DELETE CASCADE ON UPDATE CASCADE;";
        String foreignKey2 = "ALTER TABLE EMOZIONI ADD FOREIGN KEY(USER_PROP_ID) REFERENCES UTENTI_REGISTRATI(ID_USER) ON DELETE CASCADE ON UPDATE CASCADE;";
        Statement statement = connectionToDB.createStatement();
        statement.executeUpdate(Emozioni);
        statement.executeUpdate(foreignKey1);
        statement.executeUpdate(foreignKey2);
        statement.close();
        System.out.println("Table Emozioni created!");
    }
    
    public void createDBTables() {
        try {
            buildCanzoniTable();
            buildUtenti_RegistratiTable();
            buildIndirizziTable();
            buildPlaylistTable();
            buildContenuto_PlaylistTable();
            buildEmozioniTable();
            System.out.println("DB created with success!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
