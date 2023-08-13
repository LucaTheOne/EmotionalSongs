/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package clientES;

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
    private ServicesBox servicesBox;
    
    public static ServicesProvider getInstance(){
        if(singleton == null){
            singleton = new ServicesProvider();
        }
        return singleton;
    }
    
    private ServicesProvider() {
        initialize();
    }
    
    public Remote getService(int serviceId){
        return servicesBox.getService(serviceId);
    }
    
    private void initialize(){
        new RequestServiceHostFrame(this);
    }
    
    protected void buildServicesBox(String servicesHost,int servicesPort){
        this.servicesBox = new ServicesBox(servicesHost, servicesPort);
    }
    /*    
    public static void main(String[] args) throws RemoteException {
        ServicesProvider sp = ServicesProvider.getInstance();
    }*/
}
