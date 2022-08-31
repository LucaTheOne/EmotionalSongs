package emotionalsongs;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
*La classe Brano si occupa di creare oggetti di tipo Brano.
*@authore Bolelli Luca
*@version 1.3
*/
public class Brano {

//campi
  private String title,author,tag,year;
  /**
   * @hidden
   */
  public JButton button = new JButton();
  /**
   * @hidden
   */
  public RecordEmozioniBrano datiEmozioniBrano;
  
  
//costruttore
  
  /**
   * Costruisce l'oggetto Brano.
   * @param title - Titolo del brano.
   * @param author - Autore del brano.
   * @param year - Anno del brano.
   * @param tag - Tag del brano.
   * @throws IOException 
   */
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
  /**
   * Il metodo restiuisce una stringa con il titolo del brano.
   * @return titolo del brano. 
   */
  public String getTitle(){
    return this.title;
  }

  /**
   * Il metodo restiuisce una stringa con l'autore del brano.
   * @return autore del brano.
   */
  public String getAuthor(){
    return this.author;
  }

  /**
   * Il metodo restiuisce una stringa con l'anno del brano.
   * @return anno del brano.
   */  
  public String getYear(){
    return this.year;
  }

  /**
   * Il metodo restiuisce il tag del brano.
   * @return tag del brano.
   */  
  public String getTag(){
    return this.tag;
  }
  
  /**
   * 
   * @hidden 
   */
  public JButton getButton(){
      return this.button;
  }

//metodi di confronto
  /**
   * Il metodo restituisce true se il Brano rappresentato dall'oggetto che esegue il metodo
   * e uguale a quello specificato tramite l'agomento, altrimenti false.
   * @param brano - argomento Brano.
   * @return true - se i brani sono uguali, altrimenti false.
   */
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
/**
   * Il metodo si occupa di restituire una stringa con :
   * <p> Titolo: ~ Autore: ~ Anno di pubblicazione: . 
   * @return una stringa ordinata con i dati del brano.
   */
  public String toStringOrdinato(){
    String stringa = this.getTitle() +" ~ " + this.getAuthor() + " ~ " +this.year;
    return stringa;
  }
}
