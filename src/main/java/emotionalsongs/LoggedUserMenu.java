/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package emotionalsongs;

/**
 *
 * @author natanaild
 */
public class LoggedUserMenu extends javax.swing.JPanel {

    /**
     * Creates new form LoggedUserMenuButtonPanel
     */
    public LoggedUserMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoggedUserWestButtonsMenuPanel = new javax.swing.JPanel();
        Panel1 = new javax.swing.JPanel();
        ConsultaRepositoryButton = new javax.swing.JButton();
        Panel2 = new javax.swing.JPanel();
        LeMiePlaylistButton = new javax.swing.JButton();
        Panel3 = new javax.swing.JPanel();
        LogoutButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(160, 600));

        LoggedUserWestButtonsMenuPanel.setPreferredSize(new java.awt.Dimension(160, 600));
        LoggedUserWestButtonsMenuPanel.setLayout(new java.awt.GridLayout(8, 1));

        Panel1.setLayout(new java.awt.GridLayout(1, 0));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("emotionalsongs/Bundle"); // NOI18N
        ConsultaRepositoryButton.setText(bundle.getString("LoggedUserMenu.ConsultaRepositoryButton.text")); // NOI18N
        Panel1.add(ConsultaRepositoryButton);

        LoggedUserWestButtonsMenuPanel.add(Panel1);

        Panel2.setLayout(new java.awt.GridLayout(1, 0));

        LeMiePlaylistButton.setText(bundle.getString("LoggedUserMenu.LeMiePlaylistButton.text")); // NOI18N
        Panel2.add(LeMiePlaylistButton);

        LoggedUserWestButtonsMenuPanel.add(Panel2);

        Panel3.setLayout(new java.awt.GridLayout(1, 0));

        LogoutButton.setText(bundle.getString("LoggedUserMenu.LogoutButton.text")); // NOI18N
        Panel3.add(LogoutButton);

        LoggedUserWestButtonsMenuPanel.add(Panel3);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(LoggedUserWestButtonsMenuPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 600, Short.MAX_VALUE)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(LoggedUserWestButtonsMenuPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultaRepositoryButton;
    private javax.swing.JButton LeMiePlaylistButton;
    private javax.swing.JPanel LoggedUserWestButtonsMenuPanel;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    // End of variables declaration//GEN-END:variables
}