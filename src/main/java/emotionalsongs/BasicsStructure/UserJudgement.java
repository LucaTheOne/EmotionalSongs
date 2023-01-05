
package emotionalsongs.BasicsStructure;

/**
 * La classe importa le emozioni per ogni brani.
 * @author 
 */
public class UserJudgement {

    Emozioni emotions;
    //DataBaseUsers userDatabase = EMOTIONALSONGS.userDataBase;
    
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
    /*
    //Utente
    public void aggiornaListaUtentiVotato(User user){
        String[] newArray = new String[usersIds.length+1];
        for(int i = 0;i<usersIds.length;i++){
           newArray[i] = usersIds[i];
        }
        newArray[newArray.length-1] = user.getUserId();
        usersIds=newArray;
    }
    
    private String stringaUtenti(){
        String stringa = usersIds[0];
        for (int i = 1; i < usersIds.length;i++){
            stringa += "," + usersIds[i];
        }
        return stringa+";";
    }
    */

    //getters
    public String getBranoTag() {
        return this.branoTag;
    }

    public String getUserIDRecord() {
        return this.userID;
    }
    
    //comparing
    public int compareTo(UserJudgement record) {
        return this.branoTag.compareTo(record.getBranoTag());
    }
    
    
}
