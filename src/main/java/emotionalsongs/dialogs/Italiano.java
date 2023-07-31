/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */

package emotionalsongs.dialogs;

/**
 * Classe che implementa i dialogi dell' interfaccia in italiano.
 */
public class Italiano extends dialogs{
    //Generici
    public String searchBarText(){
        return "Digiti titolo oppure autore;anno";
    }
    
    public String availableSongs(){
        return "canzoni disponibili!";
    }
    
    public String foundedResults(){
        return "risultati trovati";
    }
    
    public String noSongsFounded(){
        return "0 risultati trovati!";
    }
   //BASICS STRUCTURE: EMOZIONI

     public String amazementName() {
         return "Meraviglia";
    }

    public String amazementExplanation() {
        return "Sensazione di stupore o felicità.";
    }

    public String solemnityName() {
        return "Solennità";
    }

    public String solemnityExplanation() {
        return "Sensazione di trascendenza, ispirazione.Brividi.";
    }

    public String tendernessName() {
        return "Tenereza";
    }

    public String tendernessExplanation() {
        return "Sensualità, affetto, sentimento di emotività.";
    }

    public String nostalgiaName() {
        return "Nostalgia";
    }

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
        return "Sentirsi forte, eroici , trionfanti, energetici.";
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
        return "Spazio generato con successo";
    }
    
    //BASICS DATABASES: DATABASEPLAYLISTS
    
    public String isVoid(){
        return "Il basa dati e vuoto!";
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
        return "Password non coincidono!";
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
        return "Cognome non valioa!";
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
        return "Indirizzo non valido!";
    }
  
    public String useridToUpperCaseWithColon() {
        return "USER ID: ";
    }
    
    public String userIdTaken(){
        return "ID già presente";
    }

    public String userIdNotValid() {
        return "User id non valido!";
    }

    public String passswordR(){
        return "PASSWORD";
    }
    
    public String passwordCheck() {
        return "VERIFICA PASSWORD";
    }
    
    public String passwordNotValid(){
        return "Password non valido!";
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
        return "Crea Playlist";
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
        return "Se vuoi puoi inserire qui una nota o commento riguardo "
                + "la percezione di questa emozione nell' ascolto del brano.";
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
        return "Trends dei voti";
    }
    
    public String marksMedium(){
        return "media dei voti";
    }
    
    public String howMuchFeeled(){
        return "Quanto un utente ha percepito l' emozione";
    }
    
    public String numberOfUser(){
        return "Numeri di utenti";
    }

     public String reportPaneTitle(){
        return "REPORT DATI SUI GIUDIZI DELLE EMOZIONI PERCEPITE " + 
                " DAGLI UTENTI NELL' ASCOLTO DELLA CANZONE:\n\n";
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
        return "Le mie playlists";
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
        return "Errore accorso! impossibile generare il report!";
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
        return "Errore: Tutte le emozioni devono ricevere un voto!";
    }

    @Override
    public String voidPlaylistsDenied() {
        return "Errore le playlist vuote non sono ammesse";
    }

    @Override
    public String voteInstructions() {
        return "Nel seguente form hai la possibilità \n"+
                "di esprimere un parere sulla canzone scelta\n"+
                "Sulla base di 9 emozioni.\n"+
                "Per ogniuna delle emozioni devi esprimere un voto\n"+
                "che va da 1 a 5:\n"+
                "dove 1 indica che l'emozione è stata percepita per niente e\n"+
                "5 indica che l' emozione è stata percepita appieno.\n"+
                "Se lo desideri, per ogni emozione, puoi fornire \n"+
                "un commento di massimo 255 caratteri.";
    }
}
