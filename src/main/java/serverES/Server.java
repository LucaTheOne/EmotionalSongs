package serverES;


import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.util.logging.*;



/**
 *
 * @author big
 */
public class Server {
    private static final int PORT_TO_DB = 9876;
    private static final int PORT_TO_REMOTE_SERVICES = 5432;
    private static InetAddress SERVER_INET_ADDRESS = null;
    private static Registry registroServizi = null;
    private Vector<String> servicesNamesVector;

    public Server() throws RemoteException {
        try {
            SERVER_INET_ADDRESS = InetAddress.getLocalHost();
            registroServizi =LocateRegistry.createRegistry(PORT_TO_REMOTE_SERVICES);
            servicesNamesVector = new Vector<>();
            //adding all necessary service to the vector with addService
        } catch (java.net.UnknownHostException ex) {
            System.err.println("Impossibile avviare il server!");
            System.err.println(ex.getMessage());
        }  
    }
    
    private void addService(String serviceName,Remote servizio){
        try {
            registroServizi.rebind(serviceName, servizio);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void terminateServices(){
        if(!servicesNamesVector.isEmpty()){
            for(String serv: servicesNamesVector){
                try {
                    registroServizi.unbind(serv);  
                } catch (RemoteException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
    }
    
    
    public static void main(String[] args) throws RemoteException {
        Server server = new Server();
        ServerControlGUI terminal = new ServerControlGUI(SERVER_INET_ADDRESS.getHostAddress(), PORT_TO_REMOTE_SERVICES, server);
    }
}
