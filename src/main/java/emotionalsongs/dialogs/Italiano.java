//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA

package emotionalsongs.dialogs;

/**
 * Classe che implementa i dialogi dell' interfaccia in italiano.
 */
public class Italiano extends dialogs{
    
   //BASICS STRUCTURE: EMOZIONI

    
     public String amazementNome() {
         return "Meraviglia";
    }

    public String amazementESpiegazione() {
        return "Sensazione di stupore o felicità.";
    }

    public String solemnityNome() {
        return "Solennità";
    }

    public String solemnitySpiegazione() {
        return "Sensazione di trascendenza, ispirazione.Brividi.";
    }

    public String tendernessNome() {
        return "Tenereza";
    }

    public String tendernessSpiegazione() {
        return "Sensualità, affetto, sentimento di emotività.";
    }

    public String nostalgiaNome() {
        return "Nostalgia";
    }

    public String nostalgiaSpiegazione() {
        return "Sognante, malinconia, sentimento di emotività.";
    }

    public String calmnessNome() {
        return "Pacatezza";
    }

    public String calmnessSpiegazione() {
        return "Rilassamento, serenità, meditatività.";
    }

    public String powerNome() {
        return "Potere";
    }

    public String powerSpiegazione() {
        return "Sentirsi forte, eroici , trionfanti, energetici.";
    }

    public String joyNome() {
        return "Gioia";
    }

    public String joySpiegazione() {
        return "Sentirsi come danzanti, raggianti, animati, divertiti.";
    }

    public String tensionNome() {
        return "Tensione";
    }
  
    public String tensioneSpiegazione() {
        return "Sentire nervosismo, impazienza, irritazione.";
    }

    public String sadnessNome() {
        return "Tristezza";
    }

    public String sadnessSpiegazione() {
        return "Sentirsi depressi, scarichi, dispiaciuti.";
    }
    
    //BASIC STRUCTURE : USER
    
    public String uProprietario(){
        return "Proprietario: ";
    }
    
    public String spazioG(){
        return "Spazio generato con successo";
    }
    
    //BASICS DATABASES: DATABASEPLAYLISTS
    
    public String isVoid(){
        return "Il basa dati e vuoto!";
    }
    
    // ENGINES : EngineRegister
    
    public String utenteCreato(){
        return "Utente creato";
    }
    
    public String utenteAggiunto(){
        return "Utente aggiunto";
    }
    

    public String idUtente() {
        return "ID Utente: ";
    }

    public String idUtenteInes() {
        return "ID Utente inesistente!";
    }

    public String password() {
        return "Password: ";
    }

    public String passwordErr() {
        return "Password errata!";
    }
    
    public String passwordNonCoincidono(){
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

    public String nomeNon() {
        return "Nome non valido! ";
    }

    public String cognome() {
        return "COGNOME: ";
    }

    public String cognomeNon() {
        return "Cognome non valioa!";
    }

    public String indirizzo() {
        return "INDIRIZZO: ";
    }

    public String indirizzoNon() {
        return "Questo campo non può essere vuoto!";
    }

    public String dataNascita() {
        return "DATA DI NASCITA: ";
    }

    public String dataNasciataNon() {
        return "Formato data non valido!";
    }

    public String cf() {
        return "CODICE FISCALE: ";
    }
    
    public String cfpresente(){
        return "Codice fiscale già presente nel sistema!";
    }


    public String cfNon() {
        return "Formato data non valido!";
    }

    public String email() {
        return "INDIRIZZO E-MAIL";
    }

    public String emailNon() {
        return "Indirizzo non valido!";
    }
  
    public String userid() {
        return "USER ID: ";
    }
    
    public String userIdpresente(){
        return "ID già presente";
    }

    public String useridNon() {
        return "User id non valido!";
    }

    public String passswordR(){
        return "PASSWORD";
    }
    
    public String passwordCheck() {
        return "VERIFICA PASSWORD";
    }
    
    public String passwordNon(){
        return "Password non valido!";
    }
    
    public String registrati() {
        return "Registrati";
    }

    public String chiudi() {
        return "Chiudi";
    }

    //GUI PLATYLIST CREATION FRAME
    
    public String nuovaPlaylist() {
        return "Nome della nuova playlist: ";
    }

    public String titolo() {
        return "Titolo";
    }

    public String autore() {
        return "Autore";
    }

    public String anno() {
        return "Anno";
    }

    public String creaNuovaPlaylist() {
        return "Crea nuova playlist";
    }

    public String annulla() {
        return "Annulla";
    }
    
   //GUI MAIN MENU LEFT LOGGED
    
    public String creaPlaylist(){
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

    public String newPlaylist(){
        return "Nome nuova playlist";
    }
   
    public String creaNuovaPlaylistpiu(){
        return "+ Crea nuova playlist";
    }
    
    public String datiCanzoni(){
        return "Dati canzone";
    }
    
    public String vota(){
        return "Vota";
    }
    
    public String songsJudge(){
        return "Se vuoi puoi inserire qui una nota o commento riguardo "
                + "la percezione di questa emozione nell' ascolto del brano.";
    }

    public String graficEx() {
        return "Grafico dei trends dei voti delle emozioni";
    }
    
    public String emozioni(){
        return "Emotioni";
    }
    
    public String trendsV(){
        return "Trends dei voti";
    }
    
    public String mediaVoti(){
        return "media dei voti";
    }
    
    public String quantoHaPercepito(){
        return "Quanto un utente ha percepito l' emozione";
    }
    
    public String numeroUtenti(){
        return "Numeri di utenti";
    }

     public String report1(){
        return "REPORT DATI SUI GIUDIZI DELLE EMOZIONI PERCEPITE " + 
                " DAGLI UTENTI NELL' ASCOLTO DELLA CANZONE:\n\n";
    }
   
    public String espressoVoto(){
        return "Numero di utenti che hanno espresso il loro parare: ";
    }
    
    public String datiRelativi(){
        return "DATI RELATIVI AI GIUDIZI DEGLI UTENTI RIGUARDO ALLA PERCEZIONE DELLE RISPETTIVE EMOZIONI: ";
    }
    
    public String mediaArit(){
        return "   media aritmetica: ";
    }
    
    public String moda(){
        return "   moda: ";
    }
    
    public String mediana(){
        return "   mediana: ";
    }

    @Override
    public String yearOfPublication() {
        return "Anno di pubblicazione: ";
    }

    @Override
    public String author() {
        return "Autore: ";
    }

    @Override
    public String title() {
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
    public String userPlaylists() {
        return "Le mie playlists";
    }

    @Override
    public String createNewPlaylist() {
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
