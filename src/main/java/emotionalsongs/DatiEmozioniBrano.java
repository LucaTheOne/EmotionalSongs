
package emotionalsongs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 * @author 
 */
public class DatiEmozioniBrano {
    
    Brano branoCorrelatoAlleEmozioni;
    
    Emozioni AMAZEMENT = Emozioni.AMAZEMENT;
    Emozioni SOLEMNITY = Emozioni.SOLEMNITY;
    Emozioni TENDERNESS = Emozioni.TENDERNESS;
    Emozioni NOSTALGIA = Emozioni.NOSTALGIA;
    Emozioni CALMNESS = Emozioni.CALMNESS;
    Emozioni POWER = Emozioni.POWER;
    Emozioni JOY = Emozioni.JOY;
    Emozioni TENSION = Emozioni.TENSION;
    Emozioni SADNESS = Emozioni.SADNESS;

    public DatiEmozioniBrano(Brano brano) {
        branoCorrelatoAlleEmozioni = brano;
    }
    
    public String stringaEmozioniBrano(){
        String stringaDaStampare = "";
        stringaDaStampare += branoCorrelatoAlleEmozioni.getTitle() + "," + branoCorrelatoAlleEmozioni.getAuthor() + "," + branoCorrelatoAlleEmozioni.getYear() + "," + branoCorrelatoAlleEmozioni.getTag() + "\r";
        stringaDaStampare += "  " +  AMAZEMENT.getNomeEmozione() + ";" + AMAZEMENT.getNumeroVoti() + ";" + AMAZEMENT.stringaVoti() + AMAZEMENT.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  SOLEMNITY.getNomeEmozione() + ";" + SOLEMNITY.getNumeroVoti() + ";" + SOLEMNITY.stringaVoti() + SOLEMNITY.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  TENDERNESS.getNomeEmozione() + ";" + TENDERNESS.getNumeroVoti() + ";" + TENDERNESS.stringaVoti() + TENDERNESS.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  NOSTALGIA.getNomeEmozione() + ";" + NOSTALGIA.getNumeroVoti() + ";" + NOSTALGIA.stringaVoti() + NOSTALGIA.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  CALMNESS.getNomeEmozione() + ";" + CALMNESS.getNumeroVoti() + ";" + CALMNESS.stringaVoti() + CALMNESS.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  POWER.getNomeEmozione() + ";" + POWER.getNumeroVoti() + ";" + POWER.stringaVoti() + POWER.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  JOY.getNomeEmozione() + ";" + JOY.getNumeroVoti() + ";" + JOY.stringaVoti() + JOY.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  TENSION.getNomeEmozione() + ";" + TENSION.getNumeroVoti() + ";" + TENSION.stringaVoti() + TENSION.stringaCommenti() + "\r";
        stringaDaStampare += "  " +  SADNESS.getNomeEmozione() + ";" + SADNESS.getNumeroVoti() + ";" + SADNESS.stringaVoti() + SADNESS.stringaCommenti() + "\r";
        stringaDaStampare += Utilities.divisioreFinale;
        return stringaDaStampare;
    }
}
