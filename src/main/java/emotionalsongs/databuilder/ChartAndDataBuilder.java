//Luca Bolelli - 749137 - VA
//Natanail Danailov Danailov - 739887 - VA
//Alexandru Boitor - 749004 - VA

package emotionalsongs.databuilder;

import emotionalsongs.BasicsStructure.*;
import emotionalsongs.DataBases.*;
import emotionalsongs.Engines.*;
import emotionalsongs.GUI.ErrorMessage.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

/**
 *
 * @author big
 */
public class ChartAndDataBuilder {
    
    private Song analizingSong;
    private UserJudgement[] songUsersJudgements;
    private int[] amazementMarks,solemnityMarks,tendernessMarks,nostalgiaMarks,calmnessMarks,powerMarks,joyMarks,tensionMarks,sadnessMarks;
    private String amazementNotes = "",solemnityNotes ="",tendernessNotes = "",nostalgiaNotes = "",calmnessNotes = "",powerNotes = "",joyNotes = "",tensionNotes = "",sadnessNotes = "";
    JFreeChart[] arrayChartsEmotions;
    
    public ChartAndDataBuilder(String songTag) {
        buildData(songTag);
        arrayChartsEmotions = buildAllEmotionsChart();     
    }
    
    // chart getter methods
    public JFreeChart[] getArrayCharts(){
        return arrayChartsEmotions;
    }
    
    public JFreeChart getChart(int emotion){
        return arrayChartsEmotions[emotion];
    }
    
    public JFreeChart getMediumsChart(){
        return buildBarMediumsChart();
    }
    
    public JFreeChart getTrendsChart(){
        return buildBarTrendsChart();
    }
    
    public JFreeChart getMediansChart(){
        return buildBarMediansChart();
    }
    
    //String data getters
    public String[] getArrayNotes(){
        String[] arrayNotes = new String[9];
        arrayNotes[0] = amazementNotes;
        arrayNotes[1] = solemnityNotes;
        arrayNotes[2] = tendernessNotes;
        arrayNotes[3] = nostalgiaNotes;
        arrayNotes[4] = calmnessNotes;
        arrayNotes[5] = powerNotes;
        arrayNotes[6] = joyNotes;
        arrayNotes[7] = tensionNotes;
        arrayNotes[8] = sadnessNotes;
        return arrayNotes;
    }
    
    public String getEmotionNotes(int emotion){
        return getArrayNotes()[emotion];
    }
    
    public String getSongDataReport(){
        String report = "REPORT DATI SUI GIUDIZI DELLE EMOZIONI PERCEPITE" + 
                " DAGLI UTENTI NELL' ASCOLTO DELLA CANZONE:\n\n"+
                "   Titolo: " + analizingSong.getTitle() + ",\n"+
                "   Autore: " + analizingSong.getAuthor() + ",\n"+
                "   Anno: "+ analizingSong.getYear() + "\n\n"+
                
                "Numero di utenti che hanno espresso il loro parare: " + getNumberOfJudgements() + ".\n\n"+   
                
                "DATI RELATIVI AI GIUDIZI DEGLI UTENTI RIGUARDO ALLA PERCEZIONE DELLE RISPETTIVE EMOZIONI: " +"\n\n"+
                
                "Meraviglia:\n" +
                "   media aritmetica: " + calculateAritmethicalMedium(amazementMarks) + "\n" + 
                "   moda: " + findTrend(amazementMarks) + "\n"+
                "   mediana: " + findMedian(amazementMarks) + "\n\n"+
                
                "Solennità:\n" +
                "   media aritmetica: " + calculateAritmethicalMedium(solemnityMarks) + "\n" + 
                "   moda: " + findTrend(solemnityMarks) + "\n"+
                "   mediana: " + findMedian(solemnityMarks) + "\n\n"+
                
                "Tenerezza:\n" +
                "   media: " + calculateAritmethicalMedium(tendernessMarks) + "\n" + 
                "   moda: " + findTrend(tendernessMarks) + "\n"+
                "   mediana: " + findMedian(tendernessMarks) + "\n\n"+
                
                "Nostalgia:\n" +
                "   media: " + calculateAritmethicalMedium(nostalgiaMarks) + "\n" + 
                "   moda: " + findTrend(nostalgiaMarks) + "\n"+
                "   mediana " + findMedian(nostalgiaMarks) + "\n\n"+
                
                "Calma:\n" +
                "   media: " + calculateAritmethicalMedium(calmnessMarks) + "\n" + 
                "   moda: " + findTrend(calmnessMarks) + "\n"+
                "   mediana: " + findMedian(calmnessMarks) + "\n\n"+
                
                "Potere:\n" +
                "   media: " + calculateAritmethicalMedium(powerMarks) + "\n" + 
                "   moda: " + findTrend(powerMarks) + "\n"+
                "   mediana: " + findMedian(powerMarks) + "\n\n"+
                
                "Gioia:\n" +
                "   media: " + calculateAritmethicalMedium(joyMarks) + "\n" + 
                "   moda: " + findTrend(joyMarks) + "\n"+
                "   mediana: " + findMedian(joyMarks) + "\n\n"+
                
                "Tensione:\n" +
                "   media: " + calculateAritmethicalMedium(tensionMarks) + "\n" + 
                "   moda: " + findTrend(tensionMarks) + "\n"+
                "   mediana: " + findMedian(tensionMarks) + "\n\n"+
                
                "Tristezza:\n" +
                "   media: " + calculateAritmethicalMedium(sadnessMarks) + "\n" + 
                "   moda: " + findTrend(sadnessMarks) + "\n" + 
                "   mediana: " + findMedian(sadnessMarks) + ".\n";
        return report;
    }
    
    public String getSongNotesReport(){
        String report = "COMMENTI ESPRESSI DAGLI UTENTI RIGUARDO OGNI EMOZIONE:\n\n"+
                "Meraviglia:\n"+
                getEmotionNotes(Emotions.AMAZEMENT_INDEX)+"\n\n"+
                
                "Solennità:\n"+
                getEmotionNotes(Emotions.SOLEMNITY_INDEX)+"\n\n"+
                
                "Tenerezza:\n"+
                getEmotionNotes(Emotions.TENDERNESS_INDEX)+"\n\n"+
                
                "Nostalgia:\n"+
                getEmotionNotes(Emotions.NOSTALGIA_INDEX)+"\n\n"+
                
                "Calma:\n"+
                getEmotionNotes(Emotions.CALMNESS_INDEX)+"\n\n"+
                
                "Potere:\n"+
                getEmotionNotes(Emotions.POWER_INDEX)+"\n\n"+
                
                "Gioia:\n"+
                getEmotionNotes(Emotions.JOY_INDEX)+"\n\n"+
                
                "Tensione:\n"+
                getEmotionNotes(Emotions.TENSION_INDEX)+"\n\n"+
                
                "Tristezza:\n"+
                getEmotionNotes(Emotions.SADNESS_INDEX)+"\n";
        
        return report;
    }
    
    public String buildDataFolderName(){
        return "Report_"+analizingSong.getTitle()+"_"+analizingSong.getAuthor()+"_"+analizingSong.getYear()+"_"+analizingSong.getTag();
    }
    
    // private internal methods
    private void buildData(String songTag){
        analizingSong=new EngineSearcher().searchByBranoTag(Repository.getInstance(), songTag);
        songUsersJudgements = DataBaseJudgements.getInstance().searchJudgements(songTag);
        if(songUsersJudgements == null){
            new PopUpAllert(
                    "Non sono disponibili informazioni per questa canzone: " + 
                    "Titolo: " + analizingSong.getTitle() + ", " +
                    "Autore: " + analizingSong.getAuthor() + ", "+
                    "Anno: " + analizingSong.getYear() + "."
            ).setVisible(true);
            return;
        }
        
        initializeArrays(songUsersJudgements.length);
        
        for(int i = 0; i< songUsersJudgements.length;i++){
            amazementMarks[i] = songUsersJudgements[i].getAmazementMark();
            amazementNotes += songUsersJudgements[i].getAmazementNotes() + "; ";
            
            solemnityMarks[i] = songUsersJudgements[i].getSolemnityMark();
            solemnityNotes += songUsersJudgements[i].getSolemnityNotes() + "; ";
            
            tendernessMarks[i] = songUsersJudgements[i].getTendernessMark();
            tendernessNotes += songUsersJudgements[i].getTendernessNotes() + "; ";
            
            nostalgiaMarks[i] = songUsersJudgements[i].getNostalgiaMark();
            nostalgiaNotes += songUsersJudgements[i].getNostalgiaNotes() + "; ";
            
            calmnessMarks[i] = songUsersJudgements[i].getCalmnessMark();
            calmnessNotes += songUsersJudgements[i].getCalmnessNotes()+ "; ";
            
            powerMarks[i] = songUsersJudgements[i].getPowerMark();
            powerNotes+=songUsersJudgements[i].getPowerNotes()+ "; ";
            
            joyMarks[i] = songUsersJudgements[i].getJoyMark();
            joyNotes+=songUsersJudgements[i].getJoyNotes()+ "; ";
            
            tensionMarks[i] = songUsersJudgements[i].getTensionMark();
            tensionNotes+=songUsersJudgements[i].getTensionNotes()+ "; ";
            
            sadnessMarks[i] = songUsersJudgements[i].getSadnessMark();
            sadnessNotes+=songUsersJudgements[i].getSadnessNotes()+ "; ";
            
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
    
    private JFreeChart buildBarMediumsChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(calculateAritmethicalMedium(amazementMarks), "amazement", "");
        dataset.setValue(calculateAritmethicalMedium(solemnityMarks), "solemnity", "");
        dataset.setValue(calculateAritmethicalMedium(tendernessMarks), "tenderness", "");
        dataset.setValue(calculateAritmethicalMedium(nostalgiaMarks), "nostalgia", "");
        dataset.setValue(calculateAritmethicalMedium(calmnessMarks), "calmness", "");
        dataset.setValue(calculateAritmethicalMedium(powerMarks), "power", "");
        dataset.setValue(calculateAritmethicalMedium(joyMarks), "joy", "");
        dataset.setValue(calculateAritmethicalMedium(tensionMarks), "tension", "");
        dataset.setValue(calculateAritmethicalMedium(sadnessMarks), "sadness", "");
        
        JFreeChart barChart = ChartFactory.createBarChart("Grafico delle medie dei voti delle emozioni", "emozioni", "medie dei voti", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        NumberAxis yRange = new NumberAxis();
        yRange.setRange(0, 5);
        yRange.setTickUnit(new NumberTickUnit(0.2));
        plot.setRangeAxis(yRange);
        return barChart;
    }
    
    private JFreeChart buildBarTrendsChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(findTrend(amazementMarks), "amazement", "");
        dataset.setValue(findTrend(solemnityMarks), "solemnity", "");
        dataset.setValue(findTrend(tendernessMarks), "tenderness", "");
        dataset.setValue(findTrend(nostalgiaMarks), "nostalgia", "");
        dataset.setValue(findTrend(calmnessMarks), "calmness", "");
        dataset.setValue(findTrend(powerMarks), "power", "");
        dataset.setValue(findTrend(joyMarks), "joy", "");
        dataset.setValue(findTrend(tensionMarks), "tension", "");
        dataset.setValue(findTrend(sadnessMarks), "sadness", "");
        
        JFreeChart barChart = ChartFactory.createBarChart("Grafico dei trends dei voti delle emozioni", "emozioni", "trends dei voti", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        NumberAxis yRange = new NumberAxis();
        yRange.setRange(0, 5);
        yRange.setTickUnit(new NumberTickUnit(0.2));
        plot.setRangeAxis(yRange);
        return barChart;
    }
    
    private JFreeChart buildBarMediansChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(findMedian(amazementMarks), "amazement", "");
        dataset.setValue(findMedian(solemnityMarks), "solemnity", "");
        dataset.setValue(findMedian(tendernessMarks), "tenderness", "");
        dataset.setValue(findMedian(nostalgiaMarks), "nostalgia", "");
        dataset.setValue(findMedian(calmnessMarks), "calmness", "");
        dataset.setValue(findMedian(powerMarks), "power", "");
        dataset.setValue(findMedian(joyMarks), "joy", "");
        dataset.setValue(findMedian(tensionMarks), "tension", "");
        dataset.setValue(findMedian(sadnessMarks), "sadness", "");
        
        JFreeChart barChart = ChartFactory.createBarChart("Grafico delle mediane dei voti delle emozioni", "emozioni", "mediane dei voti", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        NumberAxis yRange = new NumberAxis();
        yRange.setRange(0, 5);
        yRange.setTickUnit(new NumberTickUnit(0.2));
        plot.setRangeAxis(yRange);
        return barChart;
    }
    
    private JFreeChart buildBarEmotionChart(String typeOfEmotion,int[] emotionMarkCounter){
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
        array[0] = buildBarEmotionChart("Amazement", marksCounter(amazementMarks));
        array[1] = buildBarEmotionChart("Solemnity", marksCounter(solemnityMarks));
        array[2] = buildBarEmotionChart("Tenderness", marksCounter(tendernessMarks));
        array[3] = buildBarEmotionChart("Nostalgia", marksCounter(nostalgiaMarks));
        array[4] = buildBarEmotionChart("Calmness", marksCounter(calmnessMarks));
        array[5] = buildBarEmotionChart("Power", marksCounter(powerMarks));
        array[6] = buildBarEmotionChart("Joy", marksCounter(joyMarks));
        array[7] = buildBarEmotionChart("Tension", marksCounter(tensionMarks));
        array[8] = buildBarEmotionChart("Sadness", marksCounter(sadnessMarks));
        return array;
        
    }
    
    
    private double calculateAritmethicalMedium(int[] arrayOfInt){
        int sum = 0;
        for(int i = 0; i< arrayOfInt.length;i++) sum += arrayOfInt[i];
        double medium = (double)sum / (double) arrayOfInt.length;
        return medium;
    }
    
    private double findMedian(int[] arrayOfInt){
        double median = 0;
        new EngineSorter().sortIntArray(arrayOfInt);
        int length = arrayOfInt.length;
        if(length%2!=0) median = (double)arrayOfInt[length/2];
        else {
            int sumeOfMiddles = arrayOfInt[length/2-1]+arrayOfInt[length/2];
            median = ((double)sumeOfMiddles)/2;
        }
        return median;
    }
    
    private int findTrend(int[] arrayOfInt){
        int maxcount = 0;
        int n = arrayOfInt.length;
        int element_having_max_freq = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arrayOfInt[i] == arrayOfInt[j]) {
                count++;
            }
        }
        if (count > maxcount) {
            maxcount = count;
            element_having_max_freq = arrayOfInt[i];
        }
    }
 
    return element_having_max_freq;
    }
    
    private int getNumberOfJudgements(){
        return songUsersJudgements.length;
    }
    
    // debugger code
    /*
    public static void main(String[] args) {
        ChartAndDataBuilder builder = new ChartAndDataBuilder("TRXWWGC12903CDDEA1");
        //System.out.println(builder.songUsersJudgements.length);
        //System.out.println(builder.amazementNotes);
        //JFreeChart chart = builder.arrayChartsEmotions[0];
        System.out.println(builder.getSongDataReport());
        System.out.println(builder.getSongNotesReport());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(new ChartPanel(builder.getMediansChart()));
        frame.setVisible(true);
        
    }*/
}
