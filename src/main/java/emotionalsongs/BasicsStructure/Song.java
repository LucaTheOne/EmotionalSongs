package emotionalsongs.BasicsStructure;

import emotionalsongs.*;
import emotionalsongs.GUI.PlayLists.*;
import emotionalsongs.GUI.Repository.*;
import java.io.*;

/**
*La classe Song si occupa di creare oggetti di tipo Song.
*@authore Bolelli Luca
*@version 1.3
*/
public class Song {

//campi
  private String title,author,tag;
  private int year;
  /**
   * @hidden
   */
  public Record datiEmozioniBrano;
  
  
    //costruttore
    /**
    * Costruisce l'oggetto Brano.
    * @param title - Titolo del brano.
    * @param author - Autore del brano.
    * @param year - Anno del brano.
    * @param tag - Tag del brano.
    * @throws IOException 
    */
    public Song(String title, String author,String year,String tag) throws IOException{
        this.title = title;
        this.author = author;
        this.year = Integer.parseInt(year);
        this.tag = tag;
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
    public int getYear(){
        return this.year;
    }

    /**
    * Il metodo restiuisce il tag del brano.
    * @return tag del brano.
    */  
    public String getTag(){
        return this.tag;
    }

    //metodi di confronto
    /**
    * Il metodo restituisce true se il Song rappresentato dall'oggetto che esegue il metodo
 e uguale a quello specificato tramite l'agomento, altrimenti false.
    * @param brano - argomento Song.
    * @return true - se i brani sono uguali, altrimenti false.
    **/
    public boolean equalsTo(Song brano) {
        return this.tag.equals(brano.tag);
    }
    
    //metodi di esposizione
    /**
    * Il metodo si occupa di restituire una stringa con :
    * <p> Titolo: ~ Autore: ~ Anno di pubblicazione: . 
    * @return una stringa ordinata con i dati del brano.
    **/
    public String toStringOrdinato(){
        String stringa = this.getTitle() +" ~ " + this.getAuthor() + " ~ " +this.year;
        return stringa;
    }
    
    public SongChartYTPanel buildPanelView(){
        return new SongChartYTPanel(this);
    }
    
    public void visualizzaEmozioneBrano(){
        //da implementare
    }

    public AddSongToPlaylistPanel buildPanelAddToPlaylist() {
        return new AddSongToPlaylistPanel(this, EMOTIONALSONGS.playListsManager);
    }
    
    public String buildResearchQueryUrl(){
        return "https://www.youtube.com/results?search_query=" + 
                title.replaceAll(" ", "+") +
                "+" + author.replaceAll(" ", "")+
                "+" + String.valueOf(year);
    }
    
    public SongChartForPlaylist buildPlaylistPanel(Playlist propertyPlaylist){
        return new SongChartForPlaylist(EMOTIONALSONGS.getLoggedUser().getUserId(),this,propertyPlaylist);
    }
    
    public int compareTags(Song song) {
        return this.tag.compareTo(song.getTag());
    }

    public int compareTitles(Song song) {
        return this.title.compareTo(song.getTitle());
    }
    
    public int compareAuthors(Song song) {
        return this.author.compareTo(song.getAuthor());
    }
    
    public int compareYear(Song song) {
        return this.year-song.getYear();
    }
    
}
