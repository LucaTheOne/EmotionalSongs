package emotionalsongs;

import java.io.*;

public class Brano {

//campi
  private String title,author,year,tag;
  /**
  private Emozioni Amazement = Emozioni.AMAZEMENT;
  private Emozioni Solemnity = Emozioni.SOLEMNITY;
  private Emozioni Tenderness = Emozioni.TENDERNESS;
  private Emozioni Nostalgia = Emozioni.NOSTALGIA;
  private Emozioni Calmness = Emozioni.CALMNESS;
  private Emozioni Power = Emozioni.POWER;
  private Emozioni Joy = Emozioni.JOY;
  private Emozioni Tension = Emozioni.TENSION;
  private Emozioni Sadness = Emozioni.SADNESS;
  
  private int numberOfVoteForAmazement;
  private int numberOfVoteForSolemnity;
  private int numberOfVoteForTenderness;
  private int numberOfVoteForNostalgia;
  private int numberOfVoteForCalmness;
  private int numberOfVoteForPower;
  private int numberOfVoteForJoy;
  private int numberOfVoteForTension;
  private int numberOfVoteForSadness;
  **/
  
//costruttore
  Brano(String title, String author,String year,String tag) throws IOException{
    this.title = title;
    this.author = author;
    this.year = year;
    this.tag = tag;
    //importazioneVotiBrano();
    
    
  }

//metodi
  public String getTitle(){
    return this.title;
  }

  public String getAuthor(){
    return this.author;
  }

  public String getYear(){
    return this.year;
  }

  public String getTag(){
    return this.tag;
  }


  public boolean equalsTo(Brano brano) {

    return this.title == brano.title&&this.author == brano.author&&this.year == brano.year;
  }
  /**
  public void voteBranoEmotions(){
      Amazement.voteAnEmotion();
      numberOfVoteForAmazement++;
      
      Solemnity.voteAnEmotion();
      numberOfVoteForSolemnity++;
      
      Tenderness.voteAnEmotion();
      numberOfVoteForTenderness++;
      
      Nostalgia.voteAnEmotion();
      numberOfVoteForNostalgia++;
      
      Calmness.voteAnEmotion();
      numberOfVoteForCalmness++;
      
      Power.voteAnEmotion();
      numberOfVoteForPower++;
      
      Joy.voteAnEmotion();
      numberOfVoteForJoy++;
      
      Tension.voteAnEmotion();
      numberOfVoteForTension++;
              
      Sadness.voteAnEmotion();
      numberOfVoteForSadness++;
      
  }
  * **/
  
  public String toStringOrdinato(){
    String stringa ="Titolo: " +  this.getTitle() +"Autore: " + this.getAuthor() + "Anno di pubblicazione: " +this.year + "\n";
    return stringa;
  }
  /**
  private void importazioneVotiBrano() throws FileNotFoundException, IOException{
    BufferedReader buffer = new BufferedReader(new FileReader(new File(Utilities.pathToEmozioniDati)));  
    String currentLine = "";
    while(!currentLine.equals(getTag())){
        currentLine = buffer.readLine();
    }
    while(!currentLine.equals(Utilities.divisioreFinale)){
        currentLine = buffer.readLine();
        String[] currentSplitted = currentLine.split(";");
        numberOfVoteForAmazement = Integer.parseInt(currentSplitted[1]);
        String[] serieVoti = currentSplitted[2].split(" ");
        Amazement.votes = new int[numberOfVoteForAmazement];
        for(int i = 0;i<serieVoti.length;i++){
            Amazement.votes[i] = Integer.parseInt(serieVoti[i]);
        }
        Amazement.notes = currentSplitted[3].split("<>");
    }
  }
  **/
}
