
package emotionalsongs;

/**
 * La classe importa le emozioni per ogni brani.
 * @author 
 */
public class Record {

    Emozioni emotions;
    DataBaseUsers userDatabase = EMOTIONALSONGS.userDataBase;
    
    private String branoTag;
    
    private String[] usersIds;
    
    
    //costruttori
    
    public Record(String fileLine){
        
        String[] lineSpliltted = fileLine.split(";");
        
        branoTag = lineSpliltted[0];
        usersIds = toUtenteArray(lineSpliltted[1]);
        
        emotions.AMAZEMENT.setMarks(lineSpliltted[2]); emotions.AMAZEMENT.setNotes(lineSpliltted[3]);
        emotions.SOLEMNITY.setMarks(lineSpliltted[4]); emotions.SOLEMNITY.setNotes(lineSpliltted[5]);
        emotions.TENDERNESS.setMarks(lineSpliltted[6]); emotions.TENDERNESS.setNotes(lineSpliltted[7]);
        emotions.NOSTALGIA.setMarks(lineSpliltted[8]); emotions.NOSTALGIA.setNotes(lineSpliltted[9]);
        emotions.CALMNESS.setMarks(lineSpliltted[10]); emotions.CALMNESS.setNotes(lineSpliltted[11]);
        emotions.POWER.setMarks(lineSpliltted[12]); emotions.POWER.setNotes(lineSpliltted[13]);
        emotions.JOY.setMarks(lineSpliltted[14]); emotions.JOY.setNotes(lineSpliltted[15]);
        emotions.TENSION.setMarks(lineSpliltted[16]); emotions.TENSION.setNotes(lineSpliltted[17]);
        emotions.SADNESS.setMarks(lineSpliltted[18]); emotions.SADNESS.setNotes(lineSpliltted[19]);     
    }

    public Record(String branoTag, String[] usersIds, int[] amazementMarks, String[] amazementNotes, int[] solemnityMarks, String[] solemnityNotes, int[] tendernessMarks, String[] tendernessNotes, int[] nostalgiaMarks, String[] nostalgiaNotes, int[] calmnessMarks, String[] calmnessNotes, int[] powerMarks, String[] powerNotes, int[] joyMarks, String[] joyNotes, int[] tensionMarks, String[] tensionNotes, int[] sadnessMarks, String[] sadnessNotes) {
        this.branoTag = branoTag;
        this.usersIds = usersIds;
        this.emotions.AMAZEMENT.setMarks(amazementMarks); this.emotions.AMAZEMENT.setNotes(amazementNotes);
        this.emotions.SOLEMNITY.setMarks(solemnityMarks); this.emotions.SOLEMNITY.setNotes(solemnityNotes);
        this.emotions.TENDERNESS.setMarks(tendernessMarks); this.emotions.TENDERNESS.setNotes(tendernessNotes);
        this.emotions.NOSTALGIA.setMarks(nostalgiaMarks); this.emotions.NOSTALGIA.setNotes(nostalgiaNotes);
        this.emotions.CALMNESS.setMarks(calmnessMarks); this.emotions.CALMNESS.setNotes(calmnessNotes);
        this.emotions.POWER.setMarks(powerMarks); this.emotions.POWER.setNotes(powerNotes);
        this.emotions.JOY.setMarks(joyMarks); this.emotions.JOY.setNotes(joyNotes);
        this.emotions.TENSION.setMarks(tensionMarks); this.emotions.TENSION.setNotes(tensionNotes);
        this.emotions.SADNESS.setMarks(sadnessMarks); this.emotions.SADNESS.setNotes(sadnessNotes);        
    }

    /**
     * Il metodo crea una stringa con il titolo del brano, autore, anno e tag,
     * e una riga nuova con ogni emozione, voto e commento. 
     * @return una stringa con il brano, emozioni e commenti.
     */
    public String stringaRecord() {
        return branoTag +";"+
                stringaUtenti()+
                stringaEmozione(emotions.AMAZEMENT)+
                stringaEmozione(emotions.SOLEMNITY)+
                stringaEmozione(emotions.TENDERNESS)+
                stringaEmozione(emotions.NOSTALGIA)+
                stringaEmozione(emotions.CALMNESS)+
                stringaEmozione(emotions.POWER)+
                stringaEmozione(emotions.JOY)+
                stringaEmozione(emotions.TENSION)+
                stringaEmozione(emotions.SADNESS);
    }
    
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
    
    private String stringaEmozione(Emozioni emotion){
        return stringaVoti(emotion.getMarks()) + stringaCommenti(emotion.getNotes());
    }
    //metodi di uso generale nella classe
    private int[] convertiInArrayInts(String stringa){
        String[] stringSplitted = stringa.split(",");
        int[] arrayInt = new int[stringSplitted.length];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = Integer.parseInt(stringSplitted[i]);
        }
        EngineSorter sorter = new EngineSorter();
        sorter.sortIntArray(arrayInt);
        return arrayInt;
    }
    
    private String[] convertiInArrayStrings(String stringa){
        String[] stringSplitted = stringa.split("<>");
        String[] arrayString = new String[stringSplitted.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = stringSplitted[i];
        }
        return arrayString;
    }
    
    private String[] toUtenteArray(String userList){
        String[] arrayUsers = userList.split(",");
        EngineSorter sorter = new EngineSorter();
        return arrayUsers;
    }

    private String stringaVoti(int[] marks) {
        String stringa = String.valueOf(marks[0]);
        for (int i = 1; i < usersIds.length;i++){
            stringa += "," + String.valueOf(marks[i]);
        }
        return stringa+";";
    }

    private String stringaCommenti(String[] notes) {
        String stringa = notes[0];
        for (int i = 1; i < usersIds.length;i++){
            stringa += "<>" + notes[i];
        }
        return stringa+";";
    }

    String getTag() {
        return this.branoTag;
    }

    String[] getUsersIds() {
        return this.usersIds;
    }
    
    
}
