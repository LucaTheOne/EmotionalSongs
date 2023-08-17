/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */



package emotionalsongs.gui.login;

import serverES.server_services_common_interfaces.data_validator.UsersDataValidator;
import emotionalsongs.client_internal_services.ClientUtilities;
import clientES.*;
import emotionalsongs.*;
import emotionalsongs.gui.main_window.*;
import java.awt.geom.*;
import java.rmi.*;

/**
 *Classe le cui istanze rappresentano il form di login.
 */
public class LoginFrame extends javax.swing.JFrame {
    private final MainFrame mainWindow;
    private final UsersDataValidator dataValidator;
    /**
     * Crea un form per il login.
     */
    public LoginFrame() {
        this.dataValidator = (UsersDataValidator) ServicesProvider.getInstance().getService(ServicesProvider.USERS_DATA_VALIDATOR);
        mainWindow = MainFrame.getIstance();
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
        jLabel1.setText(emotionalsongs.EmotionalSongs.dialoghi.userId());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 255, -1, 20));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 298, -1, -1));

        wrongId.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        wrongId.setForeground(new java.awt.Color(255, 51, 51));
        wrongId.setText(emotionalsongs.EmotionalSongs.dialoghi.userIdNotFound());
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
        jLabel3.setIcon(ClientUtilities.logingBG);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        wrongId.setVisible(false);
        wrongPassword.setVisible(false);
        try {
            boolean[] errors = dataValidator.validateLogin(idField.getText(), String.valueOf(passwordField.getPassword()));
            if(errors[0] == true){
                wrongId.setText(EmotionalSongs.dialoghi.userIdNotFound());
                wrongId.setVisible(true);
                revalidate();
                repaint();
                return;
            } else {
                if(errors[1] == true){
                    wrongPassword.setText(EmotionalSongs.dialoghi.passwordErr());
                    wrongPassword.setVisible(true);
                    revalidate();
                    repaint();
                    return;
                }
            }
            EmotionalSongs.setLoggedUser(idField.getText());
            //efficientare
            mainWindow.setLeftPanel(new MenuLeftLogged(mainWindow));
            mainWindow.setUpperBar(new UpperBarLoggedPanel(mainWindow));
            mainWindow.updateView();
            
            dispose();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }  
    }//GEN-LAST:event_loginButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed
    /*
    public static void main(String[] args) {
        JFrame frame = new LoginFrame((UsersDataValidator) ServicesBox.getInstance().getService(ServicesBox.USERS_DATA_VALIDATOR));
        frame.setVisible(true);
    }
    */
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
