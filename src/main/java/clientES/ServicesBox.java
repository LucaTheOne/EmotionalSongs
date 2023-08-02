/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package clientES;

import java.rmi.*;
import java.rmi.registry.*;
import serverES.services_common_interfaces.data_handler.*;
import serverES.services_common_interfaces.data_validator.*;

/**
 *
 * @author big
 */
public class ServicesBox extends Thread{
    
    private static ServicesBox services = null;
    private static int servicesPort = 5432; // default port
    private static String servicesHost = "127.0.1.1";
    protected static boolean readyToBeInitialized = false;
    
    //services ids
    public final static int EMOTIONS_DATA_HANDLER = 0;
    public final static int USERS_DATA_HANDLER = 1;
    public final static int SONGS_DATA_HANDLER = 2;
    public final static int PLAYLISTS_DATA_HANDLER = 3;
    
    public final static int EMOTIONS_DATA_VALIDATOR = 4;
    public final static int USERS_DATA_VALIDATOR = 5;
    public final static int PLAYLISTS_DATA_VALIDATOR = 6;
    
    //Getting and updating data services
    private EmotionsDataHandler emotionsDataHandler;
    private PlaylistsDataHandler playlistsDataHandler;
    private SongsDataHandler songsDataHandler;
    private UsersDataHandler usersDataHandler;
    
    //checker services
    private EmotionsDataValidator emotionsDataValidator;
    private PlaylistsDataValidator playlistsDataValidator;
    private UsersDataValidator usersDataValidator;
    
    protected ServicesBox(String servicesHost,int servicesPort){
        try {
            Registry registryServices = LocateRegistry.getRegistry(servicesHost, servicesPort);
            
            //Getting and updating data services
            emotionsDataHandler = (EmotionsDataHandler)registryServices.lookup(EmotionsDataHandler.SERVICE_NAME);
            playlistsDataHandler = (PlaylistsDataHandler) registryServices.lookup(PlaylistsDataHandler.SERVICE_NAME);
            songsDataHandler = (SongsDataHandler) registryServices.lookup(SongsDataHandler.SERVICE_NAME);
            usersDataHandler = (UsersDataHandler) registryServices.lookup(UsersDataHandler.SERVICE_NAME);
            
            //checker services
            emotionsDataValidator = (EmotionsDataValidator)registryServices.lookup(EmotionsDataValidator.SERVICE_NAME);
            playlistsDataValidator = (PlaylistsDataValidator)registryServices.lookup(PlaylistsDataValidator.SERVICE_NAME);
            usersDataValidator = (UsersDataValidator)registryServices.lookup(UsersDataValidator.SERVICE_NAME);
            
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());   
        }
    }
    
    public static ServicesBox getInstance(){
        if(services == null) services = new ServicesBox(servicesHost, servicesPort);
        return services;
    }
    
    public Remote getService(int serviceId){
        switch (serviceId) {
            case EMOTIONS_DATA_HANDLER: return emotionsDataHandler;
            case USERS_DATA_HANDLER: return usersDataHandler;
            case PLAYLISTS_DATA_HANDLER: return playlistsDataHandler;
            case SONGS_DATA_HANDLER: return songsDataHandler;
            
            case EMOTIONS_DATA_VALIDATOR: return emotionsDataValidator;
            case USERS_DATA_VALIDATOR: return usersDataValidator;
            case PLAYLISTS_DATA_VALIDATOR: return playlistsDataValidator;
            
            default: throw new AssertionError();
        }
    }
    
    protected static void setPort(int port){
        servicesPort=port;
    }
    
    protected static void setHost(String host){
        servicesHost = host;
    }
    /*
    public static void main(String[] args) throws InterruptedException, RemoteException {
        new RequestServiceHostFrame();
        while (services == null) {            
           Thread.sleep(300); 
        }
        SongsDataHandler sdh = (SongsDataHandler)services.getService(2);
        System.out.println(sdh.getRepoSize());
        
    }*/
}
