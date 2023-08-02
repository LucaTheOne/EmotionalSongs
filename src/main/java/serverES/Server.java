/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES;

import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.sql.*;
import java.util.*;
import serverES.db_communication.*;
import serverES.db_communication.canzoni.*;
import serverES.db_communication.emozioni.*;
import serverES.db_communication.playlist.*;
import serverES.db_communication.utenti_registrati_table.*;
import serverES.services_common_interfaces.data_handler.*;
import serverES.services_common_interfaces.data_validator.*;



/**
 *Classe contenente il metodo main da cui avrà inizio la vita operativa del server.
 */
public class Server {
    
    private static final int PORT_TO_REMOTE_SERVICES = 5432;
    private static InetAddress SERVER_INET_ADDRESS = null;
    private static Registry registroServizi = null;
    private Vector<String> servicesNamesVector = new Vector<>();
    
    /**
     * Con la chiamata a tale costruttore si settano i dati necessari alla sua operatività,
     * nonchè si registrano in un registro tutti i servizi che offre.
     * @throws RemoteException 
     */
    public Server() throws RemoteException {
        try {
            SERVER_INET_ADDRESS = InetAddress.getLocalHost();
            registroServizi = LocateRegistry.createRegistry(PORT_TO_REMOTE_SERVICES);
            Connection ConnToDB = DBConnector.getDefaultConnection();
            //adding all necessary service to the vector with addService
            addService(EmotionsDataHandler.SERVICE_NAME, new ProxyToDBEmozioni(ConnToDB));
            addService(EmotionsDataValidator.SERVICE_NAME, new EmozioniDataChecker(ConnToDB));
            System.out.println("Emotion services added!");
            addService(PlaylistsDataHandler.SERVICE_NAME, new ProxyToDBPlaylists(ConnToDB));
            addService(PlaylistsDataValidator.SERVICE_NAME, new PlaylistsDataChecker(ConnToDB));
            System.out.println("Playlists services added!");
            addService(UsersDataHandler.SERVICE_NAME, new ProxyToDBUtenti_Registrati(ConnToDB));
            addService(UsersDataValidator.SERVICE_NAME, new UtentiDataChecker(ConnToDB));
            System.out.println("Users services added!");
            addService(SongsDataHandler.SERVICE_NAME, new ProxyToDBCanzoni(ConnToDB));
            System.out.println("Songs services added!");
        } catch (java.net.UnknownHostException ex) {
            System.err.println("Impossibile avviare il server!");
            System.err.println(ex.getMessage());
        }  
    }
    
    /**
     * Metodo che permette di aggiungere un servizio remoto al registry, passandogli il nome con il quale ci si riferirà 
     * a tale servizio e l' oggetto remoto il quale vi rappresenta.
     * @param serviceName Stringa con il nome da assegnare al servizio.
     * @param servizio Oggetto remoto da aggiungere come servizio.
     */
    private void addService(String serviceName,Remote servizio){
        try {
            registroServizi.rebind(serviceName, servizio);
            servicesNamesVector.add(serviceName);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Metodo tramite il quale tutti i servizi del server vengono resi non più disponibili.
     */
    protected void terminateServices(){
        if(!servicesNamesVector.isEmpty()){
            for(String serv: servicesNamesVector){
                try {
                    registroServizi.unbind(serv);  
                } catch (RemoteException ex) {
                    System.out.println(ex.getMessage());
                } catch (NotBoundException ex) {
                    System.out.println(ex.getMessage());
                }
            } 
        }
    }
    
    
    public static void main(String[] args) throws RemoteException {
        Server server = new Server();
        ServerControlGUI terminal = ServerControlGUI.obtainControlGuiReference(SERVER_INET_ADDRESS.getHostAddress(), PORT_TO_REMOTE_SERVICES, server);
        
    }
}
