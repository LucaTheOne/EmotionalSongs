//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA


package emotionalsongs.basic_structures;

/**
 * La classe importa le emozioni per ogni brano.
 * @author 
 */
public class UserJudgement {
    
    private String branoTag;
    
    private String userID;
    
    private int amazementMark,solemnityMark,tendernessMark,nostalgiaMark,calmnessMark,powerMark,joyMark,tensionMark,sadnessMark;
    
    private String amazementNotes, solemnityNotes, tendernessNotes, nostalgiaNotes, calmnessNotes, powerNotes, joyNotes, tensionNotes, sadnessNotes;
    //costruttori
    
    public UserJudgement(String fileLine){
        
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

    public UserJudgement(String branoTag, String userID, int amazementMarks, String amazementNotes, int solemnityMarks, String solemnityNotes, int tendernessMarks, String tendernessNotes, int nostalgiaMarks, String nostalgiaNotes, int calmnessMarks, String calmnessNotes, int powerMarks, String powerNotes, int joyMarks, String joyNotes, int tensionMarks, String tensionNotes, int sadnessMarks, String sadnessNotes) {
        
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
     * Il metodo crea una stringa con il titolo del brano, autore, anno e tag,
     * e una riga nuova con ogni emozione, voto e commento. 
     * @return una stringa con il brano, emozioni e commenti.
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
     * Il metodo restituisce il userID.
     * @return il userID
     */
    public String getUserIDRecord() {
        return this.userID;
    }
    
    //comparing
    
    /**
     * Il metodo restituisce:
     * <ul>
     * <li>Un numero negativo se il tag della canzone che chiama il metodo
     * è lessicograficamente precedente al tag della canzone che l'utente a passata come argomento.</li>
     * <li>Un intero positivo se lessicograficamente seguente al tag della canzone passata come argomento. </li>
     * <li>Zero se sono uguali. </li>
     * </ul>
     * @param record
     * @return Un numero intero.
     */
    public int compareTo(UserJudgement record) {
        return this.branoTag.compareTo(record.getBranoTag());
    }
    
    /**
     * Il metodo restituisce un array di interi contenente tutti i voti.
     * @return Array di interi.
     */
    public int[] getMarksArray(){
        int[] arrayMarks = new int[9];
        arrayMarks[0] = amazementMark;
        arrayMarks[1] = solemnityMark;
        arrayMarks[2] = tendernessMark;
        arrayMarks[3] = nostalgiaMark;
        arrayMarks[4] = calmnessMark;
        arrayMarks[5] = powerMark;
        arrayMarks[6] = joyMark;
        arrayMarks[7] = tensionMark;
        arrayMarks[8] = sadnessMark;
        return arrayMarks;
    }
    
    /**
     * Il metodo restituisce un array di stringhe contenente tutti i commenti.
     * @return Array di stringhe.
     */
    public String[] getNotesArray(){
        String[] arrayNotes = new String[9];
        arrayNotes[0] = amazementNotes;
        arrayNotes[1] = solemnityNotes;
        arrayNotes[2] = tendernessNotes;
        arrayNotes[3] = nostalgiaNotes;
        arrayNotes[4] = calmnessNotes;
        arrayNotes[5] = powerNotes;
        arrayNotes[6] = joyNotes;
        arrayNotes[7] = tendernessNotes;
        arrayNotes[8] = sadnessNotes;
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
