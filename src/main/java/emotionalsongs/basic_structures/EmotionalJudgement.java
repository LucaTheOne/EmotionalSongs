//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.basic_structures;

/**
 * Classe le cui istanze rappresentano una valutazione emozionale:
 * <ul>
 * <li> Riguardo una singola canzone.</li>
 * <li> Da parte di un singolo utente.</li>
 * <li> Sulla base di nove emozioni</li>
 * </ul>
 * Tali valutazioni contengono sia note che valutazioni da 1 a 5 per ogni emozione, dove
 * 1 indica per nulla, 5 appieno;
 */
public class EmotionalJudgement {
    
    private String branoTag;
    
    private String userID;
    
    private int amazementMark,solemnityMark,tendernessMark,nostalgiaMark,calmnessMark,powerMark,joyMark,tensionMark,sadnessMark;
    
    private String amazementNotes, solemnityNotes, tendernessNotes, nostalgiaNotes, calmnessNotes, powerNotes, joyNotes, tensionNotes, sadnessNotes;
    //costruttori
    
    /**
     * Costruttore che prendendo come argomento una singola line del file Emozioni.dati.txt vi ci costruisce
     * un istanza della classe.
     * @param fileLine Stringa estratta da una riga del file Emozioni.dati.txt.
     */
    public EmotionalJudgement(String fileLine){
        
        String[] fileLineSplitted = fileLine.split(";");
        
        branoTag = fileLineSplitted[0];
        userID= fileLineSplitted[1];
        
        amazementMark = Integer.parseInt(fileLineSplitted[2]); amazementNotes = fileLineSplitted[3];
        solemnityMark = Integer.parseInt(fileLineSplitted[4]); solemnityNotes = fileLineSplitted[5];
        tendernessMark = Integer.parseInt(fileLineSplitted[6]); tendernessNotes = fileLineSplitted[7];
        nostalgiaMark = Integer.parseInt(fileLineSplitted[8]); nostalgiaNotes = fileLineSplitted[9];
        calmnessMark = Integer.parseInt(fileLineSplitted[10]); calmnessNotes = fileLineSplitted[11];
        powerMark = Integer.parseInt(fileLineSplitted[12]); powerNotes = fileLineSplitted[13];
        joyMark = Integer.parseInt(fileLineSplitted[14]); joyNotes = fileLineSplitted[15];
        tensionMark = Integer.parseInt(fileLineSplitted[16]); tensionNotes = fileLineSplitted[17];
        sadnessMark = Integer.parseInt(fileLineSplitted[18]); sadnessNotes = fileLineSplitted[19];
    }
    /**
     * Costruttore che costruisce un istanza della classe passando come argomenti cio che la compone.
     * @param branoTag Tag della istanza di Song che rappresenta la canzone giudicata.
     * @param userID    ID dell' istaza di User che ha effettuato il giudizio emozionale.
     * @param amazementMarks Intero rappresentante il voto relativo all' emozione Meraviglia.
     * @param amazementNotes Nota espressa dall' utente riguardo l' emozione Meraviglia.
     * @param solemnityMarks Intero rappresentante il voto relativo all' emozione Solennità.
     * @param solemnityNotes Nota espressa dall' utente riguardo l' emozione Solennità.
     * @param tendernessMarks Intero rappresentante il voto relativo all' emozione tenerezza.
     * @param tendernessNotes Nota espressa dall' utente riguardo l' emozione Tenerezza.
     * @param nostalgiaMarks Intero rappresentante il voto relativo all' emozione Nostalgia.
     * @param nostalgiaNotes Nota espressa dall' utente riguardo l' emozione Nostalgia.
     * @param calmnessMarks Intero rappresentante il voto relativo all' emozione Calma.
     * @param calmnessNotes Nota espressa dall' utente riguardo l' emozione Calma.
     * @param powerMarks Intero rappresentante il voto relativo all' emozione Potere.
     * @param powerNotes Nota espressa dall' utente riguardo l' emozione Potere.
     * @param joyMarks Intero rappresentante il voto relativo all' emozione Gioia.
     * @param joyNotes Nota espressa dall' utente riguardo l' emozione Gioia.
     * @param tensionMarks Intero rappresentante il voto relativo all' emozione Tensione.
     * @param tensionNotes Nota espressa dall' utente riguardo l' emozione Tensione.
     * @param sadnessMarks Intero rappresentante il voto relativo all' emozione Tristezza.
     * @param sadnessNotes Nota espressa dall' utente riguardo l' emozione Tristezza.
     */
    public EmotionalJudgement(String branoTag, String userID, int amazementMarks, String amazementNotes, int solemnityMarks, String solemnityNotes, int tendernessMarks, String tendernessNotes, int nostalgiaMarks, String nostalgiaNotes, int calmnessMarks, String calmnessNotes, int powerMarks, String powerNotes, int joyMarks, String joyNotes, int tensionMarks, String tensionNotes, int sadnessMarks, String sadnessNotes) {
        
        this.branoTag = branoTag;
        this.userID = userID;
        
        this.amazementMark = amazementMarks; this.amazementNotes = amazementNotes;
        this.solemnityMark = solemnityMarks; this.solemnityNotes = solemnityNotes;
        this.tendernessMark = tendernessMarks; this.tendernessNotes = tendernessNotes;
        this.nostalgiaMark = nostalgiaMarks; this.nostalgiaNotes = nostalgiaNotes;
        this.calmnessMark = calmnessMarks; this.calmnessNotes = calmnessNotes;
        this.powerMark = powerMarks; this.powerNotes = powerNotes;
        this.joyMark = joyMarks; this.joyNotes = joyNotes;
        this.tensionMark = tensionMarks; this.tensionNotes = tensionNotes;
        this.sadnessMark = sadnessMarks; this.sadnessNotes = sadnessNotes;
    }

    /**
     * Il metodo crea una stringa, rappresentante il singolo giudizio emozione di un utente per una canzone, formattata
     * nel formato del file Emozioni.dati.txt.
     * @return Stringa per il formato del file Emozioni.dati.txt.
     */
    public String stringaRecord() {
        return branoTag +";"+
                userID +";"+
                amazementMark+";"+ amazementNotes +";"+
                solemnityMark+";"+ solemnityNotes +";"+
                tendernessMark+";"+ tendernessNotes +";"+
                nostalgiaMark+";"+ nostalgiaNotes +";"+
                calmnessMark+";"+ calmnessNotes +";"+
                powerMark+";"+ powerNotes +";"+
                joyMark+";"+ joyNotes +";"+
                tensionMark+";"+ tensionNotes +";"+
                sadnessMark+";"+ sadnessNotes +";";
    }

    //getters
    /**
     * Il metodo restituisce il tag del brano.
     * @return Tag del brano.
     */
    public String getBranoTag() {
        return this.branoTag;
    }

    /**
     * Il metodo restituisce l' userID.
     * @return il userID
     */
    public String getUserIDRecord() {
        return this.userID;
    }
    
    //comparing
    
    /**
     * 
     * @param record
     * @return <ul>
     * <li><b>Un intero negativo</b> se il tag della canzone giudicata nel giudizio emozionale che chiama il metodo è <b>lessicograficamente precedente</b> al tag della canzone giudicata nel giudizio emozionale della canzone passata come argomento.</li>
     * <li><b>Un intero positivo</b> se il tag della canzone giudicata nel giudizio emozionale che chiama il metodo è <b>lessicograficamente seguente</b> al tag della canzone giudicata nel giudizio emozionale della canzone passata come argomento.</li>
     * <li>Zero se sono uguali. </li>
     * </ul>
     */
    public int compareTo(EmotionalJudgement record) {
        return this.branoTag.compareTo(record.getBranoTag());
    }
    
    /**
     * Il metodo restituisce un array di interi contenente i voti di tutte le emozioni.
     * @return Array di interi.
     */
    public int[] getMarksArray(){
        int[] arrayMarks = new int[9];
        arrayMarks[Emotions.AMAZEMENT_INDEX] = amazementMark;
        arrayMarks[Emotions.SOLEMNITY_INDEX] = solemnityMark;
        arrayMarks[Emotions.TENDERNESS_INDEX] = tendernessMark;
        arrayMarks[Emotions.NOSTALGIA_INDEX] = nostalgiaMark;
        arrayMarks[Emotions.CALMNESS_INDEX] = calmnessMark;
        arrayMarks[Emotions.POWER_INDEX] = powerMark;
        arrayMarks[Emotions.JOY_INDEX] = joyMark;
        arrayMarks[Emotions.TENSION_INDEX] = tensionMark;
        arrayMarks[Emotions.SADNESS_INDEX] = sadnessMark;
        return arrayMarks;
    }
    
    /**
     * Il metodo restituisce un array di stringhe contenente i commenti riguardo a tutte le emozioni.
     * @return Array di stringhe.
     */
    public String[] getNotesArray(){
        String[] arrayNotes = new String[9];
        arrayNotes[Emotions.AMAZEMENT_INDEX] = amazementNotes;
        arrayNotes[Emotions.SOLEMNITY_INDEX] = solemnityNotes;
        arrayNotes[Emotions.TENDERNESS_INDEX] = tendernessNotes;
        arrayNotes[Emotions.NOSTALGIA_INDEX] = nostalgiaNotes;
        arrayNotes[Emotions.CALMNESS_INDEX] = calmnessNotes;
        arrayNotes[Emotions.POWER_INDEX] = powerNotes;
        arrayNotes[Emotions.JOY_INDEX] = joyNotes;
        arrayNotes[Emotions.TENDERNESS_INDEX] = tendernessNotes;
        arrayNotes[Emotions.SADNESS_INDEX] = sadnessNotes;
        return arrayNotes;
    }
    //amazement getters
    /**
     * Il metodo restituisce il voto dell'emozione Meraviglia.
     * @return Il voto dell'emozione Meraviglia.
     */
    public int getAmazementMark(){
        return amazementMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Meraviglia.
     * @return Il commento all'emozione Meraviglia.
     */
    public String getAmazementNotes(){
        return amazementNotes;
    }
    
    //solemnity getters
    /**
     * Il metodo restituisce il voto dell'emozione Solennità.
     * @return Il voto dell'emozione Solennità.
     */
    public int getSolemnityMark(){
        return solemnityMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Solennità.
     * @return Il commento all'emozione Solennità.
     */
    public String getSolemnityNotes(){
        return solemnityNotes;
    }
    
    //tenderness Getters
    /**
     * Il metodo restituisce il voto dell'emozione Tenerezza.
     * @return Il voto dell'emozione Tenerezza.
     */
    public int getTendernessMark(){
        return tendernessMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Tenerezza.
     * @return Il commento all'emozione Tenerezza.
     */
    public String getTendernessNotes(){
        return tendernessNotes;
    }
    
    //nostalgia getters
     /**
     * Il metodo restituisce il voto dell'emozione Nostalgia.
     * @return Il voto dell'emozione Nostalgia.
     */
    public int getNostalgiaMark(){
        return nostalgiaMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Nostalgia.
     * @return Il commento all'emozione Nostalgia.
     */
    public String getNostalgiaNotes(){
        return nostalgiaNotes;
    }
    
    //calmness getters
     /**
     * Il metodo restituisce il voto dell'emozione Pacatezza.
     * @return Il voto dell'emozione Pacatezza.
     */
    public int getCalmnessMark(){
        return calmnessMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Pacatezza.
     * @return Il commento all'emozione Pacatezza.
     */
    public String getCalmnessNotes(){
        return calmnessNotes;
    }
    
    //power getters
     /**
     * Il metodo restituisce il voto dell'emozione Potere.
     * @return Il voto dell'emozione Potere.
     */
    public int getPowerMark(){
        return powerMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Potere.
     * @return Il commento all'emozione Potere.
     */
    public String getPowerNotes(){
        return powerNotes;
    }
    
    //joy getters
     /**
     * Il metodo restituisce il voto dell'emozione Gioia.
     * @return Il voto dell'emozione Gioia.
     */
    public int getJoyMark(){
        return joyMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Gioia.
     * @return Il commento all'emozione Gioia.
     */
    public String getJoyNotes(){
        return joyNotes;
    }
    
    //tension getters
     /**
     * Il metodo restituisce il voto dell'emozione Tensione.
     * @return Il voto dell'emozione Tensione.
     */
    public int getTensionMark(){
        return tensionMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Tensione.
     * @return Il commento all'emozione Tensione.
     */
    public String getTensionNotes(){
        return tensionNotes;
    }
    
    //sadness getters
    /**
     * Il metodo restituisce il voto dell'emozione Tristezza.
     * @return Il voto dell'emozione Tristezza.
     */
    public int getSadnessMark(){
        return sadnessMark;
    }
    
    /**
     * Il metodo restituisce il commento all'emozione Tristezza.
     * @return Il commento all'emozione Tristezza.
     */
    public String getSadnessNotes(){
        return sadnessNotes;
    }
    
}
