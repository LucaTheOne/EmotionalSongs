/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Megaport
 */
public class dataSetEmozioni {
    ArrayList<DatiEmozioniBrano> dataSetEmozioni = new ArrayList<>();
    
    public void importaDataSetEmozioni() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(Utilities.pathToPlaylistDati));
        int counter = 0;
        String StringaCorrente = "";
        String[] StringaCorrenteSplitted = new String[1];
        DatiEmozioniBrano dati = null;
        while((StringaCorrente = reader.readLine()) != null){
            switch (counter) {
                case 0:
                    dati = new DatiEmozioniBrano(SearchEngine.cercaBranoEsatto(StringaCorrente, EMOTIONALSONGS.REPOSITORY));
                    counter++;
                    break;
                case 1:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.AMAZEMENT.importaVoti(StringaCorrenteSplitted[2] );
                    dati.AMAZEMENT.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                case 2:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.SOLEMNITY.importaVoti(StringaCorrenteSplitted[2] );
                    dati.SOLEMNITY.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                    break;
                case 3:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.TENDERNESS.importaVoti(StringaCorrenteSplitted[2]);
                    dati.TENDERNESS.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                    break;
                case 4:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.NOSTALGIA.importaVoti(StringaCorrenteSplitted[2] );
                    dati.NOSTALGIA.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                    break;
                case 5:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.CALMNESS.importaVoti(StringaCorrenteSplitted[2] );
                    dati.CALMNESS.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                    break;
                case 6:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.POWER.importaVoti(StringaCorrenteSplitted[2] );
                    dati.POWER.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                    break;
                case 7:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.JOY.importaVoti(StringaCorrenteSplitted[2] );
                    dati.JOY.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                    break;
                case 8:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
                    dati.TENSION.importaVoti(StringaCorrenteSplitted[2] );
                    dati.TENSION.importaCommenti(StringaCorrenteSplitted[3]);
                    counter++;
                    break;
                case 9:
                    StringaCorrenteSplitted = StringaCorrente.split(";");
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
        reader.close();
    }
    
    public void esportaDataSetEmozioni(){
        //implementare
    }
}
