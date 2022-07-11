package emotionalsongs;

public class Brano {

//campi
  private String title,author,year,tag;

//costruttore
  Brano(String title, String author,String year,String tag){
    this.title = title;
    this.author = author;
    this.year = year;
    this.tag = tag;
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

  public String toStringOrdinato(){
    String stringa ="Titolo: " +  this.getTitle() + "\n " +"   Autore: " + this.getAuthor() + "\n " + "   Anno di pubblicazione: " +this.year + "\n";
    return stringa;
  }
}
