/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package clientES;

import clientES.services_common_interfaces.data_handler.*;
import clientES.services_common_interfaces.data_validator.*;
import java.rmi.*;
import java.rmi.registry.*;

/**
 *
 * @author big
 */
public class ServicesBox {
    
    private static ServicesBox services = null;
    private static int servicesPort;
    private static String servicesHost;
    protected static boolean readyToBeInitialized = false;
    
    //services ids
    public final int EMOTIONS_DATA_HANDLER = 0;
    public final int USERS_DATA_HANDLER = 1;
    public final int SONGS_DATA_HANDLER = 2;
    public final int PLAYLISTS_DATA_HANDLER = 3;
    
    public final int EMOTIONS_DATA_VALIDATOR = 4;
    public final int USERS_DATA_VALIDATOR = 5;
    public final int PLAYLISTS_DATA_VALIDATOR = 6;
    
    //Getting and updating data services
    private EmotionsDataHandler emotionsDataHandler;
    private PlaylistsDataHandler playlistsDataHandler;
    private SongsDataHandler songsDataHandler;
    private UsersDataHandler usersDataHandler;
    
    //checker services
    private EmotionsDataValidator emotionsDataValidator;
    private PlaylistsDataValidator playlistsDataValidator;
    private UsersDataValidator usersDataValidator;
    
    private ServicesBox(String servicesHost,int servicesPort){
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
        if(!(services == null)) return services;
        return initializeSevicesBox();
    }
    
    private static ServicesBox initializeSevicesBox(){
        new RequestServiceHostFrame();
        while(!readyToBeInitialized){
            if(servicesPort != 0 && servicesHost != null) readyToBeInitialized = true;
        }
        return new ServicesBox(servicesHost, servicesPort);
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
    
    public static void main(String[] args) {
        ServicesBox sb = ServicesBox.getInstance();
        SongsDataHandler dh = (SongsDataHandler)sb.getService(sb.SONGS_DATA_HANDLER);
        try {
            System.out.println("DB size: " + dh.getRepoSize());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
