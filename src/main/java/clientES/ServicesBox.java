/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package clientES;

import serverES.server_services_common_interfaces.data_validator.UsersDataValidator;
import serverES.server_services_common_interfaces.data_validator.PlaylistsDataValidator;
import serverES.server_services_common_interfaces.data_validator.EmotionsDataValidator;
import serverES.server_services_common_interfaces.data_handler.PlaylistsDataHandler;
import serverES.server_services_common_interfaces.data_handler.SongsDataHandler;
import serverES.server_services_common_interfaces.data_handler.EmotionsDataHandler;
import serverES.server_services_common_interfaces.data_handler.UsersDataHandler;
import java.rmi.*;
import java.rmi.registry.*;

/**
 *
 * @author big
 */
class ServicesBox {
    
    private int servicesPort = 5432; // default port
    private String servicesHost = "127.0.0.1";//default host
    
    //services ids
    private final int EMOTIONS_DATA_HANDLER = 0;
    private final int USERS_DATA_HANDLER = 1;
    private final int SONGS_DATA_HANDLER = 2;
    private final int PLAYLISTS_DATA_HANDLER = 3;
    
    private final int EMOTIONS_DATA_VALIDATOR = 4;
    private final int USERS_DATA_VALIDATOR = 5;
    private final int PLAYLISTS_DATA_VALIDATOR = 6;
    
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
            this.servicesHost = servicesHost;
            this.servicesPort = servicesPort;
            
            Registry registryServices = LocateRegistry.getRegistry(this.servicesHost, this.servicesPort);
            
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
    
    /*
    public static void main(String[] args) throws InterruptedException, RemoteException {
        new RequestServiceHostFrame();
        while (services == null) {            
           Thread.sleep(300); 
        }
        SongsDataHandler sdh = (SongsDataHandler)services.getService(2);
        //System.out.println(sdh.getRepoSize());
        String[] arr = sdh.requestRepositorysSongByIndex(0, 100);
        for(String str: arr) System.out.println(str);
    }*/
}
