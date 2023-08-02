/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.basic_structures;

/**
 *
 * Classe le cui istanze rappresentano un utente.
 */
public class User {
    //campi
    private String userId;
    /**
     * Costruice un istanza di Utente.
     * @param userId - userId dell'utente.
     */
    public User(String userId){
        this.userId = userId;  
    }
    
    //metodi getter
    /**
     * Il metodo restituisce l'userID dell'utente.
     * @return userId - userID dell'utente.
     */
    public String getUserId(){
        return userId;
    }
}

