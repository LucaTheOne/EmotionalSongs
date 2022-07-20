package emotionalsongs;

import java.io.*;
import java.util.*;

// RIVEDERE L'INTERO CODICE 

class SearchSongBrain{
  List<String[]> resultsList = new ArrayList<String[]>();
  //public static void main(String[] args) {
    //cercaBranoMusicale();
  //}

  /**
  * metodo per avviare la ricerca tramite due possibili metodiche;
  * tramite titolo o tramite autore ed anno, a seconda della scelta
  * Si appoggia ad un altro metodo: SceltaTipoRicerca()
  **/
  public static Brano cercaBranoMusicale() throws FileNotFoundException, IOException{
    return SceltaTipoRicerca();
  }

  /**
  * Questa parte di codice si occupa di selezionare il tipo di ricerca da effettuare.
  * Prevede anche una parte di interazione con l' utente.
  * Sfrutta i servizi offerti dalla classe Scanner e dalle sue istanze
  * per acquisire la scelta fatta dall' utente sottoforma di stringa.
  * Sono implementate anche codici di controllo per assicurarsi che
  * la scelta dell' utente sia attuabile.
  * Per la ricerca effettiva si appoggia ad altri metodi, in base
  * alla scelta dell' utente.
  **/
  static Brano SceltaTipoRicerca() throws FileNotFoundException, IOException{
    //parte di comunicazione all' utente
    System.out.println("Selezionare tra: ");
    System.out.println("-Ricerca tramite Titolo della canzone -> T");
    System.out.println("-Ricerca tramite Autore ed Anno della canzone -> A");
    Brano searchedSong;
    Scanner inputStream = new Scanner(System.in);
    //La scelta dell'utente viene acqusita tramite stream e salvata in una variabile.
    //Tutto quanto viene forzato al upper case cosi da non avere incompatibilità.
    String sceltaRicerca = inputStream.nextLine().toUpperCase();

    //Frazione di codice che controlla se la scelta dell' utente sia lecita
    while(!sceltaRicerca.equals("T") && !sceltaRicerca.equals("A")){
      //se la scelta non è lecita chiede di rifarla
      System.out.println("Scelta non ammessa, selezionare T oppure A");
      sceltaRicerca = inputStream.nextLine().toUpperCase();
    }
    inputStream.close();
    //In base alla scelta dell' utente il software stabilisce quale metodo chiamare
    if (sceltaRicerca.equals("T")) {
      searchedSong = ricercaBranoPerTitolo();
    } else {
      searchedSong = ricercaBranoPerAutoreEAnno();
    }

    return searchedSong;
  }

  /**
  * metodo per cercare i brani che nel titolo presentano una determinata parola o parte di ammessa
  * In questa versione del codice l' indirizzo del file è fissato.
  * Tramite una istanza di scanner si apre uno stream con il file Canzoni.dati.csv e si
  * analizza riga per riga in cerca della parola cercata, previa divisione di quest' ultima in sottostringhe
  * memorizzate in un array così che si possa sfruttarlo per il confronto.
  **/
  static Brano ricercaBranoPerTitolo() throws FileNotFoundException, IOException{

    //Il file può sollevare eccezioni controllate quando non esiste, quindi le tratto esplicitamente
    //try{
      List<String[]> resultsList = new ArrayList<String[]>();
      int indexResult = 1;
      boolean restart = false;
      boolean found = false;//Sfrutto una variabile per memorizzare se la ricerca è andata a buon fine

      //Scanner inputStream = new Scanner(new File("Canzoni.dati.csv"));//Apro uno stream con il file delle canzoni
      Scanner inputStream = new Scanner(new File("/Users/big/Documents/GitHub/EMOTIONALSONGS/data/Canzoni.dati.txt"));
      inputStream.useDelimiter("\n");//Stabilisco che le stringhe devono essere divise in base ai ritorni a capo e non più agli spazi

      do {//fai e ripeti qualora restart = true
        //chiedo all' utente di inserire la parola da cercare nei titoli
        System.out.println("Ricerca tramite brani; Inserisca il brano da cercare:");
        //Tramite stream salvo la parola dell' utente in una variabile
        String titoloBrano = (new Scanner(System.in)).nextLine();

        System.out.println("Risultati Ricerca:");

        while(inputStream.hasNext()){//fintanto che ci sono linee nel file

          String line = inputStream.next();//prendo l' intera linea
          String[] splittedLine = line.split("<SEP>");//Divido la line in stringhe divise da <SEP> e le salvo in un array

          if (splittedLine[3].toUpperCase().contains(titoloBrano.toUpperCase())) {//se il primo elemento dell' array (cioè il titolo) coincide con la parola cercata
            //Stampa su terminale del risultato
            System.out.println((indexResult+1) +"." + splittedLine[3].toUpperCase());
            System.out.println("   " + "Autore/i: " + splittedLine[2]);
            System.out.println("   " + "Data di rilascio: " + splittedLine[0]);
            //lo salvo in un array
            String[] result = {splittedLine[3],splittedLine[2],splittedLine[0],splittedLine[1]};//{titolo,autore, anno}
            //e lo aggiungo alla lista dei risultati della ricerca
            resultsList.add(result);
            found = true;//Segnalo che ci sono risultati nella ricerca e li stampo
            indexResult++;
          }
        }

        if (found == false){//se non ci sono stati risultati nella ricerca
          System.out.println("Nessun brano tra quelli disponibili presenta la parola cercata");
          System.out.println("Vuole effettuare un altra ricerca per brano? s/n");
          boolean validated = false;//sfrutto la variabile boolean validated per determinare se la scelta utente è valida
          do {//ripeti fintanto che l' utente non effettua una scelta valida
            String sn = new Scanner(System.in).nextLine();
            if (sn.equalsIgnoreCase("n")) {
              validated = true;
              return null;//se l' utente cambia idea ritorna null
            } else if(sn.equalsIgnoreCase("s")){
              validated = true;
              restart = true;//l' utente decide di effettuare un altra ricerca per brani
            } else {
              System.out.println("Scelta non valida!\n"+"Vuole effettuare un altra ricerca per brano?\n"+ "digiti s se si, digiti n se no: ");
            }
          } while (!validated);
        }
      } while (restart);

      System.out.println("digiti il numero associato al brano che vuole selezionare, " + "digiti 0 per aggiungerne nessuno di essi: ");
      int indexOfChosedSong = Integer.parseInt(new Scanner(System.in).nextLine());
      while (indexOfChosedSong>resultsList.size()) {
        System.out.println("Scelta non valida, la ricerca ha prodotto solo " + resultsList.size() + " risultati;");
        System.out.println("digiti il numero associato al brano che vuole aggiungere alla playlist");
        indexOfChosedSong = Integer.parseInt(new Scanner(System.in).nextLine());
      }

      if (indexOfChosedSong == 0) {
        System.out.println("Scelta effettuata: nessuna canzone");
        return null;
      }

      String[]choosedSong = resultsList.get(indexOfChosedSong-1);
      inputStream.close();
      Brano choosedOne = new Brano(choosedSong[0], choosedSong[1], choosedSong[2],choosedSong[3]);
      return choosedOne;
    //} catch (FileNotFoundException e){
      //e.printStackTrace();
    //}
  }

  /**
  * metodo per cercare i brani su base di autore ed anno.
  * In questa versione del codice l' indirizzo del file è fissato.
  * Tramite una istanza di scanner si apre uno stream con il file Canzoni.dati.csv e si
  * analizza riga per riga in cerca di una stringa che presenti sia l' autore che l' anno cercati,
  * previa divisione di quest' ultima in sottostringhe
  * memorizzate in un array così che si possa sfruttarlo per il confronto.
  **/
  static Brano ricercaBranoPerAutoreEAnno() throws FileNotFoundException, IOException{

    //try{
      List<String[]> resultsList = new ArrayList<String[]>();
      int indexResult = 1;
      boolean restart = false;
      boolean found = false;//Sfrutto una variabile per memorizzare se la ricerca è andata a buon fine

      //Scanner inputStream = new Scanner(new File("Canzoni.dati.csv"));//Apro uno stream con il file delle canzoni
      Scanner inputStream = new Scanner(new File("/Users/big/Documents/GitHub/EMOTIONALSONGS/data/Canzoni.dati.txt"));
      inputStream.useDelimiter("\n");//Stabilisco che le stringhe devono essere divise in base ai ritorni a capo e non più agli spazi

      do {//fai e ripeti qualora restart = true
        //chiedo all' utente di inserire Autore ed anno da cercare
        System.out.println("Ricerca tramite Autore ed anno;\n" + "Inserisca rispettivamente Autore ed anno, divisi da _ :");
        String autoreAnno = (new Scanner(System.in)).nextLine();
        //Divido autore ed anno e li salvo in due posizioni differenti di un array
        String[] AutoreAnno = autoreAnno.split("_");//[autore,anno]

        System.out.println("Risultati ricerca: ");

        while(inputStream.hasNext()){//fintanto che ci sono linee nel file
          String linea = inputStream.next();
          String[] splittedLine = linea.split("<SEP>");
          //se l' autore della canzone salvato in posizione 1 dell' array coincide con quello inserito dall' utente && L' anno salvato in posizione 3 dell' array contiene quello selezionato dall' utente
          if (splittedLine[2].toUpperCase().contains(AutoreAnno[0].toUpperCase()) && splittedLine[0].contains(AutoreAnno[1]) ) {
            System.out.println(indexResult + ". " + splittedLine[3].toUpperCase());
            System.out.println("  " + "Autore/i: " + splittedLine[2]);
            System.out.println("  " + "Data di rilascio: " + splittedLine[0]);
            String[] result = {splittedLine[3],splittedLine[2],splittedLine[0],splittedLine[1]};//{titolo,autore, anno,tag}
            //e lo aggiungo alla lista dei risultati della ricerca
            resultsList.add(result);
            found = true;//Segnalo che ci sono risultati nella ricerca e li stampo
            indexResult++;
          }
        }

        if (found == false){//se non ci sono stati risultati nella ricerca
          System.out.println("Nessun brano tra quelli disponibili presenta autore ed anno cercati");
          System.out.println("Vuole effettuare un altra ricerca per autore ed anno? s/n");
          boolean validated = false;//sfrutto la variabile boolean validated per determinare se la scelta utente è valida
          do {//ripeti fintanto che l' utente non effettua una scelta valida
            String sn = new Scanner(System.in).nextLine();
            if (sn.equalsIgnoreCase("n")) {
              validated = true;
              return null;//se l' utente cambia idea ritorna null
            } else if(sn.equalsIgnoreCase("s")){
              validated = true;
              restart = true;//l' utente decide di effettuare un altra ricerca per brani
            } else {
              System.out.println("Scelta non valida!\n"+"Vuole effettuare un altra ricerca per brano?\n"+ "digiti s se si, digiti n se no: ");
            }
          } while (!validated);
        }
      } while (restart);

      System.out.println("digiti il numero associato al brano che vuole selezionare, " + "digiti 0 per aggiungerne nessuno di essi: ");
      int indexOfChosedSong = Integer.parseInt(new Scanner(System.in).nextLine());
      while (indexOfChosedSong>resultsList.size()) {
        System.out.println("Scelta non valida, la ricerca ha prodotto solo " + resultsList.size() + " risultati;");
        System.out.println("digiti il numero associato al brano che vuole aggiungere alla playlist");
        indexOfChosedSong = Integer.parseInt(new Scanner(System.in).nextLine());
      }

      if (indexOfChosedSong == 0) {
        System.out.println("Scelta effettuata: nessuna canzone");
        return null;
      }

      String[]choosedSong = resultsList.get(indexOfChosedSong-1);
      Brano choosedOne = new Brano(choosedSong[0], choosedSong[1], choosedSong[2], choosedSong[3]);
      return choosedOne;
    //} catch (FileNotFoundException e){
      //e.printStackTrace();
    //}
  }
}
