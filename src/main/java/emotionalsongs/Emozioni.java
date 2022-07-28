package emotionalsongs;

import java.util.*;

public enum Emozioni {

    AMAZEMENT("Meraviglia","Sensazione di stupore o felicità."),
    SOLEMNITY("Solennità","Sensazione di trascendenza, ispirazione. Brividi."),
    TENDERNESS("Tenereza","Sensualità, affetto, sentimento di amore."),
    NOSTALGIA("Nostalgia","Sognante, malinconia, sentimento di emotività."),
    CALMNESS("Pacatezza","Rilassamento, serenità, meditatività."),
    POWER("Potere","Sentirsi forte, eroici , trionfanti, energetici."),
    JOY("Gioia","Sentirrsi come danzanti, raggianti, animati, divertiti."),
    TENSION("Tensione","Sentire nervosismo, impazienza, irritazione."),
    SADNESS("Tristezza","Sentirsi depressi, scarichi, dispiaciuti.");
  
    //campi
    final private String nomeEmozione;
    final private String descrizioneEmozione;
    private int numeroVoti;
    private int[] votes;
    private String[] notes;

  //costruttori
    Emozioni(String name,String explanation){
        this.nomeEmozione = name;
        this.descrizioneEmozione = explanation;
    }
  
  //metodi
    public String getNomeEmozione(){
        return this.nomeEmozione;
    }
    
    public String getDescrizioneEmozione(){
        return this.descrizioneEmozione;
    }
    
    public void voteAnEmotion(){
        giveAVote();
        System.out.println("Vuole inserire un commento riguardo a questa emozione: "+nomeEmozione+"? ");
        if(Utilities.readYesOrNot()){
            commentAnEmotion();
        }
    }
    
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
    
    public void importaVoti(String voti){
        String[] votiSplitted = voti.split(" ");
        int[] votiInt = new int[votiSplitted.length];
        for(int i = 0; i<votiInt.length;i++){
            votiInt[i] = Integer.parseInt(votiSplitted[i]);
        }
        votes = votiInt;
        numeroVoti = votes.length;
    }
    
    public void importaCommenti(String Commenti){
        String[] commentiSplitted = Commenti.split("<>");
        notes = commentiSplitted;
    }

    public int getNumeroVoti() {
        return numeroVoti;
    }
    
    public String stringaVoti(){
        String stringa = "";
        for(int i = 0;i<votes.length;i++){
            stringa += i<votes.length-1? votes[i] + " ": votes[i];
        }
        return stringa;
    }
    
    public String stringaCommenti(){
        String stringa = "";
        for(int i = 0;i<notes.length;i++){
            stringa += i<notes.length-1? notes[i] + "<>": notes[i];
        }
        return stringa;
    }
}
