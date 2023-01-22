//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.gui.registration;

import emotionalsongs.*;
import emotionalsongs.gui.main_window.*;
import emotionalsongs.managers.*;
import java.awt.*;
import javax.swing.*;

/**
 * Classe le cui istanze sono dei form per la registrazione di un nuovo utente.
 */
public class RegistrationPanel extends javax.swing.JPanel {
    
    private MainFrame mainWindow = MainFrame.getIstance();
    private RegistrationManager manager;
    /**
     * Crea form di registrazione gestito dal manager passato come argomento.
     * @param manager manager di gestione della registrazione.
     */
    public RegistrationPanel(RegistrationManager manager) {
        this.manager = manager;
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
        indirizzoLabel = new javax.swing.JLabel();
        dataDiNascitaLabel = new javax.swing.JLabel();
        cfLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        textFieldsLabel = new javax.swing.JPanel();
        nomeTextField = new javax.swing.JTextField();
        cognomeTextField = new javax.swing.JTextField();
        indirizzoTextField = new javax.swing.JTextField();
        dataDiNascitaTextField = new javax.swing.JTextField();
        cfTextField = new javax.swing.JTextField();
        mailTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        warningLabelsPanel = new javax.swing.JPanel();
        nomeCheckLabel = new javax.swing.JLabel();
        cognomeCheckLabel = new javax.swing.JLabel();
        indirizzoCheckLabel = new javax.swing.JLabel();
        dataDiNascitaCheckLabel = new javax.swing.JLabel();
        cfCheckLabel = new javax.swing.JLabel();
        mailCheckLabel = new javax.swing.JLabel();
        idCheckLabel = new javax.swing.JLabel();
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
        iconPanel.setPreferredSize(new java.awt.Dimension(100, 250));
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
        cognomeLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.cognome());
        cognomeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(cognomeLabel);

        indirizzoLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        indirizzoLabel.setForeground(new java.awt.Color(255, 255, 255));
        indirizzoLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        indirizzoLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.indirizzo());
        indirizzoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(indirizzoLabel);

        dataDiNascitaLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        dataDiNascitaLabel.setForeground(new java.awt.Color(255, 255, 255));
        dataDiNascitaLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dataDiNascitaLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.dataNascita());
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
        idLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.userid());
        idLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelsPanel.add(idLabel);

        mainGridPanel.add(labelsPanel);

        textFieldsLabel.setOpaque(false);
        textFieldsLabel.setLayout(new java.awt.GridLayout(7, 1));

        nomeTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(nomeTextField);

        cognomeTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(cognomeTextField);

        indirizzoTextField.setPreferredSize(new java.awt.Dimension(400, 30));
        textFieldsLabel.add(indirizzoTextField);

        dataDiNascitaTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        dataDiNascitaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDiNascitaTextFieldActionPerformed(evt);
            }
        });
        textFieldsLabel.add(dataDiNascitaTextField);

        cfTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(cfTextField);

        mailTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(mailTextField);

        idTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        textFieldsLabel.add(idTextField);

        mainGridPanel.add(textFieldsLabel);

        warningLabelsPanel.setOpaque(false);
        warningLabelsPanel.setLayout(new java.awt.GridLayout(7, 1));

        nomeCheckLabel.setVisible(false);
        nomeCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        nomeCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        nomeCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.nomeNon());
        warningLabelsPanel.add(nomeCheckLabel);

        cognomeCheckLabel.setVisible(false);
        cognomeCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        cognomeCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        cognomeCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.cognomeNon());
        warningLabelsPanel.add(cognomeCheckLabel);

        indirizzoCheckLabel.setVisible(false);
        indirizzoCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        indirizzoCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        indirizzoCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.indirizzoNon());
        warningLabelsPanel.add(indirizzoCheckLabel);

        dataDiNascitaCheckLabel.setVisible(false);
        dataDiNascitaCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        dataDiNascitaCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        dataDiNascitaCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.dataNasciataNon());
        warningLabelsPanel.add(dataDiNascitaCheckLabel);

        cfCheckLabel.setVisible(false);
        cfCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        cfCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        cfCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.cfNon());
        warningLabelsPanel.add(cfCheckLabel);

        mailCheckLabel.setVisible(false);
        mailCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        mailCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        mailCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.emailNon());
        warningLabelsPanel.add(mailCheckLabel);

        idCheckLabel.setVisible(false);
        idCheckLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        idCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        idCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.useridNon());
        warningLabelsPanel.add(idCheckLabel);

        mainGridPanel.add(warningLabelsPanel);

        jPanel3.add(mainGridPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        lowPanel.setOpaque(false);
        lowPanel.setPreferredSize(new java.awt.Dimension(600, 150));
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
        passwordCheckLabel.setText(emotionalsongs.EmotionalSongs.dialoghi.passwordNon());
        passwordPanel.add(passwordCheckLabel);

        lowPanel.add(passwordPanel, java.awt.BorderLayout.NORTH);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setPreferredSize(new java.awt.Dimension(900, 120));
        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        registratiButton.setText(emotionalsongs.EmotionalSongs.dialoghi.registrati());
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

        closeButton.setText(emotionalsongs.EmotionalSongs.dialoghi.chiudi());
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
        exportToManager();
        manager.startRegistration();
    }//GEN-LAST:event_registratiButtonActionPerformed

    private void dataDiNascitaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDiNascitaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataDiNascitaTextFieldActionPerformed
    
    public void setAllCheckOff(){
        cfCheckLabel.setVisible(false);
        cfCheckLabel.setText("Codice fiscale non valido!");cfCheckLabel.setVisible(false);
        nomeCheckLabel.setVisible(false);
        cognomeCheckLabel.setVisible(false);
        indirizzoCheckLabel.setVisible(false);
        mailCheckLabel.setVisible(false);
        passwordCheckLabel.setVisible(false);
        idCheckLabel.setVisible(false);
        
    }
    
    public void exportToManager(){
        manager.userId = idTextField.getText();
        manager.name = nomeTextField.getText();
        manager.secondName = cognomeTextField.getText();
        manager.fiscalCode = cfTextField.getText();
        manager.address = indirizzoTextField.getText();
        manager.email = mailTextField.getText();
        manager.password = String.valueOf(passwordTextField.getPassword());
        manager.passwordControl = String.valueOf(controlloTextField.getPassword());
        manager.birthDay = dataDiNascitaTextField.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField dataDiNascitaTextField;
    private javax.swing.JPanel iconPanel;
    public javax.swing.JLabel idCheckLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    public javax.swing.JLabel indirizzoCheckLabel;
    private javax.swing.JLabel indirizzoLabel;
    private javax.swing.JTextField indirizzoTextField;
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
    private javax.swing.JButton registratiButton;
    private javax.swing.JPanel textFieldsLabel;
    private javax.swing.JPanel warningLabelsPanel;
    // End of variables declaration//GEN-END:variables
}
