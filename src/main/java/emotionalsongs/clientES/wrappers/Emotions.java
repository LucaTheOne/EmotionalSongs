/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.wrappers;
import emotionalsongs.*;

/**
 * Tipo enumerativo le cui costanti rappresentano emozioni attribuibili ad ogni brano.
 * Ogni Emozione è composta da due campi:
 * <ul>
 * <li>@param <i>name</i> che contiene il nome dell'emozione.</li>
 * <li>@param <i>explanation</i> che contiene la descrizione ufficiale dell' emozione.</li>
 * </ul>
 * 
 */
public enum Emotions {
    
    /**
    * Meraviglia - Sensazione di stupore o felicità.
    */
    AMAZEMENT(EmotionalSongs.dialoghi.amazementName(),EmotionalSongs.dialoghi.amazementExplanation()),
    /**
     * Solennità - Sensazione di trascendenza, ispirazione. Brividi.
     */
    SOLEMNITY(EmotionalSongs.dialoghi.solemnityName(),EmotionalSongs.dialoghi.solemnityExplanation()),
    /**
     * Tenereza - Sensualità, affetto, sentimento di amore.
     */
    TENDERNESS(EmotionalSongs.dialoghi.tendernessName(),EmotionalSongs.dialoghi.tendernessExplanation()),
    /**
     * Nostalgia - Sognante, malinconia, sentimento di emotività.
     */
    NOSTALGIA(EmotionalSongs.dialoghi.nostalgiaName(),EmotionalSongs.dialoghi.nostalgiaExplanation()),
    /**
     * Pacatezza - Rilassamento, serenità, meditatività.
     */
    CALMNESS(EmotionalSongs.dialoghi.calmnessName(),EmotionalSongs.dialoghi.calmnessExplanation()),
    /**
     * Potere - Sentirsi forte, eroici , trionfanti, energetici.
     */
    POWER(EmotionalSongs.dialoghi.powerName(),EmotionalSongs.dialoghi.powerExplanation()),
    /**
     * Gioia - Sentirsi come danzanti, raggianti, animati, divertiti.
     */
    JOY(EmotionalSongs.dialoghi.joyName(),EmotionalSongs.dialoghi.joyExplanation()),
    /**
     * Tensione - Sentire nervosismo, impazienza, irritazione.
     */
    TENSION(EmotionalSongs.dialoghi.tensionName(),EmotionalSongs.dialoghi.tensionExplanation()),
    /**
     * Tristezza - Sentirsi depressi, scarichi, dispiaciuti.
     */
    SADNESS(EmotionalSongs.dialoghi.sadnessName(),EmotionalSongs.dialoghi.sadnessExplanation());

    //campi
    final private String nomeEmozione;
    final private String descrizioneEmozione;
    
    //PUBLIC STATIC CONSTANTS
    /**
     * Intero rappresentante l' indice della posizione dell' emozione <i>Meraviglia</i>.
     */
    public static int AMAZEMENT_INDEX = 0;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Solennità</i>.
             */
    public static int SOLEMNITY_INDEX = 1;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Tenerezza</i>.
             */
    public static int TENDERNESS_INDEX = 2;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Nostalgia</i>.
             */
    public static int NOSTALGIA_INDEX = 3;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Calma</i>.
             */
    public static int CALMNESS_INDEX = 4;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Potere</i>.
             */
    public static int POWER_INDEX = 5;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Gioia</i>.
             */
    public static int JOY_INDEX = 6;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Tensione</i>.
             */
    public static int TENSION_INDEX = 7;
            /**
             * Intero rappresentante l' indice della posizione dell' emozione <i>Tristezza</i>.
             */
    public static int SADNESS_INDEX = 8;


    //costruttore
    /**
    * Costruisce l'oggetto Emozione ricevendo come argomento due stringhe:
    * <ul>
    * <li>@param name - Nome dell'emozione.</li>
    * <li>@param explanation - Descrizione dell'emozione.</li>
    */
    Emotions(String name,String explanation){
        this.nomeEmozione = name;
        this.descrizioneEmozione = explanation;
    }

    //metodi getter
     /**
     * Il metodo restituisce la stringa contenente il nome dell'emozione che ne richiama il metodo.
     * @return Il nome dell'emozione.
     */
    public String getName(){
        return this.nomeEmozione;
    }

    /**
     * Il metodo restituisce la stringa contenente la descrizione dell'emozione che ne richiama il metodo.
     * @return La descrizione dell'emozione.
     */
    public String getDescription(){
        return this.descrizioneEmozione;
    }

    /**
     * @return L' istanza dell' emozione che ne richiama il metodo.
     */
    public Emotions getEmotion(){
        return this;
    }

}