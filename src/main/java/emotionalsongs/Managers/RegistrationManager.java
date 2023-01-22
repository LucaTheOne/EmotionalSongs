//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.managers;

import emotionalsongs.*;
import emotionalsongs.data_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.main_window.*;
import emotionalsongs.gui.registration.*;
import java.io.*;

/**
 * Classe che si occupa di gestire il processo di registrazione di un nuovo utente ed aggiornarne il database Utenti.
 */
public class RegistrationManager {
    private static RegistrationManager instance = null;
    private RegistrationPanel panel;
    public String userId;
    public String name;
    public String secondName;
    public String fiscalCode;
    public String address;
    public String email;
    public String password;
    public String passwordControl;
    public String birthDay;
    
    /**
     * Metodo per accedere alla istanza del Registration Manager.
     * @return 
     */
    public static RegistrationManager getInstance(){
        if(instance== null) instance = new RegistrationManager();
        return instance;
    }
    private RegistrationManager() {
        this.panel = new RegistrationPanel(this);
    }
    /**
     * Metodo che avvia il form di registrazione di un nuovo utente.
     */
    public void startForm(){
        MainFrame.getIstance().setMainPanel(panel);
    }
    /**
     * Metodo che effettua la registrazione effettiva del nuovo utente, utilizzando i dati che questo ha 
     * fornito tramite il form, dopo averli convalidati.
     * Si occupa di comunicare al utente quali campi non siano stati reputati idonei.
     * Qual' ora siano tutti quanti idonei aggiorna il database inserendo i dati del nuovo utente ed aggiorna 
     * l' interfaccia grafica.
     */
    public void startRegistration(){
        EngineRegister engine = new EngineRegister(DataBaseUsers.getInstance());
        panel.setAllCheckOff();
        boolean allDataValid = true;
        
        EngineChecker checker = new EngineChecker();
        if(checker.checkIdValidity(userId)){
            if(!checker.checkIdNotTaken(DataBaseUsers.getInstance(), userId)){
                panel.idCheckLabel.setVisible(true);
                panel.idCheckLabel.setText(EmotionalSongs.dialoghi.userIdTaken());
                allDataValid = false;
            }
        } else {
            panel.idCheckLabel.setVisible(true);
            panel.idCheckLabel.setText(EmotionalSongs.dialoghi.userIdNotValid());
            allDataValid = false;
        }
        
        if(!checker.checkNameValidity(name)){
            panel.nomeCheckLabel.setVisible(true);
            panel.nomeCheckLabel.setText(EmotionalSongs.dialoghi.nameNotValid());
            allDataValid = false;
        }
        
        if(!checker.checkSurnameValidity(secondName)){
            panel.cognomeCheckLabel.setVisible(true);
            panel.cognomeCheckLabel.setText(EmotionalSongs.dialoghi.notValidSurname());
            allDataValid = false;
        }
        
        if(checker.checkCfValidity(fiscalCode)){
            if(!checker.checkCfNotPresent(DataBaseUsers.getInstance(), fiscalCode)){
                panel.cfCheckLabel.setVisible(true);
                panel.cfCheckLabel.setText(EmotionalSongs.dialoghi.cfIsPresentYet());
                allDataValid = false;
            }
        }else{
            panel.cfCheckLabel.setVisible(true);
            panel.cfCheckLabel.setText(EmotionalSongs.dialoghi.invalidCf());
            allDataValid = false;
        }
        
        if(!checker.checkAddresValidity(address)){
            panel.indirizzoCheckLabel.setVisible(true);
            panel.indirizzoCheckLabel.setText(EmotionalSongs.dialoghi.addrNotValid());
            allDataValid = false;
        }
        
        if(!checker.checkMailValidity(email)){
            panel.mailCheckLabel.setVisible(true);
            panel.mailCheckLabel.setText(EmotionalSongs.dialoghi.emailNotValid());
            allDataValid = false;
        }
        
        if(checker.checkPasswordValidity(password)){
            if(!checker.passwordsMatch(password, passwordControl)) {
                panel.passwordCheckLabel.setText(EmotionalSongs.dialoghi.passwordsNotMatching());
                panel.passwordCheckLabel.setVisible(true);
                allDataValid = false;                
            }
        } else {
           panel.passwordCheckLabel.setText(EmotionalSongs.dialoghi.passwordNotValid());
           panel.passwordCheckLabel.setVisible(true);
           allDataValid = false;
        }
        
        if(!checker.checkBirthDayValidity(birthDay)){
            panel.dataDiNascitaCheckLabel.setText(EmotionalSongs.dialoghi.invalidBirthDate());
            panel.dataDiNascitaCheckLabel.setVisible(true);
            allDataValid = false;
        }
        
        if(!allDataValid) {
            panel.revalidate();
            panel.repaint();
            return;
        }
        
        try {
            engine.registraNuovoUtente(userId, name, secondName, fiscalCode, address, email, password, passwordControl, birthDay);
            MainFrame.getIstance().cleanUpMainPanel();
            MainFrame.getIstance().setUpperBar(new UpperBarUnloggedPanel(MainFrame.getIstance()));
            MainFrame.getIstance().updateView();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }       
    }
}
