/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */
package emotionalsongs.clientES;

import emotionalsongs.*;
import emotionalsongs.clientES.gui.generics.*;
import emotionalsongs.clientES.gui.main_window.*;
/**
 *
 * @author big
 */
public class ClientInitializer extends javax.swing.JFrame{
    
    private InitializationFrame initFrame;
    
    /**
     * Creates new form RequestServiceHostFrame
     */
    public ClientInitializer() {
        initFrame = new InitializationFrame();
        initFrame.setVisible(true);
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainInnerPanel = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        hostText = new javax.swing.JTextField();
        portText = new javax.swing.JTextField();
        hostLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        connectButton.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        connectButton.setText(EmotionalSongs.dialoghi.tryConnectToService());
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        hostText.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        hostText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        portText.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        portText.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        hostLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        hostLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostLabel.setText(EmotionalSongs.dialoghi.hostServiceLabel());

        portLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        portLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        portLabel.setText(EmotionalSongs.dialoghi.portLabel());

        jButton1.setText(EmotionalSongs.dialoghi.exit());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainInnerPanelLayout = new javax.swing.GroupLayout(mainInnerPanel);
        mainInnerPanel.setLayout(mainInnerPanelLayout);
        mainInnerPanelLayout.setHorizontalGroup(
            mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainInnerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(portText)
                    .addComponent(hostText)
                    .addComponent(hostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addComponent(portLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainInnerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(mainInnerPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainInnerPanelLayout.setVerticalGroup(
            mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainInnerPanelLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(hostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hostText, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(4, 4, 4))
        );

        hostText.getAccessibleContext().setAccessibleDescription("");
        portText.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(mainInnerPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        boolean ok = true;
        String selectedHost = hostText.getText();
        String selectedPort = portText.getText();
        if(selectedHost.isBlank() || selectedHost.equalsIgnoreCase(EmotionalSongs.dialoghi.typeAnHostAddressError())){
            hostText.setText(EmotionalSongs.dialoghi.typeAnHostAddressError());
            ok = false;
            this.revalidate();
            this.repaint();
        }
        if(selectedPort.isBlank() || selectedPort.equalsIgnoreCase(EmotionalSongs.dialoghi.typeAPortError())){
            portText.setText(EmotionalSongs.dialoghi.typeAPortError());
            ok = false;
            this.revalidate();
            this.repaint();
        }
        if(ok) {
            ServicesProvider.singleton = new ServicesProvider(selectedHost, Integer.parseInt(selectedPort));
            initFrame.dispose();
            MainFrame.getIstance().setVisible(true);
            dispose();
        }else{
            System.out.println("impossible to find services!");
        }    
    }//GEN-LAST:event_connectButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //public static void main(String[] args) throws RemoteException {
        //try {
            //new ClientInitializer();
            
            /*
            Registry registryServices = LocateRegistry.getRegistry("192.168.1.6", 5432);
            SongsDataHandler dh = (SongsDataHandler) registryServices.lookup("songs_data_handler");
            System.out.println(dh.getRepoSize());
        //} catch (NotBoundException ex) {
            //System.out.println(ex.getMessage());
        //} catch (AccessException ex) {
            //System.out.println(ex.getMessage());
        //}*/
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JTextField hostText;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel mainInnerPanel;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portText;
    // End of variables declaration//GEN-END:variables

}
