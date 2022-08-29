
package emotionalsongs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe DataSetEmozioni si occupa di importare ed esportare i dati delle 
 * emozioni.
 * @author Bolelli Luca
 */
public class DataSetEmozioni {
    
    
    private ArrayList<DatiEmozioniBrano> dataSetEmozioni = new ArrayList<>();
    
    /**
     * Crea un oggetto che importa i dati delle emozioni.
     */
    public DataSetEmozioni() {
        try {
            importaDataSetEmozioni();    
        } catch (IOException e) {
            e.getMessage();
        }
        

    }
    
   
    /**
     * Il metodo crea un buffer per leggere dal file i voti e commenti assegnati ad ogni emozione,
     * dopidichè verrno salvati in un array di stringhe.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void importaDataSetEmozioni() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(Utilities.pathToPlaylistDati));
        String stringaCorrente = "";
        if((stringaCorrente = reader.readLine())==null) {
            //System.out.println("DataSet vuoto!");
            reader.close();
            return;
        }
        else{
           int counter = 0;
        
            String[] StringaCorrenteSplitted = new String[1];
            DatiEmozioniBrano dati = null;
            
            while((stringaCorrente = reader.readLine()) != null){
                switch (counter) {
                    case 0:
                        dati = new DatiEmozioniBrano(EngineSearch.cercaBranoEsatto(stringaCorrente, EMOTIONALSONGS.REPOSITORY));
                        counter++;
                        break;
                    case 1:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.AMAZEMENT.importaVoti(StringaCorrenteSplitted[2] );
                        dati.AMAZEMENT.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 2:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.SOLEMNITY.importaVoti(StringaCorrenteSplitted[2] );
                        dati.SOLEMNITY.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 3:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.TENDERNESS.importaVoti(StringaCorrenteSplitted[2]);
                        dati.TENDERNESS.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 4:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.NOSTALGIA.importaVoti(StringaCorrenteSplitted[2] );
                        dati.NOSTALGIA.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 5:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.CALMNESS.importaVoti(StringaCorrenteSplitted[2] );
                        dati.CALMNESS.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 6:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.POWER.importaVoti(StringaCorrenteSplitted[2] );
                        dati.POWER.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 7:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.JOY.importaVoti(StringaCorrenteSplitted[2] );
                        dati.JOY.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 8:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.TENSION.importaVoti(StringaCorrenteSplitted[2] );
                        dati.TENSION.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;
                    case 9:
                        StringaCorrenteSplitted = stringaCorrente.split(";");
                        dati.SADNESS.importaVoti(StringaCorrenteSplitted[2] );
                        dati.SADNESS.importaCommenti(StringaCorrenteSplitted[3]);
                        counter++;
                        break;    
                    default:
                        dataSetEmozioni.add(dati);
                        counter = 0;
                    break;
                }  
            }
        } 
        reader.close();
    }
    
    /**
     * Il metodo crea un buffer per esportare i dati delle emozioni.
     * @throws IOException 
     */
    public void esportaDataSetEmozioni() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Utilities.pathToEmozioniDati)));
        for(int i = 0; i<dataSetEmozioni.size();i++){
            writer.write(dataSetEmozioni.get(i).stringaEmozioniBrano());
        }
        writer.flush();
    }
}
