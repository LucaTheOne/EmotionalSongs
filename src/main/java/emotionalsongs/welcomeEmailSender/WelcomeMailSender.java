package emotionalsongs.welcomeEmailSender;



import emotionalsongs.DataBases.*;
import emotionalsongs.*;
import emotionalsongs.DataBases.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class WelcomeMailSender {

    public static void sendMailToNewUser() {

        // Recipient's email ID needs to be mentioned.
        String to = EMOTIONALSONGS.loggedUser.getEmail();

        // Sender's email ID needs to be mentioned
        String from = "bigs.development.studio@gmail.com";

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

                return new PasswordAuthentication(from, "zcaivjomuuuruwzg");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Benvenuto in EmotionalSongs");
            
            HTMLWelcomeBuilder b = new HTMLWelcomeBuilder();
            // Now set the actual message
             message.setContent(b.html,"text/html");

            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        EMOTIONALSONGS.userDataBase = new DataBaseUsers();
        EMOTIONALSONGS.loggedUser = EMOTIONALSONGS.userDataBase.getUser(5);
        HTMLWelcomeBuilder h = new HTMLWelcomeBuilder();
        sendMailToNewUser();
    }

}