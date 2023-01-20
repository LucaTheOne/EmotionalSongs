//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.basic_structures;

import emotionalsongs.engines.*;

/**
 * 
 * Classe che rappresenta un insieme di canzoni (Un set di playlist).
 * Composta da un array di istanze di Playlist ed una Stringa contenente l' id Utente Univoco
 * del proprietario.
 */
public class PlaylistsSet {
   
    //campi
    private Playlist[] set;
    private String idOwner;
    //costructors
   
    /**
     * Costruttore che Prende una riga dal file che contiene le playlist di tutti gli utenti (Playlist.dati.txt)
     * e la adopera per costruirvi un istanza di PlaylistSet (Insieme di playlist appartenenti ad un utente)
     * @param stringFromFile Riga del file Playlist.dati.txt
     */
    public PlaylistsSet(String stringFromFile){
        String[] str = stringFromFile.split(";"); 
        idOwner = str[0];
        Playlist[] newOne = new Playlist[str.length-1];
        for(int i = 1;i<str.length;i++){
            newOne[i-1] = new Playlist(str[i]);
        }
        set = newOne;
    }
    /**
     * Costruttore che costruisce un istanza di PlaylistSet ricevendo come argomenti l' id di un utente ed un array di playlist.
     * @param idOwner id di un istanza di User (utente).
     * @param playlists array di istanze di Playlist.
     */
    public PlaylistsSet(String idOwner,Playlist[] playlists){
        this.idOwner = idOwner;
        set = playlists;
        sort();
    }
    
    /**
     * Costruttore per creare un playlistset per un utente che ancora non ne possiede.
     * @param idOwner id istanza di User (utente).
     * @param singlePlaylist Istanza di Playlist.
     */
    public PlaylistsSet(String idOwner, Playlist singlePlaylist){
        this.idOwner = idOwner;
        set = new Playlist[1];
        set[0] = singlePlaylist;
    }
    
    //getterMethod
    /**
     * Ritorna l' arrary di istanze di playlist che rappresenta il set stesso.
     * @return array di playlist contenute nel set.
     */
    public Playlist[] getArray(){
        return this.set;
    }
    
    /**
     * 
     * @return Un intero rappresentante il numero di playlist presenti nel set
     */
    public int getSize(){
        return set.length;
    }
    /**
     * 
     * @return Stringa contenente l' id univo del proprietario del set.
     */ 
    public String getOwnerId(){
        return idOwner;
    }
    
    //setter methods
    /**
     * Aggiorna il set aggiungendovi una playlist nuova, passata come argomento, successivamente riordina il set
     * sulla base dei nomi della playlist.
     * @param playlist Istanza di playlist da aggiungere al set che richiama il metodo.
     */    
    public void addPlaylist(Playlist playlist){
        Playlist[] newOne = new Playlist[set.length+1];
        for (int i = 0; i < set.length; i++) {
            newOne[i] = set[i];
        }
        newOne[newOne.length-1] = playlist;
        this.set=newOne;
        if(set.length >1){
            sort();
        }
    }
    
    //sorter method
    private void sort(){
        EngineSorter sorter = new EngineSorter();
        sorter.sortSetOfPlaylists(this);
    }
    
    //String methods
    /**
     * Metodo che costruisce la stringa formattata per rappresentare il set di playlist nel File Playlist.dati.txt.
     * il formato prevede che ogni riga sia un PlaylistsSet,ogni utente ha un solo PlaylistsSet, così composta:
     * |UserId|;|playlistName|:|songTag1|,|songTag2|,...,|songTagn|;|playlistName1|:|songTag11|,|songTag12|,...,|songTag1n|;...
     * @return Stringa formattata nel formato del file di appoggio.
     */
    public String componiStringa(){
        String stringa = idOwner+";";
        for (int i = 0; i < set.length; i++) {
            stringa += set[i].composeString();
        }
        return stringa+"\n";
    }
    
    /**
     *
     * @param index intero rappresentatnte una posizione nel playlistSet
     * @return Playlist in posizione index.
     */
    public Playlist getPlaylist(int index) {
        return set[index];
    }
    /**
     * Metodo per comparare lessicograficamente due playlistSet sulla base degli id dei loro proprietari.
     * @param playlistSet set con cui confrontare il set che chiama il metodo.
     * @return <ul>
     *          <li><b> Un intero negativo</b> se l' id dell' utente proprietario dell ' oggetto che chiama il metodo è <b>lessicograficamente precedente</b> a quello del' oggetto passato come argomento.</li>
     *          <li><b> Un intero positivo</b> se l' id dell' utente proprietario dell ' oggetto che chiama il metodo è <b>lessicograficamente seguente</b> a quello del' oggetto passato come argomento.</li>
     *          <li><b>Zero altrimenti</b></li>
     *         </ul>
     */         
    public int compareTo(PlaylistsSet playlistSet) {
        return this.idOwner.compareTo(playlistSet.getOwnerId());
    }
    /**
     * Ristruttura il set.
     * @param newSet array di playlist che rappresenterà il nuovo contenuto del set
     */
    public void updateSet(Playlist[] newSet) {
        this.set = newSet;
        
    }  
   
}

