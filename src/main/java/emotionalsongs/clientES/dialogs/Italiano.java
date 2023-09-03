/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */

package emotionalsongs.clientES.dialogs;

/**
 * Classe che implementa i dialogi dell' interfaccia in italiano.
 */
public class Italiano extends ClientDialogs{
    //Generici
    @Override
    public String searchBarText(){
        return "";
    }
    
    @Override
    public String availableSongs(){
        return "canzoni disponibili!";
    }
    
    @Override
    public String foundedResults(){
        return "risultati trovati";
    }
    
    @Override
    public String noSongsFounded(){
        return "0 risultati trovati!";
    }
    
    @Override
    public String selectedSongs(){
        return "brani selezionati!";
    }
    
   //BASICS STRUCTURE: EMOZIONI

    @Override
     public String amazementName() {
         return "Meraviglia";
    }

    @Override
    public String amazementExplanation() {
        return "Sensazione di stupore o felicità.";
    }
    
    @Override
    public String solemnityName() {
        return "Solennità";
    }
    
    @Override
    public String solemnityExplanation() {
        return "Sensazione di trascendenza, ispirazione. Brividi.";
    }
    
    @Override
    public String tendernessName() {
        return "Tenerezza";
    }
    
    @Override
    public String tendernessExplanation() {
        return "Sensualità, affetto, sentimento di emotività.";
    }

    @Override
    public String nostalgiaName() {
        return "Nostalgia";
    }
    
    @Override
    public String nostalgiaExplanation() {
        return "Sognante, malinconia, sentimento di emotività.";
    }

    public String calmnessName() {
        return "Pacatezza";
    }

    public String calmnessExplanation() {
        return "Rilassamento, serenità, meditatività.";
    }

    public String powerName() {
        return "Potere";
    }

    public String powerExplanation() {
        return "Sentirsi forti, eroici, trionfanti, energici.";
    }

    public String joyName() {
        return "Gioia";
    }

    public String joyExplanation() {
        return "Sentirsi come danzanti, raggianti, animati, divertiti.";
    }

    public String tensionName() {
        return "Tensione";
    }
  
    public String tensionExplanation() {
        return "Sentire nervosismo, impazienza, irritazione.";
    }

    public String sadnessName() {
        return "Tristezza";
    }

    public String sadnessExplanation() {
        return "Sentirsi depressi, scarichi, dispiaciuti.";
    }
    
    //BASIC STRUCTURE : USER
    
    public String propertyUser(){
        return "Proprietario: ";
    }
    
    public String spaceSuccessfullyGenerated(){
        return "Spazio generato con successo!";
    }
    
    //BASICS DATABASES: DATABASEPLAYLISTS
    
    public String isVoid(){
        return "Il database è vuoto!";
    }
    
    // ENGINES : EngineRegister
    
    public String userCreated(){
        return "Utente creato";
    }
    
    public String userAdded(){
        return "Utente aggiunto";
    }
    

    public String userId() {
        return "ID Utente: ";
    }

    public String userIdNotFound() {
        return "ID Utente inesistente!";
    }

    public String password() {
        return "Password: ";
    }

    public String passwordErr() {
        return "Password errata!";
    }
    
    public String passwordsNotMatching(){
        return "Le due password non coincidono!";
    }

    public String log() {
        return "Accedi";
    }

    public String exit() {
        return "Esci";
    }

    public String name() {
        return "NOME: ";
    }

    public String nameNotValid() {
        return "Nome non valido! ";
    }

    public String surname() {
        return "COGNOME: ";
    }

    public String notValidSurname() {
        return "Cognome non valido!";
    }

    public String address() {
        return "INDIRIZZO: ";
    }

    public String addrNotValid() {
        return "Questo campo non può essere vuoto!";
    }

    public String birthDate() {
        return "DATA DI NASCITA: ";
    }

    public String invalidBirthDate() {
        return "Formato data non valido!";
    }

    public String cf() {
        return "CODICE FISCALE: ";
    }
    
    public String cfIsPresentYet(){
        return "Codice fiscale già presente nel sistema!";
    }


    public String invalidCf() {
        return "Formato data non valido!";
    }

    public String email() {
        return "INDIRIZZO E-MAIL";
    }

    public String emailNotValid() {
        return "Indirizzo e-mail non valido!";
    }
  
    public String useridToUpperCaseWithColon() {
        return "USER ID: ";
    }
    
    public String userIdTaken(){
        return "ID già presente";
    }

    public String userIdNotValid() {
        return "User ID non valido!";
    }

    public String passswordR(){
        return "PASSWORD";
    }
    
    public String passwordCheck() {
        return "VERIFICA PASSWORD";
    }
    
    public String passwordNotValid(){
        return "Password non valida!";
    }
    
    public String registrer() {
        return "Registrati";
    }

    //GUI PLATYLIST CREATION FRAME
    
    public String newPlaylistName() {
        return "Nome della nuova playlist: ";
    }

    public String title() {
        return "Titolo";
    }

    public String author() {
        return "Autore";
    }

    public String year() {
        return "Anno";
    }

    public String creaNuovaPlaylistButton() {
        return "Crea nuova playlist";
    }

    public String abort() {
        return "Annulla";
    }
    
   //GUI MAIN MENU LEFT LOGGED
    
    public String createPlaylist(){
        return "Crea playlist";
    }

    public String profile() {
        return "Profilo";
    }

    public String credits() {
        return "Crediti";
    }

    public String menu() {
        return "Menu";
    }

    public String newPlaylistLabel(){
        return "Nome nuova playlist";
    }
   
    public String createNewPlaylist(){
        return "+ Crea nuova playlist";
    }
    
    public String songData(){
        return "Dati canzone";
    }
    
    public String vote(){
        return "Vota";
    }
    
    public String songsJudgeCommentRequest(){
        return """
               Se vuoi puoi inserire qui una nota o commento riguardo 
               la percezione di questa emozione nell'ascolto del brano.""";
    }

    public String chartMedian() {
        return "Grafico delle mediane dei voti delle emozioni";
    }
    
    public String chartMedium(){
        return "Grafico delle medie aritmetiche dei voti delle emozioni";
    }

    public String chartTrend(){
        return "Grafico dei trend dei voti delle emozioni";
    }
    public String emotions(){
        return "Emozioni";
    }
    
    public String trendsV(){
        return "Trend dei voti";
    }
    
    public String marksMedium(){
        return "Media dei voti";
    }
    
    public String howMuchFeeled(){
        return "Quanto un utente ha percepito l'emozione";
    }
    
    public String numberOfUser(){
        return "Numero di utenti";
    }

     public String reportPaneTitle(){
        return """
               REPORT DATI SUI GIUDIZI DELLE EMOZIONI PERCEPITE  DAGLI UTENTI NELL'ASCOLTO DELLA CANZONE:
               """;
    }
   
    public String votedYet(){
        return "Numero di utenti che hanno espresso il loro parare: ";
    }
    
    public String relativeData(){
        return "DATI RELATIVI AI GIUDIZI DEGLI UTENTI RIGUARDO ALLA PERCEZIONE DELLE RISPETTIVE EMOZIONI: ";
    }
    
    public String aritmeticalMedium(){
        return "   media aritmetica: ";
    }
    
    public String trend(){
        return "   moda: ";
    }
    
    public String median(){
        return "   mediana: ";
    }

    @Override
    public String yearOfPublication() {
        return "Anno di pubblicazione: ";
    }

    @Override
    public String authorCapitalizedWithColon() {
        return "Autore: ";
    }

    @Override
    public String titleCapitalizedWithColon() {
        return "Titolo: ";
    }

    @Override
    public String exportData() {
        return "Esporta dati canzone";
    }

    @Override
    public String close() {
        return "Chiudi";
    }

    @Override
    public String songDataView() {
        return "Vista dati canzoni";
    }

    @Override
    public String myPlaylistsText() {
        return "Le mie playlist";
    }

    @Override
    public String newPlaylistText() {
        return "Nuova playlist";
    }

    @Override
    public String registration() {
        return "Registrazione";
    }

    @Override
    public String fileNotFound() {
        return "File sorgente necessario irraggiungibile: ";
    }

    @Override
    public String ImpossibleToGenerateReport() {
        return "Errore: impossibile generare il report!";
    }

    @Override
    public String OpSucessTerminated() {
        return "Operazione terminata con successo!";
    }

    @Override
    public String maxStringLong255() {
        return "Attenzione! Lunghezza massima dei commenti di 255 caratteri!";
    }

    @Override
    public String notAllVoted() {
        return "Errore: tutte le emozioni devono ricevere un voto!";
    }

    @Override
    public String voidPlaylistsDenied() {
        return "Errore: le playlist vuote non sono ammesse!";
    }

    @Override
    public String voteInstructions() {
        return """
               Nel seguente form hai la possibilit\u00e0 
               di esprimere un parere sulla canzone scelta
               sulla base di 9 emozioni.
               Per ognuna delle emozioni devi esprimere un voto
               che va da 1 a 5 \u2013 
               dove 1 indica che l'emozione non \u00e8 stata percepita 
               per niente e 5 indica che l' emozione \u00e8 stata 
               percepita appieno.
               Se lo desideri, per ogni emozione, puoi fornire 
               un commento di massimo 255 caratteri.""";
    }

    @Override
    public String tryConnectToService() {
        return "Connetti";
    }

    @Override
    public String typeAnHostAddressError() {
        return "Inserire un indirizzo IP host valido!";
    }

    @Override
    public String typeAPortError() {
        return "Inserire la porta del servizio!";
    }

    @Override
    public String hostServiceLabel() {
        return "IP host del servizio:";
    }

    @Override
    public String portLabel() {
        return "Porta del servizio:";
    }

    @Override
    public String errorSongNotEsists() {
        return "Errore: canzone non presente nel database!";
    }

    @Override
    public String errorVoteArrayDim() {
        return "Errore: i voti superano in numero le emozioni!";
    }

    @Override
    public String errorVoteRange() {
        return "Errore: un voto è fuori dal range 1-5!";
    }

    @Override
    public String errorCharacterInComment() {
        return "Errore: sono presenti caratteri non ammessi nel commento!";
    }

    @Override
    public String errorCommentLength() {
        return "Errore: numero massimo di caratteri ammessi 255!";
    }

    @Override
    public String errorSql() {
        return "Errore di comunicazione con il database!";
    }

    @Override
    public String noPlaylists() {
                return "Non possiede alcuna playlist. Ne può creare una premendo sul bottone: '" +createNewPlaylist()+"'.";

    }
}
