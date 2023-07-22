/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.gui.main_window;

/**
 * Classe le cui istanze sono pannelli incorporei ed invisibili.
 */
public class MenuLeftVoid extends javax.swing.JPanel {
    
    private MainFrame mainPage;
    /**
     * Crea un pannello incorporeo per la schermata principale, passata come argomento.
     * @param correlated Frame principale a cui il pannello è associato.
     */
    public MenuLeftVoid(MainFrame correlated) {
        mainPage = correlated;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(0, 300));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
