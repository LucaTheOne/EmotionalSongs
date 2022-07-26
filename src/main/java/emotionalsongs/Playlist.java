package emotionalsongs;

import java.io.*;
import java.util.*;

/**
 *  La classe Playlist 
 * @author Luca
 * @version 1.4
 *
 */
public class Playlist extends EMOTIONALSONGS{

    //campi
    String nomePlaylist;
    String proprietario = super.loggedUser.getUserId();

    List<Brano> listaCanzoniPlaylist = new ArrayList<Brano>();

    //costruttore
    /**
     * 
     * @throws IOException 
     */
    public Playlist() throws IOException{
        setNomePlaylist();
        System.out.println("Vuole aggiungere subito canzoni alla sua playlist "+ nomePlaylist +"? ");
        if(Utilities.readYesOrNot()){
            registraPlaylist();
        }
        aggiungiPlaylistASetPlaylistsUtente();
    }
    
    /**
     * 
     * @param proprietario
     * @param nomePlaylist
     * @param listaCanzoniPlaylist 
     */
    Playlist(String proprietario, String nomePlaylist, ArrayList<Brano> listaCanzoniPlaylist) {
        setNomePlaylist();
        //this.listaCanzoniPlaylist = listaCanzoniPlaylist;
    }

    //metodi
    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void registraPlaylist() throws FileNotFoundException, IOException{
        addSongToPlaylist();
        boolean another = false;
        boolean valid = false;
        Scanner inputStream = new Scanner(System.in);
        do {
           
            System.out.println("Vuole aggiungere un altro brano alla playlist?");
            if (Utilities.readYesOrNot()) {
                addSongToPlaylist();
                another = true;
            } else {
                another = false;
            }
        } while (another);
        inputStream.close();
    }
    
    /**
     * 
     * 
     */
    private void aggiungiPlaylistASetPlaylistsUtente(){
        super.loggedUser.addToPlaylistSet(this);
    }
    
    /**
     * Il metodo restituisce una String con il nome della playlist
     * @return il campo nomePlayList.
     */
    public String getNomePlaylist(){
        return this.nomePlaylist;
    }
    
    /**
     * Il metodo restituisce una String con il nome della playlist scelto dall'utente.
     * @return nome della Playlist
     */
    public static String setNomePlaylist(){
        String nome;
        Scanner inputStream = new Scanner(System.in);
        do {
            System.out.println("Scelga un nome per la sua playlist:");
            nome = inputStream.nextLine();
            if (nome.equals(null)) {
            System.out.println("Deve dare un nome alla sua playlist!");
            }
        } while (nome.equals(null));
        inputStream.close();
        return nome;
    }

    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void addSongToPlaylist() throws FileNotFoundException, IOException{
        SearchEngine search = new SearchEngine();
        ArrayList<Brano> listaScelte= search.cercaBranoMusicale();
        if(listaScelte.size()==1){
            System.out.println("Vuole aggiungere il brano: \n"+
                    listaScelte.get(0).toStringOrdinato()+"alla sua playlist "+ 
                    getNomePlaylist()+"?");
                    
            if(Utilities.readYesOrNot()){
                listaCanzoniPlaylist.add(listaScelte.get(0));
            }
        }
        System.out.println("Brani trovati: ");
        System.out.println(search.stampaRisultati());
        System.out.println("Digiti gli indici delle canzoni, separati da uno spazio che vuole aggiungere alla sua playlist "+getNomePlaylist()+":");
        String[] scelte = new Scanner(System.in).nextLine().split(" ");
        int[] scelteint = new int[scelte.length];
        for(int i = 0; i<scelte.length;i++){
            scelteint[i] = Integer.parseInt(scelte[i])-1;
        }
        for(int i = 0; i<scelte.length;i++){
            listaCanzoniPlaylist.add(listaScelte.get(scelteint[i]));
        }
        
        riordinaPlaylist();
    }

    //implementare metodo per riordinare la Playlist
    private void riordinaPlaylist(){
        
    }
    
    //implementare metodo di ricerca interno alla playlist
    public void cercaNellaPlaylist(){
        
    }
    
    /**
     * 
     * @return 
     */
    public String componiStringaPlaylist(){
        String stringa = "";
        stringa = "Proprietario : " + proprietario + "\n";
        stringa = stringa + "  Playlist : " + nomePlaylist + "\n" + "    <";
    
        for (int i=0;i<listaCanzoniPlaylist.size();i++ ) {
            stringa =stringa + "    "+i+". "+ listaCanzoniPlaylist.get(i).toString() + "\n";
        }
        stringa += "    > " + " \n";
        return stringa;
     } 
}
 