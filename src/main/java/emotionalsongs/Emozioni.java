package emotionalsongs;

import java.util.*;

public enum Emozioni {
  AMAZEMENT("Amazement","Feeling of wonder or happiness."),
  SOLEMNITY("Solemnity","Feeling of trascendence,inspiration. Thrills."),
  TENDERNESS("Tenderness","Sensuality, affect, feeling of love."),
  NOSTALGIA("Nostalgia","Dreamy, melancholic, sentimental feelings."),
  CALMNESS("Calmness","Relaxation, serenity,meditativeness."),
  POWER("Power","Feeling strong,heroic,triumphant, energetic."),
  JOY("Joy","Feeling like dancing, bouncy feeling, animated, amused."),
  TENSION("Tension","Feeling nervous,impatient,irritated."),
  SADNESS("Sadness","Feeling depressed, sorrowful.");
  
  //campi
  final private String name;
  final private String explanation;
  int[] votes;
  String[] notes;

  //costruttori
  Emozioni(String name,String explanation){
    this.name = name;
    this.explanation = explanation;
    //this.score = score;
    //this.note = note;
  }
  //metodi
  public String getName(){
    return this.name;
  }

  public String getExplanation(){
    return this.explanation;
  }
  
    public void voteAnEmotion(){
        giveAVote();
        System.out.println("Vuole inserire un commento riguardo a questa emozione: "+name+"? ");
        System.out.println("Prema S se si, N se non vuole aggiungere commenti");
        String scelta = new Scanner(System.in).nextLine();
        if(scelta.toLowerCase().contains("s")){
            commentAnEmotion();
        }
    }
    public void giveAVote(){
        System.out.println("Inserisca un voto da 1 a 5 in base a quanto ha percepito la seguente emozione, 1 per ninte, 5 molto:");
        System.out.println(getName() + ","+ getExplanation()+": ");
        int[] newArrayVotes = new int[votes.length +1];
        for(int i = 0;i<votes.length;i++){
            newArrayVotes[i] = votes[i];
        }
        newArrayVotes[newArrayVotes.length-1] = new Scanner(System.in).nextInt();
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
}
