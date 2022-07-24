package emotionalsongs;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Utente {
    //campi
    //boolean autenticated = false;
    private String userId,nome,cognome,cf,indirizzo,email,password,dataNascita;
    private ArrayList<Playlist> playlistSet; 

    Utente(String userId, String password,String cf,String nome,String cognome,String dataNascita,String email,String indirizzo){
        this.userId = userId;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.indirizzo = indirizzo;
        this.email = email;
        this.password = password;
        this.dataNascita = dataNascita;
        
    }
    
    static public void Registrazione() throws IOException {
        RegistrationForm regEngine = new RegistrationForm();
        regEngine.registraNuovoUtente();
    }
    
    public void stampaUtenteSuTerminale() {
        System.out.println("Codice fiscale: " + cf);
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Data di Nascita: " + dataNascita);
        System.out.println("Indirizzo: " + indirizzo);
        System.out.println("ID Utente: " + userId); 
        System.out.println("email: " + email);
        System.out.println("Password: " + password);
    }
    
    static private String setNome(){
        String nome = null;
        boolean valid = true;
        do{
            System.out.println("Inserisca il suo primo nome:");
            nome = new Scanner(System.in).nextLine();
            if (nome.length()>20||nome.length()<3||nome.isEmpty()||nome.matches(".*\\d.*")) {
                valid = false;
                System.out.println("nome non valido");
            }else{
                valid=true;
            }
        }while(!valid);
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }

    static private String setCognome(){
        String cognome = null;
        boolean valid = true;
        do{
            System.out.println("Inserisca il suo primo cognome:");
            cognome = new Scanner(System.in).nextLine();
            if (cognome.length()>20||cognome.length()<3||cognome.isEmpty()||cognome.matches(".*\\d.*")) {
                valid = false;
                System.out.println("nome non valido");
            }else{
                valid=true;
            }
        }while(!valid);
        return cognome.substring(0, 1).toUpperCase() + cognome.substring(1).toLowerCase();
    }

    static private String setInd(){
        boolean valid = true;
        String indirizzo = null;
        do{
            System.out.print("Inserisca il suo indirizzo di residenza,\n"+"(via/piazza, numero civico, cap, comune, provincia): ");
		  indirizzo = new Scanner(System.in).nextLine();
            if(indirizzo.isEmpty()){
                System.out.print("Questo campo deve essere compilato! ");
                valid = false;
            }
        }while(!valid);
        return indirizzo.toLowerCase();
    }

    static private String setPassword() throws PatternSyntaxException{
        String password,passwordCtrl;
        System.out.println("Scelga una password:");
        do{
            System.out.println("Minimo 8 - massimo 20 caratteri,\n"+"una minuscola, una maiuscola, un numero \n "+"ed almeno un carattere speciale tra: @#$%^&+=");
            password = new Scanner(System.in).nextLine();
    /**
    * Stringa contenente i tipi di caratteri da controllare ve ne sia la presenza
    * di almeno uno per tipologia:
    * (?=.*[0-9]) -> almeno un numero tra 0 e 9,
    * (?=.*[a-z]) -> Almeno una lettera minuscola,
    * (?=.*[A-Z]) -> Almeno una lettera maiuscola,
    * (?=.*[@#$%^&+=!]) -> almeno uno dei seguenti caratteri speciali @#$%^&+=!,
    * (?=\\S+$) -> spazi bianchi non ammessi,
    * {8,20} -> minimo 8, massimo 20 caratteri.
    **/
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}";
    /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
    /** Pattern class contiene il metodo .matcher() per verificare se la password coincide con il pattern.**/
        Matcher m = p.matcher(password);
    /**
    * Questa parte del codice gestissce la situazione
    * nel caso la password non rispettasse tutti i requisiti
    **/
        while(!(m.matches())){
            System.out.println("Password non valida! \n"+" Prego inserire una password valida: ");
            System.out.println("Minimo 8 - massimo 20 caratteri,\n"+"una minuscola, una maiuscola, un numero \n "+"ed almeno un carattere speciale tra: @#$%^&+=");
            password = new Scanner(System.in).nextLine();
            m = p.matcher(password);
        }
    /**
    *Per verificare che l' utente sappia che password abbia inserito
    *gli si chiede di reinserirle per poi successivamente confrontarla
    **/
        System.out.println("Reinserisca la password per verificare se è stata scritta correttamente");
        passwordCtrl = new Scanner(System.in).nextLine();
        if(!password.equals(passwordCtrl)){
            System.out.println("Le password non coincidono! \n"+"reinserisca la password: ");
        }
    } while(!password.equals(passwordCtrl));
    return password;
  }

    static private String setMail() throws PatternSyntaxException{
        String mail;
        System.out.println("Inserire un indirizzo email valido:");
        mail = new Scanner(System.in).nextLine();
        // Regex to check valid password.
        String regex = "^(.+)@(.+)$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        // Pattern class contains matcher() method to find matching between given password and regular expression.
        Matcher m = p.matcher(mail);
        // Nel caso la password non rispettasse i requisiti
        while(!(m.matches())){
            System.out.println("Indirizzo mail non valido:");
            System.out.println("Inserire un indirizzo email valido:");
            mail = new Scanner(System.in).nextLine();
            m = p.matcher(mail);
        }
        return mail;
    }

    static private String setCFUser() throws PatternSyntaxException{
        String cf;
        System.out.println("Inserisca il suo codice fiscale:");
        cf = new Scanner(System.in).nextLine().toUpperCase();
    /**
    * Stringa contenente i tipi di caratteri ed il formato
    * che deve presentare un codice fiscale italiano corretto:
    * [A-Za-z]{6} -> 6 lettere dell' alfabeto da a a z.
    * [0-9lmnpqrstuvLMNPQRSTUV]{2} -> due valori tra 0-9 o lmnpqrstuv.
    * [abcdehlmprstABCDEHLMPRST]{1} -> una lettera tra abcdehlmprst
    * [0-9lmnpqrstuvLMNPQRSTUV]{3} -> nuovamente tre valori tra 0-9 o lmnpqrstuv.
    * [A-Za-z]{1} -> una lettera del alfabeto.
    **/
        String regex = "^([A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1})$|([0-9]{11})$";
    /** compila il pattern precedente **/
        Pattern p = Pattern.compile(regex);
    /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
        Matcher m = p.matcher(cf);
    /**
    * Questa parte del codice gestissce la situazione
    * nel caso il cf non rispettasse il pattern
    **/
        while(!(m.matches())){
            System.out.println("Codice fiscale errato! \n"+" Prego reinserire un codice fiscale valido "+"(formato Italiano):");
            cf = new Scanner(System.in).nextLine();
            m = p.matcher(cf);
        }
        return cf.toUpperCase();
    }

    static private String setBirthDate() throws PatternSyntaxException {
        String date;
        boolean valid = false;
        do{
            System.out.println("Inserisca la sua data di nascita (gg/mm/aaaa)");
            date = new Scanner(System.in).nextLine();
            String regex = "^([0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4})$";
      /** compila il pattern precedente **/
            Pattern p = Pattern.compile(regex);
      /** Pattern class contiene il metodo .matcher() per verificare se il cf coincide con il pattern.**/
            Matcher m = p.matcher(date);
            if (!m.matches()) {
                System.out.println("Formato data errato! \n");
            }
            valid = m.matches();
        } while(!valid);
        return date;
    }

    static private boolean userCFSigned(String cf){
        try{
            String fileUtenti = "../data/UtentiRegistrati.dati.csv";
            Scanner inputStream = new Scanner(new FileReader(fileUtenti));
            inputStream.useDelimiter("\n");

            while(inputStream.hasNext()){
            String line = inputStream.next();//prendo l' intera linea
            if(line.contains("Codice fiscale:")){
                if (line.contains(cf)) {
                inputStream.close();
                return true;
                }
            }
        }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return false;
    }

    static private String setUserID(){
        String id;
        boolean valid;
        do{
            do{
                System.out.println("Scelga un user ID;\n"+"sara neccessario per il suo accesso!\n"+"Max 10 caratteri, minimo 3 caratteri, niente spazi vuoti ammessi:");
                id = new Scanner(System.in).nextLine();
                if (id.length()<3||id.length()>10||id.contains(" ")) {
                    System.out.println("User ID scelto non valido!");
                    valid = false;
                }else {valid = true;}
            } while(!valid);

            if (userIDTaken(id)) {
                System.out.println("User ID già registrato!");
            valid=false;
            }
        } while (!valid);
    return id;
  }

    static private boolean userIDTaken(String id){
        try{
            String fileUtenti = "../data/UtentiRegistrati.dati.csv";
            Scanner inputStream = new Scanner(new FileReader(fileUtenti));
            inputStream.useDelimiter("\n");

            while(inputStream.hasNext()){
            int countline = 0;
            String line = inputStream.next();//prendo l' intera linea
            if(countline%9==0){
                if (line.contains(id)) {
                    inputStream.close();
                    return true;
                }
            }
            countline++;
            inputStream.close();
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }   
        return false;
    }

    static private void creaPlaylistSetVuoto(String userId){
    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Utilities.pathToPlaylistDati,true));
      bufferedWriter.write("Proprietario: "+ userId + "/n"+"_.-._.-._.-._.-._.-._.-._\n");
      bufferedWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Spazio generato con successo");
  }

    public String getUserId(){
    return userId;
  }

    public String getNome(){
    return nome;
  }

    public String getCognome(){
    return cognome;
  }

    public String getCF(){
    return cf;
  }

    public String getIndirizzo(){
    return indirizzo;
  }

    public String getEmail(){
    return email;
  }

    public String getDataDiNascita(){
    return dataNascita;
  }
    
    public void addToPlaylistSet(Playlist addplay){
        playlistSet.add(addplay);
    }
    
    
    
    
}

