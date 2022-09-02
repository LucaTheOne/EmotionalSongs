package emotionalsongs;

import java.util.*;

/**
 * Le costanti rappresentano delle emozioni da attribuire al brano. 
 * @author Bolelli Luca
 */
public enum Emozioni {

     /**
     * Meraviglia - Sensazione di stupore o felicità.
     */    
    AMAZEMENT("Meraviglia","Sensazione di stupore o felicità."),
    /**
     * Solennità - Sensazione di trascendenza, ispirazione. Brividi.
     */    
    SOLEMNITY("Solennità","Sensazione di trascendenza, ispirazione. Brividi."),
    /**
     * Tenereza - Sensualità, affetto, sentimento di amore.
     */
    TENDERNESS("Tenereza","Sensualità, affetto, sentimento di amore."),
    /**
     * Nostalgia - Sognante, malinconia, sentimento di emotività.
     */
    NOSTALGIA("Nostalgia","Sognante, malinconia, sentimento di emotività."),
    /**
     * Pacatezza - Rilassamento, serenità, meditatività.
     */
    CALMNESS("Pacatezza","Rilassamento, serenità, meditatività."),
    /**
     * Potere - Sentirsi forte, eroici , trionfanti, energetici.
     */
    POWER("Potere","Sentirsi forte, eroici , trionfanti, energetici."),
    /**
     * Gioia - Sentirsi come danzanti, raggianti, animati, divertiti.
     */    
    JOY("Gioia","Sentirrsi come danzanti, raggianti, animati, divertiti."),
    /**
     * Tensione - Sentire nervosismo, impazienza, irritazione.
     */
    TENSION("Tensione","Sentire nervosismo, impazienza, irritazione."),
    /**
     * Tristezza - Sentirsi depressi, scarichi, dispiaciuti.
     */
    SADNESS("Tristezza","Sentirsi depressi, scarichi, dispiaciuti.");
  
    //campi
    final private String nomeEmozione;
    final private String descrizioneEmozione;
    private int[] marks;
    private String[] notes;

    
  //costruttori
     /**
     * Costruisce l'oggetto con l'emozione e relativa descrizione.
     * @param name - Nome dell'emozione.
     * @param explanation - Descrizione dell'emozione.
     */
    Emozioni(String name,String explanation){
        this.nomeEmozione = name;
        this.descrizioneEmozione = explanation;
    }
  
  //metodi
     /**
     * Restituisce una stringa con il nome dell'emozione.
     * @return Il nome dell'emozione.
     */
    public String getName(){
        return this.nomeEmozione;
    }
    
    /**
     * Restituisce una stringa con la descrizione dell'emozione.
     * @return La descrizione dell'emozione.
     */
    public String getDescription(){
        return this.descrizioneEmozione;
    }
    
    public Emozioni getEmotion(){
        return this;
    }
    
    /**
     * Il metodo chiede all'utente di dare un voto da 1 a 5 in base a quanto percepito,
     * dopodichè chiede se vuole inserire un commento.
     */
    public void voteEmotion(int mark){
        int[] array = new int[marks.length];
        for(int i = 0;i<marks.length;i++){
            array[i] = marks[i];
        }
        array[array.length-1] = mark;
        marks = array;
    }
    
    /**
     * Il metodo chiede all'utente di inserire un commento che non deve 
     * superare i 256 caratteri; se superati viene richiesto un altro commento, 
     * dopodichè viene salvato in un array di tipo String.
     */
    public void commentEmotion(String note){
        String[] array = new String[notes.length];
        for(int i = 0;i<notes.length;i++){
            array[i] = notes[i];
        }
        array[array.length-1] = note;
        notes = array;
    }
    
    /**
     * Il metodo importa i commenti inseriti dall'utente.
     * @param Commenti 
     */
    public void importNotes(String Commenti){
        String[] commentiSplitted = Commenti.split("<>");
        notes = commentiSplitted;
    }
    
    public int [] getMarks(){
        return this.marks;
    }
    /**
     * Il metodo restituisce il voto.
     * @return il voto.
     */
    public int getNumeroVoti() {
        return marks.length;
    }
    
    public String[] getNotes(){
        return this.notes;
    }
    
    public String stringaEmozione(){
        return stringaVoti()+stringaCommenti();
    }
    /**
     * Il metodo restituisce una stringa con i voti inseriti dall'utente.
     * @return i voti. 
     */
    private String stringaVoti(){
        String stringa = String.valueOf(marks[0]);
        for (int i = 1; i < marks.length;i++){
            stringa += "," + marks[i];
        }
        return stringa+";";
    }
    
    /**
     * Il metodo restituisce una stringa con i commenti inseriti dall'utente.
     * @return i commenti.
     */
    private String stringaCommenti(){
        String stringa = notes[0];
        for (int i = 1; i < notes.length;i++){
            stringa += "<SEP>" + notes[i];        }
        return stringa;
    }
}
