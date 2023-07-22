/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.basic_structures;

import emotionalsongs.managers.PlaylistsManager;
import emotionalsongs.*;
import emotionalsongs.gui.data_visualizer.*;
import emotionalsongs.gui.playlists.*;
import emotionalsongs.gui.repository.*;
import java.io.*;

/**
* Classe le cui stanze rappresentano una canzone.
* Le sue istanze sono composte da tre stringhe:
* <ul>
*   <li> Titolo della canzone</li>
*   <li> Autore della canzone</li>
*   <li> Anno di pubblicazione della canzone</li>
* </ul>
*
*/
public class Song {

//campi
  private String title,author,tag;
  private int year;
  
    //costruttore
    /**
    * Costruisce Le istanze di Song le quali rappresentano una canzone.
    * @param title - Titolo del brano.
    * @param author - Autore del brano.
    * @param year - Anno del brano.
    * @param tag - Tag Univoco del brano.
    * @throws IOException 
    */
    public Song(String title, String author,String year,String tag) throws IOException{
        this.title = title;
        this.author = author;
        this.year = Integer.parseInt(year);
        this.tag = tag;
    }

    //metodi getter
    /**
    * Il metodo restiuisce una stringa contenente il titolo del brano.
    * @return titolo del brano. 
    */
    public String getTitle(){
        return this.title;
    }

    /**
    * Il metodo restiuisce una stringa contenente l'autore del brano.
    * @return autore del brano.
    */
    public String getAuthor(){
        return this.author;
    }

    /**
    * Il metodo restiuisce una stringa contenente l'anno di pubblicazione del brano.
    * @return anno del brano.
    */  
    public int getYear(){
        return this.year;
    }

    /**
    * Il metodo restiuisce la stringa contenente il tag del brano.
    * @return tag del brano.
    */  
    public String getTag(){
        return this.tag;
    }

    //metodi di confronto
    /**
    * Il metodo restituisce true se il tag del' istanza di Song che esegue il metodo
    * è uguale a quello dell' istanza di Song specificata tramite l'agomento, altrimenti false.
    * Nota: Essendo il tag univoco, tag diversi indiano canzoni diversi
    * @param brano - argomento Song.
    * @return <ul><li>true -> se i tag dei brani sono uguali.</li><li>false -> se i tag dei brani non sono uguali.</li></ul>
    **/
    public boolean equalsTo(Song brano) {
        return this.tag.equals(brano.tag);
    }
    
    //metodi di esposizione
    /**
    * Il metodo restituisce una stringa con nel formato:
    * Titolo ~ Autore ~ Anno di pubblicazione: . 
    * @return una stringa ordinata con i dati del brano divisi da ~.
    **/
    public String toStringOrdinato(){
        String stringa = this.getTitle() +" ~ " + this.getAuthor() + " ~ " +this.year;
        return stringa;
    }
    
    /**
     * Questo metodo costruisce e poi mostra un istanza di DataVisualizationForm relativa alla canzone rappresentata.
     * Il frame che così appare contiene grafici con i dati relativi ai giudizi emozionali relativi alla Istanza di Song che chiama il metodo,
     * un report testuale e dei metodi per esportare tali dati.
     */
    public void visualizzaEmozioneBrano(){
        new DataVisualizationForm(tag).setVisible(true);
    }
    
    //metodi di costruzione
    /**
     * Il metodo crea un istanza di SongPanelForRepositoryView consistente in un Pannello (Estenzione di JPanel)
     * esponente i campi rappresentanti dell ' istanza di Song che chiama questo metodo.
     * @return Pannello rappresentativo della canzone durante l' ispezione del repository.
     */
    public SongPanelForRepositoryView buildPanelView(){
        return new SongPanelForRepositoryView(this);
    }
    
    /**
     * Il metodo crea in istanza di SongToAddToAPlaylistPanel consistente in un Pannello (Estenzione di JPanel)
     * esponente i campi rappresentanti dell ' istanza di Song e che permette di aggiungere la canzone rappresentata dell' istanza che chiama il metodo ad una playlist
     * durante il form di creazione.
     * @return Pannello rappresentativo della canzone durante la creazione di una playlist.
     */
    public SongToAddToAPlaylistPanel buildPanelAddToPlaylist() {
        return new SongToAddToAPlaylistPanel(this, PlaylistsManager.getInstance());
    }
    
    /**
     * Il metodo ritorna una stringa con il link di ricerca della canzone, rappresentata dall' istanza che ne chiama il metodo, su youtube.
     * @return L'url di ricerca della canzone.
     */
    public String buildResearchQueryUrl(){
        return "https://www.youtube.com/results?search_query=" + 
                title.replaceAll(" ", "+") +
                "+" + author.replaceAll(" ", "")+
                "+" + String.valueOf(year);
    }
    
    /**
     * Il metodo ritorna un istanza di SongPanel, estensione di JPanel, la quale rappresenta graficamente l' istanza di Song che richiama il metodo
     * come parte di una playlist.
     * @param propertyPlaylist la Playlist in cui il brano è contenuto.
     * @return Il pannello con la Playlist.
     */
    public SongPanel buildPanelForPlaylist(Playlist propertyPlaylist){
        return new SongPanel(EmotionalSongs.getLoggedUser().getUserId(),this,propertyPlaylist);
    }
    
    //metodi di confronto
    /**
     * @param song Istanza di Song con cui confrontare l' istanza che chiama il metodo.
     * @return <ul>
     * <li><b>Un numero negativo</b> se il tag della istanza di Song che chiama il metodo
     * è <b>lessicograficamente precedente</b> al tag della istanza di Song passata come argomento.</li> 
     * <li><b>Un intero positivo</b> se lessicograficamente seguente al tag della canzone passata come argomento </li>
     * <li>Zero altrimenti. </li>
     * </ul>
     */
    public int compareTags(Song song) {
        return this.tag.compareTo(song.getTag());
    }
    
     /**
     * @param song Istanza di Song con cui confrontare l' istanza che chiama il metodo.
     * @return <ul>
     * <li><b>Un numero negativo</b> se il titolo della istanza di Song che chiama il metodo è <b>lessicograficamente precedente</b> al titolo della canzone passata come argomento </li>
     * <li><b>Un intero positivo</b> se il titolo della istanza di Song che chiama il metodo è <b>lessicograficamente seguente</b> al titolo della canzone passata come argomento </li>
     * <li>Zero altrimenti. </li>
     * </ul>
     */
    public int compareTitles(Song song) {
        return this.title.compareTo(song.getTitle());
    }
    
    /**
     * 
     * @param song Istanza di Song con cui confrontare l' istanza che chiama il metodo.
     * @return <ul>
     * <li><b>Un numero negativo</b> se l' autore della istanza di Song che chiama il metodo è <b>lessicograficamente precedente</b> al autore della canzone passata come argomento </li>
     * <li><b>Un intero positivo</b> se l' autore della istanza di Song che chiama il metodo è <b>lessicograficamente seguente</b> al autore della canzone passata come argomento </li>
     * <li>Zero altrimenti. </li>
     * </ul>
     */
    public int compareAuthors(Song song) {
        return this.author.compareTo(song.getAuthor());
        
    }
    
    /**
     * 
     * @param song Canzone.
     * @return <ul>
     * <li><b>Un numero negativo</b> se l' anno della istanza di Song che chiama il metodo è <b>lessicograficamente precedente</b> l' anno della canzone passata come argomento </li>
     * <li><b>Un intero positivo</b> se l' anno della istanza di Song che chiama il metodo è <b>lessicograficamente seguente</b> l' anno della canzone passata come argomento </li>
     * <li>Zero altrimenti. </li>
     * </ul>
     */
    public int compareYear(Song song) {
        return this.year-song.getYear();
    }
    
}
