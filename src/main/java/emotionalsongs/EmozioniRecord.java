
package emotionalsongs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * La classe importa le emozioni per ogni brani.
 * @author 
 */
public class EmozioniRecord {

    Emozioni emotions;
    private Brano brano;
    
    Utente[] arrayUtentiVotato;
    
    int[] votiAmazement;
    String[] commentiAmazement;
    
    int[] votiSolemnity;
    String[] commentiSolemnity;
    
    int[] votiTenderness;
    String[] commentiTenderness;
    
    int[] votiNostalgia;
    String[] commentiNostalgia;
    
    int[] votiCalmness;
    String[] commentiCalmness;
    
    int[] votiPower;
    String[] commentiPower;
    
    int[] votiJoy;
    String[] commentiJoy;
    
    int[] votiTension;
    String[] commentiTension;
    
    int[] votiSadness;
    String[] commentiSadness;
            
    public EmozioniRecord(Brano brano) {
       this.brano = brano;
    }
    
    private void importaDati(){
        
    }
    /**
     * Il metodo crea una stringa con il titolo del brano, autore, anno e tag,
     * e una riga nuova con ogni emozione, voto e commento. 
     * @return una stringa con il brano, emozioni e commenti.
     */
    public String stringaEmozioniBrano(){
        
    }
    
    void aggiungiUtenteCheHaVotatoIlBrano(Utente user){
        Utente[] newArray = new Utente[arrayUtentiVotato.length+1];
        for(int i = 0;i<arrayUtentiVotato.length;i++){
           newArray[i] = arrayUtentiVotato[i];
        }
        newArray[newArray.length-1] = user;
        arrayUtentiVotato=newArray;
        EngineSort sorter = new EngineSort();
        sorter.riordinaArrayUtenti(newArray);
    }
    
    private String stringaUtenti(){
        String stringa = "";
        for (int i = 0; i < arrayUtentiVotato.length;i++){
            stringa += i!=arrayUtentiVotato.length-1 ? stringa + arrayUtentiVotato[i].getUserId()+"<SEP>": stringa + arrayUtentiVotato[i].getUserId()+ ";" ;
        }
        return stringa;
    }
    
    private String stringaVotiAmazement(){
        String stringa = "";
        for (int i = 0; i < votiAmazement.length;i++){
            stringa += i!=votiAmazement.length-1 ? stringa + votiAmazement[i]+",": stringa + votiAmazement[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiAmazement(){
        String stringa = "";
        for (int i = 0; i < commentiAmazement.length;i++){
            stringa += i!=commentiAmazement.length-1 ? stringa + commentiAmazement[i]+",": stringa + commentiAmazement[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaVotiSolemnity(){
        String stringa = "";
        for (int i = 0; i < votiSolemnity.length;i++){
            stringa += i!=votiSolemnity.length-1 ? stringa + votiSolemnity[i]+",": stringa + votiSolemnity[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiSolemnity(){
        String stringa = "";
        for (int i = 0; i < commentiSolemnity.length;i++){
            stringa += i!=commentiSolemnity.length-1 ? stringa + commentiSolemnity[i]+",": stringa + commentiSolemnity[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaVotiTenderness(){
        String stringa = "";
        for (int i = 0; i < votiTenderness.length;i++){
            stringa += i!=votiTenderness.length-1 ? stringa + votiTenderness[i]+",": stringa + votiTenderness[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiTenderness(){
        String stringa = "";
        for (int i = 0; i < commentiTenderness.length;i++){
            stringa += i!=commentiTenderness.length-1 ? stringa + commentiTenderness[i]+",": stringa + commentiTenderness[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaVotiAmazement(){
        String stringa = "";
        for (int i = 0; i < votiAmazement.length;i++){
            stringa += i!=votiAmazement.length-1 ? stringa + votiAmazement[i]+",": stringa + votiAmazement[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiAmazement(){
        String stringa = "";
        for (int i = 0; i < commentiAmazement.length;i++){
            stringa += i!=commentiAmazement.length-1 ? stringa + commentiAmazement[i]+",": stringa + commentiAmazement[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiAmazement(){
        String stringa = "";
        for (int i = 0; i < commentiAmazement.length;i++){
            stringa += i!=commentiAmazement.length-1 ? stringa + commentiAmazement[i]+",": stringa + commentiAmazement[i]+ ";" ;
        }
        return stringa;
    }
}
