/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package clientES;

import emotionalsongs.*;
import java.rmi.*;

/**
 *
 * @author big
 */
public class ServicesProvider {
    
    public static final int EMOTIONS_DATA_HANDLER = 0;
    public static final int USERS_DATA_HANDLER = 1;
    public static final int SONGS_DATA_HANDLER = 2;
    public static final int PLAYLISTS_DATA_HANDLER = 3;
    
    public static final int EMOTIONS_DATA_VALIDATOR = 4;
    public static final int USERS_DATA_VALIDATOR = 5;
    public static final int PLAYLISTS_DATA_VALIDATOR = 6;
    
    private static ServicesProvider singleton = null;
    private final ServicesBox servicesBox;
    private int servicesPort = 0;
    private String servicesHost = "";
    
    public static ServicesProvider getInstance(){
        if(singleton == null){
            singleton = new ServicesProvider();
        }
        return singleton;
    }
    
    private ServicesProvider() {
        initialize();
        while(servicesPort == 0 || servicesHost.isBlank()){
            try {
                Thread.sleep(100);
                System.out.println("waiting data...");
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            } 
        }
        servicesBox = new ServicesBox(servicesHost, servicesPort);
    }
    
    public Remote getService(int serviceId){
        return servicesBox.getService(serviceId);
    }
    
    private void initialize(){
        new InitOperator(servicesHost, servicesPort).run();
    }
    
    private class InitOperator extends Thread{
        private String serHost;
        private int serPort;
        public InitOperator(String serHost,int serPort) {
            this.serHost = serHost;
            this.serPort = serPort;
        }
        @Override
        public void run(){
            new ClientInitializer(serHost, serPort);
        }
    }
    
    public static void main(String[] args) throws RemoteException {
        /*ServicesProvider sp = ServicesProvider.getInstance();
        UsersDataHandler dh = (UsersDataHandler) sp.getService(USERS_DATA_HANDLER);
        boolean result = dh.userCanVoteSong("theOne", "TRPDMSM128F42B7CE0");
        System.out.println(result);*/
        System.out.println(EmotionalSongs.dialoghi.name());
    }
    
}
