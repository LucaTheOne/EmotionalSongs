package emotionalsongs;

import java.io.*;
import java.util.*;

public class Playlist{

  //campi
  String nomePlaylist;
  List<Brano> listaCanzoniPlaylist = new ArrayList<Brano>();
  //costruttore
  Playlist(String nomePlaylist, List<Brano> listaCanzoniPlaylist){
    this.nomePlaylist = nomePlaylist;
    //this.listaCanzoniPlaylist = listaCanzoniPlaylist;
  }

  //metodi
  public void RegistraPlaylist() throws FileNotFoundException{
    setNomePlaylist();
    boolean another = false;
    boolean valid = false;
    Scanner inputStream = new Scanner(System.in);
    do {
      addSongToPlaylist();
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
  }

  public String getNomePlaylist(){
    return this.nomePlaylist;
  }

  public void setNomePlaylist(){
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
    this.nomePlaylist = nome;
  }

  public void addSongToPlaylist() throws FileNotFoundException{
    Brano brano = SearchSongBrain.cercaBranoMusicale();
    if (brano != null) {
      this.listaCanzoniPlaylist.add(brano);
    }
  }

  public String componiStringaPlaylist(){
    String stringa = "";
    stringa = " Playlist: " + getNomePlaylist()+"\n";
    for (int i=0;i<listaCanzoniPlaylist.size();i++ ) {
      stringa =stringa + "  "+i+". "+ listaCanzoniPlaylist.get(i).toString() + "\n";
    }
    stringa += " ----------------------------\n";
    return stringa;
  }

  //da implementare il metodo per salvare la playlist su file

/**
  String[] votesArray = new String[9];
  String[] commentsArray = new String[9];

  public voteASong(){
    System.out.println(
      "Per ogni emozione, ne legga la breve descrizione;\n"+
      "dia un voto da 1 a 5 sulla base di quanto ha percepito tale emozione\n"+
      "durante l' ascolto del brano, considerando 1: per niente, 5: molto." );
    votesArray[0] = voteAnEmotion(AMAZEMENT);
    commentsArray[0] = commentAnEmotion(AMAZEMENT);
    votesArray[1] = voteAnEmotion(SOLEMNITY);
    commentsArray[1] = commentAnEmotion(SOLEMNITY);
    votesArray[2] = voteAnEmotion(TENDERNESS);
    commentsArray[2] = commentAnEmotion(TENDERNESS);
    votesArray[3] = voteAnEmotion(NOSTALGIA);
    commentsArray[3] = commentAnEmotion(NOSTALGIA);
    votesArray[4] = voteAnEmotion(CALMNESS);
    commentsArray[4] = commentAnEmotion(CALMNESS);
    votesArray[5] = voteAnEmotion(POWER);
    commentsArray[5] = commentAnEmotion(POWER);
    votesArray[6] = voteAnEmotion(JOY);
    commentsArray[6] = commentAnEmotion(JOY);
    votesArray[7] = voteAnEmotion(TENSION);
    commentsArray[7] = commentAnEmotion(TENSION);
    votesArray[8] = voteAnEmotion(SADNESS);
    commentsArray[8] = commentAnEmotion(SADNESS);
  }

  private String voteAnEmotion(Emotions e){
    String vote;
    System.out.println(e.getName() +":\n"+e.getExplanation()+"\n"+"Quanto ha percepito tale emozione?");
    do {
        boolean validated = false;
      do {
        vote = Scanner(System.in).nextLine();
        if (vote != "1"&&vote != "2"&&vote != "3"&&vote != "4"&&vote != 5) {
          System.out.println("Voto non valido! inserisca un numero da 1 a 5: ");
        }
      } while (!vote.equals("1")&&!vote.equals("2")&&!vote.equals("3")&&!vote.equals("4")&&!vote.equals("5"));

      System.out.println("Conferma? s/n");
      boolean correct = false;
      String sn = new Scanner(System.in).nextLine();
      do {
        if (sn.equalsIgnoreCase("n")) {
          validated = false;
        } else if (sn.equalsIgnoreCase("s")) {
          validated = true;
        } else{
          System.out.println("Scelta non valida!\n"+"Digiti s per confermare altrimenti n per cambiare voto");
          correct = false;
        }
      } while (!correct);

    } while (!validated);
    return vote;
  }

  private String commentAnEmotion(Emotions e){
    String comment;
    boolean validated= false;
    do {
      System.out.println("Vuole Commentare quanto lei ha percepito\n"+ "riguardo questa emozione?\n"+"Digiti s per confermare, n per non commentare:");
      String sn = new Scanner(System.in).nextLine();
      if(sn.equalsIgnoreCase("s")){
        System.out.println("Inserisca il suo commento, massimo 256 caratteri:");
        comment = new Scanner(System.in).nextLine();
        validated = true;
      } else if (sn.equalsIgnoreCase("n")) {
        comment = "";
        validated = true;
      } else {
        System.out.println("Scelta non valida!"+"Digiti s per commentare, n per non commentare:");

      }
    } while (!validated);
    return comment;
  }**/

}
