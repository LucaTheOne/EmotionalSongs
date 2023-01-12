//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs.Managers;

import emotionalsongs.DataBases.*;
import emotionalsongs.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.Registration.*;
import emotionalsongs.GUI.mainWindow.*;
import java.io.*;

/**
 *
 * @author big
 */
public class RegistrationManager {
    private static RegistrationManager instance = null;
    public GUIRegistrationPanel panel;
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
        this.panel = new GUIRegistrationPanel(this);
    }
    
    public void startForm(){
        MainFrame.getIstance().setMainPanel(panel);
    }
    
    public void startRegistration(){
        EngineRegistrer engine = new EngineRegistrer(DataBaseUsers.getInstance());
        panel.setAllCheckOff();
        boolean allDataValid = true;
        
        EngineChecker checker = new EngineChecker();
        if(checker.checkIdValidity(userId)){
            if(!checker.checkIdNotTaken(DataBaseUsers.getInstance(), userId)){
                panel.idCheckLabel.setVisible(true);
                panel.idCheckLabel.setText(EMOTIONALSONGS.dialoghi.userIdpresente());
                allDataValid = false;
            }
        } else {
            panel.idCheckLabel.setVisible(true);
            panel.idCheckLabel.setText(EMOTIONALSONGS.dialoghi.useridNon());
            allDataValid = false;
        }
        
        if(!checker.checkNameValidity(name)){
            panel.nomeCheckLabel.setVisible(true);
            panel.nomeCheckLabel.setText(EMOTIONALSONGS.dialoghi.nomeNon());
            allDataValid = false;
        }
        
        if(!checker.checkCognomeValidity(secondName)){
            panel.cognomeCheckLabel.setVisible(true);
            panel.cognomeCheckLabel.setText(EMOTIONALSONGS.dialoghi.cognomeNon());
            allDataValid = false;
        }
        
        if(checker.checkCfValidity(fiscalCode)){
            if(!checker.checkCfNotPresent(DataBaseUsers.getInstance(), fiscalCode)){
                panel.cfCheckLabel.setVisible(true);
                panel.cfCheckLabel.setText(EMOTIONALSONGS.dialoghi.cfpresente());
                allDataValid = false;
            }
        }else{
            panel.cfCheckLabel.setVisible(true);
            panel.cfCheckLabel.setText(EMOTIONALSONGS.dialoghi.cfNon());
            allDataValid = false;
        }
        
        if(!checker.checkAddresValidity(address)){
            panel.indirizzoCheckLabel.setVisible(true);
            panel.indirizzoCheckLabel.setText(EMOTIONALSONGS.dialoghi.indirizzoNon());
            allDataValid = false;
        }
        
        if(!checker.checkMailValidity(email)){
            panel.mailCheckLabel.setVisible(true);
            panel.mailCheckLabel.setText(EMOTIONALSONGS.dialoghi.emailNon());
            allDataValid = false;
        }
        
        if(checker.checkPasswordValidity(password)){
            if(!checker.passwordsMatch(password, passwordControl)) {
                panel.passwordCheckLabel.setText(EMOTIONALSONGS.dialoghi.passwordNonCoincidono());
                panel.passwordCheckLabel.setVisible(true);
                allDataValid = false;                
            }
        } else {
           panel.passwordCheckLabel.setText(EMOTIONALSONGS.dialoghi.passwordNon());
           panel.passwordCheckLabel.setVisible(true);
           allDataValid = false;
        }
        
        if(!checker.checkBirthDayValidity(birthDay)){
            panel.dataDiNascitaCheckLabel.setText(EMOTIONALSONGS.dialoghi.dataNasciataNon());
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
            MainFrame.getIstance().setUpperBar(new GUIMainUpperBarUnloggedPanel(MainFrame.getIstance()));
            MainFrame.getIstance().updateView();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }       
    }
}
