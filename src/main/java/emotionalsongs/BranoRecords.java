
package emotionalsongs;

/**
 * La classe importa le emozioni per ogni brani.
 * @author 
 */
public class BranoRecords {

    Emozioni emotions;
    DataBaseUtenti userDatabase = EMOTIONALSONGS.userDataBase;
    
    private String branoTag;
    
    private String[] arrayUtentiVotato;
    
    
    //costruttori

    public BranoRecords(String branoTag){
        this.branoTag = branoTag;
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
    public void aggiornaListaUtentiVotato(Utente user){
        String[] newArray = new String[arrayUtentiVotato.length+1];
        for(int i = 0;i<arrayUtentiVotato.length;i++){
           newArray[i] = arrayUtentiVotato[i];
        }
        newArray[newArray.length-1] = user.getUserId();
        arrayUtentiVotato=newArray;
    }
    
    private String stringaUtenti(){
        String stringa = arrayUtentiVotato[0];
        for (int i = 1; i < arrayUtentiVotato.length;i++){
            stringa += "," + arrayUtentiVotato[i];
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
        String[] stringSplitted = stringa.split("<SEP>");
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
        for (int i = 1; i < arrayUtentiVotato.length;i++){
            stringa += "," + String.valueOf(marks[i]);
        }
        return stringa+";";
    }

    private String stringaCommenti(String[] notes) {
        String stringa = notes[0];
        for (int i = 1; i < arrayUtentiVotato.length;i++){
            stringa += "<SEP>" + notes[i];
        }
        return stringa+";";
    }
}
