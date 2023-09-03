/*
 * Luca Bolelli - 749137 - VA
 * Natanail Danailov Danailov - 739887 - VA
 * Riccardo Rosarin - 749914 - VA
 * Eleonora Macchi - 748736 - VA
 */


package emotionalsongs.clientES.gui.data_visualizer;

import emotionalsongs.*;
import emotionalsongs.clientES.client_internal_services.*;
import emotionalsongs.clientES.gui.allerter.*;
import emotionalsongs.clientES.wrappers.*;
import java.io.*;
import javax.swing.*;
import org.jfree.chart.*;

/**
 * Classe le cui istanze mostrano, visualmente, un report relativo ai giudizi emozionali della canzone rappresentata dal tag passato
 * come argomento al costruttore, tramite grafici ed un report testuale.
 * Offre anche la possibilità di esportare tale report.
 */
public class DataVisualizationForm extends javax.swing.JFrame {
    
    private SongsDataBuilder songDataBuilder;
    
    /**
     * Crea e restituisce il form per la visualizazzione del brano rappresentato dal tag passato
     * come argomento.
     * @param songId tag della canzone di cui mostrarne i giudizi emozionali in forma aggregata.
     * 
     */
    public DataVisualizationForm(String songId) {
        songDataBuilder = new SongsDataBuilder(songId);
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        LabelAndTextPanel = new javax.swing.JPanel();
        TextAreaScrollablePanel = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        EmotionsGraphPanel = new javax.swing.JPanel();
        subPanel1 = new javax.swing.JPanel();
        ButtonsPanel = new javax.swing.JPanel();
        ExportButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        chartPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 660));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 3200));
        mainPanel.setLayout(new java.awt.BorderLayout());

        LabelAndTextPanel.setBackground(new java.awt.Color(255, 255, 255));
        LabelAndTextPanel.setPreferredSize(new java.awt.Dimension(100, 400));
        LabelAndTextPanel.setLayout(new java.awt.BorderLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(1
        );
        jTextArea1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setBorder(null);
        jTextArea1.setText(songDataBuilder.getSongDataReport()+"\nn.b voti da 1 a 5, dove 1 indica per nulla percepita e 5 indica pienamente percepita."+"\n\n"+songDataBuilder.getSongNotesReport());
        TextAreaScrollablePanel.setViewportView(jTextArea1);

        LabelAndTextPanel.add(TextAreaScrollablePanel, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(EmotionalSongs.dialoghi.songDataView());
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 80));
        LabelAndTextPanel.add(jLabel1, java.awt.BorderLayout.NORTH);

        mainPanel.add(LabelAndTextPanel, java.awt.BorderLayout.NORTH);

        EmotionsGraphPanel.setPreferredSize(new java.awt.Dimension(1000, 2700));
        EmotionsGraphPanel.setLayout(new java.awt.GridLayout(3, 3));
        JFreeChart[] charts = songDataBuilder.getArrayCharts();
        for(int i = 0; i<9;i++){
            EmotionsGraphPanel.add(new ChartPanel(charts[i]));
        }
        mainPanel.add(EmotionsGraphPanel, java.awt.BorderLayout.CENTER);

        subPanel1.setPreferredSize(new java.awt.Dimension(100, 1500));
        subPanel1.setLayout(new java.awt.BorderLayout());

        ButtonsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ButtonsPanel.setPreferredSize(new java.awt.Dimension(100, 60));
        ButtonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        ExportButton.setBackground(new java.awt.Color(0, 204, 102));
        ExportButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        ExportButton.setForeground(new java.awt.Color(255, 255, 255));
        ExportButton.setText(EmotionalSongs.dialoghi.exportData());
        ExportButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExportButton.setOpaque(true);
        ExportButton.setPreferredSize(new java.awt.Dimension(400, 50));
        ExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtonActionPerformed(evt);
            }
        });
        ButtonsPanel.add(ExportButton);

        closeButton.setBackground(new java.awt.Color(255, 0, 51));
        closeButton.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText(EmotionalSongs.dialoghi.close());
        closeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        closeButton.setOpaque(true);
        closeButton.setPreferredSize(new java.awt.Dimension(100, 30));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        ButtonsPanel.add(closeButton);

        subPanel1.add(ButtonsPanel, java.awt.BorderLayout.SOUTH);

        chartPanel2.setLayout(new java.awt.GridLayout(3, 1));
        chartPanel2.add(new ChartPanel(songDataBuilder.getMediumsChart()));
        chartPanel2.add(new ChartPanel(songDataBuilder.getMediansChart()));
        chartPanel2.add(new ChartPanel(songDataBuilder.getTrendsChart()));
        subPanel1.add(chartPanel2, java.awt.BorderLayout.CENTER);

        mainPanel.add(subPanel1, java.awt.BorderLayout.SOUTH);

        mainScrollPane.setViewportView(mainPanel);

        getContentPane().add(mainScrollPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        JFrame parentComponent = new JFrame();
        parentComponent.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // Some init code, if you need one, like setting title
        int returnValue = fileChooser.showOpenDialog(parentComponent);
        if ( returnValue == JFileChooser.APPROVE_OPTION) {
            String whereToSaveOsDependent = 
                    fileChooser.getSelectedFile().getAbsolutePath()+
                    System.getProperty("file.separator")+
                    (songDataBuilder.buildDataFolderName());
            boolean created = new File(whereToSaveOsDependent).mkdir();
            if(!created){
                new PopUpAllert(EmotionalSongs.dialoghi.ImpossibleToGenerateReport()).setVisible(true);
                return;
            } else {
                File textFiles = new File(whereToSaveOsDependent + System.getProperty("file.separator") + "Report.txt");
                try {
                    textFiles.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(textFiles));
                    writer.write(songDataBuilder.getSongDataReport());
                    writer.write(songDataBuilder.getSongNotesReport());
                    writer.close();
                    //saving single emotions chart
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Amazement_chart"+".png"),
                        songDataBuilder.getChart(Emotions.AMAZEMENT_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Solemnity_chart"+".png"),
                        songDataBuilder.getChart(Emotions.SOLEMNITY_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Tenderness_chart"+".png"),
                        songDataBuilder.getChart(Emotions.TENDERNESS_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Nostalgia_chart"+".png"),
                        songDataBuilder.getChart(Emotions.NOSTALGIA_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Calmness_chart"+".png"),
                        songDataBuilder.getChart(Emotions.CALMNESS_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Power_chart"+".png"),
                        songDataBuilder.getChart(Emotions.POWER_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Joy_chart"+".png"),
                        songDataBuilder.getChart(Emotions.JOY_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Tension_chart"+".png"),
                        songDataBuilder.getChart(Emotions.TENSION_INDEX),
                        1000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Sadness_chart"+".png"),
                        songDataBuilder.getChart(Emotions.SADNESS_INDEX),
                        1000, 1000);
                
                    //saving aggregated data charts
                
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Mediums_chart"+".png"),
                        songDataBuilder.getMediumsChart(),
                        2000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Medians_chart"+".png"),
                        songDataBuilder.getMediansChart(),
                        2000, 1000);
                    ChartUtilities.saveChartAsPNG(new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Trends_chart"+".png"),
                        songDataBuilder.getTrendsChart(),
                        2000, 1000);
                    new PopUpAllert(EmotionalSongs.dialoghi.OpSucessTerminated()).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }    
        }   
    }//GEN-LAST:event_ExportButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JPanel EmotionsGraphPanel;
    private javax.swing.JButton ExportButton;
    private javax.swing.JPanel LabelAndTextPanel;
    private javax.swing.JScrollPane TextAreaScrollablePanel;
    private javax.swing.JPanel chartPanel2;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JPanel subPanel1;
    // End of variables declaration//GEN-END:variables
    
    /*
    public static void main(String[] args) {
        String whereToSaveOsDependent = null;
        JFrame parentComponent = new JFrame();
        parentComponent.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // Some init code, if you need one, like setting title
        int returnValue = fileChooser.showOpenDialog(parentComponent);
        if ( returnValue == JFileChooser.APPROVE_OPTION) {
            whereToSaveOsDependent = 
                    fileChooser.getSelectedFile().getAbsolutePath()+
                    System.getProperty("file.separator")
                   ; 
        }
        new File(whereToSaveOsDependent+System.getProperty("file.separator")+"Prova").mkdir();
        File textFiles = new File(whereToSaveOsDependent + System.getProperty("file.separator") +"Prova" + System.getProperty("file.separator") + "Report.txt");
        try {
            textFiles.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(whereToSaveOsDependent);
    }*/
}
