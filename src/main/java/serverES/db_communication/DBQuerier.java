/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.db_communication;

import java.sql.*;
import java.util.*;
import org.apache.commons.lang3.*;

/**
 *
 * @author big
 */
public class DBQuerier {
    
    private Connection connectionToDB;
    private String divider = "£SEP£";

    public DBQuerier(Connection connectionToDB) {
        this.connectionToDB = connectionToDB;
    }
    
    /**
     * Metodo che ritorna un array di stringhe, in ogni sua posizione ci sono i dati
     * di una canzone cui il titolo coincide alla stringa passata come argomento, 
     * oppure che vi è contenuta in esso.
     * NB: i match precisi sono nelle prime posizioni dell' array.
     * @param title Stringa da cercare nei titoli delle canzoni.
     * @return array di stringhe rappresentanti le canzoni che soddisfano i criteri di ricerca.
     */
    public String[] cercaBranoMusicale(String title){
        try {
            String query = "SELECT ID_UNIVOCO,TITOLO,AUTORE,ANNO FROM CANZONI WHERE LOWER(TITOLO) LIKE LOWER('%"+title+"%') ORDER BY TITOLO,AUTORE,ANNO ASC;";
            
            Statement statement = connectionToDB.createStatement();
            statement = connectionToDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            String[] resultArray = convertResultToArrayString(queryResult);
            statement.close();
            return resultArray;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Metodo che ritorna un array di stringhe, in ogni sua posizione ci sono i dati
     * di una canzone cui il autore coincide alla stringa passata come argomento, 
     * oppure che vi è contenuta in esso e l' anno coincide con l' intero passato come argomento.
     * @param author Stringa da cercare negli autori delle canzoni.
     * @param year Anno delle canzoni ricercate
     * @return array di stringhe rappresentanti le canzoni che soddisfano i criteri di ricerca.
     */
    public String[] cercaBranoMusicale(String author, int year){
        try {
            String query = "SELECT ID_UNIVOCO,TITOLO,AUTORE,ANNO FROM CANZONI WHERE LOWER(AUTORE) LIKE LOWER('%"+author+"%') INTERSECT SELECT ID_UNIVOCO,TITOLO,AUTORE,ANNO FROM CANZONI WHERE ANNO = "+year+" ORDER BY ANNO,AUTORE,TITOLO ASC;";
            
            Statement statement = connectionToDB.createStatement();
            statement = connectionToDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            String[] resultArray = convertResultToArrayString(queryResult);
            statement.close();
            return resultArray;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Metodo che ritorna un array di canzoni comprese tra i due indici (che sono compresi).
     * Gli elementi sono adeguatamente formattati come da interfaccia "DataManager".
     * @param startIndex indice prima canzone.
     * @param endIndex indice ultima canzone.
     * @return Array di stringhe con i dati delle canzoni contenute tra startIndex ed endIndex compresi.
     */
    public String[] getSongsBeetweenIndexes(int startIndex,int endIndex) {
        try {
            String query = "SELECT * FROM CANZONI WHERE REPO_INDEX BETWEEN "+startIndex+" AND "+endIndex+";";
            Statement statement = connectionToDB.createStatement();
            ResultSet queryResult = statement.executeQuery(query);
            String[] results = convertResultToArrayString(queryResult);
            return results;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Metodo che si occupa di aggiungere al db una nuova playlist.
     * Le sue operazioni compongono una transazione, se qualcosa va storto viene annullato tutto.
     * NB: genera anche l' id univoco per la nuova playlist.
     * @param newPlaylistName Nome della nuova playlist.
     * @param userIdOwner ID univoco del proprietario della playlist
     * @param idsSongs Contenuto della playlist, che verrà inserito nella tabella contenuto_playlist.
     * @return 0 - operazione avvenuta con successo.
     * 1 - transazione abortita.
     */
    public int updatePlaylistTable(String newPlaylistName,String userIdOwner,String[] idsSongs) {
        //query to update playlist table.
        String queryPlaylist = "INSERT INTO PLAYLIST(ID_PLAYLIST,USER_PROP_ID,NOME_PLAYLIST) VALUES(?,?,?);";
        //query to update contenuto_playlist table.
        String queryContenuto_playlist = "INSERT INTO CONTENUTO_PLAYLIST(PLAYLIST_ID,CANZONE_ID) VALUES (?,?);";
        //generate an unique id for this new playlist.
        String idUniqueNewPlaylist = generateIdUnique(20);
        
        //statement to build's container
        PreparedStatement statement = null;
        
        //disable the autocommit, this operation need to be a transaction; if something went wrong, all operation must been aborted.
        try {
            connectionToDB.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Impossible to start transaction!");
            System.out.println(ex.getMessage());
            return 1;
        }
        
        //prepare and execute the statement to insert a new playlist in the db.
        try {
            statement = connectionToDB.prepareStatement(queryPlaylist);
            statement.setString(1, idUniqueNewPlaylist);
            statement.setString(2, userIdOwner);
            statement.setString(3, newPlaylistName);
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            try {
                System.out.println("Impossible to insert the new playlist, transation aborted!");
                System.out.println(ex.getMessage());
                connectionToDB.rollback(); //everithing is aborted
                return 1;
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
                return 1;
            }
        }
        
        //prepare and execute the statement to update contenuto_playlist, every line is composed by the new playlist id and one song id in it.
        try {
            statement = connectionToDB.prepareStatement(queryContenuto_playlist);
            //Create in the DB one line for each song in the playlist.
            for (int i = 0; i < idsSongs.length; i++) {
                statement.setString(1, idUniqueNewPlaylist);
                statement.setString(2, idsSongs[i]);
                statement.execute();
            }
            statement.close();
        } catch (SQLException ex) {
            try {
                System.out.println("Impossible to insert some songs, transation aborted!");
                System.out.println(ex.getMessage());
                connectionToDB.rollback();
                return 1;
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
                return 1;
            }
        }
        
        //at the moment all gone right, now it try to commit the transaction.
        try {
            connectionToDB.commit();
        } catch (SQLException ex) {
            System.out.println("Impossible to commit, operation aborted!");
            System.out.println(ex.getMessage());
            return 1;
        }
        
        // now autocommit is reabled.
        try {
            connectionToDB.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        //all is gone right
        return 0;
    }
    
    /**
     * Metodoche si occupa di aggiornare la tabella Emozioni con un nuovo giudizio emozionale.
     * il metodo controlla da solo la lunghezza del commento ed il numero di voti.
     * @param idUser Id dell' utente che effettua il giudizio emozionale.
     * @param idSong Id della canzone giudicata dall' utente.
     * @param emotionalMarks array con i voti emozionali nel seguente ordine: [MERAVIGLIA,SOLENNITA,TENEREZZA,NOSTALGIA,PACATEZZA,POTERE,GIOIA,TENSIONE,TRISTEZZA].
     * @param comment commento opzionale.
     * @return 0 - operazione completata con successo.
     * 1 - errore db.
     * 2 - dati non validi.
     */
    public int updateEmozioniTable(String idUser,String idSong,int[] emotionalMarks,String comment){
        //control marks array
        if(emotionalMarks.length!=9){
            System.out.println("Error MARKS data invalid");
            return 2;
        }
        //control comment length
        if (comment.length()>256) {
            System.out.println("Error comment contain too characters, max: 256, actual: "+comment.length());
            return 2;
        }
        //string with the needed query
        String queryEmotions = "INSERT INTO EMOZIONI(USER_PROP_ID,CANZONE_ID,COMMENTO,MERAVIGLIA,SOLENNITA,TENEREZZA,NOSTALGIA,PACATEZZA,POTERE,GIOIA,TENSIONE,TRISTEZZA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            PreparedStatement statement = connectionToDB.prepareStatement(queryEmotions);
            statement.setString(1, idUser);
            statement.setString(2, idSong);
            statement.setString(3, comment);
            for(int i = 4; i<13; i++){
                statement.setInt(i, emotionalMarks[i-4]);
            }
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error: impossible to update Emozioni table!");
            System.out.println(ex.getCause());
            return 1;
        }
        return 0;
    }
    
    //metodi di supporto interni alla classe.
    /**
     * Metodo interno alla classe di supporto, si occupa di convertire un result set in un array
     * di stringhe già formattate adeguatamente.
     * @param queryResultSet ResultSet da convertire in array;
     * @return array di stringhe già formattate.
     */
    private String[] convertResultToArrayString(ResultSet queryResultSet) {
        try {
            // se il result set è null ritorna null.
            if(queryResultSet == null) return null;
            
            ResultSetMetaData metaData = queryResultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            Vector<String> listaRisultati = new Vector<>();
            
            while (queryResultSet.next()){
                String stringaFormattata = "";
                for (int i = 0; i < numberOfColumns; i++) {    
                    stringaFormattata+=queryResultSet.getString(i+1) + (i==numberOfColumns-1? "":divider);
                }
                listaRisultati.add(stringaFormattata);
            }
            if(listaRisultati.isEmpty()) return null;
            return fromVectorToArray(listaRisultati);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Metodo interno di supporto al metodo convertResultToArrayString(ResultSet queryResultSet)
     * che si occupa semplicemente di convertire una lista di stringhe in un array.
     * @param stringVector lista da trasformare in array.
     * @return array derivato dalla lista passata come argomento.
     */
    private String[] fromVectorToArray(Vector<String> stringVector){
        int dimension = stringVector.size();
        String[] array = new String[dimension];
        for(int i= 0; i<dimension; i++){
            array[i] = stringVector.get(i);
        }
        return array;
    }
    
    /** metodo interno di supporto al metodo updatePlaylistTable() che si occupa sia di generare idUnivoci, che verificare
     * che questo sia realmente unico, finchè non ne trova uno unico continua a generali.
     * @return Stringa con id univoco.
     */
    private String generateIdUnique(int lenght) {
        
            String idProposed = RandomStringUtils.randomAlphanumeric(lenght);
            boolean unique = false;
            final String controlQuery = "SELECT COUNT(ID_PLAYLIST) FROM PLAYLIST WHERE ID_PLAYLIST = ?;";
        try {    
            PreparedStatement statementControl = connectionToDB.prepareStatement(controlQuery);
            statementControl.setString(1, idProposed);
            ResultSet resultSet = statementControl.executeQuery();
            resultSet.next();
            while(!unique){
                int result = resultSet.getInt(1);
                unique = (result == 0);
                if(!unique){
                    idProposed = RandomStringUtils.randomAlphanumeric(20);
                    statementControl = connectionToDB.prepareStatement(controlQuery);
                    statementControl.setString(1, idProposed);
                    resultSet.next();
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Impossible to generate id unique!");
            System.out.println(ex.getMessage());
            return null;
        }
        return idProposed;
    }
    
    //debugger and test main
    public static void main(String[] args) {
        
        DBQuerier querier = new DBQuerier(DBConnector.getConnection(DBConnector.PORT_TO_DB));
        
        //String[] res = querier. getSongsBeetweenIndexes(0, 10);
        //for(int i = 0; i<res.length;i++){
        //  System.out.println(res[i]);
        //}
         
        
        //String[] ids = {"TRMYDFV128F42511FC","TRRAHXQ128F42511FF","TRFAFTK12903CC77B8","TRSTBUY128F4251203","TRODGCA128F4251206"};
        //querier.updatePlaylistTable("playlist caricata da java", "theOne",ids );
        
        
        //querier.updateEmozioniTable("theOne", "TRWSZDB128F934171B", new int[]{1,2,3,4,5,4,3,2,1}, "commento prova da java");
        
        //String[] result = querier.cercaBranoMusicale("titolo");
        //if(result == null){
            //System.out.println("No songs founded!");
        //} else {
            //for(int i = 0; i<result.length;i++){
                //System.out.println(result[i]);
            //}
        //}
    }
}
