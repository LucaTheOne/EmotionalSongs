
package emotionalsongs.chartbuilder;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.ErrorMessage.*;
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

/**
 *
 * @author big
 */
public class ChartBuilder {
    private Song chartedSong;
    private UserJudgement[] songJudgements;
    private int[] amazementMarks,solemnityMarks,tendernessMarks,nostalgiaMarks,calmnessMarks,powerMarks,joyMarks,tensionMarks,sadnessMarks;
    private String amazementNotes = "",solemnityNotes ="",tendernessNotes = "",nostalgiaNotes = "",calmnessNotes = "",powerNotes = "",joyNotes = "",tensionNotes = "",sadnessNotes = "";
    JFreeChart[] arrayCharts;
    public ChartBuilder(String songTag) {
        
        buildData(songTag);
        arrayCharts = buildAllEmotionsChart();  
        
    }
    
    private void buildData(String songTag){
        chartedSong=new EngineSearcher().searchBranoTag(Repository.getInstance(), songTag);
        songJudgements = DataBaseJudgements.getInstance().searchJudgements(songTag);
        if(songJudgements == null){
            new ErrorPopUp(
                    "Non sono disponibili informazioni per questa canzone: \n" + 
                    "Titolo: " + chartedSong.getTitle() + "\n" +
                    "Autore: " + chartedSong.getAuthor() + "\n"+
                    "Anno: " + chartedSong.getYear() + "."
            );
            return;
        }
        
        initializeArrays(songJudgements.length);
        
        for(int i = 0; i< songJudgements.length;i++){
            amazementMarks[i] = songJudgements[i].getAmazementMark();
            amazementNotes += songJudgements[i].getAmazementNotes() + "; ";
            
            solemnityMarks[i] = songJudgements[i].getSolemnityMark();
            solemnityNotes += songJudgements[i].getSolemnityNotes() + "; ";
            
            tendernessMarks[i] = songJudgements[i].getTendernessMark();
            tendernessNotes += songJudgements[i].getTendernessNotes() + "; ";
            
            nostalgiaMarks[i] = songJudgements[i].getNostalgiaMark();
            nostalgiaNotes += songJudgements[i].getNostalgiaNotes() + "; ";
            
            calmnessMarks[i] = songJudgements[i].getCalmnessMark();
            calmnessNotes += songJudgements[i].getCalmnessNotes()+ "; ";
            
            powerMarks[i] = songJudgements[i].getPowerMark();
            powerNotes+=songJudgements[i].getPowerNotes()+ "; ";
            
            joyMarks[i] = songJudgements[i].getJoyMark();
            joyNotes+=songJudgements[i].getJoyNotes()+ "; ";
            
            tensionMarks[i] = songJudgements[i].getTensionMark();
            tensionNotes+=songJudgements[i].getTensionNotes()+ "; ";
            
            sadnessMarks[i] = songJudgements[i].getSadnessMark();
            sadnessNotes+=songJudgements[i].getSadnessNotes()+ "; ";
            
        }
        
    }
    
    private void initializeArrays(int numberOfJudgements){
        amazementMarks = new int[numberOfJudgements];
        solemnityMarks = new int[numberOfJudgements];
        tendernessMarks = new int[numberOfJudgements];
        nostalgiaMarks = new int[numberOfJudgements];
        calmnessMarks = new int[numberOfJudgements];
        powerMarks = new int[numberOfJudgements];
        joyMarks = new int[numberOfJudgements];
        tensionMarks = new int[numberOfJudgements];
        sadnessMarks = new int[numberOfJudgements];
    }
    
    private int[] marksCounter(int[] mark){
        int[] arrayCount = new int[5];
        for(int i = 0; i< 5;i++){
            arrayCount[i] = 0;
        }
        for(int i = 0; i<mark.length;i++){
            switch (mark[i]) {
                case 1:
                    arrayCount[0]++;
                    break;
                case 2:
                    arrayCount[1]++;
                    break;
                case 3:
                    arrayCount[2]++;
                    break;
                case 4:
                    arrayCount[3]++;
                    break;
                case 5:
                    arrayCount[4]++;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return arrayCount;
    }
    
    private JFreeChart buildBarChart(String typeOfEmotion,int[] emotionMarkCounter){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(emotionMarkCounter[0], "1", "");
        dataSet.setValue(emotionMarkCounter[1], "2", "");
        dataSet.setValue(emotionMarkCounter[2], "3", "");
        dataSet.setValue(emotionMarkCounter[3], "4", "");
        dataSet.setValue(emotionMarkCounter[4], "5", "");
        
        JFreeChart barChart = ChartFactory.createBarChart(typeOfEmotion, "Quanto un utente ha percepito l' emozione", "Numero di utenti", dataSet, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        return barChart;
    }
    
    private JFreeChart[] buildAllEmotionsChart(){
        JFreeChart[] array = new JFreeChart[9];
        array[0] = buildBarChart("Amazement", marksCounter(amazementMarks));
        array[1] = buildBarChart("Solemnity", marksCounter(solemnityMarks));
        array[2] = buildBarChart("Tenderness", marksCounter(tendernessMarks));
        array[3] = buildBarChart("Nostalgia", marksCounter(nostalgiaMarks));
        array[4] = buildBarChart("Calmness", marksCounter(calmnessMarks));
        array[5] = buildBarChart("Power", marksCounter(powerMarks));
        array[6] = buildBarChart("Joy", marksCounter(joyMarks));
        array[7] = buildBarChart("Tension", marksCounter(tensionMarks));
        array[8] = buildBarChart("Sadness", marksCounter(sadnessMarks));
        return array;
        
    }
    // debugger code
    public static void main(String[] args) {
        ChartBuilder builder = new ChartBuilder("TRXWWGC12903CDDEA1");
        System.out.println(builder.songJudgements.length);
        System.out.println(builder.amazementNotes);
        for(int i = 0;i<builder.amazementMarks.length;i++) System.out.println(builder.amazementMarks[i]);
        JFreeChart chart = builder.arrayCharts[0];
        
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(new ChartPanel(chart));
        frame.setVisible(true);
        
    }
}
