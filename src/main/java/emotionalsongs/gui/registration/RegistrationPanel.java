/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.gui.registration;

import clientES.*;
import emotionalsongs.*;
import emotionalsongs.gui.main_window.*;
import emotionalsongs.welcome_email.*;
import java.awt.*;
import java.rmi.*;
import javax.swing.*;
import serverES.services_common_interfaces.data_handler.*;
import serverES.services_common_interfaces.data_validator.*;

/**
 * Classe le cui istanze sono dei form per la registrazione di un nuovo utente.
 */
public class RegistrationPanel extends javax.swing.JPanel {
    
    private final MainFrame mainWindow;
    private final UsersDataHandler dataHandler;
    private final UsersDataValidator dataValidator;
    /**
     * Crea form di registrazione.
     * @param dataHandlerService servizio di gestione degli utenti.
     * @param dataValidatorService servizio di validazione dati degli utenti.
     * @param container MainFrame che conterrà questo pannello.
     */
    public RegistrationPanel(MainFrame container) {
        ServicesProvider sp = ServicesProvider.getInstance();
        dataHandler = (UsersDataHandler) sp.getService(ServicesProvider.USERS_DATA_HANDLER);
        dataValidator = (UsersDataValidator) sp.getService(ServicesProvider.USERS_DATA_VALIDATOR);;
        mainWindow = container;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(ClientUtilities.regBG.getImage(), 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }
        };
        jPanel3 = new javax.swing.JPanel();
        iconPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mainGridPanel = new javax.swing.JPanel();
        labelsPanel = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        cognomeLabel = new javax.swing.JLabel();
        dataDiNascitaLabel = new javax.swing.JLabel();
        cfLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        IndirizzoTextLabel = new javax.swing.JLabel();
        textFieldsLabel = new javax.swing.JPanel();
        nomeTextField = new javax.swing.JTextField();
        cognomeTextField = new javax.swing.JTextField();
        birthdayTextField = new javax.swing.JTextField();
        cfTextField = new javax.swing.JTextField();
        mailTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        warningLabelsPanel = new javax.swing.JPanel();
        nomeCheckLabel = new javax.swing.JLabel();
        cognomeCheckLabel = new javax.swing.JLabel();
        dataDiNascitaCheckLabel = new javax.swing.JLabel();
        cfCheckLabel = new javax.swing.JLabel();
        mailCheckLabel = new javax.swing.JLabel();
        idUserCheckLabel = new javax.swing.JLabel();
        indirizzoCheckLabel = new javax.swing.JLabel();
        lowPanel = new javax.swing.JPanel();
        passwordPanel = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        controlloLabel = new javax.swing.JLabel();
        controlloTextField = new javax.swing.JPasswordField();
        passwordCheckLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        registerNewUserButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 600));
        setLayout(new java.awt.BorderLayout());

        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        iconPanel.setOpaque(false);
        iconPanel.setPreferredSize(new java.awt.Dimension(175, 300));
        iconPanel.setLayout(new java.awt.GridLayout(1, 3));
        iconPanel.add(jLabel1);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(ClientUtilities.regIcon);
        iconPanel.add(jLabel3);
        iconPanel.add(jLabel2);

        jPanel3.add(iconPanel, java.awt.BorderLayout.PAGE_START);

        mainGridPanel.setOpaque(false);
        mainGridPanel.setLayout(new java.awt.GridLayout(1, 3));

        labelsPanel.setOpaque(false);
        labelsPanel.setLayout(new java.awt.GridLayout(7, 1));

        nomeLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        nomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        nomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nomeLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.name());
        nomeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(nomeLabel);

        cognomeLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cognomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        cognomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cognomeLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.surname());
        cognomeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(cognomeLabel);

        dataDiNascitaLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        dataDiNascitaLabel.setForeground(new java.awt.Color(255, 255, 255));
        dataDiNascitaLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dataDiNascitaLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.birthDate());
        dataDiNascitaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(dataDiNascitaLabel);

        cfLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cfLabel.setForeground(new java.awt.Color(255, 255, 255));
        cfLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cfLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.cf());
        cfLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(cfLabel);

        mailLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        mailLabel.setForeground(new java.awt.Color(255, 255, 255));
        mailLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mailLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.email());
        mailLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(mailLabel);

        idLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        idLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.userId());
        idLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(idLabel);

        IndirizzoTextLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        IndirizzoTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        IndirizzoTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        IndirizzoTextLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.name());
        IndirizzoTextLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(IndirizzoTextLabel);

        mainGridPanel.add(labelsPanel);

        textFieldsLabel.setOpaque(false);
        textFieldsLabel.setLayout(new java.awt.GridLayout(7, 1));

        nomeTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(nomeTextField);

        cognomeTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(cognomeTextField);
        textFieldsLabel.add(birthdayTextField);

        cfTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(cfTextField);

        mailTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(mailTextField);

        idTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(idTextField);

        addressTextField.setText("ES: via indirizzo_nome, numero_civico, cap");
        textFieldsLabel.add(addressTextField);

        mainGridPanel.add(textFieldsLabel);

        warningLabelsPanel.setOpaque(false);
        warningLabelsPanel.setLayout(new java.awt.GridLayout(7, 1));

        nomeCheckLabel.setVisible(false);
        nomeCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        nomeCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        nomeCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.nameNotValid());
        warningLabelsPanel.add(nomeCheckLabel);

        cognomeCheckLabel.setVisible(false);
        cognomeCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        cognomeCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        cognomeCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.notValidSurname());
        warningLabelsPanel.add(cognomeCheckLabel);

        dataDiNascitaCheckLabel.setVisible(false);
        dataDiNascitaCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        dataDiNascitaCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        dataDiNascitaCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.invalidBirthDate());
        warningLabelsPanel.add(dataDiNascitaCheckLabel);

        cfCheckLabel.setVisible(false);
        cfCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        cfCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        cfCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.invalidCf());
        warningLabelsPanel.add(cfCheckLabel);

        mailCheckLabel.setVisible(false);
        mailCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        mailCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        mailCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.emailNotValid());
        warningLabelsPanel.add(mailCheckLabel);

        idUserCheckLabel.setVisible(false);
        idUserCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        idUserCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        idUserCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.userIdNotValid());
        warningLabelsPanel.add(idUserCheckLabel);

        indirizzoCheckLabel.setVisible(false);
        indirizzoCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        indirizzoCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        indirizzoCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.addrNotValid());
        warningLabelsPanel.add(indirizzoCheckLabel);

        mainGridPanel.add(warningLabelsPanel);

        jPanel3.add(mainGridPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        lowPanel.setOpaque(false);
        lowPanel.setPreferredSize(new java.awt.Dimension(600, 120));
        lowPanel.setLayout(new java.awt.BorderLayout());

        passwordPanel.setOpaque(false);
        passwordPanel.setLayout(new java.awt.GridLayout(1, 5));

        passwordLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        passwordLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.passswordR());
        passwordPanel.add(passwordLabel);

        passwordTextField.setPreferredSize(new java.awt.Dimension(180, 30));
        passwordPanel.add(passwordTextField);

        controlloLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        controlloLabel.setForeground(new java.awt.Color(255, 255, 255));
        controlloLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        controlloLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.passwordCheck());
        passwordPanel.add(controlloLabel);

        controlloTextField.setPreferredSize(new java.awt.Dimension(180, 30));
        passwordPanel.add(controlloTextField);

        passwordCheckLabel.setVisible(false);
        passwordCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        passwordCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        passwordCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.passwordNotValid());
        passwordPanel.add(passwordCheckLabel);

        lowPanel.add(passwordPanel, java.awt.BorderLayout.NORTH);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setPreferredSize(new java.awt.Dimension(900, 100));
        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        registerNewUserButton.setText(emotionalsongs.EmotionalSongs.dialoghi.registrer());
        registerNewUserButton.setPreferredSize(new java.awt.Dimension(180, 60));
        registerNewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNewUserButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 28, 0, 28);
        buttonsPanel.add(registerNewUserButton, gridBagConstraints);

        closeButton.setText(emotionalsongs.EmotionalSongs.dialoghi.close());
        closeButton.setPreferredSize(new java.awt.Dimension(180, 60));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 24, 0, 24);
        buttonsPanel.add(closeButton, gridBagConstraints);

        lowPanel.add(buttonsPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(lowPanel, java.awt.BorderLayout.PAGE_END);

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        mainWindow.cleanUpMainPanel();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void registerNewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNewUserButtonActionPerformed
        setAllCheckOff();
        boolean okData = false;
        try {
            okData = checkData();
            int okUpdate = 1;
            if(okData){
                okUpdate = dataHandler.requestToUpdateUsersTable(
                     idTextField.getText(),
                      mailTextField.getText(),
                        cfTextField.getText(),
                    String.valueOf(passwordTextField.getPassword()),
                       nomeTextField.getText(),
                     cognomeTextField.getText(), 
                  birthdayTextField.getText(),
                   addressTextField.getText()
                );
            } else {
                return;
            }
            if(okUpdate == 1){
                System.out.println("Error! impossible to register the new user: internal errors occurred!");
            } else {
                //i obtain the containing frame and close it and then this panel.
                WelcomeMailSender.sendMailToNewUser(
                        nomeTextField.getText(), 
                        cognomeTextField.getText(), 
                        birthdayTextField.getText(), 
                        cfTextField.getText(),
                        addressTextField.getText(),
                        mailTextField.getText(),
                        idTextField.getText(), 
                        String.valueOf(passwordTextField.getPassword())
                    ); // manda mail di benvenuto al nuovo utente con i suoi dati inseriti.
                ((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
            }
        }catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_registerNewUserButtonActionPerformed
    
    private void setAllCheckOff(){
        cfCheckLabel.setVisible(false);
        cfCheckLabel.setVisible(false);
        nomeCheckLabel.setVisible(false);
        cognomeCheckLabel.setVisible(false);
        indirizzoCheckLabel.setVisible(false);
        mailCheckLabel.setVisible(false);
        passwordCheckLabel.setVisible(false);
        idUserCheckLabel.setVisible(false);   
    }
    
    private boolean checkData() throws RemoteException{
        String idUser,email,cf,password,controlpswd,nome,cognome,birthday,indirizzo;
        idUser = idTextField.getText();
        email = mailTextField.getText();
        cf = cfTextField.getText();
        password = String.copyValueOf(passwordTextField.getPassword());
        controlpswd = String.copyValueOf(controlloTextField.getPassword());
        nome = nomeTextField.getText();
        cognome = cognomeTextField.getText();
        birthday = birthdayTextField.getText();
        indirizzo = addressTextField.getText();
        
        boolean[] booleani = dataValidator.validateNewUserData(idUser, email, cf, password, controlpswd, nome, cognome, birthday, indirizzo);
        boolean allOk = true;
        //advises if user id is not valid
        if(booleani[0]) {
           idUserCheckLabel.setText(EmotionalSongs.dialoghi.userIdNotValid());
           idUserCheckLabel.setVisible(true);
           allOk = false;
        }
        //advises if user id is taken
        if(booleani[1]){
           idUserCheckLabel.setText(EmotionalSongs.dialoghi.userIdTaken());
           idUserCheckLabel.setVisible(true);
           allOk = false;
        }
        //advises if cf is not valid
        if(booleani[2]){
            cfCheckLabel.setText(EmotionalSongs.dialoghi.invalidCf());
            cfCheckLabel.setVisible(true);
            allOk = false;
        }
        //advises if cf is already present
        if(booleani[3]){
            cfCheckLabel.setText(EmotionalSongs.dialoghi.cfIsPresentYet());
            cfCheckLabel.setVisible(true);
            allOk = false;
        }
        //advises if password isn't valid
        if(booleani[4]){
            passwordCheckLabel.setText(EmotionalSongs.dialoghi.passwordNotValid());
            passwordCheckLabel.setVisible(true);
            allOk = false;
        }
        //advises if passwords don't match
        if(booleani[5]){
            passwordCheckLabel.setText(EmotionalSongs.dialoghi.passwordsNotMatching());
            passwordCheckLabel.setVisible(true);
            allOk = false;
        }
        //check if name isn't valid
        if(booleani[6]){
            nomeCheckLabel.setText(EmotionalSongs.dialoghi.nameNotValid());
            nomeCheckLabel.setVisible(true);
            allOk = false;
        }
        //check id surname is not valid
        if(booleani[7]){
            cognomeCheckLabel.setText(EmotionalSongs.dialoghi.notValidSurname());
            cognomeCheckLabel.setVisible(true);
            allOk = false;
        }
        //check if birthday is valid
        if(booleani[8]){
            dataDiNascitaCheckLabel.setText(EmotionalSongs.dialoghi.invalidBirthDate());
            dataDiNascitaCheckLabel.setVisible(true);
            allOk = false;
        }
        //check if address is valid
        if(booleani[9]){
            indirizzoCheckLabel.setText(EmotionalSongs.dialoghi.addrNotValid());
            indirizzoCheckLabel.setVisible(true);
            allOk = false;
        }
        
        //update view
        revalidate();
        repaint();
        
        return allOk;
    }
    /*
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(600, 800);
        ServicesBox sb = ServicesBox.getInstance();
        frame.add(
                new RegistrationPanel(
                    (UsersDataHandler) sb.getService(ServicesBox.USERS_DATA_HANDLER),
                    (UsersDataValidator)sb.getService(ServicesBox.USERS_DATA_VALIDATOR),
                    MainFrame.getIstance()
                )
            );
        frame.setVisible(true);
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IndirizzoTextLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField birthdayTextField;
    private javax.swing.JPanel buttonsPanel;
    public javax.swing.JLabel cfCheckLabel;
    private javax.swing.JLabel cfLabel;
    private javax.swing.JTextField cfTextField;
    private javax.swing.JButton closeButton;
    public javax.swing.JLabel cognomeCheckLabel;
    private javax.swing.JLabel cognomeLabel;
    private javax.swing.JTextField cognomeTextField;
    private javax.swing.JLabel controlloLabel;
    private javax.swing.JPasswordField controlloTextField;
    public javax.swing.JLabel dataDiNascitaCheckLabel;
    private javax.swing.JLabel dataDiNascitaLabel;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    public javax.swing.JLabel idUserCheckLabel;
    public javax.swing.JLabel indirizzoCheckLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel labelsPanel;
    private javax.swing.JPanel lowPanel;
    public javax.swing.JLabel mailCheckLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JPanel mainGridPanel;
    private javax.swing.JPanel mainPanel;
    public javax.swing.JLabel nomeCheckLabel;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    public javax.swing.JLabel passwordCheckLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton registerNewUserButton;
    private javax.swing.JPanel textFieldsLabel;
    private javax.swing.JPanel warningLabelsPanel;
    // End of variables declaration//GEN-END:variables
}
