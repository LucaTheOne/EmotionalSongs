//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA



package emotionalsongs.gui.login;

import emotionalsongs.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.main_window.*;
import java.awt.*;
import java.awt.geom.*;

/**
 *Classe le cui istanze rappresentano il form di login.
 */
public class LoginFrame extends javax.swing.JFrame {
    private EngineLogger logger = new EngineLogger();
    private Image bg = Utilities.logingBG.getImage();
    private MainFrame mainWindow = MainFrame.getIstance();
    /**
     * Crea un form per il login.
     */
    public LoginFrame() {
        setAlwaysOnTop(true);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wrongId = new javax.swing.JLabel();
        wrongPassword = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setUndecorated(true);
        setResizable(false);
        setShape(new RoundRectangle2D.Double(0, 0, 400, 400, 20, 20));
        setSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButton.setText(emotionalsongs.EmotionalSongs.dialoghi.log());
        loginButton.setPreferredSize(new java.awt.Dimension(100, 40));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 339, -1, -1));

        idField.setPreferredSize(new java.awt.Dimension(150, 25));
        getContentPane().add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 253, -1, -1));

        passwordField.setPreferredSize(new java.awt.Dimension(150, 25));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 296, -1, -1));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(emotionalsongs.EmotionalSongs.dialoghi.idUtente());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 255, -1, 20));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 298, -1, -1));

        wrongId.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        wrongId.setForeground(new java.awt.Color(255, 51, 51));
        wrongId.setText(emotionalsongs.EmotionalSongs.dialoghi.idUtenteInes());
        wrongId.setVisible(false);
        getContentPane().add(wrongId, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 263, -1, -1));

        wrongPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        wrongPassword.setForeground(new java.awt.Color(255, 51, 51));
        wrongPassword.setText(emotionalsongs.EmotionalSongs.dialoghi.passwordErr());
        wrongPassword.setVisible(false);
        getContentPane().add(wrongPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 301, -1, -1));

        jButton1.setText(emotionalsongs.EmotionalSongs.dialoghi.exit());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 339, 100, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(Utilities.logingBG);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        logger.login(idField.getText(), String.valueOf(passwordField.getPassword()));
        if(!logger.idFounded){
            this.wrongId.setVisible(true);
            this.revalidate();
            this.repaint();
        }
        if(!logger.passwordMatches){
            this.wrongPassword.setVisible(true);
            this.revalidate();
            this.repaint();
        }
        if(logger.idFounded&&logger.passwordMatches){
            mainWindow.cleanUpMainPanel();
            mainWindow.setUpperBar(new UpperBarLoggedPanel(mainWindow));
            mainWindow.setLeftPanel(new MenuLeftLogged(mainWindow));
            dispose();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    public javax.swing.JPasswordField passwordField;
    public javax.swing.JLabel wrongId;
    public javax.swing.JLabel wrongPassword;
    // End of variables declaration//GEN-END:variables
}
