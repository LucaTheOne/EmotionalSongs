/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.gui.main_window;


import java.awt.*;
import javax.swing.*;

/**
 * 
 * Classe che rappresenta la finestra principale del software ed anche l' unica fissa in quanto ,nonostante 
 * i suoi pannelli interni possano variare, essendo una classe di tipo singleton esiste una sola istanza possibile di essa.
 * Ciò è dovuto al fatto che ci sono vari aspetti che necessitano che l' interfaccia grafica a cui fanno riferimento sia sempre la stessa.
 *
 * <ul>
 * <li> Pannello laterale sinistro che può assumere tre forme, in base che sia invisibile, di un utente loggato, di un utente non loggato </li>
 * <li> Pannello superiore le cui funzionalità variano a seconda che l' utente sia loggato o meno </li>
 * <li> una barra inferiore con una manciata di informazioni sul produttore del software </li>
 * <li> Il panello centrale, gestito principalmente dai manager, che varia più spesso degli altri, sulla base delle azioni dell' utente</li>
 * </ul>
 */
public class MainFrame extends javax.swing.JFrame {

    
    private static MainFrame instance = null;
    private boolean leftMenuOpened = false;
    /**
     * Metodo che permette di accedere alla istanza unica della finestra principale.
     */
    private MainFrame() {
        
        initComponents();
        setLeftPanel(new MenuLeftVoid(this));
        setUpperBar(new UpperBarUnloggedPanel(this));
    }
    
    public static MainFrame getIstance(){
        if(instance==null) instance = new MainFrame();
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        globalPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(emotionalsongs.clientES.client_internal_services.ClientUtilities.mainBackGround.getImage(), 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }
        };
        leftPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        upperBar = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        lowerBarStatusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EmotionalSongs");
        setAutoRequestFocus(false);
        setIconImage(emotionalsongs.clientES.client_internal_services.ClientUtilities.logo.getImage());
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("mainPageFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setSize(new java.awt.Dimension(1000, 700));

        globalPanel.setLayout(new java.awt.BorderLayout());

        leftPanel.setPreferredSize(new java.awt.Dimension(0, 659));
        leftPanel.setLayout(new java.awt.BorderLayout());
        globalPanel.add(leftPanel, java.awt.BorderLayout.WEST);

        rightPanel.setPreferredSize(new java.awt.Dimension(0, 659));
        rightPanel.setLayout(new java.awt.BorderLayout());
        globalPanel.add(rightPanel, java.awt.BorderLayout.EAST);

        upperBar.setPreferredSize(new java.awt.Dimension(1000, 0));
        upperBar.setLayout(new java.awt.BorderLayout());
        globalPanel.add(upperBar, java.awt.BorderLayout.NORTH);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());
        globalPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        lowerBarStatusLabel.setBackground(new java.awt.Color(0, 0, 0));
        lowerBarStatusLabel.setForeground(new java.awt.Color(255, 255, 255));
        lowerBarStatusLabel.setText("      EmotionalSongs- v2.0 - Progetto di Laboratorio Interdisciplinare – A.A. 2022-23");
        lowerBarStatusLabel.setOpaque(true);
        globalPanel.add(lowerBarStatusLabel, java.awt.BorderLayout.SOUTH);
        lowerBarStatusLabel.getAccessibleContext().setAccessibleName("LowerBarStatusLabel");

        getContentPane().add(globalPanel, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel globalPanel;
    public javax.swing.JPanel leftPanel;
    private javax.swing.JLabel lowerBarStatusLabel;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JPanel rightPanel;
    public javax.swing.JPanel upperBar;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Metodo per aggiornare l' aspetto della gui
     */
    public void updateView() {
        revalidate();
        repaint();
    }
    /**
     * Metodo per modificare il pannello laterale sinistro, inserendo quello passato come argomento.
     * @param newLeftPanel pannello dlaterale che andrà a sostituire quello vecchio.
     */
    public void setLeftPanel(JPanel newLeftPanel){
        leftPanel.removeAll();
        leftPanel.setPreferredSize(new Dimension(newLeftPanel.getPreferredSize()));
        leftPanel.add(newLeftPanel,BorderLayout.CENTER);
        leftPanel.revalidate();
        leftPanel.repaint();
    }
    /**
     * Metodo per modificare il pannello superiore, inserendo quello passato come argomento.
     * @param newUpperBar Barra superiore che andrà a sostituire quello vecchia.
     */
    public void setUpperBar(JPanel newUpperBar){
        upperBar.removeAll();
        upperBar.setPreferredSize(new Dimension(newUpperBar.getPreferredSize()));
        upperBar.add(newUpperBar,BorderLayout.CENTER);
        upperBar.revalidate();
        upperBar.repaint(); 
    }
    /**
     * Metodo per aggiornare il contenuto del pannello principale.
     * @param content Contenuto da mostrare nel panello principale.
     */
    public void setMainPanel(JPanel content){
        cleanUpMainPanel();
        mainPanel.add(content,BorderLayout.CENTER);
        mainPanel.setOpaque(true);
        content.setVisible(true);
        revalidate();
        repaint(); 
    }
    /**
     * Metodo per ripulire il pannello principale.
     */
    public void cleanUpMainPanel(){
        mainPanel.removeAll();
        mainPanel.setOpaque(false);
        revalidate();
        repaint();
    }
    /**
     * metodo utilizzato per ricostruire la view in caso di cambio di lingua.
     */
    public void restartView() {
        instance.dispose();
        instance = new MainFrame();
        instance.setVisible(true);
    }
    
    /**
     * Metodo che setta il flag del menu sinistro come aperto.
     */
    public void setMenuOpened(){
        leftMenuOpened = true;
    }
    /**
     * Metodo che setta il flag del menù sinistro come chiuso.
     */
    public void setMenuClosed(){
        leftMenuOpened = false;
    }
    /**
     * Metodo che riporta il flag del menù sinistro.
     * @return true se il menù è aperto, false altrimenti.
     */
    public boolean getIfLeftOpened(){
        return leftMenuOpened;
    }

}
