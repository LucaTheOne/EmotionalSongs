package emotionalsongs;

import java.io.*;
import java.util.*;

public class Playlist{

  //campi
  String nomePlaylist;
  String proprietario;

  List<Brano> listaCanzoniPlaylist = new ArrayList<Brano>();

  //costruttore
  Playlist(String proprietario, String nomePlaylist, ArrayList<Brano> listaCanzoniPlaylist){
    setNomePlaylist();
    //this.listaCanzoniPlaylist = listaCanzoniPlaylist;
  }

  //metodi
  public static Playlist RegistraPlaylist(Utente proprietario) throws FileNotFoundException, IOException{
    ArrayList<Brano> playlist = new ArrayList<Brano>();  
    String nomePlayList = setNomePlaylist();
    boolean another = false;
    boolean valid = false;
    Scanner inputStream = new Scanner(System.in);
    do {
      addSongToPlaylist(playlist);
      do {
        System.out.println("Vuole aggiungere un altro brano alla playlist?\n"+"Digiti s se si, digiti n se no: ");
        String choosed = inputStream.nextLine();
        if (choosed.equalsIgnoreCase("s")) {
          another = true;
        } else if (choosed.equalsIgnoreCase("n")) {
          another = false;
        }else{
          System.out.println("Scelta non valida!\n"+"Vuole aggiungere un altro brano alla playlist?\n"+"Digiti s se si, digiti n se no: ");
          valid = false;
        }
      } while (!valid);
    } while (another);
    inputStream.close();
    return new Playlist(proprietario.getUserId(),nomePlayList, playlist);
  }
  
  public static void aggiungiPlaylistaSet(Utente proprietario, Playlist playlist){
      proprietario.addtoPlaylistSet(playlist);
      
  }

  public String getNomePlaylist(){
    return this.nomePlaylist;
  }

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

   static public void addSongToPlaylist(List<Brano> l) throws FileNotFoundException, IOException{
    Brano brano = SearchSongBrain.cercaBranoMusicale();
    if (brano != null) {
      l.add(brano);
    }
  }

  //implementare metodo per riordinare la Playlist

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
 