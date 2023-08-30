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
        return "songs found!";
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
        return "Owner: ";
    }
    
    public String spaceSuccessfullyGenerated(){
        return "Space generated successfully!";
    }
    
    //BASICS DATABASES: DATABASEPLAYLISTS

    public String isVoid(){
        return "Database is empty!";
    }
    
    // ENGINES : EngineRegister
    
    public String userCreated(){
        return "User created successfully!";
    }
    
    public String userAdded(){
        return "User added successfully!";
    }
    

    //GUI FRAME LOGIN 
  
    public String userId() {
        return "User ID: ";
    }

    public String userIdNotFound() {
        return "User ID doesn't exist!";
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
        return "Invalid data format!";
    }

    public String cf() {
        return "FISCAL CODE: ";
    }

    public String invalidCf() {
       return "Invalid data format!";
    }
    
    public String cfIsPresentYet(){
        return "Fiscal code already used!";
    }

    public String email() {
        return "E-MAIL ADDRESS: ";
    }

    public String emailNotValid() {
        return "Invalid e-mail address!";
    }

    public String useridToUpperCaseWithColon() {
        return "USER ID: ";
    }
    
    public String userIdTaken(){
        return "User ID already used!";
    }

    public String userIdNotValid() {
        return "Invalid user ID!";
    }
    
    public String passswordR(){
        return "PASSWORD";
    }

    public String passwordCheck() {
        return "PASSWORD";
    }

    public String passwordNotValid(){
        return "Invalid password!";
    }
    
    public String passwordsNotMatching(){
        return "Passwords don't match!";
    }
   
    public String registrer() {
        return "Registration";
    }
    
    //GUI PLATYLIST CREATION FRAME
    
    public String newPlaylistName() {
        return "New playlist's name: ";
    }

    public String title() {
        return "Title";
    }

    public String author() {
        return "Author";
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
        return "Create playlist";
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
       return "If you wish, insert here a note or comment about the perception of this emotion while listening to the piece.";
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
        return "Number of users";
    }
   
    public String reportPaneTitle(){
       return """
              DATA REPORT ON JUDGEMENTS ABOUT PERCEIVED EMOTIONS FROM USERS LISTENING TO THE SONG:
              """;
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
        return "Needed file couldn't be found by the software: ";
    }

    @Override
    public String ImpossibleToGenerateReport() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String OpSucessTerminated() {
        return "Operation terminated succesfully!";
    }

    @Override
    public String maxStringLong255() {
        return "Error: comments' max length is 255 characters!";
    }

    @Override
    public String notAllVoted() {
        return "Error: all emotions must be judged!";
    }

    @Override
    public String voidPlaylistsDenied() {
        return "Error: empty playlists aren't allowed!";
    }

    @Override
    public String voteInstructions() {
        return """
               In the following form you have the opportunity to pass a judgement on the selected song on the base of nine emotions, for each one you have to pass a vote 1 to 5; where 1 means emotion little perceived and 5 means plenty perceived. If you want it, you can release a comment, of max 255 characters, for each emotion.
               """;
    }

    @Override
    public String tryConnectToService() {
        return "Connect";
    }

    @Override
    public String typeAnHostAddressError() {
        return "Type a valid host IP address";
    }

    @Override
    public String typeAPortError() {
        return "Type service host's port";
    }

    @Override
    public String hostServiceLabel() {
        return "Service host's IP address:";
    }

    @Override
    public String portLabel() {
        return "Service host's port";
    }

    @Override
    public String errorSongNotEsists() {
        return "Error: song not available in database!";
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
        return "Error: not allowed characters in comment!";
    }

    @Override
    public String errorCommentLength() {
        return "Error: max comment's characters' number is 255!";
    }

    @Override
    public String errorSql() {
       return "Error: impossible to comunicate with the database!";
    }

    @Override
    public String noPlaylists() {
        return "You haven't any playlists yet! Please proceed to create one clicking on the button: '"+createNewPlaylist()+"'.";
    }
    
}