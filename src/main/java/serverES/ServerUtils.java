/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES;

import serverES.db_connector.DBConnector;
import java.sql.*;
import java.util.*;
import org.apache.commons.lang3.*;

/**
 * Classe contenente metodi utili ai servizi remoti per svolgere i loro rispettivi compiti.
 */
public class ServerUtils {
    
    //COMMON STRINGS
    public static final String STRING_SEPARATOR = "£SEP£";
    
    /**
     * Metodo usato per controllare che la stringa passata come argomento sia composta da soli caratteri ASCII.
     * @param stringToCheck Stringa da controllare.
     * @return true se ci sono solo caratteri ASCII, false altrimenti.
     */
    public static boolean isFitToPostgresql(String stringToCheck){
        if(stringToCheck.isBlank()) return true;
        int ascii;
        char c;
        for(int i = 0; i < stringToCheck.length(); i++) {  
            //per ogni carattere controllo il suo valore ASCII. se supera il numero 128 non rientra nell'ASCII standard
            c = stringToCheck.charAt(i);
            ascii = (int)c;
            if(ascii > 128) return false;
        }
        return true;
        //thx to eleonora for this support method  :)
    }
    
    /**
     * Metodo che si occupa di convertire un result set in un array
     * di stringhe già formattate adeguatamente.
     * @param queryResultSet ResultSet da convertire in array;
     * @return array di stringhe già formattate.
     */
    public static String[] convToArrayStr(ResultSet queryResultSet) {
        try {
            // se il result set è null ritorna null.
            if(queryResultSet == null) return null;
            
            ResultSetMetaData metaData = queryResultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            Vector<String> listaRisultati = new Vector<>();
            
            while (queryResultSet.next()){
                String stringaFormattata = "";
                for (int i = 0; i < numberOfColumns; i++) {    
                    stringaFormattata+=queryResultSet.getString(i+1) + (i==numberOfColumns-1? "":DBConnector.SEP);
                }
                listaRisultati.add(stringaFormattata);
            }
            if(listaRisultati.isEmpty()) return null;
            return fromVectorToArrayFormatted(listaRisultati);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Metodo interno di supporto al metodo convertResultToArrayString(ResultSet queryResultSet)
     * che si occupa semplicemente di convertire una lista di stringhe in un array.
     * @param stringVector lista da trasformare in array.
     * @return Array di stringhe formattate ottenuto dalla lista passata come argomento.
     */
    public static String[] fromVectorToArrayFormatted(Vector<String> stringVector){
        int dimension = stringVector.size();
        String[] array = new String[dimension];
        for(int i= 0; i<dimension; i++){
            array[i] = stringVector.get(i);
        }
        return array;
    }
    
    /** 
     * metodo interno di supporto al metodo updatePlaylistTable() che si occupa sia di generare idUnivoci, che verificare
     * che questo sia realmente unico, finchè non ne trova uno unico continua a generali.
     * @return Stringa con id univoco.
     */
    public static String generateIdUnique(int lenght,Connection connectionToDB) {
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
}
