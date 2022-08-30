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
    private int numeroVoti;
    private int[] votes;
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
    public String getNomeEmozione(){
        return this.nomeEmozione;
    }
    
    /**
     * Restituisce una stringa con la descrizione dell'emozione.
     * @return La descrizione dell'emozione.
     */
    public String getDescrizioneEmozione(){
        return this.descrizioneEmozione;
    }
    
    /**
     * Il metodo chiede all'utente di dare un voto da 1 a 5 in base a quanto percepito,
     * dopodichè chiede se vuole inserire un commento.
     */
    public void voteAnEmotion(){
        giveAVote();
       
    }
    
    /**
     * Il metodo chiede all'utente di inserire un voto
     * da 1 a 5 in base a quanto percepito, dopodichè il voto viene salvato in un array di tipo int.
     */
    public void giveAVote(){
        System.out.println("Inserisca un voto da 1 a 5 in base a quanto ha percepito la seguente emozione, 1 per ninte, 5 molto:");
        System.out.println(getNomeEmozione() + ","+ getDescrizioneEmozione()+": ");
        int[] newArrayVotes = new int[votes.length +1];
        for(int i = 0;i<votes.length;i++){
            newArrayVotes[i] = votes[i];
        }
        newArrayVotes[newArrayVotes.length-1] = new Scanner(System.in).nextInt();
        //metodo che fa reinserire il voto all' utente nel caso sia minore di 1 e maggiore di 5.
        votes = newArrayVotes;
    }
    
    /**
     * Il metodo chiede all'utente di inserire un commento che non deve 
     * superare i 256 caratteri; se superati viene richiesto un altro commento, 
     * dopodichè viene salvato in un array di tipo String.
     */
    public void commentAnEmotion(){
        System.out.println("Inserisca il suo commento, max 256 caratteri!");
        String commentoUtente = new Scanner(System.in).nextLine();
        while(commentoUtente.length()>256) {
            System.out.println("Troppi caratteri nel suo commento,Inserisca un commento di max 256 caratteri!");
            commentoUtente = new Scanner(System.in).nextLine();
        }
        
        String[] newCommentsArray = new String[notes.length + 1];
        for (int i = 0; i < notes.length; i++){
            newCommentsArray[i] = notes[i];  
        }
        
        newCommentsArray[newCommentsArray.length-1] = new Scanner(System.in).nextLine();
        notes = newCommentsArray;
    }
    
    /**
     * Il metodo importa i voti inseriti.
     * @param voti 
     */
    public void importaVoti(String voti){
        String[] votiSplitted = voti.split(" ");
        int[] votiInt = new int[votiSplitted.length];
        for(int i = 0; i<votiInt.length;i++){
            votiInt[i] = Integer.parseInt(votiSplitted[i]);
        }
        votes = votiInt;
        numeroVoti = votes.length;
    }
    
    /**
     * Il metodo importa i commenti inseriti dall'utente.
     * @param Commenti 
     */
    public void importaCommenti(String Commenti){
        String[] commentiSplitted = Commenti.split("<>");
        notes = commentiSplitted;
    }

    /**
     * Il metodo restituisce il voto.
     * @return il voto.
     */
    public int getNumeroVoti() {
        return numeroVoti;
    }
    
    /**
     * Il metodo restituisce una stringa con i voti inseriti dall'utente.
     * @return i voti. 
     */
    public String stringaVoti(){
        String stringa = "";
        for(int i = 0;i<votes.length;i++){
            stringa += i<votes.length-1? votes[i] + " ": votes[i];
        }
        return stringa;
    }
    
    /**
     * Il metodo restituisce una stringa con i commenti inseriti dall'utente.
     * @return i commenti.
     */
    public String stringaCommenti(){
        String stringa = "";
        for(int i = 0;i<notes.length;i++){
            stringa += i<notes.length-1? notes[i] + "<>": notes[i];
        }
        return stringa;
    }
}
