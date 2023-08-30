/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.clientES.dialogs;

/**
 * Classe che implemeta i dialoghi dell' interfaccia in inglese.
 */
public class English extends ClientDialogs{
    
    //Generici
    public String searchBarText(){
        return "Insert title or author;year";
    }
    
    public String availableSongs(){
        return "available songs!";
    }
    
    public String foundedResults(){
        return "Song founded!";
    }
    
    public String noSongsFounded(){
        return "0 results founded!";
    }
    
    public String selectedSongs(){
        return "selected songs!";
    }
    
    //BASICS STRUCTURE: EMOZIONI

     public String amazementName() {
         return "Amazement";
    }

    public String amazementExplanation() {
        return "Feeling of wonder or happiness.";
    }

    public String solemnityName() {
        return "Solemnity";
    }

    public String solemnityExplanation() {
        return "Feeling of transcendence, inspiration. Thrills.";
    }

    public String tendernessName() {
        return "Tenderness";
    }

    public String tendernessExplanation() {
        return "Sensuality, affect, feeling of love.";
    }

    public String nostalgiaName() {
        return "Nostalgia";
    }

    public String nostalgiaExplanation() {
        return "Dreamy, melancholic, sentimental feelings.";
    }

    public String calmnessName() {
        return "Calmness";
    }

    public String calmnessExplanation() {
        return "Relaxation, serenity, meditativeness";
    }

    public String powerName() {
        return "Power";
    }

    public String powerExplanation() {
        return "Feeling strong, heroic, triumphant, energetic.";
    }

    public String joyName() {
        return "Joy";
    }

    public String joyExplanation() {
        return "Feels like dancing, bouncy feeling, animated, amused.";
    }

    public String tensionName() {
        return "Tension";
    }
  
    public String tensionExplanation() {
        return "Feeling Nervous, impatient, irritated.";
    }

    public String sadnessName() {
        return "Sadness";
    }

    public String sadnessExplanation() {
        return "Feeling Depressed, sorrowful.";
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
        return "Database is void";
    }
    
    // ENGINES : EngineRegister
    
    public String userCreated(){
        return "";
    }
    
    public String userAdded(){
        return "";
    }
    

    //GUI FRAME LOGIN 
  
    public String userId() {
        return "ID User: ";
    }

    public String userIdNotFound() {
        return "ID User doesn't exist!";
    }

    public String password() {
        return "Password: ";
    }

    public String passwordErr() {
        return "Wrong password!";
    }

    public String log() {
        return "Login";
    }
    
    public String exit() {
        return "Exit";
    }
    
    //GUI REGISTRATION PANEL

    public String name() {
        return "FIRST NAME: ";
    }

    public String nameNotValid() {
        return "First name not valid!";
    }

    public String surname() {
        return "LAST NAME: ";
    }

    public String notValidSurname() {
        return "Last name not valid!";
    }

    public String address() {
        return "ADDRESS: ";
    }

    public String addrNotValid() {
        return "This field cannot be empty!";
    }

    public String birthDate() {
       return "DATE OF BIRTH:";
    }

    public String invalidBirthDate() {
        return "Format data not valid!";
    }

    public String cf() {
        return "FISCAL CODE: ";
    }

    public String invalidCf() {
       return "Format data not valid!";
    }
    
    public String cfIsPresentYet(){
        return "Fiscal code already used";
    }

    public String email() {
        return "E-MAIL ADDRESS: ";
    }

    public String emailNotValid() {
        return "Address not valid!";
    }

    public String useridToUpperCaseWithColon() {
        return "USER ID: ";
    }
    
    public String userIdTaken(){
        return "ID used";
    }

    public String userIdNotValid() {
        return "User ID not valid!";
    }
    
    public String passswordR(){
        return "PASSWORD";
    }

    public String passwordCheck() {
        return "PASSWORD";
    }

    public String passwordNotValid(){
        return "Password not valid!";
    }
    
    public String passwordsNotMatching(){
        return "Password non coincidono!";
    }
   
    public String registrer() {
        return "Registration";
    }
    
    //GUI PLATYLIST CREATION FRAME
    
    public String newPlaylistName() {
        return "Nome of the new playlist: ";
    }

    public String title() {
        return "Title";
    }

    public String author() {
        return "Autor";
    }

    public String year() {
        return "Year";
    }

    public String creaNuovaPlaylistButton() {
        return "Create new playlist";
    }

    public String abort() {
        return "Delete";
    }
    
    //GUI MAIN MENU LEFT LOGGED
    
    public String createPlaylist(){
        return "Create Playlist";
    }

    
    public String profile() {
        return "Profile";
    }

    public String credits() {
        return "Credits";
    }
    
    public String menu() {
        return "Menu";
    }
    
    public String newPlaylistLabel(){
        return "New playlist name";
    }
    
    public String createNewPlaylist(){
        return "+ Create new playlist";
    }
    
    public String songData(){
        return "CHART ";
    }
    
    public String vote(){
        return "Vote";
    }
    
   public String songsJudgeCommentRequest(){
       return "If you want, insert here a note or comment about the perception of this emotion while listening to the piece.";
   }

    public String chartMedian() {
        return "Medians' graph of emotion ratings";
    }

    public String chartMedium() {
        return "Mediums' graph of emotion ratings";
    }

    public String chartTrend() {
        return "Trends' graph of emotion ratings";
    }
    
    public String emotions(){
        return "Emotion";
    }
    
    public String trendsV(){
        return "Trends of vote";
    }
    
    public String marksMedium(){
        return "Grade point averages";
    }
    
    public String howMuchFeeled(){
        return "How much a user perceived the emotion";
    }
  
    public String numberOfUser(){
        return "Numbers of users";
    }
   
    public String reportPaneTitle(){
       return "DATA REPORT ON JUDGMENTS OF PERCEIVED EMOTIONS " + 
                " FROM USERS LISTENING TO THE SONG:\n\n";
    }
    
    public String votedYet(){
        return "Number of users who have expressed their opinion: ";
    }
    
    public String relativeData(){
        return "DATA RELATING TO USER JUDGMENTS ABOUT THE PERCEPTION OF THEIR RESPECTIVE EMOTIONS: ";
    }
    
    public String aritmeticalMedium(){
       return "   arithmetic average: ";
    }
    
    public String trend(){
        return "   trend: ";
    }
    
    public String median(){
        return "   median: ";
}

    @Override
    public String yearOfPublication() {
        return "Year of publication: ";
    }

    @Override
    public String authorCapitalizedWithColon() {
        return "Author: ";
    }

    @Override
    public String titleCapitalizedWithColon() {
        return "Title: ";
    }

    @Override
    public String exportData() {
        return "Export song's data";
    }

    @Override
    public String close() {
        return "Close";
    }

    @Override
    public String songDataView() {
        return "Song's data view";
    }

    @Override
    public String myPlaylistsText() {
        return "My playlists";
    }

    @Override
    public String newPlaylistText() {
        return "New playlist";
    }

    @Override
    public String registration() {
    return "Registration";
    }

    @Override
    public String fileNotFound() {
        return "Necessary file can't be found by the software: ";
    }

    @Override
    public String ImpossibleToGenerateReport() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String OpSucessTerminated() {
        return "Operation succesfully terminated !";
    }

    @Override
    public String maxStringLong255() {
        return "Error: comments' max legth is 255 characters!";
    }

    @Override
    public String notAllVoted() {
        return "Error: All emotions must be judged!";
    }

    @Override
    public String voidPlaylistsDenied() {
        return "Error: void playlists aren't allowed!";
    }

    @Override
    public String voteInstructions() {
        return "In the following form you have the opportunity to\n"+
                "pass a judgement on the selected song on the base of\n"+
                "nine emotions, for each one you have to pass a vote 1 to 5;\n"+
                "where 1 means emotion little perceived and 5 means\n"+
                "plenty perceived.\n"+
                "If you want it, you can release a comment,\n of max 255 characters, for each emotion.";
    }

    @Override
    public String tryConnectToService() {
        return "Connect";
    }

    @Override
    public String typeAnHostAddressError() {
        return "Type a valid IP Host address";
    }

    @Override
    public String typeAPortError() {
        return "Type Host service's port";
    }

    @Override
    public String hostServiceLabel() {
        return "Host service's IP address:";
    }

    @Override
    public String portLabel() {
        return "Host service's port";
    }

    @Override
    public String errorSongNotEsists() {
        return "Error: song not in database!";
    }

    @Override
    public String errorVoteArrayDim() {
        return "Error: number of marks doesn't match the number of emotions!";
    }

    @Override
    public String errorVoteRange() {
        return "Error: one or more marks out of range 1-5!";
    }

    @Override
    public String errorCharacterInComment() {
        return "Error: Characters not tolerated in comment!";
    }

    @Override
    public String errorCommentLength() {
        return "Error: Max comment's characters' number is 256!";
    }

    @Override
    public String errorSql() {
       return "Error: impossible to comunicate with the DataBase!";
    }

    @Override
    public String noPlaylists() {
        return "You haven't any playlists yet! Please proceed to create one cliccking on the button: '"+createNewPlaylist()+"'.";
    }
    
}