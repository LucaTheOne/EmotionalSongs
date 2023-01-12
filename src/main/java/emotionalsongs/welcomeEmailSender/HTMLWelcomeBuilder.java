//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.welcomeEmailSender;


import emotionalsongs.BasicsStructure.*;
import emotionalsongs.*;
import emotionalsongs.BasicsStructure.*;
import java.io.*;
import java.util.logging.*;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author big
 */
class HTMLWelcomeBuilder {
    
    User user = EMOTIONALSONGS.getLoggedUser();
    String message ="";
    String[] userdata = new String[8];
    String[] identifiers = {"%&0","%&1","%&2","%&3","%&4","%&5","%&6","%&7"};
    
    public HTMLWelcomeBuilder() {
        userdata[0] = user.getNome();
        userdata[1] = user.getCognome();
        userdata[2] = user.getDataDiNascita();
        userdata[3] = user.getCF();
        userdata[4] = user.getIndirizzo();
        userdata[5] = user.getEmail();
        userdata[6] = user.getUserId();
        userdata[7] = user.getPassword();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("../EMOTIONALSONGS/Risorse/email-registration-confirm-def/registration-confirm.html")));
            String current = "";
            while((current = reader.readLine()) != null){
                message += current;
            }
            for (int i = 0; i < 8; i++) {
                message = message.replace(identifiers[i], userdata[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HTMLWelcomeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HTMLWelcomeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String buildMessage(){
        return message;
    }
     
}
