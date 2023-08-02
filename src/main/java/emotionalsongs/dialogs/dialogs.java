/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.dialogs;

/**
 * Classe astratta che fa da involucro per le classi che gestiscono la lingua del software.
 */
public abstract class dialogs {

    public abstract String tryConnectToService();
    //generics
    public abstract String searchBarText();
    
    public abstract String availableSongs();
    
    public abstract String foundedResults();
    
    public abstract String noSongsFounded();
    
    public abstract String selectedSongs();
    
    //songs
    public abstract String yearOfPublication();

    public abstract String authorCapitalizedWithColon();
    
    //emotions
    public abstract String titleCapitalizedWithColon();
    
    public abstract String amazementName();
    
    public abstract String amazementExplanation();
    
    public abstract String solemnityName();
    
    public abstract String solemnityExplanation();
    
    public abstract String tendernessName();
    
    public abstract String tendernessExplanation();
    
    public abstract String nostalgiaName();
    
    public abstract String nostalgiaExplanation();
    
    public abstract String calmnessName();
    
    public abstract String calmnessExplanation();
    
    public abstract String powerName();
    
    public abstract String powerExplanation();
    
    public abstract String joyName();
    
    public abstract String joyExplanation();
    
    public abstract String tensionName();
    
    public abstract String tensionExplanation();
    
    public abstract String sadnessName();
    
    public abstract String sadnessExplanation();
    
    //BASICS STRUCTURE: USER
    
    public abstract String propertyUser();
    
    public abstract String spaceSuccessfullyGenerated();
    
    
    //BASICS DATABASES: DATABASEPLAYLISTS
    
    public abstract String isVoid();
    
    
    // ENGINES : EngineRegister
    
    public abstract String userCreated();
    
    public abstract String userAdded();
    
    
    
    public abstract String userId();
    
    public abstract String userIdNotFound();
    
    public abstract String password();
    
    public abstract String passwordErr();
    
    public abstract String log();
    
    public abstract String exit();
    
    //GUI REGISTRATION PANEL
    
    public abstract String name();
    
    public abstract String nameNotValid();
    
    public abstract String surname();
    
    public abstract String notValidSurname();
    
    public abstract String address();
    
    public abstract String addrNotValid();
    
    public abstract String birthDate();
    
    public abstract String invalidBirthDate();
    
    public abstract String cf();
    
    public abstract String invalidCf();
    
    public abstract String cfIsPresentYet();
    
    public abstract String email();
    
    public abstract String emailNotValid();
    
    public abstract String useridToUpperCaseWithColon();
    
    public abstract String userIdTaken();
    
    public abstract String userIdNotValid();
    
    public abstract String passswordR();
    
    public abstract String passwordCheck();
    
    public abstract String passwordNotValid();
    
    public abstract String passwordsNotMatching();
    
    public abstract String registrer();
        
    //GUI PLAYLIST CREATION FRAME
    
    public abstract String newPlaylistName();
    
    public abstract String title();
    
    public abstract String author();
    
    public abstract String year();
    
    public abstract String creaNuovaPlaylistButton();
    
    public abstract String abort();
    
    //GUI MAIN MENU LEFT LOGGED
    
    public abstract String createPlaylist();
    
    //GUI MAIN UPPER BAR LOGGED PANEL
    
    public abstract String profile();
    
    public abstract String credits();
    
    //GUI MAIN UPPER BAR UNLOGGED PANEL
    
    public abstract String menu();
    
    //GUI PLAYLISTS
    
    public abstract String newPlaylistLabel();
    
    public abstract String createNewPlaylist();
    
    public abstract String songData();
    
    public abstract String vote();
    
    //GUI Songs Judgement
    
    public abstract String songsJudgeCommentRequest();
    
    /// CHART AND DATA BUILDER
    
    public abstract String chartMedian();
    
    public abstract String chartMedium();

    public abstract String chartTrend();

    public abstract String emotions();

    public abstract String trendsV();
    
    public abstract String marksMedium();
    
    public abstract String howMuchFeeled();
    
    public abstract String numberOfUser();
    
    public abstract String reportPaneTitle();
    
    public abstract String votedYet();
    
    public abstract String relativeData();
    
    public abstract String aritmeticalMedium();
    
    public abstract String trend();
    
    public abstract String median();

    public abstract String exportData();

    public abstract String close();

    public abstract String songDataView();

    public abstract String myPlaylistsText();

    public abstract String newPlaylistText();

    public abstract String registration();

    public abstract String fileNotFound();

    public abstract String ImpossibleToGenerateReport();

    public abstract String OpSucessTerminated();

    public abstract String maxStringLong255(); 
    
    public abstract String notAllVoted(); 

    public abstract String voidPlaylistsDenied(); 
    
    public abstract String voteInstructions();

    public abstract String typeAnHostAddressError();

    public abstract String typeAPortError(); 
    
    public abstract String hostServiceLabel();

    public abstract String portLabel();
}
