package emotionalsongs;

import java.io.*;

public class Brano {

//campi
  private String title,author,year,tag;
  public DatiEmozioniBrano datiEmozioniBrano = new DatiEmozioniBrano(this);
  
  
//costruttore
  Brano(String title, String author,String year,String tag) throws IOException{
    this.title = title;
    this.author = author;
    this.year = year;
    this.tag = tag;
    //importazioneVotiBrano();
    
    
  }

//metodi getter
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

//metodi di confronto
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

//metodi di esposizione  
  public String toStringOrdinato(){
    String stringa ="Titolo: " +  this.getTitle() +", Autore: " + this.getAuthor() + ", Anno di pubblicazione: " +this.year + ".\r";
    return stringa;
  }
}
