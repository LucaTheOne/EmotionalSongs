/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES.server_services.emozioni;

import serverES.utils.ServerUtils;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
//import serverES.*;
import serverES.server_services_common_interfaces.data_handler.*;

/**
 *
 * @author big
 */
public class ProxyToDBEmozioni extends UnicastRemoteObject implements EmotionsDataHandler {
    
    private static final long serialVersionUID = 1L;
    private final Connection CONNECTION_TO_DB;
    
    /**
     * Metodo costruttore della classe
     * @param DBConn: istanza di connessione al database
     * @throws RemoteException: sollevata nel caso la connessione al database dovesse fallire
     */
    public ProxyToDBEmozioni(Connection DBConn) throws RemoteException{
        super();
        CONNECTION_TO_DB = DBConn;
    }

    
    //luca
    /**
     * Metodo che interroga il DB per ottenere informazioni riguardo 
     * ai giudizi emozionali relativi alla canzone il cui id è passato come argomento.
     * Ritorna un array contenente in ogni posizione un giudizio ricevuto da un utente.
     *      -Formato: "meraviglia_voto£SEP£solennita_voto£SEP£tenerezza_voto£SEP£nostalgia_voto£SEP£pacatezza_voto£SEP£potere_voto£SEP£gioia_voto£SEP£tensione_voto£SEP£tristezza_voto£SEP£commento"
     * @param idSong id della canzone il quale si vogliono ottenere i giudizi emozionali.
     * @return array contenente in ogni posizione un giudizio ricevuto da un utente, null se non ve ne sono disponibili.
     * @throws java.rmi.RemoteException
     */
    @Override
    public String[] requestDataJudgementsSong(String idSong)throws RemoteException{
        try {
            String query = "SELECT * FROM EMOZIONI WHERE CANZONE_ID = ?;";
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(query);
            statement.setString(1, idSong);
            ResultSet result = statement.executeQuery();
            String[] temp =  ServerUtils.convToArrayStr(result);    
            return temp;
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            return null;
        }
    }

    //Luca
    /**
     * Metodoche si occupa di aggiornare la tabella Emozioni con un nuovo giudizio emozionale.
     * Il metodo controlla da solo la lunghezza del commento ed il numero di voti.
     * @param idUser Id dell' utente che effettua il giudizio emozionale.
     * @param idSong Id della canzone giudicata dall' utente.
     * @param emotionalMarks array con i voti emozionali nel seguente ordine: [MERAVIGLIA,SOLENNITA,TENEREZZA,NOSTALGIA,PACATEZZA,POTERE,GIOIA,TENSIONE,TRISTEZZA].
     * @param comment commento opzionale.
     * @return 0 - operazione completata con successo.
     * 1 - errore db.
     * 2 - dati non validi.
     * @throws java.rmi.RemoteException
     */
    @Override
    public synchronized int InserisciEmozioniBrano(String idUser,String idSong,int[] emotionalMarks,String comment)throws RemoteException{
        //control marks array
        if(emotionalMarks.length!=9){
            System.out.println("Error MARKS data invalid");
            return 2;
        }
        //control comment length
        if (comment.length()>256) {
            System.out.println("Error: comment contain too characters, max: 256, actual: "+comment.length());
            return 2;
        }
        if(!ServerUtils.isFitToPostgresql(comment)){
            System.out.println("Error: comment contain not admitted characters, only ASCII permitted!");
            return 2;
        }
        
        //string with the needed query
        String queryEmotions = "INSERT INTO EMOZIONI(USER_PROP_ID,CANZONE_ID,COMMENTO,MERAVIGLIA,SOLENNITA,TENEREZZA,NOSTALGIA,PACATEZZA,POTERE,GIOIA,TENSIONE,TRISTEZZA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = CONNECTION_TO_DB.prepareStatement(queryEmotions);
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
            System.out.println(ex.getMessage());
            return 1;
        }
        return 0;
    }
    /*
    public static void main(String[] args) throws RemoteException {
        ProxyToDBEmozioni p = new ProxyToDBEmozioni(DBConnector.getDefaultConnection());
        String[] res =p.requestDataJudgementsSong("TRMYDFV128F42511FC");
        for(String str:res) System.out.println(str);
    }*/
}
