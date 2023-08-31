/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package serverES.welcome_email_sender;
/**
 * Classe che si occupa di fornire metodi per la compilazione del form html di benvenuto.
 */
class HTMLWelcomeBuilder {
    
    private String message ="";
    private String[] userdata = new String[8];
    private String[] identifiers = {"%&0","%&1","%&2","%&3","%&4","%&5","%&6","%&7"};
    
    /**
     * Costruttore della classe che si occupa di compilare il form html di benvenuto sulla base dei dati dell' utente appena registrato.
     */
    protected HTMLWelcomeBuilder(String name, String surname,String birthdate,String cf,String address,String email,String userId, String password) {
        userdata[0] = name;
        userdata[1] = surname;
        userdata[2] = birthdate;
        userdata[3] = cf;
        userdata[4] = address;
        userdata[5] = email;
        userdata[6] = userId;
        userdata[7] = password;
        
        message = new WelcomeMailMessageTemplate().getMailWelcomeTemplate();
        
        for (int i = 0; i < 8; i++) {
            message = message.replace(identifiers[i], userdata[i]);
        }
    }
    /**
     * Restituisce il form compilato sotto forma di stringa.
     * @return stringa rappresentante il form compilato.
     */
    protected String getwelcomeMessage(){
        return message;
    }
     
}
