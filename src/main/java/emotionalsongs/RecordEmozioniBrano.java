
package emotionalsongs;

/**
 * La classe importa le emozioni per ogni brani.
 * @author 
 */
public class RecordEmozioniBrano {

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
            
    public RecordEmozioniBrano(String linea) {
        EngineSearcher searcher = new EngineSearcher();
        String[] lineaSplitted = linea.split(";");
        
        //importa da file il brano
        brano = searcher.cercaBranoTag(EMOTIONALSONGS.REPOSITORY,lineaSplitted[0]);
        
        //importa da file gli utenti
        arrayUtentiVotato = searcher.getUsersFromId(EMOTIONALSONGS.userDataBase,lineaSplitted[1]);
        
        //importa da file Amazement del brano
        votiAmazement = convertiInArrayInts(lineaSplitted[2]);
        commentiAmazement = convertiInArrayStrings(lineaSplitted[3]);
        
        //importa da file Solemnity del brano
        votiSolemnity = convertiInArrayInts(lineaSplitted[4]);
        commentiSolemnity = convertiInArrayStrings(lineaSplitted[5]);
        
        //importa da file Tenderness del brano
        votiTenderness = convertiInArrayInts(lineaSplitted[6]);
        commentiTenderness = convertiInArrayStrings(lineaSplitted[7]);
        
        //importa da file Nostalgia del brano
        votiNostalgia = convertiInArrayInts(lineaSplitted[8]);
        commentiNostalgia = convertiInArrayStrings(lineaSplitted[9]);
        
        //importa da file Calmness del brano
        votiCalmness = convertiInArrayInts(lineaSplitted[10]);
        commentiCalmness = convertiInArrayStrings(lineaSplitted[11]);
        
        //importa da file Power del brano
        votiPower = convertiInArrayInts(lineaSplitted[12]);
        commentiPower = convertiInArrayStrings(lineaSplitted[13]);
        
        //importa da file Joy del brano
        votiJoy = convertiInArrayInts(lineaSplitted[14]);
        commentiJoy = convertiInArrayStrings(lineaSplitted[15]);
        
        //importa da file Tension del brano
        votiTension = convertiInArrayInts(lineaSplitted[16]);
        commentiTension = convertiInArrayStrings(lineaSplitted[17]);
        
        //importa da file Sadness del brano
        votiSadness = convertiInArrayInts(lineaSplitted[18]);
        commentiSadness = convertiInArrayStrings(lineaSplitted[19]);
        
    }    
    
    /**
     * Il metodo crea una stringa con il titolo del brano, autore, anno e tag,
     * e una riga nuova con ogni emozione, voto e commento. 
     * @return una stringa con il brano, emozioni e commenti.
     */
    
    public String stringaEmozioniBrano(){
        return brano.getTag()+";"+
                stringaUtenti()+
                stringaAmazement()+
                stringaSolemnity()+
                stringaTenderness()+
                stringaNostalgia()+
                stringaCalmness()+
                stringaPower()+
                stringaJoy()+
                stringaTension()+
                stringaSadness();
    }
    
    //Utente
    public void aggiornaListaUtentiVotato(Utente user){
        Utente[] newArray = new Utente[arrayUtentiVotato.length+1];
        for(int i = 0;i<arrayUtentiVotato.length;i++){
           newArray[i] = arrayUtentiVotato[i];
        }
        newArray[newArray.length-1] = user;
        arrayUtentiVotato=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.sortUserArrayById(newArray);
    }
    
    private String stringaUtenti(){
        String stringa = "";
        for (int i = 0; i < arrayUtentiVotato.length;i++){
            stringa += i!=arrayUtentiVotato.length-1 ? stringa + arrayUtentiVotato[i].getUserId()+",": stringa + arrayUtentiVotato[i].getUserId()+ ";" ;
        }
        return stringa;
    }
    
    //Amazement
    private String stringaAmazement(){
        return stringaVotiAmazement()+stringaCommentiAmazement();
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
    
    public void aggiornaAmazement(int voto){
        int[] newArray = new int[votiAmazement.length+1];
        for(int i = 0;i<votiAmazement.length;i++){
           newArray[i] = votiAmazement[i];
        }
        newArray[newArray.length-1] = voto;
        votiAmazement=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaAmazement(int voto,String nota){
        aggiornaAmazement(voto);
        String[] newArray = new String[commentiAmazement.length+1];
        for(int i = 0;i<commentiAmazement.length;i++){
           newArray[i] = commentiAmazement[i];
        }
        newArray[newArray.length-1] = nota;
        commentiAmazement=newArray;
    }
    
    //Solemnity
    private String stringaSolemnity(){
        return stringaVotiSolemnity()+stringaCommentiSolemnity();
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
    
    public void aggiornaSolemnity(int voto){
        int[] newArray = new int[votiSolemnity.length+1];
        for(int i = 0;i<votiSolemnity.length;i++){
           newArray[i] = votiSolemnity[i];
        }
        newArray[newArray.length-1] = voto;
        votiSolemnity=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaSolemnity(int voto,String nota){
        aggiornaSolemnity(voto);
        String[] newArray = new String[commentiSolemnity.length+1];
        for(int i = 0;i<commentiSolemnity.length;i++){
           newArray[i] = commentiSolemnity[i];
        }
        newArray[newArray.length-1] = nota;
        commentiSolemnity=newArray;
    }
    
    //Tenderness
    private String stringaTenderness(){
        return stringaVotiTenderness()+stringaCommentiTenderness();
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
    
    public void aggiornaTenderness(int voto){
        int[] newArray = new int[votiTenderness.length+1];
        for(int i = 0;i<votiTenderness.length;i++){
           newArray[i] = votiTenderness[i];
        }
        newArray[newArray.length-1] = voto;
        votiTenderness=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaTenderness(int voto,String nota){
        aggiornaTenderness(voto);
        String[] newArray = new String[commentiTenderness.length+1];
        for(int i = 0;i<commentiTenderness.length;i++){
           newArray[i] = commentiTenderness[i];
        }
        newArray[newArray.length-1] = nota;
        commentiTenderness=newArray;
    }
    
    //Nostalgia
    private String stringaNostalgia(){
        return stringaVotiNostalgia()+stringaCommentiNostalgia();
    }
    
    private String stringaVotiNostalgia(){
        String stringa = "";
        for (int i = 0; i < votiNostalgia.length;i++){
            stringa += i!=votiNostalgia.length-1 ? stringa + votiNostalgia[i]+",": stringa + votiNostalgia[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiNostalgia(){
        String stringa = "";
        for (int i = 0; i < commentiNostalgia.length;i++){
            stringa += i!=commentiNostalgia.length-1 ? stringa + commentiNostalgia[i]+",": stringa + commentiNostalgia[i]+ ";" ;
        }
        return stringa;
    }
    
    public void aggiornaNostalgia(int voto){
        int[] newArray = new int[votiNostalgia.length+1];
        for(int i = 0;i<votiNostalgia.length;i++){
           newArray[i] = votiNostalgia[i];
        }
        newArray[newArray.length-1] = voto;
        votiNostalgia=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaNostalgia(int voto,String nota){
        aggiornaNostalgia(voto);
        String[] newArray = new String[commentiNostalgia.length+1];
        for(int i = 0;i<commentiNostalgia.length;i++){
           newArray[i] = commentiNostalgia[i];
        }
        newArray[newArray.length-1] = nota;
        commentiNostalgia=newArray;
    }
    
    //Calmness
    private String stringaCalmness(){
        return stringaVotiCalmness()+stringaCommentiCalmness();
    }
    
    private String stringaVotiCalmness(){
        String stringa = "";
        for (int i = 0; i < votiCalmness.length;i++){
            stringa += i!=votiCalmness.length-1 ? stringa + votiCalmness[i]+",": stringa + votiCalmness[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiCalmness(){
        String stringa = "";
        for (int i = 0; i < commentiCalmness.length;i++){
            stringa += i!=commentiCalmness.length-1 ? stringa + commentiCalmness[i]+",": stringa + commentiCalmness[i]+ ";" ;
        }
        return stringa;
    }
    
    public void aggiornaCalmness(int voto){
        int[] newArray = new int[votiCalmness.length+1];
        for(int i = 0;i<votiCalmness.length;i++){
           newArray[i] = votiCalmness[i];
        }
        newArray[newArray.length-1] = voto;
        votiCalmness=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaCalmness(int voto,String nota){
        aggiornaCalmness(voto);
        String[] newArray = new String[commentiCalmness.length+1];
        for(int i = 0;i<commentiCalmness.length;i++){
           newArray[i] = commentiCalmness[i];
        }
        newArray[newArray.length-1] = nota;
        commentiCalmness=newArray;
    }
    
    //Power
    private String stringaPower(){
        return stringaVotiPower()+stringaCommentiPower();
    }
    
    private String stringaVotiPower(){
        String stringa = "";
        for (int i = 0; i < votiPower.length;i++){
            stringa += i!=votiPower.length-1 ? stringa + votiPower[i]+",": stringa + votiPower[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiPower(){
        String stringa = "";
        for (int i = 0; i < commentiPower.length;i++){
            stringa += i!=commentiPower.length-1 ? stringa + commentiPower[i]+",": stringa + commentiPower[i]+ ";" ;
        }
        return stringa;
    }
    
    public void aggiornaPower(int voto){
        int[] newArray = new int[votiPower.length+1];
        for(int i = 0;i<votiPower.length;i++){
           newArray[i] = votiPower[i];
        }
        newArray[newArray.length-1] = voto;
        votiPower=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaPower(int voto,String nota){
        aggiornaPower(voto);
        String[] newArray = new String[commentiPower.length+1];
        for(int i = 0;i<commentiPower.length;i++){
           newArray[i] = commentiPower[i];
        }
        newArray[newArray.length-1] = nota;
        commentiPower=newArray;
    }
    
    //Joy
    private String stringaJoy(){
        return stringaVotiJoy()+stringaCommentiJoy();
    }
    
    private String stringaVotiJoy(){
        String stringa = "";
        for (int i = 0; i < votiJoy.length;i++){
            stringa += i!=votiJoy.length-1 ? stringa + votiJoy[i]+",": stringa + votiJoy[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiJoy(){
        String stringa = "";
        for (int i = 0; i < commentiJoy.length;i++){
            stringa += i!=commentiJoy.length-1 ? stringa + commentiJoy[i]+",": stringa + commentiJoy[i]+ ";" ;
        }
        return stringa;
    }
    
    public void aggiornaJoy(int voto){
        int[] newArray = new int[votiJoy.length+1];
        for(int i = 0;i<votiJoy.length;i++){
           newArray[i] = votiJoy[i];
        }
        newArray[newArray.length-1] = voto;
        votiJoy=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaJoy(int voto,String nota){
        aggiornaJoy(voto);
        String[] newArray = new String[commentiJoy.length+1];
        for(int i = 0;i<commentiJoy.length;i++){
           newArray[i] = commentiJoy[i];
        }
        newArray[newArray.length-1] = nota;
        commentiJoy=newArray;
    }
    
    //Tension
    private String stringaTension(){
        return stringaVotiTension()+stringaCommentiTension();
    }
    
    private String stringaVotiTension(){
        String stringa = "";
        for (int i = 0; i < votiTension.length;i++){
            stringa += i!=votiTension.length-1 ? stringa + votiTension[i]+",": stringa + votiTension[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiTension(){
        String stringa = "";
        for (int i = 0; i < commentiTension.length;i++){
            stringa += i!=commentiTension.length-1 ? stringa + commentiTension[i]+",": stringa + commentiTension[i]+ ";" ;
        }
        return stringa;
    }
    
    public void aggiornaTension(int voto){
        int[] newArray = new int[votiTension.length+1];
        for(int i = 0;i<votiTension.length;i++){
           newArray[i] = votiTension[i];
        }
        newArray[newArray.length-1] = voto;
        votiTension=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaTension(int voto,String nota){
        aggiornaTension(voto);
        String[] newArray = new String[commentiTension.length+1];
        for(int i = 0;i<commentiTension.length;i++){
           newArray[i] = commentiTension[i];
        }
        newArray[newArray.length-1] = nota;
        commentiTension=newArray;
    }
    
    //Sadness
    private String stringaSadness(){
        return stringaVotiSadness()+stringaCommentiSadness();
    }
    
    private String stringaVotiSadness(){
        String stringa = "";
        for (int i = 0; i < votiSadness.length;i++){
            stringa += i!=votiSadness.length-1 ? stringa + votiSadness[i]+",": stringa + votiSadness[i]+ ";" ;
        }
        return stringa;
    }
    
    private String stringaCommentiSadness(){
        String stringa = "";
        for (int i = 0; i < commentiSadness.length;i++){
            stringa += i!=commentiSadness.length-1 ? stringa + commentiSadness[i]+",": stringa + commentiSadness[i]+ ";" ;
        }
        return stringa;
    }
    
    public void aggiornaSadness(int voto){
        int[] newArray = new int[votiSadness.length+1];
        for(int i = 0;i<votiSadness.length;i++){
           newArray[i] = votiSadness[i];
        }
        newArray[newArray.length-1] = voto;
        votiSadness=newArray;
        EngineSorter sorter = new EngineSorter();
        sorter.riordinaArrayInt(newArray);
    }
    
    public void aggiornaSadness(int voto,String nota){
        aggiornaSadness(voto);
        String[] newArray = new String[commentiSadness.length+1];
        for(int i = 0;i<commentiSadness.length;i++){
           newArray[i] = commentiSadness[i];
        }
        newArray[newArray.length-1] = nota;
        commentiSadness=newArray;
    }
    
    //metodi di uso generale nella classe
    private int[] convertiInArrayInts(String stringa){
        String[] stringSplitted = stringa.split(",");
        int[] arrayInt = new int[stringSplitted.length];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = Integer.parseInt(stringSplitted[i]);
        }
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
}
