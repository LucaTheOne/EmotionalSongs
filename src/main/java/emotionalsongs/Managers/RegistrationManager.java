//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs.managers;

import emotionalsongs.engines.EngineChecker;
import emotionalsongs.engines.EngineRegister;
import emotionalsongs.gui.main_window.*;
import emotionalsongs.gui.registration.*;
import emotionalsongs.*;
import emotionalsongs.data_structures.DataBaseUsers;

import java.io.*;

/**
 *
 * @author big
 */
public class RegistrationManager {
    private static RegistrationManager instance = null;
    public RegistrationPanel panel;
    public String userId;
    public String name;
    public String secondName;
    public String fiscalCode;
    public String address;
    public String email;
    public String password;
    public String passwordControl;
    public String birthDay;
    
    public static RegistrationManager getInstance(){
        if(instance== null) instance = new RegistrationManager();
        return instance;
    }
    private RegistrationManager() {
        this.panel = new RegistrationPanel(this);
    }
    
    public void startForm(){
        MainFrame.getIstance().setMainPanel(panel);
    }
    
    public void startRegistration(){
        EngineRegister engine = new EngineRegister(DataBaseUsers.getInstance());
        panel.setAllCheckOff();
        boolean allDataValid = true;
        
        EngineChecker checker = new EngineChecker();
        if(checker.checkIdValidity(userId)){
            if(!checker.checkIdNotTaken(DataBaseUsers.getInstance(), userId)){
                panel.idCheckLabel.setVisible(true);
                panel.idCheckLabel.setText(EmotionalSongs.dialoghi.userIdpresente());
                allDataValid = false;
            }
        } else {
            panel.idCheckLabel.setVisible(true);
            panel.idCheckLabel.setText(EmotionalSongs.dialoghi.useridNon());
            allDataValid = false;
        }
        
        if(!checker.checkNameValidity(name)){
            panel.nomeCheckLabel.setVisible(true);
            panel.nomeCheckLabel.setText(EmotionalSongs.dialoghi.nomeNon());
            allDataValid = false;
        }
        
        if(!checker.checkCognomeValidity(secondName)){
            panel.cognomeCheckLabel.setVisible(true);
            panel.cognomeCheckLabel.setText(EmotionalSongs.dialoghi.cognomeNon());
            allDataValid = false;
        }
        
        if(checker.checkCfValidity(fiscalCode)){
            if(!checker.checkCfNotPresent(DataBaseUsers.getInstance(), fiscalCode)){
                panel.cfCheckLabel.setVisible(true);
                panel.cfCheckLabel.setText(EmotionalSongs.dialoghi.cfpresente());
                allDataValid = false;
            }
        }else{
            panel.cfCheckLabel.setVisible(true);
            panel.cfCheckLabel.setText(EmotionalSongs.dialoghi.cfNon());
            allDataValid = false;
        }
        
        if(!checker.checkAddresValidity(address)){
            panel.indirizzoCheckLabel.setVisible(true);
            panel.indirizzoCheckLabel.setText(EmotionalSongs.dialoghi.indirizzoNon());
            allDataValid = false;
        }
        
        if(!checker.checkMailValidity(email)){
            panel.mailCheckLabel.setVisible(true);
            panel.mailCheckLabel.setText(EmotionalSongs.dialoghi.emailNon());
            allDataValid = false;
        }
        
        if(checker.checkPasswordValidity(password)){
            if(!checker.passwordsMatch(password, passwordControl)) {
                panel.passwordCheckLabel.setText(EmotionalSongs.dialoghi.passwordNonCoincidono());
                panel.passwordCheckLabel.setVisible(true);
                allDataValid = false;                
            }
        } else {
           panel.passwordCheckLabel.setText(EmotionalSongs.dialoghi.passwordNon());
           panel.passwordCheckLabel.setVisible(true);
           allDataValid = false;
        }
        
        if(!checker.checkBirthDayValidity(birthDay)){
            panel.dataDiNascitaCheckLabel.setText(EmotionalSongs.dialoghi.dataNasciataNon());
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
