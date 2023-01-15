//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.BasicsStructure;


/**
 * Le costanti rappresentano delle emozioni da attribuire al brano.
 * @author Bolelli Luca
 */
public enum Emotions {
    
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
    
    //PUBLIC STATIC CONSTANTS
    public static int 
            AMAZEMENT_INDEX = 0,
            SOLEMNITY_INDEX = 1,
            TENDERNESS_INDEX = 2,
            NOSTALGIA_INDEX = 3,
            CALMNESS_INDEX = 4,
            POWER_INDEX = 5,
            JOY_INDEX = 6,
            TENSION_INDEX = 7,
            SADNESS_INDEX = 8;


    //costruttori
    /**
    * Costruisce l'oggetto con l'emozione e relativa descrizione.
    * @param name - Nome dell'emozione.
    * @param explanation - Descrizione dell'emozione.
    */
    Emotions(String name,String explanation){
        this.nomeEmozione = name;
        this.descrizioneEmozione = explanation;
    }

    //metodi getter
     /**
     * Il metodo restituisce una stringa con il nome dell'emozione.
     * @return Il nome dell'emozione.
     */
    public String getName(){
        return this.nomeEmozione;
    }

    /**
     * Il metodo restituisce una stringa con la descrizione dell'emozione.
     * @return La descrizione dell'emozione.
     */
    public String getDescription(){
        return this.descrizioneEmozione;
    }

    /**
     * Il metodo restituisce l'emozione richiesta.
     * @return L'emozione.
     */
    public Emotions getEmotion(){
        return this;
    }

}