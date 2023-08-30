/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */

package serverES;

import java.io.*;
import java.time.*;
import javax.swing.*;

/**
 * Classe il cui unico scopo è quello di permettere all' utenti di controllare il server,
 * fornendovi una basilare interfaccia grafica.
 * NB: il frame è reso subito visibile con l' instanziazione della classe.
 */
class ServerControlGUI extends javax.swing.JFrame {
    
    private String localAddress = "";
    private String globalAddress = "";
    private int port = 0;
    private Server serverToControl;
    public static ServerControlGUI serverControlGui = null;
    /**
     * Crea una nuova istanza di questa classe;
     * @param InetAddressServer Stringa con l' indirizzo ip della macchina corrente.
     * @param port Porta sul quale il registry è operativo.
     * @param server Riferimento al serverToControl che deve controllare.
     */
    protected ServerControlGUI(Server server) {
        this.serverToControl=server;
        initComponents();
    }
    
    protected void setGlobalAddress(String globalIPAddress) {
        this.globalAddress = globalIPAddress;
        IPGlobalLabel.setText(globalIPAddress);
        revalidate();
        repaint();
        setVisible(true);
    }
    
    protected void setLocalAddress(String addres,int port){
        this.localAddress = addres;
        this.port = port;
        IPLocalLabel.setText(localAddress);
        portLabel.setText(String.valueOf(port));
        revalidate();
        repaint();
        setVisible(true);
    }
    protected static ServerControlGUI obtainControlGuiReference(Server server){
        if(serverControlGui == null) serverControlGui = new ServerControlGUI(server);
        return serverControlGui;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        globalPanel = new javax.swing.JPanel();
        exitButtonPanel = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        dataPanel = new javax.swing.JPanel();
        ServiceDataInfo = new javax.swing.JPanel();
        localAddressLabel = new javax.swing.JLabel();
        IPLocalLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        globalAddressLabel = new javax.swing.JLabel();
        IPGlobalLabel = new javax.swing.JLabel();
        logAndExportButtonPanel = new javax.swing.JPanel();
        exportButtonPanel = new javax.swing.JPanel();
        ExportLogButton = new javax.swing.JButton();
        logPanel = new javax.swing.JPanel();
        ServerLogTerminal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        globalPanel.setBackground(new java.awt.Color(0, 0, 102));
        globalPanel.setLayout(new java.awt.BorderLayout(0, 4));

        exitButtonPanel.setOpaque(false);
        exitButtonPanel.setPreferredSize(new java.awt.Dimension(1000, 60));
        exitButtonPanel.setLayout(new java.awt.BorderLayout());

        ExitButton.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        ExitButton.setText("Close Server's Services");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        exitButtonPanel.add(ExitButton, java.awt.BorderLayout.CENTER);

        globalPanel.add(exitButtonPanel, java.awt.BorderLayout.PAGE_END);

        dataPanel.setOpaque(false);
        dataPanel.setPreferredSize(new java.awt.Dimension(1000, 300));
        dataPanel.setLayout(new java.awt.BorderLayout());

        ServiceDataInfo.setBackground(new java.awt.Color(255, 255, 255));
        ServiceDataInfo.setOpaque(false);

        localAddressLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        localAddressLabel.setForeground(new java.awt.Color(255, 255, 255));
        localAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        localAddressLabel.setText("Local address:");

        IPLocalLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 30)); // NOI18N
        IPLocalLabel.setForeground(new java.awt.Color(255, 255, 255));
        IPLocalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPLocalLabel.setText(localAddress);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Service's port:");

        portLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 30)); // NOI18N
        portLabel.setForeground(new java.awt.Color(255, 255, 255));
        portLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        portLabel.setText(String.valueOf(port));

        globalAddressLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        globalAddressLabel.setForeground(new java.awt.Color(255, 255, 255));
        globalAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        globalAddressLabel.setText("Global address:");

        IPGlobalLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 30)); // NOI18N
        IPGlobalLabel.setForeground(new java.awt.Color(255, 255, 255));
        IPGlobalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPGlobalLabel.setText(globalAddress);

        javax.swing.GroupLayout ServiceDataInfoLayout = new javax.swing.GroupLayout(ServiceDataInfo);
        ServiceDataInfo.setLayout(ServiceDataInfoLayout);
        ServiceDataInfoLayout.setHorizontalGroup(
            ServiceDataInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServiceDataInfoLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(ServiceDataInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IPGlobalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(globalAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IPLocalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 204, 204))
        );
        ServiceDataInfoLayout.setVerticalGroup(
            ServiceDataInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServiceDataInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(globalAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IPGlobalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IPLocalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataPanel.add(ServiceDataInfo, java.awt.BorderLayout.CENTER);

        globalPanel.add(dataPanel, java.awt.BorderLayout.PAGE_START);

        logAndExportButtonPanel.setOpaque(false);
        logAndExportButtonPanel.setLayout(new java.awt.BorderLayout());

        exportButtonPanel.setOpaque(false);
        exportButtonPanel.setPreferredSize(new java.awt.Dimension(200, 280));

        ExportLogButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        ExportLogButton.setText("Export log");
        ExportLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportLogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exportButtonPanelLayout = new javax.swing.GroupLayout(exportButtonPanel);
        exportButtonPanel.setLayout(exportButtonPanelLayout);
        exportButtonPanelLayout.setHorizontalGroup(
            exportButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportButtonPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(ExportLogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        exportButtonPanelLayout.setVerticalGroup(
            exportButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportButtonPanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(ExportLogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        logAndExportButtonPanel.add(exportButtonPanel, java.awt.BorderLayout.LINE_END);

        logPanel.setPreferredSize(new java.awt.Dimension(234, 70));
        logPanel.setLayout(new java.awt.BorderLayout());

        ServerLogTerminal.setBackground(new java.awt.Color(0, 0, 0));
        ServerLogTerminal.setLayout(new java.awt.BorderLayout());

        logTextArea.setBackground(new java.awt.Color(0, 0, 0));
        logTextArea.setColumns(20);
        logTextArea.setForeground(new java.awt.Color(255, 255, 255));
        logTextArea.setRows(5);
        logTextArea.setText("SERVER CONSOLE LOG STARTED: "+LocalDateTime.now().toString()+"\n"+"(output only)"+"\n");
        jScrollPane1.setViewportView(logTextArea);

        ServerLogTerminal.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        logPanel.add(ServerLogTerminal, java.awt.BorderLayout.CENTER);

        logAndExportButtonPanel.add(logPanel, java.awt.BorderLayout.CENTER);

        globalPanel.add(logAndExportButtonPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(globalPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExportLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportLogButtonActionPerformed
        exportAction(false);
    }//GEN-LAST:event_ExportLogButtonActionPerformed
    /**
     * Metodo il quale permette di esportare il contenuto del log in un file di testo.
     * Permette all' utente di sceglierne la destinazione.
     * Vi si può passare un parametro boolean il quale se è true fa si che questo frame venga chiuso.
     * @param dispose Se true chiude il corrente frame.
     */
    protected void exportAction(boolean dispose){
        addLineLog("Console: exporting current log...\n"+
                "Select where to export by the opened window");
        JFrame parentComponent = new JFrame();
        parentComponent.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // Some init code, if you need one, like setting title
        int returnValue = fileChooser.showOpenDialog(parentComponent);
        if ( returnValue == JFileChooser.APPROVE_OPTION) {
            String whereToSave = fileChooser.getSelectedFile().getAbsolutePath();
            File textFiles = new File(whereToSave + System.getProperty("file.separator") + "Report_"+LocalDateTime.now().toString()+".txt");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(textFiles));
                writer.write(logTextArea.getText());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                addLineLog("Error: impossible to generate report");
            }
            addLineLog("Report Exported!");
        } else{
            addLineLog("Error: impossible to generate report");
            if(dispose) dispose();
            System.exit(0);
            return;
        }
        if(dispose){
            dispose();
            System.exit(0);
        }
        
    }
    
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        serverToControl.terminateServices();
        addLineLog("All services shutted down!\n");
        new AskIfTOSaveLog(this);
        
    }//GEN-LAST:event_ExitButtonActionPerformed
    
    /**
     * Metodo tramite il quale si può aggiungere una riga di testo al log.
     * NB: ritorno a capo a fine riga incluso nel metodo.
     * @param stringToAddToLog Stringa da aggiungere al terminale.
     */
    protected void addLineLog(String stringToAddToLog){
        String tmp = logTextArea.getText();
        String formatted = LocalDateTime.now().toString()+":"+
                stringToAddToLog+"\n";
        tmp+=formatted;
        logTextArea.setText(tmp);
        logTextArea.validate();
        logTextArea.repaint();
    }
    
    protected void terminateAll(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton ExportLogButton;
    private javax.swing.JLabel IPGlobalLabel;
    private javax.swing.JLabel IPLocalLabel;
    private javax.swing.JPanel ServerLogTerminal;
    private javax.swing.JPanel ServiceDataInfo;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JPanel exitButtonPanel;
    private javax.swing.JPanel exportButtonPanel;
    private javax.swing.JLabel globalAddressLabel;
    private javax.swing.JPanel globalPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel localAddressLabel;
    private javax.swing.JPanel logAndExportButtonPanel;
    private javax.swing.JPanel logPanel;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JLabel portLabel;
    // End of variables declaration//GEN-END:variables

    
}
