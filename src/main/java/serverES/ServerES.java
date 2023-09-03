/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package serverES;

import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.sql.*;
import java.util.*;
import serverES.db_connector.*;
import serverES.server_services.canzoni.*;
import serverES.server_services.emozioni.*;
import serverES.server_services.playlist.*;
import serverES.server_services.utenti_registrati.*;
import serverES.server_services_common_interfaces.data_handler.*;
import serverES.server_services_common_interfaces.data_validator.*;



/**
 *Classe contenente il metodo main da cui avrà inizio la vita operativa del server.
 */
public class ServerES {
    
    private static final int PORT_TO_REMOTE_SERVICES = 5432;
    private static String SERVER_INET_ADDRESS_LOCAL = null;
    private static String SERVER_INET_ADDRESS_GLOBAL = null;
    private static Registry registroServizi = null;
    private Vector<String> servicesNamesVector = new Vector<>();
    private ServerControlGUI serverControlGUI;
    
    /**
     * Con la chiamata a tale costruttore si settano i dati necessari alla sua operatività,
     * nonchè si registrano in un registro tutti i servizi che offre.
     * @throws RemoteException 
     */
    public ServerES() throws RemoteException {
         
    }
    
    /**
     * Avvia il server avviando tutti i servizi necessari il suo funzionameto
     */
    public void startServer(){
        serverControlGUI = new ServerControlGUI(this);
        try { 
            SERVER_INET_ADDRESS_LOCAL = InetAddress.getLocalHost().getHostAddress();
            SERVER_INET_ADDRESS_GLOBAL = getMyGlobalAddress();
            serverControlGUI.setLocalAddress(SERVER_INET_ADDRESS_LOCAL, PORT_TO_REMOTE_SERVICES);
            serverControlGUI.setGlobalAddress(SERVER_INET_ADDRESS_GLOBAL);
            registroServizi = LocateRegistry.createRegistry(PORT_TO_REMOTE_SERVICES);
            serverControlGUI.addLineLog("Services' registry created!");
            Connection ConnToDB = DBConnector.getConnection();
            
            //adding all necessary service to the vector with addService
            addService(EmotionsDataHandler.SERVICE_NAME, new ProxyToDBEmozioni(ConnToDB));
            addService(EmotionsDataValidator.SERVICE_NAME, new EmozioniDataChecker(ConnToDB));
            serverControlGUI.addLineLog("Emotion services added!");
            
            addService(PlaylistsDataHandler.SERVICE_NAME, new ProxyToDBPlaylists(ConnToDB));
            addService(PlaylistsDataValidator.SERVICE_NAME, new PlaylistsDataChecker(ConnToDB));
            serverControlGUI.addLineLog("Playlists services added!");
            
            addService(UsersDataHandler.SERVICE_NAME, new ProxyToDBUtenti_Registrati(ConnToDB));
            addService(UsersDataValidator.SERVICE_NAME, new UtentiDataChecker(ConnToDB));
            serverControlGUI.addLineLog("Users services added!");
            
            addService(SongsDataHandler.SERVICE_NAME, new ProxyToDBCanzoni(ConnToDB));
            serverControlGUI.addLineLog("Songs services added!");
            
        } catch (java.net.UnknownHostException ex) {
            System.out.println("Impossibile avviare il server!");
            System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println("Impossibile avviare il server!");
            System.out.println(ex.getMessage());
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
        serverControlGUI.addLineLog("All services shutted down!");
    }
    
    private String getMyGlobalAddress(){
        try {
            URL myIpFinder = new URL("http://checkip.amazonaws.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(myIpFinder.openStream()));
            return reader.readLine();    
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * Metodo main, all'avvio questo è il primo metodo eseguito
     * @param args
     * @throws RemoteException 
     */
    public static void main(String[] args) throws RemoteException{
        ServerES server = new ServerES();
        new ServerInitializer(server);
    }
}
