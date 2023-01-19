//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.basic_structures;

import emotionalsongs.*;
import emotionalsongs.gui.data_visualizer.*;
import emotionalsongs.gui.playlists.*;
import emotionalsongs.gui.repository.*;
import emotionalsongs.managers.*;

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
    * è uguale a quello specificato tramite l'agomento, altrimenti false.
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
    
    /**
     * Il metodo apre una finestra contenente il report riassuntivo delle emozioni.
     */
    public void visualizzaEmozioneBrano(){
        new DataVisualizationForm(tag).setVisible(true);
    }
    
    //metodi di costruzione
    /**
     * Il metodo crea il pannello della repository. 
     * @return Il pannello.
     */
    public SongPanelForRepositoryView buildPanelView(){
        return new SongPanelForRepositoryView(this);
    }
    
    /**
     * Il metodo crea il pannello che visualizza le canzoni del repository e permette di aggiungerle nella playlist.
     * @return Il pannello.
     */
    public SongToAddToAPlaylistPanel buildPanelAddToPlaylist() {
        return new SongToAddToAPlaylistPanel(this, PlaylistsManager.getInstance());
    }
    
    /**
     * Il metodo costruisce il link di ricerca della canzone su youtube.
     * @return L'url di ricerca della canzone.
     */
    public String buildResearchQueryUrl(){
        return "https://www.youtube.com/results?search_query=" + 
                title.replaceAll(" ", "+") +
                "+" + author.replaceAll(" ", "")+
                "+" + String.valueOf(year);
    }
    
    /**
     * Il metodo crea il pannello che contiene la Playlist.
     * @param propertyPlaylist
     * @return Il pannello con la Playlist.
     */
    public SongPanel buildPanelForPlaylist(Playlist propertyPlaylist){
        return new SongPanel(EmotionalSongs.getLoggedUser().getUserId(),this,propertyPlaylist);
    }
    
    //metodi di confronto
    /**
     * Il metodo restituisce:
     * <ul>
     * <li>Un numero negativo se il tag della canzone che chiama il metodo
     * è lessicograficamente precedente al tag della canzone passata come argomento </li>
     * <li>Un intero positivo se lessicograficamente seguente al tag della canzone passata come argomento </li>
     * <li>Zero se sono uguali </li>
     * </ul>
     * @param song Canzone.
     * @return Ritorna un numero intero.
     */
    public int compareTags(Song song) {
        return this.tag.compareTo(song.getTag());
    }
    
     /**
     * Il metodo restituisce:
     * <ul>
     * <li>Un numero negativo se il titolo della canzone che chiama il metodo
     * è lessicograficamente precedente al titolo della canzone passata come argomento </li>
     * <li>Un intero positivo se lessicograficamente seguente al titolo della canzone passata come argomento </li>
     * <li>Zero se sono uguali </li>
     * </ul>
     * @param song Canzone.
     * @return Ritorna un numero intero.
     */
    public int compareTitles(Song song) {
        return this.title.compareTo(song.getTitle());
    }
    
      /**
     * Il metodo restituisce:
     * <ul>
     * <li>Un numero negativo se l'autore della canzone che chiama il metodo
     * è lessicograficamente precedente all'autore della canzone passata come argomento. </li>
     * <li>Un intero positivo se lessicograficamente seguente all'autore della canzone passata come argomento. </li>
     * <li>Zero se sono uguali. </li>
     * </ul>
     * @param song Canzone.
     * @return Ritorna un numero intero.
     */
    public int compareAuthors(Song song) {
        return this.author.compareTo(song.getAuthor());
    }
    
      /**
     * Il metodo restituisce:
     * <ul>
     * <li>Un numero negativo se l'anno della canzone che chiama il metodo
     * è lessicograficamente precedente all'anno della canzone passata come argomento.</li>
     * <li>Un intero positivo se lessicograficamente seguente all'anno della canzone passata come argomento. </li>
     * <li>Zero se sono uguali. </li>
     * </ul>
     * @param song Canzone.
     * @return Ritorna un numero intero.
     */
    public int compareYear(Song song) {
        return this.year-song.getYear();
    }
    
}
