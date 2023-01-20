//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA


package emotionalsongs.gui.data_visualizer;

import emotionalsongs.basic_structures.*;
import emotionalsongs.engines.*;
import emotionalsongs.gui.allerter.*;
import java.io.*;
import javax.swing.*;
import org.jfree.chart.*;

/**
 * Classe le cui istanze mostrano, visualmente, un report relativo ai giudizi emozionali della canzone rappresentata dal tag passato
 * come argomento al costruttore, tramite grafici ed un report testuale.
 * Offre anche la possibilità di esportare tale report.
 */
public class DataVisualizationForm extends javax.swing.JFrame {
    
    private EngineBuilderChartAndData dataBuilder;
    /**
     * Crea il form per la visualizazzione del brano rappresentato dal tag passato
     * come argomento.
     * @param songToRepresentTag tag della canzone di cui mostrarne i giudizi emozionali in forma aggregata.
     * @return Form di visulizzazione dei giudizi emozionali in forma aggregata.
     */
    
    public DataVisualizationForm(String songToRepresentTag) {
        dataBuilder = new EngineBuilderChartAndData(songToRepresentTag);
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
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
        chartPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 660));

        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 3200));
        mainPanel.setLayout(new java.awt.BorderLayout());

        LabelAndTextPanel.setPreferredSize(new java.awt.Dimension(100, 400));
        LabelAndTextPanel.setLayout(new java.awt.BorderLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(1
        );
        jTextArea1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setBorder(null);
        jTextArea1.setText(dataBuilder.getSongDataReport()+"\nn.b voti da 1 a 5, dove 1 indica per nulla percepita e 5 indica pienamente percepita."+"\n\n"+dataBuilder.getSongNotesReport());
        TextAreaScrollablePanel.setViewportView(jTextArea1);

        LabelAndTextPanel.add(TextAreaScrollablePanel, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VISUALIZZAZIONE DATI CANZONE");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 80));
        LabelAndTextPanel.add(jLabel1, java.awt.BorderLayout.NORTH);

        mainPanel.add(LabelAndTextPanel, java.awt.BorderLayout.NORTH);

        EmotionsGraphPanel.setPreferredSize(new java.awt.Dimension(1000, 2700));
        EmotionsGraphPanel.setLayout(new java.awt.GridLayout(3, 3));
        JFreeChart[] charts = dataBuilder.getArrayCharts();
        for(int i = 0; i<9;i++){
            EmotionsGraphPanel.add(new ChartPanel(charts[i]));
        }
        mainPanel.add(EmotionsGraphPanel, java.awt.BorderLayout.CENTER);

        subPanel1.setPreferredSize(new java.awt.Dimension(100, 1500));
        subPanel1.setLayout(new java.awt.BorderLayout());

        ButtonsPanel.setPreferredSize(new java.awt.Dimension(100, 60));

        ExportButton.setText("Esporta dati canzone");
        ExportButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ExportButton.setPreferredSize(new java.awt.Dimension(400, 50));
        ExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtonActionPerformed(evt);
            }
        });
        ButtonsPanel.add(ExportButton);

        subPanel1.add(ButtonsPanel, java.awt.BorderLayout.SOUTH);

        chartPanel2.setLayout(new java.awt.GridLayout(3, 1));
        chartPanel2.add(new ChartPanel(dataBuilder.getMediumsChart()));
        chartPanel2.add(new ChartPanel(dataBuilder.getMediansChart()));
        chartPanel2.add(new ChartPanel(dataBuilder.getTrendsChart()));
        subPanel1.add(chartPanel2, java.awt.BorderLayout.CENTER);

        mainPanel.add(subPanel1, java.awt.BorderLayout.SOUTH);

        mainScrollPane.setViewportView(mainPanel);

        getContentPane().add(mainScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        JFrame parentComponent = new JFrame();
        parentComponent.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // Some init code, if you need one, like setting title
        int returnValue = fileChooser.showOpenDialog(parentComponent);
        if ( returnValue == JFileChooser.APPROVE_OPTION) {
            String whereToSave = fileChooser.getSelectedFile().getAbsolutePath()+
                    System.getProperty("file.separator")+
                    (dataBuilder.buildDataFolderName().replaceAll(" ", "-").replaceAll(System.getProperty("file.separator"), "_"));
            //System.out.println(whereToSave);
            boolean created = new File(whereToSave).mkdir();
            if(!created){
                new PopUpAllert("Errore: impossibile creare la cartella con i report!").setVisible(true);
                return;
            }
            File textFiles = new File(whereToSave + System.getProperty("file.separator") + "Report.txt");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(textFiles));
                writer.write(dataBuilder.getSongDataReport());
                writer.write(dataBuilder.getSongNotesReport());
                writer.close();
                //saving single emotions chart
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Amazement_chart"+".png"),
                        dataBuilder.getChart(Emotions.AMAZEMENT_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Solemnity_chart"+".png"),
                        dataBuilder.getChart(Emotions.SOLEMNITY_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Tenderness_chart"+".png"),
                        dataBuilder.getChart(Emotions.TENDERNESS_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Nostalgia_chart"+".png"),
                        dataBuilder.getChart(Emotions.NOSTALGIA_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Calmness_chart"+".png"),
                        dataBuilder.getChart(Emotions.CALMNESS_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Power_chart"+".png"),
                        dataBuilder.getChart(Emotions.POWER_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Joy_chart"+".png"),
                        dataBuilder.getChart(Emotions.JOY_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Tension_chart"+".png"),
                        dataBuilder.getChart(Emotions.TENSION_INDEX),
                        1000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Sadness_chart"+".png"),
                        dataBuilder.getChart(Emotions.SADNESS_INDEX),
                        1000, 1000);
                
                //saving aggregated data charts
                
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Mediums_chart"+".png"),
                        dataBuilder.getMediumsChart(),
                        2000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Medians_chart"+".png"),
                        dataBuilder.getMediansChart(),
                        2000, 1000);
                ChartUtilities.saveChartAsPNG(new File(whereToSave+System.getProperty("file.separator")+"Trends_chart"+".png"),
                        dataBuilder.getTrendsChart(),
                        2000, 1000);
                
                new PopUpAllert("Operazione terminata con successo").setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
        
    }//GEN-LAST:event_ExportButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JPanel EmotionsGraphPanel;
    private javax.swing.JButton ExportButton;
    private javax.swing.JPanel LabelAndTextPanel;
    private javax.swing.JScrollPane TextAreaScrollablePanel;
    private javax.swing.JPanel chartPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JPanel subPanel1;
    // End of variables declaration//GEN-END:variables
}
