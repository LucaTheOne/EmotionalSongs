package emotionalsongs;

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
  final String name;
  final String explanation;

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

}
