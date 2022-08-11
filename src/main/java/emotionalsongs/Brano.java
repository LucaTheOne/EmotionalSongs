package emotionalsongs;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Brano {

//campi
  private String title,author,tag,year;
  public JButton button = new JButton();
  public DatiEmozioniBrano datiEmozioniBrano;
  
  
//costruttore
  Brano(String title, String author,String year,String tag) throws IOException{
    this.title = title;
    this.author = author;
    this.year = year;
    this.tag = tag;
    button.setText(toStringOrdinato());
    button.setPreferredSize(new Dimension(600, 30));
    button.setFont(new Font("Helvetica Neue", 0, 18));
    button.setMargin(new Insets(4, 2, 2, 4));
    button.setVisible(true);
    //datiEmozioniBrano=importaVotiBrano(tag); da implementare
    
    
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
  
  public JButton getButton(){
      return this.button;
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
    String stringa = this.getTitle() +" ~ " + this.getAuthor() + " ~ " +this.year;
    return stringa;
  }
}
