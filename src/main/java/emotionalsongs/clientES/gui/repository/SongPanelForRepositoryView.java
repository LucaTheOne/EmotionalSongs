/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.gui.repository;

import emotionalsongs.clientES.gui.data_visualizer.DataVisualizationForm;
import emotionalsongs.clientES.wrappers.Song;
import emotionalsongs.clientES.client_internal_services.ClientUtilities;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * Classe le cuyi istanze rappresentano graficamente una canzone.
 * Offrono i pulsanti per:
 * <ul>
 * <li>Mostrare i report della canzone rappresentata</li>
 * <li>Avviare la ricerca della canzone su youtube</li>
 * </ul>
 */
public class SongPanelForRepositoryView extends javax.swing.JPanel {

    
    private String representedSong;
    private String title,idUnique,author;
    private int year;
    private final String SEP = ClientUtilities.STRING_SEPARATOR;
    
    /**
     * Crea il pannello di rappresentazione della canzone passata come argomento.
     * @param representedSong Canzone rappresentata dal pannello.
     */
    public SongPanelForRepositoryView(String representedSong) {
        this.representedSong = representedSong;
        String[] splitted = representedSong.split(SEP);
        if(splitted.length!=5) System.out.println("Errore, stringa canzone non valida.");
        idUnique = splitted[0];
        //repo index isn't needed
        title = splitted[2];
        author = splitted[3];
        year = Integer.parseInt(splitted[4]);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AuthorYearLabels = new javax.swing.JPanel();
        authorLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        buttonsLabel = new javax.swing.JPanel();
        chartButton = new javax.swing.JButton();
        ytButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(720, 75));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(720, 75));
        setLayout(new java.awt.BorderLayout());

        labelPanel.setOpaque(false);
        labelPanel.setPreferredSize(new java.awt.Dimension(500, 60));
        labelPanel.setLayout(new java.awt.BorderLayout());

        titlePanel.setOpaque(false);
        titlePanel.setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 26)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText(title);
        titleLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        titlePanel.add(titleLabel, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(30, 49));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        titlePanel.add(jPanel1, java.awt.BorderLayout.LINE_START);

        labelPanel.add(titlePanel, java.awt.BorderLayout.CENTER);

        AuthorYearLabels.setOpaque(false);
        AuthorYearLabels.setPreferredSize(new java.awt.Dimension(150, 28));
        AuthorYearLabels.setLayout(new java.awt.BorderLayout());

        authorLabel.setForeground(new java.awt.Color(204, 204, 204));
        authorLabel.setText(author+"       "+String.valueOf(year));
        authorLabel.setPreferredSize(new java.awt.Dimension(400, 20));
        AuthorYearLabels.add(authorLabel, java.awt.BorderLayout.CENTER);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        AuthorYearLabels.add(jPanel2, java.awt.BorderLayout.LINE_START);

        labelPanel.add(AuthorYearLabels, java.awt.BorderLayout.SOUTH);

        add(labelPanel, java.awt.BorderLayout.CENTER);

        buttonsLabel.setOpaque(false);
        buttonsLabel.setPreferredSize(new java.awt.Dimension(150, 75));
        java.awt.GridBagLayout buttonsLabelLayout = new java.awt.GridBagLayout();
        buttonsLabelLayout.columnWidths = new int[] {0};
        buttonsLabelLayout.rowHeights = new int[] {0, 8, 0};
        buttonsLabel.setLayout(buttonsLabelLayout);

        chartButton.setText(emotionalsongs.EmotionalSongs.dialoghi.songData());
        chartButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        chartButton.setOpaque(true);
        chartButton.setPreferredSize(new java.awt.Dimension(125, 25));
        chartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        buttonsLabel.add(chartButton, gridBagConstraints);

        ytButton.setText("YT");
        ytButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        ytButton.setOpaque(true);
        ytButton.setPreferredSize(new java.awt.Dimension(125, 25));
        ytButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ytButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        buttonsLabel.add(ytButton, gridBagConstraints);

        add(buttonsLabel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void chartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartButtonActionPerformed
        new DataVisualizationForm(idUnique).setVisible(true);
    }//GEN-LAST:event_chartButtonActionPerformed

    private void ytButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ytButtonActionPerformed
        Desktop desktop = java.awt.Desktop.getDesktop();
            try {
                //specify the protocol along with the URL
		URI linkToYT = new URI(Song.buildResearchQueryUrl(title,author,year));
		desktop.browse(linkToYT);
            } catch (URISyntaxException e) {
		// TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_ytButtonActionPerformed

            @Override
            protected void paintComponent(Graphics g){
                Graphics g2 = g.create();
                g2.drawImage(ClientUtilities.SongViewIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AuthorYearLabels;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JPanel buttonsLabel;
    private javax.swing.JButton chartButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JButton ytButton;
    // End of variables declaration//GEN-END:variables
}
