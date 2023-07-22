/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.welcome_email;



import emotionalsongs.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Classe statica il cui unico metodo si occupa di mandare il form di benvenuto ad un indirizzo email.
 * La classe sfrutta l' api offerto da google mail service.
 */
public class WelcomeMailSender {
    /**
     * Metodo che spedisce la mail di benvenuto.
     */
    public static void sendMailToNewUser() {

        // Recipient's email ID needs to be mentioned.
        String to = EmotionalSongs.getLoggedUser().getEmail();

        // Sender's email ID needs to be mentioned
        String sender = "bigs.development.studio@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("bigs.development.studio@gmail.com", "zcaivjomuuuruwzg");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(sender));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Benvenuto in EmotionalSongs");
            
            HTMLWelcomeBuilder b = new HTMLWelcomeBuilder();
            // Now set the actual message
             message.setContent(b.getwelcomeMessage(),"text/html");

            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}