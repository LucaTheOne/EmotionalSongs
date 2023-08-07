/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.gui.registration;

import emotionalsongs.*;
import emotionalsongs.gui.main_window.*;
import java.awt.*;
import java.rmi.*;
import javax.swing.*;
import serverES.services_common_interfaces.data_handler.*;
import serverES.services_common_interfaces.data_validator.*;

/**
 * Classe le cui istanze sono dei form per la registrazione di un nuovo utente.
 */
public class RegistrationPanel extends javax.swing.JPanel {
    
    private final MainFrame mainWindow = MainFrame.getIstance();
    private final UsersDataHandler dataHandler;
    private final UsersDataValidator dataValidator;
    private String tipoVia;
    /**
     * Crea form di registrazione gestito dal manager passato come argomento.
     * @param manager manager di gestione della registrazione.
     */
    public RegistrationPanel(UsersDataHandler dataHandlerService, UsersDataValidator dataValidatorService) {
        dataHandler = dataHandlerService;
        dataValidator = dataValidatorService;
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
                g2.drawImage(Utilities.regBG.getImage(), 0, 0, getWidth(), getHeight(), null);
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
        voidLabel = new javax.swing.JLabel();
        IndirizzoTextLabel = new javax.swing.JLabel();
        nazioneLabel = new javax.swing.JLabel();
        regioneTextLabel = new javax.swing.JLabel();
        cittàTextLabel = new javax.swing.JLabel();
        capLabel = new javax.swing.JLabel();
        textFieldsLabel = new javax.swing.JPanel();
        nomeTextField = new javax.swing.JTextField();
        cognomeTextField = new javax.swing.JTextField();
        dataNascitaPanel = new javax.swing.JPanel();
        dayTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        monthTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        yearTextField = new javax.swing.JTextField();
        cfTextField = new javax.swing.JTextField();
        mailTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        tipoViaPanel = new javax.swing.JPanel();
        viaRB = new javax.swing.JRadioButton();
        vialeRB = new javax.swing.JRadioButton();
        corsoRB = new javax.swing.JRadioButton();
        piazzaRB = new javax.swing.JRadioButton();
        IndirizzoPanel = new javax.swing.JPanel();
        civicoTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        indirizzoTextField = new javax.swing.JTextField();
        nazioneTextLabel = new javax.swing.JTextField();
        regioneTextField = new javax.swing.JTextField();
        cittaTextField = new javax.swing.JTextField();
        capTextField = new javax.swing.JTextField();
        warningLabelsPanel = new javax.swing.JPanel();
        nomeCheckLabel = new javax.swing.JLabel();
        cognomeCheckLabel = new javax.swing.JLabel();
        dataDiNascitaCheckLabel = new javax.swing.JLabel();
        cfCheckLabel = new javax.swing.JLabel();
        mailCheckLabel = new javax.swing.JLabel();
        idCheckLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        indirizzoCheckLabel = new javax.swing.JLabel();
        lowPanel = new javax.swing.JPanel();
        passwordPanel = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        controlloLabel = new javax.swing.JLabel();
        controlloTextField = new javax.swing.JPasswordField();
        passwordCheckLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        registratiButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 600));
        setLayout(new java.awt.BorderLayout());

        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        iconPanel.setOpaque(false);
        iconPanel.setPreferredSize(new java.awt.Dimension(100, 220));
        iconPanel.setLayout(new java.awt.GridLayout(1, 3));
        iconPanel.add(jLabel1);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(Utilities.regIcon);
        iconPanel.add(jLabel3);
        iconPanel.add(jLabel2);

        jPanel3.add(iconPanel, java.awt.BorderLayout.PAGE_START);

        mainGridPanel.setOpaque(false);
        mainGridPanel.setLayout(new java.awt.GridLayout(1, 3));

        labelsPanel.setOpaque(false);
        labelsPanel.setLayout(new java.awt.GridLayout(12, 1));

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

        voidLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        voidLabel.setForeground(new java.awt.Color(255, 255, 255));
        voidLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        voidLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(voidLabel);

        IndirizzoTextLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        IndirizzoTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        IndirizzoTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        IndirizzoTextLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.name());
        IndirizzoTextLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(IndirizzoTextLabel);

        nazioneLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        nazioneLabel.setForeground(new java.awt.Color(255, 255, 255));
        nazioneLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nazioneLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.name());
        nazioneLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(nazioneLabel);

        regioneTextLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        regioneTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        regioneTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        regioneTextLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.name());
        regioneTextLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(regioneTextLabel);

        cittàTextLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cittàTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        cittàTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cittàTextLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.name());
        cittàTextLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(cittàTextLabel);
        labelsPanel.add(capLabel);

        mainGridPanel.add(labelsPanel);

        textFieldsLabel.setOpaque(false);
        textFieldsLabel.setLayout(new java.awt.GridLayout(12, 1));

        nomeTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(nomeTextField);

        cognomeTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(cognomeTextField);

        dayTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dayTextField.setText("dd");
        dataNascitaPanel.add(dayTextField);

        jLabel4.setText("/");
        dataNascitaPanel.add(jLabel4);

        monthTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        monthTextField.setText("mm");
        dataNascitaPanel.add(monthTextField);

        jLabel5.setText("/");
        dataNascitaPanel.add(jLabel5);

        yearTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearTextField.setText("yyyy");
        dataNascitaPanel.add(yearTextField);

        textFieldsLabel.add(dataNascitaPanel);

        cfTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(cfTextField);

        mailTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(mailTextField);

        idTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(idTextField);

        viaRB.setSelected(true);
        viaRB.setText("via");
        viaRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaRBActionPerformed(evt);
            }
        });
        tipoViaPanel.add(viaRB);

        vialeRB.setText("viale");
        tipoViaPanel.add(vialeRB);

        corsoRB.setText("corso");
        tipoViaPanel.add(corsoRB);

        piazzaRB.setText("piazza");
        tipoViaPanel.add(piazzaRB);

        textFieldsLabel.add(tipoViaPanel);

        IndirizzoPanel.setLayout(new java.awt.BorderLayout());
        IndirizzoPanel.add(civicoTextField, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("num.");
        jPanel2.add(jLabel6, java.awt.BorderLayout.LINE_END);
        jPanel2.add(indirizzoTextField, java.awt.BorderLayout.CENTER);

        IndirizzoPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        textFieldsLabel.add(IndirizzoPanel);
        textFieldsLabel.add(nazioneTextLabel);

        regioneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regioneTextFieldActionPerformed(evt);
            }
        });
        textFieldsLabel.add(regioneTextField);
        textFieldsLabel.add(cittaTextField);
        textFieldsLabel.add(capTextField);

        mainGridPanel.add(textFieldsLabel);

        warningLabelsPanel.setOpaque(false);
        warningLabelsPanel.setLayout(new java.awt.GridLayout(12, 1));

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

        idCheckLabel.setVisible(false);
        idCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        idCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        idCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.userIdNotValid());
        warningLabelsPanel.add(idCheckLabel);
        warningLabelsPanel.add(jPanel1);

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

        registratiButton.setText(emotionalsongs.EmotionalSongs.dialoghi.registrer());
        registratiButton.setPreferredSize(new java.awt.Dimension(180, 60));
        registratiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registratiButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 28, 0, 28);
        buttonsPanel.add(registratiButton, gridBagConstraints);

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

    private void registratiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registratiButtonActionPerformed
        
    }//GEN-LAST:event_registratiButtonActionPerformed

    private void regioneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regioneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regioneTextFieldActionPerformed

    private void viaRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viaRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viaRBActionPerformed
    
    public void setAllCheckOff(){
        cfCheckLabel.setVisible(false);
        cfCheckLabel.setVisible(false);
        nomeCheckLabel.setVisible(false);
        cognomeCheckLabel.setVisible(false);
        indirizzoCheckLabel.setVisible(false);
        mailCheckLabel.setVisible(false);
        passwordCheckLabel.setVisible(false);
        idCheckLabel.setVisible(false);   
    }
    
    private boolean checkData() throws RemoteException{
        String idUser,email,cf,password,controlpswd,nome,cognome,tipoInd,indirizzo,nazione,provincia,città;
        int ddNascita,mmNascita,yyyyNascita,civico,cap;
        idUser = idTextField.getText();
        email = mailTextField.getText();
        cf = capTextField.getText();
        password = String.copyValueOf(passwordTextField.getPassword());
        controlpswd = String.copyValueOf(controlloTextField.getPassword());
        nome = nomeTextField.getText();
        cognome = cognomeTextField.getText();
        ddNascita = Integer.parseInt(dayTextField.getText());
        mmNascita = Integer.parseInt(monthTextField.getText());
        yyyyNascita = Integer.parseInt(yearTextField.getText());
        tipoInd = getTipoVia();
        indirizzo = indirizzoTextField.getText();
        civico = Integer.parseInt(civicoTextField.getText());
        cap = Integer.parseInt(capTextField.getText());
        nazione = nazioneTextLabel.getText();
        provincia = regioneTextLabel.getText();
        città = cittaTextField.getText();
        
        boolean[] booleani = dataValidator.validateNewUserData(idUser, email, cf, password, controlpswd, nome, cognome, tipoInd, indirizzo, civico, cap, nazione, provincia, città);
        if(!booleani[0]){
            
        }
    }
    
    private String getTipoVia(){
        if(viaRB.isSelected()) return "via";
        else if (vialeRB.isSelected()) return "viale";
        else if (corsoRB.isSelected()) return "corso";
        else if (piazzaRB.isSelected()) return "piazza";
        else return "via";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IndirizzoPanel;
    private javax.swing.JLabel IndirizzoTextLabel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel capLabel;
    private javax.swing.JTextField capTextField;
    public javax.swing.JLabel cfCheckLabel;
    private javax.swing.JLabel cfLabel;
    private javax.swing.JTextField cfTextField;
    private javax.swing.JTextField cittaTextField;
    private javax.swing.JLabel cittàTextLabel;
    private javax.swing.JTextField civicoTextField;
    private javax.swing.JButton closeButton;
    public javax.swing.JLabel cognomeCheckLabel;
    private javax.swing.JLabel cognomeLabel;
    private javax.swing.JTextField cognomeTextField;
    private javax.swing.JLabel controlloLabel;
    private javax.swing.JPasswordField controlloTextField;
    private javax.swing.JRadioButton corsoRB;
    public javax.swing.JLabel dataDiNascitaCheckLabel;
    private javax.swing.JLabel dataDiNascitaLabel;
    private javax.swing.JPanel dataNascitaPanel;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JPanel iconPanel;
    public javax.swing.JLabel idCheckLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    public javax.swing.JLabel indirizzoCheckLabel;
    private javax.swing.JTextField indirizzoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel labelsPanel;
    private javax.swing.JPanel lowPanel;
    public javax.swing.JLabel mailCheckLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JPanel mainGridPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JLabel nazioneLabel;
    private javax.swing.JTextField nazioneTextLabel;
    public javax.swing.JLabel nomeCheckLabel;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    public javax.swing.JLabel passwordCheckLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JRadioButton piazzaRB;
    private javax.swing.JTextField regioneTextField;
    private javax.swing.JLabel regioneTextLabel;
    private javax.swing.JButton registratiButton;
    private javax.swing.JPanel textFieldsLabel;
    private javax.swing.JPanel tipoViaPanel;
    private javax.swing.JRadioButton viaRB;
    private javax.swing.JRadioButton vialeRB;
    private javax.swing.JLabel voidLabel;
    private javax.swing.JPanel warningLabelsPanel;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
